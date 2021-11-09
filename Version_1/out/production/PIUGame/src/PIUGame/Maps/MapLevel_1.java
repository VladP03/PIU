package PIUGame.Maps;

public class MapLevel_1 {
    ///Definire statica a matricei de coduri de dale.
    private static int map[][] = {
            {6, 3, 3, 3, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,    6, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1}, //0
            {6, 6, 6, 6, 3, 3, 6, 6, 6, 3, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6,    6, 6, 3, 3, 3, 0, 0, 0, 0, 0, 5, 5, 5, 3, 1, 1, 1, 1, 1, 1}, //1
            {3, 6, 6, 6, 6, 6, 6, 3, 0, 3, 3, 3, 0, 0, 3, 3, 3, 3, 3, 6,    6, 6, 3, 3, 6, 3, 0, 0, 0, 0, 5, 5, 3, 3, 1, 1, 1, 1, 1, 1}, //2
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3,    0, 3, 3, 3, 3, 3, 4, 0, 0, 0, 5, 0, 3, 3, 5, 5, 4, 4, 4, 1}, //3
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2,    3, 0, 3, 0, 3, 3, 4, 0, 0, 0, 5, 0, 5, 5, 5, 5, 4, 4, 4, 1}, //4
            {3, 3, 0, 0, 3, 0, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3,    3, 0, 0, 0, 3, 4, 4, 0, 0, 5, 5, 5, 5, 5, 5, 5, 4, 5, 5, 1}, //5
            {3, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 5, 1}, //6
            {5, 0, 3, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 1, 1, 0, 0, 5, 5, 5, 5, 5, 5, 4, 4, 4, 5, 1}, //7
            {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5,    0, 0, 5, 5, 0, 3, 1, 0, 0, 0, 5, 3, 3, 5, 5, 4, 4, 4, 5, 1}, //8
            {5, 0, 5, 5, 5, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0,    0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 5, 3, 3, 3, 5, 5, 4, 4, 5, 1}, //9
            {5, 0, 0, 3, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3,    2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 5, 5, 4, 5, 5, 5}, //10
            {5, 0, 0, 0, 3, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 2,    2, 3, 0, 5, 3, 0, 0, 0, 5, 5, 5, 5, 4, 4, 4, 4, 4, 5, 5, 5}, //11
            {5, 0, 3, 3, 3, 3, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 5, 3, 0, 3,    2, 2, 0, 5, 0, 0, 0, 0, 3, 3, 5, 4, 4, 5, 4, 5, 5, 5, 5, 5}, //12
            {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 5, 0, 0, 2,    2, 2, 0, 5, 3, 0, 0, 3, 2, 2, 5, 4, 4, 5, 4, 5, 5, 5, 5, 5}, //13

            {5, 0, 0, 0, 0, 3, 3, 0, 3, 3, 3, 3, 3, 3, 0, 0, 5, 5, 0, 2,    5, 5, 0, 5, 5, 0, 0, 3, 2, 2, 5, 4, 4, 4, 4, 4, 4, 5, 5, 5}, //14
            {5, 0, 0, 0, 1, 3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 3, 3, 2, 2, 5, 4, 5, 5, 5, 4, 5, 5, 5, 5}, //15
            {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 3, 2, 2, 5, 5, 5, 5, 5, 4, 5, 5, 5, 5}, //16
            {5, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0,    0, 0, 0, 3, 3, 0, 0, 0, 3, 3, 5, 5, 4, 4, 4, 4, 5, 4, 4, 6}, //17
            {5, 0, 5, 5, 5, 0, 0, 2, 2, 3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0,    0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 4, 4, 4, 5, 5, 4, 4, 4, 4, 6}, //18
            {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3,    3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}}; // 19

    public static int getPreciseTile(int x, int y){
        return map[x][y];
    }

}
