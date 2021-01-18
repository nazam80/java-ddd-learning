package tv.codely.mooc.steps.domain;

import tv.codely.shared.domain.StringValueObject;

public class StepTitle extends StringValueObject {

	public StepTitle(String value) {
		super(value);	
	}

    private StepTitle() {
        super(null);
    }
}
