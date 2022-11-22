package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
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

import ch.zli.m223.model.Workspace;
import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.service.WorkspaceService;

@Path("/workspaces")
// Überlegen Sie sich, weshalb das notwendig ist.
@org.eclipse.microprofile.openapi.annotations.tags.Tag(name = "Workspace", description = "Handling of workspaces")
public class WorkspaceController {

    @Inject
    WorkspaceService workspaceService;

    @GET
    @Path("/getAll")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @RequestScoped
    @Operation(summary = "Index all workspaces.", description = "Returns a list of all workspaces.")
    public List<Workspace> index() {
        return workspaceService.findAll();
    }

    @POST
    @RolesAllowed("admin")
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new workspace.", description = "Creates a new tag and returns the newly added workspace.")
    public Workspace create(Workspace workspace) {
        return workspaceService.createWorkspace(workspace);
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RequestScoped
    @Operation(summary = "Deletes an workspace.", description = "Deletes an workspace by its id.")
    public void delete(@PathParam("id") Long id) {
        workspaceService.deleteWorkspace(id);
    }

    @PUT
    @Path("/put/{id}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates an workspace.", description = "Updates an workspace by its id.")
    public Workspace update(@PathParam("id") Long id, Workspace workspace) {
        return workspaceService.updateWorkspace(id, workspace);
    }

}
