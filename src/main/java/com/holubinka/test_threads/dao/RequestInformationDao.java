package com.holubinka.test_threads.dao;

import com.holubinka.test_threads.model.RequestInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestInformationDao extends JpaRepository<RequestInformation, Long> {
}
