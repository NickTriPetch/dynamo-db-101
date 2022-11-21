package com.learn.dynamodb101.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.learn.dynamodb101.dto.PostRequestDto
import com.learn.dynamodb101.dto.PostResponseDto
import com.learn.dynamodb101.property.AmazonProperty
import com.learn.dynamodb101.service.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class PostController(
    val postService: PostService,
    val amazonProperty: AmazonProperty,
) {
    @GetMapping(
        path = ["/post/test"]
    )
    fun testSomething() {
        println(ObjectMapper().writeValueAsString(amazonProperty))

        println("Hello")
    }

    @PostMapping(
        path = ["/post"],
        consumes = ["application/json"],
        produces = ["application/json; charset=UTF-8"]
    )
    fun create(@RequestBody post: PostRequestDto): PostResponseDto {
        return postService.create(post)
    }
}
