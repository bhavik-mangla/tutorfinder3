package com.example.tutorfinder;

public class Tutors {

    private String Name;
    private String Class1;
    private String Locality;
    private String PastResults;
    private String Image1;
    private String Image2;
    private String Image3;
    private String Subject;
    private String PhoneNumber;
    private String Address;
    private String TeachingExperience;
    private String Rating;
    private String Review1;
    private String Review2;

    // Empty constructor required for Firestore
    public Tutors() {
    }

    // Constructor with parameters
    public Tutors(String name, String class1, String locality, String pastResults, String image1,
                  String image2, String image3, String subject, String phoneNumber, String address,
                  String teachingExperience, String rating, String review1, String review2) {
        this.Name = name;
        this.Class1 = class1;
        this.Locality = locality;
        this.PastResults = pastResults;
        this.Image1 = image1;
        this.Image2 = image2;
        this.Image3 = image3;
        this.Subject = subject;
        this.PhoneNumber = phoneNumber;
        this.Address = address;
        this.TeachingExperience = teachingExperience;
        this.Rating = rating;
        this.Review1 = review1;
        this.Review2 = review2;
    }

    // Getters and setters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getClass1() {
        return Class1;
    }

    public void setClass1(String class1) {
        this.Class1 = class1;
    }

    public String getLocality() {
        return Locality;
    }

    public void setLocality(String locality) {
        this.Locality = locality;
    }

    public String getPastResults() {
        return PastResults;
    }

    public void setPastResults(String pastResults) {
        this.PastResults = pastResults;
    }

    public String getImage1() {
        return Image1;
    }

    public void setImage1(String image1) {
        this.Image1 = image1;
    }

    public String getImage2() {
        return Image2;
    }

    public void setImage2(String image2) {
        this.Image2 = image2;
    }

    public String getImage3() {
        return Image3;
    }

    public void setImage3(String image3) {
        this.Image3 = image3;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        this.Subject = subject;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getTeachingExperience() {
        return TeachingExperience;
    }

    public void setTeachingExperience(String teachingExperience) {
        this.TeachingExperience = teachingExperience;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        this.Rating = rating;
    }

    public String getReview1() {
        return Review1;
    }

    public void setReview1(String review1) {
        this.Review1 = review1;
    }

    public String getReview2() {
        return Review2;
    }

    public void setReview2(String review2) {
        this.Review2 = review2;
    }

    //toMap() method
}
