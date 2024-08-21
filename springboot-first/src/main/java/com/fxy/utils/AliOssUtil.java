package com.fxy.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Component
public class AliOssUtil {
//    需要单独配置
    @Autowired
    private AliOssProperties aliOssProperties;


    // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
    //EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
    public String upload(MultipartFile file) throws Exception {


        String accessKeyId = aliOssProperties.getAccessKeyId();
        String accessKeySecret = aliOssProperties.getAccessKeySecret();
        String endpoint = aliOssProperties.getEndpoint();
        String bucketName = aliOssProperties.getBucketName();
        //获取上传文件的输入流
        InputStream inputStream = file.getInputStream();

        //避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        //后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //uuid
        String UUID = java.util.UUID.randomUUID().toString();
        //拼接
        String fileName = UUID + suffix;
        //上传文件到OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, fileName, inputStream);
        //文件访问URL
        String url = endpoint.split("//")[0] + "//" + bucketName + "/" + fileName;
        ossClient.shutdown();
        return url;
    }

}
