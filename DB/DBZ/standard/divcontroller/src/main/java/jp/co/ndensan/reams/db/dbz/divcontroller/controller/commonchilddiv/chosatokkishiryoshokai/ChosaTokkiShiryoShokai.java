/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.chosatokkishiryoshokai;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokaiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * @author n8344
 */
public class ChosaTokkiShiryoShokai {

    private static final RString SELECTED_KEY0 = new RString("key0");

    /**
     * 画面初期化
     *
     * @param div ChosaTokkiShiryoShokaiDiv
     * @return ResponseData<ChosaTokkiShiryoShokaiDiv>
     */
    public ResponseData<ChosaTokkiShiryoShokaiDiv> onLoad(ChosaTokkiShiryoShokaiDiv div) {
        ArrayList<RString> imgGneponPathList = DataPassingConverter.deserialize(div.getImgGenponPathList(), ArrayList.class);
        ArrayList<RString> imgMaskPathList = DataPassingConverter.deserialize(div.getImgMaskPathList(), ArrayList.class);
        ArrayList<RString> genponTitleList = DataPassingConverter.deserialize(div.getGenponTitleList(), ArrayList.class);
        ArrayList<RString> maskTitleList = DataPassingConverter.deserialize(div.getMaskTitleList(), ArrayList.class);

        div.initialize(imgGneponPathList, imgMaskPathList, genponTitleList, maskTitleList);
        return ResponseData.of(div).respond();
    }

    /**
     * 区分を切り替え
     *
     * @param div ChosaTokkiShiryoShokaiDiv
     * @return ResponseData<ChosaTokkiShiryoShokaiDiv>
     */
    public ResponseData<ChosaTokkiShiryoShokaiDiv> onChange_radGenpoMask(ChosaTokkiShiryoShokaiDiv div) {
        if (SELECTED_KEY0.equals(div.getRadGenpoMask().getSelectedKey())) {
            div.getGenpoTabContainer().setDisplayNone(false);
            div.getMaskTabContainer().setDisplayNone(true);
        } else {
            div.getGenpoTabContainer().setDisplayNone(true);
            div.getMaskTabContainer().setDisplayNone(false);
        }
        return ResponseData.of(div).respond();
    }
}
