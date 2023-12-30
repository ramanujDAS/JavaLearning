public class Test2 {
    public static void main(String[] args) {

        System.out.println("start");
        ProductCode productCode = ProductCode.PL;
        switch (productCode) {
            case OCL:
            case OCL_NO_FD:
            case OC:
                System.out.println("swicth OC");
                break;
            default:
                System.out.println("switch PL");
        }
    }
}
