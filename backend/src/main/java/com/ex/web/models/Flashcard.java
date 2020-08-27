package com.ex.web.models;

import javax.persistence.*;

@Entity
@Table(name = "FLASHCARDS")
public class Flashcard {
    @Id
    @Column(name="FLASHCARD_ID", columnDefinition="serial primary key")
    @GeneratedValue(strategy=GenerationType.IDENTITY) // the table creates this value
    private int id;

    @Column(name="FLASHCARD_QUESTION", nullable = false)
    private String question;
    @Column(name="FLASHCARD_ANSWER", nullable = false)
    private String answer;

  /*
    create table if not exist FLASHCARDS (
      flashcard_id serial,
      flashcard_question varchar(4000) not null,
      flashcard_answer varchar(4000) not null,
      primary key(flashcard_id)
    );
   */

    public Flashcard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
