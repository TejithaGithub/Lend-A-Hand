package com.lendhand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lendhand.model.DonationsTable;

@Repository
public interface DonationRepository extends JpaRepository<DonationsTable, Long> {

    List<DonationsTable> findByDriveId(int id);

}
