package co.com.bancolombia.model.log.gateways;

import co.com.bancolombia.model.log.Log;

import java.util.List;
import java.util.Optional;

public interface LogRepository {

    void save(Log log);

    List<Log> getLogs();
}
