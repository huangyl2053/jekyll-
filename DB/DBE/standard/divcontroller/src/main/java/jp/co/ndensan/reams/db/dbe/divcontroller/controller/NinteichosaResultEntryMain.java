/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaForNinteichosaResultDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteichosaDetailDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteichosaResultEntryMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteichosaResultEntryTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgNinteichosaResultTaishosha_Row;
import jp.co.ndensan.reams.ur.urz.business.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.business.IDateOfBirth;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * NinteichosaResultEntryMainDivを制御します。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaResultEntryMain {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaResultEntryMainDiv
     * @param target NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryMainDiv> onLoad(NinteichosaResultEntryMainDiv div, NinteichosaResultEntryTargetDiv target) {
        ResponseData<NinteichosaResultEntryMainDiv> response = new ResponseData<>();

        HihokenshaForNinteichosaResult.setTargetInfo(div.getHihokenshaForNinteichosaResult(),
                target.getDgNinteichosaResultTaishosha().getClickedItem());
        NinteichosaDetail.onLoad(div.getNinteichosaDetail());

        response.data = div;
        return response;
    }

    /**
     * HihokenshaForNinteichosaResultDivを操作するためのクラスです。
     */
    private static class HihokenshaForNinteichosaResult {

        /**
         * HihokenshaForNinteichosaResultDivをdgNinteichosaResultTaishosha_Rowで設定します。
         *
         * @param div HihokenshaForNinteichosaResultDiv
         * @param data dgNinteichosaResultTaishosha_Row
         */
        public static void setTargetInfo(HihokenshaForNinteichosaResultDiv div, dgNinteichosaResultTaishosha_Row data) {
            div.getTxtHihokenshaNo().setValue(data.getHihokenshaNo());
            div.getTxtHokenshaNo().setValue(data.getHokenshaNo());
            div.getTxtShinseiDate().setValue(new RDate(data.getShinseiDate().getValue().toString()));
            div.getTxtShinseiKubun().setValue(data.getShinseiKubun());
            div.getTxtHihokenshaName().setValue(data.getShimei());
            div.getTxtHihokenshaGender().setValue(data.getGender());
            div.getTxtHihokenshaYubinNo().setValue(data.getYubinNo());
            div.getTxtHihokenshaJusho().setValue(data.getJusho());
            IDateOfBirth birthDay = DateOfBirthFactory.createInstance(data.getBirthDay().getValue());
            div.getTxtHihokenshaBirthDay().setValue(birthDay.toDate());
            div.getTxtHihokenshaAge().setValue(new RString("" + birthDay.get年齢()));
        }
    }

    /**
     * NinteichosaDetailDivを操作するためのクラスです。
     */
    private static class NinteichosaDetail {

        /**
         * ロード時の処理です。
         *
         * @param div ChosainForNinteichosaResultDiv
         */
        public static void onLoad(NinteichosaDetailDiv div) {
            div.getTxtChosainCode().setValue(new RString("0000000002"));
            div.getTxtChosainName().setValue(new RString("調査員"));
            div.getTxtChosaItakusakiCode().setValue(new RString("0000000001"));
            div.getTxtChosaItakusakiName().setValue(new RString("調査委託先A"));
        }
    }
}
