package pdg.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pdg.dto.mapper.IEstadoMapper;

import pdg.modelo.*;

import pdg.modelo.dto.EstadoDTO;

import pdg.presentation.businessDelegate.IBusinessDelegate;

import java.util.List;


@RestController
@RequestMapping("/estado")
public class EstadoRestController {
    private static final Logger log = LoggerFactory.getLogger(EstadoRestController.class);
    @Autowired
    private IBusinessDelegate businessDelegatorView;
    @Autowired
    private IEstadoMapper estadoMapper;

    @PostMapping(value = "/saveEstado")
    public void saveEstado(@RequestBody
    EstadoDTO estadoDTO) throws Exception {
        try {
            Estado estado = estadoMapper.estadoDTOToEstado(estadoDTO);

            businessDelegatorView.saveEstado(estado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteEstado/{idEstado}")
    public void deleteEstado(@PathVariable("idEstado")
    Double idEstado) throws Exception {
        try {
            Estado estado = businessDelegatorView.getEstado(idEstado);

            businessDelegatorView.deleteEstado(estado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateEstado/")
    public void updateEstado(@RequestBody
    EstadoDTO estadoDTO) throws Exception {
        try {
            Estado estado = estadoMapper.estadoDTOToEstado(estadoDTO);

            businessDelegatorView.updateEstado(estado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataEstado")
    public List<EstadoDTO> getDataEstado() throws Exception {
        try {
            return businessDelegatorView.getDataEstado();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getEstado/{idEstado}")
    public EstadoDTO getEstado(@PathVariable("idEstado")
    Double idEstado) throws Exception {
        try {
            Estado estado = businessDelegatorView.getEstado(idEstado);

            return estadoMapper.estadoToEstadoDTO(estado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
