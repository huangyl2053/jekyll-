/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1320001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710040.DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710050.DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710060.DBD710060_HanyoListShakaiFukushiHojinKeigenParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710070.DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710080.DBD710080_HanyoListFutanGendoGakuNinteiParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710110.DBD710110_HanyoListKokuhoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710120.DBD710120_HanyoListKokiKoreishaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710130.DBD710130_HanyoListJigyoTaishoshaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710140.DBD710140_HanyoListRiyoshaFutanwariaiParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710150.DBD710150_HanyoListShisetsuNyutaishoParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1320001.HanyoListParamHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1320001.HanyoListParamValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBD1320001_汎用リスト出力(介護受給共通)。
 *
 * @reamsid_L DBD-3930-010 liwul
 */
public class HanyoListParam {

    /**
     * 汎用リスト出力(介護受給共通)画面の初期化。
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     *
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onLoad(HanyoListParamDiv div) {
        getHandler(div).onLoad(ResponseHolder.getMenuID());
        return ResponseData.of(div).respond();
    }

    /**
     * 条件の保存 入力チェック
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_onBeforeParamSave(HanyoListParamDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs errorMessagePairs = getValidationHandler(div).validate実行するボタンクリック();
            if (errorMessagePairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(errorMessagePairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 条件の保存
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_saveBatchParameterSave(HanyoListParamDiv div) {
        return ResponseData.of(getHandler(div).saveBatchParamterMap(ResponseHolder.getMenuID())).respond();
    }

    /**
     * 条件の復元
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_onRestoreBatchParameter(HanyoListParamDiv div) {
        getHandler(div).restoreBatchParameter(ResponseHolder.getMenuID());
        return ResponseData.of(div).respond();
    }

    /**
     * 出力方法選択ラジオボタンonSelect画面項目制御
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onSelect_radShuturyokuHoho(HanyoListParamDiv div) {
        getHandler(div).onSelect_radShuturyokuHoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 年度RbGr onclick画面項目制御
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_radChushutsuJokenA(HanyoListParamDiv div) {
        getHandler(div).onClick_radChushutsuJokenA();
        return ResponseData.of(div).respond();
    }

    /**
     * 基準日RbGr onclick画面項目制御
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_radChushutsuJokenB(HanyoListParamDiv div) {
        getHandler(div).onClick_radChushutsuJokenB();
        return ResponseData.of(div).respond();
    }

    /**
     * 申請日RbGr onclick画面項目制御
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_radHaniJoken2(HanyoListParamDiv div) {
        getHandler(div).onClick_radChushutsuJokenB();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン 入力チェック　と　操作実施確認ボタン
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_onBeforeBatchParameterRegister(HanyoListParamDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs 帳票出力項目MessagePairs = null;
            if (!div.getCcdShutsuryokuKomoku().isDisabled()) {
                帳票出力項目MessagePairs = getValidationHandler(div).validate帳票出力項目チェック();
                
            }
            if (帳票出力項目MessagePairs != null && 帳票出力項目MessagePairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(帳票出力項目MessagePairs).respond();
            }
            ValidationMessageControlPairs warningMessagePairs = getValidationHandler(div).validate表題();
            if (warningMessagePairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(warningMessagePairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設入退所「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710150_HanyoListShisetsuNyutaishoParameter>
     */
    public ResponseData<DBD710150_HanyoListShisetsuNyutaishoParameter> onClick_btnShisetsuNyutaishoBatchRegister(HanyoListParamDiv div) {
        DBD710150_HanyoListShisetsuNyutaishoParameter parameter = getHandler(div).get汎用リスト_施設入退所BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 利用者負担額減免「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter>
     */
    public ResponseData<DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter> onClick_btnRiyoshaFutanGakuGengakuBatchRegister(HanyoListParamDiv div) {
        DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter parameter = getHandler(div).get汎用リスト_利用者負担額減免BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 訪問介護利用者負担額減額「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter>
     */
    public ResponseData<DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter> onClick_btnHomonKaigoBatchRegister(HanyoListParamDiv div) {
        DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter parameter = getHandler(div).get汎用リスト_訪問介護利用者負担額減額BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 社会福祉法人軽減「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710060_HanyoListShakaiFukushiHojinKeigenParameter>
     */
    public ResponseData<DBD710060_HanyoListShakaiFukushiHojinKeigenParameter> onClick_btnShakaiFukushiBatchRegister(HanyoListParamDiv div) {
        DBD710060_HanyoListShakaiFukushiHojinKeigenParameter parameter = getHandler(div).get汎用リスト_社会福祉法人軽減BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 特別地域加算減免「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter>
     */
    public ResponseData<DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter> onClick_btnTokubetsuChiikiKasanBatchRegister(HanyoListParamDiv div) {
        DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter parameter = getHandler(div).get汎用リスト_特別地域加算減免BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 負担限度額認定「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710080_HanyoListFutanGendoGakuNinteiParameter>
     */
    public ResponseData<DBD710080_HanyoListFutanGendoGakuNinteiParameter> onClick_btnFutanGendoGakuNinteiBatchRegister(HanyoListParamDiv div) {
        DBD710080_HanyoListFutanGendoGakuNinteiParameter parameter = getHandler(div).get汎用リスト_負担限度額認定BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 国保「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710110_HanyoListKokuhoParameter>
     */
    public ResponseData<DBD710110_HanyoListKokuhoParameter> onClick_btnKokuhoBatchRegister(HanyoListParamDiv div) {
        DBD710110_HanyoListKokuhoParameter parameter = getHandler(div).get汎用リスト_国保BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 後期高齢者「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710120_HanyoListKokiKoreishaParameter>
     */
    public ResponseData<DBD710120_HanyoListKokiKoreishaParameter> onClick_btnKokiKoreishaBatchRegister(HanyoListParamDiv div) {
        DBD710120_HanyoListKokiKoreishaParameter parameter = getHandler(div).get汎用リスト_後期高齢者BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 事業対象者「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710130_HanyoListJigyoTaishoshaParameter>
     */
    public ResponseData<DBD710130_HanyoListJigyoTaishoshaParameter> onClick_btnJigyoTaishoshaBatchRegister(HanyoListParamDiv div) {
        DBD710130_HanyoListJigyoTaishoshaParameter parameter = getHandler(div).get汎用リスト_事業対象者BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 利用者負担割合「実行する」ボタン 操作実施
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     * @return ResponseData<DBD710140_HanyoListRiyoshaFutanwariaiParameter>
     */
    public ResponseData<DBD710140_HanyoListRiyoshaFutanwariaiParameter> onClick_btnRiyoshaFutanwariaiBatchRegister(HanyoListParamDiv div) {
        DBD710140_HanyoListRiyoshaFutanwariaiParameter parameter = getHandler(div).get汎用リスト_利用者負担割合BatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private HanyoListParamHandler getHandler(HanyoListParamDiv div) {
        return new HanyoListParamHandler(div);
    }

    private HanyoListParamValidationHandler getValidationHandler(HanyoListParamDiv div) {
        return new HanyoListParamValidationHandler(div);
    }
}
