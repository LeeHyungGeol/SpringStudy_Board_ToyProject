package com.board_toy_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

//JPA 엔티티 매핑
@Entity
@Getter @Setter
public class BoardVO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB에 값을 넣으면, DB가 자동으로 Id를 생성해주는 것을 "Identity 전략" 이라고 한다.
    private int id;
    private String title;
    private String content;
    private String writer;
    private Timestamp timestamp;

    public BoardVO() {}

    public BoardVO(int id, String title, String content, String writer, Timestamp timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.timestamp = timestamp;
    }
}
