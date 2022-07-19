package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {

    private String userId;
    private String name;
    private int code;
    private String message;

    public UserResponseDTO(){
    }

    public UserResponseDTO(String userId, String name, int code, String message){

        this.userId = userId;
        this.name = name;
        this.code = code;
        this.message = message;
    }
}
