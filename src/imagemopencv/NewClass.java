/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagemopencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Poseidom
 */
public class NewClass {
    
    
    public static void main(String[] args) {
        
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        Mat imagemcolorida = imread("src\\pessoas\\pessoas3.jpg");
        Mat imagemcinza = new Mat();
        Imgproc.cvtColor(imagemcolorida, imagemcinza, Imgproc.COLOR_BGR2GRAY);
        
        
        CascadeClassifier classificador = new CascadeClassifier("src\\CASCATES\\haarcascade_frontalface_default.xml");
        
        MatOfRect faceDetectadas = new MatOfRect();
        classificador.detectMultiScale(imagemcinza, faceDetectadas,
                
                1.19,//scale factor
                3, //minneighbors
                0,//flags
                new Size(30,30), //MinSize
                new Size(100,100)); //MaxSize;
        
        
        
        
        System.out.println(faceDetectadas.toArray().length);
        for(Rect rect: faceDetectadas.toArray()){
            System.out.println(rect.x + " "+ rect.y+ " "+ rect.width +" "+rect.height);
            Imgproc.rectangle(imagemcolorida, new Point(rect.x, rect.y),new Point(rect.x + rect.width, rect.y+rect.height), new Scalar(0,0,255),2);
            
            
        }
        
        UTILITARIOS ut = new UTILITARIOS();
        
        ut.mostraImagem(ut.convertMatToImage(imagemcolorida));
        
        
               
        
        
    }
    
}
