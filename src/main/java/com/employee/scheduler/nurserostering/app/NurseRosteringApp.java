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

package com.employee.scheduler.nurserostering.app;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import com.employee.scheduler.common.app.CommonApp;
import com.employee.scheduler.common.persistence.AbstractSolutionExporter;
import com.employee.scheduler.common.persistence.AbstractSolutionImporter;
import com.employee.scheduler.common.persistence.SolutionDao;
import com.employee.scheduler.common.swingui.SolutionPanel;
import com.employee.scheduler.nurserostering.persistence.NurseRosteringDao;
import com.employee.scheduler.nurserostering.persistence.NurseRosteringExporter;
import com.employee.scheduler.nurserostering.persistence.NurseRosteringImporter;
import com.employee.scheduler.nurserostering.swingui.NurseRosteringPanel;

public class NurseRosteringApp extends CommonApp {

    public static final String SOLVER_CONFIG
            = "com/employee/scheduler/nurserostering/solver/nurseRosteringSolverConfig.xml";

    public static void main(String[] args) {
        prepareSwingEnvironment();
        new NurseRosteringApp().init();
    }

    public NurseRosteringApp() {
        super("Employee rostering",
                "Official competition name: INRC2010 - Nurse rostering\n\n" +
                        "Assign shifts to employees.",
                NurseRosteringPanel.LOGO_PATH);
    }

    @Override
    protected Solver createSolver() {
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        return solverFactory.buildSolver();
    }

    @Override
    protected SolutionPanel createSolutionPanel() {
        return new NurseRosteringPanel();
    }

    @Override
    protected SolutionDao createSolutionDao() {
        return new NurseRosteringDao();
    }

    @Override
    protected AbstractSolutionImporter createSolutionImporter() {
        return new NurseRosteringImporter();
    }

    @Override
    protected AbstractSolutionExporter createSolutionExporter() {
        return new NurseRosteringExporter();
    }

}
