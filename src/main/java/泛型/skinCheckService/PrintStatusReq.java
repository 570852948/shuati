package 泛型.skinCheckService;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrintStatusReq extends BaseBusinessDto {
    private String qrCode;
    private String status;
}
