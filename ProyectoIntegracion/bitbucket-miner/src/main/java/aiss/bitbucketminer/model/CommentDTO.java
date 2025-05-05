package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import aiss.bitbucketminer.model.dependencies.Content;
import aiss.bitbucketminer.model.dependencies.Inline;
import aiss.bitbucketminer.model.dependencies.Link;
import aiss.bitbucketminer.model.dependencies.User;
import aiss.bitbucketminer.model.dependencies.Issue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDTO {

    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private int id;

    @JsonProperty("created_on")
    private String createdOn;

    @JsonProperty("updated_on")
    private String updatedOn;

    @JsonProperty("content")
    private Content content;

    @JsonProperty("user")
    private User user;

    @JsonProperty("deleted")
    private boolean deleted;

    @JsonProperty("inline")
    private Inline inline;

    @JsonProperty("links")
    private Map<String, Link> links;

    @JsonProperty("issue")
    private Issue issue;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCreatedOn() { return createdOn; }
    public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

    public String getUpdatedOn() { return updatedOn; }
    public void setUpdatedOn(String updatedOn) { this.updatedOn = updatedOn; }

    public Content getContent() { return content; }
    public void setContent(Content content) { this.content = content; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public Inline getInline() { return inline; }
    public void setInline(Inline inline) { this.inline = inline; }

    public Map<String, Link> getLinks() { return links; }
    public void setLinks(Map<String, Link> links) { this.links = links; }

    public Issue getIssue() { return issue; }
    public void setIssue(Issue issue) { this.issue = issue; }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", createdOn='" + createdOn + '\'' +
                ", updatedOn='" + updatedOn + '\'' +
                ", content=" + content +
                ", user=" + user +
                ", deleted=" + deleted +
                ", inline=" + inline +
                ", links=" + links +
                ", issue=" + issue +
                '}';
    }
}