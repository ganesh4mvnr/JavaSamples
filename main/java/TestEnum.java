public class TestEnum {
    public static void main(String[] args) {
        System.out.println("Val => " + ModeCodes.FCP.getClassId());
        double amt = 2500.0;
        String maskAmt = "22990120".replaceAll("\\S", "*");
        if (amt > 2500) {
            System.out.println("Amount == " + amt);
        }
        System.out.println("maskAmt -> " + maskAmt);
    }
}

enum ModeCodes {
    FCP(1), P(2);

    private int classId;

    ModeCodes(int classId) {
        this.classId = classId;
    }

    /**
     * @return int --> classId
     */
    public int getClassId() {
        return this.classId;
    }
}
