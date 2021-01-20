package tv.codely.shared.infrastructure;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.EventBus;

public class UnitTestCase {
	protected EventBus eventBus;

	@BeforeEach
	protected void setUp() {
		eventBus = mock(EventBus.class);
	}

	public void shouldHavePublished(List<DomainEvent<?>> domainEvents) {
		verify(eventBus, atLeastOnce()).publish(domainEvents);
	}

	public void shouldHavePublished(DomainEvent<?> domainEvent) {
		shouldHavePublished(Collections.singletonList(domainEvent));
	}
}
