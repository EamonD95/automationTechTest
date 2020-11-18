package config;

public enum Environments {

    HOME("http://automationpractice.com/index.php");

    private final String hostname;

    Environments(String hostname) {
        this.hostname = hostname;
    }

    public String getEnvironmentURL() {
        return hostname;
    }
}

