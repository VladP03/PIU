package PIUGame.Maps;

import PIUGame.Graphics.Assets;
import PIUGame.RefLinks;

import java.awt.*;

public class MapElements {

    private int index_level;
    private RefLinks refLink;

    public MapElements(RefLinks refLink,  int index_level){
        this.refLink = refLink;
        this.index_level = index_level;
    }

    public void Draw(Graphics g, int index_level){
        switch(index_level){
            case 1:

                // ground road vertical de la casa in jos
                for(int i=0; i<7; i++)
                {
                    g.drawImage(Assets.ground_path_vertical_image, (int) (190 - refLink.getGameCamera().getxOffset()), (int) (190 + i*70 - refLink.getGameCamera().getyOffset()), 50, 70, null);
                }
                // de la casa in stanga jos
                for(int i=0; i<7; i++)
                {
                    g.drawImage(Assets.ground_path_vertical_image, (int) (60 - refLink.getGameCamera().getxOffset()), (int) (500 + i*70 - refLink.getGameCamera().getyOffset()), 50, 70, null);
                }
                // de la casa in dreapta catre a doua casa
                for(int i=0; i<7; i++)
                {
                    g.drawImage(Assets.ground_path_vertical_image, (int) (770 - refLink.getGameCamera().getxOffset()), (int) (220 + i*70 - refLink.getGameCamera().getyOffset()), 50, 70, null);
                }

                // datre finalul jocului
                for(int i=0; i<7; i++)
                {
                    g.drawImage(Assets.ground_path_vertical_image, (int) (1600 - refLink.getGameCamera().getxOffset()), (int) (500 + i*70 - refLink.getGameCamera().getyOffset()), 50, 70, null);
                }

                // --------------------------------------------------------------

                // ground road orizontal de la casa la dreapta
                for(int i=0; i<11; i++)
                {
                    g.drawImage(Assets.ground_path_horizontal_image, (int) (230 + i*50 - refLink.getGameCamera().getxOffset()), (int) (310 - refLink.getGameCamera().getyOffset()), 50, 70, null);
                }
                //  cel care trece pe sub a doua casa
                for(int i=0; i<22; i++)
                {
                    g.drawImage(Assets.ground_path_horizontal_image, (int) (97 + i*50 - refLink.getGameCamera().getxOffset()), (int) (650 - refLink.getGameCamera().getyOffset()), 50, 70, null);
                }

                //  cel care duce catre nivelul urmator
                for(int i=0; i<7; i++)
                {
                    g.drawImage(Assets.ground_path_horizontal_image, (int) (1640 + i*50 - refLink.getGameCamera().getxOffset()), (int) (800 - refLink.getGameCamera().getyOffset()), 50, 70, null);
                }

                // house image
                g.drawImage(Assets.house_image, (int) (100 - refLink.getGameCamera().getxOffset()), (int) (40 - refLink.getGameCamera().getyOffset()), 170, 150, null);
                g.drawImage(Assets.house_type_2_image, (int) (500 - refLink.getGameCamera().getxOffset()), (int) (500 - refLink.getGameCamera().getyOffset()), 170, 150, null);
                g.drawImage(Assets.house_image, (int) (1500 - refLink.getGameCamera().getxOffset()), (int) (5 - refLink.getGameCamera().getyOffset()), 170, 150, null);


                // forest image
                g.drawImage(Assets.forest_image, (int) (280 - refLink.getGameCamera().getxOffset()), (int) (0 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (390 - refLink.getGameCamera().getxOffset()), (int) (90 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (-30 - refLink.getGameCamera().getxOffset()), (int) (130 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (0 - refLink.getGameCamera().getxOffset()), (int) (300 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (480 - refLink.getGameCamera().getxOffset()), (int) (-30 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (700 - refLink.getGameCamera().getxOffset()), (int) (130 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (-20 - refLink.getGameCamera().getxOffset()), (int) (400 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (330 - refLink.getGameCamera().getxOffset()), (int) (420 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (240 - refLink.getGameCamera().getxOffset()), (int) (360 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (550 - refLink.getGameCamera().getxOffset()), (int) (330 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (170 - refLink.getGameCamera().getxOffset()), (int) (690 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (680 - refLink.getGameCamera().getxOffset()), (int) (-100 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (800 - refLink.getGameCamera().getxOffset()), (int) (-95 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (990 - refLink.getGameCamera().getxOffset()), (int) (-20 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (840 - refLink.getGameCamera().getxOffset()), (int) (280 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (820 - refLink.getGameCamera().getxOffset()), (int) (430 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (800 - refLink.getGameCamera().getxOffset()), (int) (750 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (650 - refLink.getGameCamera().getxOffset()), (int) (800 - refLink.getGameCamera().getyOffset()), 200, 180, null);g.drawImage(Assets.forest_image, (int) (170 - refLink.getGameCamera().getxOffset()), (int) (690 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (1100 - refLink.getGameCamera().getxOffset()), (int) (590 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (1270 - refLink.getGameCamera().getxOffset()), (int) (490 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (1470 - refLink.getGameCamera().getxOffset()), (int) (410 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (1370 - refLink.getGameCamera().getxOffset()), (int) (290 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (1870 - refLink.getGameCamera().getxOffset()), (int) (490 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (1570 - refLink.getGameCamera().getxOffset()), (int) (390 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (1370 - refLink.getGameCamera().getxOffset()), (int) (10 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (1650 - refLink.getGameCamera().getxOffset()), (int) (30 - refLink.getGameCamera().getyOffset()), 200, 180, null);
                g.drawImage(Assets.forest_image, (int) (1770 - refLink.getGameCamera().getxOffset()), (int) (60 - refLink.getGameCamera().getyOffset()), 200, 180, null);
//                g.drawImage(Assets.forest_image, (int) (170 - refLink.getGameCamera().getxOffset()), (int) (690 - refLink.getGameCamera().getyOffset()), 200, 180, null);
//                g.drawImage(Assets.forest_image, (int) (170 - refLink.getGameCamera().getxOffset()), (int) (690 - refLink.getGameCamera().getyOffset()), 200, 180, null);

                // apa
                g.drawImage(Assets.water_type_1_image, (int) (350 - refLink.getGameCamera().getxOffset()), (int) (730 - refLink.getGameCamera().getyOffset()), 200, 100, null);
                g.drawImage(Assets.water_type_1_image, (int) (1300 - refLink.getGameCamera().getxOffset()), (int) (690 - refLink.getGameCamera().getyOffset()), 200, 100, null);
                g.drawImage(Assets.water_type_1_image, (int) (1180 - refLink.getGameCamera().getxOffset()), (int) (10 - refLink.getGameCamera().getyOffset()), 200, 100, null);
//                g.drawImage(Assets.water_type_1_image, (int) (350 - refLink.getGameCamera().getxOffset()), (int) (730 - refLink.getGameCamera().getyOffset()), 200, 100, null);



                for(int i=0; i<10; i++) {
                    //g.drawImage(Assets.tree_type_1_image, (int) (i *50 - refLink.getGameCamera().getxOffset()), (int) (200 - refLink.getGameCamera().getyOffset()), 50, 70, null);
                }

                for(int i=0; i<10; i++) {
                    //g.drawImage(Assets.tree_type_1_image, (int) (200 - refLink.getGameCamera().getxOffset()), (int) (i*70 - refLink.getGameCamera().getyOffset()), 50, 70, null);
                }



//                g.drawImage(Assets.tree_image, (int)(10 - refLink.getGameCamera().getxOffset()),(int)(10 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(50 - refLink.getGameCamera().getxOffset()),(int)(20 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(100 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(150 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(200 - refLink.getGameCamera().getxOffset()),(int)(100 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(250 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(300 - refLink.getGameCamera().getxOffset()),(int)(80 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(350 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(450 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(500 - refLink.getGameCamera().getxOffset()),(int)(100 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.tree_image, (int)(550 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
//                g.drawImage(Assets.arrow_image, (int)(1790 - refLink.getGameCamera().getxOffset()),(int)(850 - refLink.getGameCamera().getyOffset()),60,50, null);
                break;
            case 2:
                g.drawImage(Assets.map_level_2_image, (int)(0 - refLink.getGameCamera().getxOffset()),(int)(0 - refLink.getGameCamera().getyOffset()),2*1488, 2*1872, null);
                break;
            case 3:
                break;
            default:
                System.out.println("level not found");
        }

    }

}
