package eu.datagraphics.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MasterMindDTO {

    @NotNull(message = "Can not be empty")
    @Size(min = 2, max = 5, message = "not in range")
    private String chellange;

    public String getChellange() {
        return chellange;
    }

    public void setChellange(String chellange) {
        this.chellange = chellange;
    }
}
