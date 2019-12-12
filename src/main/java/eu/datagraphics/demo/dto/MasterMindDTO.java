package eu.datagraphics.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MasterMindDTO {

    @NotNull(message = "Can not be empty")
    @Size(min = 4, max = 4, message = "Should contain 4 guesses")
    private String chellange;

    public String getChellange() {
        return chellange;
    }

    public void setChellange(String chellange) {
        this.chellange = chellange;
    }
}
