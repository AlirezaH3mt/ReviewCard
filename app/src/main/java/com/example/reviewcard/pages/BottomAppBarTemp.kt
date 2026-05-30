package com.example.reviewcard.pages

import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.reviewcard.R
import com.example.reviewcard.navigation.AllNavItems

@Composable
fun BottomAppBarTemp(navController: NavController){

    val navItems = listOf(AllNavItems.Home, AllNavItems.WordsListPage, AllNavItems.NotesListPage)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = colorResource(R.color.dark_gray)
    ) {
        navItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute?.startsWith(item.path) == true,
                onClick = {
                    if (currentRoute != item.path){
                        navController.navigate(item.path){
                            navController.graph.startDestinationRoute?.let {
                                route -> popUpTo(route){
                                    saveState = true
                            }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.iconPath),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        color = colorResource(R.color.white)
                    )
                        },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = colorResource(R.color.super_light_blue),
                    selectedIconColor = colorResource(R.color.black),
                    unselectedIconColor = colorResource(R.color.white)
                )
            )
        }

    }

}











