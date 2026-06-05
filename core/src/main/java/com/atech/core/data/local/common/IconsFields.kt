package com.atech.core.data.local.common

import androidx.room.ColumnInfo

data class IconsFields(
    @ColumnInfo(name = "icon_name")
    private val iconName : String,
    @ColumnInfo(name = "icon_color")
    private var iconColor : Long,
    @ColumnInfo(name = "brand_color")
    private val brandColor : Long
)
