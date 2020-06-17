package com.hibernatedemo.company.fileupload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentFileRepository extends JpaRepository<ContentFile, Integer> {
}
