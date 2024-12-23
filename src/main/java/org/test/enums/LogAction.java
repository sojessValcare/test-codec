package org.test.enums;

public enum LogAction {

    ADD("ADD"),MODIFY("MODIFY"),DELETE("DELETE");
    private final String action;

    private LogAction(String action) {
        this.action = action;
    }

    public String action() {
        return this.action;
    }
}
