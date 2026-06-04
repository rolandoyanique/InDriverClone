package com.roli.indriveclone.presentation.screens.auth.register.component

import android.widget.Toast
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
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.roli.indriveclone.R
import com.roli.indriveclone.presentation.components.DefaultButton
import com.roli.indriveclone.presentation.components.DefaultOutlineTextField
import com.roli.indriveclone.presentation.screens.auth.register.RegisterViewModel
import kotlin.collections.listOf

@Composable
fun RegisterContent(navHostController: NavHostController,paddingValues: PaddingValues,vm: RegisterViewModel= hiltViewModel()){
    val state=vm.state;
    val context= LocalContext.current;
    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage.isNotEmpty()){
            Toast.makeText(context,vm.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xFFAC9E1F), Color(0xFFFFE91F))

            )
        )
        .padding(paddingValues)
    ){
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Login",
                color=Color.Black,
                fontSize = 27.sp,
                modifier = Modifier
                    .rotate(degrees = 90f)
                    .padding(top = 10.dp)
                    .clickable { navHostController.popBackStack() }
            )
            Spacer(modifier = Modifier.height(150.dp))
            Text(text = "Registro",
                color=Color.Black,
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .rotate(degrees = 90f)
                    .padding(top = 60.dp))
            Spacer(modifier = Modifier.height(50.dp))
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(start = 60.dp, bottom = 35.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFC9AD1F), Color(0xFFFCDA22))
                ),
                shape = RoundedCornerShape(
                    topStart = 35.dp,
                    bottomStart = 35.dp
                )
            )
        ){
            Column(modifier=Modifier.statusBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ){
                    Image(modifier = Modifier
                        .size(140.dp)
                        .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.car_white),contentDescription=null)
                }
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value =state.name,
                    label = "Nombre",
                    icon = Icons.Outlined.Person,
                    onValueChange ={
                        vm.onNameInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value =state.lastname,
                    label = "Apellido",
                    icon = Icons.Outlined.Person,
                    onValueChange ={
                        vm.onLastNameInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value =state.email,
                    label = "Email",
                    icon = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email,
                    onValueChange ={
                        vm.onEmailInput(it);
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value =state.phone,
                    label = "Telefono",
                    icon = Icons.Outlined.Phone,
                    keyboardType = KeyboardType.Number,
                    onValueChange ={
                        vm.onPhoneInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value =state.password,
                    label = "Password",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange ={
                        vm.onPasswordInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value =state.confirmPassword,
                    label = "Confirmar Password",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange ={
                        vm.onConfirmPasswordInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultButton(
                    modifier = Modifier,
                    text = "Crear Usuario",
                    onClick = {vm.register()}
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier= Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Spacer(modifier = Modifier
                        .width(30.dp)
                        .height(1.dp)
                        .background(color = Color.Black)
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 7.dp),
                        text = "0",
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier
                        .width(30.dp)
                        .height(1.dp)
                        .background(color = Color.Black)
                    )
                }
                Spacer(modifier = Modifier.height(17.dp))
                Row(
                    modifier= Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Ya tienes cuenta?",
                        color = Color.Black,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        modifier = Modifier.clickable{navHostController.popBackStack()},
                        text = "Iniciar Sesión",
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}