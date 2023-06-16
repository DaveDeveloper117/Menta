package com.davedev.menta.onboarding;

/*
 * Nombre del Proyecto: Menta
 * Desarrollador: David Butrón
 * Perfil de Github: https://github.com/DaveDeveloper117/
 * Diseñador UI/UX: Valam Matías https://github.com/OmniSk8
 * Diseñador UI/UX: Marco Malagon https://github.com/SpartanTerra69
 * Licencia: https://github.com/DaveDeveloper117/Menta/blob/master/LICENSE
 * URL del Repositorio: https://github.com/DaveDeveloper117/Menta.git
 */
public class ScreenItem {

    String Title, Description;
    int ScreenImg;

    public ScreenItem(String title, String description, int screenImg) {
        Title = title;
        Description = description;
        ScreenImg = screenImg;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

}
