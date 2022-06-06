package cl.tesoreria.java.interfaceRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.tesoreria.java.modelo.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
