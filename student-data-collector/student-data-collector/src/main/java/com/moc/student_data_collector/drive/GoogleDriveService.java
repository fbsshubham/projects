//package com.moc.student_data_collector.drive;
//
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.auth.oauth2.TokenResponse;
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
//import com.google.api.client.http.ByteArrayContent;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.gson.GsonFactory;
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.model.*;
//
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.Collections;
//
//@Service
//public class GoogleDriveService {
//
//    private static final String APPLICATION_NAME = "Student Upload (Manual Auth)";
//    private static final String ACCESS_TOKEN = "PASTE_YOUR_ACCESS_TOKEN";
//    private static final String REFRESH_TOKEN = "PASTE_YOUR_REFRESH_TOKEN";
//    private static final String CLIENT_ID = "PASTE_CLIENT_ID";
//    private static final String CLIENT_SECRET = "PASTE_CLIENT_SECRET";
//
//    private Drive drive;
//
//    public GoogleDriveManualService() throws Exception {
//        this.drive = createDriveService();
//    }
//
//    private Drive createDriveService() throws Exception {
//        NetHttpTransport transport = new NetHttpTransport();
//        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
//
//        TokenResponse tokenResponse = new TokenResponse()
//                .setAccessToken(ACCESS_TOKEN)
//                .setRefreshToken(REFRESH_TOKEN);
//
//        Credential credential = new GoogleCredential.Builder()
//                .setTransport(transport)
//                .setJsonFactory(jsonFactory)
//                .setClientSecrets(CLIENT_ID, CLIENT_SECRET)
//                .build()
//                .setFromTokenResponse(tokenResponse);
//
//        return new Drive.Builder(transport, jsonFactory, credential)
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }
//
//    public String uploadFile(String fileName, byte[] fileData, String mimeType, String folderId) throws IOException {
//        File fileMetadata = new File();
//        fileMetadata.setName(fileName);
//        fileMetadata.setParents(Collections.singletonList(folderId));
//
//        ByteArrayContent mediaContent = new ByteArrayContent(mimeType, fileData);
//
//        File file = drive.files().create(fileMetadata, mediaContent)
//                .setFields("id")
//                .execute();
//
//        return file.getId();
//    }
//
//    public String createFolder(String name, String parentId) throws IOException {
//        File fileMetadata = new File();
//        fileMetadata.setName(name);
//        fileMetadata.setMimeType("application/vnd.google-apps.folder");
//
//        if (parentId != null) {
//            fileMetadata.setParents(Collections.singletonList(parentId));
//        }
//
//        File folder = drive.files().create(fileMetadata)
//                .setFields("id")
//                .execute();
//
//        return folder.getId();
//    }
//}
