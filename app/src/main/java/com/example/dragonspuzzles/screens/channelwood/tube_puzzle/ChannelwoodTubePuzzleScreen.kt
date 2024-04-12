package com.example.dragonspuzzles.screens.channelwood.tube_puzzle

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dragonspuzzles.common.BackToolbar
import com.example.dragonspuzzles.screens.channelwood.ChannelwoodSymbol
import com.example.dragonspuzzles.screens.channelwood.LeftFacingButton
import com.example.dragonspuzzles.screens.channelwood.RightFacingButton
import com.example.dragonspuzzles.screens.channelwood.cross
import com.example.dragonspuzzles.screens.channelwood.cyanArc
import com.example.dragonspuzzles.screens.channelwood.downUp
import com.example.dragonspuzzles.screens.channelwood.moonMountain
import com.example.dragonspuzzles.screens.channelwood.semicircle
import com.example.dragonspuzzles.ui.theme.DragonsPuzzlesTheme

@Composable
fun ChannelwoodTubePuzzleScreen(
    popUpScreen: () -> Unit,
    viewModel: ChannelwoodTubePuzzleViewModel = ChannelwoodTubePuzzleViewModel()
) {
    ChannelwoodTubePuzzleScreenContent(
        popUpScreen,
        viewModel::onArrowClick,
        viewModel.puzzleState.top,
        viewModel.puzzleState.topMid,
        viewModel.puzzleState.bottomMid,
        viewModel.puzzleState.bottom
    )
}

@Composable
fun ChannelwoodTubePuzzleScreenContent(
    popUpScreen: () -> Unit,
    onArrowClick: (ChannelwoodTubeRings, Boolean) -> Unit,
    top: ChannelwoodSymbol,
    topMid: ChannelwoodSymbol,
    bottomMid: ChannelwoodSymbol,
    bottom: ChannelwoodSymbol)
{
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.tertiaryContainer)) {
        BackToolbar(title = "", popUpScreen)

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
            ChannelwoodTubeRing(top, Modifier.size(100.dp))
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
            ChannelwoodTubeRing(topMid, Modifier.size(100.dp))
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
            ChannelwoodTubeRing(bottomMid, Modifier.size(100.dp))
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
            ChannelwoodTubeRing(bottom, Modifier.size(100.dp))
            RightFacingButton(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clickable { onArrowClick(ChannelwoodTubeRings.BOTTOM, false) }
            )
        }
    }
}

@Composable
fun ChannelwoodTubeRing(symbol: ChannelwoodSymbol, modifier: Modifier) {
    Box (modifier = Modifier
        ,
        contentAlignment = Alignment.Center) {
        when (symbol) {
            ChannelwoodSymbol.SEMICIRCLE -> semicircle(modifier)
            ChannelwoodSymbol.CYANARC -> cyanArc(modifier)
            ChannelwoodSymbol.CROSS -> cross(modifier)
            ChannelwoodSymbol.DOWNUP -> downUp(modifier)
            ChannelwoodSymbol.MOONMOUNTAIN -> moonMountain(modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChannelwoodTubePuzzleScreenPreview() {
    DragonsPuzzlesTheme {
        ChannelwoodTubePuzzleScreenContent(
            popUpScreen = { },
            onArrowClick = {_,_ -> },
            ChannelwoodSymbol.SEMICIRCLE,
            ChannelwoodSymbol.SEMICIRCLE,
            ChannelwoodSymbol.SEMICIRCLE,
            ChannelwoodSymbol.SEMICIRCLE
        )
    }
}