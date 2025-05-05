package aiss.githubminer.model.commitDependencies;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitFileDTO {

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("additions")
    private int additions;

    @JsonProperty("deletions")
    private int deletions;

    @JsonProperty("changes")
    private int changes;

    @JsonProperty("status")
    private String status;

    @JsonProperty("raw_url")
    private String rawUrl;

    @JsonProperty("blob_url")
    private String blobUrl;

    @JsonProperty("patch")
    private String patch;

    public CommitFileDTO() {}

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public int getAdditions() { return additions; }
    public void setAdditions(int additions) { this.additions = additions; }

    public int getDeletions() { return deletions; }
    public void setDeletions(int deletions) { this.deletions = deletions; }

    public int getChanges() { return changes; }
    public void setChanges(int changes) { this.changes = changes; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRawUrl() { return rawUrl; }
    public void setRawUrl(String rawUrl) { this.rawUrl = rawUrl; }

    public String getBlobUrl() { return blobUrl; }
    public void setBlobUrl(String blobUrl) { this.blobUrl = blobUrl; }

    public String getPatch() { return patch; }
    public void setPatch(String patch) { this.patch = patch; }

    @Override
    public String toString() {
        return String.format("CommitFileDTO{filename='%s', status='%s', changes=%d}", filename, status, changes);
    }
}