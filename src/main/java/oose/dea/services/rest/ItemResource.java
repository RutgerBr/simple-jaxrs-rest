package oose.dea.services.rest;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path(("items"))
public class ItemResource
{
    List<Item> items = new ArrayList<>();

    @GET
    @Produces("text/html")
    public String getTextItems()
    {
        return "bread, butter";
    }

    @GET
    @Produces("application/json")
    public List<String> getJsonItems()
    {
        List<String> food = new ArrayList<>();
        food.add("bread");
        food.add("butter");

        return food;
    }

    @GET
    @Path("{sku}")
    @Produces("application/json")
    public Item getJsonItem(@PathParam("sku") String sku)
    {
        items.add(new Item ("asdf", "catagorie", "titel"));

        Item returnItem = new Item();
        for (Item item : items)
        {
            if (sku.equals(item.getSku()))
            {
                returnItem = item;
            }
        }
        return returnItem;
    }

    @POST
    @Consumes("application/json")
    public void addItem(Item item)
    {
        items.add(item);
    }

    @DELETE
    @Path("{sku}")
    public Item deleteItem(@PathParam("sku") final String sku)
    {
        items.removeIf(item -> item.getSku().equals(sku));
    }
}
