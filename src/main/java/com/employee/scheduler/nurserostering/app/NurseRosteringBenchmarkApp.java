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

import com.employee.scheduler.common.app.CommonBenchmarkApp;
import com.employee.scheduler.common.app.CommonBenchmarkApp.ArgOption;


public class NurseRosteringBenchmarkApp extends CommonBenchmarkApp {

    public static void main(String[] args) {
        new NurseRosteringBenchmarkApp().buildAndBenchmark(args);
    }

    public NurseRosteringBenchmarkApp() {
        super(
                new ArgOption("sprint",
                        "com/employee/scheduler/nurserostering/benchmark/nurseRosteringSprintBenchmarkConfig.xml"),
                new ArgOption("medium",
                        "com/employee/scheduler/nurserostering/benchmark/nurseRosteringMediumBenchmarkConfig.xml"),
                new ArgOption("long",
                        "com/employee/scheduler/nurserostering/benchmark/nurseRosteringLongBenchmarkConfig.xml"),
                new ArgOption("stepLimit",
                        "com/employee/scheduler/nurserostering/benchmark/nurseRosteringStepLimitBenchmarkConfig.xml")
        );
    }

}
