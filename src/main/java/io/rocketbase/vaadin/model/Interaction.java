package io.rocketbase.vaadin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Interaction {

    private boolean hex = true;

    private boolean rgba = true;

    private boolean hsla = true;

    private boolean hsva = true;

    private boolean cmyk = true;

    private boolean input = true;

    private boolean clear = false;

    private boolean save = true;

}
