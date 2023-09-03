package com.parce.proyectofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.parce.proyectofinal.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitValue() = runTest{
        assertEquals(null,viewModel.stringCompare.value)
    }

    @Test
    fun mainViewModel_CompareEqualStrings() = runTest {
        val text1 = "digitall-Soft"
        val text2 = "digitall-Soft"
        launch {
            viewModel.compareStrings(text1,text2)
        }
        advanceUntilIdle()
        val comp = viewModel.stringCompare.value?.compareResult
        assertTrue(comp!!)
    }

    @Test
    fun mainViewModel_CompareDistincStrings() = runTest {
        val text1 = "digitall-soft"
        val text2 = "digital-soft"

        launch{
            viewModel.compareStrings(text1,text2)
        }
        advanceUntilIdle()
        val comp = viewModel.stringCompare.value?.compareResult
        assertFalse(comp!!)
    }


}