package my.kkc.kassandra.data

import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface KkcMessageRepo: CassandraRepository<KkcMessageTable, Long> {

}