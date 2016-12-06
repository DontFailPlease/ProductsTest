package view.products.product;

import java.io.File;

/**
 * Created by di on 29.11.16.
 */
public interface ProductEditorInterface {
    void setName(String name);
    void setPrice(String price);
    void setImage(File image);
    void setDescription(String description);
    void changeWindowMode(OpeningMode mode);
}
