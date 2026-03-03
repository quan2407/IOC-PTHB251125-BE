public class Validator {
    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {

        if (!phone.matches("\\d+")) {
            throw new InvalidPhoneNumberLengthException("Lỗi: Số điện thoại chỉ được chứa các chữ số!");
        }
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Lỗi: Số điện thoại phải có đúng 10 chữ số (Hiện có: " + phone.length() + ")");
        }
    }
}
