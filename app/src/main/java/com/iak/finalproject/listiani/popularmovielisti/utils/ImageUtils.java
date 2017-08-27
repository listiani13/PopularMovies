package com.iak.finalproject.listiani.popularmovielisti.utils;

/**
 * Created by ACER on 26/08/2017.
 */

public class ImageUtils {
    private static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/";

    public static String generateImageUrl(String imagePath){
        return BASE_IMAGE_URL+ "w185" +imagePath;
    }
}
