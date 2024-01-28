package models.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Quiz implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private User owner;
    private Date createdAt;
    private Date updatedAt;
    private boolean isPrivate;
    private List<Question> questions = new ArrayList<>();

    public Quiz(Integer id, User owner, Date createdAt, Date updatedAt, boolean isPrivate, List<Question> questions) {
        this.id = id;
        this.owner = owner;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isPrivate = isPrivate;
        this.questions = questions;
    }

    public Quiz() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", owner=" + owner +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isPrivate=" + isPrivate +
                ", questions=" + questions +
                '}';
    }
}
