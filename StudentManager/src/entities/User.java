package entities;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class User{

    protected String code;
    protected String name;
    protected String birthDay;
    protected String gender;
    protected String address;
    protected String email;
    protected String password;
    protected Role role;
    protected boolean isDeleted;

    protected double mathScore = 0;
    protected double englishScore= 0;
    protected double literatureScore= 0;
    protected Map<String, Double> additionalScores;
    Set<String> specialSubjects;


    public User(String code, String name, String birthDay, String gender, String address, String email, String password, Role role, boolean isDeleted, double mathScore, double englishScore, double literatureScore) {
        this.code = code;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isDeleted = isDeleted;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.literatureScore = literatureScore;
        this.additionalScores = new HashMap<>();
        this.specialSubjects = new HashSet<>();
    }

    public String getCode() {
        return code;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }

    public Role getRole(){
        return role;
    }
    public boolean isDeleted(){ return isDeleted;}
    public void setDeleted(boolean deleted)
    {
        isDeleted=deleted;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getLiteratureScore() {
        return literatureScore;
    }

    public void setLiteratureScore(double literatureScore) {
        this.literatureScore = literatureScore;
    }
    public void addSpecialSubject(String subjectName) {
        specialSubjects.add(subjectName);
    }

    public Set<String> getSpecialSubjects() {
        return specialSubjects;
    }

    public void setAdditionalScore(String subjectName, double score) {
        additionalScores.put(subjectName, score);
    }

    public Map<String, Double> getAdditionalScores() {
        return additionalScores;
    }
    public boolean checkEmailPassword(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
    public double calculateAverageScore() {
        double totalScore = mathScore + literatureScore + englishScore;
        int count = 3; // Start with 3 fixed subjects

        // Add additional scores
        for (Double score : additionalScores.values()) {
            totalScore += score;
            count++;
        }

        return count > 0 ? totalScore / count : 0; // Avoid division by zero
    }

}
