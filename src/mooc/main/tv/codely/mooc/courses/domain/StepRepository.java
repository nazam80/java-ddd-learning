package tv.codely.mooc.courses.domain;

import java.util.Optional;

import tv.codely.mooc.steps.domain.Step;
import tv.codely.mooc.steps.domain.StepId;

public interface StepRepository {
    void save(Step step);

    Optional<? extends Step> search(StepId id);
}
