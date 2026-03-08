package io.dimasla4ee.contacts_viewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import io.dimasla4ee.contacts_viewer.ui.theme.ContactsViewerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsViewerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContactDetails(
                        modifier = Modifier.padding(innerPadding),
                        contact = Contact(
                            "Андрей",
                            "Жетпакович",
                            "Композин",
                            imageRes = null,
                            isFavorite = true,
                            phone = "+7 (911) 111-11-11",
                            address = "США: Маунтин-Вью, Калифорния",
                            email = "jetpackcompose@gmail.com"
                        )
                    )
                }
            }
        }
    }

}
