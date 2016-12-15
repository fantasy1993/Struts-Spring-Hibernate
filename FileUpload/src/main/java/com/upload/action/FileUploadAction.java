package com.upload.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhuxinquan on 16-12-14.
 */
public class FileUploadAction extends ActionSupport {

    private List<File> upload;

    public List<File> getUpload() {
        return upload;
    }

    public void setUpload(List<File> upload) {
        this.upload = upload;
    }

    public List<String> getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(List<String> uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public List<String> getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(List<String> uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private List<String> uploadContentType;

    private List<String> uploadFileName;

    private String result;

    @Override
    public String execute() throws Exception {
//        String path = ServletActionContext.getServletContext().getRealPath("/file");
        String path = "/home/file";
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        //循环将批量上传的文件保存到本地
        for(int i=0;i<upload.size();i++){
            FileUtils.copyFile(upload.get(i),
                    new File(file, new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "_" + String.valueOf(uploadFileName.get(i).toString().hashCode()) + "_" + uploadFileName.get(i)));
        }

        result="上传成功！";

        return SUCCESS;
    }
}
