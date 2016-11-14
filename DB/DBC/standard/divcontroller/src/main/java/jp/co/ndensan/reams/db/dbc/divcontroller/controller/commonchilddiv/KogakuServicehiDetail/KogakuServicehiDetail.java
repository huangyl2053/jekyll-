/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.KogakuServicehiDetail;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail.KogakuServicehiDetailDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-010 guozm
 */
public class KogakuServicehiDetail {

    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");

    /**
     * 支給区分のonChange()
     *
     * @param div KogakuServicehiDetailDiv
     * @return ResponseData
     */
    public ResponseData<KogakuServicehiDetailDiv> onChange_rdbShikyuKubun(
            KogakuServicehiDetailDiv div) {
        if (KEY0.equals(div.getRdbShikyuKubun().getSelectedKey())) {
            div.getTxtShikyuKingaku().setDisabled(false);
        } else if (KEY1.equals(div.getRdbShikyuKubun().getSelectedKey())) {
            div.getTxtShikyuKingaku().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }
}
