package com.rave.mathbooks.model

import com.rave.mathbooks.model.local.Book
import com.rave.mathbooks.model.remote.APIService
import com.rave.mathbooks.model.remote.dtos.BookDTO
import com.rave.mathbooks.model.remote.dtos.MathResponse
import com.rave.mathbooks.util.CoroutinesTestExtension
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

@OptIn(ExperimentalCoroutinesApi::class)
internal class RepoTest {

    @RegisterExtension
    private val testExtension = CoroutinesTestExtension()
    private val service: APIService = mockk()
    private val repo = MathRepo(service)

    @Test
    fun testGetMathBooks() = runTest(testExtension.dispatcher) {
        // Given
        val serviceResult = MathResponse(
            key = null,
            name = null,
            subject_type = null,
            work_count = null,
            works = listOf(
                BookDTO(
                    authors = null,
                    availability = null,
                    cover_edition_key = null,
                    cover_id = null,
                    edition_count = null,
                    first_publish_year = null,
                    has_fulltext = null,
                    ia = null,
                    ia_collection = null,
                    key = null,
                    lending_edition = null,
                    lending_identifier = null,
                    lendinglibrary = null,
                    printdisabled = null,
                    public_scan = null,
                    subject = null,
                    title = "Calculus"
                )
            )
        )
        val expectedResult = listOf(
            Book(
                title = "Calculus"
            )
        )

        // When
        coEvery { service.getMathBooks() } coAnswers { serviceResult }
        val result = repo.getMathBooks()

        // Then
        Assertions.assertEquals(expectedResult, result)
    }
}
