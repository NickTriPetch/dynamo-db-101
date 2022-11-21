package com.learn.dynamodb101.service

import com.learn.dynamodb101.dto.PostRequestDto
import com.learn.dynamodb101.dto.PostResponseDto

interface IPostService {
    fun create(post: PostRequestDto): PostResponseDto
}
