package com.learn.dynamodb101

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class DynamoDb101Application

fun main(args: Array<String>) {
    runApplication<DynamoDb101Application>(*args)
}
