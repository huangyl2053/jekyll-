/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.business.core.chosahyo.INinteichosaItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KihonchosaResultGuidanceDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteichosaResultInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * NinteichosaResultInputを制御します。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaResultInput {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaResultsInputDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultInputDiv> onLoad(NinteichosaResultInputDiv div) {
        ResponseData<NinteichosaResultInputDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

    /**
     * テストです。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaResultInputDiv> onClick_Test(NinteichosaResultInputDiv div) {
        ResponseData<NinteichosaResultInputDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

    /**
     * KihonchosaResultGuidanceDviを操作するためのクラスです。
     */
    private static class KihonchosaResultGuidance {

        private KihonchosaResultGuidance() {
        }

        public static void setUp(KihonchosaResultGuidanceDiv div, INinteichosaItem item) {
//            setUp_ItemNo(div, item);
        }

        private static void setUp_ItemNo(KihonchosaResultGuidanceDiv div, RString item) {
            div.getLblItemNo().setText(item);
        }

        private static void setUp_ItemName(KihonchosaResultGuidanceDiv div, RString name) {
            div.getLblItemName().setText(name);
        }
    }

}
