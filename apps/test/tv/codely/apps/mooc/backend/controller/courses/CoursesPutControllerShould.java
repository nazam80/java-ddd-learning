package tv.codely.apps.mooc.backend.controller.courses;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import tv.codely.apps.mooc.backend.controller.RequestTestCase;

@Transactional
final class CoursesPutControllerShould extends RequestTestCase {

    @Test
    void create_a_valid_course() throws Exception{
        assertRequestWithBody("PUT", "/courses/6d245356-703b-4a99-bb57-2ca6855471f9", "{\"name\":\"The best course\", \"duration\": \"5 hours\"}", 201);
    }
}
