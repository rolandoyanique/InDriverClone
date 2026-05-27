package com.roli.indriveclone.presentation.screens.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.roli.indriveclone.R
import com.roli.indriveclone.presentation.components.DefaultButton
import com.roli.indriveclone.presentation.components.DefaultOutlineTextField
import com.roli.indriveclone.ui.theme.InDriveCloneTheme

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    var email by remember{
        mutableStateOf("")
    }
    var name by remember{
        mutableStateOf("")
    }
    var lastname by remember{
        mutableStateOf("")
    }
    var phone by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    var confirmPassword by remember{
        mutableStateOf("")
    }
    Scaffold() { paddingValues ->
        Box(modifier = Modifier
                    .fillMaxSize()
            .background(brush = Brush.linearGradient(
                colors = listOf(Color(0xFFFEFA1E),Color(0xFF673AB7))
            ))
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
                        .padding(top=10.dp)
                        .clickable{navHostController.popBackStack()}
                )
                Spacer(modifier = Modifier.height(150.dp))
                Text(text = "Registro",
                    color=Color.Black,
                    fontSize = 33.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .rotate(degrees = 90f)
                        .padding(top=60.dp))
                Spacer(modifier = Modifier.height(50.dp))
            }
            Box(modifier = Modifier
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
                Column(modifier=Modifier.statusBarsPadding(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top=10.dp)
                    ){
                        Image(modifier = Modifier.size(140.dp).align(Alignment.Center),
                            painter = painterResource(id = R.drawable.car_white),contentDescription=null)
                    }
                    DefaultOutlineTextField(
                        modifier = Modifier,
                        value =name,
                        label = "Nombre",
                        icon = Icons.Outlined.Person,
                        onValueChange ={
                            name=it
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultOutlineTextField(
                        modifier = Modifier,
                        value =lastname,
                        label = "Apellido",
                        icon = Icons.Outlined.Person,
                        onValueChange ={
                            lastname=it
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultOutlineTextField(
                        modifier = Modifier,
                        value =email,
                        label = "Email",
                        icon = Icons.Outlined.Email,
                        keyboardType = KeyboardType.Email,
                        onValueChange ={
                            email=it
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultOutlineTextField(
                        modifier = Modifier,
                        value =phone,
                        label = "Telefono",
                        icon = Icons.Outlined.Phone,
                        keyboardType = KeyboardType.Number,
                        onValueChange ={
                            phone=it
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultOutlineTextField(
                        modifier = Modifier,
                        value =password,
                        label = "Password",
                        icon = Icons.Outlined.Lock,
                        hideText = true,
                        onValueChange ={
                            password=it
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultOutlineTextField(
                        modifier = Modifier,
                        value =confirmPassword,
                        label = "Confirmar Password",
                        icon = Icons.Outlined.Lock,
                        hideText = true,
                        onValueChange ={
                            confirmPassword=it
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultButton(
                       modifier = Modifier,
                        text = "Crear Usuario",
                        onClick = {}
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
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPreview(){
    InDriveCloneTheme() {
        RegisterScreen(rememberNavController())
    }
}