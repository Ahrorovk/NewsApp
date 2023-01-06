package com.example.news.presentation.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.news.presentation.Screens.HomeScreen.components.HomeScreenTopAppBar


@SuppressLint("UnrememberedMutableState")
@Composable
fun ProfileScreen(navController: NavController, viewModel: MainViewModel) {
    var liveDateString = MutableLiveData<String>()
    var Username by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var Phonenumber by remember { mutableStateOf("") }
    val username=viewModel.username
    val email=viewModel.email
    val phonenumber=viewModel.phoneNumber
    //viewModel.getListOfUser()

//    Box(modifier = Modifier
//        .fillMaxSize()
//        .background(Color(0xFF47494E)))
//    {
    Column() {

        HomeScreenTopAppBar(iconButtonOnClick =  {
            navController.popBackStack()
        }, backgroundColor =Color(0xFFCFCFCF), viewModel = viewModel, value = viewModel.searchTextField,
        bool=true, backProfileIconButtonOnClick = {
            navController.popBackStack()
            })

        TextButton(onClick = {}) {
//                       Spacer(modifier = Modifier.width(250.dp))
            Icon(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
                imageVector = Icons.Outlined.Edit,
                contentDescription = null
            )
        }
//            Text(text="${liveDateString.value}")
//            myLiveData.observe(this , Observer{
//
//            })
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .height(60.dp)
                    .width(90.dp),
                imageVector = Icons.Default.VerifiedUser,
                contentDescription = null
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = username.value.toString(), fontSize = 30.sp, color = Color.Black)
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        )
        {
            Text(text = phonenumber.value.toString())
        }
        LazyColumn(modifier= Modifier
            .padding(horizontal = 12.dp)) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    NumberRow(
                        text = "",
                        label="Username",
                        value = Username,
                        onValueChange = {
                            Username = it
                        },
                        placeholder = "Username",
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    NumberRow(
                        text = "",
                        label="Email",
                        value = Email,
                        onValueChange = {
                            Email = it
                        },
                        placeholder = "Email",
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column() {
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    label={ Text(text="Your Phone Number") },
                                    value = Phonenumber,
                                    onValueChange = {
                                        Phonenumber = it
                                    },
                                    placeholder = { Text("Phone Number") },
                                    colors = TextFieldDefaults.textFieldColors(
                                        textColor = Color.Black,
                                        disabledTextColor = Color.Transparent,
                                        backgroundColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Black,
                                        unfocusedIndicatorColor = Color.Black,
                                        disabledIndicatorColor = Color.Black
                                    ),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp), contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        viewModel.setUsername(Username)
                        viewModel.setEmail(Email)
                        viewModel.setPhonenumber(Phonenumber)
                    }) {
                        Text("Ok")
                    }
                }
            }
        }
    }
}
@Composable
fun NumberRow(
    text:String,
    placeholder:String,
    value: String,
    onValueChange: (String) -> Unit,
    label:String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(text = text, fontSize = 25.sp, color = Color.Red)
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label={ Text(text=label) },
                    value = value,
                    onValueChange = onValueChange,
                    placeholder = { Text(placeholder) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Black,
                        disabledIndicatorColor = Color.Black
                    )
                )
            }
        }
    }
}