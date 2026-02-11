package com.bor96dev.hwflow

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun titleDisplayed() {
        composeTestRule.onNodeWithText("Все города:").assertExists()
    }

    @Test
    fun citiesAreLoaded() {
        composeTestRule.waitUntil(3_000) {
            composeTestRule
                .onAllNodes(hasText("Tokyo - Asia"))
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule.onNodeWithText("Tokyo - Asia").assertExists()
    }
}