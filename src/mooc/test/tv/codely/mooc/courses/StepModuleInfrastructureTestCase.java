package tv.codely.mooc.courses;

import org.springframework.beans.factory.annotation.Autowired;

import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.courses.domain.StepRepository;

public abstract class StepModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {

    @Autowired
    protected StepRepository mySqlStepRepository;
}

