package com.javarush.task.task16.task1631;


import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Андрей on 22.03.2017.
 */
public class ImageReaderFactory {

    public static ImageReader getImageReader (ImageTypes reader) {
        if (reader==ImageTypes.JPG)
        return new JpgReader();
        else if (reader==ImageTypes.PNG)
            return new PngReader();
        else if (reader==ImageTypes.BMP)
            return new BmpReader();
        else
        throw new IllegalArgumentException("Неизвестный тип картинки");

    }
}
