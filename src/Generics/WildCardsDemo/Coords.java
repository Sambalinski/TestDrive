package Generics.WildCardsDemo;

public class Coords<T extends TwoD> {
    T[] coordsObjArr;

    Coords(T[] o) {
        coordsObjArr = o;
    }
}
