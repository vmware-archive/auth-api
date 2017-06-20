package org.memoro.auth.timeutilities

import org.assertj.core.api.Assertions.assertThat
import org.joda.time.DateTime
import org.junit.Test
import java.util.*

class ISO8601AwareObjectMapperFactoryTest {
    @Test
    fun createsObjectMapper_thatCanParseDate_withTimeZone() {
        val dateString = "2017-06-20T15:00:00+0900"
        val dateTime = DateTime.parse(dateString)
        val testObject = TestObject(dateTime.toDate())


        val actual = ISO8601AwareObjectMapperFactory.instance().writeValueAsString(testObject)


        val expected = "{\"date\":\"$dateString\"}"
        assertThat(actual).isEqualTo(expected)
    }
}

private data class TestObject(val date: Date)