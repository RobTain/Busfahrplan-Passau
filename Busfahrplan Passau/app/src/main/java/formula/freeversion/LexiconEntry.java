package formula.freeversion;


/**
 * Created by RobTain on 27.01.2016.
 */
public class LexiconEntry {
    private String title;
    private String description;
    private boolean premium;
    private String[] keywords;
    private Enum topic;

    public LexiconEntry(String title, String description, boolean premium, String[] keywords,
                        Topic topic) {
        this.title = title;
        this.description = description;
        this.premium = premium;
        this.keywords = keywords;
        this.topic = topic;

    }

    public Enum getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPremium() {
        return premium;
    }

    public String[] getKeywords() {
        return keywords;
    }

}
