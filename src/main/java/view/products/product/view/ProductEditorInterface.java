package view.products.product.view;

import java.io.File;

/**
 * Created by di on 29.11.16.
 */
public interface ProductEditorInterface {
    void setPanelName(String name);
    void setName(String name);
    void setPrice(Integer price);
    void setImage(File image);
    void setDescription(String description);
}
