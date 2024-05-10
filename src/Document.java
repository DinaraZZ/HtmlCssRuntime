import java.time.LocalDate;

public class Document implements Comparable<Document> {
    private LocalDate date;
    private String content;

    public Document(String content) {
        this.content = content;
        this.date = LocalDate.now();
    }

    public Document(LocalDate date, String content) {
        this.date = date;
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    @Override
    public int compareTo(Document o) {
        return this.date.compareTo(o.getDate());
    }
}
