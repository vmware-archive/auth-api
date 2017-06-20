package org.memoro.auth

import org.hamcrest.Matchers.`is`
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.junit.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class TokenControllerTest {
    private var mockMvc: MockMvc? = null

    @Test
    fun token_POST_returnsTokenGroup() {
        val date = DateTime()
        val fakeTimeSource = FakeTimeSource(date)
        val accountController = TokenController(fakeTimeSource)
        val dateToString = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ").print(date)
        mockMvc = standaloneSetup(accountController).build()

        val result = mockMvc?.perform(post("/token"))

        result?.andExpect(
                jsonPath("$.accessToken", `is`("MyAccessToken"))
        )?.andExpect(
                jsonPath("$.refreshToken", `is`("MyRefreshToken"))
        )?.andExpect(
                jsonPath("$.expires", `is`(dateToString))
        )
    }
}