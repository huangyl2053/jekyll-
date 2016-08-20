/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1110001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShotokujohoIchiranhyoSakuseiBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001.DBB1110001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001.ShotokuJohoIchiranHyoSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1110001.ShotokuJohoIchiranHyoSakuseiHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1110001.ShotokuJohoIchiranHyoSakuseiValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM51003_所得情報一覧表作成のクラスです。
 *
 * @reamsid_L DBB-1650-010 lijunjun
 */
public class ShotokuJohoIchiranHyoSakusei {

    private static final RString INDEX_111 = new RString("111");
    private static final RString INDEX_112 = new RString("112");
    private static final RString INDEX_120 = new RString("120");

    /**
     * 初期化のメソッド
     *
     * @param div ShotokushokaihyoIkkatuDiv
     * @return ResponseData<ShotokushokaihyoIkkatuDiv>
     */
    public ResponseData<ShotokuJohoIchiranHyoSakuseiDiv> onLoad(ShotokuJohoIchiranHyoSakuseiDiv div) {
        RString 導入形態コード = getHandler(div).get導入形態コード();
        getHandler(div).initialize(導入形態コード);
        if (INDEX_111.equals(導入形態コード)) {
            return ResponseData.of(div).setState(DBB1110001StateName.介護保険所得情報一覧広域用);
        } else if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            return ResponseData.of(div).setState(DBB1110001StateName.介護保険所得情報一覧単一他社用);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出対象の変更のメソッドです。
     *
     * @param div ShotokushokaihyoIkkatuDiv
     * @return ResponseData<ShotokushokaihyoIkkatuDiv>
     */
    public ResponseData<ShotokuJohoIchiranHyoSakuseiDiv> onChange_tyushutuTaishou(ShotokuJohoIchiranHyoSakuseiDiv div) {
        getHandler(div).onchange_抽出対象の変更();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンのメソッドです。
     *
     * @param div ShotokuJohoIchiranHyoSakuseiDiv
     * @return ResponseData<ShotokujohoIchiranhyoSakuseiBatchParameter>
     */
    public ResponseData<ShotokujohoIchiranhyoSakuseiBatchParameter> onClick_Register(ShotokuJohoIchiranHyoSakuseiDiv div) {
        ShotokujohoIchiranhyoSakuseiBatchParameter parameter = getHandler(div).creatBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 実行する前の入力チェックのメソッドです。
     *
     * @param div ShotokuJohoIchiranHyoSakuseiDiv
     * @return ResponseData<ShotokuJohoIchiranHyoSakuseiDiv>
     */
    public ResponseData<ShotokuJohoIchiranHyoSakuseiDiv> onClick_BeforeRegisterCheck(ShotokuJohoIchiranHyoSakuseiDiv div) {
        RString 導入形態コード = getHandler(div).get導入形態コード();
        boolean 広域保険者日付チェックflag = false;
        boolean 単一市町村日付チェックflag = false;
        if (INDEX_111.equals(導入形態コード)) {
            広域保険者日付チェックflag = getHandler(div).is広域保険者日付チェック();
        } else if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            単一市町村日付チェックflag = getHandler(div).is単一市町村日付チェック();
        }
        if (INDEX_111.equals(導入形態コード) && 広域保険者日付チェックflag) {
            ValidationMessageControlPairs validPairs = getValidationHandler().check日付(広域保険者日付チェックflag);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        } else if ((INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) && 単一市町村日付チェックflag) {
            ValidationMessageControlPairs validPairs = getValidationHandler().check日付(単一市町村日付チェックflag);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ShotokuJohoIchiranHyoSakuseiHandler getHandler(ShotokuJohoIchiranHyoSakuseiDiv div) {
        return new ShotokuJohoIchiranHyoSakuseiHandler(div);
    }

    private ShotokuJohoIchiranHyoSakuseiValidationHandler getValidationHandler() {
        return new ShotokuJohoIchiranHyoSakuseiValidationHandler();
    }
}
