package com.example.dragonspuzzles.screens.channelwood.grid_puzzle

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dragonspuzzles.common.BackToolbar
import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol
import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbolBox
import com.example.dragonspuzzles.screens.channelwood.ResetButton
import com.example.dragonspuzzles.screens.channelwood.GridBase
import com.example.dragonspuzzles.ui.theme.DragonsPuzzlesTheme

@Composable
fun ChannelwoodGridPuzzleScreen(
    popUpScreen: () -> Unit,
    viewModel: ChannelwoodGridPuzzleViewModel
) {
    ChannelwoodGridPuzzleScreenContent(
        popUpScreen,
        viewModel::gridButtonClick,
        viewModel::resetPuzzle,
        viewModel.puzzleState.top,
        viewModel.puzzleState.left,
        viewModel.puzzleState.right,
        viewModel.puzzleState.bottom,
        viewModel.puzzleState.completed
    )
}

@Composable
fun ChannelwoodGridPuzzleScreenContent(
    popUpScreen: () -> Unit,
    gridButtonClicked: (ChannelwoodGridSquares) -> Unit,
    resetButtonClicked: () -> Unit,
    top: ChannelwoodSymbol,
    left: ChannelwoodSymbol,
    right: ChannelwoodSymbol,
    bottom: ChannelwoodSymbol,
    completed: Boolean) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primaryContainer)) {
        BackToolbar(title = if (completed) "The lid pops open with a *thunk*" else "", popUpScreen)

        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            GridBase()
            Column(
                modifier = Modifier
                    .size(300.dp)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .size(300.dp, 93.dp)
                ) {
                    Spacer(modifier = Modifier.size(94.dp))
                    ChannelwoodSymbolBox(symbol = top, modifier = Modifier
                        .size(92.dp)
                        .clickable { gridButtonClicked(ChannelwoodGridSquares.TOP) })
                }
                Row(
                    modifier = Modifier
                        .size(300.dp, 93.dp)
                ) {
                    ChannelwoodSymbolBox(symbol = left, modifier = Modifier
                        .size(94.dp)
                        .clickable { gridButtonClicked(ChannelwoodGridSquares.LEFT) })
                    Spacer(modifier = Modifier.size(92.dp))
                    ChannelwoodSymbolBox(symbol = right, modifier = Modifier
                        .size(94.dp)
                        .clickable { gridButtonClicked(ChannelwoodGridSquares.RIGHT) })
                }
                Row(
                    modifier = Modifier
                        .size(300.dp, 93.dp)
                ) {
                    Spacer(modifier = Modifier.size(94.dp))
                    ChannelwoodSymbolBox(symbol = bottom, modifier = Modifier
                        .size(92.dp)
                        .clickable { gridButtonClicked(ChannelwoodGridSquares.BOTTOM) })
                }
            }
        }
        Spacer(modifier = Modifier.fillMaxWidth().padding(80.dp))
        ResetButton(resetButtonClicked)
    }
}

@Preview(showBackground = true)
@Composable
fun ChannelwoodGridPuzzleScreenPreview() {
    DragonsPuzzlesTheme {
        ChannelwoodGridPuzzleScreenContent(
            { },
            { },
            { },
            ChannelwoodSymbol.DOWNUP,
            ChannelwoodSymbol.CROSS,
            ChannelwoodSymbol.MOONMOUNTAIN,
            ChannelwoodSymbol.CYANARC,
            true)
    }
}