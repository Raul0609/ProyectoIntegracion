package aiss.githubminer.model.issueDependencies;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestDTO {

    @JsonProperty("url")
    private String url;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("diff_url")
    private String diffUrl;

    @JsonProperty("patch_url")
    private String patchUrl;

    public PullRequestDTO() {}

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

    public String getDiffUrl() { return diffUrl; }
    public void setDiffUrl(String diffUrl) { this.diffUrl = diffUrl; }

    public String getPatchUrl() { return patchUrl; }
    public void setPatchUrl(String patchUrl) { this.patchUrl = patchUrl; }

    @Override
    public String toString() {
        return String.format("PullRequestDTO{url='%s', htmlUrl='%s', diffUrl='%s', patchUrl='%s'}", url, htmlUrl, diffUrl, patchUrl);
    }
}