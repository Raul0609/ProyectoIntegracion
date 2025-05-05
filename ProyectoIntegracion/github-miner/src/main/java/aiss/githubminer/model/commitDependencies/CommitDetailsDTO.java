package aiss.githubminer.model.commitDependencies;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitDetailsDTO {

    @JsonProperty("url")
    private String url;

    @JsonProperty("author")
    private CommitAuthorDTO author;

    @JsonProperty("committer")
    private CommitAuthorDTO committer;

    @JsonProperty("message")
    private String message;

    @JsonProperty("comment_count")
    private int commentCount;

    public CommitDetailsDTO() {}

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public CommitAuthorDTO getAuthor() { return author; }
    public void setAuthor(CommitAuthorDTO author) { this.author = author; }

    public CommitAuthorDTO getCommitter() { return committer; }
    public void setCommitter(CommitAuthorDTO committer) { this.committer = committer; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getCommentCount() { return commentCount; }
    public void setCommentCount(int commentCount) { this.commentCount = commentCount; }

    @Override
    public String toString() {
        return String.format("CommitDetailsDTO{url='%s', message='%s', commentCount=%d}", url, message, commentCount);
    }
}