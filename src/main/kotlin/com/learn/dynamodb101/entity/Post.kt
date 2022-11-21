package com.learn.dynamodb101.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.learn.dynamodb101.dto.PostRequestDto
import java.util.UUID

@DynamoDBTable(
    tableName = "nick"
)
class Post {
    @field:DynamoDBHashKey
    @field:DynamoDBAttribute(attributeName = "id")
    var id: Long? = null

    @field:DynamoDBAttribute(attributeName = "title")
    var title: String = ""

    constructor(post: PostRequestDto) {
        this.id = post.id
        this.title = post.title
    }
}
