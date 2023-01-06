package com.example.news.domain.NewsInfo

import android.content.Context
import android.widget.Toast
import com.example.news.Resource
import com.example.news.data.remote.InfoApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetNewsAndroidUseCase(private val repository: InfoApi) {

    operator fun invoke(technology: String,context: Context): Flow<Resource<News>> =
        flow{
            try {
                emit(Resource.Loading<News>())
                val response = repository.getNewsAndroid(technology = technology)
                emit(Resource.Success<News>(response))
                Toast.makeText(context,"Обновлено",Toast.LENGTH_SHORT).show()
            }catch (e: HttpException) {
                emit(
                    Resource.Error<News>(
                        e.localizedMessage ?: "Произошла непредвиденная ошибка"
                    )
                )
                Toast.makeText(context,e.localizedMessage,Toast.LENGTH_SHORT).show()

            } catch (e: IOException) {
                emit(Resource.Error<News>("Не удалось связаться с сервером. Проверьте подключение к Интернету."))
                Toast.makeText(context,"Не удалось связаться с сервером. Проверьте подключение к Интернету.",Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                emit(Resource.Error<News>("${e.message}"))
                Toast.makeText(context,"${e.message}",Toast.LENGTH_SHORT).show()
            }
        }
}