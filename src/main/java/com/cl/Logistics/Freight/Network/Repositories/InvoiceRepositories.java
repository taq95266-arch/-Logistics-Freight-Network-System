package com.cl.Logistics.Freight.Network.Repositories;

import com.cl.Logistics.Freight.Network.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepositories extends JpaRepository<Invoice,Long> {
}
