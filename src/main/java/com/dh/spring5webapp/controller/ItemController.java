/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.ItemCommand;
import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.services.ItemService;
import com.dh.spring5webapp.services.SubCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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
        Response.ResponseBuilder responseBuilder = Response.ok(item);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @POST
    public Response saveItem(ItemCommand item) {
        Item model = item.toDomain();
        model.setSubCategory(subCategoryService.findById(item.getSubCategoryId()));
        Item itemPersisted = service.save(model);
        Response.ResponseBuilder responseBuilder = Response.ok(itemPersisted);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();
    }

    @PUT
    public Response updateItem(Item item) {
        Item itemPersisted = service.save(item);
        Response.ResponseBuilder responseBuilder = Response.ok(itemPersisted);
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

/*
    @POST
    @Path("/{id}/image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response potImage(@PathParam("id") String id, @RequestParam("imagefile") MultipartFile file) {
        service.saveImage(Long.valueOf(id), file);

        model.addAttribute("item", service.findById(Long.valueOf(id)));
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "redirect:/items/update/{id}";
    }
*/

/*
    @GetMapping("/{id}/readimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        Item itemPersisted = service.findById(Long.valueOf(id));

        if (itemPersisted.getImage() != null) {
            byte[] byteArray = new byte[itemPersisted.getImage().length];
            int i = 0;

            for (Byte wrappedByte : itemPersisted.getImage()) {
                byteArray[i++] = wrappedByte;
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
*/

    private void addCorsHeader(Response.ResponseBuilder responseBuilder) {
        responseBuilder.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .header("Access-Control-Allow-Headers",
                        "Access-Control-Allow-Credentials, Access-Control-Allow-Headers, Origin, Accept, Authorization, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    }
}    