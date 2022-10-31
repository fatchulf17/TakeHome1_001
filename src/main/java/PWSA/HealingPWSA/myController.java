/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PWSA.HealingPWSA;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lenovo
 */

@Controller
public class myController {
    
    @RequestMapping("/nexthalaman")
    public String next(
            @RequestParam(value = "nama") String isipertama,
            @RequestParam(value= "alamat") String isikedua,
            @RequestParam(value= "foto") MultipartFile foto,
            Model kurir
    )throws IOException{
        byte[] img = foto.getBytes();
        
        String image = Base64.encodeBase64String(img);  
        String imglink = "data:image/png;base64,".concat(image);
        kurir.addAttribute("paket1", isipertama);
        kurir.addAttribute("paket2", isikedua);
        kurir.addAttribute("foto1", imglink);
        
        return "viewpage";
    }
}