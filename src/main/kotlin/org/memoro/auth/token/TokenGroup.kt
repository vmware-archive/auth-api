package org.memoro.auth.token

import java.util.*

data class TokenGroup(
        val accessToken: String,
        val refreshToken: String,
        val expires: Date
)
