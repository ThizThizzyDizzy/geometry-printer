package geometryprinter;
import static geometryprinter.Main.getRemoteInputStream;
import geometryprinter.item.Item;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import simplelibrary.Sys;
import simplelibrary.error.ErrorAdapter;
import simplelibrary.error.ErrorCategory;
import simplelibrary.font.FontManager;
import simplelibrary.game.GameHelper;
import simplelibrary.opengl.Renderer2D;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.components.MenuComponent;
import simplelibrary.opengl.gui.components.MenuComponentButton;
import simplelibrary.texture.TexturePack;
import simplelibrary.texture.TexturePackManager;
import simplelibraryextended.opengl.model.Model;
public class Core extends Renderer2D{
    /**
     * Find the location of a new polygon on a specific side of another polygon.
     * @param x the X value of the current polygon.
     * @param y the Y value of the current polygon. (On a coordinate plane, so positive Y means up.)
     * @param sides the number of sides on the original polygon.
     * @param rot the rotation of the original polygon. rot of 0 means a point is directly up. (Degrees)
     * @param sideLength the side length of the original polygon.
     * @param side which side to add a new polygon to. Goes clockwise from the top. (0 to n-1)
     * @param newSides How many sides the new polygon should have.
     * @return {x, y, rot} of the new polygon.
     */
    public static double[] getLocation(double x, double y, int sides, double rot, double sideLength, int side, int newSides){
        //TODO this does not work properly for large shapes. (Truncated Cube)
        double dist = apothem(sides, sideLength)+apothem(newSides, sideLength);
        double angle = 360d/sides;
        rot += angle*(side+.5);
        if(rot>=360){
            rot-=360;
        }
        x+=dist*Math.sin(Math.toRadians(rot));
        y+=dist*Math.cos(Math.toRadians(rot));
        if(newSides%2==0){
            double newAngle = 360d/newSides;
            rot+=newAngle/2;
        }
        if(rot>=360){
            rot-=360;
        }
        return new double[]{x,y,rot};
    }
    /**
     * Find the location of a new polygon on a specific side of another polygon centered at (0,0).
     * @param sides the number of sides on the original polygon.
     * @param rot the rotation of the original polygon. rot of 0 means a point is directly up.
     * @param sideLength the side length of the original polygon.
     * @param side which side to add a new polygon to. Goes clockwise from the top. (0 to n-1)
     * @param newSides How many sides the new polygon should have.
     * @return {x, y, rot}
     */
    public static double[] getLocation(int sides, double rot, double sideLength, int side, int newSides){
        return getLocation(0, 0, sides, rot, sideLength, side, newSides);
    }
    public static double apothem(int sides, double sideLength){
        return sideLength/(2*Math.tan(Math.PI/sides));
    }
    public static GUI gui;
    public static GameHelper helper;
    public static ArrayList<Long> FPStracker = new ArrayList<>();
    public static boolean debugMode = false;
    public static final boolean is3D = true;
    public static boolean enableCullFace = false;
    public static final boolean fullscreen = true;
    public static final boolean supportTyping = true;
    public static String newsURL = "https://www.dropbox.com/s/2ih8waveyfqqicz/news.txt?dl=1";
    public static ArrayList<String> news = new ArrayList<>();
    public static ArrayList<BackgroundElement> backgroundElements = new ArrayList<>();
    public static final Random rand = new Random(1);
    private static int maxBackgroundElements = 500;
    private static int timer = 0;
    private static int time = 0;
    public static void main(String[] args) throws NoSuchMethodException{
        helper = new GameHelper();
        helper.setBackground(new Color(0, 127, 255));
        helper.setDisplaySize(800, 600);
        helper.setRenderInitMethod(Core.class.getDeclaredMethod("renderInit", new Class<?>[0]));
        helper.setTickInitMethod(Core.class.getDeclaredMethod("tickInit", new Class<?>[0]));
        helper.setFinalInitMethod(Core.class.getDeclaredMethod("finalInit", new Class<?>[0]));
        helper.setMaximumFramerate(60);
        helper.setRenderMethod(Core.class.getDeclaredMethod("render", int.class));
        helper.setTickMethod(Core.class.getDeclaredMethod("tick", boolean.class));
        helper.setUsesControllers(true);
        helper.setWindowTitle(Main.applicationName);
        helper.setMode(is3D?GameHelper.MODE_HYBRID:GameHelper.MODE_2D);
        if(fullscreen){
            helper.setFullscreen(true);
            helper.setAutoExitFullscreen(false);
        }
        helper.setFrameOfView(90);
        Sys.initLWJGLGame(new File("/errors/"), new ErrorAdapter(){
            @Override
            public void warningError(String message, Throwable error, ErrorCategory catagory){
                if(message==null){
                    return;
                }
                if(message.contains(".png!")){
                    System.err.println(message);
                }
            }
        }, null, helper);
    }
    public static void renderInit() throws LWJGLException{
        helper.frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                helper.running = false;
            }
        });
        FontManager.addFont("/simplelibrary/font");
        FontManager.setFont("font");
        GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_BLEND);
        if(is3D){
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            if(enableCullFace) GL11.glEnable(GL11.GL_CULL_FACE);
        }
        if(supportTyping){
            Keyboard.enableRepeatEvents(true);
        }
        new TexturePackManager(new File(Main.getAppdataRoot()+"\\Texture packs"), new TexturePack(){
            @Override
            public InputStream getResourceAsStream(String name){
                if(name.startsWith("/")){
                    return super.getResourceAsStream(name);
                }
                try{
                    return new FileInputStream(new File(name));
                }catch(FileNotFoundException ex){}
                return super.getResourceAsStream(name);
            }
        });
        gui = new GUI(is3D?GameHelper.MODE_HYBRID:GameHelper.MODE_2D, helper);
        new Menu2D(gui, null).loadItems();
        new MenuArchimedeanSolids(gui, null).loadItems();
        new MenuPlatonicSolids(gui, null).loadItems();
        new MenuJohnsonSolids(gui, null).loadItems();
        new MenuBuildingMaterials(gui, null).loadItems();
        new MenuOther3D(gui, null).loadItems();
        new MenuChemistry(gui, null).loadItems();
        Item.init = false;
        gui.open(new MenuMain(gui));
    }
    public static void tickInit() throws LWJGLException{
    }
    public static void finalInit() throws LWJGLException{
        if(Main.jLayer){
            Sounds.create();
        }
        new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    news.clear();
                    news.add("Downloading news...");
                    File newsFile = new File(Main.getAppdataRoot()+"\\news.txt");
                    if(newsFile.exists()){
                        newsFile.delete();
                    }
                    if(downloadFile(newsURL, newsFile)==null){
                        news.clear();
                        news.add("Failed to download news.");
                        return;
                    }
                    news.clear();
                    try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(newsFile)))) {
                        String line;
                        while((line=reader.readLine())!=null){
                            news.add(line);
                        }
                    }
                }catch(IOException ex){
                    throw new RuntimeException(ex);
                }
            }
        }).start();
    }
    public static void tick(boolean isLastTick){
        if(Main.jLayer){
            Sounds.tick(isLastTick);
        }
        if(!isLastTick){
            gui.tick();
        }
    }
    public static void render(int millisSinceLastTick){
        GL11.glColor4d(1, 1, 1, 1);
        if(gui.menu!=null&&(gui.menu instanceof MenuMain||gui.menu instanceof MenuCredits||gui.menu instanceof MenuOutOfMemory||gui.menu instanceof MenuMusicDownload)){
            render3DBackground(millisSinceLastTick);
        }
        if(gui.menu!=null&&gui.menu instanceof MenuAddItem){
            ((MenuAddItem)gui.menu).render3D(millisSinceLastTick);
        }
        if(gui.menu!=null&&gui.menu instanceof MenuPrintList){
            ((MenuPrintList)gui.menu).render3D(millisSinceLastTick);
        }
        GL11.glColor4d(1, 1, 1, 1);
        if(is3D&&enableCullFace) GL11.glDisable(GL11.GL_CULL_FACE);
        gui.render(millisSinceLastTick);
        if(is3D&&enableCullFace) GL11.glEnable(GL11.GL_CULL_FACE);
        FPStracker.add(System.currentTimeMillis());
        while(FPStracker.get(0)<System.currentTimeMillis()-5_000){
            FPStracker.remove(0);
        }
    }
    public static long getFPS(){
        return FPStracker.size()/5;
    }
    public static double distance(MenuComponent o1, MenuComponent o2){
        return Math.sqrt(Math.pow((o1.x+o1.width/2)-(o2.x+o2.width/2), 2)+Math.pow((o1.y+o1.height/2)-(o2.y+o2.height/2), 2));
    }
    public static double distance(MenuComponent component, double x, double y) {
        return distance(component, new MenuComponentButton(x, y, 0, 0, "", false));
    }
    public static double distance(double x1, double y1, double x2, double y2) {
        return distance(new MenuComponentButton(x1, y1, 0, 0, "", false), new MenuComponentButton(x2, y2, 0, 0, "", false));
    }
    public static boolean isMouseWithinComponent(MenuComponent component){
        return isClickWithinBounds(Mouse.getX(), Display.getHeight()-Mouse.getY(), component.x, component.y, component.x+component.width, component.y+component.height);
    }
    public static boolean isMouseWithinComponent(MenuComponent component, MenuComponent... parents){
        double x = component.x;
        double y = component.y;
        for(MenuComponent c : parents){
            x+=c.x;
            y+=c.y;
        }
        return isClickWithinBounds(Mouse.getX(), Display.getHeight()-Mouse.getY(), x, y, x+component.width, y+component.height);
    }
    public static boolean isPointWithinComponent(double x, double y, MenuComponent component){
        return isClickWithinBounds(x, y, component.x, component.y, component.x+component.width, component.y+component.height);
    }
    private static void render3DBackground(int millisSinceLastTick){
        if(backgroundElements.size()<maxBackgroundElements){
            timer++;
            if(timer>time){
                backgroundElements.add(new BackgroundElementModel(getRandomItemModel()));
                timer -= time;
            }
        }
        for (Iterator<BackgroundElement> it = backgroundElements.iterator(); it.hasNext();) {
            BackgroundElement element = it.next();
            element.render(millisSinceLastTick);
            if(element.dead){
                it.remove();
            }
        }
    }
    public static double getValueBetweenTwoValues(double pos1, double val1, double pos2, double val2, double pos){
        if(pos1>pos2){
            return getValueBetweenTwoValues(pos2, val2, pos1, val1, pos);
        }
        double posDiff = pos2-pos1;
        double percent = pos/posDiff;
        double valDiff = val2-val1;
        return percent*valDiff+val1;
    }
    public static void drawLine(double x1, double y1, double x2, double y2, int width){
        Renderer2D.drawLine(x1, y1, x2, y2);
        for(int i = 0; i<width/2; i++){
            Renderer2D.drawLine(x1+i, y1, x2+i, y2);
            Renderer2D.drawLine(x1-i, y1, x2-i, y2);
            Renderer2D.drawLine(x1, y1+i, x2, y2+i);
            Renderer2D.drawLine(x1, y1-i, x2, y2-i);
        }
    }
    private static Model getRandomItemModel(){
        Item item = Item.items.get(rand.nextInt(Item.items.size()));
        try{
            Model model = item.getModel();
            if(model==null)return getRandomItemModel();
            return model;
        }catch(IOException ex){
            System.err.println(ex.getMessage());
            return getRandomItemModel();
        }
    }
    private static File downloadFile(String link, File destinationFile){
        if(destinationFile.exists()||link==null){
            return destinationFile;
        }
        destinationFile.getParentFile().mkdirs();
        try {
            URL url = new URL(link);
            int fileSize;
            URLConnection connection = url.openConnection();
            connection.setDefaultUseCaches(false);
            if ((connection instanceof HttpURLConnection)) {
                ((HttpURLConnection)connection).setRequestMethod("HEAD");
                int code = ((HttpURLConnection)connection).getResponseCode();
                if (code / 100 == 3) {
                    return null;
                }
            }
            fileSize = connection.getContentLength();
            byte[] buffer = new byte[65535];
            int unsuccessfulAttempts = 0;
            int maxUnsuccessfulAttempts = 3;
            boolean downloadFile = true;
            while (downloadFile) {
                downloadFile = false;
                URLConnection urlconnection = url.openConnection();
                if ((urlconnection instanceof HttpURLConnection)) {
                    urlconnection.setRequestProperty("Cache-Control", "no-cache");
                    urlconnection.connect();
                }
                String targetFile = destinationFile.getName();
                FileOutputStream fos;
                int downloadedFileSize;
                try (InputStream inputstream=getRemoteInputStream(targetFile, urlconnection)) {
                    fos=new FileOutputStream(destinationFile);
                    downloadedFileSize=0;
                    int read;
                    while ((read = inputstream.read(buffer)) != -1) {
                        fos.write(buffer, 0, read);
                        downloadedFileSize += read;
                    }
                }
                fos.close();
                if (((urlconnection instanceof HttpURLConnection)) && 
                    ((downloadedFileSize != fileSize) && (fileSize > 0))){
                    unsuccessfulAttempts++;
                    if (unsuccessfulAttempts < maxUnsuccessfulAttempts){
                        downloadFile = true;
                    }else{
                        throw new Exception("failed to download "+targetFile);
                    }
                }
            }
            return destinationFile;
        }catch (Exception ex){
            return null;
        }
    }
}