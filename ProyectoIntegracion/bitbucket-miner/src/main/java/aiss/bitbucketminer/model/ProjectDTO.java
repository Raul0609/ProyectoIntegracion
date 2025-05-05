package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import aiss.bitbucketminer.model.dependencies.Links;
import aiss.bitbucketminer.model.dependencies.Owner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO {
    @JsonProperty("type")
    private String type;

    @JsonProperty("links")
    private Links links;

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("key")
    private String key;

    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("is_private")
    private boolean isPrivate;

    @JsonProperty("created_on")
    private String createdOn;

    @JsonProperty("updated_on")
    private String updatedOn;

    @JsonProperty("has_publicly_visible_repos")
    private boolean hasPubliclyVisibleRepos;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Links getLinks() { return links; }
    public void setLinks(Links links) { this.links = links; }

    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isPrivate() { return isPrivate; }
    public void setPrivate(boolean isPrivate) { this.isPrivate = isPrivate; }

    public String getCreatedOn() { return createdOn; }
    public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

    public String getUpdatedOn() { return updatedOn; }
    public void setUpdatedOn(String updatedOn) { this.updatedOn = updatedOn; }

    public boolean isHasPubliclyVisibleRepos() { return hasPubliclyVisibleRepos; }
    public void setHasPubliclyVisibleRepos(boolean hasPubliclyVisibleRepos) { this.hasPubliclyVisibleRepos = hasPubliclyVisibleRepos; }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "type='" + type + '\'' +
                ", links=" + links +
                ", uuid='" + uuid + '\'' +
                ", key='" + key + '\'' +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isPrivate=" + isPrivate +
                ", createdOn='" + createdOn + '\'' +
                ", updatedOn='" + updatedOn + '\'' +
                ", hasPubliclyVisibleRepos=" + hasPubliclyVisibleRepos +
                '}';
    }
}
