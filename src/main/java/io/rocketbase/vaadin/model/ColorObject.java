package io.rocketbase.vaadin.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ColorObject {

    private String hexColor;
    private String rgbaColor;
    private String hslaColor;
    private String hsvaColor;
    private String cmykColor;
}
