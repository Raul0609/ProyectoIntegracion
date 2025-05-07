package aiss.bitbucketminer.model.dependencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {
    @JsonProperty("href")
    private String href;

    @JsonProperty("name")
    private String name;

    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Link{" +
                "href='" + href + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
