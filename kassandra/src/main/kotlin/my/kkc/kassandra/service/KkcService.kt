package my.kkc.kassandra.service

import my.kkc.kommon.model.KkcMessage

interface KkcService {
    fun get(count: Int): List<KkcMessage>

    fun insert(str: String)
}