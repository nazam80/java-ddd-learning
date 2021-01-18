package tv.codely.mooc.steps.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import tv.codely.mooc.courses.StepModuleInfrastructureTestCase;
import tv.codely.mooc.steps.domain.Step;
import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.StepIdMother;
import tv.codely.mooc.steps.domain.challenge.ChallengeStepMother;
import tv.codely.mooc.steps.domain.video.VideoStepMother;

@Transactional
class MySqlStepRepositoryShould  extends StepModuleInfrastructureTestCase {

    @Test
    void save_a_valid_step() {
    	steps().stream().forEach(step -> mySqlStepRepository.save(step));
    }


    @Test
    void search_an_existing_step() {
    	steps().stream().forEach(step -> {
    		mySqlStepRepository.save(step);

    		Assert.assertEquals(Optional.of(step), mySqlStepRepository.search(step.id()));
    	});
    }

    //@Test
    void search_not_existing_step() {
        StepId id = StepIdMother.random();        
        
        Assert.assertFalse(mySqlStepRepository.search(id).isPresent());
    }


    private List<? extends Step> steps() {
        return List.of(ChallengeStepMother.random(), VideoStepMother.random());
    }
}
