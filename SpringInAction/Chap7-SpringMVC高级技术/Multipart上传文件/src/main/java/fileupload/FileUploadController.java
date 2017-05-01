package fileupload;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by zhuxinquan on 17-4-23.
 */
@Controller
public class FileUploadController {
    private static final Logger log = LogManager.getLogger("FileUpload");
    @ResponseBody
    @RequestMapping("/fileUpload")
    public Object fileUpload(MultipartFile uploadFile) {
        log.info( () -> uploadFile.getOriginalFilename());
        log.info( () -> uploadFile.getSize());
        log.info( () -> uploadFile.getName());

        return "hello world!";
    }
}
