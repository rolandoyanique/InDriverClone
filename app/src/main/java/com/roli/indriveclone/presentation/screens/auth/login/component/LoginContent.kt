package com.roli.indriveclone.presentation.screens.auth.login.component

import android.R.attr.tag
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.roli.indriveclone.R
import com.roli.indriveclone.presentation.components.DefaultTextField
import com.roli.indriveclone.presentation.navigation.screen.auth.AuthScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roli.indriveclone.presentation.components.DefaultButton
import com.roli.indriveclone.presentation.screens.auth.login.LoginViewModel

@Composable
fun LoginContent(navHostController: NavHostController,paddingValues: PaddingValues) {
    val vm: LoginViewModel = viewModel()
    val state=vm.state;
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xFFAC9E1F),Color(0xFFFFE91F))
            )
        )
        .padding(paddingValues)){
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.rotate(90f).padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(150.dp))
            Text(
                text = "Registro",
                color = Color.White,
                fontSize = 27.sp,
                modifier = Modifier
                    .clickable{ navHostController.navigate(route = AuthScreen.Register.route)}
                    .rotate(90f).padding(top = 30.dp)
            )
            Spacer(modifier = Modifier.height(250.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 60.dp, bottom = 35.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFC9AD1F),Color(0xFFFCDA22))
                    ),
                    shape = RoundedCornerShape(
                        topStart = 35.dp,
                        bottomStart = 35.dp
                    )
                )
        ){
            Column(modifier = Modifier.statusBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Wellcome",
                    color=Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "back...",
                    color=Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp)
                ){
                    Image(
                        modifier = Modifier
                            .size(150.dp)
                            .align(Alignment.CenterEnd),
                        painter = painterResource(id=R.drawable.car_white),
                        contentDescription = ""

                    )
                }

                Text(
                    text = "Log in",
                    color=Color.White,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(50.dp))
                DefaultTextField(
                    modifier = Modifier,
                    value = state.email,
                    label = "Email",
                    icon = Icons.Outlined.Email,
                    onValueChange={ email->
                        vm.onEmailInput(email)
                    },
                    keyboardType = KeyboardType.Email
                )
                Spacer(modifier = Modifier.height(20.dp))
                DefaultTextField(
                    modifier = Modifier,
                    value = state.password,
                    label = "Password",
                    icon = Icons.Outlined.Lock,
                    onValueChange={password->
                        vm.onPasswordInput(password)
                    },
                    keyboardType = KeyboardType.Password,
                    hideText = true
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(modifier=Modifier,
                    text="LOGIN",
                    onClick={
                        vm.login()
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.Black)
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        text = "O",
                        color=Color.Black,
                        fontSize = 20.sp
                    )
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.Black)
                    )
                }
                Spacer(modifier=Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "No tienes cuenta? ",
                        color=Color.Black,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        modifier = Modifier.clickable{navHostController.navigate(route = AuthScreen.Register.route)},
                        text = "Registrate",
                        color=Color.Black,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier=Modifier.height(70.dp))
            }
        }
    }
}