package Generics.WildCardsDemo;

public class BoundedWildcard {
    static void showXY(Coords<? extends TwoD> c) {
        for (int i = 0; i < c.coordsObjArr.length; i++)
            System.out.println(c.coordsObjArr[i].x + " " + c.coordsObjArr[i].y);
        System.out.println();
    }

    static void showXYZ(Coords<? extends ThreeD> c) {
        for (int i = 0; i < c.coordsObjArr.length; i++)
            System.out.println(c.coordsObjArr[i].x + " " + c.coordsObjArr[i].y + " " + c.coordsObjArr[i].z);
        System.out.println();
    }

    static void showXYZTime(Coords<? extends FourD> c) {
        for (int i = 0; i < c.coordsObjArr.length; i++)
            System.out.println(c.coordsObjArr[i].x + " " + c.coordsObjArr[i].y + " " + c.coordsObjArr[i].z + " " + c.coordsObjArr[i].t);
        System.out.println();
    }

    static void showXYThreeOnly(Coords<? super ThreeD> c) {
        for (int i = 0; i < c.coordsObjArr.length; i++)
            System.out.println(c.coordsObjArr[i].x + " " + c.coordsObjArr[i].y);
        System.out.println();
    }

    public static void main(String[] args) {
        Coords<TwoD> twoDCoords = new Coords<>(new TwoD[]{new TwoD(3, 4),
                new TwoD(1, 7), new TwoD(5, 5)});


        Coords<ThreeD> threeDCoords = new Coords<>(new ThreeD[]{new ThreeD(5, 5, 3),
                new ThreeD(-9, 5, 3), new ThreeD(-7, 7, 1)});

        Coords<FourD> fourDCoords = new Coords<>(new FourD[]{new FourD(1, 2, 3, 4),
                new FourD(-6, 1, 4, 5), new FourD(-8, 2, 8, 4)});

        showXY(twoDCoords);
        showXY(threeDCoords);
        showXYZTime(fourDCoords);
        showXYThreeOnly(twoDCoords);
        showXYThreeOnly(threeDCoords);
    }
}
