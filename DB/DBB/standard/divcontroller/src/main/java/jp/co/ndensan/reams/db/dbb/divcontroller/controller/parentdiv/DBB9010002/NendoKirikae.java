/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB9010002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.nendokirikae.DBB901002_NendoKirikaeParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9010002.NendoKirikaeDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9010002.NendoKirikaeHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 年度切替のクラスです
 *
 * @reamsid_L DBB-5722-010 zhengshenlei
 */
public class NendoKirikae {

    /**
     * 画面初期化です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<NendoKirikaeDiv>
     */
    public ResponseData<NendoKirikaeDiv> onload(NendoKirikaeDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン処理です。
     *
     * @param div NendoKirikaeDiv
     * @return ResponseData<NendoKirDBB901002_NendoKirikaeParameterikaeDiv>
     */
    public ResponseData<DBB901002_NendoKirikaeParameter> onClick_btBatch(NendoKirikaeDiv div) {
        DBB901002_NendoKirikaeParameter para = getHandler(div).バッチ実行();
        return ResponseData.of(para).respond();
    }

    private NendoKirikaeHandler getHandler(NendoKirikaeDiv div) {
        return new NendoKirikaeHandler(div);
    }
}
