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

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.EntryService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all entries.", 
        description = "Returns a list of all entries."
    )
    public List<Booking> index() {
        return entryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new entry.", 
        description = "Creates a new entry and returns the newly added entry."
    )
    public Booking create(Booking booking) {
       return entryService.createEntry(booking);
    }

    @Path("/{id}")
    @DELETE
    @Operation(
        summary = "Deletes an entry.",
        description = "Deletes an entry by its id."
    )
    public void delete(@PathParam("id") Long id) {
        entryService.deleteEntry(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(
        summary = "Updates an entry.",
        description = "Updates an entry by its id."
    )
    public Booking update(@PathParam("id") Long id, Booking booking) {
        return entryService.updateEntry(id, booking);
    }

}