package com.example.songs.home.data



data class SongModel (
    val resultCount: Long,
    val results: List<Result>
)

data class Result (

    val artistID: Long? = null,
    val collectionID: Long? = null,
    val trackID: Long? = null,
    val artistName: String,
    val collectionName: String? = null,
    val trackName: String? = null,
    val collectionCensoredName: String? = null,
    val trackCensoredName: String? = null,
    val artistViewURL: String? = null,
    val collectionViewURL: String? = null,
    val trackViewURL: String? = null,
    val previewURL: String? = null,
    val artworkUrl30: String? = null,
    val artworkUrl60: String,
    val artworkUrl100: String,
    val collectionPrice: Double? = null,
    val trackPrice: Double? = null,
    val releaseDate: String,

    val discCount: Long? = null,
    val discNumber: Long? = null,
    val trackCount: Long? = null,
    val trackNumber: Long? = null,
    val trackTimeMillis: Long? = null,

    val primaryGenreName: String,
    val isStreamable: Boolean? = null,
    val collectionArtistID: Long? = null,
    val collectionArtistViewURL: String? = null,
    val trackRentalPrice: Double? = null,
    val collectionHDPrice: Double? = null,
    val trackHDPrice: Double? = null,
    val trackHDRentalPrice: Double? = null,
    val longDescription: String? = null,
    val hasITunesExtras: Boolean? = null,
    val shortDescription: String? = null,
    val description: String? = null,
    val copyright: String? = null,
    val collectionArtistName: String? = null,
    val feedURL: String? = null,
    val artworkUrl600: String? = null,
    val genreIDS: List<String>? = null,
    val genres: List<String>? = null
)