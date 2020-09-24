package com.zkdlu.template.spring_java.interfaces;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CrudController<TEntity, TKey> {
    @PostMapping
    boolean create(@RequestBody TEntity model);

    @GetMapping
    List<TEntity> read();

    @PutMapping("/{key}")
    TEntity update(@PathVariable TKey key, @RequestBody TEntity model);

    @DeleteMapping("/{key}")
    boolean delete(@PathVariable TKey key);

    @GetMapping("/{key}")
    TEntity readOne(@PathVariable TKey key);
}
