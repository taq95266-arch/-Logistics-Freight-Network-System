package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.InvoiceService;
import com.cl.Logistics.Freight.Network.entities.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("invoices")
public class InvoiceController {

    InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public Long addInvoice(@RequestParam BigDecimal amount,
                           @RequestParam String status,
                           @RequestParam LocalDate issuedDate) {

        return invoiceService.addInvoice(
                amount,
                status,
                issuedDate
        );
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoice();
    }

    @GetMapping("/{id}")
    public Invoice getById(@PathVariable Long id) {
        return invoiceService.getById(id);
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id,
                                 @RequestParam BigDecimal amount,
                                 @RequestParam String status,
                                 @RequestParam LocalDate issuedDate) {

        return invoiceService.updateInvoice(
                id,
                amount,
                status,
                issuedDate
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteInvoice(@PathVariable Long id) {
        return invoiceService.deleteById(id);
    }
}
