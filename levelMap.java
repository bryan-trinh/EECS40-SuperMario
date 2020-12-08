package com.example.assignment4_mario;

public class levelMap {

    public static pixel_type[][] currentMap;
    public int currentMapOffset;

    public levelMap(){
        this.currentMapOffset = 0;
        this.currentMap = map_list[currentMapOffset];
    }

    public levelMap(int mapSelection){
        this.currentMapOffset = mapSelection;
        this.currentMap = map_list[currentMapOffset];
    }

    private final pixel_type[][][] map_list = {
            {

                    {pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,       pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,  pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK},
                    {pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,       pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,  pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK,   pixel_type.BLOCK},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN,    pixel_type.COIN,    pixel_type.COIN,    pixel_type.NOTHING, pixel_type.NOTHING,     pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.MUSHROOM, pixel_type.PIPE,    pixel_type.NOTHING, pixel_type.GOOMBA,  pixel_type.NOTHING, pixel_type.PIPE,    pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.GOOMBA, pixel_type.NOTHING,pixel_type.COIN, pixel_type.NOTHING,      pixel_type.FLAG,    pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN, pixel_type.COIN, pixel_type.COIN, pixel_type.NOTHING, pixel_type.NOTHING,     pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.BRICK,   pixel_type.NOTHING,     pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.BRICK,   pixel_type.ITEMBRICK_S,    pixel_type.BRICK,   pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.STAR,    pixel_type.NOTHING,     pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,     pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,     pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,     pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,     pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},

            },
            {
                    {pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.VOID, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.VOID, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK},
                    {pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.VOID, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.NOTHING, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.NOTHING, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.PIPE, pixel_type.NOTHING, pixel_type.COIN, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.PIPE, pixel_type.NOTHING, pixel_type.FLAG, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.NOTHING, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.COIN, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN, pixel_type.COIN, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN, pixel_type.BLOCK, pixel_type.NOTHING, pixel_type.BLOCK,pixel_type.COIN, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.BRICK, pixel_type.ITEMBRICK_S, pixel_type.BRICK, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN, pixel_type.NOTHING, pixel_type.COIN,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},

            },
            {
                    {pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.VOID, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.VOID, pixel_type.VOID, pixel_type.BLOCK, pixel_type.BLOCK},
                    {pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.VOID, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK,pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.BLOCK, pixel_type.VOID, pixel_type.VOID, pixel_type.BLOCK, pixel_type.BLOCK},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.GOOMBA, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.PIPE, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.GOOMBA, pixel_type.NOTHING, pixel_type.GOOMBA, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.FLAG, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.COIN, pixel_type.COIN, pixel_type.COIN, pixel_type.NOTHING, pixel_type.BRICK, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.BRICK, pixel_type.BRICK, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.BRICK, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.COIN, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.ITEMBRICK_S, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.MUSHROOM, pixel_type.STAR, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},
                    {pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING,pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING, pixel_type.NOTHING},


            }
    };

    public void printMap(){
        for(int i = this.currentMap.length-1; i >= 0; i--){
            for(int j = 0; j < this.currentMap[i].length; j++){
                System.out.print(this.currentMap[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public pixel_type getPixelValueAt(int y, int x){
        return this.currentMap[y][x];
    }

    public void modifyMap(int y, int x, pixel_type pixelValue){
        this.currentMap[y][x] = pixelValue;
    }

    public void removeMario(){
        for(int i = 0; i < this.currentMap.length; i++){
            for(int j = 0; j < this.currentMap[i].length; j++){
                if(this.currentMap[i][j] == pixel_type.MARIO){
                    this.currentMap[i][j] = pixel_type.NOTHING;
                    break;
                }
            }
        }
    }

    public void moveGoombasLeft(){
        for(int i = 0; i < this.currentMap.length; i++){
            for(int j = 0; j < this.currentMap[i].length; j++){
                if(this.currentMap[i][j] == pixel_type.GOOMBA){
                    this.currentMap[i][j-1] = pixel_type.GOOMBA;
                    this.currentMap[i][j] = pixel_type.NOTHING;
                }
            }
        }
    }

    public void moveGoombasRight(){
        for(int i = 0; i < this.currentMap.length; i++){
            for(int j = this.currentMap[i].length-2; j >= 0; j--){
                if(this.currentMap[i][j] == pixel_type.GOOMBA){
                    this.currentMap[i][j+1] = pixel_type.GOOMBA;
                    this.currentMap[i][j] = pixel_type.NOTHING;
                }
            }
        }
    }

    public void movePirahnasUp(){
        for(int i = this.currentMap.length-1; i >= 0; i--){
            for(int j = 0; j < this.currentMap[i].length; j++){
                if(this.currentMap[i][j] == pixel_type.PIPE){
                    if(this.currentMap[i+1][j] == pixel_type.NOTHING){
                        if(!mario.marioIsClose(j)) {
                            this.currentMap[i + 1][j] = pixel_type.PIRAHNA_PLANT;
                        }
                    }
                }
            }
        }
    }

    public void movePirahnasDown(){
        for(int i = this.currentMap.length-1; i >= 0; i--){
            for(int j = 0; j < this.currentMap[i].length; j++){
                if(this.currentMap[i][j] == pixel_type.PIRAHNA_PLANT){
                    this.currentMap[i][j] = pixel_type.NOTHING;
                }
            }
        }
    }
}
