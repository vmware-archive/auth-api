package org.memoro.auth

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*

@RestController
class TokenController(
        private val timeSource: TimeSource = RealTimeSource()
) {

    @RequestMapping(path = arrayOf("/token"), method = arrayOf(RequestMethod.POST))
    fun createToken(): String {
        val objectMapper = ObjectMapper()
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        dateFormat.timeZone = TimeZone.getDefault()
        objectMapper.dateFormat = dateFormat

        val tokenGroupJson = objectMapper.writeValueAsString(
                TokenGroup("MyAccessToken", "MyRefreshToken", this.timeSource.getDateTime().toDate())
        )

        return tokenGroupJson
    }
}

