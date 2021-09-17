package pojos;
import com.fasterxml.jackson.annotation.JsonProperty;
public class EmulatorProperties {

    @JsonProperty("platformName")
    public String platformName;

    @JsonProperty("platformVersion")
    public String platformVersion;

    @JsonProperty("deviceName")
    public String deviceName;

    @JsonProperty("appPackage")
    public String appPackage;

    @JsonProperty("appActivity")
    public String appActivity;

}
