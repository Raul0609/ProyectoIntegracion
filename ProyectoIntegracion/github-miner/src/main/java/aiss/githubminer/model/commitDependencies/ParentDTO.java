package aiss.githubminer.model.commitDependencies;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentDTO {

    @JsonProperty("url")
    private String url;

    @JsonProperty("sha")
    private String sha;

    public ParentDTO() {}

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getSha() { return sha; }
    public void setSha(String sha) { this.sha = sha; }

    @Override
    public String toString() {
        return String.format("ParentDTO{url='%s', sha='%s'}", url, sha);
    }
}