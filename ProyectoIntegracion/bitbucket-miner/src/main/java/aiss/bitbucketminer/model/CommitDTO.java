package aiss.bitbucketminer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import aiss.bitbucketminer.model.dependencies.Author;
import aiss.bitbucketminer.model.dependencies.Repository;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitDTO {
    @JsonProperty("hash")
    private String hash;

    @JsonProperty("message")
    private String message;

    @JsonProperty("date")
    private String date;

    @JsonProperty("author")
    private Author author;

    @JsonProperty("repository")
    private Repository repository;

    public String getHash() { return hash; }

    public void setHash(String hash) { this.hash = hash; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public Author getAuthor() { return author; }

    public void setAuthor(Author author) { this.author = author; }

    public Repository getRepository() { return repository; }

    public void setRepository(Repository repository) { this.repository = repository; }

    @Override
    public String toString() {
        return "CommitDTO{" +
                "hash='" + hash + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", author=" + author +
                ", repository=" + repository +
                '}';
    }
}
