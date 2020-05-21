package my.kkc.kassandra.data

import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.cassandra.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface KkcMessageRepo: CassandraRepository<KkcMessageTable, UUID> {
    @Query("select * from kkc.message limit :limit")
    fun selectWithLimit(limit: Int): List<KkcMessageTable>
}
