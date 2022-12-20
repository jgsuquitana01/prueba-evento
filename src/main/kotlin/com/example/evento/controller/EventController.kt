package com.example.evento.controller

import com.example.evento.model.Event
import com.example.evento.model.Member
import com.example.evento.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/event")
class EventController {
    @Autowired
    lateinit var eventService: EventService

    @GetMapping
    fun list(pageable: Pageable, event:Event):ResponseEntity<*>{
        val response = eventService.list(pageable, event)
        return ResponseEntity(response, HttpStatus.ACCEPTED)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id:Long):ResponseEntity<Event>{
        return ResponseEntity(eventService.listById(id), HttpStatus.ACCEPTED)
    }



    @PostMapping
    fun save(@RequestBody @Validated event: Event): ResponseEntity<Event>?{
        return ResponseEntity(eventService.save(event), HttpStatus.ACCEPTED)

    }

    @PutMapping
    fun update(@RequestBody event:Event): ResponseEntity<Event> {
        return ResponseEntity(eventService.update(event), HttpStatus.ACCEPTED)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean?{
        return eventService.delete(id)
    }



}