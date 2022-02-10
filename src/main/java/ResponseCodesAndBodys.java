import org.json.JSONObject;

public class ResponseCodesAndBodys {
    public final int CODE_403_FORBIDDEN = 403;
    public final String RESPONSE_BODY_403_REQUIRED_FIELD = new JSONObject()
            .put("success",false)
            .put("message","Email, password and name are required fields")
            .toString();
    public final String RESPONSE_BODY_403_ALREADY_EXIST = new JSONObject()
            .put("success",false)
            .put("message","User already exists")
            .toString();


}
