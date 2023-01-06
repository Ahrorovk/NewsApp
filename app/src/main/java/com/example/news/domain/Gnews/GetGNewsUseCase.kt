package com.example.news.domain.Gnews

import android.content.Context
import android.widget.Toast
import com.example.news.Resource
import com.example.news.data.remote.InfoApi
import com.example.news.domain.currency.currency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetGNewsUseCase (private val repository: InfoApi) {

    operator fun invoke(search:String, token:String ,lang:String,context: Context): Flow<Resource<Gnews>> =
        flow{
            try {
                emit(Resource.Loading<Gnews>())
                val response = repository.getGNews(search,token,lang)
                emit(Resource.Success<Gnews>(response))
                Toast.makeText(context,"Обновлено", Toast.LENGTH_SHORT).show()
            }catch (e: HttpException) {
                emit(
                    Resource.Error<Gnews>(
                        e.localizedMessage ?: "Произошла непредвиденная ошибка"
                    )
                )
                Toast.makeText(context,e.localizedMessage, Toast.LENGTH_SHORT).show()

            } catch (e: IOException) {
                emit(Resource.Error<Gnews>("Не удалось связаться с сервером. Проверьте подключение к Интернету."))
                Toast.makeText(context,"Не удалось связаться с сервером. Проверьте подключение к Интернету.",
                    Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                emit(Resource.Error<Gnews>("${e.message}"))
                Toast.makeText(context,"${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
}