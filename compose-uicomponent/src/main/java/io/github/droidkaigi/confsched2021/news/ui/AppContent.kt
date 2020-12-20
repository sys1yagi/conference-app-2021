package io.github.droidkaigi.confsched2021.news.ui

import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawerLayout
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.droidkaigi.confsched2021.news.ui.news.NewsScreen
import io.github.droidkaigi.confsched2021.news.ui.theme.Conferenceapp2021newsTheme

@Composable
fun AppContent(
    modifier: Modifier = Modifier,
    firstDrawerValue: DrawerValue = DrawerValue.Closed,
) {
    val drawerState = rememberDrawerState(firstDrawerValue)
    val navController = rememberNavController()
    val onNavigationIconClick = { drawerState.open() }
    ModalDrawerLayout(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = { DrawerContent(navController) }
    ) {
        NavHost(navController, startDestination = "newsContents") {
            composable("newsContents") {
                NewsScreen(onNavigationIconClick)
            }
            composable("about_this_app") {
                Text("ok?")
            }
        }
    }
}