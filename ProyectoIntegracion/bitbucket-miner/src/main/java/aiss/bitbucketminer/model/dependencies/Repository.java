package aiss.bitbucketminer.model.dependencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    @Override
    public String toString() {
        return "Repository{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
