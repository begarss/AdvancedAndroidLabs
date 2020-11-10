package com.raywenderlich.android.redditclone.models



data class Post(
    val author: Author,
    val category: Category,
    val date: String,
    val description: String,
    val id: Int,
    val is_published: Boolean,
    val title: String
)