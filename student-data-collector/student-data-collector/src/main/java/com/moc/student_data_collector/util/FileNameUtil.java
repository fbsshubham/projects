package com.moc.student_data_collector.util;
public class FileNameUtil {
    public static String sanitize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String buildPhotoFilename(String rollNo, String studentName) {
        return sanitize(rollNo) + "_" + sanitize(studentName) + ".jpg";
    }
}
