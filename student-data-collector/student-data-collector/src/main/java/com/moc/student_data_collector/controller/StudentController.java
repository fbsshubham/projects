package com.moc.student_data_collector.controller;

import com.moc.student_data_collector.entity.Student;
import com.moc.student_data_collector.repository.StudentRepository;
import com.moc.student_data_collector.util.FileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // ✅ Save new student
    @PostMapping("/save")
    public String saveStudent(
            @RequestParam String rollNo,
            @RequestParam String studentName,
            @RequestParam String batchName,
            @RequestParam String moduleName,
            @RequestParam String mockNo,
            @RequestParam(required = false) String testDate, // optional, default to today
            @RequestParam String photoBase64
    ) {
        try {
            if (photoBase64.startsWith("data:image")) {
                photoBase64 = photoBase64.substring(photoBase64.indexOf(",") + 1);
            }

            String fileName = FileNameUtil.buildPhotoFilename(rollNo, studentName);
            byte[] photoBytes = Base64.getDecoder().decode(photoBase64);

            LocalDate date = (testDate != null && !testDate.isEmpty()) 
                    ? LocalDate.parse(testDate) 
                    : LocalDate.now();

            Student student = new Student(
                    rollNo,
                    studentName,
                    batchName,
                    moduleName,
                    mockNo,
                    date,
                    fileName,
                    photoBytes
            );

            studentRepository.save(student);

            return "✅ Student saved: " + studentName;

        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }

    // ✅ Export all photos
    @GetMapping("/getallphotos")
    public String getAllPhotos(
            @RequestParam String batchName,
            @RequestParam String moduleName,
            @RequestParam String mockNo
    ) {
        try {
            List<Student> data = studentRepository.findAll();
            String fullPath = "D:\\" + batchName + "\\" + moduleName + "\\" + mockNo + "\\";

            File dir = new File(fullPath);
            if (!dir.exists()) dir.mkdirs();

            for (Student s : data) {
                String fileName = FileNameUtil.buildPhotoFilename(s.getRollNo(), s.getStudentName());
                try (FileOutputStream fos = new FileOutputStream(fullPath + fileName)) {
                    fos.write(s.getPhotoBytes());
                }
            }

            return "✅ All photos saved to: " + fullPath;
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }
}
