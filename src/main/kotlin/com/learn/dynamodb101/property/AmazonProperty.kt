package com.learn.dynamodb101.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "amazon-properties")
data class AmazonProperty(
    val enabled: Boolean,
    val accessKey: String,
    val secretKey: String,
    val dynamoDBEndpoint: String,
    val bucketName: String,
    val region: String,
)
