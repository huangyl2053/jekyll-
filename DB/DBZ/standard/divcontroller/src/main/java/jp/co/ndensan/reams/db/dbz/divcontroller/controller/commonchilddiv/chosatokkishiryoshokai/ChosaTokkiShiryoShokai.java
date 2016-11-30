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
    public ResponseData<ChosaTokkiShiryoShokaiDiv> initialize(ChosaTokkiShiryoShokaiDiv div) {
        // 引数保存例
        // パスのリスト:imgPath1,imgPath12,RString.Empty,imgPath14...(イメージがない場合、RString.Emptyを設定する)
        // タイトルリストのItem数はパスリストのItem数と一致してください。
        ArrayList<RString> imgGnepoPathList = DataPassingConverter.deserialize(div.getImgGenpoPathList(), ArrayList.class);
        ArrayList<RString> imgMaskPathList = DataPassingConverter.deserialize(div.getImgMaskPathList(), ArrayList.class);
        ArrayList<RString> genpoTitleList = DataPassingConverter.deserialize(div.getGenpoTitleList(), ArrayList.class);
        ArrayList<RString> maskTitleList = DataPassingConverter.deserialize(div.getMaskTitleList(), ArrayList.class);
        
        if (!imgGnepoPathList.isEmpty()) {
            if (imgGnepoPathList.size() >= 1) {
                div.getGenpoTabContainer().getGenpoTabPanel1().setVisible(true);
                div.getGenpoTabContainer().getGenpoTabPanel1().setTitle(genpoTitleList.get(0));
                div.getGenpoTabContainer().getGenpoTabPanel1().getImgGenpo1().setSrc(imgGnepoPathList.get(0));
                if (RString.isNullOrEmpty(imgGnepoPathList.get(0))) {
                    div.getGenpoTabContainer().getGenpoTabPanel1().setDisabled(true);
                }
            }
            if (imgGnepoPathList.size() >= 2) {
                div.getGenpoTabContainer().getGenpoTabPanel2().setVisible(true);
                div.getGenpoTabContainer().getGenpoTabPanel2().setTitle(genpoTitleList.get(1));
                div.getGenpoTabContainer().getGenpoTabPanel2().getImgGenpo2().setSrc(imgGnepoPathList.get(1));
                if (RString.isNullOrEmpty(imgGnepoPathList.get(1))) {
                    div.getGenpoTabContainer().getGenpoTabPanel2().setDisabled(true);
                }
            }
            if (imgGnepoPathList.size() >= 3) {
                div.getGenpoTabContainer().getGenpoTabPanel3().setVisible(true);
                div.getGenpoTabContainer().getGenpoTabPanel3().setTitle(genpoTitleList.get(2));
                div.getGenpoTabContainer().getGenpoTabPanel3().getImgGenpo3().setSrc(imgGnepoPathList.get(2));
                if (RString.isNullOrEmpty(imgGnepoPathList.get(2))) {
                    div.getGenpoTabContainer().getGenpoTabPanel3().setDisabled(true);
                }
            }
            if (imgGnepoPathList.size() >= 4) {
                div.getGenpoTabContainer().getGenpoTabPanel4().setVisible(true);
                div.getGenpoTabContainer().getGenpoTabPanel4().setTitle(genpoTitleList.get(3));
                div.getGenpoTabContainer().getGenpoTabPanel4().getImgGenpo4().setSrc(imgGnepoPathList.get(3));
                if (RString.isNullOrEmpty(imgGnepoPathList.get(3))) {
                    div.getGenpoTabContainer().getGenpoTabPanel4().setDisabled(true);
                }
            }
            if (imgGnepoPathList.size() >= 5) {
                div.getGenpoTabContainer().getGenpoTabPanel5().setVisible(true);
                div.getGenpoTabContainer().getGenpoTabPanel5().setTitle(genpoTitleList.get(4));
                div.getGenpoTabContainer().getGenpoTabPanel5().getImgGenpo5().setSrc(imgGnepoPathList.get(4));
                if (RString.isNullOrEmpty(imgGnepoPathList.get(4))) {
                    div.getGenpoTabContainer().getGenpoTabPanel5().setDisabled(true);
                }
            }
            if (imgGnepoPathList.size() >= 6) {
                div.getGenpoTabContainer().getGenpoTabPanel6().setVisible(true);
                div.getGenpoTabContainer().getGenpoTabPanel6().setTitle(genpoTitleList.get(5));
                div.getGenpoTabContainer().getGenpoTabPanel6().getImgGenpo6().setSrc(imgGnepoPathList.get(5));
                if (RString.isNullOrEmpty(imgGnepoPathList.get(5))) {
                    div.getGenpoTabContainer().getGenpoTabPanel6().setDisabled(true);
                }
            }
            if (imgGnepoPathList.size() >= 7) {
                div.getGenpoTabContainer().getGenpoTabPanel7().setVisible(true);
                div.getGenpoTabContainer().getGenpoTabPanel7().setTitle(genpoTitleList.get(6));
                div.getGenpoTabContainer().getGenpoTabPanel7().getImgGenpo7().setSrc(imgGnepoPathList.get(6));
                if (RString.isNullOrEmpty(imgGnepoPathList.get(6))) {
                    div.getGenpoTabContainer().getGenpoTabPanel7().setDisabled(true);
                }
            }
            if (imgGnepoPathList.size() >= 8) {
                div.getGenpoTabContainer().getGenpoTabPanel8().setVisible(true);
                div.getGenpoTabContainer().getGenpoTabPanel8().setTitle(genpoTitleList.get(7));
                div.getGenpoTabContainer().getGenpoTabPanel8().getImgGenpo8().setSrc(imgGnepoPathList.get(7));
                if (RString.isNullOrEmpty(imgGnepoPathList.get(7))) {
                    div.getGenpoTabContainer().getGenpoTabPanel8().setDisabled(true);
                }
            }
        }
        
        if (!imgMaskPathList.isEmpty()) {
            if (imgMaskPathList.size() >= 1) {
                div.getMaskTabContainer().getMaskTabPanel1().setVisible(true);
                div.getMaskTabContainer().getMaskTabPanel1().setTitle(maskTitleList.get(0));
                if (!RString.isNullOrEmpty(imgMaskPathList.get(0))) {
                    div.getMaskTabContainer().getMaskTabPanel1().getImgMask1().setSrc(imgMaskPathList.get(0));
                } else {
                    div.getMaskTabContainer().getMaskTabPanel1().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 2) {
                div.getMaskTabContainer().getMaskTabPanel2().setVisible(true);
                div.getMaskTabContainer().getMaskTabPanel2().setTitle(maskTitleList.get(1));
                div.getMaskTabContainer().getMaskTabPanel2().getImgMask2().setSrc(imgMaskPathList.get(1));
                if (RString.isNullOrEmpty(imgMaskPathList.get(1))) {
                    div.getMaskTabContainer().getMaskTabPanel2().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 3) {
                div.getMaskTabContainer().getMaskTabPanel3().setVisible(true);
                div.getMaskTabContainer().getMaskTabPanel3().setTitle(maskTitleList.get(2));
                div.getMaskTabContainer().getMaskTabPanel3().getImgMask3().setSrc(imgMaskPathList.get(2));
                if (RString.isNullOrEmpty(imgMaskPathList.get(2))) {
                    div.getMaskTabContainer().getMaskTabPanel3().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 4) {
                div.getMaskTabContainer().getMaskTabPanel4().setVisible(true);
                div.getMaskTabContainer().getMaskTabPanel4().setTitle(maskTitleList.get(3));
                div.getMaskTabContainer().getMaskTabPanel4().getImgMask4().setSrc(imgMaskPathList.get(3));
                if (RString.isNullOrEmpty(imgMaskPathList.get(3))) {
                    div.getMaskTabContainer().getMaskTabPanel4().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 5) {
                div.getMaskTabContainer().getMaskTabPanel5().setVisible(true);
                div.getMaskTabContainer().getMaskTabPanel5().setTitle(maskTitleList.get(4));
                div.getMaskTabContainer().getMaskTabPanel5().getImgMask5().setSrc(imgMaskPathList.get(4));
                if (RString.isNullOrEmpty(imgMaskPathList.get(4))) {
                    div.getMaskTabContainer().getMaskTabPanel5().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 6) {
                div.getMaskTabContainer().getMaskTabPanel6().setVisible(true);
                div.getMaskTabContainer().getMaskTabPanel6().setTitle(maskTitleList.get(5));
                div.getMaskTabContainer().getMaskTabPanel6().getImgMask6().setSrc(imgMaskPathList.get(5));
                if (RString.isNullOrEmpty(imgMaskPathList.get(5))) {
                    div.getMaskTabContainer().getMaskTabPanel6().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 7) {
                div.getMaskTabContainer().getMaskTabPanel7().setVisible(true);
                div.getMaskTabContainer().getMaskTabPanel7().setTitle(maskTitleList.get(6));
                div.getMaskTabContainer().getMaskTabPanel7().getImgMask7().setSrc(imgMaskPathList.get(6));
                if (RString.isNullOrEmpty(imgMaskPathList.get(6))) {
                    div.getMaskTabContainer().getMaskTabPanel7().setDisabled(true);
                }
            }
            if (imgMaskPathList.size() >= 8) {
                div.getMaskTabContainer().getMaskTabPanel8().setVisible(true);
                div.getMaskTabContainer().getMaskTabPanel8().setTitle(maskTitleList.get(7));
                div.getMaskTabContainer().getMaskTabPanel8().getImgMask8().setSrc(imgMaskPathList.get(7));
                if (RString.isNullOrEmpty(imgMaskPathList.get(7))) {
                    div.getMaskTabContainer().getMaskTabPanel8().setDisabled(true);
                }
            }
        }

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
