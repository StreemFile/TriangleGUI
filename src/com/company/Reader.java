package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TriangleGUI.Reader
 *
 * @Autor: vovamv
 * @DateTime: 10/14/20|5:26 пп
 * @Version Reader: 1.0
 */

public class Reader extends JFrame {
    JButton getTriangleType, getPerimeter, getArea, getInscribedCircle, getDescribedCircle, getMiddleLine, getHeight, getMedian, getBisector, getTriangleInfo, getIsSimilar, toString;
    JButton addTriangleThreeSides, addTriangleTwoSides, addTriangleOneSide;
    JLabel someText;
    JLabel border;
    eHandler handler = new eHandler();
    List<Triangle> myTriangles = new ArrayList<>();

    public Reader(String title) {
        super(title);
        someText = new JLabel("");
        border = new JLabel("________________________________________________________________________________");
        myTriangles.add(TriangleFactory.createTriangleThoughTwoSidesAndAngle(1,2,135));
        myTriangles.add(TriangleFactory.createTriangleThoughTwoSidesAndAngle(6,3,135));
        getTriangleType = new JButton("Вивести тип трикутника");
        getTriangleInfo = new JButton("Вивести інформацію про трикутник");
        toString = new JButton("Вивести сторони та кути трикутника");
        getPerimeter = new JButton("Вивести периметр");
        getArea = new JButton("Вивести площу");
        getInscribedCircle = new JButton("Вивести радіус вписаного кола");
        getDescribedCircle = new JButton("Вивести радіус описаного кола");
        getMiddleLine = new JButton("Вивести середню лінію");
        getHeight = new JButton("Вивести висоту");
        getMedian = new JButton("Вивести медіану");
        getBisector = new JButton("Вивести бісектрису");
        getIsSimilar = new JButton("Порівняти трикутники");
        addTriangleThreeSides = new JButton("Додати трикутник за 3 сторонами");
        addTriangleTwoSides = new JButton("Додати трикутник за 2 сторонами та 1 кутом");
        addTriangleOneSide = new JButton("Додати трикутник за 1 стороною та 2 кутами");
        setLayout(new FlowLayout());
        add(getTriangleInfo);
        add(getTriangleType);
        add(toString);
        add(getPerimeter);
        add(getArea);
        add(getInscribedCircle);
        add(getDescribedCircle);
        add(getMiddleLine);
        add(getHeight);
        add(getMedian);
        add(getBisector);
        add(getIsSimilar);
        add(addTriangleThreeSides);
        add(addTriangleTwoSides);
        add(addTriangleOneSide);
        add(border);
        add(someText);
        getTriangleInfo.addActionListener(handler);
        getTriangleType.addActionListener(handler);
        toString.addActionListener(handler);
        getPerimeter.addActionListener(handler);
        getArea.addActionListener(handler);
        getInscribedCircle.addActionListener(handler);
        getDescribedCircle.addActionListener(handler);
        getMiddleLine.addActionListener(handler);
        getHeight.addActionListener(handler);
        getMedian.addActionListener(handler);
        getBisector.addActionListener(handler);
        addTriangleThreeSides.addActionListener(handler);
        addTriangleTwoSides.addActionListener(handler);
        addTriangleOneSide.addActionListener(handler);
        getIsSimilar.addActionListener(handler);
    }

    public class eHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == getTriangleInfo) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    someText.setText(TriangleService.getTriangleInfo(myTriangles.get(neededTriangle - 1)));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == getTriangleType) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    someText.setText(TriangleService.getTriangleType(myTriangles.get(neededTriangle - 1)));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == toString) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    someText.setText(myTriangles.get(neededTriangle - 1).toString());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == getPerimeter) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    someText.setText("Периметр: " + Math.round(TriangleService.getPerimeter(myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == getArea) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    someText.setText("Площа: " + Math.round(TriangleService.getArea(myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == getInscribedCircle) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    someText.setText("Радіус вписаного кола: " + Math.round(TriangleService.getInscribedCircle(myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == getDescribedCircle) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    someText.setText("Радіус описаного кола: " + Math.round(TriangleService.getDescribedCircle(myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == getMiddleLine) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    myTriangles.get(neededTriangle - 1).getSideA();
                    String side = JOptionPane.showInputDialog("Введіть сторону, навпроти якої потрібно знайти середню лінію (a/b/c): ");
                    if (side.equals("a")) {
                        someText.setText("Середня лінія протилежна до введеної сторони: " + TriangleService.getMiddleLine(myTriangles.get(neededTriangle - 1).getSideA()));
                    } else if (side.equals("b")) {
                        someText.setText("Середня лінія протилежна до введеної сторони: " + TriangleService.getMiddleLine(myTriangles.get(neededTriangle - 1).getSideB()));

                    } else if (side.equals("c")) {
                        someText.setText("Середня лінія протилежна до введеної сторони: " + TriangleService.getMiddleLine(myTriangles.get(neededTriangle - 1).getSideC()));
                    } else {
                        someText.setText("Невірно введена сторона.");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == getHeight) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    myTriangles.get(neededTriangle - 1).getSideA();
                    String side = JOptionPane.showInputDialog("Введіть сторону, до якої проведена висота (a/b/c): ");
                    if (side.equals("a")) {
                        someText.setText("Висота, яка проведена до введеної сторони: " + Math.round(TriangleService.getHeight(myTriangles.get(neededTriangle - 1).getSideA(), myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                    } else if (side.equals("b")) {
                        someText.setText("Висота, яка проведена до введеної сторони: " + Math.round(TriangleService.getHeight(myTriangles.get(neededTriangle - 1).getSideB(), myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);

                    } else if (side.equals("c")) {
                        someText.setText("Висота, яка проведена до введеної сторони: " + Math.round(TriangleService.getHeight(myTriangles.get(neededTriangle - 1).getSideC(), myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                    } else {
                        someText.setText("Невірно введена сторона.");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == getMedian) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    myTriangles.get(neededTriangle - 1).getSideA();
                    String side = JOptionPane.showInputDialog("Введіть сторону, до якої проведена медіана (a/b/c): ");
                    if (side.equals("a")) {
                        someText.setText("Медіана, яка проведена до введеної сторони: " + Math.round(TriangleService.getMedian(myTriangles.get(neededTriangle - 1).getSideA(), myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                    } else if (side.equals("b")) {
                        someText.setText("Медіана, яка проведена до введеної сторони: " + Math.round(TriangleService.getMedian(myTriangles.get(neededTriangle - 1).getSideB(), myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);

                    } else if (side.equals("c")) {
                        someText.setText("Медіана, яка проведена до введеної сторони: " + Math.round(TriangleService.getMedian(myTriangles.get(neededTriangle - 1).getSideC(), myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                    } else {
                        someText.setText("Невірно введена сторона.");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if (e.getSource() == getBisector) {
                try {
                    int neededTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер трикутника: "));
                    myTriangles.get(neededTriangle - 1).getSideA();
                    String side = JOptionPane.showInputDialog("Введіть сторону, до якої проведена бісектриса (a/b/c): ");
                    if (side.equals("a")) {
                        someText.setText("Бісектриса, яка проведена до введеної сторони: " + Math.round(TriangleService.getBisector(myTriangles.get(neededTriangle - 1).getSideA(), myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                    } else if (side.equals("b")) {
                        someText.setText("Бісектриса, яка проведена до введеної сторони: " + Math.round(TriangleService.getBisector(myTriangles.get(neededTriangle - 1).getSideB(), myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);

                    } else if (side.equals("c")) {
                        someText.setText("Бісектриса, яка проведена до введеної сторони: " + Math.round(TriangleService.getBisector(myTriangles.get(neededTriangle - 1).getSideC(), myTriangles.get(neededTriangle - 1)) * 100.0) / 100.0);
                    } else {
                        someText.setText("Невірно введена сторона.");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Трикутник під заданим номером не існує!");
                }
            }
            if(e.getSource() == getIsSimilar){
                try {
                    int firstTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер першого трикутника: "));
                    myTriangles.get(firstTriangle-1).getSideA();
                    int secondTriangle = Integer.parseInt(JOptionPane.showInputDialog("Введіть номер другого трикутника: "));
                    myTriangles.get(secondTriangle-1).getSideA();
                    someText.setText(TriangleService.getIsSimilar(myTriangles.get(firstTriangle-1),myTriangles.get(secondTriangle-1)));
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Один з трикутників не існує!");
                }
            }
            if (e.getSource() == addTriangleThreeSides) {
                try {
                    float sideA = Integer.parseInt(JOptionPane.showInputDialog("Введіть сторону a: "));
                    float sideB = Integer.parseInt(JOptionPane.showInputDialog("Введіть сторону b: "));
                    float sideC = Integer.parseInt(JOptionPane.showInputDialog("Введіть сторону c: "));
                    if(TriangleFactory.isValidSide(sideA,sideB,sideC)) {
                        myTriangles.add(TriangleFactory.createTriangleThroughThreeSides(sideA, sideB, sideC));
                    }else {
                        JOptionPane.showMessageDialog(null, "Трикутник з заданими сторонами не може існувати!");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Введіть цифри!");
                }
            }
            if (e.getSource() == addTriangleTwoSides) {
                try {
                    float sideB = Integer.parseInt(JOptionPane.showInputDialog("Введіть сторону b: "));
                    float sideC = Integer.parseInt(JOptionPane.showInputDialog("Введіть сторону c: "));
                    double angleAlpha = Integer.parseInt(JOptionPane.showInputDialog("Введіть кут альфа: "));
                    if(TriangleFactory.isValidAngle(angleAlpha)){
                        myTriangles.add(TriangleFactory.createTriangleThoughTwoSidesAndAngle(sideB, sideC, angleAlpha));
                    }else {
                        JOptionPane.showMessageDialog(null, "Трикутник з заданим кутом не може існувати!");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Введіть цифри!");
                }
            }
            if (e.getSource() == addTriangleOneSide) {
                try {
                    float sideC = Integer.parseInt(JOptionPane.showInputDialog("Введіть сторону c: "));
                    double angleAlpha = Integer.parseInt(JOptionPane.showInputDialog("Введіть кут альфа: "));
                    double angleBeta = Integer.parseInt(JOptionPane.showInputDialog("Введіть кут бета: "));
                    if(TriangleFactory.isValidAngle(angleAlpha,angleBeta)) {
                        myTriangles.add(TriangleFactory.createTriangleThoughSideAndTwoAngles(sideC, angleAlpha, angleBeta));
                    } else {
                        JOptionPane.showMessageDialog(null, "Трикутник з заданими кутами не може існувати!");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Введіть цифри!");
                }
            }
        }
    }


}
