package aiss.githubminer.model.issueDependencies;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MilestoneDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("url")
    private String url;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("labels_url")
    private String labelsUrl;

    @JsonProperty("state")
    private String state;

    @JsonProperty("open_issues")
    private Integer openIssues;

    @JsonProperty("closed_issues")
    private Integer closedIssues;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("closed_at")
    private String closedAt;

    @JsonProperty("due_on")
    private String dueOn;

    public MilestoneDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNodeId() { return nodeId; }
    public void setNodeId(String nodeId) { this.nodeId = nodeId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

    public String getLabelsUrl() { return labelsUrl; }
    public void setLabelsUrl(String labelsUrl) { this.labelsUrl = labelsUrl; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public Integer getOpenIssues() { return openIssues; }
    public void setOpenIssues(Integer openIssues) { this.openIssues = openIssues; }

    public Integer getClosedIssues() { return closedIssues; }
    public void setClosedIssues(Integer closedIssues) { this.closedIssues = closedIssues; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public String getClosedAt() { return closedAt; }
    public void setClosedAt(String closedAt) { this.closedAt = closedAt; }

    public String getDueOn() { return dueOn; }
    public void setDueOn(String dueOn) { this.dueOn = dueOn; }

    @Override
    public String toString() {
        return String.format("MilestoneDTO{id=%d, title='%s', state='%s', openIssues=%d, closedIssues=%d}", id, title, state, openIssues, closedIssues);
    }
}