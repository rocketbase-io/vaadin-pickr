package io.rocketbase.vaadin.model;

import com.vaadin.flow.component.ComponentEvent;
import io.rocketbase.vaadin.Pickr;
import lombok.Data;

@Data
public class PickrEvent extends ComponentEvent<Pickr> {

    public PickrEvent(Pickr pickr, boolean fromClient) {
        super(pickr, fromClient);
    }
}
