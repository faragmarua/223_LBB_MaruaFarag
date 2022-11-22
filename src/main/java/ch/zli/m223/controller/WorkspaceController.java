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
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all workspaces.", description = "Returns a list of all workspaces.")
    public List<Workspace> index() {
        return workspaceService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new workspace.", description = "Creates a new tag and returns the newly added workspace.")
    public Workspace create(Workspace workspace) {
        return workspaceService.createWorkspace(workspace);
    }

    @Path("/{id}")
    @DELETE
    @Operation(summary = "Deletes an workspace.", description = "Deletes an workspace by its id.")
    public void delete(@PathParam("id") Long id) {
        workspaceService.deleteWorkspace(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(summary = "Updates an workspace.", description = "Updates an workspace by its id.")
    public Workspace update(@PathParam("id") Long id, Workspace workspace) {
        return workspaceService.updateWorkspace(id, workspace);
    }

}
