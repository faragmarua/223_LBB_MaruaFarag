package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Admin;
import ch.zli.m223.service.*;

@Path("/admins")
@Tag(name = "Admins", description = "Handling of admins")
public class AdminController {

    @Inject
    AdminService adminService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all admins.", description = "Returns a list of all admins.")
    public List<Admin> index() {
        return adminService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new booking.", description = "Creates a new admin  and returns the newly added admin.")
    public Admin create(Admin admin) {
        return adminService.createAdmin(admin);
    }

    @Path("/delete/{id}")
    @DELETE
    @Operation(summary = "Deletes an admin.", description = "Deletes an admin by its id.")
    public void delete(@PathParam("id") Long id) {
        adminService.deleteAdmin(id);
    }

    @Path("/put/{id}")
    @PUT
    @Operation(summary = "Updates an admin.", description = "Updates an admin by its id.")
    public Admin update(@PathParam("id") Long id, Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

}
