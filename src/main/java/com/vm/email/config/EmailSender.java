package com.vm.email.config;

import com.vm.email.domain.MailObject;
import lombok.extern.apachecommons.CommonsLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class EmailSender {

    //private static final Logger log = LoggerFactory.getLogger(EmailSender.class);

    /**
     * Before send mail first prepare @MailObject
     *
     * @param mailObject
     */
    public void prepareAndSend(MailObject mailObject) throws InterruptedException {
        log.info("Mail Send Successfully!");
        Thread.sleep(10000);
        log.info("Check!");
        if (log.isDebugEnabled()) {
            log.debug("Polling mailbox folder: ");
        }
    }
}

/*
public class AddAttachment implements Processor{

        @Override
        public void process(Exchange exchng) throws Exception {
                // TODO Auto-generated method stub

                Message in = exchng.getIn();

        /*	in.addAttachment("payload", new DataHandler(new FileDataSource(
                                "d:/payload.txt")));*/

             /*   exchng.getOut().addAttachment("payload.txt", new DataHandler(new FileDataSource(
                        "d:/payload.txt")));
                        }
                        }



                        > public class AddAttachment implements Processor{
>
>         @Override
>         public void process(Exchange exchng) throws Exception {
>                 // TODO Auto-generated method stub
>
>                 Message in = exchng.getIn();
>
>         /*      in.addAttachment("payload", new DataHandler(new
> FileDataSource(
>                                 "d:/payload.txt")));*/ /*
>
        >                 exchng.getOut().addAttachment("payload.txt", new
        > DataHandler(new
        > FileDataSource(
        >                                 "d:/payload.txt")));
        > }
        > }

https://stackoverflow.com/questions/15947523/apache-camel-enrich-message-with-file-content-on-request
http://www.rgagnon.com/javadetails/java-get-document-sharepoint-library.html
https://github.com/vionita/java-sharepoint-library
https://www.example-code.com/java/sharepoint_download_file.asp
https://stackoverflow.com/questions/29570383/basic-authentication-from-java-to-sharepoint-2013-rest-api
https://vectus.wordpress.com/2014/07/23/sharepoint-2013-rest-api-windows-authentication-java-https-client-defaulthttpclient-ntcredentials-sslcontext-sslsocketfactory/

public void addItem(String itemUrl, File file) throws IOException {
    TempFiles tf = new TempFiles();
    HttpPut request = new HttpPut(itemUrl);
    request.setEntity(new FileEntity(file));
    System.out.println("ITEM URL: " + itemUrl);
    CloseableHttpResponse response = httpClient.execute(target, request, context);
    System.out.println("STATUS CODE POST: " + response.getStatusLine());
    tf.deleteTempFiles();
}

<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.4.1</version>
</dependency>
The authentication to SharePoint works:

public class SharePointClientAuthentication {

public static void main(String[] args) throws Exception {
    CredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(
            new AuthScope(AuthScope.ANY),
            new NTCredentials("username", "password", "https://hostname", "domain"));
    CloseableHttpClient httpclient = HttpClients.custom()
            .setDefaultCredentialsProvider(credsProvider)
            .build();
    try {
        HttpGet httpget = new HttpGet("http://hostname/_api/web/lists");

        System.out.println("Executing request " + httpget.getRequestLine());
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            EntityUtils.consume(response.getEntity());
        } finally {
            response.close();
        }
    } finally {
        httpclient.close();
    }
}
}
}









                        */