package com.example.backendapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "author_id")
    private long authorId;

    @Getter
    @Setter
    @Column(name = "date")
    private Date postDate;

    @Getter
    @Setter
    @Column(name = "title")
    private String postTitle;

    @Getter
    @Setter
    @Column(name = "group_id")
    private long postGroupId;

    @Getter
    @Setter
    @Column(name = "sent_by_admin")
    private boolean postSentByAdmin;
}
