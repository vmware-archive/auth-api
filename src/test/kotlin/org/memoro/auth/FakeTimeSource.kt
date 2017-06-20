package org.memoro.auth

import org.joda.time.DateTime

class FakeTimeSource(private var fakeTime: DateTime) : TimeSource {
    override fun getDateTime(): DateTime {
        return this.fakeTime
    }
}