package com.lian.group.Controller;

import com.lian.group.Entity.Formula;
import com.lian.group.Entity.Resource;
import com.lian.group.Service.FormulaService;
import com.lian.group.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// what is a @restController; all class will got a @ResponseBody as default
@RestController
public class ResourceController {
    // All functions are using by Interface function, so you may imp it latter
    @Autowired
    private final ResourceService resourceService;
    @Autowired
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
    public ResponseEntity<?> findResourceByID(@PathVariable Integer id) throws Exception {
        Resource resource = resourceService.findOne(id);
//        resourceService.alterResource("test","int");
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/getResourceName")
    public ResponseEntity<?> findResourceByResourceName(@RequestParam String resourceName) throws Exception{

        Resource resource = resourceService.findName(resourceName);
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/getResources")
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.findAll();
        return ResponseEntity.ok(resources);
    }

    // Old version
//    @GetMapping("/deleteResource/{id}")
//    public String deleteResourceByID(@PathVariable Integer id) throws Exception {
//        resourceService.deleteOne(id);
//        return "Delete Resource Successfully";
//    }
    @DeleteMapping("/deleteResource")
    public ResponseEntity<?> deleteResourceByID(@RequestParam Integer id) throws Exception {
        // this find(id) will run 2 times which make no sense. Change after Test.
//        Resource resource = resourceService.findOne(id);

        resourceService.deleteOne(id);
        return ResponseEntity.ok("Resource Deleted");
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
    public ResponseEntity<?> addResource(@RequestParam String resourceName) {
        resourceService.addOne(resourceName);
        return ResponseEntity.ok("Resource Added");
    }

    // @PostMapping and @GetMapping both worked here,but need @pathvariable in Get
//    @GetMapping("/updateResource/{id}&{resourceName}")
    @PutMapping("/updateResource")
    public ResponseEntity<?> updateResource(@RequestParam Integer id, @RequestParam String resourceName) throws Exception {
        resourceService.updateOne(id, resourceName);
        return ResponseEntity.ok("Resource Updated");
    }

    //changing database
    @PutMapping("/alterResource")
    public ResponseEntity<?> alter(){
//        resourceService.alterResource(columnName,columnType);
        resourceService.alterResource("test","int");
        return ResponseEntity.ok("Column Added");
    }
    /**
     * Formula Controller
     */

    //Using EX:  http://localhost:8080/getFormulaByID/?id=1
    @GetMapping("/getFormulaByID")
    public ResponseEntity<?> findFormulaByID(@RequestParam Integer id) throws Exception {
        Formula formula = formulaService.findOne(id);
        return  ResponseEntity.ok(formula);
    }

    //Duplicate row returns, using findAllBy...()
    @GetMapping("/getFormulaByCostCode")
    public ResponseEntity<List<Formula>> findFormulaByCostCode(@RequestParam String costCode) throws Exception {
        List<Formula> formulas = formulaService.findByCostCode(costCode);
        return  ResponseEntity.ok(formulas);
    }

    @GetMapping("/getFormulaByItemID")
    public ResponseEntity<List<Formula>> findFormulaByItemID(@RequestParam Integer itemID) throws Exception {
        List<Formula> formulas =formulaService.findByItemId(itemID);
        return ResponseEntity.ok(formulas);
    }

    @GetMapping("/getFormulaByEditable")
    public ResponseEntity<List<Formula>> findFormulaByItemID(@RequestParam boolean editable) throws Exception {
        List<Formula> formulas =formulaService.findByEditable(editable);
        return ResponseEntity.ok(formulas);
    }

    @GetMapping("/getFormulas")
    public ResponseEntity<List<Formula>> getAllFormulas() {
        List<Formula> formulas =formulaService.findAll();
        return ResponseEntity.ok(formulas);
    }

    //---Delete
    @DeleteMapping("/deleteFormula")
    public ResponseEntity<?> deleteFormulaByID(@RequestParam Integer id) throws Exception {
        formulaService.deleteOne(id);
        return ResponseEntity.ok("Delete Formula Successfully");
    }

    @PostMapping("/addFormula")
    public ResponseEntity<?> addFormula(@RequestParam String costCode, @RequestParam Integer itemId,@RequestParam boolean editable) {
        formulaService.addOne(costCode, itemId, editable);
        return ResponseEntity.ok("Add Formula Successfully");
    }

    //---Update
    @PostMapping("/updateCostCode")
    public ResponseEntity<?> updateFormulaCostCode(@RequestParam Integer id, @RequestParam String costCode) throws Exception {
        formulaService.updateCostCode(id, costCode);
        return ResponseEntity.ok("Update CostCode successfully");
    }

    @PostMapping("/updateItemID")
    public ResponseEntity<?> updateFormulaItemID(@RequestParam Integer id, @RequestParam Integer itemID) throws Exception {
        formulaService.updateItemId(id, itemID);
        return ResponseEntity.ok("Update ItemID successfully");
    }

    @PostMapping("/updateEditable")
    public ResponseEntity<?> updateFormulaEditable(@RequestParam Integer id, @RequestParam boolean editable) throws Exception {
        formulaService.updateEditable(id, editable);
        return ResponseEntity.ok("Update Editable successfully");
    }



}
