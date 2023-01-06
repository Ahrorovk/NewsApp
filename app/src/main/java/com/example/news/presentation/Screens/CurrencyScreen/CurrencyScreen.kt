package com.example.news.presentation.Screens.CurrencyScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import coil.compose.rememberImagePainter
import com.example.news.Constants.api_key_from_GNews
import com.example.news.presentation.Screens.CurrencyScreen.components.CustomGNewsScreenBox
import com.example.news.presentation.Screens.HomeScreen.components.HomeScreenTopAppBar
import com.example.news.presentation.Screens.InfoScreen.components.ErrorIndicator
import com.example.news.presentation.Screens.InfoScreen.components.LoadingIndicator
import com.example.news.presentation.Screens.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CurrencyScreen(navController:NavController,viewModel: MainViewModel) {
    val stateSearchClick = viewModel.stateSearchClick
    val stateGetCurrency = viewModel.stateGetCurrency
    val context = LocalContext.current
    val state = rememberSwipeRefreshState(stateGetCurrency.value.isLoading)
    val getNewsFromServer = stateGetCurrency.value.response
    val stateGetGNews = viewModel.stateGetGNews
    val getGNews = stateGetGNews.value.response
    var searchTextField = viewModel.searchTextField
    LaunchedEffect(key1 = true){
        viewModel.getGNews(search = searchTextField,api_key_from_GNews,"ru",context)
    }
    Scaffold(topBar = {
        HomeScreenTopAppBar(
            value = searchTextField,
            viewModel = viewModel,
            backgroundColor = Color(0xFFCFCFCF),
            iconButtonOnClick = {
                viewModel.setSearch("")
            },bool=false, backProfileIconButtonOnClick = {},
        onSearch = {
            viewModel.searchClick(2)
            viewModel.getGNews(search = searchTextField,api_key_from_GNews,"ru",context)
        }
            )
    }) {

            if(stateSearchClick==2) {
                if(getGNews==null){
                    ErrorIndicator(onRetryText = "Повторить попытку",error ="ничего не найдено", onRetryClick = { viewModel.getGNews(search = searchTextField, api_key_from_GNews, "ru", context) })
                }
                else
                    ErrorIndicator(
                    error = stateGetGNews.value.error,
                    onRetryClick = {
                        viewModel.getGNews(
                            search = searchTextField,
                            api_key_from_GNews,
                            "ru",
                            context
                        )
                    },
                    onRetryText = "Повторить попытку"
                )
            }
        else {
                ErrorIndicator(onRetryText = "",
                    error ="Пожалуйста введите запрос",
                    onRetryClick = {},
                    showButton = false
                )
            }
        LoadingIndicator(isLoading = stateGetGNews.value.isLoading)

        getGNews?.let { newsNonNull ->
            SwipeRefresh(
                modifier = Modifier.fillMaxSize(),
                state = state,
                onRefresh = {
                    viewModel.getGNews(search = searchTextField, api_key_from_GNews, "ru", context)
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
                                colorOfIconFavorite = Color.Red,
                                IconFavoriteBool = false,
                                IconBookMarkBool = false,
                                colorOfIconBookMark = Color.Green,
                                IconFavoriteOnClick = { /*TODO*/ },
                                IconSaveOnClick = { /*TODO*/ },
                                IconDeleteOnClick = { /*TODO*/ },
                                SaveDeleteBool =false,
                                onClick = {}
                            )
                        }
                    }
//                LazyVerticalGrid(
//                    cells = GridCells.Fixed(3),
//                    contentPadding = PaddingValues(8.dp),
//                    content = {
//                        item {
//
//                            CustomField(
//                                name = newsNonNull.AED.name,
//                                newsNonNull.AED.buy_value,
//                                newsNonNull.AED.money_transfer_buy_value,
//                                newsNonNull.AED.sell_value
//                            )
//                        }
//                        item {
//                            CustomField(
//                                name = newsNonNull.EUR.name,
//                                buy_value = newsNonNull.EUR.buy_value,
//                                money_transfer_buy_value = newsNonNull.EUR.money_transfer_buy_value,
//                                sell_value = newsNonNull.EUR.sell_value
//                            )
//                        }
//                        item {
//                            CustomField(
//                                name = newsNonNull.EUR.name,
//                                buy_value = newsNonNull.EUR.buy_value,
//                                money_transfer_buy_value = newsNonNull.EUR.money_transfer_trade_value,
//                                sell_value = newsNonNull.EUR.sell_value
//                            )
//
//                        }
//                        item {
//                            CustomField(
//                                name = newsNonNull.RUB.name,
//                                buy_value = newsNonNull.RUB.buy_value,
//                                money_transfer_buy_value = newsNonNull.RUB.money_transfer_trade_value,
//                                sell_value = newsNonNull.RUB.sell_value
//                            )
//
//                        }
//                    })
                }
            }
        }

    }
}
@Composable
fun CustomField(
    name:String,
    buy_value:String,
    icon: String
){
    Box() {
        Column {
            Text("название $name")
            Text(text = "Купля $buy_value")
            Image(painter = rememberImagePainter(data = icon), contentDescription = null)
            Divider(color = Color.LightGray)
        }
    }
}
//api-key uOSYBzvx6AjexmsJpmMxCoUWUwPAKQ3w

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