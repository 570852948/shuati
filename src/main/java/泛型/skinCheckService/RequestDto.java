package 泛型.skinCheckService;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestDto<T extends BaseBusinessDto> {

    private String header;

    private T data;



}
