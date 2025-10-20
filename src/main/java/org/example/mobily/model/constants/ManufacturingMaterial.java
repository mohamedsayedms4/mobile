package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidManufacturingMaterialException;

import java.util.Arrays;

@Getter
public enum ManufacturingMaterial {
    // المواد الأصلية
    PLASTIC("Plastic", "بلاستيك"),
    METAL("Metal", "معدن"),
    GLASS("Glass", "زجاج"),
    CERAMIC("Ceramic", "سيراميك"),
    CERAMIC_SHIELD("Ceramic Shield", "سيراميك شيلد"),
    LEATHER("Leather", "جلد"),
    FABRIC("Fabric", "قماش"),
    RUBBER("Rubber", "مطاط"),
    TITANIUM("Titanium", "تيتانيوم"),
    STAINLESS_STEEL("Stainless Steel", "ستانلس ستيل"),
    ALUMINUM("Aluminum", "ألمنيوم"),
    MAGNESIUM("Magnesium", "مغنيسيوم"),
    CARBON_FIBER("Carbon Fiber", "ألياف كربونية"),
    POLYCARBONATE("Polycarbonate", "بولي كربونيت"),
    GORILLA_GLASS("Gorilla Glass", "زجاج غوريلا"),
    SAPPHIRE_GLASS("Sapphire Glass", "زجاج ياقوتي"),
    TRANSPARENT_GLASS("Transparent Glass", "زجاج شفاف"),
    METAL_ALLOY("Metal Alloy", "سبيكة معدنية"),
    COPPER("Copper", "نحاس"),
    GOLD("Gold", "ذهب"),
    SILVER("Silver", "فضة"),

    // الإضافات الجديدة
    TPU("Thermoplastic Polyurethane", "تي بي يو"),
    ABS("ABS Plastic", "بلاستيك ABS"),
    SILICONE("Silicone", "سيليكون"),
    BRASS("Brass", "نحاس أصفر"),
    ZINC("Zinc", "زنك"),
    CHROME("Chrome", "كروم"),
    WOOD("Wood", "خشب"),
    BAMBOO("Bamboo", "بامبو"),
    PLATINUM("Platinum", "بلاتين"),
    CERAMIC_GLASS("Ceramic Glass", "زجاج سيراميكي");

    private final String en;
    private final String ar;

    ManufacturingMaterial(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public ManufacturingMaterial parseManufacturingMaterial(String value) {
        return Arrays.stream(ManufacturingMaterial.values())
                .filter(type -> type.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidManufacturingMaterialException(value));
    }

    @JsonCreator
    public static ManufacturingMaterial fromString(String value) {
        for (ManufacturingMaterial m : ManufacturingMaterial.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidManufacturingMaterialException(
                value);
    }
}
