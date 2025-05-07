package aiss.bitbucketminer.model.dependencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("nickname")
    private String nickname;

    public String getDisplayName() { return displayName; }

    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getNickname() { return nickname; }

    public void setNickname(String nickname) { this.nickname = nickname; }

    @Override
    public String toString() {
        return "Author{" +
                "displayName='" + displayName + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
