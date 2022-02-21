package co.com.bancolombia.usecase.log;

import co.com.bancolombia.model.log.Log;
import co.com.bancolombia.model.log.gateways.LogRepository;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class LogUseCase {

    private final LogRepository logRepository;

    public void save(int quantity) {
        Timestamp id = Timestamp.valueOf(LocalDateTime.now());
        logRepository.save(new Log(id, quantity));
    }

    public List<Log> getLogs() {
        return logRepository.getLogs();
    }
}
