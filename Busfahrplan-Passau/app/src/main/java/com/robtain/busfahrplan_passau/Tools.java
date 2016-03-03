package com.robtain.busfahrplan_passau;

import android.content.Intent;
import android.view.MenuItem;

import java.util.LinkedList;

/**
 * provides methodes to reduce code duplication or set general settings
 */
public class Tools {
    private String codeword;
    private BusStation busStation;

    /**
     * selects a class and set a keyword (keyword is a identifier for the
     * content of submenu
     * @param item navmenu
     * @return selected class
     */
        final public Class selectPath(MenuItem item){
            int id = item.getItemId();
            Intent i = null;

            switch (id) {
                case R.id.nav_1_2_Lindau_Kohlbruck:
                    codeword = "1_2";
                    return SubmenuActivity.class;
                case R.id.nav_1_Kohlbruck_Lindau:
                    codeword = "1";
                    return SubmenuActivity.class;
                case R.id.nav_2_Kohlbruck_Zieglreuth:
                    codeword = "2";
                    return SubmenuActivity.class;
                case R.id.nav_3_4_Baeckerholz_Hochstein_Achleiten:
                    codeword = "3_4";
                    return SubmenuActivity.class;
                case R.id.nav_3_Achleiten_Baeckerholz:
                    codeword = "3";
                    return SubmenuActivity.class;
                case R.id.nav_4_Achleiten_Hochstein:
                    codeword = "4";
                    return SubmenuActivity.class;
                case R.id.nav_5_6_Kohlbruck_Patriching:
                    codeword = "5_6_K_P";
                    return SubmenuActivity.class;
                case R.id.nav_5_6_Patriching_Kohlbruck:
                    codeword = "5_6_P_K";
                    return SubmenuActivity.class;
                case R.id.nav_7_Eichendorffstr_Ries:
                    codeword = "7_E_R";
                    return SubmenuActivity.class;
                case R.id.nav_7_Ries_Eichendorffstr:
                    codeword = "7_R_E";
                    return SubmenuActivity.class;
                case R.id.nav_8_9_Kohlbruck_Koenigschalding:
                    codeword = "8_9_Kohl_Koenig";
                    return SubmenuActivity.class;
                case R.id.nav_8_9_Koenigschalding_Kohlbruck:
                    codeword = "8_9_Koenig_Kohl";
                    return SubmenuActivity.class;
                case R.id.nav_10_ZOB_Schalding:
                    codeword = "10_Z_S";
                    return SubmenuActivity.class;
                case R.id.nav_10_Schalding_ZOB:
                    codeword = "10_S_Z";
                    return SubmenuActivity.class;
                case R.id.nav_11_ZOB_Senefelderstr:
                    codeword = "11_Z_S";
                    return SubmenuActivity.class;
                case R.id.nav_11_Senefelderstr_ZOB:
                    codeword = "11_S_Z";
                    return SubmenuActivity.class;
                case R.id.nav_K1_Lueftlberg_Mariahilf:
                    codeword = "K1_L_M";
                    return SubmenuActivity.class;
                case R.id.nav_K1_Mariahilf_Lueftlberg:
                    codeword = "K1_M_L";
                    return SubmenuActivity.class;
                case R.id.nav_K2_Sieglberg_Muehltal:
                    codeword = "K2_S_M";
                    return SubmenuActivity.class;
                case R.id.nav_K2_Muehltal_Sieglberg:
                    codeword = "K2_M_S";
                    return SubmenuActivity.class;
                case R.id.nav_K3_Klinikum_Hoegl:
                    codeword = "K3_K_H";
                    return SubmenuActivity.class;
                case R.id.nav_K3_Hoegl_Klinikum:
                    codeword = "K3_H_K";
                    return SubmenuActivity.class;
                case R.id.nav_K4_ZOB_Sperrwies:
                    codeword = "K4_Z_S";
                    return SubmenuActivity.class;
                case R.id.nav_K4_Sperrwies_ZOB:
                    codeword = "K4_S_Z";
                    return SubmenuActivity.class;
                case R.id.nav_78_ZOB_Schalding:
                    codeword = "78_Z_S";
                    return SubmenuActivity.class;
                case R.id.nav_78_Schalding_ZOB:
                    codeword = "78_S_Z";
                    return SubmenuActivity.class;
                case R.id.nav_79_ZOB_Eichendorffstr:
                    codeword = "79_Z_E";
                    return SubmenuActivity.class;
                case R.id.nav_79_Eichendorffstr_ZOB:
                    codeword = "79_E_Z";
                    return SubmenuActivity.class;
                case R.id.nav_CB_Bahnhofstr_Roemerplatz:
                    codeword = "CB_B_R";
                    return SubmenuActivity.class;
                case R.id.nav_CB_Roemerplatz_Bahnhofstr:
                    codeword = "CB_R_B";
                    return SubmenuActivity.class;
                default:
                    return StartActivity.class;
            }
        }

    /**
     * returns the selected keyword for the class
     * @return String keyword
     */
    public String getCodeword() {
        return codeword;
    }

    /**
     * transforms a keyword into a displayable title
     * @param s keyword
     * @return title
     */
    public String transformKeywordIntoTitle(String s) {
        String title = null;
            switch (s) {
                case "1_2":
                   title = "Linie 1/2: Lindau/Ziegelreuth - ZOB - " +
                           "Kohlbruck/Erlebnisbad PEB";
                    break;
                case "1":
                    title = "Linie 1: Kohlbruck/Erlebnisbad PEB - ZOB - Lindau";
                    break;
                case "2":
                    title = "Linie 2: Kohlbruck/Erlebnisbad PEB - ZOB - " +
                            "Zieglreuth";
                  break;
                case "3_4":
                    title = "Linie 3/4: Bäckerholz/Hochstein - ZOB - Achleiten";
                    break;
                case "3":
                    title = "Linie 3: Achleiten - ZOB - Bäckerholz";
                    break;
                case "4":
                    title = "Linie 4: Achleiten - ZOB - Hochstein";
                    break;
                case "5_6_K_P":
                    title = "Linie 5/6: Kohlbruck - ZOB - " +
                            "Patriching/Schalding" +
                            " " +
                            "l.d.D.";
                    break;
                case "5_6_P_K":
                    title = "Linie 5/6: Patriching/Schalding l.d.D. - ZOB - " +
                            "Kohlbruck";
                    break;
                case "7_E_R":
                    title = "Linie 7: Eichendorffstr. - ZOB - Ries";
                    break;
                case "7_R_E":
                    title = "Linie 7: Ries - ZOB - Eichendorffstr.";
                   break;
                case "8_9_Kohl_Koenig":
                    title = "Linie 8/9: Kohlbruck/Erlebnisbad PEB - ZOB - " +
                            "Königschalding";
                   break;
                case "8_9_Koenig_Kohl":
                    title = "Linie 8/9: Königschalding - ZOB - " +
                            "Kohlbruck/Erlebnisbad PEB";
                    break;
                case "10_Z_S":
                    title = "Linie 10: ZOB - Schalding r.d.D.";
                    break;
                case "10_S_Z":
                    title = "Linie 10: Schalding r.d.D. - ZOB";
                    break;
                case "11_Z_S":
                    title = "Linie 11: ZOB - Senefelderstr.";
                    break;
                case "11_S_Z":
                    title = "Linie 11: Senefelderstr. - ZOB";
                    break;
                case "K1_L_M":
                    title = "Linie K1: Lüftlberg - ZOB - " +
                            "Mariahilf-Grenzstation";
                    break;
                case "K1_M_L":
                    title = "Linie K1: Mariahilf-Grenzstation - ZOB - " +
                            "Lüftlberg";
                    break;
                case "K2_S_M":
                    title = "Linie K2: Sieglberg/Sieglgut - ZOB - " +
                            "Mühltal/Lindental";
                    break;
                case "K2_M_S":
                    title = "Linie K2: Mühltal/Lindental - ZOB - " +
                            "Sieglberg/Sieglgut";
                    break;
                case "K3_K_H":
                    title = "Linie K3: Klinikum - ZOB - Am Högl/Sulzsteg";
                    break;
                case "K3_H_K":
                    title = "Linie K3: Am Högl/Sulzsteg - ZOB - Klinikum";
                    break;
                case "K4_Z_S":
                    title = "Linie K4: ZOB - Sperrwies";
                    break;
                case "K4_S_Z":
                    title = "Linie K4: Sperrwies - ZOB";
                    break;
                case "78_Z_S":
                    title = "Linie 78: ZOB - Schalding r.d.D.";
                    break;
                case "78_S_Z":
                    title = "Linie 78: Schalding r.d.D. - ZOB";
                    break;
                case "79_Z_E":
                    title = "Linie 79: ZOB - Eichendorffstr.";
                    break;
                case "79_E_Z":
                    title = "Linie 79: Eichendorffstr. - ZOB";
                    break;
                case "CB_B_R":
                    title = "Citybus: Parkhaus Bahnhofstr. - ZOB - Römerplatz";
                    break;
                case "CB_R_B":
                    title = "Citybus: Römerplatz - ZOB - Parkhaus Bahnhofstr.";
                    break;
            }
        return title;
    }


    public LinkedList findBusLine(String s) {
        String title = null;
        LinkedList<BusStation> list = new LinkedList<>();
        switch (s) {
            case "1_2":
                busStation = new BusStation("Abteistr");
                list.add(busStation);
                busStation = new BusStation("Breiteich");
                list.add(busStation);
                busStation = new BusStation("Breslauer Straße");
                list.add(busStation);
                busStation = new BusStation("Christdobl");
                list.add(busStation);
                busStation = new BusStation("Dr. Emil-Brichta-Str.");
                list.add(busStation);
                busStation = new BusStation("Englmeierstraße");
                list.add(busStation);
                busStation = new BusStation("Firmiangut");
                list.add(busStation);
                busStation = new BusStation("Giselastraße");
                list.add(busStation);
                busStation = new BusStation("Am Hochpegel");
                list.add(busStation);
                busStation = new BusStation("Ilzbrücke");
                list.add(busStation);
                busStation = new BusStation("Josef-Wenzl-Str.");
                list.add(busStation);
                busStation = new BusStation("Kainzenweg");
                list.add(busStation);
                busStation = new BusStation("Kastenreuth");
                list.add(busStation);
                busStation = new BusStation("Laimgrub");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße");
                list.add(busStation);
                busStation = new BusStation("Lindau");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse");
                list.add(busStation);
                busStation = new BusStation("Prinz-Eugen-Straße");
                list.add(busStation);
                busStation = new BusStation("Rathaus");
                list.add(busStation);
                busStation = new BusStation("Römerplatz");
                list.add(busStation);
                busStation = new BusStation("Säumerweg");
                list.add(busStation);
                busStation = new BusStation("Scharbachweg");
                list.add(busStation);
                busStation = new BusStation("Schönleitnerweg");
                list.add(busStation);
                busStation = new BusStation("Schulzentrum / AOK");
                list.add(busStation);
                busStation = new BusStation("St. Anton");
                list.add(busStation);
                busStation = new BusStation("Sulzweg");
                list.add(busStation);
                busStation = new BusStation("Waldschmidtstraße");
                list.add(busStation);
                busStation = new BusStation("Wilhelm-Niedermayer-Str.");
                list.add(busStation);
                busStation = new BusStation("Zahnradfabrik / Werk 1");
                list.add(busStation);
                busStation = new BusStation("Zieglreuth");
                list.add(busStation);
                busStation = new BusStation("Schanzlbrücke");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 1 C");
                list.add(busStation);



                break;
            case "1":
                title = "Linie 1: Kohlbruck/Erlebnisbad PEB - ZOB - Lindau";
                break;
            case "2":
                title = "Linie 2: Kohlbruck/Erlebnisbad PEB - ZOB - " +
                        "Zieglreuth";
                break;
            case "3_4":
                title = "Linie 3/4: Bäckerholz/Hochstein - ZOB - Achleiten";
                break;
            case "3":
                title = "Linie 3: Achleiten - ZOB - Bäckerholz";
                break;
            case "4":
                title = "Linie 4: Achleiten - ZOB - Hochstein";
                break;
            case "5_6_K_P":
                title = "Linie 5/6: Kohlbruck - ZOB - " +
                        "Patriching/Schalding" +
                        " " +
                        "l.d.D.";
                break;
            case "5_6_P_K":
                title = "Linie 5/6: Patriching/Schalding l.d.D. - ZOB - " +
                        "Kohlbruck";
                break;
            case "7_E_R":
                title = "Linie 7: Eichendorffstr. - ZOB - Ries";
                break;
            case "7_R_E":
                title = "Linie 7: Ries - ZOB - Eichendorffstr.";
                break;
            case "8_9_Kohl_Koenig":
                title = "Linie 8/9: Kohlbruck/Erlebnisbad PEB - ZOB - " +
                        "Königschalding";
                break;
            case "8_9_Koenig_Kohl":
                title = "Linie 8/9: Königschalding - ZOB - " +
                        "Kohlbruck/Erlebnisbad PEB";
                break;
            case "10_Z_S":
                title = "Linie 10: ZOB - Schalding r.d.D.";
                break;
            case "10_S_Z":
                title = "Linie 10: Schalding r.d.D. - ZOB";
                break;
            case "11_Z_S":
                title = "Linie 11: ZOB - Senefelderstr.";
                break;
            case "11_S_Z":
                title = "Linie 11: Senefelderstr. - ZOB";
                break;
            case "K1_L_M":
                title = "Linie K1: Lüftlberg - ZOB - " +
                        "Mariahilf-Grenzstation";
                break;
            case "K1_M_L":
                title = "Linie K1: Mariahilf-Grenzstation - ZOB - " +
                        "Lüftlberg";
                break;
            case "K2_S_M":
                title = "Linie K2: Sieglberg/Sieglgut - ZOB - " +
                        "Mühltal/Lindental";
                break;
            case "K2_M_S":
                title = "Linie K2: Mühltal/Lindental - ZOB - " +
                        "Sieglberg/Sieglgut";
                break;
            case "K3_K_H":
                title = "Linie K3: Klinikum - ZOB - Am Högl/Sulzsteg";
                break;
            case "K3_H_K":
                title = "Linie K3: Am Högl/Sulzsteg - ZOB - Klinikum";
                break;
            case "K4_Z_S":
                title = "Linie K4: ZOB - Sperrwies";
                break;
            case "K4_S_Z":
                title = "Linie K4: Sperrwies - ZOB";
                break;
            case "78_Z_S":
                title = "Linie 78: ZOB - Schalding r.d.D.";
                break;
            case "78_S_Z":
                title = "Linie 78: Schalding r.d.D. - ZOB";
                break;
            case "79_Z_E":
                title = "Linie 79: ZOB - Eichendorffstr.";
                break;
            case "79_E_Z":
                title = "Linie 79: Eichendorffstr. - ZOB";
                break;
            case "CB_B_R":
                title = "Citybus: Parkhaus Bahnhofstr. - ZOB - Römerplatz";
                break;
            case "CB_R_B":
                title = "Citybus: Römerplatz - ZOB - Parkhaus Bahnhofstr.";
                break;
        }
        return list;
    }
}
