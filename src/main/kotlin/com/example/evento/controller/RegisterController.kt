package com.example.evento.controller

import com.example.evento.model.Conference
import com.example.evento.model.Register
import com.example.evento.service.RegisterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/register")
class RegisterController {
    @Autowired
    lateinit var registerService: RegisterService

    @GetMapping
    fun list(pageable: Pageable, register: Register):ResponseEntity<*>{
        val response = registerService.list(pageable, register)
        return ResponseEntity(response, HttpStatus.ACCEPTED)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id:Long):ResponseEntity<Register>?{
        return ResponseEntity(registerService.listById(id), HttpStatus.ACCEPTED)
    }

    @GetMapping("/conference/{mid}")
    fun listConferences(@PathVariable("mid") id: Long):ResponseEntity<*>{
        val response = registerService.listConferences(id)
        return ResponseEntity(response, HttpStatus.ACCEPTED)
    }


    @PostMapping
    fun save(@RequestBody @Validated register: Register): ResponseEntity<Register>?{
        return ResponseEntity(registerService.save(register), HttpStatus.ACCEPTED)

    }

    @PutMapping
    fun update(@RequestBody register:Register): ResponseEntity<Register> {
        return ResponseEntity(registerService.update(register), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean?{
        return registerService.delete(id)
    }

    @PatchMapping
    fun updateAssisted(@RequestBody register: Register):ResponseEntity<Register>{
        registerService.save(register)
        return ResponseEntity(registerService.updateAssisted(register), HttpStatus.ACCEPTED)
    }

}