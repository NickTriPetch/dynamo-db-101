package com.learn.dynamodb101.dto

import com.learn.dynamodb101.entity.Post

class PostResponseDto(
    val id: Long?,
    val title: String?,
) {
    constructor(post: Post) : this(
        id = post.id,
        title = post.title,
    )
}
