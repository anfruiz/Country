package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entities.LogsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.sql.Timestamp;
import java.time.LocalTime;

public interface JPARepository extends CrudRepository<LogsEntity, Timestamp> {
}
