package com.swappy.makeathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swappy.makeathon.entity.PlaylistEntity;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, String>  {
	
}
