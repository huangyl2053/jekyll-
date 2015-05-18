/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.HihokenshashoHakkoTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.commonchilddiv.atenashokaisimple.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 被保険者証発行対象者情報Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class HihokenshashoHakkoTaishoshaJoho {

    /**
     * 被保険者証発行該当者一覧画面-「選択」ボタン押下時の処理を表します。
     *
     * @param panel HihokenshashoHakkoTaishoshaJohoDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshashoHakkoTaishoshaJohoDiv> dispTaishoshaJoho(
            HihokenshashoHakkoTaishoshaJohoDiv panel) {
        ResponseData<HihokenshashoHakkoTaishoshaJohoDiv> response = new ResponseData<>();

//        RString rsShikibetsuCode = (RString) ViewStateHolder.get("shikibetsuCode", RString.class);
//        RString rsHihoNo = (RString) ViewStateHolder.get("hihokenshaNo", RString.class);
        HashMap hashMap
                = YamlLoader.DBU.loadAsList(new RString("dbu0410011/HihokenshashoHakkoTaishoshaJoho.yml")).get(0);
//        int iIdx;
//        if (rsHihoNo.toString().equals("1234500001")) {
//            iIdx = 0;
//        } else {
//            iIdx = 1;
//        }
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        //宛名照会 識別コード設定
//        AtenaShokaiSimple.setData(panel.getHihokenshashoHakkoTaishoshaCommonJoho().getAtenaInfo(),
//                new ShikibetsuCode(ymlData.getAsRString("shikibetsuCode")));
//
//
//        //HashMap hashMap = hihokenshashoHakkoTaishoshaJohoList.get(iIdx);
//        ControlGenerator ymlData = new ControlGenerator(hashMap);
//        //対象者情報の出力
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtAtenaMeisho().
//                setValue(ymlData.getAsRString("shimei"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtAtenaKanaMeisho().
//                setValue(ymlData.getAsRString("kanashimei"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtJusho().
//                setValue(ymlData.getAsRString("jusho"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtSeinengappiYMD().
//                setValue(ymlData.getAsRDate("birthday"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtNenrei().
//                setValue(ymlData.getAsRString("nenrei"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtSeibetsu().
//                setValue(ymlData.getAsRString("seibetsu"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtGyoseiku().
//                setValue(ymlData.getAsRString("gyoseiku"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtYubinNo().
//                setValue(ymlData.getAsYubinNo("yubinNo"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtJuminJotai().
//                setValue(ymlData.getAsRString("juminjotai"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtShikibetsuCode().
//                setValue(ymlData.getAsRString("shikibetsuCode"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtKojinHojinCode().
//                setValue(ymlData.getAsRString("kojinNo"));
//
//        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtSetaiCode().
//                setValue(ymlData.getAsRString("setaiCode"));
        //介護資格基本情報
        panel.getCcdKaigoShikakuKihon().getTxtHihokenshaNo().
                setValue(ymlData.getAsRString("hihoNo"));

        if (ymlData.getAsRString("shutokuymd").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtShutokuYmd().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtShutokuYmd().
                    setValue(ymlData.getAsFlexibleDate("shutokuymd"));
        }

        if (ymlData.getAsRString("shutokujiyu").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtShutokuJiyu().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtShutokuJiyu().
                    setValue(ymlData.getAsRString("shutokujiyu"));
        }

        if (ymlData.getAsRString("soshitsuymd").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtSoshitsuYmd().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtSoshitsuYmd().
                    setValue(ymlData.getAsFlexibleDate("soshitsuymd"));
        }

        if (ymlData.getAsRString("soshitsujiyu").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtSoshitsuJiyu().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtSoshitsuJiyu().
                    setValue(ymlData.getAsRString("soshitsujiyu"));
        }

        if (ymlData.getAsRString("jutokukubun").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtJutokuKubun().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtJutokuKubun().
                    setValue(ymlData.getAsRString("jutokukubun"));
        }

        if (ymlData.getAsRString("kaigodo").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtYokaigoJotaiKubun().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtYokaigoJotaiKubun().
                    setValue(ymlData.getAsRString("kaigodo"));
        }

        if (ymlData.getAsRString("ninteikikanfrom").toString().isEmpty()) {

            panel.getCcdKaigoShikakuKihon().getTxtNinteiKaishiYmd().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtNinteiKaishiYmd().
                    setValue(ymlData.getAsRDate("ninteikikanfrom"));
        }

        if (ymlData.getAsRString("ninteikikanto").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtNinteiShuryoYmd().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtNinteiShuryoYmd().
                    setValue(ymlData.getAsRDate("ninteikikanto"));
        }

        response.data = panel;
        return response;

    }

}
