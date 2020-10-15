
package com.company;

/**
 * Created by IntelliJ IDEA.
 * Laba 5.TriangleFactory
 *
 * @Autor: vovamv
 * @DateTime: 10/14/20|11:12 дп
 * @Version TriangleFactory: 1.0
 */

public class TriangleFactory {
    public static Triangle createTriangleThroughThreeSides(float sideA, float sideB, float sideC){
        return new Triangle(sideA,sideB,sideC);
    }
    public static Triangle createTriangleThoughTwoSidesAndAngle(float sideB, float sideC,double alphaAngle){
            float sideA = TriangleFactory.getThirdSide(sideB,sideC, Math.toRadians(alphaAngle));
            return new Triangle(sideA,sideB, sideC);
    }
    public static Triangle createTriangleThoughSideAndTwoAngles(float sideC,double alphaAngle,double betaAngle){
            float sideB = TriangleFactory.getSecondSide(sideC,Math.toRadians(betaAngle), Math.toRadians(180 - alphaAngle - betaAngle));
            float sideA = TriangleFactory.getThirdSide(sideB,sideC, Math.toRadians(alphaAngle));
            return new Triangle(sideA,sideB,sideC);
    }

    public static Float getThirdSide(float sideB, float sideC, double alphaAngle){
            return (float)(Math.sqrt(Math.pow(sideB, 2) + Math.pow(sideC, 2) - 2 * sideB *
                    sideC * Math.cos(alphaAngle)));
    }

    public static Float getSecondSide(float sideC,double betaAngle, double gammaAngle){
            return (float)(sideC * Math.sin(betaAngle) / Math.sin(gammaAngle));
    }
    public static boolean isValidAngle(double angleAlpha){
        boolean isValid = true;
        if(angleAlpha >= 180 || angleAlpha <= 0) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidAngle(double angleAlpha, double angleBeta){
        boolean isValid = true;
        if(angleAlpha + angleBeta >= 180 ||
                angleAlpha <= 0 || angleBeta <= 0 ) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidSide(float sideA, float sideB, float sideC){
        boolean isValid = true;
        if (sideA + sideB <= sideC ||
                sideB + sideC <= sideA ||
                sideA + sideC <= sideB ||
                 sideA == 0 || sideB == 0 || sideC == 0) {
            isValid = false;
        }

        return isValid;
    }
}
