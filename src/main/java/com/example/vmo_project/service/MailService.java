package com.example.vmo_project.service;

import com.example.vmo_project.entity.Apartment;
import com.example.vmo_project.entity.Bill;
import com.example.vmo_project.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

  private final JavaMailSender emailSender;

  public void sendEmail(Person person, Apartment apartment, Bill bill, double amount) {
    SimpleMailMessage message = new SimpleMailMessage();

    String subject = "Thông báo đóng tiền phí sinh hoạt tháng " + bill.getBillDate().getMonthValue()
        + "/"
        + bill.getBillDate().getYear()
        + " của căn hộ "
        + apartment.getApartmentNumber();

    String body = "Kính gửi " + person.getName()
        + ",\n\n"
        + "Thông tin chi tiết các loại phí:\n"
        + "- Tiền điện:\n"
        + " .Số điện tiêu thụ: "
        + bill.getElectricityNumber()
        + "Kwh\n"
        + " .Tổng hóa đơn điện: "
        + bill.getElectricityNumber() * bill.getFeeTypes().stream()
        .filter(feeType -> feeType.getName().equals("electricity")).findFirst().orElse(null)
        .getPrice()
        + " VNĐ\n"
        + "- Tiền nước:\n"
        + " .Số nước tiêu thụ: "
        + bill.getWaterNumber()
        + "m3\n"
        + " .Tổng hóa đơn nước: "
        + bill.getWaterNumber() * bill.getFeeTypes().stream()
        .filter(feeType -> feeType.getName().equals("water")).findFirst().orElse(null)
        .getPrice()
        + " VNĐ\n"
        + "- Tiền chi phí chung cư:\n"
        + " .Tiền gửi xe: "
        + bill.getFeeTypes().stream().filter(feeType -> feeType.getName().equals("parking"))
        .findFirst().orElse(null).getPrice()
        + " VNĐ\n"
        + " .Tiền vệ sinh: "
        + bill.getFeeTypes().stream().filter(feeType -> feeType.getName().equals("cleaning"))
        .findFirst().orElse(null).getPrice()
        + " VNĐ\n"
        + " .Tiền bảo trì: "
        + bill.getFeeTypes().stream().filter(feeType -> feeType.getName().equals("maintaining"))
        .findFirst().orElse(null).getPrice()
        + " VNĐ\n"
        + "Tổng số tiền phải thanh toán: "
        + amount
        + " VNĐ\n\n"
        + "Trân trọng,\nBan quản lý tòa nhà";

    message.setTo(person.getEmail());
    message.setSubject(subject);
    message.setText(body);

    emailSender.send(message);
  }
}
