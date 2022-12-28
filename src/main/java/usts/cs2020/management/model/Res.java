package usts.cs2020.management.model;

import javax.persistence.*;

@Entity
@Table(name = "response")
public class Res {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private String question;
    private String initiator;
    private String response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", question='" + question + '\'' +
                ", initiator='" + initiator + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
