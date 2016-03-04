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
        LinkedList<BusStation> list = new LinkedList<>();
        switch (s) {
            case "1_2":
                busStation = new BusStation("Abteistraße", "1_2", "1");
                list.add(busStation);
                busStation = new BusStation("Breiteich", "1_2", "2");
                list.add(busStation);
                busStation = new BusStation("Breslauer Straße", "1_2", "3");
                list.add(busStation);
                busStation = new BusStation("Christdobl", "1_2", "4");
                list.add(busStation);
                busStation = new BusStation("Dr. Emil-Brichta Straße", "1_2",
                        "5");
                list.add(busStation);
                busStation = new BusStation("Englmeierstraße", "1_2", "6");
                list.add(busStation);
                busStation = new BusStation("Firmiangut", "1_2", "7");
                list.add(busStation);
                busStation = new BusStation("Giselastraße", "1_2", "8");
                list.add(busStation);
                busStation = new BusStation("Am Hochpegel", "1_2", "9");
                list.add(busStation);
                busStation = new BusStation("Ilzbrücke", "1_2", "10");
                list.add(busStation);
                busStation = new BusStation("Josef-Wenzl Straße", "1_2", "11");
                list.add(busStation);
                busStation = new BusStation("Kainzenweg", "1_2", "12");
                list.add(busStation);
                busStation = new BusStation("Kastenreuth", "1_2", "13");
                list.add(busStation);
                busStation = new BusStation("Laimgrub", "1_2", "14");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße", "1_2", "15");
                list.add(busStation);
                busStation = new BusStation("Lindau", "1_2", "16");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "1_2", "17");
                list.add(busStation);
                busStation = new BusStation("Prinz-Eugen Straße", "1_2", "18");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "1_2", "19");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "1_2", "20");
                list.add(busStation);
                busStation = new BusStation("Säumerweg", "1_2", "21");
                list.add(busStation);
                busStation = new BusStation("Scharbachweg", "1_2", "22");
                list.add(busStation);
                busStation = new BusStation("Schönleitnerweg", "1_2", "23");
                list.add(busStation);
                busStation = new BusStation("Schulzentrum / AOK", "1_2", "24");
                list.add(busStation);
                busStation = new BusStation("St. Anton", "1_2", "25");
                list.add(busStation);
                busStation = new BusStation("Sulzsteg", "1_2", "26");
                list.add(busStation);
                busStation = new BusStation("Waldschmidtstraße", "1_2", "27");
                list.add(busStation);
                busStation = new BusStation("Wilhelm-Niedermayer Straße",
                        "1_2", "28");
                list.add(busStation);
                busStation = new BusStation("Zahnradfabrik / Werk 1", "1_2",
                        "29");
                list.add(busStation);
                busStation = new BusStation("Zieglreuth", "1_2", "30");
                list.add(busStation);
                busStation = new BusStation("Schanzlbrücke", "1_2", "31");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 1 C", "1_2", "32");
                list.add(busStation);
                break;
            case "1":
                busStation = new BusStation("Abteistraße", "1", "1");
                list.add(busStation);
                busStation = new BusStation("Breslauer Straße","1", "2");
                list.add(busStation);
                busStation = new BusStation("Christdobl","1", "3");
                list.add(busStation);
                busStation = new BusStation("Dr. Emil-Brichta Straße","1",
                        "4");
                list.add(busStation);
                busStation = new BusStation("Englmeierstraße","1", "5");
                list.add(busStation);
                busStation = new BusStation("Firmiangut","1", "6");
                list.add(busStation);
                busStation = new BusStation("Giselastraße","1", "7");
                list.add(busStation);
                busStation = new BusStation("Am Hochpegel","1", "8");
                list.add(busStation);
                busStation = new BusStation("Ilzbrücke","1", "9");
                list.add(busStation);
                busStation = new BusStation("Josef-Wenzl Straße","1", "10");
                list.add(busStation);
                busStation = new BusStation("Kainzenweg","1", "11");
                list.add(busStation);
                busStation = new BusStation("Kohlbruck / Erlebnisbad PEB",
                        "1", "12");
                list.add(busStation);
                busStation = new BusStation("Laimgrub","1", "13");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße","1", "14");
                list.add(busStation);
                busStation = new BusStation("Lindau","1", "15");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse","1", "16");
                list.add(busStation);
                busStation = new BusStation("Prinz-Eugen Straße","1", "17");
                list.add(busStation);
                busStation = new BusStation("Rathaus","1", "18");
                list.add(busStation);
                busStation = new BusStation("Römerplatz","1", "19");
                list.add(busStation);
                busStation = new BusStation("Schönleitnerweg","1", "20");
                list.add(busStation);
                busStation = new BusStation("Schulzentrum / AOK","1", "21");
                list.add(busStation);
                busStation = new BusStation("St. Anton","1", "22");
                list.add(busStation);
                busStation = new BusStation("Waldschmidtstraße","1", "23");
                list.add(busStation);
                busStation = new BusStation("Schanzlturm","1", "24");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 1 A B","1", "25");
                list.add(busStation);
                break;
            case "2":
                busStation = new BusStation("Breiteich", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Breslauer Straße", "2", "2");
                list.add(busStation);
                busStation = new BusStation("Christdobl", "2", "3");
                list.add(busStation);
                busStation = new BusStation("Dr. Emil-Brichta Straße", "2",
                        "4");
                list.add(busStation);
                busStation = new BusStation("Englmeierstraße", "2", "5");
                list.add(busStation);
                busStation = new BusStation("Giselastraße", "2", "6");
                list.add(busStation);
                busStation = new BusStation("Am Hochpegel", "2", "7");
                list.add(busStation);
                busStation = new BusStation("Ilzbrücke", "2", "8");
                list.add(busStation);
                busStation = new BusStation("Josef-Wenzl Straße", "2", "9");
                list.add(busStation);
                busStation = new BusStation("Kainzenweg", "2", "10");
                list.add(busStation);
                busStation = new BusStation("Kastenreuth", "2", "11");
                list.add(busStation);
                busStation = new BusStation("Kohlbruck / Erlebnisbad PEB",
                        "2", "12");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße", "2", "13");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "2", "14");
                list.add(busStation);
                busStation = new BusStation("Prinz-Eugen Straße", "2", "15");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "2", "16");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "2", "17");
                list.add(busStation);
                busStation = new BusStation("Säumerweg", "2", "18");
                list.add(busStation);
                busStation = new BusStation("Schanzlturm", "2", "19");
                list.add(busStation);
                busStation = new BusStation("Scharbachweg", "2", "20");
                list.add(busStation);
                busStation = new BusStation("Schönleitnerweg", "2", "21");
                list.add(busStation);
                busStation = new BusStation("Schulzentrum / AOK", "2", "22");
                list.add(busStation);
                busStation = new BusStation("St. Anton", "2", "23");
                list.add(busStation);
                busStation = new BusStation("Sulzsteg", "2", "24");
                list.add(busStation);
                busStation = new BusStation("Waldschmidtstraße", "2", "25");
                list.add(busStation);
                busStation = new BusStation("Wilhelm-Niedermayer Straße",
                        "2", "26");
                list.add(busStation);

                busStation = new BusStation("ZOB Bussteig 1 A B", "2", "27");
                list.add(busStation);
                break;
            case "3_4":
                busStation = new BusStation("Achatiusstraße", "3_4", "1");
                list.add(busStation);
                busStation = new BusStation("Auenweg", "3_4", "2");
                list.add(busStation);
                busStation = new BusStation("Aufischer", "3_4", "3");
                list.add(busStation);
                busStation = new BusStation("Augustinergasse", "3_4", "4");
                list.add(busStation);
                busStation = new BusStation("Bäckerholz", "3_4", "5");
                list.add(busStation);
                busStation = new BusStation("Christdobl", "3_4", "6");
                list.add(busStation);
                busStation = new BusStation("Evangelische Kirche", "3_4", "7");
                list.add(busStation);
                busStation = new BusStation("Garhammerweg", "3_4", "8");
                list.add(busStation);
                busStation = new BusStation("Haibach", "3_4", "9");
                list.add(busStation);
                busStation = new BusStation("Hals", "3_4", "10");
                list.add(busStation);
                busStation = new BusStation("Hochstein", "3_4", "11");
                list.add(busStation);
                busStation = new BusStation("Hörnerweg", "3_4", "12");
                list.add(busStation);
                busStation = new BusStation("Ilzbrücke", "3_4", "13");
                list.add(busStation);
                busStation = new BusStation("Ilzleite", "3_4", "14");
                list.add(busStation);
                busStation = new BusStation("Jägersteig", "3_4", "15");
                list.add(busStation);
                busStation = new BusStation("Jahnstraße", "3_4", "16");
                list.add(busStation);
                busStation = new BusStation("Jesuitenschlößl", "3_4", "17");
                list.add(busStation);
                busStation = new BusStation("Johann-Bergler Straße", "3_4",
                        "18");
                list.add(busStation);
                busStation = new BusStation("Kirchenplatz", "3_4", "19");
                list.add(busStation);
                busStation = new BusStation("Kremserstraße", "3_4", "20");
                list.add(busStation);
                busStation = new BusStation("Landrichterstraße", "3_4", "21");
                list.add(busStation);
                busStation = new BusStation("Lindau", "3_4", "22");
                list.add(busStation);
                busStation = new BusStation("Mühltalstraße", "3_4", "23");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "3_4", "24");
                list.add(busStation);
                busStation = new BusStation("Obere Schneckenbergstraße",
                        "3_4", "25");
                list.add(busStation);
                busStation = new BusStation("Oetkersiedlung", "3_4", "26");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "3_4", "27");
                list.add(busStation);
                busStation = new BusStation("Rosensteig", "3_4", "28");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "3_4", "29");
                list.add(busStation);
                busStation = new BusStation("Schwendistraße", "3_4", "30");
                list.add(busStation);
                busStation = new BusStation("Stadttheater", "3_4", "31");
                list.add(busStation);
                busStation = new BusStation("Zahnradfabrik / Werk 1", "3_4",
                        "32");
                list.add(busStation);
                busStation = new BusStation("Schanzlbrücke", "3_4", "33");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 1 D", "3_4", "34");
                list.add(busStation);


                break;
            case "3":
                busStation = new BusStation("Achleiten", "3", "1");
                list.add(busStation);
                busStation = new BusStation("Auenweg", "3", "2");
                list.add(busStation);
                busStation = new BusStation("Aufischer", "3", "3");
                list.add(busStation);
                busStation = new BusStation("Augustinergasse", "3", "4");
                list.add(busStation);
                busStation = new BusStation("Evangelische Kirche", "3", "5");
                list.add(busStation);
                busStation = new BusStation("Garhammerweg", "3", "6");
                list.add(busStation);
                busStation = new BusStation("Haibach", "3", "7");
                list.add(busStation);
                busStation = new BusStation("Hörnerweg", "3", "8");
                list.add(busStation);
                busStation = new BusStation("Jägersteig", "3", "9");
                list.add(busStation);
                busStation = new BusStation("Jesuitenschlößl", "3", "10");
                list.add(busStation);
                busStation = new BusStation("Johann-Bergler-Straße", "3", "11");
                list.add(busStation);
                busStation = new BusStation("Kremserstraße", "3", "12");
                list.add(busStation);
                busStation = new BusStation("Lindau", "3", "1");
                list.add(busStation);
                busStation = new BusStation("Mühltalstraße", "3", "13");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "3", "14");
                list.add(busStation);
                busStation = new BusStation("Obere Schneckenbergstraße", "3",
                        "15");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "3", "16");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "3", "17");
                list.add(busStation);
                busStation = new BusStation("Schwendistraße", "3", "18");
                list.add(busStation);
                busStation = new BusStation("Stadttheater", "3", "19");
                list.add(busStation);
                busStation = new BusStation("Zahnradfabrik / Werk 1", "3",
                        "20");
                list.add(busStation);
                busStation = new BusStation("Schmiedgasse", "3", "21");
                list.add(busStation);
                busStation = new BusStation("Am Schanzlturm", "3", "22");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 1 A B", "3", "23");
                list.add(busStation);
                break;
            case "4":
                busStation = new BusStation("Achatiusstraße", "4", "1");
                list.add(busStation);
                busStation = new BusStation("Achleiten", "4", "2");
                list.add(busStation);
                busStation = new BusStation("Auenweg", "4", "3");
                list.add(busStation);
                busStation = new BusStation("Augustinergasse", "4", "4");
                list.add(busStation);
                busStation = new BusStation("Christdobl", "4", "5");
                list.add(busStation);
                busStation = new BusStation("Haibach", "4", "6");
                list.add(busStation);
                busStation = new BusStation("Hals", "4", "7");
                list.add(busStation);
                busStation = new BusStation("Hörnerweg", "4", "8");
                list.add(busStation);
                busStation = new BusStation("Ilzbrücke", "4", "9");
                list.add(busStation);
                busStation = new BusStation("Ilzleite", "4", "10");
                list.add(busStation);
                busStation = new BusStation("Jesuitenschlößl", "4", "11");
                list.add(busStation);
                busStation = new BusStation("Johann-Bergler Straße", "4", "12");
                list.add(busStation);
                busStation = new BusStation("Kremserstraße", "4", "13");
                list.add(busStation);
                busStation = new BusStation("Landrichterstraße", "4", "14");
                list.add(busStation);
                busStation = new BusStation("Mühltalstraße", "4", "15");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "4", "16");
                list.add(busStation);
                busStation = new BusStation("Oetkersiedlung", "4", "17");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "4", "18");
                list.add(busStation);
                busStation = new BusStation("Rosensteig", "4", "19");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "4", "20");
                list.add(busStation);
                busStation = new BusStation("Schwendistraße", "4", "21");
                list.add(busStation);
                busStation = new BusStation("Stadttheater", "4", "22");
                list.add(busStation);
                busStation = new BusStation("Schmiedgasse", "4", "23");
                list.add(busStation);
                busStation = new BusStation("Schanzlturm", "4", "24");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 1 A B", "4", "25");
                list.add(busStation);
                break;
            case "5_6_K_P":
                busStation = new BusStation("Auerspergstraße", "5_6_K_P", "1");
                list.add(busStation);
                busStation = new BusStation("Betty-Pfleger Straße",
                        "5_6_K_P", "2");
                list.add(busStation);
                busStation = new BusStation("Danziger Straße", "5_6_K_P", "3");
                list.add(busStation);
                busStation = new BusStation("Donauhof", "5_6_K_P", "4");
                list.add(busStation);
                busStation = new BusStation("Donau-Schwaben Straße",
                        "5_6_K_P", "5");
                list.add(busStation);
                busStation = new BusStation("Dr. Ernst.-Derra Straße",
                        "5_6_K_P", "6");
                list.add(busStation);
                busStation = new BusStation("Dr. Geiger Weg", "5_6_K_P", "7");
                list.add(busStation);
                busStation = new BusStation("Eggendobl", "5_6_K_P", "8");
                list.add(busStation);
                busStation = new BusStation("Englbolding", "5_6_K_P", "9");
                list.add(busStation);
                busStation = new BusStation("Fürstenweg", "5_6_K_P", "10");
                list.add(busStation);
                busStation = new BusStation("Gaißa Brücke", "5_6_K_P", "11");
                list.add(busStation);
                busStation = new BusStation("Gertraudstraße", "5_6_K_P", "12");
                list.add(busStation);
                busStation = new BusStation("Glockenstraße", "5_6_K_P", "13");
                list.add(busStation);
                busStation = new BusStation("Gretli-Fuchs Straße", "5_6_K_P",
                        "14");
                list.add(busStation);
                busStation = new BusStation("Grillenöd", "5_6_K_P", "15");
                list.add(busStation);
                busStation = new BusStation("Hellersberg", "5_6_K_P", "16");
                list.add(busStation);
                busStation = new BusStation("Irring", "5_6_K_P", "17");
                list.add(busStation);
                busStation = new BusStation("Jägerreuth", "5_6_K_P", "18");
                list.add(busStation);
                busStation = new BusStation("Kachletstraße", "5_6_K_P", "19");
                list.add(busStation);
                busStation = new BusStation("Kiesling", "5_6_K_P", "20");
                list.add(busStation);
                busStation = new BusStation("Kohlbruck / Erlebnisbad PEB",
                        "5_6_K_P", "21");
                list.add(busStation);
                busStation = new BusStation("Kohlbruck Brücke", "5_6_K_P",
                        "22");
                list.add(busStation);
                busStation = new BusStation("Kohlbruck", "5_6_K_P", "23");
                list.add(busStation);
                busStation = new BusStation("Kraftstraße", "5_6_K_P", "24");
                list.add(busStation);
                busStation = new BusStation("Kubinstraße", "5_6_K_P", "25");
                list.add(busStation);
                busStation = new BusStation("Lambergstraße", "5_6_K_P", "26");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße", "5_6_K_P", "27");
                list.add(busStation);
                busStation = new BusStation("Lüftlbergstraße", "5_6_K_P", "28");
                list.add(busStation);
                busStation = new BusStation("Maierhof", "5_6_K_P", "29");
                list.add(busStation);
                busStation = new BusStation("Minihofstraße", "5_6_K_P", "30");
                list.add(busStation);
                busStation = new BusStation("Moos", "5_6_K_P", "31");
                list.add(busStation);
                busStation = new BusStation("Neureuth", "5_6_K_P", "32");
                list.add(busStation);
                busStation = new BusStation("Passavia", "5_6_K_P", "33");
                list.add(busStation);
                busStation = new BusStation("Patriching", "5_6_K_P", "34");
                list.add(busStation);
                busStation = new BusStation("Plantage", "5_6_K_P", "35");
                list.add(busStation);
                busStation = new BusStation("Pramöd", "5_6_K_P", "36");
                list.add(busStation);
                busStation = new BusStation("Ries / Wasserturm", "5_6_K_P",
                        "37");
                list.add(busStation);
                busStation = new BusStation("Sailerwöhr", "5_6_K_P", "38");
                list.add(busStation);
                busStation = new BusStation("Schalding l.d.D.", "5_6_K_P",
                        "39");
                list.add(busStation);
                busStation = new BusStation("Schellköpfing", "5_6_K_P", "40");
                list.add(busStation);
                busStation = new BusStation("Am Schnanzl", "5_6_K_P", "41");
                list.add(busStation);
                busStation = new BusStation("Schulstraße", "5_6_K_P", "42");
                list.add(busStation);
                busStation = new BusStation("Simmerlingweg", "5_6_K_P", "43");
                list.add(busStation);
                busStation = new BusStation("St. Korona", "5_6_K_P", "44");
                list.add(busStation);
                busStation = new BusStation("St. Korona 2", "5_6_K_P", "45");
                list.add(busStation);
                busStation = new BusStation("Stadtgärtnerei", "5_6_K_P", "46");
                list.add(busStation);
                busStation = new BusStation("Stelzlhof", "5_6_K_P", "47");
                list.add(busStation);
                busStation = new BusStation("Tannenleite", "5_6_K_P", "48");
                list.add(busStation);
                busStation = new BusStation("Walding", "5_6_K_P", "49");
                list.add(busStation);
                busStation = new BusStation("Westerburgerstraße", "5_6_K_P",
                        "50");
                list.add(busStation);
                busStation = new BusStation("Wörth", "5_6_K_P", "51");
                list.add(busStation);
                busStation = new BusStation("Zahnradfabrik / Werk 2",
                        "5_6_K_P", "52");
                list.add(busStation);
                busStation = new BusStation("Zieglstadl", "5_6_K_P", "53");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 3", "5_6_K_P", "54");
                list.add(busStation);
                break;
            case "5_6_P_K":
                busStation = new BusStation("Auerspergstraße", "5_6_P_K", "1");
                list.add(busStation);
                busStation = new BusStation("Danziger Straße", "5_6_P_K", "2");
                list.add(busStation);
                busStation = new BusStation("Donauhof", "5_6_P_K", "3");
                list.add(busStation);
                busStation = new BusStation("Donau-Schwaben Straße",
                        "5_6_P_K", "4");
                list.add(busStation);
                busStation = new BusStation("Dr. Ernst.-Derra Straße",
                        "5_6_P_K", "5");
                list.add(busStation);
                busStation = new BusStation("Dr. Geiger Weg", "5_6_P_K", "6");
                list.add(busStation);
                busStation = new BusStation("Eggendobl", "5_6_P_K", "7");
                list.add(busStation);
                busStation = new BusStation("Fattinger Straße", "5_6_P_K", "8");
                list.add(busStation);
                busStation = new BusStation("Freudenhain", "5_6_P_K", "9");
                list.add(busStation);
                busStation = new BusStation("Fürstenweg", "5_6_P_K", "10");
                list.add(busStation);
                busStation = new BusStation("Gaishofen", "5_6_P_K", "11");
                list.add(busStation);
                busStation = new BusStation("Gaißa Brücke", "5_6_P_K", "12");
                list.add(busStation);
                busStation = new BusStation("Gertraudstraße", "5_6_P_K", "13");
                list.add(busStation);
                busStation = new BusStation("Glockenstraße", "5_6_P_K", "14");
                list.add(busStation);
                busStation = new BusStation("Gretli-Fuchs Straße", "5_6_P_K",
                        "15");
                list.add(busStation);
                busStation = new BusStation("Grillenöd", "5_6_P_K", "16");
                list.add(busStation);
                busStation = new BusStation("Irring", "5_6_P_K", "17");
                list.add(busStation);
                busStation = new BusStation("Jägerreuth", "5_6_P_K", "18");
                list.add(busStation);
                busStation = new BusStation("Kachletstraße", "5_6_P_K", "19");
                list.add(busStation);
                busStation = new BusStation("Kiesling", "5_6_P_K", "20");
                list.add(busStation);
                busStation = new BusStation("Kohlbruck / Erlebnisbad PEB",
                        "5_6_P_K", "21");
                list.add(busStation);
                busStation = new BusStation("Kraftstraße", "5_6_P_K", "22");
                list.add(busStation);
                busStation = new BusStation("Kubinstraße", "5_6_P_K", "23");
                list.add(busStation);
                busStation = new BusStation("Lambergstraße", "5_6_P_K", "24");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße", "5_6_P_K", "25");
                list.add(busStation);
                busStation = new BusStation("Lüftlbergstraße", "5_6_P_K", "26");
                list.add(busStation);
                busStation = new BusStation("Maierhof", "5_6_P_K", "27");
                list.add(busStation);
                busStation = new BusStation("Minihofstraße", "5_6_P_K", "28");
                list.add(busStation);
                busStation = new BusStation("Moos", "5_6_P_K", "29");
                list.add(busStation);
                busStation = new BusStation("Neureut", "5_6_P_K", "30");
                list.add(busStation);
                busStation = new BusStation("Passavia", "5_6_P_K", "31");
                list.add(busStation);
                busStation = new BusStation("Patriching", "5_6_P_K", "32");
                list.add(busStation);
                busStation = new BusStation("Patriching-Siedlung", "5_6_P_K",
                        "33");
                list.add(busStation);
                busStation = new BusStation("Plantage", "5_6_P_K", "34");
                list.add(busStation);
                busStation = new BusStation("Pramöd", "5_6_P_K", "35");
                list.add(busStation);
                busStation = new BusStation("Ries / Rennweg", "5_6_P_K", "36");
                list.add(busStation);
                busStation = new BusStation("Ries / Wasserturm", "5_6_P_K",
                        "37");
                list.add(busStation);
                busStation = new BusStation("Sailerwöhr", "5_6_P_K", "38");
                list.add(busStation);
                busStation = new BusStation("Schalding l.d.D.", "5_6_P_K",
                        "39");
                list.add(busStation);
                busStation = new BusStation("Schanzlbrücke", "5_6_P_K", "40");
                list.add(busStation);
                busStation = new BusStation("Schulstraße", "5_6_P_K", "41");
                list.add(busStation);
                busStation = new BusStation("Simmerlingweg", "5_6_P_K", "42");
                list.add(busStation);
                busStation = new BusStation("Stelzlhof", "5_6_P_K", "43");
                list.add(busStation);
                busStation = new BusStation("Westerburgerstraße", "5_6_P_K",
                        "44");
                list.add(busStation);
                busStation = new BusStation("Wörth", "5_6_P_K", "45");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 2", "2", "46");
                list.add(busStation);
                busStation = new BusStation("Zieglstadl", "5_6_P_K", "47");
                list.add(busStation);
                break;
            case "7_E_R":
                busStation = new BusStation("Anzengruberstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Auerspergstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Aeußere Spitalhofstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Bockhofweg", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Danziger Straße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Dr. Geiger Weg", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Eggendobl", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Eichendorffstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Eichetstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Freudenhain", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Fürstenweg", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Gertraudstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Glockenstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Grillenöd", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Herrmann-Woesner Straße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Holzmannstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Kraftstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Kreuzbergstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Lambergstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Lautensackstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Martin-Seitz Straße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Max-Matheis Straße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Plantage", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Reinhard-Raffalt Straße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Ries / Rennweg", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Sailerwöhr", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Am Schanzl", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Schreinerbauerweg", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Schulstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Senefelderstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Sturmbergweg", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Westendstraße", "7_E_R", "1");
                list.add(busStation);
                busStation = new BusStation("Westerburgerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 3", "7_E_R", "1");
                list.add(busStation);
                break;
            case "7_R_E":
                busStation = new BusStation("Auerspergstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Aeußere Spitalhofstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Danziger Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Dr. Geiger Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eggendobl", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eichetstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Fürstenweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gertraudstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Glockenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Grillenöd", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Herrmann-Woesner Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Holzmannstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kraftstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kreuzbergstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Lambergstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Lautensackstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Martin-Seitz Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Max-Matheis Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Plantage", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Reinhard-Raffalt Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Ries", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Sailerwöhr", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schreinerbauerweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schulstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Senefelderstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Anzengruberstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 2", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Anzengruberstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schanzlbrücke", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Westerburgerstraße", "2", "1");
                list.add(busStation);
                break;
            case "8_9_Kohl_Koenig":
                busStation = new BusStation("Apfelkoch", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Augustinergasse", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Birkhamerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Breslauerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Dr. Winklhofer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gionstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Graf-Salm Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gustav-Haydn Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hacklstein", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Heining", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kachlet", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Klinikum", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kohlbruck / Erlebnisbad PEB", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Königsberger Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Oberöder Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Raiffeisenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rittsteig", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schönleitnerweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Simmerlingsweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Söldenpeterweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Steinbachmühle", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stelzhamer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Universität", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Vornholz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Weinleitenweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Winzerleite", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Wörthstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 3", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofstraße", "2", "1");
                list.add(busStation);
                break;
            case "8_9_Koenig_Kohl":
                busStation = new BusStation("Apfelkoch", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Augustinergasse", "2", "1");
                list.add(busStation);
                busStation = new BusStation("B. von Behr Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Birkhamerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Breslauerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eich", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gionstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Graf-Salm Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Parkhaus Bahnhofstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hacklstein", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Heining", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hermann-Woesner Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Pater-Rupert-Mayer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hofmannsthalstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Holzmannstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kachlet", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Klinikum", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Königsberger Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Königschalding", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Raiffeisenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rittsteig", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schönleitnerweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Simmerlingsweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Söldenpeterweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stallerweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Steinbachmühle", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stelzhamer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Universität", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Vornholz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Weinleitenweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Westendstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Wörthstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 2", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Richterstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofstraße", "2", "1");
                list.add(busStation);
                break;
            case "10_Z_S":
                busStation = new BusStation("Buchenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gartenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hochlandweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Holzmannstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Prügelweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Raiffeisenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Reuthinger Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schalding r.d.D.", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Steinbachmühle", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stelzhamer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Westendstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Winzerleite", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 4", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofsstraße", "2", "1");
                list.add(busStation);
                break;
            case "10_S_Z":
                busStation = new BusStation("Buchenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Einöder Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gartenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Parkhaus Bahnhofsstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hochlandweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hoffeldweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Holzmannstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Prügelweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Raiffeisenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Reuthinger Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schalding r.d.D.", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Steinbachmühle", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stelzhamer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Westendstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Winzerleite", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofsstraße", "2", "1");
                list.add(busStation);
                break;
            case "11_Z_S":
                busStation = new BusStation("B. von Behr Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Carossastraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eichendorffstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eichetstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Emerenz-Meier Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hacklstein", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Heining", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kachlet", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Lautensackstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Martin-Seitz Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Raiffeisenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Reinhard-Raffalt Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rittsteigerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stallerweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Steinbachmühle", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stelzhamer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Anzengruberstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 4", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofstraße", "2", "1");
                list.add(busStation);
                break;
            case "11_S_Z":
                busStation = new BusStation("Carossastraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Emerenz-Meier Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Parkhaus Bahnhofstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hacklstein", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Heining", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kachlet", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Raiffeisenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Reinhard-Raffalt Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Senefelderstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Steinbachmühle", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stelzhamer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofstraße", "2", "1");
                list.add(busStation);
                break;
            case "K1_L_M":
                busStation = new BusStation("Anger", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Augustinerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Aumühlweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Donauweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eggendobl", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Fürstenweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Jahnstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kirchenplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Lüftlberg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Mariahilf-Grenzstation", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Mozartstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Muffatstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schulstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stadttheater", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 4", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schärdinger Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schanzlbrücke", "2", "1");
                list.add(busStation);
                break;
            case "K1_M_L":
                busStation = new BusStation("Anger", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Augustinerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Aumühlweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Donauweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eggendobl", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Jahnstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Mariahilf-Grenzstation", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Mozartstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Muffatstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schulstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stadttheater", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schmiedgasse", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 4", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Am Schanzl", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schärdinger Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Mayrhof", "2", "1");
                list.add(busStation);
                break;
            case "K2_S_M":
                busStation = new BusStation("Augustinerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Christdobl", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Ilzbrücke", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Jahnstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kirchenplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kühberg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Lindenthal 1", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Linzer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Mühltal", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Mühltalstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Sieglberg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Sieglgut", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stadttheater", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Voglau", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 4", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schanzlbrücke", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Klafterbrunnweg", "2", "1");
                list.add(busStation);
                break;
            case "K2_M_S":
                busStation = new BusStation("Augustinerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Christdobl", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Ilzbrücke", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Kirchenplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Mühltal", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Mühltalstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stadttheater", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Zollamt Saming", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Lindenthal 2", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schmiedgase", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 4", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Am Schanzlturm", "2", "1");
                list.add(busStation);
                break;
            case "K3_K_H":
                busStation = new BusStation("Apfelkoch", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Aufischer", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eduard-Hamm Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Giselastraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hochstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Ingling", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Klinikum", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Lindau", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Sulzsteg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Untere Schneckenbergstraße A", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Untere Schneckenbergstraße B", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Untere Schneckenbergstraße C", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Wörthsstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Untere Schneckenbergstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 4", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Am Schanzlturm", "2", "1");
                list.add(busStation);
                break;
            case "K3_H_K":
                busStation = new BusStation("Am Högl", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Apfelkoch", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Aufischer", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eduard-Hamm Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Giselastraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hochstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Klinikum", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Leopoldstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Lindau", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Sulzsteg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Untere Schneckenbergstraße A", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Untere Schneckenbergstraße B", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Untere Schneckenbergstraße C", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Wörthsstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Untere Schneckenbergstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 4", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schanzlbrücke", "2", "1");
                list.add(busStation);
                break;
            case "K4_Z_S":
                busStation = new BusStation("Aeußere Spitalhofstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bernhrad-Setzer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Brand", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Brand (Bedarfshaltestelle)", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Brandweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Danziger Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Dr. Geiger Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gutenbergstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hammerbachstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Herrmann-Woesner Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Holzheimerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Holzmannstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Johann-Riederer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Medienstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift / Haus Waldesruh", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Sagmeisterweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schreinerholzerweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 4", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofstraße", "2", "1");
                list.add(busStation);
                break;
            case "K4_S_Z":
                busStation = new BusStation("Aeußere Spitalhofstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bernhrad-Setzer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Brand", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Brand (Bedarfshaltestelle)", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Brandweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Danziger Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Dr. Geiger Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gutenbergstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hammerbachstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Herrmann-Woesner Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Holzheimerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Holzmannstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Johann-Riederer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Medienstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift / Haus Waldesruh", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Paula-Deppe Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schreinerholzerweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Sperrwies", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Westendstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofstraße", "2", "1");
                list.add(busStation);
                break;
            case "78_Z_S":
                busStation = new BusStation("B. von Behr Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Buchenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Dr. Winklhofer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gartenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gionstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Herrmann-Woesner Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hochlandweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hoffeldweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Oberöder Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Prügelweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Reuthinger Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rittsteig", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rittsteigerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schalding r.d.D.", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stallerweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Winzerleite", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Richterstraße", "2", "1");
                list.add(busStation);
                break;
            case "78_S_Z":
                busStation = new BusStation("B. von Behr Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Buchenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Dr. Winklhofer Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Einöder Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gartenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gionstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Gustav-Haydn Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Herrmann-Woesner Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hochlandweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hoffeldweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Neustift", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Oberöder Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Prügelweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Reuthinger Weg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rittsteig", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rittsteigerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schalding r.d.D.", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stallerweg", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Winzerleite", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Richterstraße", "2", "1");
                list.add(busStation);
                break;
            case "79_Z_E":
                busStation = new BusStation("B. von Behr Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eichetstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Martin-Seitz Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rittsteigerstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Stallerweg", "2", "1");
                list.add(busStation);
                break;
            case "79_E_Z":
                busStation = new BusStation("Carossastraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Eichendorffstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Emerenz-Meier Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Lautensackstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Raiffeisenstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Reinhard-Raffalt Straße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Anzengruberstraße", "2", "1");
                list.add(busStation);
                break;
            case "CB_B_R":
                busStation = new BusStation("Parkhaus Bahnhofstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Am Schanzl", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Domplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rathausplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Residenzplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rindermarkt", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 5", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Am Schanzlturm", "2", "1");
                list.add(busStation);
                break;
            case "CB_R_B":
                busStation = new BusStation("Hauptbahnhof", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Nagelschmiedgasse", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Rathaus", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Römerplatz", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schlosserstiege", "2", "1");
                list.add(busStation);
                busStation = new BusStation("ZOB Bussteig 5", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Bahnhofstraße", "2", "1");
                list.add(busStation);
                busStation = new BusStation("Schanzlbrücke", "2", "1");
                list.add(busStation);
                break;
        }
        return list;
    }
}
