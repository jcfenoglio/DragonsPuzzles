package com.example.dragonspuzzles.screens.channelwood.tube_puzzle

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dragonspuzzles.common.BackToolbar
import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol
import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbolBox
import com.example.dragonspuzzles.screens.channelwood.LeftFacingButton
import com.example.dragonspuzzles.screens.channelwood.ResetButton
import com.example.dragonspuzzles.screens.channelwood.RightFacingButton
import com.example.dragonspuzzles.ui.theme.DragonsPuzzlesTheme

@Composable
fun ChannelwoodTubePuzzleScreen(
    popUpScreen: () -> Unit,
    viewModel: ChannelwoodTubePuzzleViewModel
) {
    ChannelwoodTubePuzzleScreenContent(
        popUpScreen,
        viewModel::onArrowClick,
        viewModel::resetPuzzle,
        viewModel.puzzleState.top,
        viewModel.puzzleState.topMid,
        viewModel.puzzleState.bottomMid,
        viewModel.puzzleState.bottom,
        viewModel.puzzleState.completed
    )
}

@Composable
fun ChannelwoodTubePuzzleScreenContent(
    popUpScreen: () -> Unit,
    onArrowClick: (ChannelwoodTubeRings, Boolean) -> Unit,
    onResetClick: () -> Unit,
    top: ChannelwoodSymbol,
    topMid: ChannelwoodSymbol,
    bottomMid: ChannelwoodSymbol,
    bottom: ChannelwoodSymbol,
    completed: Boolean)
{
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.tertiaryContainer)) {
        val title = if (completed) {
            "*click* The tube opens!"
        } else {""}
        BackToolbar(title = title, popUpScreen)
        val lineColor = MaterialTheme.colorScheme.secondary
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            LeftFacingButton(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clickable { onArrowClick(ChannelwoodTubeRings.TOP, true) }
            )
            Box(modifier = Modifier
                .padding(5.dp)
                .drawWithCache {
                    onDrawBehind {
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 15f
                        )
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = 15f
                        )
                        drawLine(
                            color = lineColor,
                            start = Offset(size.width, 0f),
                            end = Offset(size.width, size.height),
                            strokeWidth = 15f
                        )
                    }
                }){ChannelwoodSymbolBox(top, Modifier.size(100.dp))}
            RightFacingButton(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clickable { onArrowClick(ChannelwoodTubeRings.TOP, false) }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            LeftFacingButton(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clickable { onArrowClick(ChannelwoodTubeRings.TOPMID, true) }
            )
            Box(modifier = Modifier
                .padding(5.dp)
                .drawWithCache {
                    onDrawBehind {
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 15f
                        )
                    }
                })
            {ChannelwoodSymbolBox(topMid, Modifier.size(100.dp))}
            RightFacingButton(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clickable { onArrowClick(ChannelwoodTubeRings.TOPMID, false) }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            LeftFacingButton(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clickable { onArrowClick(ChannelwoodTubeRings.BOTTOMMID, true) }
            )
            Box(modifier = Modifier
                .padding(5.dp)
                .drawWithCache {
                    onDrawBehind {
                        drawLine(
                            color = lineColor,
                            start = Offset(size.width, 0f),
                            end = Offset(size.width, size.height),
                            strokeWidth = 15f
                        )
                    }
                }){ChannelwoodSymbolBox(bottomMid, Modifier.size(100.dp))}
            RightFacingButton(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clickable { onArrowClick(ChannelwoodTubeRings.BOTTOMMID, false) }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            LeftFacingButton(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clickable { onArrowClick(ChannelwoodTubeRings.BOTTOM, true) }
            )
            Box(modifier = Modifier
                .padding(5.dp)
                .drawWithCache {
                    onDrawBehind {
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 15f
                        )
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 15f
                        )
                        drawLine(
                            color = lineColor,
                            start = Offset(size.width, 0f),
                            end = Offset(size.width, size.height),
                            strokeWidth = 15f
                        )
                    }
                }){ChannelwoodSymbolBox(bottom, Modifier.size(100.dp))}
            RightFacingButton(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clickable { onArrowClick(ChannelwoodTubeRings.BOTTOM, false) }
            )
        }

        Spacer(Modifier
            .fillMaxWidth()
            .padding(80.dp))

        ResetButton(onResetClick)
    }
}


@Preview(showBackground = true)
@Composable
fun ChannelwoodTubePuzzleScreenPreview() {
    DragonsPuzzlesTheme {
        ChannelwoodTubePuzzleScreenContent(
            popUpScreen = { },
            onArrowClick = {_,_ -> },
            onResetClick = { },
            ChannelwoodSymbol.SEMICIRCLE,
            ChannelwoodSymbol.MOONMOUNTAIN,
            ChannelwoodSymbol.DOWNUP,
            ChannelwoodSymbol.CROSS,
            true
        )
    }
}