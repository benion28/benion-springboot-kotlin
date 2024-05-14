package com.benion.examples.benionspringbootkotlin

import java.time.LocalDateTime

data class Article(
    val title: String,
//    val title: String?,
    var content: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),

// https://blog/my-first-title My First Title
//    val slug: String? = title?.toSlug()
    val slug: String = title.toSlug()
)
