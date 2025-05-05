package aiss.bitbucketminer.model;

import aiss.bitbucketminer.model.dependencies.UserAvatar;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    @JsonProperty("type")
    private String type;

    @JsonProperty("links")
    private UserAvatar links;

    @JsonProperty("created_on")
    private String createdOn;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("uuid")
    private String uuid;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public UserAvatar getLinks() { return links; }
    public void setLinks(UserAvatar links) { this.links = links; }

    public String getCreatedOn() { return createdOn; }
    public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }

    @Override
    public String toString() {
        return "UserDTO{" +
                "type='" + type + '\'' +
                ", links=" + links +
                ", createdOn='" + createdOn + '\'' +
                ", displayName='" + displayName + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
