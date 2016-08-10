/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1060001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.api.parameter.BatchParameterManager;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 減免減額帳票一括のDivControllerです。
 *
 * @reamsid_L DBD-3981-010 zhuxiaojun
 */
public class GemmenGengakuShoIkkatsuMain {

    private final RString 負担帳票のID = new RString("DBD100013_FutanGendogakuKetteiTsuchisho");
    private final RString 社会福祉のBATCH_ID = new RString("DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakko");

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
        if (文書番号.equals(new RString("1"))) {
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
    public ResponseData<BatchParameterMap> onClick_btnfutanKogakuParamSave(GemmenGengakuShoIkkatsuMainDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        BatchParameterManager manager = new BatchParameterManager(SubGyomuCode.DBD介護受給, 負担帳票のID);
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnJikkouFtanSave());
        manager.setParameterByBatch(responseData.data);
        return ResponseData.of(responseData.data).respond();
    }

    /**
     * 画面項目社会福祉法人等利用者負担軽減の設定値をバッチパラメータに設定、更新する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnshakaiKogakuParamSave(GemmenGengakuShoIkkatsuMainDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        BatchParameterManager manager = new BatchParameterManager(SubGyomuCode.DBD介護受給, 社会福祉のBATCH_ID);
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnJikkouSkaiSave());
        manager.setParameterByBatch(responseData.data);
        return ResponseData.of(responseData.data).respond();
    }

    /**
     * 負担限度額認定の年度設定、更新する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> onChange_futanNendoJikan(GemmenGengakuShoIkkatsuMainDiv div) {
//        FlexibleYear nendo = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendo().getDomain();
//        if (nendo != null) {
//            INendo getNendo = GemmenNendoResearcher.createInstance(GemmenGengakuShurui.負担限度額認定).find年度(nendo);
//            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendoFrom().setValue(getNendo.get開始日());
//            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendoTo().setValue(getNendo.get終了日());
//        }
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
//        FlexibleYear nendo = div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenNendo().getDomain();
//        if (nendo != null) {
//            INendo getNendo = GemmenNendoResearcher.createInstance(GemmenGengakuShurui.負担限度額認定).find年度(nendo);
//            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenNendoFrom().setValue(getNendo.get開始日());
//            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenNendoTo().setValue(getNendo.get終了日());
//        }
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
