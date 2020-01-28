package com.holubinka.test_threads.dao;

import com.holubinka.test_threads.model.CounterInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterInformationDao extends JpaRepository<CounterInformation, Long> {
}
