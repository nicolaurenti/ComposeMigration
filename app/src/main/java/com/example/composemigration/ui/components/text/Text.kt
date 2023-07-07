package com.example.composemigration.ui.components.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.example.composemigration.ui.Dimens.FONT_SIZE_DEFAULT
import com.example.composemigration.ui.UIConstants.EMPTY_STRING

@Composable
fun MigrationTitle(
    text: String,
    modifier: Modifier = Modifier,
    layoutId: String = EMPTY_STRING,
    fontSize: TextUnit = FONT_SIZE_DEFAULT,
) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth().wrapContentHeight().background(Color.Gray)
            .layoutId(layoutId),
        fontFamily = FontFamily.Cursive,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        fontSize = fontSize,
    )
}

@Preview
@Composable
private fun TextsPreview() {
    Column {
        MigrationTitle(text = "hello migration")
    }
}
