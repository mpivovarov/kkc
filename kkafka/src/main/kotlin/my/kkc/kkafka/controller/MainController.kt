package my.kkc.kkafka.controller

import my.kkc.kommon.controller.dto.RestResponse
import my.kkc.kommon.controller.dto.SuccessResponse
import my.kkc.kkafka.service.KkcService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/kafka")
class MainController {

    @Autowired
    lateinit var kkcService: KkcService

    @PostMapping("", "/{count}")
    fun gen(@PathVariable(value = "count", required = false) count: Int?): RestResponse {
        val res = kkcService.gen(count ?: GEN_DEFAULT)
        return SuccessResponse(Unit)
    }

    @GetMapping("", "/{count}")
    fun get(@PathVariable(value = "count", required = false) count: Int? = 0): RestResponse {
        return SuccessResponse(count?:0)
    }

    companion object {
        const val GEN_DEFAULT = 10
    }
}
