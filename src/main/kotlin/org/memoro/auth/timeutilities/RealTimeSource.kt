package org.memoro.auth.timeutilities

class RealTimeSource: TimeSource {
    override fun getDateTime(): org.joda.time.DateTime {
        return org.joda.time.DateTime()
    }
}