package com.raywenderlich.android.redditclone.models

data class DjangoPostListing(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<Post>?
)