package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import aiss.bitbucketminer.model.dependencies.Repository;
import aiss.bitbucketminer.model.dependencies.User;
import  aiss.bitbucketminer.model.dependencies.Milestone;
import aiss.bitbucketminer.model.dependencies.Version;
import aiss.bitbucketminer.model.dependencies.Component;
import aiss.bitbucketminer.model.dependencies.Content;
import aiss.bitbucketminer.model.dependencies.Links;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueDTO {
    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private int id;

    @JsonProperty("repository")
    private Repository repository;

    @JsonProperty("title")
    private String title;

    @JsonProperty("reporter")
    private User reporter;

    @JsonProperty("assignee")
    private User assignee;

    @JsonProperty("created_on")
    private String createdOn;

    @JsonProperty("updated_on")
    private String updatedOn;

    @JsonProperty("edited_on")
    private String editedOn;

    @JsonProperty("state")
    private String state;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("milestone")
    private Milestone milestone;

    @JsonProperty("version")
    private Version version;

    @JsonProperty("component")
    private Component component;

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("content")
    private Content content;

    @JsonProperty("links")
    private Links links;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Repository getRepository() { return repository; }
    public void setRepository(Repository repository) { this.repository = repository; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public User getReporter() { return reporter; }
    public void setReporter(User reporter) { this.reporter = reporter; }

    public User getAssignee() { return assignee; }
    public void setAssignee(User assignee) { this.assignee = assignee; }

    public String getCreatedOn() { return createdOn; }
    public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

    public String getUpdatedOn() { return updatedOn; }
    public void setUpdatedOn(String updatedOn) { this.updatedOn = updatedOn; }

    public String getEditedOn() { return editedOn; }
    public void setEditedOn(String editedOn) { this.editedOn = editedOn; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getKind() { return kind; }
    public void setKind(String kind) { this.kind = kind; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public Milestone getMilestone() { return milestone; }
    public void setMilestone(Milestone milestone) { this.milestone = milestone; }

    public Version getVersion() { return version; }
    public void setVersion(Version version) { this.version = version; }

    public Component getComponent() { return component; }
    public void setComponent(Component component) { this.component = component; }

    public int getVotes() { return votes; }
    public void setVotes(int votes) { this.votes = votes; }

    public Content getContent() { return content; }
    public void setContent(Content content) { this.content = content; }

    public Links getLinks() { return links; }
    public void setLinks(Links links) { this.links = links; }

    @Override
    public String toString() {
        return "IssueDTO{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", repository=" + repository +
                ", title='" + title + '\'' +
                ", reporter=" + reporter +
                ", assignee=" + assignee +
                ", createdOn='" + createdOn + '\'' +
                ", updatedOn='" + updatedOn + '\'' +
                ", editedOn='" + editedOn + '\'' +
                ", state='" + state + '\'' +
                ", kind='" + kind + '\'' +
                ", priority='" + priority + '\'' +
                ", milestone=" + milestone +
                ", version=" + version +
                ", component=" + component +
                ", votes=" + votes +
                ", content=" + content +
                ", links=" + links +
                '}';
    }
}
