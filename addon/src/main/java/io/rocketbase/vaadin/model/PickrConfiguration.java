package io.rocketbase.vaadin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickrConfiguration {

    private final String el = ".pickr";

    private String defaultColor = "FFFFFF";

    private final boolean useAsButton = false;

    private final boolean showAlways = false;

    private Components components;

    public String getJsonString() {

        List<String> parameters = new ArrayList<>();
        parameters.add(String.format("\"el\": \"%s\",", el));
        if (defaultColor != null) {
            parameters.add(String.format("\"default\": \"%s\",", defaultColor));
        }

        parameters.add(String.format("\"useAsButton\":" + useAsButton + ","));
        parameters.add(String.format("\"showAlways\":" + showAlways + ","));

        parameters.add(String.format("\"components\": {"));
        parameters.add(String.format("\"preview\":" + components.isPreview() + ","));
        parameters.add(String.format("\"opacity\":" + components.isOpacity() + ","));
        parameters.add(String.format("\"hue\":" + components.isHue() + ","));

        parameters.add(String.format("\"interaction\": {"));
        parameters.add(String.format("\"hex\":" + components.getInteraction().isHex() + ","));
        parameters.add(String.format("\"rgba\":" + components.getInteraction().isRgba() + ","));
        parameters.add(String.format("\"hsla\":" + components.getInteraction().isHsla() + ","));
        parameters.add(String.format("\"hsva\":" + components.getInteraction().isHsva() + ","));
        parameters.add(String.format("\"cmyk\":" + components.getInteraction().isCmyk() + ","));
        parameters.add(String.format("\"input\":" + components.getInteraction().isInput() + ","));
        parameters.add(String.format("\"clear\":" + components.getInteraction().isClear() + ","));
        parameters.add(String.format("\"save\":" + components.getInteraction().isSave()));
        parameters.add(String.format("}"));

        parameters.add(String.format("}"));

        String result = "{";
        int paramSize = parameters.size();
        for (int x = 0; x < paramSize; x++) {
            result += parameters.get(x);
        }
        result += "}";
        return result;

    }


}
