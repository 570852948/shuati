package 泛型.skinCheckService;

public class AppMain {

    public static void main(String[] args) {

        RequestDto<PrintStatusReq> reqRequestDto = new RequestDto<>("haha", new PrintStatusReq("a", "b"));

        PrintStatusReq data = reqRequestDto.getData();

        System.out.println(data);
    }
}
