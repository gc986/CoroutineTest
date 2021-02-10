package ru.gc986.model.wrappers

data class PaginationWrapper<E>(val res: List<E>?, val page: Int, val totalCount: Int, val totalPages: Int)