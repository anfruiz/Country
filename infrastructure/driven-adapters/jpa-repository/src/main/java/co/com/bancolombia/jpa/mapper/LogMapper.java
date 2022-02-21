package co.com.bancolombia.jpa.mapper;

import co.com.bancolombia.jpa.entities.LogsEntity;
import co.com.bancolombia.model.log.Log;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "numberOfCountries", target = "numberOfCountries")
    })
    Log toLog(LogsEntity logsEntity);
    List<Log> toLogs(List<LogsEntity> logsEntities);

    @InheritInverseConfiguration
    LogsEntity toLogEntity(Log log);
}
