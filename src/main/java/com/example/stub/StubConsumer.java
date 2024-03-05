package com.example.stub;

import lombok.extern.slf4j.Slf4j;
import org.example.event.api.IProductEventsProducer;
import org.example.event.model.ProductCreatedPayload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StubConsumer implements IProductEventsProducer {
    @Override
    public boolean sendProductCreated(ProductCreatedPayload payload, ProductCreatedPayloadHeaders headers) {
        log.info("Product was sent {}", payload.getProductType());
        return true;
    }
}
