package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(Task("title", "desc", isCompleted = false))
        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
//        assertEquals(result.completedTasksPercent, 0f)
//        assertEquals(result.activeTasksPercent, 100f)

        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))

    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZero() {
        // Create an active task
        val tasks = listOf<Task>()
        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
//        assertEquals(result.completedTasksPercent, 0f)
//        assertEquals(result.activeTasksPercent, 100f)

        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))

    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        // Create an active task
        val tasks = listOf<Task>(Task("title", "desc", isCompleted = true))
        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
//        assertEquals(result.completedTasksPercent, 0f)
//        assertEquals(result.activeTasksPercent, 100f)

        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // Create an active task
        val tasks = listOf<Task>(Task("title", "desc", isCompleted = true))
        // Call your function
        val result = getActiveAndCompletedStats(null)
        // Check the result
//        assertEquals(result.completedTasksPercent, 0f)
//        assertEquals(result.activeTasksPercent, 100f)

        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        // Create an active task
        val tasks = listOf<Task>(Task("title", "desc", isCompleted = true),
                Task("title2", "des", isCompleted = true),
                Task("tit", "des", isCompleted = false),
                Task("tit", "des", isCompleted = false),
                Task("tit", "des", isCompleted = false))
        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
//        assertEquals(result.completedTasksPercent, 0f)
//        assertEquals(result.activeTasksPercent, 100f)

        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }
}