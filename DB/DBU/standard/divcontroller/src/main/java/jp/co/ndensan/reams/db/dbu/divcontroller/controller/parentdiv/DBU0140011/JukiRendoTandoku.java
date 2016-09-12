/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0140011;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyotruku.KaigojuminHyotrukuBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0140011.JukiRendoTandokuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0140011.JukiRendoTandokuHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;

/**
 *
 * 画面設計_DBUMN81001_住民異動連携情報登録【他社住基用】。
 *
 * @reamsid_L DBA-1400-010 houtianpeng
 */
public class JukiRendoTandoku {

    /**
     * 画面設計_DBUMN81001_住民異動連携情報登録【他社住基用】。
     *
     * @param div {@link JukiRendoTandokuDiv 住民異動連携情報登録Div}
     * @return JukiRendoTandokuDiv
     */
    public ResponseData<JukiRendoTandokuDiv> onLoad(JukiRendoTandokuDiv div) {
        createHandlerOf(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 送信ファイル情報を取り込みする　ボタン。
     *
     * @param div {@link JukiRendoTandokuDiv 住民異動連携情報登録Div}
     * @param files FileData
     * @return JukiRendoTandokuDiv
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<JukiRendoTandokuDiv> onClick_yomiKomi(JukiRendoTandokuDiv div, FileData[] files) {

        for (FileData file : files) {

            createHandlerOf(div).画面編集(file);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下時、バッチパラメータを引き渡し、バッチを起動する。
     *
     * @param div 住民異動連携情報登録情報Div
     * @return ResponseData
     */
    public ResponseData<KaigojuminHyotrukuBatchParameter> onClick_jiko(JukiRendoTandokuDiv div) {
        return ResponseData.of(createHandlerOf(div).setBatchParameter()).respond();
    }

    private JukiRendoTandokuHandler createHandlerOf(JukiRendoTandokuDiv div) {
        return new JukiRendoTandokuHandler(div);
    }
}
