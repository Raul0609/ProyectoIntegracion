package aiss.bitbucketminer.model.dependencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {
    @JsonProperty("self")
    private Link self;

    @JsonProperty("html")
    private Link html;

    @JsonProperty("comments")
    private Link comments;

    @JsonProperty("attachments")
    private Link attachments;

    @JsonProperty("watch")
    private Link watch;

    @JsonProperty("vote")
    private Link vote;

    public Link getSelf() { return self; }
    public void setSelf(Link self) { this.self = self; }

    public Link getHtml() { return html; }
    public void setHtml(Link html) { this.html = html; }

    public Link getComments() { return comments; }
    public void setComments(Link comments) { this.comments = comments; }

    public Link getAttachments() { return attachments; }
    public void setAttachments(Link attachments) { this.attachments = attachments; }

    public Link getWatch() { return watch; }
    public void setWatch(Link watch) { this.watch = watch; }

    public Link getVote() { return vote; }
    public void setVote(Link vote) { this.vote = vote; }

    @Override
    public String toString() {
        return "Links{" +
                "self=" + self +
                ", html=" + html +
                ", comments=" + comments +
                ", attachments=" + attachments +
                ", watch=" + watch +
                ", vote=" + vote +
                '}';
    }
}
