public class TrainLine {

    private static final String DEFAULT_NAME = "Hogwarts Express";

    /** The name of the train line */
    private String name;
    /** The head station of the train line */
    private Station head;
    /** Current number of stations in the line */
    private int numberOfStations;
    /** Tracks the end of the station - ASSIGNMENT 3 */
    private Station end;

    /** Basic constructor */
    public TrainLine(String name) {
        this.name = name;
        this.head = null;
        this.end = null
        this.numberOfStations = 0;
    } // basic constructor

    /** Default constructor */
    public TrainLine() {
        this(DEFAULT_NAME);
    } // default constructor

    /** Accessor for the number of stations */
    public int getNumberOfStations() {
        return this.numberOfStations;
    }

    /**
     * Adds a new station after the last station of a trainline.
     * 
     * @param name String with name of new station to create and add
     *
     * ASSIGNMENT 03 - Instead of iterating through the while loop everytime this method is called, the loop
     * now calls the new "end" variable to directly call the last station in the train line, adds the new station,
     * and assigns the "end" to be the last station on the line.
     */
    public void add(String name) {
        Station newStation = new Station(name);
        if (this.head == null) {
            // No stations exist in this line. Make this new station
            // the head station of the line
            this.head = newStation;
        } else {
            // sets the next station from the end to be the new station
            this.end.setNext(newStation);
        }
        // sets the new station as the last station
        this.end = newStation;
        this.numberOfStations = this.numberOfStations+1; 
        // or this.numberOfStations++;
        // or this.numberOfStatiosn += 1;
    } // method add

    /**
     * Finds how many stations are in a train line
     * 
     * METHOD MADE OBSOLETE BY INTRODUCTING TrainLine.numberOfStations
     */
    public int stationCounter() {
        int counter = 0;
        if (this.head != null) {
            // Train line not empty
            Station cursor = this.head;
            while (cursor != null) {
                counter = counter + 1;
                cursor = cursor.getNext();
            }
        }
        return counter;
    } // method countStations

    /**
     * I couldn't think of another way to execute this method other than to iterate through the station
     * and find the index that way. I thought about adding a new "index" variable to the "Station" class,
     * but that wouldn't work as I would still have to iterate through to find the index, anyway.
     *
     * METHOD EXPLANATION:
     * Finds the index of the desired Station in the list. Counts after each iteration (index) and either returns
     * the index, or returns "-1" if there is no Station matching the provided name (case-sensitive)
     * @param stationName - specified station
     * @return station index or "-1"
     */

    public int indexOf(String stationName) {
        // default index
        int index = -1;
        // initializing current index variable
        int i = 0;
        // initializing a cursor to "ride the line"
        Station cursor = this.head;
        // the cursor will "ride" until it either reaches the end or finds the desired station.
        // the loop keeps track at which station it's at until it ends
        while (cursor != null && cursor.getName() != stationName) {
            // updates current index
            i++;
            // moves cursor to next station
            cursor = cursor.getNext();
        }
        // if the cursor found the specified station, the current index will replace the default index
        // otherwise, default index is kept
        // if the station isn't in the line, the cursor will land at "null", as it will have iterated through the whole
        // line move on to the next station from last. This, by definition of the TrainLine and Station objects, is "null"
        if (cursor != null) {
            // assigns current index to returned index
            index = i;
        }
        return index;
    } // method indexOf

    /**
     * I thought that using the previous method to implement this one was the most appropriate.
     *
     * METHOD EXPLANATION:
     * Finds whether the specified station name exists within a train line by using indexOf().
     * @param stationName - specified station
     * @return contain - boolean that is true if the line contains the station (again, case-sensitive)
     */

    public boolean contains(String stationName) {
        // checks that there is a station with the specified name by calling indexOf() the train line.
        // if the station exist, the index should be between 0 and the length - 1.
        // if not, the index will return "-1", which makes the boolean below false.
        boolean contain = (this.indexOf(stationName) != -1);
        // returns the boolean.
        return contain;
    } // method contains

    /**
     * String representation of the object
     */
    private static final String EMPTY_TRAIN_LINE = "The train line is empty";
    private static final String TRAIN_LINE_HEADER = "\"%s\" has the following stations: %s";
    private static final String NEXT_ARROW = " --> ";

    public String toString() {
        if (this.head == null) {
            return EMPTY_TRAIN_LINE;
        } else {
            String stations = String.format(TRAIN_LINE_HEADER, this.name, this.head.getName());
            Station cursor = this.head.getNext();
            while (cursor != null) {
                stations = stations + NEXT_ARROW + cursor.getName();
                cursor = cursor.getNext();
            }
            return stations;
        }
    } // method toString
} // class TrainLine
