package com.example.vmo_project.controller;

import com.example.vmo_project.request.InsertBillRequest;
import com.example.vmo_project.request.UpdateBillRequest;
import com.example.vmo_project.service.BillService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bills")
@SecurityRequirement(name = "Authorization")
public class BillController {

  @Autowired
  private BillService billService;

  @GetMapping("")
  public ResponseEntity<?> getAllBills() {
    return ResponseEntity.ok(billService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<?> getBillById(@PathVariable Long id) {
    return ResponseEntity.ok(billService.getById(id));
  }

//    @GetMapping("mail")
//    public ResponseEntity<?> testSendMail() {
//        billService.testSendMail();
//        return ResponseEntity.noContent().build();
//    }

  @GetMapping("apartment/{apartmentId}")
  public ResponseEntity<?> getBillByApartmentId(@PathVariable Long apartmentId) {
    return ResponseEntity.ok(billService.getByApartmentId(apartmentId));
  }

  @PostMapping("")
  public ResponseEntity<?> addBill(@RequestBody InsertBillRequest request) {
    return new ResponseEntity<>(billService.add(request), HttpStatus.CREATED);
  }

  @PutMapping("{id}")
  public ResponseEntity<?> updateBill(@PathVariable Long id,
      @RequestBody UpdateBillRequest request) {
    return ResponseEntity.ok(billService.update(id, request));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteBill(@PathVariable Long id) {
    billService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
