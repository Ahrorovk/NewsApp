package com.example.news.presentation.Screens.HomeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.news.Constants.bool
import com.example.news.Constants.homeScreen
import com.example.news.Screen
import com.example.news.presentation.Screens.HomeScreen.components.*
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.AMAZON
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.ANDROID
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.APPLE
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.BMW
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.CARS
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.EUROPE
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.HONDA
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.IOS
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.MERCEDES
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.SAMSUNG
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.SCIENCE
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.TECHNOLOGY
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory.USA
import com.example.news.presentation.Screens.MainViewModel
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(navController: NavController,viewModel: MainViewModel) {
    bool = true
    LaunchedEffect(key1 = true){
        homeScreen.value = true
    }
    val context = LocalContext.current
    val stateGetNewsAndroid = viewModel.stateGetNewsAndroid
    val state = rememberSwipeRefreshState(stateGetNewsAndroid.value.isLoading)
    val getNewsFromServer = stateGetNewsAndroid.value.response
    val navController1 = rememberNavController()
    var categories = viewModel.category
    val listOfNews = viewModel.listOfNews
    val listOfCategory = listOf(ANDROID,IOS,APPLE, SAMSUNG, TECHNOLOGY, AMAZON, SCIENCE, CARS,
        HONDA, BMW, MERCEDES, USA, EUROPE)
    var searchTextField = viewModel.searchTextField
    Scaffold(
//        bottomBar = {
//                    BottomBar(navController)
//        },
        drawerContent = {
            HomeDrawer(
                navController = navController,
                username = viewModel.username.value,
                phoneNumber = viewModel.phoneNumber.value,
                iconButtonOnClick = {
                    navController.navigate(Screen.CURRENCY_SCREEN.route)
                },
                profileButtonOnClick = {
                    navController.navigate(Screen.PROFILE_SCREEN.route)
                }
                )
        },
        topBar = {
            HomeScreenTopAppBar(
                value = searchTextField,
                viewModel = viewModel,
            backgroundColor = Color(0xFFCFCFCF),
            iconButtonOnClick = {
                viewModel.setSearch("")
            },bool=false, backProfileIconButtonOnClick = {},)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF3F3F3))
        ) {
            Column() {
                Spacer(Modifier.padding(vertical = 10.dp))
                Row(Modifier.padding(start = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier
                            .size(35.dp)
                            .width(45.dp),
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null
                    , tint = Color(0xFF7B868C)
                    )
                    Spacer(Modifier.padding(6.dp))
                    Text("Local News",color=Color(0xFF8698A6))
                }
                Spacer(Modifier.padding(vertical = 10.dp))
                Row(Modifier.padding(start = 14.dp)) {
                    Text(
                        "TOPICS LIST",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )

                }
                Spacer(Modifier.padding(vertical = 3.dp))

                    LazyColumn() {
                        items(listOfCategory) { category ->
                            if(category.toUpperCase(java.util.Locale.ROOT).contains(
                                    searchTextField.trim().toUpperCase(java.util.Locale.ROOT)
                            )) {
                                CustomBox(title = category, onClick = {
                                    viewModel.getNewsAndroid(category, context)
                                    viewModel.setTopAppBarCategory(category)
                                        navController.navigate(Screen.INFO_SCREEN.route)
                                })
                            }
                        }
                        items(1){
                            Spacer(modifier = Modifier.padding(vertical = 32.dp))
                        }
                    }
                }
            }
        }
    }
/*  Column(modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier=Modifier.fillMaxWidth().height(20.dp)
            .clickable {
                viewModel.getNewsAndroid()
                navController.navigate(Screen.INFO_SCREEN) }
        ){
            Text("Category: android")
        }
        Box(modifier=Modifier.fillMaxWidth().height(20.dp)
            .clickable {
                viewModel.getNewsScience()
                navController.navigate(Screen.INFO_SCREEN) }
        ){
            Text("Category: science")
        }
    }*/