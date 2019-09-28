package com.swappy.makeathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swappy.makeathon.entity.HistoricUsageDataEntity;
import com.swappy.makeathon.entity.HistoricUsageDataKey;

@Repository
public interface HistoricUsageRepository extends JpaRepository<HistoricUsageDataEntity, HistoricUsageDataKey> {
	public List<HistoricUsageDataEntity> findByDataKey_DeviceId(String deviceId);
}
