package tv.codely.mooc.courses.domain;

import tv.codely.shared.domain.IntegerMother;
import tv.codely.shared.domain.RandomElementPicker;
import tv.codely.shared.domain.WordMother;

public class CourseDurationMother {
    public static CourseDuration create(String value) {
        return new CourseDuration(value);
    }

    public static CourseDuration random() {
        return create(String.format(
            "%s %s",
            IntegerMother.random(),
            RandomElementPicker.from("years", "months", "days", "hours", "minutes", "seconds")
        ));
    }
}
