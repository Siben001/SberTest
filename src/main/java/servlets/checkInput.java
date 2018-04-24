package servlets;



import javax.servlet.http.HttpServletRequest;

public class checkInput {

    public static Boolean checkInput(String name, HttpServletRequest req){
        Boolean res = Boolean.FALSE;

        if (name.startsWith(" ")){
            req.setAttribute("Error", 4);
            res = Boolean.TRUE;
        }
        else {
            if (name.endsWith(" ")) {
                req.setAttribute("Error", 5);
                res = Boolean.TRUE;
            }
        }
        return res;
    }
}
