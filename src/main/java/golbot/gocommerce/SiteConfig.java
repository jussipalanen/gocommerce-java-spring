package golbot.gocommerce;
public class SiteConfig {
    public static String title = "GoCommerce";
    public static String baseUrl = "http:://localhost:9000";
    /**
     * @return the title
     */
    public static String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public static void setTitle(String title) {
        SiteConfig.title = title;
    }
    /**
     * @return the baseUrl
     */
    public static String getBaseUrl() {
        return baseUrl;
    }
    /**
     * @param baseUrl the baseUrl to set
     */
    public static void setBaseUrl(String baseUrl) {
        SiteConfig.baseUrl = baseUrl;
    }

    public static String getAppConfigAsJson()
    {
        return "No";
    }
}
