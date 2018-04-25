/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.ItemCommand;
import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.services.ItemService;
import com.dh.spring5webapp.services.SubCategoryService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/items")
@Produces("application/json")
@CrossOrigin
public class ItemController {
    private ItemService service;
    private SubCategoryService subCategoryService;

    public ItemController(ItemService service, SubCategoryService subCategoryService) {
        this.service = service;
        this.subCategoryService = subCategoryService;
    }

    @GET
    public Response getItems() {
        List<ItemCommand> items = new ArrayList<>();
        service.findAll().forEach(item -> {
            ItemCommand itemCommand = new ItemCommand(item);
            items.add(itemCommand);
        });
        Response.ResponseBuilder responseBuilder = Response.ok(items);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @GET
    @Path("/{id}")
    public Response getItemsById(@PathParam("id") @NotNull Long id) {
        Item item = service.findById(id);
        Response.ResponseBuilder responseBuilder = Response.ok(new ItemCommand(item));
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @POST
    public Response saveItem(ItemCommand item) {
        Item model = item.toDomain();
        model.setSubCategory(subCategoryService.findById(item.getSubCategoryId()));
        Item itemPersisted = service.save(model);
        Response.ResponseBuilder responseBuilder = Response.ok(new ItemCommand(itemPersisted));
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @PUT
    public Response updateItem(Item item) {
        Item itemPersisted = service.save(item);
        Response.ResponseBuilder responseBuilder = Response.ok(new ItemCommand(itemPersisted));
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteItem(@PathParam("id") String id) {
        service.deleteById(Long.valueOf(id));
        Response.ResponseBuilder responseBuilder = Response.ok();
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @OPTIONS
    public Response prefligth() {
        Response.ResponseBuilder responseBuilder = Response.ok();
        addCorsHeader(responseBuilder);
        responseBuilder.allow("OPTIONS").build();
        return responseBuilder.build();
    }

    @Path("/{id}/image")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@PathParam("id") String id,
                               @FormDataParam("file") InputStream file,
                               @FormDataParam("file") FormDataContentDisposition fileDisposition) {
        service.saveImage(Long.valueOf(id), file);
        return Response.ok("Data uploaded successfully !!").build();
    }

    private void addCorsHeader(Response.ResponseBuilder responseBuilder) {
        responseBuilder.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .header("Access-Control-Allow-Headers",
                        "Access-Control-Allow-Credentials, Access-Control-Allow-Headers, Origin, Accept, Authorization, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    }
}    