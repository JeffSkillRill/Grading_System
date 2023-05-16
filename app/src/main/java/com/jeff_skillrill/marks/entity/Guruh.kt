package com.jeff_skillrill.marks.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guruhlar")
data class Guruh(
    @PrimaryKey(autoGenerate = true)
    var guruh_id:  Int = 0,
    var sinf_name: String
)
