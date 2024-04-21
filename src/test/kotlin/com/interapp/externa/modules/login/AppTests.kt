package com.interapp.externa.modules.login

import com.interapp.externa.core.user.domain.User
import com.interapp.externa.modules.login.domain.AuthenticationResponse
import com.interapp.externa.modules.login.domain.RegisterRequest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
// Returns a ResponseEntity object, which contains not only the response body,
// but also the information about the status code, headers, and so on.
import org.springframework.boot.test.web.client.getForEntity
// Returns the response body as an object
//import org.springframework.boot.test.web.client.getForObject
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.boot.test.web.client.TestRestTemplate

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.test.context.support.WithMockUser

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class AppTests (@Autowired val client: TestRestTemplate) {
    private val url = "/api/v1/auth"

    @Test
    @WithMockUser()
    fun `testing if we can post a new user`() {
        val registerRequest = RegisterRequest("Lily", "lilys@gmail.com", "1234")

        val responseEntity = try {
            client.postForEntity<AuthenticationResponse>("$url/register", registerRequest)
        } catch (e: Exception) {
            // Handle the exception appropriately, like logging it
            fail<RegisterRequest>("Failed to register user", e)
            return
        }

        val registeredUser = responseEntity.body
        assertThat(registeredUser).isNotNull // Check if the registered user is not null
        val id = registeredUser!!.userId // Assuming id is a property of RegisterRequest

        val userResponseEntity: ResponseEntity<User> = try {
            client.getForEntity("$url/users/$id")
        } catch (e: Exception) {
            fail<User>("Failed to retrieve user", e)
            return
        }

        assertThat(userResponseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(userResponseEntity.body?.name).isEqualTo(registerRequest.username)
    }
}