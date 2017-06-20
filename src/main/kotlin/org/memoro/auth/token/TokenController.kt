package org.memoro.auth.token

import org.memoro.auth.timeutilities.ISO8601AwareObjectMapperFactory
import org.memoro.auth.timeutilities.RealTimeSource
import org.memoro.auth.timeutilities.TimeSource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class TokenController(
        private val timeSource: TimeSource = RealTimeSource()
) {

    @RequestMapping(path = arrayOf("/token"), method = arrayOf(RequestMethod.POST))
    fun createToken(): String {
        val objectMapper = ISO8601AwareObjectMapperFactory.instance()

        val tokenGroupJson = objectMapper.writeValueAsString(
                TokenGroup("MyAccessToken", "MyRefreshToken", this.timeSource.getDateTime().toDate())
        )

        return tokenGroupJson
    }
}

