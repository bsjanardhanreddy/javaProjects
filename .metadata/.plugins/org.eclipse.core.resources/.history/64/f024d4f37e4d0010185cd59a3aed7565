package com.jsp.workqueue.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.workqueue.entity.ChannelEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelEntity, BigInteger>
{
	
	@Query(value = "from ChannelEntity where configName=:cName and type=:cType")
	List<ChannelEntity> getChannelByConfigNameAndType(@Param(value = "cName") String configName,@Param(value = "cType")String type);
	List<ChannelEntity> findByConfigNameAndType( String configName,String type);
	
	@Query(value = "from ChannelEntity where configName in :configList")
	//List<ChannelEntity> getChannelByConfigs(@Param(value = "configList") List<String> configList);
	List<ChannelEntity> getChannelByConfigs( List<String> configList);
	List<ChannelEntity> findByConfigNameIn( List<String> configList);

	@Query(value = "from ChannelEntity where region=:region and configName=:configName")
	List<ChannelEntity> getChannelByRegionAndConfigName(@Param(value = "region") String region,@Param(value = "configName")String configName);
	List<ChannelEntity> findByRegionAndConfigName(String region,String configName);
	
	@Modifying
	@Transactional
	@Query("UPDATE ChannelEntity c SET " +
	       "c.configName = :configName, " +
	       "c.apiKey = :apiKey, " +
	       "c.secretKey = :secretKey, " +
	       "c.modifiedDate = :modifiedDate " +
	       "WHERE c.altKey = :altKey")
	int updateFieldsByAltKey(@Param("configName") String configName,
	                         @Param("apiKey") String apiKey,
	                         @Param("secretKey") String secretKey,
	                         @Param("modifiedDate") Date modifiedDate,
	                         @Param("altKey") BigInteger altKey);
	

	@Modifying
	@Transactional
	@Query("UPDATE ChannelEntity c SET"
			+ " c.isActive = :status,"
			+ " c.modifiedDate = :modifiedDate"
			+ " WHERE c.altKey = :altKey")
	int updateChannelStatus(
							@Param("status") boolean status,
	                        @Param("modifiedDate") Date modifiedDate,
							@Param("altKey") BigInteger altKey);

}
