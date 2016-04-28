package me.rockerjman222.Lttp.assets.management;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Scheduler will deploy animations at the correct time given the update counter
 * Everything will be updated sequentially
 * Assign UUIDs per state and access that way
 */
public class AnimationScheduler {

	private static AnimationScheduler instance;

	private LinkedHashMap<UUID, ResourceSchedule> scheduleList = new LinkedHashMap<>();

	public AnimationScheduler() {
		instance = this;
	}

	public void updateResources(int programTime){

		for(Map.Entry<UUID, ResourceSchedule> entry : new LinkedHashMap<>(this.scheduleList).entrySet()){

			ResourceSchedule resource = entry.getValue();

			if(resource.isFinished()){
				this.scheduleList.remove(entry.getKey(), entry.getValue());
				continue;
			}

			resource.updateIntended(programTime);
			resource.detectActivated(programTime);

		}

	}

	public void drawResources(Graphics2D graphics){
		for(Map.Entry<UUID, ResourceSchedule> entry : new LinkedHashMap<>(this.scheduleList).entrySet()){

			ResourceSchedule resource = entry.getValue();

			if(resource.isFinished()){
				this.scheduleList.remove(entry.getKey(), entry.getValue());
				continue;
			}

			resource.drawIntended(graphics);

		}
	}

	public UUID scheduleResource(ResourceSchedule schedule){
		this.scheduleList.put(schedule.getIdentifier(), schedule);
		return schedule.getIdentifier();
	}

	public void removeResource(ResourceSchedule schedule) {
		this.scheduleList.remove(schedule.getIdentifier(), schedule);
	}

	public LinkedHashMap<UUID, ResourceSchedule> getScheduleList() {
		return scheduleList;
	}

	public boolean hasSchedule(UUID key){
		return this.scheduleList.containsKey(key);
	}

	public ResourceSchedule getResource(UUID uuid){

		return this.scheduleList.get(uuid);
	}

	public static AnimationScheduler getInstance(){
		return instance;
	}

}
