package fahrkartenautomat;

public enum Note {
    HUNDRED_EURO(10000),
    FIFTY_EURO(5000),
    TWENTY_EURO(2000),
    TEN_EURO(1000),
    FIVE_EURO(500);

    private int noteValue;

    private Note(int value){
        noteValue = value;
    }
    public int getNoteValue(){
        return noteValue;
    }

}
