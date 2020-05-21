package my.kkc.kassandra.controller

import my.kkc.kassandra.service.KkcService
import my.kkc.kommon.controller.dto.RestResponse
import my.kkc.kommon.controller.dto.SuccessResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/kassandra")
class MainController {

    @Autowired
    lateinit var kkcService: KkcService

    @GetMapping("", "/{count}")
    fun get(@PathVariable(value = "count", required = false) count: Int?): RestResponse {
        val list = kkcService.get(count?:GET_DEFAULT)
        return SuccessResponse(list)
    }

    companion object {
        const val GET_DEFAULT = 10
    }
}
