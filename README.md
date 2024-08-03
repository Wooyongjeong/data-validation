# data-validation


## 개요
여러 형식의 문자열 데이터에 대한 검증 기능을 어노테이션 형태로 제공합니다.

## 기능 
- @CreditCardNumber
  - 한국식 16자리 카드번호 검증 
  - ex1 : 1234-1234-1234-1234
  - ex2 : 1234123412341234
- @CustomRegex
  - 사용자 지정 정규식 검증
- @IPv4
  - ex : 192.168.1.1 
- @IPv6
  - ex : 2001:0db8:85a3:08d3:1319:8a2e:0370:7334
- @ISBN10
  - ex : 1-4133-0454-0, 1413304540
- @ISBN13
  - ex1 : 978-1-4133-0454-1
  - ex2 : 9781413304541
- @MACAddress
  - ex1 : 00-1D-D8-B9-C5-A1
  - ex2 : 001DD8B9C5A1
- @PhoneNumber
  - 국제 번호 고려하지 않음
  - ex1 : 010-1234-5678
  - ex2 : 016-987-6543
  - ex3 : 0195554444
- @PostalCode
  - 한국식 우편번호 형식 5자리 숫자
  - ex1 : 70925
- @ResidentRegistrationNumber
  - 한국 주민등록 번호 형식
  - ex1 : 900101-1234567
  - ex2 : 9001011234567
- @Time
  - KorTime은 오전 07:30(:19)과 같은 형식 허용
  - Time12는 10:10(:24) PM, AM 11:37(:35)와 같은 형식을 허용
  - Time24는 18:55(:06)과 같은 형식 허용
- @UNIXFilePath
  - 유닉스 파일 경로 검증
  - ex : /usr/bin, ~/bin, ./../src
- @WindowsFilePath
  - 윈도우 파일 경로 검증
  - ex1 : C:\Users\John\Documents\file.txt
  - ex2 : D:\Projects\MyProject\src\main.cpp


## 사용례
```java
ex1)
public class Device {
    @MACAddress 
    private String macAddress;
    public Device(String macAddress) {
        this.macAddress = macAddress;
    }
}

Device device = new Device("00:1A:2B:3C:4D:5E");
ValidatorManager.validate(device);


ex2)
public class Book {
    @ISBN13
    private String isbn;
    public Book(String isbn) {
        this.isbn = isbn;
    }
}

Book book = new Book("978-0134685991");
ValidatorManager.validate(book);


ex3)
public class User {
    @CustomRegex(pattern = "^[a-zA-Z0-9]{6,12}$")
    private String username;
    public User(String username) {
        this.username = username;
    }
}

User user = new User("validUser123");
ValidatorManager.validate(user);
```