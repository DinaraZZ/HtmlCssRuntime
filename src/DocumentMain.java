import javax.print.Doc;
import java.time.LocalDate;
import java.util.*;

public class DocumentMain {
    public static void main(String[] args) {
        Document d1 = new Document(LocalDate.of(2024, 06, 12), "efbgae");
        Document d2 = new Document(LocalDate.of(2002, 2, 1), "gaghh");
        Document d3 = new Document(LocalDate.of(1982, 6, 11), "stejhej");
        Document d4 = new Document(LocalDate.of(2002, 2, 13), "stejhej");
        Document[] documentArray = new Document[]{d1, d2, d3, d4};

//        groupDocumentsByYear(documentArray);

        DocumentHolder documentHolder = new DocumentHolder(documentArray);
        documentHolder.showDocuments();
    }

    static public void groupDocumentsByYear(Document... documentArray) {
        Map<Integer, List<Document>> documentMap = new TreeMap<>();
        for (Document document : documentArray) {
            int docYear = document.getDate().getYear();
            List<Document> documents;
            if (documentMap.get(docYear) == null) {
                documents = new ArrayList<>();
            } else {
                documents = documentMap.get(docYear);
            }
            documents.add(document);
            Collections.sort(documents);
            documentMap.put(docYear, documents);
        }

        var keys = documentMap.keySet();
        for (Integer key : keys) {
            System.out.println(key);
            List<Document> documents = documentMap.get(key);
            for (Document document : documents) {
                System.out.println("\t" + document.getDate() + ": " + document.getContent());
            }
            System.out.println();
        }
    }
}
