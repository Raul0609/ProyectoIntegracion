
package aiss.githubminer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("url")
    private String url;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("body")
    private String body;

    @JsonProperty("user")
    private UserDTO user;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("issue_url")
    private String issueUrl;

    @JsonProperty("author_association")
    private String authorAssociation;

    public CommentDTO() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNodeId() { return nodeId; }

    public void setNodeId(String nodeId) { this.nodeId = nodeId; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getHtmlUrl() { return htmlUrl; }

    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public UserDTO getUser() { return user; }

    public void setUser(UserDTO user) { this.user = user; }

    public String getCreatedAt() { return createdAt; }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public String getIssueUrl() { return issueUrl; }

    public void setIssueUrl(String issueUrl) { this.issueUrl = issueUrl; }

    public String getAuthorAssociation() { return authorAssociation; }

    public void setAuthorAssociation(String authorAssociation) { this.authorAssociation = authorAssociation; }

    @Override
    public String toString() {
        return String.format("CommentDTO{id=%d, nodeId='%s', url='%s', htmlUrl='%s', body='%s', createdAt='%s', updatedAt='%s', issueUrl='%s', authorAssociation='%s'}",
                id, nodeId, url, htmlUrl, body, createdAt, updatedAt, issueUrl, authorAssociation);
    }
}