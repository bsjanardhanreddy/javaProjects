package com.jsp.workqueue.entity;

import java.math.BigInteger;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//@Getter
//@Setter
//@AllArgsConstructor
//or
@Data
@Entity
@Table(name="channel_info")
public class ChannelEntity 
{
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="alt_key")
	private BigInteger altKey;
	
	@Column(name="config_name")
	private String configName;
	
	@Column(name="channel_type")
	private String type;
	
	@Column(name="region")
	private String region;
	
	@Column(name="api_key")
	private String apiKey;
	
	@Column(name="secret_Key")
	private String secretKey;
	
	@Column(name="is_Active")
	private boolean isActive;
	
	@Column(name="creted_date")
	private Date cretedDate;
	
	@Column(name="modified_date")
	private Date modifiedDate;
	
	
}
