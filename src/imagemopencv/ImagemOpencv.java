/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagemopencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Poseidom
 */
public class ImagemOpencv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        Mat imagemcolorida = imread("src\\imagemopencv\\download.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
        
        UTILITARIOS ut = new UTILITARIOS();
        ut.mostraImagem(ut.convertMatToImage(imagemcolorida));
        
        Mat imagemCinza = new Mat();
        Imgproc.cvtColor(imagemcolorida, imagemCinza, Imgproc.COLOR_Luv2LBGR);
        ut.mostraImagem(ut.convertMatToImage(imagemCinza));
        
        
        
        
        
        
    }
    
}
