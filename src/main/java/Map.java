import items.*;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Map {

    private int height, width, maxAmountOfItems, totalAmountOfItems;
    private ArrayList<Item> itemsOnMap = new ArrayList<Item>();
    private HashMap<Coordinate,Tile> map;
    private static final int MINIMUM_HEIGHT = 3, MINIMUM_WIDTH = 3;
    private static final double PROCENTUAL_MULTIPLICATOR = 0.1;


    public Map(int height, int width, int totalAmountOfItems) {
        if (height <= MINIMUM_HEIGHT || width <= MINIMUM_WIDTH) {
            throw new IllegalArgumentException("För liten karta");
        }
        this.height = height;
        this.width = width;


        if (totalAmountOfItems <= 0) {
            throw new IllegalArgumentException("För lågt antal items");
        }
        this.totalAmountOfItems = totalAmountOfItems;
        this.maxAmountOfItems = (int)((height * width) * PROCENTUAL_MULTIPLICATOR);
        initMap();
    }

    public void initMap(){
        map = new HashMap<Coordinate,Tile>();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if(x==0){ // Vänstra sidan
                    addTile(x, y, new NonWalkableTile());
                }else if(y==0){ //Norra sidan
                    addTile(x, y, new NonWalkableTile());
                }else if(y == height - 1){ //Högra sidan
                    addTile(x, y, new NonWalkableTile());
                }else if (x==width -1 ){ //Södra sidan
                    addTile(x, y, new NonWalkableTile());
                }else{ //Gåbar yta
                    addTile(x, y, new FloorTile());
                }
            }
        }

        addDoorToMap();
        addBouncerToMap();
    }

    private void addDoorToMap(){
        addTile(0, calculateDoorY(), new DoorTile());
    }
    private void addBouncerToMap(){
        FloorTile tile = (FloorTile) map.get(new Coordinate(1,(calculateDoorY()-1)));
        tile.addCharacter(new Bouncer());
    }

    public int calculateDoorY(){
        return height/2;
    }

    private void addTile(int x, int y, Tile tile){
        map.put(new Coordinate(x,y), tile);
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public Tile getTileOnCoordinate(int x, int y){
        return map.get(new Coordinate(x,y));

    }

    public void addRandomItemsToMap() {
        while (itemsOnMap.size() < maxAmountOfItems) {
            Item item = selectRandomItem();
            Random random = new Random();
            Set<Coordinate> keys = map.keySet();
            Coordinate[] coordinates = keys.toArray(new Coordinate[keys.size()]);

            while (item != null) {
                int randomCoordinate = random.nextInt(coordinates.length);
                Coordinate coordinate = coordinates[randomCoordinate];
                Tile tile = map.get(coordinate);
                if (tile.getIsWalkable() && tile.getIsItemsAllowed() && !((FloorTile) tile).hasCharacter() && !((FloorTile) tile).hasItem()) {
                    ((FloorTile) tile).addItem(item);
                    itemsOnMap.add(item);
                    item = null;
                }
            }
        }
    }

    public Item selectRandomItem(){
            Item item = null;

            switch(getRandomOption()){
                case 0:
                    item = new NonAlcoholicDrink();
                    break;
                case 1:
                    item = new Water();
                    break;
                case 2:
                    item = new Shot();
                    break;
                case 3:
                    item = new GlassShiver();
                    break;
                case 4:
                    item = new Wine();
                    break;
                case 5:
                    item = new Beer();
                    break;
            }

        return item;
    }



    public int getRandomOption(){
        Random random = new Random();
        double[] probabilities = {0.1, 0.2, 0.2, 0.2, 0.2, 0.1};
        int[] results = {0, 1, 2, 3, 4, 5};

        double num = random.nextDouble();
        double s = 0;
        int lastIndex = probabilities.length - 1;

        for (int i = 0; i < lastIndex; ++i) {
            s += probabilities[i];
            if (num < s) {
                return results[i];
            }
        }
            return results[lastIndex];
    }


    public int getMaxAmountOfItems(){
        return maxAmountOfItems;
    }
    public ArrayList<Item> getItemsOnMapList(){
        return itemsOnMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Map)) return false;

        Map map1 = (Map) o;

        if (height != map1.height) return false;
        if (width != map1.width) return false;
        if (maxAmountOfItems != map1.maxAmountOfItems) return false;
        if (totalAmountOfItems != map1.totalAmountOfItems) return false;
        return map != null ? map.equals(map1.map) : map1.map == null;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + width;
        result = 31 * result + maxAmountOfItems;
        result = 31 * result + totalAmountOfItems;
        return result;
    }
}