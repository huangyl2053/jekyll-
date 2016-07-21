/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6310001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.gensenchoshudatasakusei.GensenChoshuDataSakuseiFlowParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6310001.GensenChoshuDataSakuseiDiv;

/**
 * 「源泉徴収データ作成」のハンドラークラスです。
 *
 * @reamsid_L DBE-2000-010 jinjue
 */
public class GensenChoshuDataSakuseiHandler {

    private final GensenChoshuDataSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 「源泉徴収データ作成」の div
     */
    public GensenChoshuDataSakuseiHandler(GensenChoshuDataSakuseiDiv div) {
        this.div = div;
    }

    /**
     * バッチパラメータの設定です。
     *
     * @return 「源泉徴収データ作成」のbatch用パラメータ
     */
    public GensenChoshuDataSakuseiFlowParameter getTempData() {
        GensenChoshuDataSakuseiFlowParameter tempData = new GensenChoshuDataSakuseiFlowParameter();
        tempData.set指定年(div.getTxtNendo().getValue().getYear());
        return tempData;
    }
}
