package com.example.quest_package

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun TestingHello(name: String) {
    Text(
        text = "hello custom package $name!",
    )
}

