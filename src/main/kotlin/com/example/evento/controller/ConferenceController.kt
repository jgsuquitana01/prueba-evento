package com.example.evento.controller

import com.example.evento.model.Conference
import com.example.evento.service.ConferenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/conference")
class ConferenceController {
    @Autowired
    lateinit var conferenceService: ConferenceService

    @GetMapping
    fun list(conference: Conference, pageable: Pageable):ResponseEntity<*>{
        val response = conferenceService.list(pageable, conference)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id:Long): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.listById(id), HttpStatus.ACCEPTED)
    }



    @PostMapping
    fun save(@RequestBody @Validated conference: Conference): ResponseEntity<Conference>?{
        return ResponseEntity(conferenceService.save(conference), HttpStatus.ACCEPTED)

    }

    @PutMapping
    fun update(@RequestBody conference:Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.update(conference), HttpStatus.ACCEPTED)
    }

    @PatchMapping
    fun updateName(@RequestBody conference:Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.updateName(conference), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long):Boolean?{
        return conferenceService.delete(id)
    }


}