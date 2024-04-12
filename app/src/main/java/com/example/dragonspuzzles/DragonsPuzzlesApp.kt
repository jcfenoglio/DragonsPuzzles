package com.example.dragonspuzzles

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dragonspuzzles.screens.channelwood.grid_puzzle.ChannelwoodGridPuzzleScreen
import com.example.dragonspuzzles.screens.channelwood.grid_puzzle.ChannelwoodGridPuzzleViewModel
import com.example.dragonspuzzles.screens.channelwood.tube_puzzle.ChannelwoodTubePuzzleScreen
import com.example.dragonspuzzles.screens.channelwood.tube_puzzle.ChannelwoodTubePuzzleViewModel
import com.example.dragonspuzzles.screens.puzzle_list.PuzzleListScreen
import com.example.dragonspuzzles.ui.theme.DragonsPuzzlesTheme

@Composable
fun DragonsPuzzlesApp() {
    DragonsPuzzlesTheme {
        Surface(color = MaterialTheme.colorScheme.tertiaryContainer) {
            val navController = rememberNavController()
            val appState = DragonsPuzzlesAppState(navController)

            NavHost(navController = navController, startDestination = "puzzle_list_screen") {
                dragonsPuzzlesGraph(appState)
            }

        }
    }
}


fun NavGraphBuilder.dragonsPuzzlesGraph(appState: DragonsPuzzlesAppState) {
    composable(PUZZLE_LIST_SCREEN) {
        PuzzleListScreen(openScreen = { route -> appState.navigate(route) })
    }

    composable(CHANNELWOOD_TUBE_PUZZLE_SCREEN) {
        ChannelwoodTubePuzzleScreen(popUpScreen = { appState.popUp() }, viewModel<ChannelwoodTubePuzzleViewModel>())
    }

    composable(CHANNELWOOD_GRID_PUZZLE_SCREEN) {
        ChannelwoodGridPuzzleScreen(popUpScreen = { appState.popUp() }, viewModel<ChannelwoodGridPuzzleViewModel>())
    }
}

@Preview
@Composable
fun DragonsPuzzlesAppPreview() {
    DragonsPuzzlesTheme {
        DragonsPuzzlesApp()
    }
}