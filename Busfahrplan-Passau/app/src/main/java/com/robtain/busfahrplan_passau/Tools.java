package com.robtain.busfahrplan_passau;

import android.content.Intent;
import android.view.MenuItem;

/**
 * provides methodes to reduce code duplication or set general settings
 */
public class Tools {
    private String codeword;

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
                    codeword = "78_Z_E";
                    return SubmenuActivity.class;
                case R.id.nav_79_Eichendorffstr_ZOB:
                    codeword = "78_E_Z";
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

}
