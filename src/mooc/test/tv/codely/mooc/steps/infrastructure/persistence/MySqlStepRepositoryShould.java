package tv.codely.mooc.steps.infrastructure.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import tv.codely.mooc.courses.StepModuleInfrastructureTestCase;
import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.StepIdMother;
import tv.codely.mooc.steps.domain.challenge.ChallengeStep;
import tv.codely.mooc.steps.domain.challenge.ChallengeStepMother;
import tv.codely.mooc.steps.domain.video.VideoStep;
import tv.codely.mooc.steps.domain.video.VideoStepMother;

@Transactional
class MySqlStepRepositoryShould  extends StepModuleInfrastructureTestCase {

    @Test
    void save_a_valid_video_step() {
        VideoStep step = VideoStepMother.random();
        mySqlStepRepository.save(step);
    }


    @Test
    void search_an_existing_video_step() {
    	VideoStep step = VideoStepMother.random();
        mySqlStepRepository.save(step);

        Assert.assertEquals(Optional.of(step), mySqlStepRepository.search(step.id()));
    }

    //@Test
    void search_not_existing_step() {
        StepId id = StepIdMother.random();        
        
        Assert.assertFalse(mySqlStepRepository.search(id).isPresent());
    }
    
    @Test
    void save_a_valid_challenge_step() {
        ChallengeStep step = ChallengeStepMother.random();
        mySqlStepRepository.save(step);
    }


    @Test
    void search_an_existing_challenge_step() {
    	ChallengeStep step = ChallengeStepMother.random();
        mySqlStepRepository.save(step);

        Assert.assertEquals(Optional.of(step), mySqlStepRepository.search(step.id()));
    }


}
