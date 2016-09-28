/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC5150011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC160020.DBC160020_ServicecodeIchiranParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011.DBC5150011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5150011.DBC5150011MainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5150011.DBC5150011MainValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNJ2006_サービスコード一覧表のクラスです。
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class DBC5150011Main {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div DBC5150011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC5150011MainDiv> onLoad(DBC5150011MainDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出条件区分RBTをonChangeです。
     *
     * @param div DBC5150011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC5150011MainDiv> onChanged_radMeisaiGokeiOut(DBC5150011MainDiv div) {
        getHandler(div).onChanged_radMeisaiGokeiOut();
        return ResponseData.of(div).respond();
    }

    /**
     * 出力方法CBLをonChangeです。
     *
     * @param div DBC5150011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC5150011MainDiv> onChanged_chkShutsuryokuTaisho(DBC5150011MainDiv div) {
        getHandler(div).onChanged_chkShutsuryokuTaisho();
        return ResponseData.of(div).respond();
    }

    /**
     * バッチ実行チェックのメソッドです。
     *
     * @param div DBC5150011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC5150011MainDiv> onClick_onBeforeOpenDialog(DBC5150011MainDiv div) {
        ValidationMessageControlPairs validationPairs = new ValidationMessageControlPairs();
        validationPairs.add(getValidationHandler(div).サービス種類コード_桁数チェック());
        validationPairs.add(getValidationHandler(div).サービス分類_指定なしチェック());
        validationPairs.add(getValidationHandler(div).出力方法_指定なしチェック());
        if (validationPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータの設定のメソッドです。
     *
     * @param div DBC5150011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC160020_ServicecodeIchiranParameter> onClick_btnBatchRegister(DBC5150011MainDiv div) {
        DBC160020_ServicecodeIchiranParameter parameter = getHandler(div).setParameter();
        return ResponseData.of(parameter).respond();
    }

    private DBC5150011MainHandler getHandler(DBC5150011MainDiv div) {
        return new DBC5150011MainHandler(div);
    }

    private DBC5150011MainValidationHandler getValidationHandler(DBC5150011MainDiv div) {
        return new DBC5150011MainValidationHandler(div);
    }
}
