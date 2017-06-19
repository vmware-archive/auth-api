import org.hamcrest.Matchers.containsString
import org.junit.Test
import org.memoro.account.AccountController
import org.memoro.account.Greeting
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class AccountControllerTest {

    private var mockMvc: MockMvc? = null

    @Test
    fun getAccountByIdTest() {
        val accountController = mock(AccountController::class.java)
        `when`(accountController.greeting(ArgumentMatchers.anyString())).thenReturn(Greeting(1, "Test World"))

        mockMvc = standaloneSetup(accountController).build()
        val result = mockMvc?.perform(get("/account"))

        result?.andExpect(content().string(containsString("Test World")))
    }
}