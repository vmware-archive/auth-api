package org.memoro.auth

interface TimeSource {
    fun getDateTime(): org.joda.time.DateTime
}