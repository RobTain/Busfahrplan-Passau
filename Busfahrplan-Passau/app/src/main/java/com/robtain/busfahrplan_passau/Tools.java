package com.robtain.busfahrplan_passau;

import android.content.Intent;
import android.view.MenuItem;

/**
 * Created by RobTain on 01.03.2016.
 */
public class Tools {
    /**
     * Created by RobTain on 01.03.2016.
     */

        final public Class getNavMenu(MenuItem item){
    //test
            int id = item.getItemId();
            Intent i = null;

            if (id == R.id.mathematicsNavMenu) {
                return SubmenuMathActivity.class;
            } else if (id == R.id.physicsNavMenu) {
                return SubmenuPhysicActivity.class;
            } else if (id == R.id.computerscienceNavMenu) {
                return SubmenuInformaticActivity.class;
            } else if (id == R.id.chemistryNavMenu) {
                return SubmenuChemistryActivity.class;
            } else if (id == R.id.biologyNavMenu) {
                return SubmenuBiologyActivity.class;
            } else if (id == R.id.accountingNavMenu) {
                return SubmenuAccountingActivity.class;
            } else if (id == R.id.searchNavMenu) {
                return SearchActivity.class;
            } else if (id == R.id.lexiconNavMenu) {
                return LexiconActivity.class;
            } else if (id == R.id.contactNavMenu) {
                return ContactActivity.class;
            } else if (id == R.id.rateNavMenu) {
                return RateAppActivity.class;
            } else if (id == R.id.buyPremiumNavMenu) {
                return BuyPremiumActivity.class;

            }
            //default path
            return StartActivity.class;
        }

}
