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

import ch.zli.m223.model.Member;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.service.MemberService;

@Path("/categories")
@Tag(name = "Entries", description = "Handling of categories")
public class MemberController {

    @Inject
    MemberService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all members.", 
        description = "Returns a list of all categories."
    )
    public List<Member> index() {
        return categoryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new Member.", 
        description = "Creates a new category and returns the newly added category."
    )
    public Member create(Member member) {
       return categoryService.createMember(member);
    }

    @Path("/{id}")
    @DELETE
    @Operation(
        summary = "Deletes a member.",
        description = "Deletes a category by its id."
    )
    public void delete(@PathParam("id") Long id) {
        categoryService.deleteMember(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(
        summary = "Updates a member.",
        description = "Updates a member by its id."
    )
    public Member update(@PathParam("id") Long id, Member member) {
        return categoryService.updatMember(id, member);
    }

}
