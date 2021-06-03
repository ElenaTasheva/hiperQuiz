package model;

import model.enums.Gender;
import model.enums.Role;

import java.util.List;

public class User extends BaseEntity<Long, User> {

    private String username;
    private String email;
    private String password;
    private Gender gender;
    private Role role = Role.PLAYER;
    private String picture;
    private String description;
    private String metadata;
    private boolean status;
    private List<Quiz> quizzes;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("User{");
//        sb.append("created=").append(getCreated());
//        sb.append(", id=").append(getId());
//        sb.append(", username='").append(username).append('\'');
//        sb.append(", email='").append(email).append('\'');
//        sb.append(", password='").append(password).append('\'');
//        sb.append(", gender=").append(gender);
//        sb.append(", role=").append(role);
//        sb.append(", picture='").append(picture).append('\'');
//        sb.append(", description='").append(description).append('\'');
//        sb.append(", metadata='").append(metadata).append('\'');
//        sb.append(", status=").append(status);
//        sb.append(", quizzes=").append(quizzes);
//        sb.append('}');
//        return sb.toString();
//    }


    // only for presentation purpose (report)
    @Override
    public String toString() {
      return username;
    }
}
