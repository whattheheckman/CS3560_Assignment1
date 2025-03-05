import java.util.Arrays;

enum PieceColor {Red, Green, Blue, Yellow}
enum PieceLocation {Top, Left, Right}
enum PieceType {Tip, Centre, Edge}

// top tip, left tip, right tip
// top center, left center, right center
// top edge, left edge, right edge


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

public class PryamidRubik {
    private Face[] faces = new Face[4];
    public PryamidRubik() {
        InitializeFaces();
    }
    public Face[] getFaces() {
        return faces;
    }

    private PieceType getPieceType(int face_index) {
        switch (face_index) {
            case 1, 5, 9:
                return PieceType.Tip;
            case 2, 4, 7:
                return PieceType.Edge;
            case 3, 6, 8:
                return PieceType.Centre;
            default: return null;
        }
    }

    // validate each face by checking that each face has the same color
    public boolean validateFace(int face_index) {
        Face face_to_validate = faces[face_index];
        PieceColor previousColor = face_to_validate.getTiles()[0];
        for (PieceColor pieceColor : face_to_validate.getTiles()) {
            if (pieceColor != previousColor) {return false;}
        }
        return true;
    }

    // Validate each side individually, if one of the sides fails, then the whole cube fails
    public boolean validateCube() {
        for (int i = 0; i < faces.length; i++) {
            if (!validateFace(i)) {
                return false;
            }
        }
        return true;
    }

    // each face needs a different color
    private void InitializeFaces() {
        faces[0] = new Face(PieceColor.Red);
        faces[1] = new Face(PieceColor.Green);
        faces[2] = new Face(PieceColor.Blue);
        faces[3] = new Face(PieceColor.Yellow);
    }
}

