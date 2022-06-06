package cl.tesoreria.java.interfaceRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.tesoreria.java.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
	

}
