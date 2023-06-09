package io.javabrains.reactiveworkshop;

final class PhoneNumber implements Comparable {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        //return 0;
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;

    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof PhoneNumber)) throw new RuntimeException();

        PhoneNumber ph = (PhoneNumber) o;
        if (ph.areaCode == this.areaCode) return 0;
        else if (this.areaCode > ph.areaCode) return 1;
        else return -1;


    }

    @Override
    public String toString() {
        return "areaCode :" + areaCode + " prefix: " + prefix + " linenum :" + lineNum;
    }
}
