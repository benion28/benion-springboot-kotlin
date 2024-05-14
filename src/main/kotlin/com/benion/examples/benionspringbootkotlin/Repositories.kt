package com.benion.examples.benionspringbootkotlin

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ArticleRepository: JpaRepository<Article, Long> {
    fun findAllByOrderByCreatedAtDesc(): Iterable<Article>
    fun findBySlug(slug: String): Optional<Article>
}