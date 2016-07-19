/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6310001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.gensenchoshudatasakusei.GensenChoshuDataSakuseiFlowParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6310001.GensenChoshuDataSakuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6310001.GensenChoshuDataSakuseiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6310001.GensenChoshuDataSakuseiValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 「源泉徴収データ作成」の処理詳細です。
 *
 * @reamsid_L DBE-2000-010 jinjue
 */
public class GensenChoshuDataSakusei {

    /**
     * 画面初期化処理です。
     *
     * @param div GensenChoshuDataSakuseiDiv
     * @return ResponseData<GensenChoshuDataSakuseiDiv>
     */
    public ResponseData<GensenChoshuDataSakuseiDiv> onLoad(GensenChoshuDataSakuseiDiv div) {
        div.getTxtNendo().setValue(RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * 「CSVを出力する」ボタン押下場合、"1"を設定します。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiDiv>
     */
    public ResponseData<GensenChoshuDataSakuseiDiv> onClick_csvCreate(GensenChoshuDataSakuseiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータの設定します。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiFlowParameter>
     */
    public ResponseData<GensenChoshuDataSakuseiFlowParameter> getParameter(GensenChoshuDataSakuseiDiv div) {
        GensenChoshuDataSakuseiFlowParameter tempData = getHandler(div).getTempData();
        return ResponseData.of(tempData).respond();
    }

    private GensenChoshuDataSakuseiHandler getHandler(GensenChoshuDataSakuseiDiv div) {
        return new GensenChoshuDataSakuseiHandler(div);
    }

    private GensenChoshuDataSakuseiValidationHandler getValidationHandler(GensenChoshuDataSakuseiDiv div) {
        return new GensenChoshuDataSakuseiValidationHandler(div);
    }
}
