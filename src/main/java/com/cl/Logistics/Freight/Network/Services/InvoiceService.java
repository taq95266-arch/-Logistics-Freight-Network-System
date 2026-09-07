package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.InvoiceRepositories;
import com.cl.Logistics.Freight.Network.entities.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    InvoiceRepositories invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepositories invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Long addInvoice(BigDecimal amount,
                           String status,
                           LocalDate issuedDate) {

        if (amount == null) {
            return null;
        }

        Invoice invoice = new Invoice();

        invoice.setAmount(amount);
        invoice.setStatus(status);
        invoice.setIssuedDate(issuedDate);
        invoice.setIsActive(true);

        return invoiceRepository.save(invoice).getId();
    }

    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    public Invoice getById(Long id) {

        Optional<Invoice> invoice =
                invoiceRepository.findById(id);

        if (invoice.isPresent()
                && invoice.get().getIsActive()) {

            return invoice.get();
        }

        return new Invoice();
    }

    public Invoice updateInvoice(Long id,
                                 BigDecimal amount,
                                 String status,
                                 LocalDate issuedDate) {

        Invoice invoice =
                invoiceRepository.findById(id).orElse(null);

        if (invoice == null
                || !invoice.getIsActive()) {

            return new Invoice();
        }

        invoice.setAmount(amount);
        invoice.setStatus(status);
        invoice.setIssuedDate(issuedDate);

        return invoiceRepository.save(invoice);
    }

    public Boolean deleteById(Long id) {

        Invoice invoice =
                invoiceRepository.findById(id).orElse(null);

        if (invoice == null
                || !invoice.getIsActive()) {

            return false;
        }

        invoice.setIsActive(false);

        invoiceRepository.save(invoice);

        return true;
    }
}
