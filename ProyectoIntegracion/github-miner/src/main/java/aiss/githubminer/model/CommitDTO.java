package aiss.githubminer.model;

import aiss.githubminer.model.commitDependencies.CommitDetailsDTO;
import aiss.githubminer.model.commitDependencies.CommitFileDTO;
import aiss.githubminer.model.commitDependencies.CommitStatsDTO;
import aiss.githubminer.model.commitDependencies.ParentDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitDTO {

    @JsonProperty("url")
    private String url;

    @JsonProperty("sha")
    private String sha;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("comments_url")
    private String commentsUrl;

    @JsonProperty("commit")
    private CommitDetailsDTO commit;

    @JsonProperty("author")
    private UserDTO author;

    @JsonProperty("committer")
    private UserDTO committer;

    @JsonProperty("parents")
    private List<ParentDTO> parents;

    @JsonProperty("stats")
    private CommitStatsDTO stats;

    @JsonProperty("files")
    private List<CommitFileDTO> files;

    public CommitDTO() {}

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getSha() { return sha; }
    public void setSha(String sha) { this.sha = sha; }

    public String getNodeId() { return nodeId; }
    public void setNodeId(String nodeId) { this.nodeId = nodeId; }

    public String getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

    public String getCommentsUrl() { return commentsUrl; }
    public void setCommentsUrl(String commentsUrl) { this.commentsUrl = commentsUrl; }

    public CommitDetailsDTO getCommit() { return commit; }
    public void setCommit(CommitDetailsDTO commit) { this.commit = commit; }

    public UserDTO getAuthor() { return author; }
    public void setAuthor(UserDTO author) { this.author = author; }

    public UserDTO getCommitter() { return committer; }
    public void setCommitter(UserDTO committer) { this.committer = committer; }

    public List<ParentDTO> getParents() { return parents; }
    public void setParents(List<ParentDTO> parents) { this.parents = parents; }

    public CommitStatsDTO getStats() { return stats; }
    public void setStats(CommitStatsDTO stats) { this.stats = stats; }

    public List<CommitFileDTO> getFiles() { return files; }
    public void setFiles(List<CommitFileDTO> files) { this.files = files; }

    @Override
    public String toString() {
        return String.format("CommitDTO{sha='%s', message='%s', author='%s', committer='%s', stats=%s, files=%s}",
                sha,
                commit != null ? commit.getMessage() : "No message",
                author != null ? author.getLogin() : "Unknown author",
                committer != null ? committer.getLogin() : "Unknown committer",
                stats != null ? stats.toString() : "No stats",
                files != null ? files.toString() : "No files");
    }
}