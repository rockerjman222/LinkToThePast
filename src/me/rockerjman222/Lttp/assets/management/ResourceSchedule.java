package me.rockerjman222.Lttp.assets.management;

import me.rockerjman222.Lttp.assets.Audio;
import me.rockerjman222.Lttp.assets.animation.Animation;
import me.rockerjman222.Lttp.assets.animation.AnimationPath;

import java.awt.*;
import java.util.UUID;

public class ResourceSchedule {

	private int intendedStart = -1;
	private Audio audioClip = null;
	private Animation animationPlay = null;
	private AnimationPath animationPath = null;
	private ImageSchedule imageSchedule = null;
	private int intendedStop = -1;

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
			if(this.intendedStop <= systemTime && this.intendedStop != -1){
				this.animationPath.getAnimation().stop();
				this.markFinished();
			}

		}

		if(this.imageSchedule != null && (systemTime >= intendedStop && this.intendedStop != -1)){
			this.markFinished();
		}

	}

	public void drawIntended(Graphics2D graphics){

		if(this.started && this.imageSchedule != null){
			this.imageSchedule.drawImage(graphics);
		}

	}

	public UUID getIdentifier(){
		return this.identifier;
	}

	public Animation getAnimation(){
		return this.animationPlay;
	}

	public AnimationPath getAnimationPath(){
		return this.animationPath;
	}

	public int getIntendedStart() {
		return intendedStart;
	}

	void detectActivated(int programTime){

		if(this.intendedStart <= programTime && !this.finished) {
			this.started = true;

			if(this.animationPlay != null){
				this.animationPlay.start();
			}

			if(this.animationPath != null){
				this.animationPath.start();
			}

		}



	}

	private void markFinished(){
		this.started = false;
		this.finished = true;
	}

	boolean isFinished() {
		return this.finished;
	}
}
