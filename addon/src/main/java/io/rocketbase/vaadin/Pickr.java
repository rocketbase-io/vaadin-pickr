package io.rocketbase.vaadin;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.shared.Registration;
import io.rocketbase.vaadin.model.ColorObject;
import io.rocketbase.vaadin.model.PickrConfiguration;
import io.rocketbase.vaadin.model.PickrEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag("vaadin-pickr")
@HtmlImport("frontend://html/pickr.html")
@JavaScript("bower_components/pickr/dist/pickr.min.js")
public class Pickr extends PolymerTemplate<PickrModel> {

    @Getter
    private boolean attached = false;

    private PickrConfiguration config;

    public Pickr() {
    }

    public Pickr withConfig(PickrConfiguration config) {
        this.config = config;
        return this;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        attached = true;
        updateConfig();
    }

    protected void updateConfig() {
        getModel().setPickrOptions(config.getJsonString());
    }

    public Registration addColorUpdateListener(
            ComponentEventListener<PickrEvent> listener) {
        return addListener(PickrEvent.class, listener);
    }

    @ClientCallable
    private void colorChanged(String hexColor, String rgbaColor, String hslaColor, String hsvaColor, String cmykColor) {
        ColorObject colorObject = ColorObject.builder()
                .hexColor(hexColor)
                .rgbaColor(rgbaColor)
                .hslaColor(hslaColor)
                .hsvaColor(hsvaColor)
                .cmykColor(cmykColor)
                .build();

        PickrEvent event = new PickrEvent(this, false, colorObject);
        fireEvent(event);
    }
}

