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

import pdg.dto.mapper.ITipoEstadoMapper;

import pdg.modelo.*;

import pdg.modelo.dto.TipoEstadoDTO;

import pdg.presentation.businessDelegate.IBusinessDelegatorView;

import java.util.List;


@RestController
@RequestMapping("/tipoEstado")
public class TipoEstadoRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoEstadoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITipoEstadoMapper tipoEstadoMapper;

    @PostMapping(value = "/saveTipoEstado")
    public void saveTipoEstado(@RequestBody
    TipoEstadoDTO tipoEstadoDTO) throws Exception {
        try {
            TipoEstado tipoEstado = tipoEstadoMapper.tipoEstadoDTOToTipoEstado(tipoEstadoDTO);

            businessDelegatorView.saveTipoEstado(tipoEstado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoEstado/{idTestado}")
    public void deleteTipoEstado(@PathVariable("idTestado")
    Double idTestado) throws Exception {
        try {
            TipoEstado tipoEstado = businessDelegatorView.getTipoEstado(idTestado);

            businessDelegatorView.deleteTipoEstado(tipoEstado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoEstado/")
    public void updateTipoEstado(@RequestBody
    TipoEstadoDTO tipoEstadoDTO) throws Exception {
        try {
            TipoEstado tipoEstado = tipoEstadoMapper.tipoEstadoDTOToTipoEstado(tipoEstadoDTO);

            businessDelegatorView.updateTipoEstado(tipoEstado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoEstado")
    public List<TipoEstadoDTO> getDataTipoEstado() throws Exception {
        try {
            return businessDelegatorView.getDataTipoEstado();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoEstado/{idTestado}")
    public TipoEstadoDTO getTipoEstado(
        @PathVariable("idTestado")
    Double idTestado) throws Exception {
        try {
            TipoEstado tipoEstado = businessDelegatorView.getTipoEstado(idTestado);

            return tipoEstadoMapper.tipoEstadoToTipoEstadoDTO(tipoEstado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
