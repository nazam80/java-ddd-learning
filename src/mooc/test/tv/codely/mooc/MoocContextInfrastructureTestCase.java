package tv.codely.mooc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.apps.mooc.MoocApplication;
import tv.codely.shared.infrastructure.InfrastructureTestCase;

@ContextConfiguration(classes=MoocApplication.class)
@SpringBootTest
public class MoocContextInfrastructureTestCase extends InfrastructureTestCase {
}
