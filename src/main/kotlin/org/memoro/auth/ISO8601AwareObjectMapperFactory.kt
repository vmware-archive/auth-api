package org.memoro.auth

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import java.text.SimpleDateFormat
import java.util.*

class ISO8601AwareObjectMapperFactory {
    companion object Factory {
        fun instance(): ObjectMapper {
            val objectMapper = ObjectMapper()
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            dateFormat.timeZone = TimeZone.getDefault()
            objectMapper.dateFormat = dateFormat

            return objectMapper
        }
    }
}