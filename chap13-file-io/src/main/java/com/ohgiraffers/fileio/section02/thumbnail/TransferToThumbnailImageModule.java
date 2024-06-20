package com.ohgiraffers.fileio.section02.thumbnail;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class TransferToThumbnailImageModule {
	
	public void changeThumbnail(String originFilePath, String saveFilePath, String saveFileName) throws IOException {

        File originFile = new File(originFilePath);

        File thumbFilePath = new File(saveFilePath);

        if(!thumbFilePath.exists()) {
            thumbFilePath.mkdirs();
        }
        String thumbFileName = saveFileName;

        Thumbnails.of(originFile)
                .size(100, 80)
                .toFile(saveFilePath + thumbFileName);
        
        System.out.println("[SAVE PATH] " + (thumbFilePath + thumbFileName));
        System.out.println("썸네일 변환 성공!");
	}

}
