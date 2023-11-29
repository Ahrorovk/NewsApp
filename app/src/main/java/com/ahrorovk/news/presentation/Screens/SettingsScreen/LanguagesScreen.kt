package com.ikcollab.handyhelper.app.presentation.languages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahrorovk.news.presentation.Screens.SettingsScreen.LanguagesEvent
import com.ahrorovk.news.presentation.Screens.SettingsScreen.components.LanguageItem

@Composable
fun LanguagesScreen(
    state: LanguagesState,
    onEvent: (LanguagesEvent) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        if (state.selectedLanguage != null) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(vertical = 8.dp),
                text = "Languages",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colors.onBackground
            )
            LazyColumn() {
                items(state.languages) {
                    LanguageItem(name = it.name, isActive = it.id == state.selectedLanguage.id) {
                        onEvent(LanguagesEvent.OnLanguageItemClick(it.shortCut))
                    }
                }
                item{
                    Divider(modifier=Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp))
                }
            }
        }
    }
}