package geometryprinter.item;
import geometryprinter.Core;
import geometryprinter.PageObject;
import geometryprinter.item.flat.EquilateralTriangleArray;
import geometryprinter.item.flat.Polygon;
import geometryprinter.item.flat.Rectangle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public abstract class PolyhedronNet extends Item{
    public NetPart net;
    protected int size;
    public PolyhedronNet(){
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        rebuild();
        for(NetPart part : net.getAllParts()){
            part.draw(g, format);
        }
    }
    @Override
    public boolean requiresDoubleSiding(){
        return false;
    }
    @Override
    public boolean requiresColor(){
        return false;
    }
//    @Override
//    public boolean isEqual(Item item){
//        if(item instanceof PolyhedronNet){
//            return ((PolyhedronNet)item).net.equals(net);
//        }
//        return false;
//    }
    @Override
    public boolean canSplit(){
        return true;
    }
    @Override
    protected Dimension getItemSize(){
        rebuild();
        double[] dim = net.getTotalDimensions();
        return new Dimension((int)dim[2]+1, (int)dim[3]+1);
    }
    private void reposition(){
        double[] dim = net.getTotalDimensions();
        for(NetPart part : net.getAllParts()){
            part.x-=dim[0];
            part.y-=dim[1];
        }
    }
    @Override
    public void split(ArrayList<PageObject> split){
        int triangles = 0;
        int squares = 0;
        double sideLength = -1;
        for(NetPart part : net.getAllParts()){
            sideLength = part.sideLength;
            if(part.sides==3){
                triangles++;
                continue;
            }
            if(part.sides==4){
                squares++;
                continue;
            }
            split.add(new Polygon(part.sides, (int) part.sideLength, true));
        }
        if(triangles>0)split.add(new EquilateralTriangleArray((int) sideLength, triangles));
        for(int i = 0; i<squares; i++){
            split.add(new Rectangle((int)sideLength, (int)sideLength));
        }
    }
    @Override
    public void set(String property, Object value){
        if(property.toLowerCase().equals("size")){
            size = (int) value;
            net = null;
        }
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Size"));
        return settings;
    }
    protected abstract void buildNet();
    private void rebuild(){
        if(net!=null)return;
        buildNet();
        reposition();
    }
    public static class NetPart{
        private final double rot;
        public final int sides;
        private double x;
        private double y;
        private final double sideLength;
        public final NetPart[] polygons;
        private static final NetPart EMPTY = new NetPart(0, 0, 0, 0, 0);
        private Color color;
        public NetPart(double rot, int sides, double x, double y, double sideLength){
            this(rot, sides, x, y, sideLength, Color.black);
        }
        public NetPart(double rot, int sides, double x, double y, double sideLength, Color color){
            this.rot = rot;
            this.sides = sides;
            this.x = x;
            this.y = y;
            this.sideLength = sideLength;
            this.color = color;
            polygons = new NetPart[sides];
        }
        /**
         * adds a polygon to this net.
         * @param side which side to add it on
         * @param sides how many sides the new polygon should have
         * @return the new polygon.
         */
        public NetPart addPolygon(int side, int sides){
            if(sides<3)throw new IllegalArgumentException("Polygons must have 3 sides!");
            if(side<0)throw new IllegalArgumentException("Side must be greater than or equal to zero!");
            if(side>sides-1)throw new IllegalArgumentException("Side index "+side+" does not exist on a "+sides+"-sided polygon! Use a number in the range 0-"+(sides-1));
            double[] location = Core.getLocation(x, y, this.sides, rot, sideLength, side, sides);
            if(polygons[side]!=null)throw new IllegalArgumentException("Polygon on side "+side+" already exists!");
            polygons[side] = new NetPart(location[2], sides, location[0], location[1], sideLength);
            polygons[side].polygons[Math.round((sides-1)/2f)] = EMPTY;
            return polygons[side];
        }
        @Override
        public boolean equals(Object obj){
            if(obj instanceof NetPart){
                NetPart net = (NetPart)obj;
                if(net.sides==sides&&net.rot==rot&&net.x==x&&net.y==y&&net.sideLength==sideLength){
                    for(int i = 0; i<polygons.length; i++){
                        NetPart polygon = polygons[i];
                        if(polygon==null){
                            if(net.polygons[i]==null)continue;
                            return false;
                        }
                        if(!net.polygons[i].equals(polygon)){
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        public ArrayList<NetPart> getAllParts(){
            ArrayList<NetPart> parts = new ArrayList<>();
            if(this==EMPTY){
                return parts;
            }
            parts.add(this);
            for(NetPart part : polygons){
                if(part==null)continue;
                parts.addAll(part.getAllParts());
            }
            return parts;
        }
        private void draw(Graphics g, PageFormat format){
            g.setColor(color);
            ArrayList<Double> pointRotations = new ArrayList<>();
            double r = 360/sides;
            for(int i = 0; i<sides; i++){
                double d = r*i+rot;
                if(d>=360)d-=360;
                pointRotations.add(d);
            }
            for(int i = 0; i<pointRotations.size(); i++){
                double r1 = pointRotations.get(i);
                double r2;
                if(i<pointRotations.size()-1){
                    r2 = pointRotations.get(i+1);
                }else{
                    r2 = pointRotations.get(0);
                }
                r1 = Math.toRadians(r1);
                r2 = Math.toRadians(r2);
                double rad = getRadius(sides, sideLength);
                double x1 = x+rad*Math.sin(r1);
                double y1 = y+rad*Math.cos(r1);
                double x2 = x+rad*Math.sin(r2);
                double y2 = y+rad*Math.cos(r2);
                g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
            }
        }
        /**
         * @return {x1,y1,x2,y2} where (x1,y1) is the top left corner and (x2,y2) is the bottom right corner.
         */
        private double[] getTotalDimensions(){
            ArrayList<double[]> points = new ArrayList<>();
            for(NetPart part : getAllParts()){
                points.addAll(part.getPoints());
            }
            double xmin = Double.NaN;
            double ymin = Double.NaN;
            double xmax = Double.NaN;
            double ymax = Double.NaN;
            for(double[] point : points){
                if(Double.isNaN(xmin))xmin = point[0];
                if(Double.isNaN(ymin))ymin = point[1];
                if(Double.isNaN(xmax))xmax = point[0];
                if(Double.isNaN(ymax))ymax = point[1];
                xmin = Math.min(xmin,point[0]);
                ymin = Math.min(ymin,point[1]);
                xmax = Math.max(xmax,point[0]);
                ymax = Math.max(ymax,point[1]);
            }
            return new double[]{xmin,ymin,xmax,ymax};
        }
        private double getRadius(int sides, double sideLength){
            return (1/Math.cos(Math.toRadians(90-(180/sides))))*(sideLength/2d);
        }
        private ArrayList<double[]> getPoints(){
            ArrayList<Double> pointRotations = new ArrayList<>();
            ArrayList<double[]> points = new ArrayList<>();
            double r = 360/sides;
            for(int i = 0; i<sides; i++){
                double d = r*i+rot;
                if(d>=360)d-=360;
                pointRotations.add(d);
            }
            for(int i = 0; i<pointRotations.size(); i++){
                double r1 = pointRotations.get(i);
                r1 = Math.toRadians(r1);
                double rad = getRadius(sides, sideLength);
                double x1 = x+rad*Math.sin(r1);
                double y1 = y+rad*Math.cos(r1);
                points.add(new double[]{x1,y1});
            }
            return points;
        }
        public NetPart getParent(){
            if(sides%2==0){
                return polygons[sides-2];
            }
            return polygons[sides-1];
        }
        public void remove(NetPart selectedPart){
            for(int i = 0; i<polygons.length; i++){
                NetPart polygon = polygons[i];
                if(polygon==selectedPart)polygons[i] = null;
            }
        }
    }
}