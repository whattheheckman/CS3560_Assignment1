import java.util.Arrays;

enum PieceColor {Red, Green, Blue, Yellow}
enum PieceLocation {Top, Left, Right}
enum PieceType {Tip, Centre, Edge}

// top tip, left tip, right tip
// top center, left center, right center
// top edge, left edge, right edge

/**
 *  Class for representing a face of a pryaminx Rubik's Cube
 */
class Face {
    private PieceColor[] tiles;
    public Face(PieceColor color) {
        tiles = new PieceColor[9];
        Arrays.fill(tiles, color);
    }
    public PieceColor[] getTiles() {
        return tiles;
    }
}


/**
 * Class that represents a pyraminx Rubik's Cube
 */
public class PyramidRubik {
    private Face[] faces = new Face[4];
    public PyramidRubik() {
        InitializeFaces();
    }
    public Face[] getFaces() {
        return faces;
    }


    /**
    * Returns whether a piece is a tip, edge,
    * or center piece based on its array index
    * @param piece_index integer for which array index to inspect
    * @return PieceType of Tip, Edge, or Centre
    */
    private PieceType getPieceType(int piece_index) {
        switch (piece_index) {
            case 1, 5, 9:
                return PieceType.Tip;
            case 2, 4, 7:
                return PieceType.Edge;
            case 3, 6, 8:
                return PieceType.Centre;
            default: return null;
        }
    }

    /**
     * Validate each face by checking that each face has the same color
     * @param face_index which face to validate
     * @return true is the face is all the same color, false if not
     * */
    public boolean validateFace(int face_index) {
        Face face_to_validate = faces[face_index];
        PieceColor previousColor = face_to_validate.getTiles()[0];
        for (PieceColor pieceColor : face_to_validate.getTiles()) {
            if (pieceColor != previousColor) {return false;}
        }
        return true;
    }

    /**
     * Validate if  cube is solved by checking that each side is the same color. If one of the sides fails, then the whole cube fails
     * @return true if the cube is solved, false if not
     */
    public boolean validateCube() {
        for (int i = 0; i < faces.length; i++) {
            if (!validateFace(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Initalizes the cube to have different colored faces for each face
     */
    private void InitializeFaces() {
        faces[0] = new Face(PieceColor.Red);
        faces[1] = new Face(PieceColor.Green);
        faces[2] = new Face(PieceColor.Blue);
        faces[3] = new Face(PieceColor.Yellow);
    }
}

