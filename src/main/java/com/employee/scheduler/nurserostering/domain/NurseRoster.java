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

package com.employee.scheduler.nurserostering.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.buildin.hardsoft.HardSoftScoreDefinition;
import org.optaplanner.persistence.xstream.impl.score.XStreamScoreConverter;

import com.employee.scheduler.common.domain.AbstractPersistable;
import com.employee.scheduler.nurserostering.domain.contract.Contract;
import com.employee.scheduler.nurserostering.domain.contract.ContractLine;
import com.employee.scheduler.nurserostering.domain.contract.PatternContractLine;
import com.employee.scheduler.nurserostering.domain.custom.ShiftTypeTaskTodo;
import com.employee.scheduler.nurserostering.domain.custom.Task;
import com.employee.scheduler.nurserostering.domain.custom.TaskSkillRequirement;
import com.employee.scheduler.nurserostering.domain.pattern.Pattern;
import com.employee.scheduler.nurserostering.domain.request.DayOffRequest;
import com.employee.scheduler.nurserostering.domain.request.DayOnRequest;
import com.employee.scheduler.nurserostering.domain.request.ShiftOffRequest;
import com.employee.scheduler.nurserostering.domain.request.ShiftOnRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@PlanningSolution
@XStreamAlias("NurseRoster")
public class NurseRoster extends AbstractPersistable implements Solution<HardSoftScore> {

    private String code;

    private NurseRosterParametrization nurseRosterParametrization;
    private List<Skill> skillList;
    private List<ShiftType> shiftTypeList;
    private List<Pattern> patternList;
    private List<Contract> contractList;
    private List<ContractLine> contractLineList;
    private List<PatternContractLine> patternContractLineList;
    private List<Employee> employeeList;
    private List<SkillProficiency> skillProficiencyList;
    private List<ShiftDate> shiftDateList;
    private List<Shift> shiftList;
    private List<DayOffRequest> dayOffRequestList;
    private List<DayOnRequest> dayOnRequestList;
    private List<ShiftOffRequest> shiftOffRequestList;
    private List<ShiftOnRequest> shiftOnRequestList;
    
    // custom for team machine
    private List<Task> taskList;
    private List<TaskSkillRequirement> taskSkillRequirementList;
    private List<ShiftTypeTaskTodo> shiftTypeTaskTodoList;

    private List<ShiftAssignment> shiftAssignmentList;

    @XStreamConverter(value = XStreamScoreConverter.class, types = {HardSoftScoreDefinition.class})
    private HardSoftScore score;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public NurseRosterParametrization getNurseRosterParametrization() {
        return nurseRosterParametrization;
    }

    public void setNurseRosterParametrization(NurseRosterParametrization nurseRosterParametrization) {
        this.nurseRosterParametrization = nurseRosterParametrization;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<ShiftType> getShiftTypeList() {
        return shiftTypeList;
    }

    public void setShiftTypeList(List<ShiftType> shiftTypeList) {
        this.shiftTypeList = shiftTypeList;
    }

    public List<Pattern> getPatternList() {
        return patternList;
    }

    public void setPatternList(List<Pattern> patternList) {
        this.patternList = patternList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<ContractLine> getContractLineList() {
        return contractLineList;
    }

    public void setContractLineList(List<ContractLine> contractLineList) {
        this.contractLineList = contractLineList;
    }

    public List<PatternContractLine> getPatternContractLineList() {
        return patternContractLineList;
    }

    public void setPatternContractLineList(List<PatternContractLine> patternContractLineList) {
        this.patternContractLineList = patternContractLineList;
    }

    @ValueRangeProvider(id = "employeeRange")
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<SkillProficiency> getSkillProficiencyList() {
        return skillProficiencyList;
    }

    public void setSkillProficiencyList(List<SkillProficiency> skillProficiencyList) {
        this.skillProficiencyList = skillProficiencyList;
    }

    public List<ShiftDate> getShiftDateList() {
        return shiftDateList;
    }

    public void setShiftDateList(List<ShiftDate> shiftDateList) {
        this.shiftDateList = shiftDateList;
    }

    public List<Shift> getShiftList() {
        return shiftList;
    }

    public void setShiftList(List<Shift> shiftList) {
        this.shiftList = shiftList;
    }

    public List<DayOffRequest> getDayOffRequestList() {
        return dayOffRequestList;
    }

    public void setDayOffRequestList(List<DayOffRequest> dayOffRequestList) {
        this.dayOffRequestList = dayOffRequestList;
    }

    public List<DayOnRequest> getDayOnRequestList() {
        return dayOnRequestList;
    }

    public void setDayOnRequestList(List<DayOnRequest> dayOnRequestList) {
        this.dayOnRequestList = dayOnRequestList;
    }

    public List<ShiftOffRequest> getShiftOffRequestList() {
        return shiftOffRequestList;
    }

    public void setShiftOffRequestList(List<ShiftOffRequest> shiftOffRequestList) {
        this.shiftOffRequestList = shiftOffRequestList;
    }

    public List<ShiftOnRequest> getShiftOnRequestList() {
        return shiftOnRequestList;
    }

    public void setShiftOnRequestList(List<ShiftOnRequest> shiftOnRequestList) {
        this.shiftOnRequestList = shiftOnRequestList;
    }

    public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public List<TaskSkillRequirement> getTaskSkillRequirementList() {
		return taskSkillRequirementList;
	}

	public void setTaskSkillRequirementList(
			List<TaskSkillRequirement> taskSkillRequirementList) {
		this.taskSkillRequirementList = taskSkillRequirementList;
	}

	public List<ShiftTypeTaskTodo> getShiftTypeTaskTodoList() {
		return shiftTypeTaskTodoList;
	}

	public void setShiftTypeTaskTodoList(
			List<ShiftTypeTaskTodo> shiftTypeTaskTodoList) {
		this.shiftTypeTaskTodoList = shiftTypeTaskTodoList;
	}

	@PlanningEntityCollectionProperty
    public List<ShiftAssignment> getShiftAssignmentList() {
        return shiftAssignmentList;
    }

    public void setShiftAssignmentList(List<ShiftAssignment> shiftAssignmentList) {
        this.shiftAssignmentList = shiftAssignmentList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

    public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.add(nurseRosterParametrization);
        facts.addAll(skillList);
        facts.addAll(shiftTypeList);
        facts.addAll(patternList);
        facts.addAll(contractList);
        facts.addAll(contractLineList);
        facts.addAll(patternContractLineList);
        facts.addAll(employeeList);
        facts.addAll(skillProficiencyList);
        facts.addAll(shiftDateList);
        facts.addAll(shiftList);
        facts.addAll(dayOffRequestList);
        facts.addAll(dayOnRequestList);
        facts.addAll(shiftOffRequestList);
        facts.addAll(shiftOnRequestList);
        facts.addAll(taskList);
        facts.addAll(taskSkillRequirementList);
        facts.addAll(shiftTypeTaskTodoList);
        // Do not add the planning entity's (shiftAssignmentList) because that will be done automatically
        return facts;
    }

}
