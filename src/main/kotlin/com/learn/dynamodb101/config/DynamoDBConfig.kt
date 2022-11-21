package com.learn.dynamodb101.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter
import com.learn.dynamodb101.property.AmazonProperty
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Date
import java.util.TimeZone

@Configuration
@EnableDynamoDBRepositories(
    basePackages = ["com.learn.dynamodb101"],
)
class DynamoDBConfig(
    private val amazonProperties: AmazonProperty
) {
    companion object {
        class LocalDateTimeConverter : DynamoDBTypeConverter<Date, LocalDateTime> {
            override fun convert(source: LocalDateTime): Date {
                return Date.from(source.toInstant(ZoneOffset.UTC))
            }

            override fun unconvert(source: Date): LocalDateTime {
                return source.toInstant().atZone(TimeZone.getDefault().toZoneId()).toLocalDateTime()
            }
        }
    }
    @Primary
    @Bean
    fun dynamoDBMapper(amazonDynamoDB: AmazonDynamoDB): DynamoDBMapper {
        return DynamoDBMapper(amazonDynamoDB, DynamoDBMapperConfig.DEFAULT)
    }

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        val awsCredentials = BasicAWSCredentials(amazonProperties.accessKey, amazonProperties.secretKey)
        val awsCredentialsProvider = AWSStaticCredentialsProvider(awsCredentials)
        val endpointConfiguration = AwsClientBuilder.EndpointConfiguration(
            amazonProperties.dynamoDBEndpoint,
            amazonProperties.region,
        )
        return AmazonDynamoDBClientBuilder.standard()
            .withCredentials(awsCredentialsProvider)
            .withEndpointConfiguration(endpointConfiguration)
            .build()
    }

    @Bean
    fun awsCredentials() = BasicAWSCredentials(amazonProperties.accessKey, amazonProperties.secretKey)
}
