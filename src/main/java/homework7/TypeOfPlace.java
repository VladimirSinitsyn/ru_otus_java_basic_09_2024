package homework7;

public enum TypeOfPlace {
    DEEP_FOREST("Глухой лес"),
    PLANE("Равнина"),
    SWAMP("Болото");

    private String type;

    public String getType() {
        return type;
    }
  TypeOfPlace(String type) {
        this.type = type;
  }
    }