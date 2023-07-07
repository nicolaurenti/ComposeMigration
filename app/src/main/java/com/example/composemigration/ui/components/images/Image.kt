package com.example.composemigration.ui.components.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composemigration.ui.UIConstants.EMPTY_STRING
import com.example.poccomposemigration.R

@Composable
fun MigrationImage(image: Int, modifier: Modifier = Modifier, layoutId: String) {
    Image(
        imageVector = ImageVector.vectorResource(id = image),
        modifier = modifier.layoutId(layoutId),
        contentDescription = null,
    )
}

@Preview
@Composable
private fun ImagePreview() {
    Column {
        MigrationImage(image = R.drawable.this_is_boca_logo, layoutId = EMPTY_STRING)
    }
}
