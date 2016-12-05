/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.chosatokkishiryoshokai;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokaiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 *
 * @author n8344
 */
public class ChosaTokkiShiryoShokai {

    private static final RString SELECTED_KEY0 = new RString("key0");

    /**
     * 区分を切り替え
     *
     * @param div ChosaTokkiShiryoShokaiDiv
     * @return ResponseData<ChosaTokkiShiryoShokaiDiv>
     */
    public ResponseData<ChosaTokkiShiryoShokaiDiv> onChange_radGenpoMask(ChosaTokkiShiryoShokaiDiv div) {
        if (SELECTED_KEY0.equals(div.getRadGenpoMask().getSelectedKey())) {
            TabPanel selectedTab = div.getMaskTabContainer().getSelectedItem();
            div.getGenpoTabContainer().setDisplayNone(false);
            div.getMaskTabContainer().setDisplayNone(true);
            div.getGenpoTabContainer().setSelectedItem(getGenponTab(div, selectedTab));
        } else {
            TabPanel selectedTab = div.getGenpoTabContainer().getSelectedItem();
            div.getGenpoTabContainer().setDisplayNone(true);
            div.getMaskTabContainer().setDisplayNone(false);
            div.getMaskTabContainer().setSelectedItem(getMaskTab(div, selectedTab));
        }
        return ResponseData.of(div).respond();
    }

    private TabPanel getGenponTab(ChosaTokkiShiryoShokaiDiv div, TabPanel selectedMaskTab) {
        TabPanel selectGenponTab = div.getGenpoTabPanel1();
        if (selectedMaskTab.equals(div.getMaskTabPanel2())) {
            selectGenponTab = div.getGenpoTabPanel2();
        } else if (selectedMaskTab.equals(div.getMaskTabPanel3())) {
            selectGenponTab = div.getGenpoTabPanel3();
        } else if (selectedMaskTab.equals(div.getMaskTabPanel4())) {
            selectGenponTab = div.getGenpoTabPanel4();
        } else if (selectedMaskTab.equals(div.getMaskTabPanel5())) {
            selectGenponTab = div.getGenpoTabPanel5();
        } else if (selectedMaskTab.equals(div.getMaskTabPanel6())) {
            selectGenponTab = div.getGenpoTabPanel6();
        } else if (selectedMaskTab.equals(div.getMaskTabPanel7())) {
            selectGenponTab = div.getGenpoTabPanel7();
        } else if (selectedMaskTab.equals(div.getMaskTabPanel8())) {
            selectGenponTab = div.getGenpoTabPanel8();
        }
        return selectGenponTab;
    }

    private TabPanel getMaskTab(ChosaTokkiShiryoShokaiDiv div, TabPanel selectedGenponTab) {
        TabPanel selectMaskTab = div.getMaskTabPanel1();
        if (selectedGenponTab.equals(div.getGenpoTabPanel2())) {
            selectMaskTab = div.getMaskTabPanel2();
        } else if (selectedGenponTab.equals(div.getGenpoTabPanel3())) {
            selectMaskTab = div.getMaskTabPanel3();
        } else if (selectedGenponTab.equals(div.getGenpoTabPanel4())) {
            selectMaskTab = div.getMaskTabPanel4();
        } else if (selectedGenponTab.equals(div.getGenpoTabPanel5())) {
            selectMaskTab = div.getMaskTabPanel5();
        } else if (selectedGenponTab.equals(div.getGenpoTabPanel6())) {
            selectMaskTab = div.getMaskTabPanel6();
        } else if (selectedGenponTab.equals(div.getGenpoTabPanel7())) {
            selectMaskTab = div.getMaskTabPanel7();
        } else if (selectedGenponTab.equals(div.getGenpoTabPanel8())) {
            selectMaskTab = div.getMaskTabPanel8();
        }
        return selectMaskTab;
    }
}
