package com.employee.scheduler.nurserostering.domain.custom;

import com.employee.scheduler.common.domain.AbstractPersistable;
import com.employee.scheduler.nurserostering.domain.Skill;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("TaskSkillRequirement")
public class TaskSkillRequirement extends AbstractPersistable {
	private Task task;
	private Skill skill;
	
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	@Override
    public String toString() {
        return task + "-" + skill;
    }
}
