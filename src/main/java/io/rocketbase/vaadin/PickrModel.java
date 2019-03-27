package io.rocketbase.vaadin;

import com.vaadin.flow.templatemodel.TemplateModel;

public interface PickrModel extends TemplateModel {

    void setPickrOptions(String jsonString);

}
