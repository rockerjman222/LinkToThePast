package me.rockerjman222.Lttp.assets.management;

import me.rockerjman222.Lttp.assets.Audio;
import me.rockerjman222.Lttp.assets.animation.Animation;
import me.rockerjman222.Lttp.assets.animation.AnimationPath;

import java.awt.*;
import java.util.UUID;

public class ResourceSchedule {

	private Graphics2D graphics2D = null;

	private int intendedStart = -1;
	private Audio audioClip = null;
	private Animation animationPlay = null;
	private AnimationPath animationPath = null;
	private ImageSchedule imageSchedule = null;
	private int intendedStop = -1;

	/**
	 * A Functional Interface that can be changed on the fly through the use of
	 * Lambda expressions, for those problems that require just a TINY bit more code
	 * that we haven't supplemented into the Schedule
	 * <p>
	 * At this point, the code will ALWAYS be run after everything else, we can tweak that in the future though
	 */
	private Runnable updateAdditional = null;
	private Runnable drawerAdditional = null;

	private boolean started = false;
	private boolean finished = false;

	private final UUID identifier;

	public ResourceSchedule(int intendedStart, int intendedStop) {
		this.intendedStart = intendedStart;
		this.intendedStop = intendedStop;
		this.identifier = UUID.randomUUID();
	}

	public ResourceSchedule(int intendedStart, Animation animationPlay, int intendedStop) {
		this(intendedStart, intendedStop);
		this.animationPlay = animationPlay;
	}

	public ResourceSchedule(int intendedStart , Audio audioClip, int intendedStop) {
		this(intendedStart, intendedStop);
		this.audioClip = audioClip;
	}

	public ResourceSchedule(int intendedStart, AnimationPath animationPath, int intendedStop) {
		this(intendedStart, intendedStop);
		this.animationPath = animationPath;

	}

	public ResourceSchedule(int intendedStart, ImageSchedule imageSchedule, int intendedStop) {
		this(intendedStart, intendedStop);
		this.imageSchedule = imageSchedule;
	}

	void updateIntended(int systemTime){

		if(this.audioClip != null && this.started){
			if(!this.audioClip.isRunning()){
				this.audioClip.play();
				this.markFinished();
			}
		}

		if(this.animationPlay != null && this.started){
			this.animationPlay.update();

			if(this.intendedStop == -2 && this.animationPath.getAnimation().hasPlayedOnce()){
				this.animationPath.getAnimation().stop();
				this.markFinished();
			}

		}

		if(this.animationPath != null && this.started){
			this.animationPath.update();

			if(this.intendedStop == -2 && this.animationPath.getAnimation().hasPlayedOnce()){
				this.animationPath.getAnimation().stop();
				this.markFinished();
			}
			if (this.intendedStop <= systemTime && this.intendedStop != -1 && this.intendedStop != -2){
				this.animationPath.getAnimation().stop();
				this.markFinished();
			}

		}

		if(this.imageSchedule != null && (systemTime >= intendedStop && this.intendedStop != -1)){
			this.markFinished();
		}

		//Run whatever Lambda code we've specified for update procedures
		if (this.updateAdditional != null)
			this.updateAdditional.run();

	}

	public void drawIntended(Graphics2D graphics){

		if(this.started && this.imageSchedule != null){
			this.imageSchedule.drawImage(graphics);
		}


	}

	public void drawAdditional(Graphics2D graphics) {
		this.graphics2D = graphics;

		//Draw anything else that we absolutely need at the same time and don't want to schedule
		if (this.drawerAdditional != null)
			this.drawerAdditional.run();

		this.graphics2D = null;
	}

	public void setUpdateAdditional(Runnable updateAdditional) {
		this.updateAdditional = updateAdditional;
	}

	public void setDrawerAdditional(Runnable drawerAdditional) {
		this.drawerAdditional = drawerAdditional;
	}

	UUID getIdentifier(){
		return this.identifier;
	}

	public Animation getAnimation(){
		return this.animationPlay;
	}

	public AnimationPath getAnimationPath(){
		return this.animationPath;
	}

	public void setIntendedStart(int intendedStart) {
		this.intendedStart = intendedStart;
	}

	public void setIntendedStop(int intendedStop) {
		this.intendedStop = intendedStop;
	}

	public int getIntendedStart() {
		return intendedStart;
	}

	public int getIntendedStop() {
		return intendedStop;
	}

	void detectActivated(int programTime) {

		if (this.intendedStart <= programTime && !this.finished && this.intendedStart > -1) {
			this.started = true;

			if(this.animationPlay != null){
				this.animationPlay.start();
			}

			if(this.animationPath != null){
				this.animationPath.start();
			}

		}


	}

	/**
	 * Special Accessor for the graphics, null most of the time
	 */
	public Graphics2D getGraphics() {
		return this.graphics2D;
	}

	private void markFinished(){
		this.started = false;
		this.finished = true;
	}

	boolean isFinished() {
		return this.finished;
	}

	public boolean hasStarted() {
		return this.started && !this.finished;
	}
}
