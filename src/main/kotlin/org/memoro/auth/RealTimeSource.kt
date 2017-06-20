package org.memoro.auth

class RealTimeSource: TimeSource {
    override fun getDateTime(): org.joda.time.DateTime {
        return org.joda.time.DateTime()
    }
}