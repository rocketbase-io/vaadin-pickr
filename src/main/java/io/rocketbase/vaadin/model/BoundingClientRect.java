package io.rocketbase.vaadin.model;

public class BoundingClientRect {

    private String left;
    private String right;

    public String getJsonString() {

        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append("\"left\": \"5\" ");
        sb.append("\"right\": \"5\"");
        sb.append("}");

        return sb.toString();
    }

}
