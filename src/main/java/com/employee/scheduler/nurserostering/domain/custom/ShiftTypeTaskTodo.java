/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.employee.scheduler.nurserostering.domain.custom;

import java.util.List;

import com.employee.scheduler.common.domain.AbstractPersistable;
import com.employee.scheduler.nurserostering.domain.ShiftType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ShiftTypeTaskTodo")
public class ShiftTypeTaskTodo extends AbstractPersistable {
    private ShiftType shiftType;
    private List<Task> taskList;

    public ShiftType getShiftType() {
		return shiftType;
	}
	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	@Override
    public String toString() {
        return shiftType + "-" + taskList;
    }
}
