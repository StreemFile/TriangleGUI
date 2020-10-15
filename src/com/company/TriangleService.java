

package com.company;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Laba 5.TriangleService
 *
 * @Autor: vovamv
 * @DateTime: 10/14/20|11:20 дп
 * @Version TriangleService: 1.0
 */

public class TriangleService {
    public static Double getAlphaAngle(Triangle thisTriangle) {

            return Math.acos((thisTriangle.getSideB() * thisTriangle.getSideB() + thisTriangle.getSideC() * thisTriangle.getSideC() -
                    thisTriangle.getSideA() * thisTriangle.getSideA()) / (2 * thisTriangle.getSideB() * thisTriangle.getSideC()));

    }

    public static Double getBetaAngle(Triangle thisTriangle) {

            return Math.acos((thisTriangle.getSideA() * thisTriangle.getSideA() + thisTriangle.getSideC() * thisTriangle.getSideC() -
                    thisTriangle.getSideB() * thisTriangle.getSideB()) / (2 * thisTriangle.getSideA() * thisTriangle.getSideC()));

    }

    public static Double getGammaAngle(Triangle thisTriangle) {

            return Math.acos((thisTriangle.getSideB() * thisTriangle.getSideB() + thisTriangle.getSideA() * thisTriangle.getSideA() -
                    thisTriangle.getSideC() * thisTriangle.getSideC()) / (2 * thisTriangle.getSideB() * thisTriangle.getSideA()));

    }

    private static Boolean isRight(Triangle thisTriangle) {

            return Math.round(Math.toDegrees(getAlphaAngle(thisTriangle))*1000.0)/1000.0 == 90 ||
                    Math.round(Math.toDegrees(getBetaAngle(thisTriangle))*1000.0)/1000.0 == 90 ||
                    Math.round(Math.toDegrees(getGammaAngle(thisTriangle))*1000.0)/1000.0 == 90;

    }

    public static Boolean isEquilateral(Triangle thisTriangle) {

            return Math.round(getAlphaAngle(thisTriangle)*1000.0)/1000.0 == Math.round(getBetaAngle(thisTriangle)*1000.0)/1000.0 && Math.round(getBetaAngle(thisTriangle)*1000.0)/1000.0 == Math.round(getGammaAngle(thisTriangle)*1000.0)/1000.0;

    }

    public static Boolean isIsosceles(Triangle thisTriangle) {

            return Math.round(getAlphaAngle(thisTriangle)*10000.0)/10000.0 == Math.round(getBetaAngle(thisTriangle)*10000.0)/10000.0 || Math.round(getBetaAngle(thisTriangle)*10000.0)/10000.0 == Math.round(getGammaAngle(thisTriangle)*10000.0)/10000.0 || Math.round(getAlphaAngle(thisTriangle)*10000.0)/10000.0 == Math.round(getGammaAngle(thisTriangle)*10000.0)/10000.0;
    }

    public static Boolean isScalene(Triangle thisTriangle) {

            return getAlphaAngle(thisTriangle) != getBetaAngle(thisTriangle) && getBetaAngle(thisTriangle) != getGammaAngle(thisTriangle) && getAlphaAngle(thisTriangle) != getGammaAngle(thisTriangle);

    }

    public static Boolean isAcute(Triangle thisTriangle) {

            return Math.toDegrees(getAlphaAngle(thisTriangle)) < 90 &&
                    Math.toDegrees(getBetaAngle(thisTriangle)) < 90 &&
                    Math.toDegrees(getGammaAngle(thisTriangle)) < 90;

    }

    public static Boolean isObtuse(Triangle thisTriangle) {

            return Math.toDegrees(getAlphaAngle(thisTriangle)) > 90 ||
                    Math.toDegrees(getBetaAngle(thisTriangle)) > 90 ||
                    Math.toDegrees(getGammaAngle(thisTriangle)) > 90;

    }

    public static String getTriangleType(Triangle thisTriangle) {
        String type = "";

            type += "Цей трикутник є ";
            if (isRight(thisTriangle)) {
                type +="прямокутним ";
            }
            if (isEquilateral(thisTriangle)) {
                type +="рівностороннім ";
            } else if (isIsosceles(thisTriangle)) {
                type +="рівнобедреним ";
            } else if (isScalene(thisTriangle)) {
                type +="різностороннім ";
            }
            if (isObtuse(thisTriangle)) {
                type +="тупокутним трикутником.";
            } else if (isAcute(thisTriangle)) {
                type +="гострокутним трикутником.";
            }
            return type;
    }

    public static Double getPerimeter(Triangle thisTriangle) {

            double perimeter;
            perimeter = thisTriangle.getSideA() + thisTriangle.getSideB() + thisTriangle.getSideC();
            return perimeter;

    }

    public static Double getArea(Triangle thisTriangle) {

            double area;
            double halfPerimeter = getPerimeter(thisTriangle) / 2;
            area = Math.sqrt(halfPerimeter * (halfPerimeter - thisTriangle.getSideA()) *
                    (halfPerimeter - thisTriangle.getSideB()) * (halfPerimeter - thisTriangle.getSideC()));
            return area;

    }

    public static Double getInscribedCircle(Triangle thisTriangle) {

            double inscribedCircle;
            inscribedCircle = getArea(thisTriangle) / (getPerimeter(thisTriangle) / 2);
            return inscribedCircle;

    }

    public static Double getDescribedCircle(Triangle thisTriangle) {

            double describedCircle;
            describedCircle = (thisTriangle.getSideA() * thisTriangle.getSideB() * thisTriangle.getSideC()) / (4 * getArea(thisTriangle));
            return describedCircle;

    }

    public static Double getMiddleLine(double neededSide) {
        try {
            double middleLine;
            middleLine = neededSide / 2;
            return middleLine;
        } catch (NullPointerException e){
            System.out.println("Трикутник не існує");
            return null;
        }
    }

    public static Double getHeight(double neededSide, Triangle thisTriangle) {

            double height;
            height = (2 * getArea(thisTriangle)) / neededSide;
            return height;

    }

    public static Double getMedian(double neededSide, Triangle thisTriangle) {
            double median;

            if (neededSide == thisTriangle.getSideA()) {
                median = Math.sqrt(2 * thisTriangle.getSideB() * thisTriangle.getSideB() +
                        2 * thisTriangle.getSideC() * thisTriangle.getSideC() - thisTriangle.getSideA() * thisTriangle.getSideA()) / 2;
            } else if (neededSide == thisTriangle.getSideB()) {
                median = Math.sqrt(2 * thisTriangle.getSideA() * thisTriangle.getSideA() +
                        2 * thisTriangle.getSideC() * thisTriangle.getSideC() - thisTriangle.getSideB() * thisTriangle.getSideB()) / 2;
            } else {
                median = Math.sqrt(2 * thisTriangle.getSideB() * thisTriangle.getSideB() +
                        2 * thisTriangle.getSideA() * thisTriangle.getSideA() - thisTriangle.getSideC() * thisTriangle.getSideC()) / 2;
            }
            return median;
    }

    public static Double getBisector(double neededSide, Triangle thisTriangle) {
            double bisector;

            double halfPerimeter = getPerimeter(thisTriangle) / 2;
            if (neededSide == thisTriangle.getSideA()) {
                bisector = (2 * Math.sqrt(thisTriangle.getSideB() * thisTriangle.getSideC() * halfPerimeter *
                        (halfPerimeter - thisTriangle.getSideA()))) / (thisTriangle.getSideB() + thisTriangle.getSideC());
            } else if (neededSide == thisTriangle.getSideB()) {
                bisector = (2 * Math.sqrt(thisTriangle.getSideA() * thisTriangle.getSideC() * halfPerimeter *
                        (halfPerimeter - thisTriangle.getSideB()))) / (thisTriangle.getSideA() + thisTriangle.getSideC());
            } else {
                bisector = (2 * Math.sqrt(thisTriangle.getSideA() * thisTriangle.getSideB() * halfPerimeter *
                        (halfPerimeter - thisTriangle.getSideC()))) / (thisTriangle.getSideA() + thisTriangle.getSideB());
            }
            return bisector;
    }

    public static String getTriangleInfo(Triangle thisTriangle) {
            return  thisTriangle.toString() + "<html>" + getTriangleType(thisTriangle) + "<br>" +
                    String.format("Периметр трикутника: %.2f", getPerimeter(thisTriangle)) + "<br>" +
                    String.format("\nПлоща трикутника: %.2f", getArea(thisTriangle)) + "<br>" +
                    String.format("\nРадіус вписаного кола в трикутник: %.2f", getInscribedCircle(thisTriangle)) + "<br>" +
                    String.format("\nРадіус описаного кола в трикутник: %.2f", getDescribedCircle(thisTriangle)) + "<br>" +
                    String.format("\nСередня лінія навпроти сторони a: %.2f", getMiddleLine(thisTriangle.getSideA())) + "<br>" +
                    String.format("\nСередня лінія навпроти сторони b: %.2f", getMiddleLine(thisTriangle.getSideB())) + "<br>" +
                    String.format("\nСередня лінія навпроти сторони c: %.2f", getMiddleLine(thisTriangle.getSideC())) + "<br>" +
                    String.format("\nВисота опущена з вершини а: %.2f", getHeight(thisTriangle.getSideA(), thisTriangle)) + "<br>" +
                    String.format("\nВисота опущена з вершини b: %.2f", getHeight(thisTriangle.getSideB(), thisTriangle)) + "<br>" +
                    String.format("\nВисота опущена з вершини а: %.2f", getHeight(thisTriangle.getSideC(), thisTriangle)) + "<br>" +
                    String.format("\nМедіана опущена з вершини а: %.2f", getMedian(thisTriangle.getSideA(), thisTriangle)) + "<br>" +
                    String.format("\nМедіана опущена з вершини b: %.2f", getMedian(thisTriangle.getSideB(), thisTriangle)) + "<br>" +
                    String.format("\nМедіана опущена з вершини c: %.2f", getMedian(thisTriangle.getSideC(), thisTriangle)) + "<br>" +
                    String.format("\nБісектриса опущена з вершини а: %.2f", getBisector(thisTriangle.getSideA(), thisTriangle)) + "<br>" +
                    String.format("\nБісектриса опущена з вершини b: %.2f", getBisector(thisTriangle.getSideB(), thisTriangle)) + "<br>" +
                    String.format("\nБісектриса опущена з вершини c: %.2f", getBisector(thisTriangle.getSideC(), thisTriangle)) +"<br></html>";
    }

    public static String getIsSimilar(Triangle thisTriangle, Triangle otherTriangle) {
            if (isSimilar(thisTriangle, otherTriangle)) {
                return "Трикутники подібні";
            } else {
                return "Трикутники не подібні.";
            }
    }
//
//    public static String getRatio(Triangle thisTriangle, Triangle otherTriangle) {
//            List<Float> thisTriangleSides = new ArrayList<>();
//            thisTriangleSides.add(thisTriangle.getSideA());
//            thisTriangleSides.add(thisTriangle.getSideB());
//            thisTriangleSides.add(thisTriangle.getSideC());
//            Collections.sort(thisTriangleSides);
//
//            List<Float> otherTriangleSides = new ArrayList<>();
//            otherTriangleSides.add(otherTriangle.getSideA());
//            otherTriangleSides.add(otherTriangle.getSideB());
//            otherTriangleSides.add(otherTriangle.getSideC());
//            Collections.sort(otherTriangleSides);
//
//            double firstTriangleSide = Math.round(thisTriangleSides.get(2));
//            double secondTriangleSide = Math.round(otherTriangleSides.get(2));
//            System.out.println("F: " + firstTriangleSide + " S: " + secondTriangleSide);
//
//            while ((firstTriangleSide % 2 == 0 && secondTriangleSide % 2 == 0) ||
//                    (firstTriangleSide % 3 == 0 && secondTriangleSide % 3 == 0) ||
//                    (firstTriangleSide % 5 == 0 && secondTriangleSide % 5 == 0) ||
//                    (firstTriangleSide % 7 == 0 && secondTriangleSide % 7 == 0)) {
//                if (firstTriangleSide % 2 == 0 && secondTriangleSide % 2 == 0) {
//                    firstTriangleSide /= 2;
//                    secondTriangleSide /= 2;
//                } else if (firstTriangleSide % 3 == 0 && secondTriangleSide % 3 == 0) {
//                    firstTriangleSide /= 3;
//                    secondTriangleSide /= 3;
//                } else if (firstTriangleSide % 5 == 0 && secondTriangleSide % 5 == 0) {
//                    firstTriangleSide /= 5;
//                    secondTriangleSide /= 5;
//                } else {
//                    firstTriangleSide /= 7;
//                    secondTriangleSide /= 7;
//                }
//            }
//            return (int) firstTriangleSide + ":" + (int) secondTriangleSide;
//    }
    public static Boolean isSimilar(Triangle thisTriangle, Triangle otherTriangle){
        boolean isSimilar = false;

        List<Double> thisTriangleAngles = new ArrayList<>();
        thisTriangleAngles.add(Math.round(Math.toDegrees(TriangleService.getAlphaAngle(thisTriangle))*1000.0)/1000.0);
        thisTriangleAngles.add(Math.round(Math.toDegrees(TriangleService.getBetaAngle(thisTriangle))*1000.0)/1000.0);
        thisTriangleAngles.add(Math.round(Math.toDegrees(TriangleService.getGammaAngle(thisTriangle))*1000.0)/1000.0);
        Collections.sort(thisTriangleAngles);
        System.out.println("First " + thisTriangleAngles.get(0) +  " " + thisTriangleAngles.get(1) +  " " + thisTriangleAngles.get(2) +  " ");

        List<Double> otherTriangleAngles = new ArrayList<>();
        otherTriangleAngles.add(Math.round(Math.toDegrees(TriangleService.getAlphaAngle(otherTriangle))*1000.0)/1000.0);
        otherTriangleAngles.add(Math.round(Math.toDegrees(TriangleService.getBetaAngle(otherTriangle))*1000.0)/1000.0);
        otherTriangleAngles.add(Math.round(Math.toDegrees(TriangleService.getGammaAngle(otherTriangle))*1000.0)/1000.0);
        Collections.sort(otherTriangleAngles);
        System.out.println("Second " + otherTriangleAngles.get(0) +  " " + otherTriangleAngles.get(1) +  " " + otherTriangleAngles.get(2) +  " ");

        if(thisTriangleAngles.get(0).equals(otherTriangleAngles.get(0)) &&
                thisTriangleAngles.get(1).equals(otherTriangleAngles.get(1)) &&
                thisTriangleAngles.get(2).equals(otherTriangleAngles.get(2))) {
            isSimilar = true;
        }
        return isSimilar;
    }
}
