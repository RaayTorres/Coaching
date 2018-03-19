//package pdg.rest.controllers;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import pdg.dto.mapper.IParametroMapper;
//
//import pdg.modelo.*;
//
//import pdg.modelo.dto.ParametroDTO;
//
//import pdg.presentation.businessDelegate.IBusinessDelegate;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/parametro")
//public class ParametroRestController {
//    private static final Logger log = LoggerFactory.getLogger(ParametroRestController.class);
//    @Autowired
//    private IBusinessDelegate businessDelegatorView;
//    @Autowired
//    private IParametroMapper parametroMapper;
//
//    @PostMapping(value = "/saveParametro")
//    public void saveParametro(@RequestBody
//    ParametroDTO parametroDTO) throws Exception {
//        try {
//            Parametro parametro = parametroMapper.parametroDTOToParametro(parametroDTO);
//
//            businessDelegatorView.saveParametro(parametro);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @DeleteMapping(value = "/deleteParametro/{idParam}")
//    public void deleteParametro(@PathVariable("idParam")
//    Double idParam) throws Exception {
//        try {
//            Parametro parametro = businessDelegatorView.getParametro(idParam);
//
//            businessDelegatorView.deleteParametro(parametro);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @PutMapping(value = "/updateParametro/")
//    public void updateParametro(@RequestBody
//    ParametroDTO parametroDTO) throws Exception {
//        try {
//            Parametro parametro = parametroMapper.parametroDTOToParametro(parametroDTO);
//
//            businessDelegatorView.updateParametro(parametro);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @GetMapping(value = "/getDataParametro")
//    public List<ParametroDTO> getDataParametro() throws Exception {
//        try {
//            return businessDelegatorView.getDataParametro();
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw e;
//        }
//    }
//
//    @GetMapping(value = "/getParametro/{idParam}")
//    public ParametroDTO getParametro(@PathVariable("idParam")
//    Double idParam) throws Exception {
//        try {
//            Parametro parametro = businessDelegatorView.getParametro(idParam);
//
//            return parametroMapper.parametroToParametroDTO(parametro);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//
//        return null;
//    }
//}
