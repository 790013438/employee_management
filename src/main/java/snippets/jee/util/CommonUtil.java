package snippets.jee.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

public final class CommonUtil {

    private CommonUtil() {
        throw new AssertionError();
    }

    /**
     * 压缩图片(将图片按照指定的尺寸写为PNG格式的图片)
     * @param inputStream 图片二进制数据输入流
     * @param file 目标文件
     * @param width 压缩后的宽度
     * @param height 压缩后的高度
     * @throws IOException 读写文件时可能引发IOException
     */
    public static void compressImage(InputStream inputStream, File file, 
            int width, int height) throws IOException {
        BufferedImage oldImage = ImageIO.read(inputStream);
        BufferedImage newImage = new BufferedImage(width, height, 
                BufferedImage.TYPE_INT_RGB);
        newImage.getGraphics().drawImage(oldImage, 0, 0, width, height, null);
        ImageIO.write(newImage, "PNG", file);
    }

    /**
     * 获得全局唯一的文件名
     */
    public static String getUniqueFilename() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取文件名中的后缀名
     * @param filename 文件名
     * @return 后缀名
     */
    public static String getFilenameSuffix(String filename) {
        // assert filename != null;
        int index = filename.lastIndexOf(".");
        return index > 0 && index < filename.length() - 1 ? 
            filename.substring(index) : "";
    }

    /**
     * 将时间日期格式化成字符串
     * @param pattern 样式
     * @param date 时间日期对象
     * @return 格式化后的时间日期字符串
     */
    public static String dateToString(String pattern, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * 将字符串解析成时间日期
     * @param pattern 样式
     * @param str 时间日期字符串
     * @return 时间日期对象
     */
    public static Date stringToDate(String pattern, String str) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
