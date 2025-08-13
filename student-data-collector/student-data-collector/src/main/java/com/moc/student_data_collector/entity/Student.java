package com.moc.student_data_collector.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "students")
public class Student {
    @Id
    private String rollNo;

    private String studentName;

    private String batchName;

    private String moduleName;

    private String mockNo;

    private LocalDate testDate; 

    private String photoFilename;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] photoBytes;

    public Student() {}

    public Student(String rollNo, String studentName, String batchName, String moduleName,
                   String mockNo, LocalDate testDate, String photoFilename, byte[] photoBytes) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.batchName = batchName;
        this.moduleName = moduleName;
        this.mockNo = mockNo;
        this.testDate = testDate;
        this.photoFilename = photoFilename;
        this.photoBytes = photoBytes;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getMockNo() {
        return mockNo;
    }

    public void setMockNo(String mockNo) {
        this.mockNo = mockNo;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getPhotoFilename() {
        return photoFilename;
    }

    public void setPhotoFilename(String photoFilename) {
        this.photoFilename = photoFilename;
    }

    public byte[] getPhotoBytes() {
        return photoBytes;
    }

    public void setPhotoBytes(byte[] photoBytes) {
        this.photoBytes = photoBytes;
    }
}
