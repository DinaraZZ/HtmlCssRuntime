import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentHolder {
    private List<Document> documents;

    public DocumentHolder() {
        this.documents = new ArrayList<>();
    }

    public DocumentHolder(Document document) {
        this.documents = new ArrayList<>();
        this.documents.add(document);
    }

    public DocumentHolder(Document... documents) {
        this.documents = new ArrayList<>();
        for (Document document : documents) {
            addDocument(document);
        }
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void addDocument(Document document) {
        int year = document.getDate().getYear();
        int month = document.getDate().getMonthValue();
        boolean exists = false;

        if (documents != null) {
            for (Document documentObj : documents) {
                int docYear = documentObj.getDate().getYear();
                int docMonth = documentObj.getDate().getMonthValue();

                if (year == docYear && month == docMonth) {
                    exists = true;
                    break;
                }
            }

            if (!exists) documents.add(document);
        } else {
            documents.add(document);
        }
    }

    public void showDocuments() {
        Collections.sort(documents);
        for (Document document : documents) {
            System.out.println(document.getDate() + ": " + document.getContent());
        }
    }
}
