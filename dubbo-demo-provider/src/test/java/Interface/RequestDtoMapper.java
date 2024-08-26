package Interface;

import Vo.ResultRequestVO;
import entity.ResultRequestDtoT;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestDtoMapper {

    RequestDtoMapper INSTANCE = Mappers.getMapper(RequestDtoMapper.class);

    @Mappings({
            @Mapping(source = "itemReportCode", target = "itemReportCode"),
            @Mapping(source = "itemReportName", target = "itemReportName"),
            @Mapping(source = "instrumentCode", target = "instrumentCode"),
            @Mapping(source = "instrumentName", target = "instrumentName"),
            @Mapping(source = "testResult", target = "testResult")
    })
    ResultRequestDtoT requestRequest2Dto(ResultRequestVO resultRequestVO);
    ResultRequestVO requestDto2RequestRequest(ResultRequestDtoT resultRequestDtoT);



}

