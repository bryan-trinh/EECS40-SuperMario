package com.example.assignment4_mario;

import java.util.Scanner;

/** to do:
 * -AI Behavior         [x]
 * -Jumping/Landing     [x]
 * -Timer for starman   [x]
 * -screen scrolling    [x]
 */

/** height = 8 pixels (0-7), width = 14 pixels (0-13) **/
enum mario_states{
    SMALL("SMALL"),
    BIG("BIG"),
    SMALL_STAR("SMALL", true),
    BIG_STAR("BIG", true);

    private String currentState;
    private boolean hasStar;

    mario_states(final String currentState){
        this.currentState = currentState;
    }

    mario_states(final String currentState, boolean hasStar){
        this.currentState = currentState;
        this.hasStar = hasStar;
    }

    public boolean isHasStar(){
        return hasStar;
    }

    public String getCurrentState(){
        return currentState;
    }
}

enum pixel_type {
    /** TRUE = will stop when collides, FALSE = will not stop when collides **/
    NOTHING(false),
    BLOCK(true),
    BRICK(true),
    COIN(false),
    MUSHROOM(false),
    STAR(false),
    PIPE(true),
    GOOMBA(false),
    PIRAHNA_PLANT(false),
    VOID(false),
    ITEMBRICK_M(true),
    ITEMBRICK_S(true),
    FLAG(false),
    DEADPIPE(true),
    MARIO(false);       // mario pixel_type -- only 1 will exist at all instances

    private boolean canCollide;
    private boolean death;              //true = die when land on this pixel

    pixel_type(final boolean canCollide) {
        this.canCollide = canCollide;
    }

    public boolean isCanCollide(){
        return canCollide;
    }
}

public class mario {

    mario(){
        this.mario_current_state = mario_states.SMALL;
    }

    mario(mario_states mario_current_state){
        this.mario_current_state = mario_current_state;
    }

    static String getCurrentState(){
        return mario_current_state.getCurrentState();
    }

    static boolean hasStar(){
        return mario_current_state.isHasStar();
    }
    /**
     *  No sounds
     *  3 levels      -- can fix the levels.
     *  Can redesign AI behavior
     *  Side-scroller -- left to right
     *  Mario should be able to jump
     *  Develop touch controls
     *  3 lives, running score
     */

    public static int lives = 3;                                            // defaulted to 3, reduces by 1 every death
    public static int score = 0;                                            // keeps track of points
    public static mario_states mario_current_state;                         // enum mario_states
    public static int level = 0;                                            // values of 0,1,2
    public static int smallHopFlag = 0;
    public static int highHopFlag = 0;
    public static int leftScreenBound = 0;
    final static int screenSize = 14;
    public static int rightScreenBound = leftScreenBound + screenSize -1;
    public static int currentMarioXPosition = 0;
    public static int currentMarioYPosition = 2;
    public static int time = 500;                        // 500 seconds
    public static int starManTime = 0;
    public static int hop = 0;
    /** POINTS:
     *  Brick blocks    = 10    points
     *  Coins           = 200   points  --common
     *  Mushroom        = 1000  points
     *  Starman         = 1000  points
     * */

    /**MAIN FUNCTION**/
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        /*

        levelMap map = new levelMap();
        map.printMap();

        pixel_type currPixelValue = map.getPixelValueAt(0,0);
        System.out.println("Pixel value at (0,0): " + currPixelValue);

        mario mario_player = new mario(mario_states.BIG_STAR);
        System.out.println("Current State: " + mario_player.getCurrentState());
        System.out.println("Has Star: " + mario_player.hasStar());

        mario defaultM = new mario();
        System.out.println("Default mario state: " + defaultM.getCurrentState());
        System.out.println("Has Star: " + defaultM.hasStar());

        currPixelValue = map.getPixelValueAt(2,0);      //Sets currPixelValue to VOID
        onDeathVOID(map, 2, 0);
        mario_player = restart();
        System.out.println("Current State: " + mario_player.getCurrentState());
        System.out.println("Has Star: " + mario_player.hasStar());


        System.out.println("Map before: ");
        map.printMap();
        currPixelValue = map.getPixelValueAt(0,1);      //kill goomba
        System.out.println("Map after: ");
        checkKillFromTop(map, 0, 1);
        map.printMap();

        System.out.println("Reached a new level. Changing the level... ");
        map = new levelMap(1);
        map.printMap();

         */
        runGame();
    }

    //for killing by stomping
    public static void checkKillFromTop(levelMap map, int y, int x){
        pixel_type pixelValue = map.getPixelValueAt(y,x);
        if(pixelValue == pixel_type.GOOMBA){
            System.out.println("Mario Killed GOOMBA + 200");
            smallHopFlag = 1;
            System.out.println("Score before: " + score);
            score += 200;
            map.modifyMap(y, x, pixel_type.NOTHING);
            System.out.println("Score: " + score);
        }
    }

    //for killing by star
    public static void checkKillByStar(levelMap map, int y, int x){
        pixel_type pixelValue = map.getPixelValueAt(y,x);
        if(pixelValue == pixel_type.GOOMBA || pixelValue == pixel_type.PIRAHNA_PLANT) {
            if (hasStar() == true) {
                System.out.println("Score before: " + score);
                score += 200;
                map.modifyMap(y, x, pixel_type.NOTHING);
                System.out.println("Score: " + score);
            }
        }
        if(pixelValue == pixel_type.PIRAHNA_PLANT){
            map.modifyMap(y-1, x, pixel_type.DEADPIPE);
        }
    }

    //for VOID pixel as of now
    public static void onDeathVOID(levelMap map, int y, int x){
        pixel_type pixelValue = map.getPixelValueAt(y,x);
        if(pixelValue == pixel_type.VOID){
            System.out.println("Mario lost a life");
        }
    }

    //updates mario when getting a mushroom
    public static mario getMushroom(mario m){
        if(m.hasStar() == true){
            return new mario(mario_states.BIG_STAR);
        }
        return new mario(mario_states.BIG);
    }

    //updates mario when getting a star
    public static mario getStar(mario m){
        starManTime = time;
        if(m.getCurrentState().equals("SMALL")){
            return new mario(mario_states.SMALL_STAR);
        }
        return new mario(mario_states.BIG_STAR);
    }

    //returns true if block below is can't collide
    public static boolean checkFall(levelMap map){
        if(map.getPixelValueAt(currentMarioYPosition-1, currentMarioXPosition).isCanCollide()){
            if(map.getPixelValueAt(currentMarioYPosition-1, currentMarioXPosition) == pixel_type.PIRAHNA_PLANT){
                return true;
            }
            return false;
        }
        return true;
    }

    //updating the screen bounds

    /**
     *  move(1);
     *          --call while statement between moving
     *  move(-1);
     *  move(1);
     *  move(1);
     *  ~~~~~~~~~~~~~~~~~~~
     *  while(scrollScreen()){
     *      updateBounds();
     *  }
     *
     */

    //moves mario left or right
    public static void move(levelMap map, mario m, int leftOrRight){
        if(leftOrRight == -1){
            if((currentMarioXPosition -1) >= leftScreenBound) {
                if(!map.getPixelValueAt(currentMarioYPosition, currentMarioXPosition-1).isCanCollide()) {
                    if(!(m.getCurrentState() == "BIG" && map.getPixelValueAt(currentMarioYPosition + 1, currentMarioXPosition-1).isCanCollide())) {
                        currentMarioXPosition--;
                    }
                }
                onHit(m, map, currentMarioYPosition, currentMarioXPosition, 0);
                if(m.getCurrentState() == "BIG"){
                    onHit(m, map, currentMarioYPosition + 1, currentMarioXPosition, 0);
                }
            }
        }
        else if(leftOrRight == 1){
            if((currentMarioXPosition +1) <= rightScreenBound){
                if (!map.getPixelValueAt(currentMarioYPosition, currentMarioXPosition + 1).isCanCollide()) {
                    if(!(m.getCurrentState() == "BIG" && map.getPixelValueAt(currentMarioYPosition + 1, currentMarioXPosition+1).isCanCollide())) {
                        currentMarioXPosition++;
                        //System.out.println("X: " + currentMarioXPosition + " Y: " + currentMarioYPosition + "  ");
                    }

                }
                onHit(m, map, currentMarioYPosition, currentMarioXPosition, 0);
                if(m.getCurrentState() == "BIG"){
                    onHit(m, map, currentMarioYPosition + 1, currentMarioXPosition, 0);
                }
            }
        }
    }

    //updates the screen
    public static boolean scrollScreen(levelMap map){
        int toScroll = leftScreenBound + (int)(screenSize*0.7);
        if(currentMarioXPosition >= toScroll){
            if(toScroll > (int)map.currentMap[level].length*(0.7)){
                return false;
            }
            return true;
        }
        return false;
    }

    public static void updateBounds(){
        leftScreenBound++;
        rightScreenBound++;
    }

    //returns true if mario receives dmg, false otherwise
    public static boolean didReceiveDamage(mario m){
        if(m.hasStar() == false){
            return true;
        }
        return false;
    }

    //returns a small mario if no star and big, kills mario if small, returns mario otherwise
    public static mario shrink(mario m, levelMap map){
        if(m.getCurrentState().equals("BIG") && m.hasStar() == false){
            return new mario(mario_states.SMALL);
        }
        else if(m.getCurrentState().equals("SMALL") && m.hasStar() == false){
            return restart(map);
        }
        return m;
    }

    //restart the stage, with a new mario
    public static mario restart(levelMap map){
        leftScreenBound = 0;
        rightScreenBound = leftScreenBound + screenSize-1;
        currentMarioXPosition = 1;
        currentMarioYPosition = 2;
        smallHopFlag = 0;
        highHopFlag = 0;
        map = new levelMap(level);

        lives--;
        System.out.println("Lives remaining: " + lives);
        if(lives == 0){
            System.out.println("You died.");
            System.out.println("Score: " + score);
            System.exit(10);
        }
        return new mario();
    }

    //hits a flag at the end
    public static void endLevel(pixel_type pixelValue, levelMap map){
        if(pixelValue == pixel_type.FLAG){
            if(level < 2){
                score += (time*100);
                time = 500;
                starManTime = 520;
                System.out.println("Current level: " + level);
                level++;
                System.out.println("Next level: " + level);

                currentMarioXPosition = 0;
                leftScreenBound = 0;
                rightScreenBound = leftScreenBound + screenSize;
                map = new levelMap(level);
            }
            else if(level == 2){
                System.out.println("Finished all 3 levels");
                System.exit(10);
            }
        }
    }

    //everytime mario collides with anything
    //hit from under = -1
    //hit from side  =  0
    //hit from top   =  1
    public static void onHit(mario m, levelMap map, int y, int x, int hitLocation){
        boolean hitFromUnder = (hitLocation == -1);
        boolean hitFromTop = (hitLocation == 1);
        boolean hitFromSide = (hitLocation == 0);

        pixel_type pixelValue = map.getPixelValueAt(y,x);
        /** Hit from UNDER **/
        if(hitFromUnder) {
            if(pixelValue == pixel_type.ITEMBRICK_M) {
                System.out.println("Hit an itemBrick!");
                score += 10;
                map.modifyMap(y+1, x, pixel_type.MUSHROOM);
                map.modifyMap(y, x, pixel_type.BLOCK);
                hop = 1;
            }
            else if(pixelValue == pixel_type.ITEMBRICK_S){
                System.out.println("Hit an itemBrick!");
                score += 10;
                map.modifyMap(y+1, x, pixel_type.STAR);
                map.modifyMap(y, x, pixel_type.BLOCK);
                hop = 1;
            }
            else if(pixelValue == pixel_type.MUSHROOM){
                System.out.println("Got a Mushroom!");
                score += 1000;
                getMushroom(m);
                map.modifyMap(y, x, pixel_type.NOTHING);
            }
            else if(pixelValue == pixel_type.STAR){
                System.out.println("Got a Star!");
                score += 1000;
                getStar(m);
                map.modifyMap(y, x, pixel_type.NOTHING);
            }
            else if(pixelValue == pixel_type.COIN){
                System.out.println("Got a Coin!");
                score += 200;
                map.modifyMap(y, x, pixel_type.NOTHING);
            }
            else if(pixelValue == pixel_type.BRICK){
                System.out.println("Hit a brick!");
                if(mario.getCurrentState() == "BIG") {
                    score += 10;
                    map.modifyMap(y, x, pixel_type.NOTHING);
                }
                hop = 1;
            }

        }/** Hit from TOP **/
        else if(hitFromTop){
            if(pixelValue == pixel_type.GOOMBA) {
                checkKillFromTop(map, y, x);
                currentMarioYPosition++;
            }
            else if(pixelValue == pixel_type.PIRAHNA_PLANT){
                if(didReceiveDamage(m)){
                    m = shrink(m, map);
                }
                else{
                    checkKillByStar(map, y, x);
                }
            }
            else if(pixelValue == pixel_type.MUSHROOM){
                System.out.println("Got a Mushroom!");
                score += 1000;
                getMushroom(m);
                map.modifyMap(y, x, pixel_type.NOTHING);
            }
            else if(pixelValue == pixel_type.STAR){
                System.out.println("Got a Star!");
                score += 1000;
                getStar(m);
                map.modifyMap(y, x, pixel_type.NOTHING);
            }
            else if(pixelValue == pixel_type.COIN){
                System.out.println("Got a Coin!");
                score += 200;
                map.modifyMap(y, x, pixel_type.NOTHING);
            }
            else if(pixelValue == pixel_type.VOID){
                System.out.println("Hit the VOID");
                onDeathVOID(map, y ,x);
                m = new mario();
                m = shrink(m, map);
                currentMarioXPosition--;
            }
            else if(pixelValue == pixel_type.FLAG){
                endLevel(pixel_type.FLAG, map);
            }
        }
        /** Hit from SIDE **/
        else if(hitFromSide){
            if(pixelValue == pixel_type.PIRAHNA_PLANT || pixelValue == pixel_type.GOOMBA){
                if(didReceiveDamage(m)){
                    m = shrink(m, map);
                    currentMarioXPosition--;
                }
                else{
                    checkKillByStar(map, y, x);
                }
            }
            else if(pixelValue == pixel_type.MUSHROOM){
                System.out.println("Got a Mushroom!");
                score += 1000;
                getMushroom(m);
                map.modifyMap(y, x, pixel_type.NOTHING);
            }
            else if(pixelValue == pixel_type.STAR){
                System.out.println("Got a Star!");
                score += 1000;
                getStar(m);
                map.modifyMap(y, x, pixel_type.NOTHING);
            }
            else if(pixelValue == pixel_type.COIN){
                System.out.println("Got a Coin!");
                score += 200;
                map.modifyMap(y, x, pixel_type.NOTHING);
            }
            else if(pixelValue == pixel_type.FLAG){
                endLevel(pixel_type.FLAG, map);
            }
        }

    }

    //updates the gameMap to include mario's current position
    public static void updateMarioPosition(levelMap map, mario m){
        map.removeMario();
        map.modifyMap(currentMarioYPosition, currentMarioXPosition, pixel_type.MARIO);
        if(m.getCurrentState() == "BIG"){
            map.modifyMap(currentMarioYPosition+1, currentMarioXPosition, pixel_type.MARIO);
        }
    }

    public static void jump(mario m, levelMap map){
        if(map.getPixelValueAt(currentMarioYPosition-1, currentMarioXPosition).isCanCollide() || hop != 0) {
            if (hop == 0) {
                if (smallHopFlag == 1) {
                    hop = 2;
                } else if (highHopFlag == 1) {
                    hop = 3;
                }
            }

            if (hop > 0) {
                if(m.getCurrentState() == "SMALL") {
                    if (!map.getPixelValueAt(currentMarioYPosition + 1, currentMarioXPosition).isCanCollide()) {
                        currentMarioYPosition++;
                        onHit(m, map, currentMarioYPosition, currentMarioXPosition, -1);
                    } else if (map.getPixelValueAt(currentMarioYPosition + 1, currentMarioXPosition) == pixel_type.ITEMBRICK_M || map.getPixelValueAt(currentMarioYPosition + 1, currentMarioXPosition) == pixel_type.ITEMBRICK_S || map.getPixelValueAt(currentMarioYPosition + 1, currentMarioXPosition) == pixel_type.BRICK) {
                        onHit(m, map, currentMarioYPosition + 1, currentMarioXPosition, -1);
                    }
                    onHit(m, map, currentMarioYPosition, currentMarioXPosition, -1);
                    hop--;
                    if (hop == 0) {
                        hop = 0;
                        smallHopFlag = 0;
                        highHopFlag = 0;
                    }
                }
                else if(m.getCurrentState() == "BIG") {
                    if (!map.getPixelValueAt(currentMarioYPosition + 2, currentMarioXPosition).isCanCollide()) {
                        currentMarioYPosition++;
                        onHit(m, map, currentMarioYPosition + 1, currentMarioXPosition, -1);
                    } else if (map.getPixelValueAt(currentMarioYPosition + 2, currentMarioXPosition) == pixel_type.ITEMBRICK_M || map.getPixelValueAt(currentMarioYPosition + 2, currentMarioXPosition) == pixel_type.ITEMBRICK_S || map.getPixelValueAt(currentMarioYPosition + 2, currentMarioXPosition) == pixel_type.BRICK) {
                        onHit(m, map, currentMarioYPosition + 2, currentMarioXPosition, -1);
                    }
                    onHit(m, map, currentMarioYPosition + 1, currentMarioXPosition, -1);
                    hop--;
                    if (hop == 0) {
                        hop = 0;
                        smallHopFlag = 0;
                        highHopFlag = 0;
                    }
                }
            }
        }
        /*
        for(int i = 0; i < hop; i++){
            if(map.getPixelValueAt(currentMarioYPosition+1, currentMarioXPosition).isCanCollide()){
                break;
            }
            currentMarioYPosition++;
            onHit(m, map, currentMarioYPosition, currentMarioXPosition, -1);
        }
        onHit(m, map, currentMarioYPosition, currentMarioXPosition, -1);

        smallHopFlag = 0;
        highHopFlag = 0;
        */
    }

    public static void land(mario m, levelMap map){
        if(checkFall(map)){
            currentMarioYPosition--;
        }
        onHit(m, map, currentMarioYPosition, currentMarioXPosition, 1);
    }

    public static mario checkStarTimeout(mario m){
        if(m.hasStar()){
            if(starManTime-time >= 10){
                if(m.getCurrentState().equals("BIG")){
                    return new mario(mario_states.BIG);
                }
                else
                {
                    return new mario(mario_states.SMALL);
                }
            }
        }
        return m;
    }

    public static void printMapScrolled(levelMap map){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while(scrollScreen(map)){
            updateBounds();
        }
        for(int y = map.currentMap.length-1; y >= 0; y--){
            for(int x = leftScreenBound; x < rightScreenBound; x++){
                System.out.print(getPixelName(map, y, x) + "  ");
            }
            System.out.println();
        }

    }

    private static String getPixelName(levelMap map, int y, int x){
        pixel_type temp =  map.currentMap[y][x];
        if(temp == pixel_type.NOTHING)
            return " ";
        else if(temp == pixel_type.BLOCK)
            return "B";
        else if(temp == pixel_type.GOOMBA)
            return "G";
        else if(temp == pixel_type.FLAG)
            return "F";
        else if(temp == pixel_type.MUSHROOM)
            return "m";
        else if(temp == pixel_type.PIRAHNA_PLANT)
            return "p";
        else if(temp == pixel_type.VOID)
            return " ";
        else if(temp == pixel_type.PIPE)
            return "P";
        else if(temp == pixel_type.STAR)
            return "s";
        else if(temp == pixel_type.COIN)
            return "c";
        else if(temp == pixel_type.MARIO)
            return "M";
        else if(temp == pixel_type.BRICK)
            return "b";
        else if(temp == pixel_type.ITEMBRICK_M)
            return "i";
        else if(temp == pixel_type.ITEMBRICK_S)
            return "i";
        else if(temp == pixel_type.DEADPIPE)
            return "P";
        return "";
    }

    public static void runGame(){
        mario m = new mario();
        levelMap map = new levelMap();
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        int goombaMove = 0;
        int pirahnaMove = 0;

        while(running){
            updateMarioPosition(map, m);
            //map.printMap();
            printMapScrolled(map);
            System.out.println("Lives: " + lives + "  Score: " + score + "  Time: " + time);
            System.out.println("Current State: " + m.getCurrentState() + "  Has Star: " + m.hasStar());

            String input = sc.nextLine();
            if(input.equals("d")){
                move(map, m, 1);
            }
            else if(input.equals("a")){
                move(map, m, -1);
            }
            else if(input.equals("w")){
                smallHopFlag = 1;
                jump(m, map);
            }
            land(m,map);
            checkStarTimeout(m);
            if(goombaMove % 4 == 0)
                map.moveGoombasLeft();
            else if(goombaMove % 4 == 1) {
                map.moveGoombasRight();
            }
            else if(goombaMove % 4 == 2)
                map.moveGoombasRight();
            else if(goombaMove % 4 == 3) {
                map.moveGoombasLeft();
            }

            if(pirahnaMove % 6 != 3){
                map.movePirahnasUp();
            }
            else if(pirahnaMove % 8 == 3){
                map.movePirahnasDown();
            }

            goombaMove++;
            pirahnaMove++;
            time--;
        }
    }

    public static boolean marioIsClose(int x){
        int leftX = x-2;
        int rightX = x+2;
        if(currentMarioXPosition>= leftX && currentMarioXPosition <= rightX){
            return true;
        }
        return false;
    }

}/*EOF*/
