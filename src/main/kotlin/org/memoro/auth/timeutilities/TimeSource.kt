package org.memoro.auth.timeutilities

interface TimeSource {
    fun getDateTime(): org.joda.time.DateTime
}