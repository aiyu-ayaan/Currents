package com.atech.core.data.local.common

import androidx.room.ColumnInfo

data class IconsFields(
    @ColumnInfo(name = "icon_name")
     val iconName : String,
    @ColumnInfo(name = "icon_color")
     var iconColor : Long,
    @ColumnInfo(name = "brand_color")
     val brandColor : Long
)
