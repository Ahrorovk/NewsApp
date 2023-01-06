package com.example.news.domain.currency

import android.content.Context
import android.widget.Toast
import com.example.news.Resource
import com.example.news.data.remote.InfoApi
import com.example.news.domain.NewsInfo.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCurrencyUseCase (private val repository: InfoApi) {

    operator fun invoke(context: Context): Flow<Resource<currency>> =
        flow{
            try {
                emit(Resource.Loading<currency>())
                val response = repository.getCurrency()
                emit(Resource.Success<currency>(response))
                Toast.makeText(context,"Обновлено", Toast.LENGTH_SHORT).show()
            }catch (e: HttpException) {
                emit(
                    Resource.Error<currency>(
                        e.localizedMessage ?: "Произошла непредвиденная ошибка"
                    )
                )
                Toast.makeText(context,e.localizedMessage, Toast.LENGTH_SHORT).show()

            } catch (e: IOException) {
                emit(Resource.Error<currency>("Не удалось связаться с сервером. Проверьте подключение к Интернету."))
                Toast.makeText(context,"Не удалось связаться с сервером. Проверьте подключение к Интернету.",
                    Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                emit(Resource.Error<currency>("${e.message}"))
                Toast.makeText(context,"${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
}