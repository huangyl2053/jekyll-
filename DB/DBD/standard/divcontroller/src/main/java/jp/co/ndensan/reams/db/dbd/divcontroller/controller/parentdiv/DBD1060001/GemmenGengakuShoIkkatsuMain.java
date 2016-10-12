/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1060001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD103010.DBD103010_FutanGendoGakuNinteiIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD103020.DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 減免減額帳票一括のDivControllerです。
 *
 * @reamsid_L DBD-3981-010 zhuxiaojun
 */
public class GemmenGengakuShoIkkatsuMain {

    private final RString FUTANBATCH_ID = new RString("DBD103010_FutanGendoGakuNinteiIkkatsuHakko");
    private final RString SHAKAIBATCH_ID = new RString("DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakko");
    private final RString BATCH_ID = new RString("BatchID");

    /**
     * 画面の初期化。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     *
     * @return ResponseData<GemmenGengakuShoIkkatsuMainDiv>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> onLoad(GemmenGengakuShoIkkatsuMainDiv div) {
        getHandler(div).初期化画面の表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 「負担条件を保存する」ボタンのonClickイベント処理です。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnFutanBatchParameterSave(GemmenGengakuShoIkkatsuMainDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = getHandler(div).onClick_btnBatchFutanParameterSave();
        return responseData;
    }

    /**
     * 「社会条件を保存する」ボタンのonClickイベント処理です。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchShakaiParameterSave(GemmenGengakuShoIkkatsuMainDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = getHandler(div).onClick_btnBatchShakaiParameterSave();
        return responseData;
    }

    /**
     * 「負担条件を復元する」ボタンのonClickイベント処理です。
     *
     * @param div MemoListOutputDiv
     * @return ResponseData
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> onClick_btnBatchFutanParameterRestore(GemmenGengakuShoIkkatsuMainDiv div) {
        getHandler(div).onClick_btnBatchFutanParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 「社会条件を復元する」ボタンのonClickイベント処理です。
     *
     * @param div MemoListOutputDiv
     * @return ResponseData
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> onClick_btnBatchShakaiParameterRestore(GemmenGengakuShoIkkatsuMainDiv div) {
        getHandler(div).onClick_btnBatchShakaiParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 作成対象の選択。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     *
     * @return ResponseData<GemmenGengakuShoIkkatsuMainDiv>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> sakuseiTaisho_onChange(GemmenGengakuShoIkkatsuMainDiv div) {
        return getHandler(div).作成対象の選択();
    }

    /**
     * 実行ボタンチェック。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     *
     * @return ResponseData<GemmenGengakuShoIkkatsuMainDiv>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> jikkou_check(GemmenGengakuShoIkkatsuMainDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor出力の選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getValidationHandler().validateFor交付日の非空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getValidationHandler().validateFor発行日の非空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        RString 文書番号 = getHandler(div).文書番号チェック();
        if (文書番号.equals(new RString("1")) || 文書番号.equals(new RString("2"))) {
            getValidationHandler().validateFor文書番号の設定チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        if (div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedValue().equals(GemmenGengakuShurui.負担限度額認定.get名称())) {
            getValidationHandler().validateFor対象日のチェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        } else {
            getValidationHandler().validateFor決定日のチェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 出力ボックスチェック。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     *
     * @return ResponseData<GemmenGengakuShoIkkatsuMainDiv>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> 出力ボックスチェック(GemmenGengakuShoIkkatsuMainDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor出力の選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 画面項目負担限度額認定の設定値をバッチパラメータに設定、更新する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<DBD103010_FutanGendoGakuNinteiIkkatsuHakkoParameter> onClick_btnfutanKogakuParamSave(GemmenGengakuShoIkkatsuMainDiv div) {
        FlowParameters fp = FlowParameters.of(BATCH_ID, FUTANBATCH_ID);
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(getHandler(div).onClick_btnJikkouFtanSave()).respond();
    }

    /**
     * 画面項目社会福祉法人等利用者負担軽減の設定値をバッチパラメータに設定、更新する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakkoParameter> onClick_btnshakaiKogakuParamSave(GemmenGengakuShoIkkatsuMainDiv div) {
        FlowParameters fp = FlowParameters.of(BATCH_ID, SHAKAIBATCH_ID);
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(getHandler(div).onClick_btnJikkouSkaiSave()).respond();
    }

    /**
     * 負担限度額認定の年度設定、更新する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> onChange_futanNendoJikan(GemmenGengakuShoIkkatsuMainDiv div) {
        getHandler(div).geFuTanNendo(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減の年度設定、更新する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> onChange_shakaiNendoJikan(GemmenGengakuShoIkkatsuMainDiv div) {
        getHandler(div).getShakaiNendo(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減の文書番号を生成する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> onChange_shakaiBunnshoseisei(GemmenGengakuShoIkkatsuMainDiv div) {
        getHandler(div).shakaiBunshoSaiseisei(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 負担限度額認定の文書番号を生成する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> onChange_futanBunnshoseisei(GemmenGengakuShoIkkatsuMainDiv div) {
        getHandler(div).futanBunshoSaiseisei(div);
        return ResponseData.of(div).respond();
    }

    private GemmenGengakuShoIkkatsuMainHandler getHandler(GemmenGengakuShoIkkatsuMainDiv div) {
        return new GemmenGengakuShoIkkatsuMainHandler(div);
    }

    private GemmenGengakuShoIkkatsuMainValidationHandler getValidationHandler() {
        return new GemmenGengakuShoIkkatsuMainValidationHandler();
    }

}
