package com.board_toy_project.repository;

import com.board_toy_project.domain.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaBoardRepository extends JpaRepository<BoardVO, Long> {
}
