package com.jhonatan.rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")


public class Restcontroller {

    private List<String> items = new ArrayList<String>();

    public Restcontroller() {
        items.add("Colombia");
        items.add("Brasil");
        items.add("Argentina");
        items.add("Peru");
        items.add("Chile");
        items.add("Venezuela");
        items.add("Bolivia");
    }

    @GetMapping
    public List<String> getAllItems() {
        return items;
    }

    @GetMapping("/{index}")
    public String getItem(@PathVariable int index){
        if(index >= 0 && index < items.size()){
            return items.get(index);
        }else{
            return "No encontrado";
        }
    }

    @PostMapping
    public String addItem(@RequestBody String newItem){
        items.add(newItem);
        return "Cambio exitoso ";
    }

    @PutMapping("/{index}") // Se pide un index para poder actualizar
    public String modifyItem(@PathVariable int index, @RequestBody String newItem){
        if(index >= 0 && index < items.size()){
            items.set(index, newItem);
            return "Cambio exitoso";
        }else{
            return "No encontrado";
        }
    }

    @DeleteMapping("/{index}")
    public String deleteItem(@PathVariable int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return "Eliminado";
        } else {
            return "No encontrado";
        }
    }
}
