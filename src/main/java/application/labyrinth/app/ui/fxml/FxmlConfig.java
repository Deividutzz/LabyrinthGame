package application.labyrinth.app.ui.fxml;

public class FxmlConfig
{
    private String fxmlPath = "/application/labyrinth/ui/fxml/";
    private String cssPath = "/application/labyrinth/ui/css/";

    public void setFxmlPath(String fxmlPath)
    {
        this.fxmlPath = fxmlPath;
    }
    public void setCssPath(String cssPath)
    {
        this.cssPath = cssPath;
    }
    public String getFxmlPath()
    {
        return fxmlPath;
    }
    public String getCssPath()
    {
        return cssPath;
    }
}