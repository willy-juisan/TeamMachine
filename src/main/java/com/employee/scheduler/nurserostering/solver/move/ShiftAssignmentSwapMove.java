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

package com.employee.scheduler.nurserostering.solver.move;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.optaplanner.core.impl.heuristic.move.Move;
import org.optaplanner.core.impl.score.director.ScoreDirector;
import com.employee.scheduler.nurserostering.domain.Employee;
import com.employee.scheduler.nurserostering.domain.ShiftAssignment;

public class ShiftAssignmentSwapMove implements Move {

    private ShiftAssignment leftShiftAssignment;
    private ShiftAssignment rightShiftAssignment;

    public ShiftAssignmentSwapMove(ShiftAssignment leftShiftAssignment, ShiftAssignment rightShiftAssignment) {
        this.leftShiftAssignment = leftShiftAssignment;
        this.rightShiftAssignment = rightShiftAssignment;
    }

    public boolean isMoveDoable(ScoreDirector scoreDirector) {
        return !ObjectUtils.equals(leftShiftAssignment.getEmployee(), rightShiftAssignment.getEmployee());
    }

    public Move createUndoMove(ScoreDirector scoreDirector) {
        return new ShiftAssignmentSwapMove(rightShiftAssignment, leftShiftAssignment);
    }

    public void doMove(ScoreDirector scoreDirector) {
        Employee oldLeftEmployee = leftShiftAssignment.getEmployee();
        Employee oldRightEmployee = rightShiftAssignment.getEmployee();
        NurseRosteringMoveHelper.moveEmployee(scoreDirector, leftShiftAssignment, oldRightEmployee);
        NurseRosteringMoveHelper.moveEmployee(scoreDirector, rightShiftAssignment, oldLeftEmployee);
    }

    public Collection<? extends Object> getPlanningEntities() {
        return Arrays.asList(leftShiftAssignment, rightShiftAssignment);
    }

    public Collection<? extends Object> getPlanningValues() {
        return Arrays.asList(leftShiftAssignment.getEmployee(), rightShiftAssignment.getEmployee());
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof ShiftAssignmentSwapMove) {
            ShiftAssignmentSwapMove other = (ShiftAssignmentSwapMove) o;
            return new EqualsBuilder()
                    .append(leftShiftAssignment, other.leftShiftAssignment)
                    .append(rightShiftAssignment, other.rightShiftAssignment)
                    .isEquals();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(leftShiftAssignment)
                .append(rightShiftAssignment)
                .toHashCode();
    }

    public String toString() {
        return leftShiftAssignment + " <=> " + rightShiftAssignment;
    }

}
