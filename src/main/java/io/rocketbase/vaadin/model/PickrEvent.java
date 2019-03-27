package io.rocketbase.vaadin.model;

import com.vaadin.flow.component.ComponentEvent;
import io.rocketbase.vaadin.Pickr;
import lombok.Data;
import lombok.Getter;

@Data
public class PickrEvent extends ComponentEvent<Pickr> {

    @Getter
    ColorObject colorObject;

    public PickrEvent(Pickr source, boolean fromClient,
                      ColorObject colorObject) {
        super(source, fromClient);

        this.colorObject = colorObject;
    }
}
