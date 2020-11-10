package com.raywenderlich.android.redditclone.models

data class Author(
    val email: String,
    val id: Int,
    val is_superuser: Boolean,
    val username: String,
    val profile_pic: String
)