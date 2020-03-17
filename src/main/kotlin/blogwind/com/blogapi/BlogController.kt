package blogwind.com.blogapi

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single

@Controller("/blog")
class BlogController(private val backendApi: BackendApi) {
    @Get("/show?id=id")
    fun get(id: Int): Single<String> {
        return backendApi.blog(id).map {
            "<htm><body>" +
                    "<h1>${it.title}</h1>" +
                    "<h2>${getUsername(it.userId)}</h2>" +
                    "<p>${it.content}</p>" +
                    "</body></html>"
        }
    }

    private fun getUsername(userId: Int): String {
        return "John Doe"
    }
}