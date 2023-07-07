package com.example.composemigration.ui.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.composemigration.ui.Dimens.CARD_FONT_SIZE
import com.example.composemigration.ui.Dimens.IMAGE_SIZE
import com.example.composemigration.ui.components.images.MigrationImage
import com.example.composemigration.ui.components.text.MigrationTitle
import com.example.poccomposemigration.R

@Composable
fun MigrationCard(text: String, image: Int, modifier: Modifier = Modifier) {
    Card(modifier = modifier, backgroundColor = Color.Green) {
        ConstraintLayout(constraintSet = getConstraintSet(), modifier = Modifier.wrapContentSize()) {
            MigrationImage(image = image, Modifier.height(IMAGE_SIZE).width(IMAGE_SIZE), IMAGE)
            MigrationTitle(text = text, modifier = Modifier.layoutId(TEXT), fontSize = CARD_FONT_SIZE)
        }
    }
}

private fun getConstraintSet() = ConstraintSet {
    val image = createRefFor(IMAGE)
    val text = createRefFor(TEXT)

    constrain(image) {
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
        start.linkTo(parent.start)
    }
    constrain(text) {
        top.linkTo(image.top)
        bottom.linkTo(image.bottom)
        start.linkTo(image.end)
    }
}

const val IMAGE = "IMAGE"
const val TEXT = "TEXT"

@Preview
@Composable
private fun CardPreview() {
    Column {
        MigrationCard("ESTO ES BOOOCAAA", R.drawable.this_is_boca_logo)
    }
}
