package PIUGame.Graphics;

import java.awt.image.BufferedImage;

public class Assets {
    // Hero
    public static BufferedImage[] hero_up;
    public static BufferedImage[] hero_down;
    public static BufferedImage[] hero_left;
    public static BufferedImage[] hero_right;
    public static BufferedImage[] hero_noAnimation;

    // Monster
    public static BufferedImage[] monster_up;
    public static BufferedImage[] monster_down;
    public static BufferedImage[] monster_left;
    public static BufferedImage[] monster_right;
    public static BufferedImage[] monster_noAnimation;

    // Resources
    public static BufferedImage grass_image;
    public static BufferedImage tree_type_1_image;
    public static BufferedImage tree_type_2_image;
    public static BufferedImage ground_path_horizontal_image;
    public static BufferedImage ground_path_vertical_image;
    public static BufferedImage forest_image;
    public static BufferedImage house_image;
    public static BufferedImage house_type_2_image;
    public static BufferedImage water_type_1_image;
    public static BufferedImage map_level_2_image;





    public static BufferedImage bush_image;
    public static BufferedImage wall_1_image;
    public static BufferedImage wall_2_image;

    public static BufferedImage soil;
    public static BufferedImage mountain;
    public static BufferedImage townGrass;
    public static BufferedImage townGrassDestroyed;
    public static BufferedImage townSoil;
    public static BufferedImage water;
    public static BufferedImage water_image;

    public static BufferedImage buttonStart_image;
    public static BufferedImage buttonExit_image;
    public static BufferedImage life_image;
    public static BufferedImage stone_image;
    public static BufferedImage arrow_image;
    public static BufferedImage background_image;

    /*
        \brief Functia initializaza referintele catre elementele grafice utilizate.
        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet resources_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));

        // SpriteSheet-uri pentru caractere
        SpriteSheet hero_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Character/Hero.png"));
        SpriteSheet monster_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Monster/Monster.png"));

        // SpriteSheet-uri pentru dale mapa
        SpriteSheet grass_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/grass.png"));
        SpriteSheet tree_type_1_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/tree_type_1.png"));
        SpriteSheet tree_type_2_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/tree_type_2.png"));
        SpriteSheet ground_path_horizontal_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/ground_path_horizontal.png"));
        SpriteSheet ground_path_vertical_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/ground_path_vertical.png"));
        SpriteSheet forest_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/forest_2gg.png"));
        SpriteSheet house_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/house_1g.png"));
        SpriteSheet house_type_2_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/house_2g.png"));
        SpriteSheet water_type_1_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/water.png"));

        SpriteSheet map_level_2_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Maps/map_level_2.png"));

        //SpriteSheet bush_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/Bush.jpg"));

        SpriteSheet wall_1_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/Wall1.png"));
        SpriteSheet wall_2_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/Wall2.png"));
        SpriteSheet water_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/Water.png"));

        SpriteSheet diamond_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Diamond.png"));

        // SpriteSheet pentru indicarea nivelului urmator
        SpriteSheet arrow_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Arrow.png"));

        // SpriteSheet pentru viata
        SpriteSheet life_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Life.png"));

        // SpriteSheet start & exit
        SpriteSheet buttonStart_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Start&Exit/StartButton.png"));
        SpriteSheet buttonExit_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Start&Exit/ExitButton.png"));

        //SpriteSheet ground_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tiles/Resources/grass_2.png"));
//        grass_image = ground_sheet.crop_precise(0,0, 310, 520);
        //grass_image = ground_sheet.crop_precise(0,0, 63, 60);
//        grass_image = ground_sheet.crop_precise(0,0, 317, 178);

        // SpriteSheet background
        SpriteSheet background_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Background/BackgroundImage.jpg"));
        background_image = background_sheet.crop_precise(0, 0, 1350, 770);

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        water_image = water_SpriteSheet.crop_precise(0, 0, 400, 350);
        stone_image = diamond_SpriteSheet.crop_precise(0, 0, 1300, 1300);
        tree_type_1_image = tree_type_1_SpriteSheet.crop_precise(0,0, 800, 1000);
        tree_type_2_image = tree_type_2_SpriteSheet.crop_precise(0,0, 310, 520);
        ground_path_horizontal_image = ground_path_horizontal_SpriteSheet.crop_precise(0,0, 150, 178);
        ground_path_vertical_image = ground_path_vertical_SpriteSheet.crop_precise(0,0, 178, 150);
        //forest_image = forest_SpriteSheet.crop_precise(0,0, 350, 280);
        forest_image = forest_SpriteSheet.crop_precise(0,0, 780, 670);
        house_image = house_SpriteSheet.crop_precise(0,0, 490, 550);
        house_type_2_image = house_type_2_SpriteSheet.crop_precise(0,0, 725, 570);
        water_type_1_image = water_type_1_SpriteSheet.crop_precise(0,0, 565, 260);

        map_level_2_image = map_level_2_SpriteSheet.crop_precise(0,0, 760, 1040);


        //tree_image = bush_SpriteSheet.crop_precise(0,0, 500, 305);
        wall_1_image = wall_1_SpriteSheet.crop(0, 0);
        wall_2_image = wall_2_SpriteSheet.crop_precise(0, 0, 60, 56);

        arrow_image = arrow_SpriteSheet.crop_precise(0, 0, 600, 450);
        life_image = life_SpriteSheet.crop_precise(0, 0, 540, 530);

        // start / exit button
        buttonStart_image = buttonStart_SpriteSheet.crop_precise(0, 0, 200, 80);
        buttonExit_image = buttonExit_SpriteSheet.crop_precise(0, 0, 200, 80);

        // Resources
        grass_image = grass_SpriteSheet.crop_precise(0,0, 63, 60);

        //bush_image = bush_SpriteSheet.crop_precise(0,0, 500, 305);


        initResourcesSpriteSheet(resources_SpriteSheet);
        initHeroSpriteSheet(hero_SpriteSheet);
        initMonsterSpriteSheet(monster_SpriteSheet);
    }

    private static void initResourcesSpriteSheet(SpriteSheet resourcesSpriteSheet) {
        soil = resourcesSpriteSheet.crop(1, 0);
        water = resourcesSpriteSheet.crop(2, 0);
        mountain = resourcesSpriteSheet.crop(3, 0);
        townGrass = resourcesSpriteSheet.crop(0, 1);
        townGrassDestroyed = resourcesSpriteSheet.crop(1, 1);
        townSoil = resourcesSpriteSheet.crop(2, 1);
    }

    private static void initHeroSpriteSheet(SpriteSheet heroSpriteSheet) {
        hero_up = new BufferedImage[3];
        hero_down = new BufferedImage[3];
        hero_left = new BufferedImage[3];
        hero_right = new BufferedImage[3];
        hero_noAnimation = new BufferedImage[1];

        hero_noAnimation[0] = heroSpriteSheet.crop_player(0, 2);

        hero_down[0] = heroSpriteSheet.crop_player(0, 2);
        hero_down[1] = heroSpriteSheet.crop_player(1, 2);
        hero_down[2] = heroSpriteSheet.crop_player(2, 2);

        hero_up[0] = heroSpriteSheet.crop_player(0, 0);
        hero_up[1] = heroSpriteSheet.crop_player(1, 0);
        hero_up[2] = heroSpriteSheet.crop_player(2, 0);

        hero_left[0] = heroSpriteSheet.crop_player(0, 1);
        hero_left[1] = heroSpriteSheet.crop_player(1, 1);
        hero_left[2] = heroSpriteSheet.crop_player(2, 1);

        hero_right[0] = heroSpriteSheet.crop_player(0, 3);
        hero_right[1] = heroSpriteSheet.crop_player(1, 3);
        hero_right[2] = heroSpriteSheet.crop_player(2, 3);
    }

    private static void initMonsterSpriteSheet(SpriteSheet monsterSpriteSheet) {
        monster_up = new BufferedImage[3];
        monster_down = new BufferedImage[3];
        monster_left = new BufferedImage[3];
        monster_right = new BufferedImage[3];
        monster_noAnimation = new BufferedImage[1];

        monster_noAnimation[0] = monsterSpriteSheet.crop_monster(0, 2);

        monster_down[0] = monsterSpriteSheet.crop_monster(0, 0);
        monster_down[1] = monsterSpriteSheet.crop_monster(1, 0);
        monster_down[2] = monsterSpriteSheet.crop_monster(2, 0);

        monster_up[0] = monsterSpriteSheet.crop_monster(0, 3);
        monster_up[1] = monsterSpriteSheet.crop_monster(1, 3);
        monster_up[2] = monsterSpriteSheet.crop_monster(2, 3);

        monster_left[0] = monsterSpriteSheet.crop_monster(0, 2);
        monster_left[1] = monsterSpriteSheet.crop_monster(1, 2);
        monster_left[2] = monsterSpriteSheet.crop_monster(2, 2);

        monster_right[0] = monsterSpriteSheet.crop_monster(0, 1);
        monster_right[1] = monsterSpriteSheet.crop_monster(1, 1);
        monster_right[2] = monsterSpriteSheet.crop_monster(2, 1);
    }
}