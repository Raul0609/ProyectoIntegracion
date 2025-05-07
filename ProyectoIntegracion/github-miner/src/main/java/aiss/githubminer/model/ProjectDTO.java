package aiss.githubminer.model;

import aiss.githubminer.model.projectDependencies.LicenseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("owner")
    private UserDTO owner;

    @JsonProperty("private")
    private Boolean isPrivate;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("description")
    private String description;

    @JsonProperty("fork")
    private Boolean fork;

    @JsonProperty("url")
    private String url;

    @JsonProperty("language")
    private String language;

    @JsonProperty("forks_count")
    private Integer forksCount;

    @JsonProperty("stargazers_count")
    private Integer stargazersCount;

    @JsonProperty("watchers_count")
    private Integer watchersCount;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("default_branch")
    private String defaultBranch;

    @JsonProperty("open_issues_count")
    private Integer openIssuesCount;

    @JsonProperty("topics")
    private List<String> topics;

    @JsonProperty("has_issues")
    private Boolean hasIssues;

    @JsonProperty("has_projects")
    private Boolean hasProjects;

    @JsonProperty("has_wiki")
    private Boolean hasWiki;

    @JsonProperty("has_downloads")
    private Boolean hasDownloads;

    @JsonProperty("archived")
    private Boolean archived;

    @JsonProperty("disabled")
    private Boolean disabled;

    @JsonProperty("visibility")
    private String visibility;

    @JsonProperty("pushed_at")
    private String pushedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("license")
    private LicenseDTO license;

    public ProjectDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNodeId() { return nodeId; }
    public void setNodeId(String nodeId) { this.nodeId = nodeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public UserDTO getOwner() { return owner; }
    public void setOwner(UserDTO owner) { this.owner = owner; }

    public Boolean getIsPrivate() { return isPrivate; }
    public void setIsPrivate(Boolean isPrivate) { this.isPrivate = isPrivate; }

    public String getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getFork() { return fork; }
    public void setFork(Boolean fork) { this.fork = fork; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public Integer getForksCount() { return forksCount; }
    public void setForksCount(Integer forksCount) { this.forksCount = forksCount; }

    public Integer getStargazersCount() { return stargazersCount; }
    public void setStargazersCount(Integer stargazersCount) { this.stargazersCount = stargazersCount; }

    public Integer getWatchersCount() { return watchersCount; }
    public void setWatchersCount(Integer watchersCount) { this.watchersCount = watchersCount; }

    public Integer getSize() { return size; }
    public void setSize(Integer size) { this.size = size; }

    public String getDefaultBranch() { return defaultBranch; }
    public void setDefaultBranch(String defaultBranch) { this.defaultBranch = defaultBranch; }

    public Integer getOpenIssuesCount() { return openIssuesCount; }
    public void setOpenIssuesCount(Integer openIssuesCount) { this.openIssuesCount = openIssuesCount; }

    public List<String> getTopics() { return topics; }
    public void setTopics(List<String> topics) { this.topics = topics; }

    public Boolean getHasIssues() { return hasIssues; }
    public void setHasIssues(Boolean hasIssues) { this.hasIssues = hasIssues; }

    public Boolean getHasProjects() { return hasProjects; }
    public void setHasProjects(Boolean hasProjects) { this.hasProjects = hasProjects; }

    public Boolean getHasWiki() { return hasWiki; }
    public void setHasWiki(Boolean hasWiki) { this.hasWiki = hasWiki; }

    public Boolean getHasDownloads() { return hasDownloads; }
    public void setHasDownloads(Boolean hasDownloads) { this.hasDownloads = hasDownloads; }

    public Boolean getArchived() { return archived; }
    public void setArchived(Boolean archived) { this.archived = archived; }

    public Boolean getDisabled() { return disabled; }
    public void setDisabled(Boolean disabled) { this.disabled = disabled; }

    public String getVisibility() { return visibility; }
    public void setVisibility(String visibility) { this.visibility = visibility; }

    public String getPushedAt() { return pushedAt; }
    public void setPushedAt(String pushedAt) { this.pushedAt = pushedAt; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public LicenseDTO getLicense() { return license; }
    public void setLicense(LicenseDTO license) { this.license = license; }

    @Override
    public String toString() {
        return String.format("ProjectDTO{id=%d, name='%s', fullName='%s', owner='%s', language='%s', stargazersCount=%d}",
                id, name, fullName, owner.getLogin(), language, stargazersCount);
    }
}