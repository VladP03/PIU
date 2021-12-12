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
    public static BufferedImage grass_tile_image;
    public static BufferedImage tree_type_1_image;
    public static BufferedImage tree_type_2_image;
    public static BufferedImage ground_path_horizontal_image;
    public static BufferedImage ground_path_vertical_image;
    public static BufferedImage forest_image;
    public static BufferedImage house_type_1_image;
    public static BufferedImage house_type_2_image;
    public static BufferedImage water_type_1_image;
    public static BufferedImage map_level_2_image;
    public static BufferedImage finish_zone_level_1_image;
    public static BufferedImage finish_zone_level_2_image;
    public static BufferedImage heart_life_image;

    // Sword
    public static BufferedImage sword_up_image;
    public static BufferedImage sword_down_image;
    public static BufferedImage sword_right_image;
    public static BufferedImage sword_left_image;

    // Explosion
    public static BufferedImage[] explosion_effect_image;


    // Buttons
    public static BufferedImage start_button_image;
    public static BufferedImage continue_button_image;
    public static BufferedImage settings_button_image;
    public static BufferedImage score_button_image;
    public static BufferedImage about_button_image;
    public static BufferedImage main_menu_button_image;
    public static BufferedImage exit_button_image;
    public static BufferedImage new_game_button_image;
    public static BufferedImage back_to_menu_button_image;
    public static BufferedImage easy_button_image;                      // used to set level difficulty in settingState
    public static BufferedImage medium_button_image;                    // used to set level difficulty in settingState
    public static BufferedImage hard_button_image;                      // used to set level difficulty in settingState
    public static BufferedImage menu_button_image;                      // the button from playState which is used for resume menu


    // Backgrounds image
    public static BufferedImage menu_background_image;
    public static BufferedImage resume_background_image;
    public static BufferedImage setting_background_image;
    public static BufferedImage lose_background_image;
    public static BufferedImage win_background_image;


    // Objects
    public static BufferedImage stone_image;




    /*
        \brief Functia initializaza referintele catre elementele grafice utilizate.
        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader

        // SpriteSheet-uri pentru caractere
        SpriteSheet hero_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Character/Hero.png"));
        SpriteSheet monster_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Monster/Monster.png"));


        // SpriteSheet-uri pentru dale mapa (dale)
        SpriteSheet grass_tile_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/grass_tile.png"));


        // SpriteSheet-uri pentru dale mapa (imagini)
        SpriteSheet tree_type_1_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/tree_type_1.png"));
        SpriteSheet tree_type_2_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/tree_type_2.png"));
        SpriteSheet ground_path_horizontal_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/ground_path_horizontal.png"));
        SpriteSheet ground_path_vertical_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/ground_path_vertical.png"));
        SpriteSheet forest_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/forest_2gg.png"));
        SpriteSheet house_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/house_1g.png"));
        SpriteSheet house_type_2_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/house_2g.png"));
        SpriteSheet water_type_1_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/water.png"));


        // Sword
        SpriteSheet sword_up_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Effects/sword_up.png"));
        SpriteSheet sword_down_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Effects/sword_down.png"));
        SpriteSheet sword_right_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Effects/sword_right.png"));
        SpriteSheet sword_left_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Effects/sword_left.png"));


        // Explosion effect
        SpriteSheet explosion_effect_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Effects/explosion.png"));


        // Harta
        SpriteSheet map_level_2_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Maps/map_level_2.png"));


        // Buttons
        SpriteSheet start_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/start_button.png"));
        SpriteSheet settings_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/settings_button.png"));
        SpriteSheet about_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/about_button.png"));
        SpriteSheet score_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/score_button.png"));
        SpriteSheet exit_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/exit_button.png"));
        SpriteSheet new_game_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/new_game_button.png"));
        SpriteSheet continue_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/continue_button.png"));
        SpriteSheet main_menu_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/main_menu_button.png"));
        SpriteSheet back_to_menu_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/back_to_menu_button.png"));
        SpriteSheet easy_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/easy_button.png"));
        SpriteSheet medium_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/medium_button.png"));
        SpriteSheet hard_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/hard_button.png"));
        SpriteSheet menu_button_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Buttons/menu-button.png"));

        // SpriteSheet pentru obiectele care le colecteaza player-ul
        SpriteSheet diamond_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/Diamond.png"));


        // SpriteSheet pentru indicarea nivelului urmator
        SpriteSheet finish_zone_level_1_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/finish_zone_level_1.png"));
        SpriteSheet finish_zone_level_2_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/finish_zone_level_2.png"));


        // SpriteSheet pentru viata
        SpriteSheet heart_life_SpriteSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Resources/heart_life.png"));


        // SpriteSheet background
        SpriteSheet menu_background_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Background/menu_background.jpg"));
        SpriteSheet resume_background_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Background/resume_background.jpg"));
        SpriteSheet setting_background_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Background/setting_background.png"));
        SpriteSheet lose_background_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Background/lose_background.jpg"));
        SpriteSheet win_background_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Background/win_background.jpg"));


        // ------------------------------------------------------------------------------------------------------------------------


        // Imagine pentru Tiles
        grass_tile_image = grass_tile_SpriteSheet.crop_precise(0,0, 63, 60);


        /// Se obtin subimaginile corespunzatoare elementelor necesare pentru harta 1
        tree_type_1_image = tree_type_1_SpriteSheet.crop_precise(0,0, 800, 1000);
        tree_type_2_image = tree_type_2_SpriteSheet.crop_precise(0,0, 310, 520);
        ground_path_horizontal_image = ground_path_horizontal_SpriteSheet.crop_precise(0,0, 150, 178);
        ground_path_vertical_image = ground_path_vertical_SpriteSheet.crop_precise(0,0, 178, 150);
        forest_image = forest_SpriteSheet.crop_precise(0,0, 780, 670);
        house_type_1_image = house_SpriteSheet.crop_precise(0,0, 490, 550);
        house_type_2_image = house_type_2_SpriteSheet.crop_precise(0,0, 725, 570);
        water_type_1_image = water_type_1_SpriteSheet.crop_precise(0,0, 565, 260);


        // Sword
        sword_up_image = sword_up_SpriteSheet.crop_precise(0,0, 67, 300);
        sword_down_image = sword_down_SpriteSheet.crop_precise(0,0, 67, 300);
        sword_right_image = sword_right_SpriteSheet.crop_precise(0,0, 300, 60);
        sword_left_image = sword_left_SpriteSheet.crop_precise(0,0, 300, 60);


        // Harta
        map_level_2_image = map_level_2_SpriteSheet.crop_precise(0,0, 1488, 1872);


        // Buttons
        start_button_image = start_button_SpriteSheet.crop_precise(0,0, 336, 85);
        settings_button_image = settings_button_SpriteSheet.crop_precise(0,0, 336, 85);
        about_button_image = about_button_SpriteSheet.crop_precise(0,0, 336, 85);
        score_button_image = score_button_SpriteSheet.crop_precise(0,0, 336, 85);
        exit_button_image = exit_button_SpriteSheet.crop_precise(0,0, 336, 85);
        new_game_button_image = new_game_button_SpriteSheet.crop_precise(0,0, 336, 85);
        continue_button_image = continue_button_SpriteSheet.crop_precise(0,0, 336, 85);
        main_menu_button_image = main_menu_button_SpriteSheet.crop_precise(0,0, 336, 85);
        back_to_menu_button_image = back_to_menu_button_SpriteSheet.crop_precise(0,0, 336, 85);
        easy_button_image = easy_button_SpriteSheet.crop_precise(0,0, 336, 85);
        medium_button_image = medium_button_SpriteSheet.crop_precise(0,0, 336, 85);
        hard_button_image = hard_button_SpriteSheet.crop_precise(0,0, 336, 85);
        menu_button_image = menu_button_SpriteSheet.crop_precise(0,0, 460, 160);


        // Obiectele ce le va culege player-ul
        stone_image = diamond_SpriteSheet.crop_precise(0, 0, 1300, 1300);


        // Imagini pentru indicarea nivelului urmator
        finish_zone_level_1_image = finish_zone_level_1_SpriteSheet.crop_precise(0,0, 124, 162);
        finish_zone_level_2_image = finish_zone_level_2_SpriteSheet.crop_precise(0,0, 50, 50);


        // Imagini pentru viata
        heart_life_image = heart_life_SpriteSheet.crop_precise(0,0, 635, 355);


        // Background image
        menu_background_image = menu_background_sheet.crop_precise(0, 0, 1920, 1080);
        resume_background_image = resume_background_sheet.crop_precise(0, 0, 1920, 1080);
        setting_background_image = setting_background_sheet.crop_precise(0, 0, 4000, 2250);
        lose_background_image = lose_background_sheet.crop_precise(0, 0, 2880, 1800);
        win_background_image = win_background_sheet.crop_precise(0, 0, 3440, 1920);



        initHeroSpriteSheet(hero_SpriteSheet);
        initMonsterSpriteSheet(monster_SpriteSheet);
        initExplosionEffectSpriteSheet(explosion_effect_SpriteSheet);
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


    private static void initExplosionEffectSpriteSheet(SpriteSheet explosion_effect_SpriteSheet) {
        explosion_effect_image = new BufferedImage[28];

        explosion_effect_image[0] = explosion_effect_SpriteSheet.crop_explosion(0, 0);
        explosion_effect_image[1] = explosion_effect_SpriteSheet.crop_explosion(1, 0);
        explosion_effect_image[2] = explosion_effect_SpriteSheet.crop_explosion(2, 0);
        explosion_effect_image[3] = explosion_effect_SpriteSheet.crop_explosion(3, 0);
        explosion_effect_image[4] = explosion_effect_SpriteSheet.crop_explosion(4, 0);
        explosion_effect_image[5] = explosion_effect_SpriteSheet.crop_explosion(5, 0);
        explosion_effect_image[6] = explosion_effect_SpriteSheet.crop_explosion(6, 0);
        explosion_effect_image[7] = explosion_effect_SpriteSheet.crop_explosion(7, 0);
        explosion_effect_image[8] = explosion_effect_SpriteSheet.crop_explosion(8, 0);
        explosion_effect_image[9] = explosion_effect_SpriteSheet.crop_explosion(9, 0);
        explosion_effect_image[10] = explosion_effect_SpriteSheet.crop_explosion(10, 0);
        explosion_effect_image[11] = explosion_effect_SpriteSheet.crop_explosion(11, 0);
        explosion_effect_image[12] = explosion_effect_SpriteSheet.crop_explosion(12, 0);
        explosion_effect_image[13] = explosion_effect_SpriteSheet.crop_explosion(13, 0);
        explosion_effect_image[14] = explosion_effect_SpriteSheet.crop_explosion(14, 0);
        explosion_effect_image[15] = explosion_effect_SpriteSheet.crop_explosion(15, 0);
        explosion_effect_image[16] = explosion_effect_SpriteSheet.crop_explosion(16, 0);
        explosion_effect_image[17] = explosion_effect_SpriteSheet.crop_explosion(17, 0);
        explosion_effect_image[18] = explosion_effect_SpriteSheet.crop_explosion(18, 0);
        explosion_effect_image[19] = explosion_effect_SpriteSheet.crop_explosion(19, 0);
        explosion_effect_image[20] = explosion_effect_SpriteSheet.crop_explosion(20, 0);
        explosion_effect_image[21] = explosion_effect_SpriteSheet.crop_explosion(21, 0);
        explosion_effect_image[22] = explosion_effect_SpriteSheet.crop_explosion(22, 0);
        explosion_effect_image[23] = explosion_effect_SpriteSheet.crop_explosion(23, 0);
        explosion_effect_image[24] = explosion_effect_SpriteSheet.crop_explosion(24, 0);
        explosion_effect_image[25] = explosion_effect_SpriteSheet.crop_explosion(25, 0);
        explosion_effect_image[26] = explosion_effect_SpriteSheet.crop_explosion(26, 0);
        explosion_effect_image[27] = explosion_effect_SpriteSheet.crop_explosion(27, 0);
    }


}