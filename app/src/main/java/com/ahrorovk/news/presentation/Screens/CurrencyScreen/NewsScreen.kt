package com.ahrorovk.news.presentation.Screens.CurrencyScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahrorovk.news.presentation.Screens.CurrencyScreen.components.CustomGNewsScreenBox
import com.ahrorovk.news.presentation.Screens.InfoScreen.components.ErrorIndicator
import com.ahrorovk.news.presentation.Screens.InfoScreen.components.LoadingIndicator
import com.ahrorovk.news.presentation.Screens.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun NewsScreen(navController: NavController, viewModel: MainViewModel) {
    val context = LocalContext.current
    val stateGetGNews = viewModel.stateGetGNews
    val state = rememberSwipeRefreshState(stateGetGNews.value.isLoading)
    val getGNews = stateGetGNews.value.response
    var searchTextField = viewModel.searchTextField
    if (getGNews == null) {
        ErrorIndicator(
            onRetryText = "Повторить попытку",
            error = "ничего не найдено",
            onRetryClick = {
                viewModel.getGNews(
                    search = searchTextField,
                    viewModel.stateLanguage.value,
                    context
                )
            })
    } else {
        ErrorIndicator(
            error = stateGetGNews.value.error,
            onRetryClick = {
                viewModel.getGNews(
                    search = searchTextField,
                    viewModel.stateLanguage.value,
                    context
                )
            },
            onRetryText = "Повторить попытку"
        )
    }
    LoadingIndicator(isLoading = stateGetGNews.value.isLoading)

    getGNews?.let { newsNonNull ->
        SwipeRefresh(
            modifier = Modifier.fillMaxSize(),
            state = state,
            onRefresh = {
                viewModel.getGNews(search = searchTextField, "ru", context)
            }
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 5.dp)
            ) {
                LazyColumn() {
                    items(newsNonNull.articles) {
                        CustomGNewsScreenBox(
                            author = it.source.name,
                            time = it.url,
                            date = it.publishedAt,
                            title = it.title,
                            imageUrl = it.image,
                            content = it.description,
                        )
                    }
                }
            }
        }
    }
}
//

@Composable
fun HyperlinkText(
    modifier: Modifier = Modifier,
    fullText: String,
    linkText: List<String>,
    linkTextColor: Color = Color.Blue,
    linkTextFontWeight: FontWeight = FontWeight.Medium,
    linkTextDecoration: TextDecoration = TextDecoration.Underline,
    hyperlinks: List<String> = listOf("https://stevdza-san.com"),
    fontSize: TextUnit = TextUnit.Unspecified
) {
    val annotatedString = buildAnnotatedString {
        append(fullText)
        linkText.forEachIndexed { index, link ->
            val startIndex = fullText.indexOf(link)
            val endIndex = startIndex + link.length
            addStyle(
                style = SpanStyle(
                    color = linkTextColor,
                    fontSize = fontSize,
                    fontWeight = linkTextFontWeight,
                    textDecoration = linkTextDecoration
                ),
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = "URL",
                annotation = hyperlinks[index],
                start = startIndex,
                end = endIndex
            )
        }
        addStyle(
            style = SpanStyle(
                fontSize = fontSize
            ),
            start = 0,
            end = fullText.length
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        onClick = {
            annotatedString
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}