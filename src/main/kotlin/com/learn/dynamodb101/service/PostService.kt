package com.learn.dynamodb101.service

import com.learn.dynamodb101.dto.PostRequestDto
import com.learn.dynamodb101.dto.PostResponseDto
import com.learn.dynamodb101.entity.Post
import com.learn.dynamodb101.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) : IPostService {
    override fun create(post: PostRequestDto): PostResponseDto {
        val createdPost = postRepository.save(Post(post))

        return PostResponseDto(createdPost)
    }

}
