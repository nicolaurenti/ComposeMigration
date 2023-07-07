package com.example.composemigration.ui.components.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composemigration.MigrationViewModel
import com.example.composemigration.ui.Dimens.TITLE_FONT_SIZE
import com.example.composemigration.ui.components.button.MigrationButton
import com.example.composemigration.ui.components.cards.MigrationCard
import com.example.composemigration.ui.components.text.MigrationTitle
import com.example.poccomposemigration.R

@Composable
fun MigrationScreen(viewModel: MigrationViewModel = hiltViewModel()) {
    val data = viewModel.listState.collectAsState().value
    ConstraintLayout(constraintSet = getConstraintSet(), modifier = Modifier.fillMaxSize()) {
        MigrationTitle(
            text = stringResource(R.string.this_is_a_title),
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            layoutId = TITLE,
            fontSize = TITLE_FONT_SIZE,
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.Black)
                .layoutId(LIST),
        ) {
            items(data) { item ->
                MigrationCard(item.title, item.icon)
            }
        }
        MigrationButton(
            onClick = { viewModel.buttonClicked() },
            buttonText = stringResource(R.string.this_is_a_button),
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            layoutId = BUTTON,
        )
    }
}

private fun getConstraintSet() = ConstraintSet {
    val title = createRefFor(TITLE)
    val list = createRefFor(LIST)
    val button = createRefFor(BUTTON)

    constrain(title) {
        top.linkTo(parent.top)
        bottom.linkTo(list.top)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
    }
    constrain(list) {
        top.linkTo(title.bottom)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(button.top)
        height = Dimension.fillToConstraints
    }
    constrain(button) {
        top.linkTo(list.bottom)
        bottom.linkTo(parent.bottom)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }
}

const val TITLE = "TITLE"
const val LIST = "LIST"
const val BUTTON = "BUTTON"

@Preview
@Composable
private fun MigrationScreenPreview() {
    Column {
        MigrationScreen()
    }
}
