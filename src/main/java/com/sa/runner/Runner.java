package com.sa.runner;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        // This example demonstrates adding area annotation.

        // Create an instance of Reply class and add comments
        Reply reply1 = new Reply();
        reply1.setComment("First comment");
        reply1.setRepliedOn(Calendar.getInstance().getTime());

        Reply reply2 = new Reply();
        reply2.setComment("Second comment");
        reply2.setRepliedOn(Calendar.getInstance().getTime());

        List<Reply> replies =  new ArrayList<Reply>();
        replies.add(reply1);
        replies.add(reply2);

        // Create an instance of Annotator class
        Annotator annotator = new Annotator("inputPath");
        try {
            // Create an instance of AreaAnnotation class and set options
            AreaAnnotation area = new AreaAnnotation();
            area.setBackgroundColor(65535);
            area.setBox(new Rectangle(100, 100, 100, 100));
            area.setCreatedOn(Calendar.getInstance().getTime());
            area.setMessage("This is area annotation");
            area.setOpacity(0.7);
            area.setPageNumber(0);
            area.setPenColor(65535);
            area.setPenStyle(PenStyle.Dot);
            area.setPenWidth((byte) 3);
            area.setReplies(replies);

            // Add annotation and save to file
            annotator.add(area);
            annotator.save("outputPath");
        } finally {
            if (annotator != null) {
                annotator.dispose();
            }
        }
    }
}
