package com.ui.modals;

public enum ExecutionMode {
    LOCAL("local"),
    REMOTE("remote");

    private String executionMode;

    ExecutionMode(String executionMode) {
        this.executionMode = executionMode;
    }

    public String getExecutionMode() {
        return executionMode;
    }
}
