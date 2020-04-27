public final class EnvironmentVariables {

    private EnvironmentVariables() {
    }

    public static String getHostUrl() {
        return System.getProperty("siteUrl", "https://www.rdveikals.lv/");
    }
}
