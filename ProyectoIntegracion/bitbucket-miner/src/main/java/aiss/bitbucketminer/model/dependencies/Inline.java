package aiss.bitbucketminer.model.dependencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inline {
    @JsonProperty("from")
    private int from;

    @JsonProperty("to")
    private int to;

    @JsonProperty("path")
    private String path;

    public int getFrom() { return from; }
    public void setFrom(int from) { this.from = from; }

    public int getTo() { return to; }
    public void setTo(int to) { this.to = to; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    @Override
    public String toString() {
        return "Inline{" +
                "from=" + from +
                ", to=" + to +
                ", path='" + path + '\'' +
                '}';
    }
}
