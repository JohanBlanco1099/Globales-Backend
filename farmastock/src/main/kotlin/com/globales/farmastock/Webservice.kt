package com.globales.farmastock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.NoSuchElementException

//      PRIVILEGE

@RestController
@RequestMapping("\${url.privileges}")
class PrivilegesController(private val privilegeService: PrivilegeService) {

    @GetMapping
    @ResponseBody
    fun findAll() = privilegeService.findAll()

    @Throws(NoSuchElementException::class)
    @GetMapping("{id}")
    @ResponseBody
    fun findById(@PathVariable id: Long) = privilegeService.findById(id)


    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun create(@RequestBody privilegeInput: PrivilegeInput): PrivilegeDetails? {
        return privilegeService.create(privilegeInput)
    }

    @Throws(NoSuchElementException::class)
    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun update(@RequestBody privilegeInput: PrivilegeInput): PrivilegeDetails? {
        return privilegeService.update(privilegeInput)
    }

    @Throws(NoSuchElementException::class)
    @DeleteMapping("{id}")
    @ResponseBody
    fun deleteById(@PathVariable id: Long) {
        privilegeService.deleteById(id)
    }
}

//      ROLE
@RestController
@RequestMapping("\${url.roles}")
class RoleController(private val roleService: RoleService) {

    @GetMapping
    @ResponseBody
    fun findAll() = roleService.findAll()

    @Throws(NoSuchElementException::class)
    @GetMapping("{id}")
    @ResponseBody
    fun findById(@PathVariable id: Long) = roleService.findById(id)


    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun create(@RequestBody roleInput: RoleInput): RoleDetails? {
        return roleService.create(roleInput)
    }

    @Throws(NoSuchElementException::class)
    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun update(@RequestBody roleInput: RoleInput): RoleDetails? {
        return roleService.update(roleInput)
    }

    @Throws(NoSuchElementException::class)
    @DeleteMapping("{id}")
    @ResponseBody
    fun deleteById(@PathVariable id: Long) {
        roleService.deleteById(id)
    }
}

//      USER
@RestController
@RequestMapping("\${url.users}")
class UserController(private val userService: UserService) {

    @GetMapping
    @ResponseBody
    fun findAll() = userService.findAll()

    @Throws(NoSuchElementException::class)
    @GetMapping("{id}")
    @ResponseBody
    fun findById(@PathVariable id: Long) = userService.findById(id)

    @Throws(NoSuchElementException::class)
    @GetMapping("email/{username}")
    @ResponseBody
    fun findByEmail(@PathVariable username: String) = userService.findByEmail(username)


    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun create(@RequestBody userInput: UserInput): UserResult? {
        return userService.create(userInput)
    }

    @Throws(NoSuchElementException::class)
    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun update(@RequestBody userInput: UserInput): UserResult? {
        return userService.update(userInput)
    }

    @Throws(NoSuchElementException::class)
    @DeleteMapping("{id}")
    @ResponseBody
    fun deleteById(@PathVariable id: Long) {
        userService.deleteById(id)
    }
}

//      USER
@RestController
@RequestMapping("\${url.medicines}")
class MedicinesController(private val medicineService: medicineService) {

    @GetMapping
    @ResponseBody
    fun findAll() = medicineService.findAll()

    @Throws(NoSuchElementException::class)
    @GetMapping("{id}")
    @ResponseBody
    fun findById(@PathVariable id: Long) = medicineService.findById(id)


    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun create(@RequestBody medicineInput: MedicineInput): MedicineDetails? {
        return medicineService.create(medicineInput)
    }

    @Throws(NoSuchElementException::class)
    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun update(@RequestBody medicineInput: MedicineInput): MedicineDetails? {
        return medicineService.update(medicineInput)
    }

    @Throws(NoSuchElementException::class)
    @DeleteMapping("{id}")
    @ResponseBody
    fun deleteById(@PathVariable id: Long) {
        medicineService.deleteById(id)
    }
}


//      REMINDER
@RestController
@RequestMapping("\${url.reminders}")
    class RemindersController(private val reminderService: reminderService) {

    @GetMapping
    @ResponseBody
    fun findAll() = reminderService.findAll()

    @Throws(NoSuchElementException::class)
    @GetMapping("{id}")
    @ResponseBody
    fun findById(@PathVariable id: Long) = reminderService.findById(id)


    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun create(@RequestBody reminderInput: ReminderInput): ReminderDetails? {
        return reminderService.create(reminderInput)
    }

    @Throws(NoSuchElementException::class)
    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun update(@RequestBody reminderInput: ReminderInput): ReminderDetails? {
        return reminderService.update(reminderInput)
    }

    @Throws(NoSuchElementException::class)
    @DeleteMapping("{id}")
    @ResponseBody
    fun deleteById(@PathVariable id: Long) {
        reminderService.deleteById(id)
    }
}

// Security

@Service
@Transactional
class AppUserDetailsService(
    @Autowired
    val userRepository: UserRepository,
    @Autowired
    val roleRepository: RoleRepository,
    @Autowired
    val roleMapper: RoleMapper,
) : UserDetailsService {

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the `UserDetails`
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never `null`)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     * GrantedAuthority
     */
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        var userAuth: org.springframework.security.core.userdetails.User
        val user: User = (userRepository.findByEmail(username).orElse(null)
            ?: return org.springframework.security.core.userdetails.User(
                "", "", true, true, true, true,
                getAuthorities(
                    Arrays.asList(
                        roleRepository.findByName("ROLE_USER").get())))) as User
        userAuth = org.springframework.security.core.userdetails.User(
            user.email, user.password, user.enabled, true, true,
            true, getAuthorities(user.roleList!!.toMutableList()))

        return userAuth
    }

    private fun getAuthorities(
        roles: MutableList<Role>,
    ): Collection<GrantedAuthority?>? {
        return getGrantedAuthorities(getPrivileges(roles))
    }

    private fun getPrivileges(roles: MutableList<Role>?): List<String> {
        val privileges: MutableList<String> = ArrayList()
        val collection: MutableList<Privilege> = ArrayList()
        if (roles != null) {
            for (role in roles) {
                collection.addAll(role.privilegeList!!)
            }
        }
        for (item in collection) {
            privileges.add(item.name)
        }
        return privileges
    }

    private fun getGrantedAuthorities(privileges: List<String>): List<GrantedAuthority?>? {
        val authorities: MutableList<GrantedAuthority?> = ArrayList()
        for (privilege in privileges) {
            authorities.add(SimpleGrantedAuthority(privilege))
        }
        return authorities
    }

}