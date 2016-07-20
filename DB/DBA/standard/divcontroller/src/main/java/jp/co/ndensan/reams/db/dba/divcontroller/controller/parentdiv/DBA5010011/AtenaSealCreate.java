/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA5010011;

import jp.co.ndensan.reams.db.dba.definition.batchprm.atenasealcreate.AtenaSealCreateBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA5010011.AtenaSealCreateDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA5010011.AtenaSealCreateHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA5010011.AtenaSealCreateValidatisonHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 宛名シール作成のDivControllerです。
 *
 * @reamsid_L DBA-1210-010 zhengsongling
 */
public class AtenaSealCreate {

    /**
     * 審査会委員報酬入力の初期化です。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<AtenaSealCreateDiv> onLoad(AtenaSealCreateDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出対象者チェックボックスです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<AtenaSealCreateDiv> onChange_chkTaishosha(AtenaSealCreateDiv div) {
        getHandler(div).onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 宛名シール作成の抽出期間チェック、エラーとする。
     *
     * @param div 審査会委員報酬入力DIV
     * @return バリデーション結果
     */
    public ResponseData<AtenaSealCreateDiv> onclick_Check(AtenaSealCreateDiv div) {
        ValidationMessageControlPairs validPairs = getValidatison(div).必須入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 画面項目の設定値をバッチパラメータに設定する。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<AtenaSealCreateBatchParameter>
     */
    public ResponseData<AtenaSealCreateBatchParameter> onclick_btnjikou(AtenaSealCreateDiv div) {
        return ResponseData.of(getHandler(div).onclick_btnjikou()).respond();
    }

    private AtenaSealCreateHandler getHandler(AtenaSealCreateDiv div) {
        return new AtenaSealCreateHandler(div);
    }

    private AtenaSealCreateValidatisonHandler getValidatison(AtenaSealCreateDiv div) {
        return new AtenaSealCreateValidatisonHandler(div);
    }
}
