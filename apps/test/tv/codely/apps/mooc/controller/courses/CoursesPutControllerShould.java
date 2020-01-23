package tv.codely.apps.mooc.controller.courses;

import tv.codely.apps.mooc.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

final class CoursesPutControllerShould extends RequestTestCase {

    @Test
    void create_a_valid_course() throws Exception{
        assertRequestWithBody("PUT", "/courses/6d245356-703b-4a99-bb57-2ca6855471f9", "{\"name\":\"The best course\", \"duration\": \"5 hours\"}", 201);
    }
}
