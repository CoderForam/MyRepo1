package com;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

public class CaptchaImage {

	private static final String[] NUMBERS = {"0","1","2","3","4","5","6","7","8","9","10"};
	private static final String[] OPERATIONS = {"+", "-", "*"};
	private static final Random RAND = new Random(); // not high entropy, but not a big deal here

    String captchaString = "";

    // Function to generate random captcha image and returns the BufferedImage
    public BufferedImage getCaptchaImage() {
        try {
            Color backgroundColor = Color.white;
            Color borderColor = Color.black;
            Color textColor = Color.black;
            Color circleColor = new Color(190, 160, 150);
            Font textFont = new Font("Verdana", Font.BOLD, 20);
            int charsToPrint = 5;
            int width = 160;
            int height = 50;
            int circlesToDraw = 25;
            float horizMargin = 10.0f;
            double rotationRange = 0.7; 
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
            g.setColor(backgroundColor);
            g.fillRect(0, 0, width, height);

            // lets make some noisey circles
            g.setColor(circleColor);
            for (int i = 0; i < circlesToDraw; i++) {
                int L = (int) (Math.random() * height / 2.0);
                int X = (int) (Math.random() * width - L);
                int Y = (int) (Math.random() * height - L);
                g.draw3DRect(X, Y, L * 2, L * 2, true);
            }
            g.setColor(textColor);
            g.setFont(textFont);
            FontMetrics fontMetrics = g.getFontMetrics();
            int maxAdvance = fontMetrics.getMaxAdvance();
            int fontHeight = fontMetrics.getHeight();

            Map<String,String> captcha = generateNumericCaptcha();
            
            // i removed 1 and l and i because there are confusing to users...
            // Z, z, and N also get confusing when rotated
            // this should ideally be done for every language...
            // 0, O and o removed because there are confusing to users...
            // i like controlling the characters though because it helps prevent confusion
          
            //String elegibleChars = "ABCDEFGHJKLMNPQRSTUVWXYabcdefghjkmnpqrstuvwxy23456789";
           // char[] chars = elegibleChars.toCharArray();
            float spaceForLetters = -horizMargin * 2 + width;
            float spacePerChar = spaceForLetters / (charsToPrint - 1.0f);
            StringBuffer finalString = new StringBuffer();
            if(captcha.get("position").equals("0")) {
        		finalString.append("?").append(captcha.get("operation")).append(captcha.get("second")).append("=").append(captcha.get("third"));
        	}
        	else if(captcha.get("position").equals("1")) {
        		finalString.append(captcha.get("first")).append(captcha.get("operation")).append("?").append("=").append(captcha.get("third"));
        	}
        	else {
        		finalString.append(captcha.get("first")).append(captcha.get("operation")).append(captcha.get("second")).append("=").append("?");
        	}
            System.out.println("Final captcha string : " + finalString);
            System.out.println("captcha length : " + finalString.length());
            for (int i = 0; i < charsToPrint; i++) {
				/*
				 * double randomValue = Math.random(); int randomIndex = (int)
				 * Math.round(randomValue * (chars.length - 1)); char characterToShow =
				 * chars[randomIndex];
				 */ 
            	
            	//finalString.append(characterToShow);

                // this is a separate canvas used for the character so that
                // we can rotate it independently
                //int charWidth = fontMetrics.charWidth(characterToShow);
            	int charWidth = fontMetrics.charWidth(finalString.charAt(i));
                int charDim = Math.max(maxAdvance, fontHeight);
                int halfCharDim = (int) (charDim / 2);
                BufferedImage charImage = new BufferedImage(charDim, charDim, BufferedImage.TYPE_INT_ARGB);
                Graphics2D charGraphics = charImage.createGraphics();
                charGraphics.translate(halfCharDim, halfCharDim);
                double angle = (Math.random() - 0.5) * rotationRange;
                charGraphics.transform(AffineTransform.getRotateInstance(angle));
                charGraphics.translate(-halfCharDim, -halfCharDim);
                charGraphics.setColor(textColor);
                charGraphics.setFont(textFont);
                int charX = (int) (0.5 * charDim - 0.5 * charWidth);
                
                //charGraphics.drawString("" + characterToShow, charX, (int) ((charDim - fontMetrics.getAscent()) / 2 + fontMetrics.getAscent()));
                charGraphics.drawString("" + finalString.charAt(i), charX, (int) ((charDim - fontMetrics.getAscent()) / 2 + fontMetrics.getAscent()));
                float x = horizMargin + spacePerChar * (i) - charDim / 2.0f;
                int y = (int) ((height - charDim) / 2);
                g.drawImage(charImage, (int) x, y, charDim, charDim, null, null);
                charGraphics.dispose();
            }
            g.setColor(borderColor);
            g.drawRect(0, 0, width - 1, height - 1);
            g.dispose();
            captchaString = finalString.toString();
            System.out.println(captchaString);
            File outputfile = new File("D://Foram/captcha.jpg");
            ImageIO.write(bufferedImage, "jpg", outputfile);
            return bufferedImage;
        } catch (Exception ioe) {
            throw new RuntimeException("Unable to build image", ioe);
        }
    }

    // Function to return the Captcha string
    public String getCaptchaString() {
        return captchaString;
    }
    
    public Map<String,String> generateNumericCaptcha() {
        Map<String,String> captcha = new HashMap<String, String>();
        
        int first, second, third, op, pos, solution;
        
        op = RAND.nextInt(OPERATIONS.length);
        captcha.put("operation", OPERATIONS[op]);
        switch (op) {
        case 2: // multiplication; limit generated args to [1-5]
            first = RAND.nextInt(5) + 1;
            second = RAND.nextInt(5) + 1;
            third = first * second;
            System.out.println("Inside multiplication : ");
            break;
        case 1: // subtraction
            first = RAND.nextInt(NUMBERS.length);
            second = RAND.nextInt(NUMBERS.length);
            if (first < second) {
                // reorder to ensure positive solution
                int tmp = first;
                first = second;
                second = tmp;
            }
            third = first - second;
            System.out.println("Inside subtraction : ");
            break;
        default: // addition
            first = RAND.nextInt(NUMBERS.length);
            second = RAND.nextInt(NUMBERS.length);
            third = first + second;
            System.out.println("Inside addition : ");
        }
        System.out.println("First number generated : " + first);
        System.out.println("Second number generated : " + second);
        System.out.println("Third number calculated : " + third);
        
        String rFirst = NUMBERS[first], rSecond = NUMBERS[second], rThird;
        if (third < NUMBERS.length) {
            rThird = NUMBERS[third];
        } else {
            rThird = Integer.toString(third);
        }
        
        System.out.println("RFirst number generated : " + rFirst);
        System.out.println("RSecond number generated : " + rSecond);
        System.out.println("RThird number calculated : " + rThird);
        
        pos = RAND.nextInt(3);
         System.out.println("Position : " + pos);
        switch (pos) {
        case 0:
            solution = first;
            captcha.put("second", rSecond);
            captcha.put("third", rThird);
            break;
        case 1:
            captcha.put("first", rFirst);
            solution = second;
            captcha.put("third", rThird);
            break;
        default:
            captcha.put("first", rFirst);
            captcha.put("second", rSecond);
            solution = third;
            break;
        }
        captcha.put("position", Integer.toString(pos));
        captcha.put("solution",Integer.toString(solution));
        //session.setAttribute("captcha_solution", Integer.toString(solution));
        System.out.println("captcha_solution : " + Integer.toString(solution));
        System.out.println("captcha object : " + captcha.get("operation") + " ---------------- " );
        
        return captcha;
    }
}