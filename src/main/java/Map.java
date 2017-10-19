import items.*;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Map {

    private int height, width, maxAmountOfItems;
    private HashMap<Coordinate,Tile> map;

    public Map(int height, int width) {
        if (height < 3 || width < 3) {
            throw new IllegalArgumentException("För liten karta");
        }
        this.height = height;
        this.width = width;
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

    public String[] readStringFromFile(String filename) throws IOException{

        String[] tokens = null;


            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            tokens = line.split(",");

            return tokens;




    }



    public void addRandomItemsToMap(int amountOfItems){
        List<Item> items = selectRandomItems(amountOfItems);
        Random random = new Random();
        Set<Coordinate> keys = map.keySet();
        Coordinate[] coordinates = keys.toArray(new Coordinate[keys.size()]);

        while(items.size() > 0) {
            int randomCoordinate = random.nextInt(coordinates.length);
            Coordinate coordinate = coordinates[randomCoordinate];
            Tile tile = map.get(coordinate);
            if (tile.getIsWalkable() && tile.getIsItemsAllowed() && !((FloorTile)tile).hasItem()) {
                ((FloorTile)tile).addItem(items.get(0));
                items.remove(0);
            }
        }
    }

    public List selectRandomItems(int amountOfItems){
        List items = new ArrayList();
        int numberOfItems = amountOfItems;

        for(int i = 0; i<numberOfItems; i++){
            switch(getRandomOption()){
                case 0:
                    items.add(new NonAlcoholicDrink());
                    break;
                case 1:
                    items.add(new Water());
                    break;
                case 2:
                    items.add(new Shot());
                    break;
                case 3:
                    items.add(new GlassShiver());
                    break;
                case 4:
                    items.add(new Wine());
                    break;
                case 5:
                    items.add(new Beer());
                    break;
                default:
                    System.out.println("Item not available");
            }

        }
        return items;
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



///////////////////////////////////////////////////////////////////////////////////////////////////////





}