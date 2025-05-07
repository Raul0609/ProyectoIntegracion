package aiss.bitbucketminer.model.dependencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAvatar {
    @JsonProperty("avatar")
    private Link avatar;

    public Link getAvatar() { return avatar; }
    public void setAvatar(Link avatar) { this.avatar = avatar; }

    @Override
    public String toString() {
        return "Links{" +
                "avatar=" + avatar +
                '}';
    }
}
