package aiss.bitbucketminer.model.dependencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
    @JsonProperty("raw")
    private String raw;

    @JsonProperty("markup")
    private String markup;

    @JsonProperty("html")
    private String html;

    public String getRaw() { return raw; }
    public void setRaw(String raw) { this.raw = raw; }

    public String getMarkup() { return markup; }
    public void setMarkup(String markup) { this.markup = markup; }

    public String getHtml() { return html; }
    public void setHtml(String html) { this.html = html; }

    @Override
    public String toString() {
        return "Content{" +
                "raw='" + raw + '\'' +
                ", markup='" + markup + '\'' +
                ", html='" + html + '\'' +
                '}';
    }
}
