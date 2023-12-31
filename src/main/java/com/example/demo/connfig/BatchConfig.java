package com.example.demo.connfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.batch.BatchClient;

@Configuration
public class BatchConfig {
	
	@Value("${cloud.aws.credentials.access-key}")
	private String accessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String secretKey;

	@Value("${cloud.aws.region.static}")
	private String region;

	@Bean
	public BatchClient batchClient() {

		AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
		StaticCredentialsProvider provider = StaticCredentialsProvider.create(credentials);

		return BatchClient.builder()
				.credentialsProvider(provider)
				.region(Region.AP_NORTHEAST_1) 
				.build();
	}

}
