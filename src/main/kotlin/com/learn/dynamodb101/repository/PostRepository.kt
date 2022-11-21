package com.learn.dynamodb101.repository

import com.learn.dynamodb101.entity.Post
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<Post, String>
