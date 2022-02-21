package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entities.LogsEntity;
import co.com.bancolombia.jpa.mapper.LogMapper;
import co.com.bancolombia.model.log.Log;
import co.com.bancolombia.model.log.gateways.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPARepositoryAdapter implements LogRepository {

    @Autowired
    private JPARepository jpaRepository;
    @Autowired
    private LogMapper logMapper;

    @Override
    public void save(Log log) {
        jpaRepository.save(logMapper.toLogEntity(log));
    }

    @Override
    public List<Log> getLogs() {
        List<LogsEntity> logsEntities = (List<LogsEntity>) jpaRepository.findAll();
        return logMapper.toLogs(logsEntities);
    }
}
