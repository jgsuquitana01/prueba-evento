package com.example.evento.model

import javax.persistence.*

@Entity
@Table(name="register")
class Register {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long? = null

    var code:String? = null
    @Column(name="registered_at")
    var registeredAt:String? = null

    var assisted:Boolean? = null
    @Column(name = "conference_id")
    var conferenceId:Long?=null
    @Column(name = "member_id")
    var memberId:Long?=null



}