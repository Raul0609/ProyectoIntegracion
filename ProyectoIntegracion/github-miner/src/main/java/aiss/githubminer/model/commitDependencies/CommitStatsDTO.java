package aiss.githubminer.model.commitDependencies;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitStatsDTO {

    @JsonProperty("additions")
    private int additions;

    @JsonProperty("deletions")
    private int deletions;

    @JsonProperty("total")
    private int total;

    public CommitStatsDTO() {}

    public int getAdditions() { return additions; }
    public void setAdditions(int additions) { this.additions = additions; }

    public int getDeletions() { return deletions; }
    public void setDeletions(int deletions) { this.deletions = deletions; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    @Override
    public String toString() {
        return String.format("CommitStatsDTO{additions=%d, deletions=%d, total=%d}", additions, deletions, total);
    }
}