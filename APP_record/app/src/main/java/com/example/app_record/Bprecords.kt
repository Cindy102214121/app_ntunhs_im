package com.example.app_record

import java.time.chrono.ChronoLocalDateTime

data class Bprecords(
    val bprecords: List<bprecord>
)

data class bprecord(
    val dateTime: String,
    val sys:Int,
    val dia:Int,
    val hr:Int
)