package view.products.product.builder;

import dao.model.Product;

/**
 * Created by di on 07.12.16.
 */
public class ProductEditorFactory {

    public static void createEditor()
    {
        Waiter waiter = new Waiter();
        waiter.setBuilder(new AddModeProductEditor());
        waiter.constructProductEditor();

    }

    public static void createEditor(Product selectedProduct)
    {
        Waiter waiter = new Waiter();
        if(selectedProduct == null) {
            waiter.setBuilder(new AddModeProductEditor());
        } else {
            waiter.setBuilder(new EditModeProductEditor(selectedProduct));
        }
        waiter.constructProductEditor();
    }
}
