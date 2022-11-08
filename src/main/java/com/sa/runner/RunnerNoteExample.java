package com.sa.runner;

import com.aspose.note.Document;
import com.aspose.note.SaveFormat;

import java.io.IOException;

public class RunnerNoteExample {
    public static void main(String[] args) {
        Document noteDocument = new Document("weekly_assignments.one");
        try {
            System.out.println(noteDocument.getFirstChild().getAuthor());
            System.out.println(noteDocument.getFirstChild().getTitle().getTitleText().getText());

            noteDocument.save("output.jpg", SaveFormat.Jpeg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
