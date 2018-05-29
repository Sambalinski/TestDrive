package FriendsCodes.sz.animu;

public enum AnimeType {
    Anime('A', '-'),
    Film('F', '+'),
    OVA('O', '='),
    Ongoing('G', '*'),
    UNSET('-', '?');

    public final char marker;
    public final char filler;

    AnimeType(char marker, char filler) {
        this.marker = marker;
        this.filler = filler;
    }

    public static AnimeType get(char marker) {
        for (AnimeType type : values()) {
            if (type.marker == marker)
                return type;
        }
        return UNSET;
    }
}
