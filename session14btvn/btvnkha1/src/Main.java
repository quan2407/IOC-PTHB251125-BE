//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
  Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập số cần kiểm tra");
  try {
      int n = Integer.parseInt(scanner.nextLine());
      if (n <= 0){
          System.out.println("Số nhập phải lớn hơn 0");
      } else {
          if (checkPrime(n)){
              System.out.println("Đây là số nguyên tố");
          } else {
              System.out.println("Đây không phải là số nguyên tố");
          }
      }

  } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
  }
}

private boolean checkPrime(int n) {
    if (n < 2) return false;
    if (n == 2){
        return true;
    }
    for (int i = 2; i <= Math.sqrt(n) ; i++) {
        if (n % i ==0){
            return false;
        }
    }
    return true;
}
