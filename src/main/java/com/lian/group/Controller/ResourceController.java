package com.lian.group.Controller;

import com.lian.group.Entity.Formula;
import com.lian.group.Entity.Resource;
import com.lian.group.Service.FormulaService;
import com.lian.group.Service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// what is a @restController?
@RestController
public class ResourceController {
    // All functions are using by Interface function, so you may imp it latter
    private final ResourceService resourceService;
    private final FormulaService formulaService;

    // initialize it
    public ResourceController(ResourceService resourceService, FormulaService formulaService) {
        this.resourceService = resourceService;
        this.formulaService = formulaService;
    }

    /**
     * Resource Controller
     */
    // what is @pathVar ==> use to refer {id} in url
    @GetMapping("/getResource/{id}")
    public Resource findResourceByID(@PathVariable Integer id) throws Exception {
        return resourceService.findOne(id);
    }

    @GetMapping("/getResourceName/")
    public Resource findResourceByResourceName(@RequestParam String resourceName) throws Exception{
        return resourceService.findName(resourceName);
    }

    @GetMapping("/getResources")
    public List<Resource> getAllResources() {
        return resourceService.findAll();
    }

    // Old version
//    @GetMapping("/deleteResource/{id}")
//    public String deleteResourceByID(@PathVariable Integer id) throws Exception {
//        resourceService.deleteOne(id);
//        return "Delete Resource Successfully";
//    }
    @DeleteMapping("/deleteResource")
    public String deleteResourceByID(@RequestParam Integer id) throws Exception {
        resourceService.deleteOne(id);
        return "Delete Resource Successfully";
    }

    //---Add
//    old version

//    @GetMapping("/addResource/{resourceName}")
//    public String addResource(@PathVariable String resourceName) {
//        resourceService.addOne(resourceName);
//        return "Add Resource Successfully";
//    }

    //   @PostMapping failed? Because https:// uses method "get" as default

    @PostMapping("/addNewResource")
    public String addResource(@RequestParam String resourceName) {
        resourceService.addOne(resourceName);
        return "Add Resource Successfully";
    }

    // PostMapping and getMapping both worked here
    @GetMapping("/updateResource/{id}&{resourceName}")
    public String updateResource(@PathVariable Integer id, @PathVariable String resourceName) throws Exception {
        resourceService.updateOne(id, resourceName);
        return "Update Resource Successfully";
    }

    /**
     * Formula Controller
     */

    //Using EX:  http://localhost:8080/getFormulaByID/?id=1
    @GetMapping("/getFormulaByID")
    public Formula findFormulaByID(@RequestParam Integer id) throws Exception {
        return formulaService.findOne(id);
    }

    //Duplicate row returns, using findAllBy...()
    @GetMapping("/getFormulaByCostCode")
    public List<Formula> findFormulaByCostCode(@RequestParam Integer costCode) throws Exception {
        return formulaService.findByCostCode(costCode);
    }

    @GetMapping("/getFormulaByItemID")
    public List<Formula> findFormulaByItemID(@RequestParam Integer itemID) throws Exception {
        return formulaService.findByItemId(itemID);
    }

    @GetMapping("/getFormulaByEditable")
    public List<Formula> findFormulaByItemID(@RequestParam boolean editable) throws Exception {
        return formulaService.findByEditable(editable);
    }

    @GetMapping("/getFormulas")
    public List<Formula> getAllFormulas() {
        return formulaService.findAll();
    }

    //---Delete
    @DeleteMapping("/deleteFormula")
    public String deleteFormulaByID(@RequestParam Integer id) throws Exception {
        formulaService.deleteOne(id);
        return "Delete Formula Successfully";
    }

    @PostMapping("/addFormula")
    public String addFormula(@RequestParam Integer costCode, @RequestParam Integer itemId,@RequestParam boolean editable) {
        formulaService.addOne(costCode, itemId, editable);
        return "Add Formula Successfully";
    }

    //---Update
    @PostMapping("/updateCostCode")
    public String updateFormulaCostCode(@RequestParam Integer id, @RequestParam Integer costCode) throws Exception {
        formulaService.updateCostCode(id, costCode);
        return "Update CostCode successfully";
    }

    @PostMapping("/updateItemID")
    public String updateFormulaItemID(@RequestParam Integer id, @RequestParam Integer itemID) throws Exception {
        formulaService.updateItemId(id, itemID);
        return "Update ItemID successfully";
    }

    @PostMapping("/updateEditable")
    public String updateFormulaEditable(@RequestParam Integer id, @RequestParam boolean editable) throws Exception {
        formulaService.updateEditable(id, editable);
        return "Update Editable successfully";
    }

}
