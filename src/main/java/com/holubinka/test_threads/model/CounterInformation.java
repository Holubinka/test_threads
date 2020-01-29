package com.holubinka.test_threads.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CounterInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime reachedAt;

    public CounterInformation() {
        this.reachedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReachedAt() {
        return reachedAt;
    }

    public void setReachedAt(LocalDateTime reachedAt) {
        this.reachedAt = reachedAt;
    }
}
