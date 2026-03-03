//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);
    List<String> phoneNumber = new ArrayList<>();
    List<InvalidPhoneRecord> invalidList = new ArrayList<>();
    System.out.println("Nhập dãy số cần check(cách nhau bởi dấu phẩy) : ");
    String rawString = scanner.nextLine();
    String[] rawItem = rawString.split(",");
    for (String checkPhoneNum : rawItem) {
        String cleanPhoneNum = checkPhoneNum.trim();
        if (cleanPhoneNum.isEmpty()) continue;
        try {
            Validator.validatePhoneNumber(cleanPhoneNum);
            phoneNumber.add(cleanPhoneNum);
        } catch (InvalidPhoneNumberLengthException e) {
            invalidList.add(new InvalidPhoneRecord(cleanPhoneNum, e.getMessage()));
        }
    }
    System.out.println("\n DANH SÁCH HỢP LỆ:");
    if (phoneNumber.isEmpty()) System.out.println("(Trống)");
    else phoneNumber.forEach(System.out::println);

    System.out.println("\n DANH SÁCH KHÔNG HỢP LỆ:");
    if (invalidList.isEmpty()) System.out.println("(Trống)");
    else {
        for (InvalidPhoneRecord record : invalidList) {
            System.out.println("Giá trị: " + record.value + " | Lý do: " + record.reason);
        }
    }

    scanner.close();
}
