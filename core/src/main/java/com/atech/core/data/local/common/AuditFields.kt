package com.atech.core.data.local.common

import androidx.room.ColumnInfo

data class AuditFields(
    @ColumnInfo(name = "created_at")
    val createdAt: Long,
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long? = null
)