package com.ui.modals;

public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    SAFARI("safari"),
    EDGE("edge"),
    OPERA("opera");

    private String browser;

    Browsers(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}
