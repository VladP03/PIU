package PIUGame.Graphics;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage heroRight;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_noAnimation;

    // Dale
    public static BufferedImage soil;
    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static BufferedImage townGrass;
    public static BufferedImage townGrassDestroyed;
    public static BufferedImage townSoil;
    public static BufferedImage water;
    public static BufferedImage water1;
    public static BufferedImage rockUp;
    public static BufferedImage rockDown;
    public static BufferedImage rockLeft;
    public static BufferedImage rockRight;
    public static BufferedImage tree;
    public static BufferedImage tile_1;
    public static BufferedImage[] monster_down;
    public static BufferedImage[] monster_up;
    public static BufferedImage[] monster_left;
    public static BufferedImage[] monster_right;
    public static BufferedImage[] monster_noAnim;
    public static BufferedImage button_start;
    public static BufferedImage button_exit;
    public static BufferedImage lifeImage;
    public static BufferedImage stone_image;
    public static BufferedImage tree_image;
    public static BufferedImage wall_image;
    public static BufferedImage arrow_image;
    public static BufferedImage background_image;
    /// Referinte catre elementele grafice (dale) utilizate in joc.
    // Hero
    private static BufferedImage heroLeft;

    /*
        \brief Functia initializaza referintele catre elementele grafice utilizate.
        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));

        // SpriteSheet-uri pentru caractere
        SpriteSheet hero_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Character/Hero.png"));
        SpriteSheet monster_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Monster/Monster.png"));

        // SpriteSheet-uri pentru dale mapa
        SpriteSheet wall_1_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Wall1.png"));
        SpriteSheet wall_2_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Wall2.png"));
        SpriteSheet tree_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Tree.png"));
        SpriteSheet diamond_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Diamond.png"));
        SpriteSheet water_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Water.png"));

        // SpriteSheet pentru indicarea nivelului urmator
        SpriteSheet arrow_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Arrow.png"));

        // SpriteSheet pentru viata
        SpriteSheet life_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Life.png"));

        // SpriteSheet start & exit
        SpriteSheet button_start_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Start&Exit/StartButton.png"));
        SpriteSheet button_exit_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Start&Exit/ExitButton.png"));

        // SpriteSheet background
        SpriteSheet background_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Background/BackgroundImage.jpg"));
        background_image = background_sheet.crop_precise(0, 0, 1350, 770);

        //SpriteSheet diamond_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/tree1.png"));
        //SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/pp1.jpg"));


        /// Se obtin subimaginile corespunzatoare elementelor necesare.

        arrow_image = arrow_SpriteSheet.crop_precise(0, 0, 600, 450);
        wall_image = wall_2_SpriteSheet.crop_precise(0, 0, 60, 56);
        water1 = water_SpriteSheet.crop_precise(0, 0, 400, 350);
        stone_image = diamond_SpriteSheet.crop_precise(0, 0, 1300, 1300);
        tree_image = tree_SpriteSheet.crop_precise(0, 0, 800, 1000);
        //stone_image = sheet.crop_precise(0, 0, 180, 180);
        lifeImage = life_SpriteSheet.crop_precise(0, 0, 540, 530);
        tile_1 = wall_1_SpriteSheet.crop(0, 0);

        //start / exit button

        //button_start = new BufferedImage[2];
        button_start = button_start_SpriteSheet.crop_precise(0, 0, 200, 80);
        //button_start[1] = button_start_SpriteSheet.crop_precise(0,0, 200, 80);

        //button_exit = new BufferedImage[2];
        button_exit = button_exit_SpriteSheet.crop_precise(0, 0, 200, 80);
        //button_exit[1] = button_exit_SpriteSheet.crop_precise(0,0, 200, 80);

        //  sheet_1


        grass = sheet.crop(0, 0);
        soil = sheet.crop(1, 0);
        water = sheet.crop(2, 0);
        mountain = sheet.crop(3, 0);
        townGrass = sheet.crop(0, 1);
        townGrassDestroyed = sheet.crop(1, 1);
        townSoil = sheet.crop(2, 1);
        tree = sheet.crop(3, 1);
        heroLeft = sheet.crop(0, 2);
        heroRight = sheet.crop(1, 2);
        rockUp = sheet.crop(2, 2);
        rockDown = sheet.crop(3, 2);
        rockLeft = sheet.crop(0, 3);
        rockRight = sheet.crop(1, 3);

        //sheet_player

        player_down = new BufferedImage[3];
        player_up = new BufferedImage[3];
        player_left = new BufferedImage[3];
        player_right = new BufferedImage[3];
        player_noAnimation = new BufferedImage[1];

        player_noAnimation[0] = hero_SpriteSheet.crop_player(0, 2);

        player_down[0] = hero_SpriteSheet.crop_player(0, 2);
        player_down[1] = hero_SpriteSheet.crop_player(1, 2);
        player_down[2] = hero_SpriteSheet.crop_player(2, 2);

        player_up[0] = hero_SpriteSheet.crop_player(0, 0);
        player_up[1] = hero_SpriteSheet.crop_player(1, 0);
        player_up[2] = hero_SpriteSheet.crop_player(2, 0);

        player_left[0] = hero_SpriteSheet.crop_player(0, 1);
        player_left[1] = hero_SpriteSheet.crop_player(1, 1);
        player_left[2] = hero_SpriteSheet.crop_player(2, 1);

        player_right[0] = hero_SpriteSheet.crop_player(0, 3);
        player_right[1] = hero_SpriteSheet.crop_player(1, 3);
        player_right[2] = hero_SpriteSheet.crop_player(2, 3);


        monster_down = new BufferedImage[3];
        monster_up = new BufferedImage[3];
        monster_left = new BufferedImage[3];
        monster_right = new BufferedImage[3];
        monster_noAnim = new BufferedImage[1];

        monster_noAnim[0] = monster_SpriteSheet.crop_monster(0, 2);

        monster_down[0] = monster_SpriteSheet.crop_monster(0, 0);
        monster_down[1] = monster_SpriteSheet.crop_monster(1, 0);
        monster_down[2] = monster_SpriteSheet.crop_monster(2, 0);

        monster_up[0] = monster_SpriteSheet.crop_monster(0, 3);
        monster_up[1] = monster_SpriteSheet.crop_monster(1, 3);
        monster_up[2] = monster_SpriteSheet.crop_monster(2, 3);

        monster_left[0] = monster_SpriteSheet.crop_monster(0, 2);
        monster_left[1] = monster_SpriteSheet.crop_monster(1, 2);
        monster_left[2] = monster_SpriteSheet.crop_monster(2, 2);

        monster_right[0] = monster_SpriteSheet.crop_monster(0, 1);
        monster_right[1] = monster_SpriteSheet.crop_monster(1, 1);
        monster_right[2] = monster_SpriteSheet.crop_monster(2, 1);
    }
}

