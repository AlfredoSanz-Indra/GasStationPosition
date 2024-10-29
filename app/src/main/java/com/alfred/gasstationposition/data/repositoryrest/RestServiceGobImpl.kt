package com.alfred.gasstationposition.data.repositoryrest

import com.alfred.gasstationposition.core.log.Klog
import com.alfred.gasstationposition.data.model.SimpleDataResponse
import com.alfred.gasstationposition.data.repositoryrestapi.RestServiceGob
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

/**
 * @author Alfredo Sanz
 * @time 2024
 */
class RestServiceGobImpl(private val ioDispatcher: CoroutineDispatcher): RestServiceGob {

    override suspend fun getPreciosCarburantesTerrestre(): SimpleDataResponse {
        Klog.line("RestServiceGobImpl", "getPreciosCarburantesTerrestre", "init")
        var result = SimpleDataResponse(true, 200, "OK")

        withContext(ioDispatcher) {
            val defer = async(ioDispatcher) {
                //val url = "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/"
                val url = "https://jsonplaceholder.typicode.com/todos/1"
                Klog.line("RestServiceGobImpl","getPreciosCarburantesTerrestre","url -> $url")
                val client = HttpClient(OkHttp) {
                    install(ContentNegotiation) {
                        json()
                    }
                }
                Klog.line("RestServiceGobImpl", "getPreciosCarburantesTerrestre", "client created")

                var resp = SimpleDataResponse(true, 200, "OK 1")
                try {
                    val response = client.get(url)
                    if(response.status.isSuccess()) {
                        Klog.line("RestServiceGobImpl", "getPreciosCarburantesTerrestre", "response.status -> ${response.status}")
                        resp = SimpleDataResponse(true, 200, "response -> ${response.status}")
                        resp.dat = response.body()
                   }
                    else {
                        result  = SimpleDataResponse(false, 500, "KO -> ${response.status}")
                    }
                }
                catch (e: Exception) {
                    Klog.line("RestServiceGobImpl", "c getPreciosCarburantesTerrestre", "e -> $e")
                    Klog.line("RestServiceGobImpl", "c getPreciosCarburantesTerrestre", "e -> ${e.message}")
                    result  = SimpleDataResponse(false, 501, "exception KO -> ${e.message}")
                }
                catch (e: Throwable) {
                    Klog.line("RestServiceGobImpl", "d getPreciosCarburantesTerrestre", "e -> $e")
                    Klog.line("RestServiceGobImpl", "d getPreciosCarburantesTerrestre", "e -> ${e.message}")
                    result  = SimpleDataResponse(false, 501, " throwable KO -> ${e.message}")
                }
                finally {
                    client.close()
                    Klog.line("RestServiceGobImpl", "getPreciosCarburantesTerrestre", "client close")
                }
                return@async resp
            }

            result = defer.await()
        }//scope

        return result
    }
}