package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultRequestDtoT {

    private String itemReportCode;

    private String itemReportName;

    private String instrumentCode;

    private String instrumentName;

    private String testResult;

}
