/*
* File: HangmanCanvas.java
* ------------------------
* This file keeps track of the Hangman display.
*/

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
    /** Resets the display so that only the scaffold appears */
    public void reset() {
        /* You fill this in */
        removeAll();
        lettersLabel = new GLabel("");
        incorrectLettersLabel = new GLabel("");
        
        double width = getWidth();
        double height = getHeight();
        
        double baseX = width / 2 - 200;
        double baseY = height / 2 + 150;
        
        
        verticalScaffold = new GLine(baseX, baseY, baseX, baseY - SCAFFOLD_HEIGHT);
        horizontalScaffold = new GLine(baseX, baseY - SCAFFOLD_HEIGHT,
        		baseX + BEAM_LENGTH, baseY - SCAFFOLD_HEIGHT);
     
        rope = new GLine(baseX + BEAM_LENGTH, baseY - SCAFFOLD_HEIGHT, baseX + BEAM_LENGTH, baseY - SCAFFOLD_HEIGHT + ROPE_LENGTH);
        
        add(verticalScaffold);
        add(horizontalScaffold);
        add(rope);
    }

    /**
    * Updates the word on the screen to correspond to the current
    * state of the game. The argument string shows what letters have
    * been guessed so far; unguessed letters are indicated by hyphens.
    */
    public void displayWord(String word) {
        /* You fill this in */
        remove(lettersLabel);
        lettersLabel.setLabel("" + word);
        lettersLabel.setFont("Arial-18");
        add(lettersLabel, 50, (getHeight() - 85 - lettersLabel.getAscent() / 2));
    }

    /**
    * Updates the display to correspond to an incorrect guess by the
    * user. Calling this method causes the next body part to appear
    * on the scaffold and adds the letter to the list of incorrect
    * guesses that appears at the bottom of the window.
    */
    public void noteIncorrectGuess(char letter) {
        /* You fill this in */
        
        // get current label
        String current = incorrectLettersLabel.getLabel();

        // append current labl with letter, and set it
        incorrectLettersLabel.setLabel(current + letter);

        incorrectLettersLabel.setFont("Arial-16");
        add(incorrectLettersLabel, 50, (getHeight() - 50 - incorrectLettersLabel.getAscent() / 2));

        int mistakeCount = (current + letter).length();
        printHuman(mistakeCount, getWidth() / 2, getHeight() / 2);
    }

    private void printHuman(int count, double width, double height) {

        double baseX = width - 200;
        double baseY = height + 150;

        switch (count) {
            case 1 -> printHead(baseX, baseY);
            case 2 -> printBody(baseX, baseY);
            case 3 -> printLeftArm(baseX, baseY);
            case 4 -> printRightArm(baseX, baseY);
            case 5 -> printLeftLeg(baseX, baseY);
            case 6 -> printRightLeg(baseX, baseY);
            case 7 -> printLeftFoot(baseX, baseY);
            case 8 -> printRightFoot(baseX, baseY);
        }
    }

    private void printHead(double baseX, double baseY) {
        double headX = baseX + BEAM_LENGTH - HEAD_RADIUS;
        double headY = baseY - SCAFFOLD_HEIGHT + ROPE_LENGTH;

        GOval head = new GOval(headX, headY, 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
        add(head);
    }

    private void printBody(double baseX, double baseY) {

        double bodyX = baseX + BEAM_LENGTH;
        double bodyStartY = baseY - SCAFFOLD_HEIGHT + ROPE_LENGTH + (2 * HEAD_RADIUS);

        GLine body = new GLine(bodyX, bodyStartY, bodyX, bodyStartY + BODY_LENGTH);
        add(body);
    }

    private void printLeftArm(double baseX, double baseY) {

        double armStartX = baseX + BEAM_LENGTH;
        double armEndX = armStartX - UPPER_ARM_LENGTH;
        double armY = baseY - SCAFFOLD_HEIGHT + ROPE_LENGTH + (2 * HEAD_RADIUS) + ARM_OFFSET_FROM_HEAD;

        GLine leftUpperArm = new GLine(armStartX, armY, armEndX, armY);
        GLine leftLowerArm = new GLine(armEndX, armY, armEndX, armY + LOWER_ARM_LENGTH);

        add(leftUpperArm);
        add(leftLowerArm);
    }

    private void printRightArm(double baseX, double baseY) {

        double armStartX = baseX + BEAM_LENGTH;
        double armEndX = armStartX + UPPER_ARM_LENGTH;
        double armY = baseY - SCAFFOLD_HEIGHT + ROPE_LENGTH + (2 * HEAD_RADIUS) + ARM_OFFSET_FROM_HEAD;

        GLine leftUpperArm = new GLine(armStartX, armY, armEndX, armY);
        GLine leftLowerArm = new GLine(armEndX, armY, armEndX, armY + LOWER_ARM_LENGTH);

        add(leftUpperArm);
        add(leftLowerArm);
    }

    private void printLeftLeg(double baseX, double baseY) {

        double hipStartX = baseX + BEAM_LENGTH;
        double hipEndX = hipStartX - HIP_WIDTH;
        double hipY = baseY - SCAFFOLD_HEIGHT + ROPE_LENGTH + (2 * HEAD_RADIUS) + BODY_LENGTH;

        GLine leftHip = new GLine(hipStartX, hipY, hipEndX, hipY);
        GLine leftLeg = new GLine(hipEndX, hipY, hipEndX, hipY + LEG_LENGTH);

        add(leftHip);
        add(leftLeg);
    }

    private void printRightLeg(double baseX, double baseY) {

        double hipStartX = baseX + BEAM_LENGTH;
        double hipEndX = hipStartX + HIP_WIDTH;
        double hipY = baseY - SCAFFOLD_HEIGHT + ROPE_LENGTH + (2 * HEAD_RADIUS) + BODY_LENGTH;


        GLine leftHip = new GLine(hipStartX, hipY, hipEndX, hipY);
        GLine leftLeg = new GLine(hipEndX, hipY, hipEndX, hipY + LEG_LENGTH);

        add(leftHip);
        add(leftLeg);
    }

    private void printLeftFoot(double baseX, double baseY) {

        double footStartX = baseX + BEAM_LENGTH - HIP_WIDTH;
        double footEndX = footStartX - FOOT_LENGTH;
        double footY = baseY - SCAFFOLD_HEIGHT + ROPE_LENGTH + (2 * HEAD_RADIUS) + BODY_LENGTH + LEG_LENGTH;

        GLine leftFoot = new GLine(footStartX, footY, footEndX, footY);

        add(leftFoot);
    }

    private void printRightFoot(double baseX, double baseY) {

        double footStartX = baseX + BEAM_LENGTH + HIP_WIDTH;
        double footEndX = footStartX + FOOT_LENGTH;
        double footY = baseY - SCAFFOLD_HEIGHT + ROPE_LENGTH + (2 * HEAD_RADIUS) + BODY_LENGTH + LEG_LENGTH;

        GLine rightFoot = new GLine(footStartX, footY, footEndX, footY);

        add(rightFoot);
    }

    /* Constants for the simple version of the picture (in pixels) */
    private static final int SCAFFOLD_HEIGHT = 360;
    private static final int BEAM_LENGTH = 184;
    private static final int ROPE_LENGTH = 28;
    private static final int HEAD_RADIUS = 32;
    private static final int BODY_LENGTH = 144;
    private static final int ARM_OFFSET_FROM_HEAD = 28;
    private static final int UPPER_ARM_LENGTH = 72;
    private static final int LOWER_ARM_LENGTH = 44;
    private static final int HIP_WIDTH = 36;
    private static final int LEG_LENGTH = 108;
    private static final int FOOT_LENGTH = 28;

    // Labels
    private GLabel lettersLabel;
    private GLabel incorrectLettersLabel;

    // Lines
    private GLine verticalScaffold;
    private GLine horizontalScaffold;
    private GLine rope;
}




