package com.employee.scheduler.nurserostering.domain.custom;

import com.employee.scheduler.common.domain.AbstractPersistable;

public class Task extends AbstractPersistable {
	private String code;
	private String description;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
    public String toString() {
        return code + "-" + description;
    }
}
