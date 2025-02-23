package com.benion.examples.benionspringbootkotlin

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

class RestControllers {
}

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController {
    val articles = mutableListOf(Article("My Title", "my content"))

    @GetMapping
    fun articles() = articles

    @GetMapping("/{title}")
    fun articles(@PathVariable title: String) = articles.find {
        article -> article.slug == title
    } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping
    fun newArticle(@RequestBody article: Article): Article {
        articles.add(article)
        return article
    }

    @PutMapping("/{title}")
    fun updateArticle(@RequestBody article: Article, @PathVariable title: String): Article {
        val existingArticle = articles.find {
            it.slug == title
        } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        existingArticle.content = article.content;
        return article
    }

    @DeleteMapping("/{title}")
    fun deleteArticle(@PathVariable title: String) {
        articles.removeIf{
            article -> article.slug == title
        }
    }
}