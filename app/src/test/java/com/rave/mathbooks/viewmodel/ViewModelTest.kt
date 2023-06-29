package com.rave.mathbooks.viewmodel

import com.rave.mathbooks.model.MathRepo
import com.rave.mathbooks.model.local.Book
import com.rave.mathbooks.util.CoroutinesTestExtension
import com.rave.mathbooks.util.InstantTaskExecutorExtension
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.RegisterExtension

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(InstantTaskExecutorExtension::class)
internal class ViewModelTest {

    @RegisterExtension
    private val testExtension = CoroutinesTestExtension()
    private val repo: MathRepo = mockk()
    private val viewModel = MathViewModel(repo)

    @Test
    fun testGetMathBooks() = runTest(testExtension.dispatcher) {
        // Given
        val expectedResult = listOf(
            Book(
                title = "Calculus"
            )
        )

        // When
        coEvery { repo.getMathBooks() } coAnswers { expectedResult }
        // viewModel.getMathBooks()
        val result = viewModel.books.value

        // Then
        Assertions.assertEquals(expectedResult, result)
    }
}
