package com.buchdemo.buchcontrol.control;

import com.buchdemo.buchcontrol.model.Buch;
import com.buchdemo.buchcontrol.model.Buchtyp;
import com.buchdemo.buchcontrol.service.BuchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class BuchController {

    @Autowired
    private BuchService buchService;

//    @GetMapping(path="/")
//    public @ResponseBody Iterable<Buch> getAllBuch() {
//        return buchService.findAll();
//    }

//    @RequestMapping("/")
//    public String index(Model model) {
//        List<Buch> buchList = buchService.findAll();
//        model.addAttribute("books", buchList);
//        return "index";
//    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam(defaultValue ="0") int page) {
        Page<Buch> buchList = buchService.findAllBuch(new PageRequest(page, 4));
        model.addAttribute("books", buchList);
        model.addAttribute("currPage", page);
        return "index";
    }

    @RequestMapping(value="addBuch")
    public String addBuch(Model model) {
        List<String> types = Buchtyp.getAllStrings();
        Collections.sort(types, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        model.addAttribute("buch", new Buch());
        model.addAttribute("types", types);
        return "addBuch";
    }

    @GetMapping(path="suchen/{id}")
    public ResponseEntity<?> findById (@PathVariable long id) {
        Buch found = buchService.findById(id);
        if (found == null) {
            return new ResponseEntity("Es gibt kein Buch mit gegebenem ID!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Buch>(found, HttpStatus.OK);
    }

    @GetMapping(path="suchenTitel/{titel}")
    public @ResponseBody Iterable<Buch> findById (@PathVariable String titel) {
        List<Buch> found = buchService.findByTitel(titel);
        return found;
    }

    @RequestMapping(value="save", method = RequestMethod.POST)
    public String save(Buch buch) {
        buchService.saveBuch(buch);
        return "redirect:/";
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    public String updateBuch(@PathVariable("id") long id, Model model) {
        Buch found = buchService.findById(id);
        model.addAttribute("buchChange", found);
        return "updateBuch";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBuch(@PathVariable("id") long id, Model model) {
        buchService.deleteBuchById(id);
        return "redirect:/";
    }

//    @RequestMapping(value="addBuch", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Buch> addBuch(@Valid @RequestBody Buch buch) {
//        buchService.saveBuch(buch);
//        return ResponseEntity.accepted().build();
//    }

    @DeleteMapping(path="deleteAll")
    public void deleteAll() {
        buchService.deleteAll();
    }
}
