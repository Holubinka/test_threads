package com.holubinka.test_threads.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "counter_log")
public class CounterInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime reachedAt;

    public CounterInformation(LocalDateTime reachedAt) {
        this.reachedAt = reachedAt;
    }

    public CounterInformation() {
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
