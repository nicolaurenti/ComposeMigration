package com.example.composemigration.ui.components.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import com.example.composemigration.ui.UIConstants.EMPTY_STRING

@Composable
fun MigrationButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    layoutId: String = EMPTY_STRING,
    buttonText: String = EMPTY_STRING,
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.layoutId(layoutId),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
    ) {
        Text(text = buttonText)
    }
}

@Composable
@Preview
private fun ButtonPreview() {
    Column {
        MigrationButton(
            onClick = {},
            Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            layoutId = EMPTY_STRING,
            buttonText = "Go to next screen",
        )
    }
}
