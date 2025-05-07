package aiss.githubminer.model.commitDependencies;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitAuthorDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("date")
    private String date;

    public CommitAuthorDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    @Override
    public String toString() {
        return String.format("CommitAuthorDTO{name='%s', email='%s', date='%s'}", name, email, date);
    }
}