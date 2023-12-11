package com.ahrorovk.news.domain.Gnews

import android.content.Context
import android.widget.Toast
import com.ahrorovk.news.core.Constants.api_key_from_GNews
import com.ahrorovk.news.core.Resource
import com.ahrorovk.news.domain.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(
        search: String,
        lang: String,
        context: Context
    ): Flow<Resource<Gnews>> =
        flow {
            try {
                emit(Resource.Loading<Gnews>())
                val response = repository.getGNews(search, api_key_from_GNews, lang)
                emit(Resource.Success<Gnews>(response))
                Toast.makeText(
                    context,
                    if (lang == "ru") "Обновлено" else "Updated",
                    Toast.LENGTH_SHORT
                ).show()
            } catch (e: HttpException) {
                emit(
                    Resource.Error<Gnews>(
                        e.localizedMessage
                            ?: if (lang == "ru")
                                "Произошла непредвиденная ошибка"
                            else
                                "An unexpected error has occurred"
                    )
                )
            } catch (e: IOException) {
                emit(Resource.Error<Gnews>("Не удалось связаться с сервером. Проверьте подключение к Интернету."))
                Toast.makeText(
                    context,
                    if (lang == "ru") "Не удалось связаться с сервером. Проверьте подключение к Интернету." else "The server could not be contacted. Check your internet connection.",
                    Toast.LENGTH_SHORT
                ).show()
            } catch (e: Exception) {
                emit(
                    Resource.Error<Gnews>(
                        "${e.message}"
                    )
                )
                Toast.makeText(
                    context, "${e.message}", Toast.LENGTH_SHORT
                ).show()
            }
        }
}