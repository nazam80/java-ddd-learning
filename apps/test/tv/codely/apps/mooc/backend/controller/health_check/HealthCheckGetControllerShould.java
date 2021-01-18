package tv.codely.apps.mooc.backend.controller.health_check;

import org.junit.jupiter.api.Test;

import tv.codely.apps.mooc.backend.controller.RequestTestCase;

final class HealthCheckGetControllerShould extends RequestTestCase {

    @Test
    void check_health_check_is_working() throws Exception{
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}
