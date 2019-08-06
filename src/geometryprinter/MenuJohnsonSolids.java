package geometryprinter;
import geometryprinter.item.solid.johnson.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuJohnsonSolids extends MenuList{
    public MenuJohnsonSolids(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    protected void addButtons(){
        final MenuJohnsonSolids that = this;
        addButton("Add Square Pyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new SquarePyramid()));
            }
        });
        addButton("Add Pentagonal Pyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new PentagonalPyramid()));
            }
        });
        addButton("Add Triangular Cupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TriangularCupola()));
            }
        });
        addButton("Add Square Cupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new SquareCupola()));
            }
        });
        addButton("Add Pentagonal Cupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new PentagonalCupola()));
            }
        });
        addButton("Add Pentagonal Rotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new PentagonalRotunda()));
            }
        });
        addButton("Add Elongated Triangular Pyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedTriangularPyramid()));
            }
        });
        addButton("Add Elongated Square Pyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedSquarePyramid()));
            }
        });
        addButton("Add Elongated Pentagonal Pyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalPyramid()));
            }
        });
        addButton("Add Gyroelongated Square Pyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedSquarePyramid()));
            }
        });
        addButton("Add Gyroelongated Pentagonal Pyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedPentagonalPyramid()));
            }
        });
        addButton("Add Triangular Bipyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TriangularBipyramid()));
            }
        });
        addButton("Add Pentagonal Bipyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new PentagonalBipyramid()));
            }
        });
        addButton("Add Elongated Triangular Bipyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedTriangularBipyramid()));
            }
        });
        addButton("Add Elongated Square Bipyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedSquareBipyramid()));
            }
        });
        addButton("Add Elongated Pentagonal Bipyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalBipyramid()));
            }
        });
        addButton("Add Gyroelongated Square Bipyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedSquareBipyramid()));
            }
        });
        addButton("Add Elongated Triangular Cupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedTriangularCupola()));
            }
        });
        addButton("Add Elongated Square Cupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedSquareCupola()));
            }
        });
        addButton("Add Elongated Pentagonal Cupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalCupola()));
            }
        });
        addButton("Add Elongated Pentagonal Rotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalRotunda()));
            }
        });
        addButton("Add Gyroelongated Triangular Cupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedTriangularCupola()));
            }
        });
        addButton("Add Gyroelongated Square Cupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedSquareCupola()));
            }
        });
        addButton("Add Gyroelongated Pentagonal Cupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedPentagonalCupola()));
            }
        });
        addButton("Add Gyroelongated Pentagonal Routunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedPentagonalRotunda()));
            }
        });
        addButton("Add Gyrobifastigium", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Gyrobifastigium()));
            }
        });
        addButton("Add Triangular Orthobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TriangularOrthobicupola()));
            }
        });
        addButton("Add Square Orthobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new SquareOrthobicupola()));
            }
        });
        addButton("Add Square Gyrobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new SquareGyrobicupola()));
            }
        });
        addButton("Add Pentagonal Orthobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new PentagonalOrthobicupola()));
            }
        });
        addButton("Add Pentagonal Gyrobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new PentagonalGyrobicupola()));
            }
        });
        addButton("Add Pentagonal Orthocupolarotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new PentagonalOrthocupolarotunda()));
            }
        });
        addButton("Add Pentagonal Gyrocupolarotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new PentagonalGyrocupolarotunda()));
            }
        });
        addButton("Add Pentagonal Orthobirotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new PentagonalOrthobirotunda()));
            }
        });
        addButton("Add Elongated Triangular Orthobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedTriangularOrthobicupola()));
            }
        });
        addButton("Add Elongated Triangular Gyrobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedTriangularGyrobicupola()));
            }
        });
        addButton("Add Elongated Square Gyrobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedSquareGyrobicupola()));
            }
        });
        addButton("Add Elongated Pentagonal Orthobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalOrthobicupola()));
            }
        });
        addButton("Add Elongated Pentagonal Gyrobicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalGyrobicupola()));
            }
        });
        addButton("Add Elongated Pentagonal Orthocupolarotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalOrthocupolarotunda()));
            }
        });
        addButton("Add Elongated Pentagonal Gyrocupolarotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalGyrocupolarotunda()));
            }
        });
        addButton("Add Elongated Pentagonal Orthobirotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalOrthobirotunda()));
            }
        });
        addButton("Add Elongated Pentagonal Gyrobirotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ElongatedPentagonalGyrobirotunda()));
            }
        });
        addButton("Add Gyroelongated Triangular Bicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedTriangularBicupola()));
            }
        });
        addButton("Add Gyroelongated Square Bicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedSquareBicupola()));
            }
        });
        addButton("Add Gyroelongated Pentagonal Bicupola", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedPentagonalBicupola()));
            }
        });
        addButton("Add Gyroelongated Pentagonal Cupolarotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedPentagonalCupolarotunda()));
            }
        });
        addButton("Add Gyroelongated Pentagonal Birotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyroelongatedPentagonalBirotunda()));
            }
        });
        addButton("Add Augmented Triangular Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new AugmentedTriangularPrism()));
            }
        });
        addButton("Add Biaugmented Triangular Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new BiaugmentedTriangularPrism()));
            }
        });
        addButton("Add Triaugmented Triangular Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TriaugmentedTriangularPrism()));
            }
        });
        addButton("Add Augmented Pentagonal Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new AugmentedPentagonalPrism()));
            }
        });
        addButton("Add Biaugmented Pentagonal Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new BiaugmentedPentagonalPrism()));
            }
        });
        addButton("Add Augmented Hexagonal Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new AugmentedHexagonalPrism()));
            }
        });
        addButton("Add Parabiaugmented Hexagonal Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ParabiaugmentedHexagonalPrism()));
            }
        });
        addButton("Add Metabiaugmented Hexagonal Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new MetabiaugmentedHexagonalPrism()));
            }
        });
        addButton("Add Triaugmented Hexagonal Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TriaugmentedHexagonalPrism()));
            }
        });
        addButton("Add Augmented Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new AugmentedDodecahedron()));
            }
        });
        addButton("Add Parabiaugmented Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ParabiaugmentedDodecahedron()));
            }
        });
        addButton("Add Metabiaugmented Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new MetabiaugmentedDodecahedron()));
            }
        });
        addButton("Add Triaugmented Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TriaugmentedDodecahedron()));
            }
        });
        addButton("Add Metabidiminished Icosahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new MetabidiminishedIcosahedron()));
            }
        });
        addButton("Add Tridiminished Icosahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TridiminishedIcosahedron()));
            }
        });
        addButton("Add Augmented Tridiminished Icosahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new AugmentedTridiminishedIcosahedron()));
            }
        });
        addButton("Add Augmented Truncated Tetrahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new AugmentedTruncatedTetrahedron()));
            }
        });
        addButton("Add Augmented Truncated Cube", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new AugmentedTruncatedCube()));
            }
        });
        addButton("Add Biaugmented Truncated Cube", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new BiaugmentedTruncatedCube()));
            }
        });
        addButton("Add Augmented Truncated Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new AugmentedTruncatedDodecahedron()));
            }
        });
        addButton("Add Parabiaugmented Truncated Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ParabiaugmentedTruncatedDodecahedron()));
            }
        });
        addButton("Add Metabiaugmented Truncated Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new MetabiaugmentedTruncatedDodecahedron()));
            }
        });
        addButton("Add Triaugmented Truncated Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TriaugmentedTruncatedDodecahedron()));
            }
        });
        addButton("Add Gyrate Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyrateRhombicosidodecahedron()));
            }
        });
        addButton("Add Parabigyrate Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ParabigyrateRhombicosidodecahedron()));
            }
        });
        addButton("Add Metabigyrate Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new MetabigyrateRhombicosidodecahedron()));
            }
        });
        addButton("Add Trigyrate Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TrigyrateRhombicosidodecahedron()));
            }
        });
        addButton("Add Diminished Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new DiminishedRhombicosidodecahedron()));
            }
        });
        addButton("Add Paragyrate Diminished Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ParagyrateDiminishedRhombicosidodecahedron()));
            }
        });
        addButton("Add Metagyrate Diminished Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new MetagyrateDiminishedRhombicosidodecahedron()));
            }
        });
        addButton("Add Bigyrate Diminished Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new BigyrateDiminishedRhombicosidodecahedron()));
            }
        });
        addButton("Add Parabidiminished Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new ParabidiminishedRhombicosidodecahedron()));
            }
        });
        addButton("Add Metabidiminished Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new MetabidiminishedRhombicosidodecahedron()));
            }
        });
        addButton("Add Gyrate Bidiminished Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new GyrateBidiminishedRhombicosidodecahedron()));
            }
        });
        addButton("Add Tridiminished Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TridiminishedRhombicosidodecahedron()));
            }
        });
        addButton("Add Snub Disphenoid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new SnubDisphenoid()));
            }
        });
        addButton("Add Snub Square Antiprism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new SnubSquareAntiprism()));
            }
        });
        addButton("Add Sphenocorona", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Sphenocorona()));
            }
        });
        addButton("Add Augmented Sphenocorona", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new AugmentedSphenocorona()));
            }
        });
        addButton("Add Sphenomegacorona", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Sphenomegacorona()));
            }
        });
        addButton("Add Hebesphenomegacorona", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Hebesphenomegacorona()));
            }
        });
        addButton("Add Disphenocingulum", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Disphenocingulum()));
            }
        });
        addButton("Add Bilunabirotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Bilunabirotunda()));
            }
        });
        addButton("Add Triangular hebesphenorotunda", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TriangularHebesphenorotunda()));
            }
        });
    }
}