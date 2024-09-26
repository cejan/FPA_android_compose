package com.example.samplejetpack.view.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable/*
import compose.material.theme.screens.HomeScreen
import compose.material.theme.screens.ProfileScreen
import compose.material.theme.screens.ReportScreen*/
import com.example.samplejetpack.MyViewModel
import com.example.samplejetpack.view.AllQoutes
import com.example.samplejetpack.view.screens.FertilizerScreen
import com.example.samplejetpack.view.screens.HomeScreen
import com.example.samplejetpack.view.screens.ProfileScreen
import com.example.samplejetpack.view.screens.ReportScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
            //AllQoutes()
        }

        composable(route = BottomBarScreen.Fertilizer.route) {
            FertilizerScreen()
        }

        composable(route = BottomBarScreen.Report.route) {
            ReportScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
    }
}