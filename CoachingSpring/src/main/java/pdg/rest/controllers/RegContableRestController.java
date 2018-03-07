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

import pdg.dto.mapper.IRegContableMapper;

import pdg.modelo.*;

import pdg.modelo.dto.RegContableDTO;

import pdg.presentation.businessDelegate.IBusinessDelegate;

import java.util.List;


@RestController
@RequestMapping("/regContable")
public class RegContableRestController {
    private static final Logger log = LoggerFactory.getLogger(RegContableRestController.class);
    @Autowired
    private IBusinessDelegate businessDelegatorView;
    @Autowired
    private IRegContableMapper regContableMapper;

    @PostMapping(value = "/saveRegContable")
    public void saveRegContable(@RequestBody
    RegContableDTO regContableDTO) throws Exception {
        try {
            RegContable regContable = regContableMapper.regContableDTOToRegContable(regContableDTO);

            businessDelegatorView.saveRegContable(regContable);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteRegContable/{idHis}")
    public void deleteRegContable(@PathVariable("idHis")
    Double idHis) throws Exception {
        try {
            RegContable regContable = businessDelegatorView.getRegContable(idHis);

            businessDelegatorView.deleteRegContable(regContable);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateRegContable/")
    public void updateRegContable(@RequestBody
    RegContableDTO regContableDTO) throws Exception {
        try {
            RegContable regContable = regContableMapper.regContableDTOToRegContable(regContableDTO);

            businessDelegatorView.updateRegContable(regContable);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataRegContable")
    public List<RegContableDTO> getDataRegContable() throws Exception {
        try {
            return businessDelegatorView.getDataRegContable();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getRegContable/{idHis}")
    public RegContableDTO getRegContable(@PathVariable("idHis")
    Double idHis) throws Exception {
        try {
            RegContable regContable = businessDelegatorView.getRegContable(idHis);

            return regContableMapper.regContableToRegContableDTO(regContable);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
