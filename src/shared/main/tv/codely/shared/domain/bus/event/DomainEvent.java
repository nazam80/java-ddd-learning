package tv.codely.shared.domain.bus.event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import tv.codely.shared.domain.Utils;

public abstract class DomainEvent<T extends DomainEvent<?>> {
    private final String aggregateId;
    private final String eventId;
    private final String occurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId     = UUID.randomUUID().toString();
        this.occurredOn  = Utils.dateToString(LocalDateTime.now());
    }

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId     = eventId;
        this.occurredOn  = occurredOn;
    }

    public abstract String eventName();

    public abstract Map<String, Serializable> toPrimitives();

    public abstract T fromPrimitives(
        String aggregateId,
        Map<String, Serializable> body,
        String eventId,
        String occurredOn
    );

	public String getAggregateId() {
		return aggregateId;
	}

	public String getEventId() {
		return eventId;
	}

	public String getOccurredOn() {
		return occurredOn;
	}
}
