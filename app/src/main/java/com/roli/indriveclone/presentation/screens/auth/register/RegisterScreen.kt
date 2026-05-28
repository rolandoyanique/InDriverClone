package com.roli.indriveclone.presentation.screens.auth.register
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.roli.indriveclone.presentation.screens.auth.register.component.RegisterContent
import com.roli.indriveclone.ui.theme.InDriveCloneTheme

@Composable
fun RegisterScreen(navHostController: NavHostController) {

    Scaffold() { paddingValues ->
        RegisterContent(navHostController,paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPreview(){
    InDriveCloneTheme() {
        RegisterScreen(rememberNavController())
    }
}