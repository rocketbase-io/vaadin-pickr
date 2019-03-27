package io.rocketbase.vaadin;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import io.rocketbase.vaadin.model.Components;
import io.rocketbase.vaadin.model.Interaction;
import io.rocketbase.vaadin.model.PickrConfiguration;

@Route("")
public class DemoView extends HorizontalLayout {

    Label hexColorLabel = new Label();

    public DemoView() {

        setWidth("100%");

        setSizeFull();

        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("350px");

        HorizontalLayout horLayout = new HorizontalLayout();

        Pickr pickr = new Pickr()
                .withConfig(PickrConfiguration.builder()
                        .el(".pickr")
                        .defaultColor("#4EA0DB")
                        .components(Components.builder()
                                .hue(true)
                                .opacity(true)
                                .preview(true)
                                .interaction(new Interaction())
                                .build())
                        .build());

        horLayout.add(pickr, hexColorLabel);
        layout.add(new H4("vaadin-pickr"), new Hr(), horLayout);

        pickr.addColorUpdateListener(pickrEvent -> {
            hexColorLabel.setText("Color: " + pickrEvent.getColorObject().getHexColor());
        });

        add(layout);
    }
}
