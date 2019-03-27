package io.rocketbase.vaadin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Components {

    private boolean preview;
    private boolean opacity;
    private boolean hue;

    private Interaction interaction;

}
