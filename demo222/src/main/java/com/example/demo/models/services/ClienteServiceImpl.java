package com.example.demo.models.services;

import com.example.demo.models.dao.IClienteDao;
import com.example.demo.models.entity.Cliente;
import com.example.demo.models.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private PaisServiceImpl paisService;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Optional<Pais> pais = paisService.findById(cliente.getDomicilio().getPais().getId());
        if (pais.isEmpty()) {
            throw new IllegalArgumentException("El pais no existe en la tabla paises");
        } else {
            clienteDao.save(cliente);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);

    }

}