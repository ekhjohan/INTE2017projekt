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

    public Map(int height, int width, int totalAmountOfItems) {
        if (height < 4 || width < 4) {
            throw new IllegalArgumentException("För liten karta");
        }
        this.height = height;
        this.width = width;
        this.totalAmountOfItems = totalAmountOfItems;
        this.maxAmountOfItems = (int)((height * width) * 0.1);
        initMap();
    }

    public void initMap(){
        map = new HashMap<Coordinate,Tile>();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if(x==0){ // Vänstra sidan
                    map.put(new Coordinate(x,y),new NonWalkableTile());
                }else if(y==0){ //Norra sidan
                    map.put(new Coordinate(x,y),new NonWalkableTile());
                }else if(y == height){ //Högra sidan
                    map.put(new Coordinate(x,y),new NonWalkableTile());
                }else if (x==width){ //Södra sidan
                    map.put(new Coordinate(x,y),new NonWalkableTile());
                }else{ //Gåbar yta
                    map.put(new Coordinate(x,y),new FloorTile());
                }
            }
        }
    }
    public void addTile(int x, int y, Tile tile){
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
    public HashMap<Coordinate, Tile> getMap() {
        return map;
    }

    public String[] readStringFromFile(String filename) {
        String[] tokens = null;

        try {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        tokens = line.split(",");
        br.close();
        } catch (IOException ioe) {

        }
        return tokens;
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
                if (tile.getIsWalkable() && tile.getIsItemsAllowed() && !((FloorTile) tile).hasItem()) {
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



    public void addRandomVisitor(){

    }


    public int getRandomOption(){
        Random random = new Random();
        double[] probabilities = {0.2, 0.2, 0.2, 0.2, 0.2};
        int[] results = {1, 2, 3, 4, 5};

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
        return this.maxAmountOfItems;
    }
    public ArrayList<Item> getItemsOnMapList(){
        return this.itemsOnMap;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////





}