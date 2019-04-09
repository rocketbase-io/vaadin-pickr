package io.rocketbase.vaadin.spring;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import io.rocketbase.vaadin.Pickr;
import io.rocketbase.vaadin.model.Components;
import io.rocketbase.vaadin.model.Interaction;
import io.rocketbase.vaadin.model.PickrConfiguration;

import java.io.IOException;

@Route
@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Project Base")
public class MainView extends Div {


    VerticalLayout main = new VerticalLayout();

    Label hexColorLabel = new Label();
    Label rgbaColorLabel = new Label();
    Label hslaColorLabel = new Label();
    Label hsvaColorLabel = new Label();
    Label cmykColorLabel = new Label();

    Div pickrDiv = new Div();
    Div previewDiv = new Div();

    public MainView() throws IOException {

        setWidth("100%");

        setSizeFull();

        pickrDiv.getStyle().set("padding", "1% 2%");
        pickrDiv.getStyle().set("width", "450px");
        pickrDiv.getStyle().set("margin", "auto");
        pickrDiv.getStyle().set("margin-top", "10%");
        pickrDiv.getStyle().set("text-align", "center");

        H3 header = new H3("vaadin-pickr");
        header.getStyle().set("color", "white");
        pickrDiv.add();

        Pickr pickr = new Pickr()
                .withConfig(PickrConfiguration.builder()
                        .el(".pickr")
                        .defaultColor("#FFFFFF")
                        .components(Components.builder()
                                .hue(true)
                                .opacity(true)
                                .preview(true)
                                .interaction(
                                        Interaction.builder()
                                                .hex(true)
                                                .rgba(true)
                                                .hsla(true)
                                                .hsva(true)
                                                .cmyk(true)
                                                .input(true)
                                                .save(true)
                                                .clear(true)
                                                .build())
                                .build())
                        .build());


        Label info = new Label();
        info.setText("(Tap it!)");
        info.getStyle().set("font-size", "1em");
        pickrDiv.add(header, pickr, info);


        previewDiv.getStyle().set("background-color", "white");
        previewDiv.getStyle().set("padding", "1% 2%");
        previewDiv.getStyle().set("width", "450px");
        previewDiv.getStyle().set("margin", "auto");
        previewDiv.getStyle().set("margin-top", "1%");

        H3 headerPreviewDiv = new H3("Colorcodes");
        VerticalLayout prevLayout = new VerticalLayout();
        prevLayout.setSizeFull();
        prevLayout.add(hexColorLabel, rgbaColorLabel, hslaColorLabel, hsvaColorLabel, cmykColorLabel);
        previewDiv.add(headerPreviewDiv, new Hr(), prevLayout);

        pickr.addColorUpdateListener(pickrEvent -> {
            hexColorLabel.setText("HEX: " + pickrEvent.getColorObject().getHexColor());
            rgbaColorLabel.setText("RGBA: " + pickrEvent.getColorObject().getRgbaColor());
            hslaColorLabel.setText("HSLA: " + pickrEvent.getColorObject().getHslaColor());
            hsvaColorLabel.setText("HSVA: " + pickrEvent.getColorObject().getHsvaColor());
            cmykColorLabel.setText("CMYK: " + pickrEvent.getColorObject().getCmykColor());
        });


        main.add(pickrDiv, previewDiv);

        setSizeFull();
        getStyle().set("background-color", "#3766BF");
        add(main);
    }

}
