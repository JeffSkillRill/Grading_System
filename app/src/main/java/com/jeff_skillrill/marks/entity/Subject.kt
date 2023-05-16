package com.jeff_skillrill.marks.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    var subject_id: Int = 0,
    var subject_name: String
)