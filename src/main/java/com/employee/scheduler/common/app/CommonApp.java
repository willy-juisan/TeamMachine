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

package com.employee.scheduler.common.app;

import java.awt.Component;

import javax.swing.WindowConstants;

import org.optaplanner.benchmark.impl.aggregator.swingui.SwingUncaughtExceptionHandler;
import org.optaplanner.benchmark.impl.aggregator.swingui.SwingUtils;
import org.optaplanner.core.api.solver.Solver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.employee.scheduler.common.business.SolutionBusiness;
import com.employee.scheduler.common.persistence.AbstractSolutionExporter;
import com.employee.scheduler.common.persistence.AbstractSolutionImporter;
import com.employee.scheduler.common.persistence.SolutionDao;
import com.employee.scheduler.common.swingui.SolutionPanel;
import com.employee.scheduler.common.swingui.SolverAndPersistenceFrame;

public abstract class CommonApp extends LoggingMain {

    protected static final Logger logger = LoggerFactory.getLogger(CommonApp.class);

    /**
     * Some examples are not compatible with every native LookAndFeel.
     * For example, NurseRosteringPanel is incompatible with Mac.
     */
    public static void prepareSwingEnvironment() {
        SwingUncaughtExceptionHandler.register();
        SwingUtils.fixateLookAndFeel();
    }

    protected final String name;
    protected final String description;
    protected final String iconResource;

    protected SolverAndPersistenceFrame solverAndPersistenceFrame;
    protected SolutionBusiness solutionBusiness;

    protected CommonApp(String name, String description, String iconResource) {
        this.name = name;
        this.description = description;
        this.iconResource = iconResource;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIconResource() {
        return iconResource;
    }

    public void init() {
        init(null, true);
    }

    public void init(Component centerForComponent, boolean exitOnClose) {
        solutionBusiness = createSolutionBusiness();
        solverAndPersistenceFrame = new SolverAndPersistenceFrame(
                solutionBusiness, createSolutionPanel(), name + " OptaPlanner example");
        solverAndPersistenceFrame.setDefaultCloseOperation(exitOnClose ? WindowConstants.EXIT_ON_CLOSE : WindowConstants.DISPOSE_ON_CLOSE);
        solverAndPersistenceFrame.init(centerForComponent);
        solverAndPersistenceFrame.setVisible(true);
    }

    public SolutionBusiness createSolutionBusiness() {
        SolutionBusiness solutionBusiness = new SolutionBusiness();
        solutionBusiness.setSolutionDao(createSolutionDao());
        solutionBusiness.setImporter(createSolutionImporter());
        solutionBusiness.setExporter(createSolutionExporter());
        solutionBusiness.updateDataDirs();
        solutionBusiness.setSolver(createSolver());
        return solutionBusiness;
    }

    protected abstract Solver createSolver();

    protected abstract SolutionPanel createSolutionPanel();

    protected abstract SolutionDao createSolutionDao();

    protected AbstractSolutionImporter createSolutionImporter() {
        return null;
    }

    protected AbstractSolutionExporter createSolutionExporter() {
        return null;
    }

}
