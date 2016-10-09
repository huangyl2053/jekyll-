/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1010031;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD101010.DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010031.FutangendogakuShoninMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010031.FutangendogakuShoninMainHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010031.FutangendogakuShoninMainValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 負担限度額認定申請承認（一括）画面
 *
 * @reamsid_L DBD-3710-010 xuejm
 */
public class FutangendogakuShoninMain {

    private static final int NO_0 = 0;
    private static final int NO_2 = 2;

    /**
     * 画面初期化処理です。
     *
     * @param div FutangendogakuShoninMainDiv
     * @return ResponseData<FutangendogakuShoninMainDiv>
     */
    public ResponseData<FutangendogakuShoninMainDiv> onLoad(FutangendogakuShoninMainDiv div) {
        createhandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認しない理由」を押下し、URZ.SampleBunshoToroku　をダイアログで表示する。<br/>
     *
     * @param div {@link FutangendogakuShoninMainDiv 負担限度額認定申請承認（一括）Div}
     * @return 負担限度額認定申請承認（一括）Divを持つResponseData
     */
    public ResponseData<FutangendogakuShoninMainDiv> onOpenBefore_btnOpenHiShoninRiyu(FutangendogakuShoninMainDiv div) {
        div.getFutangendogakuShonin().setSubGyomuCode(SubGyomuCode.DBD介護受給.value().substring(NO_0, NO_2));
        div.getFutangendogakuShonin().setSampleBunshoGroupCode(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * URZ.SampleBunshoToroku　をダイアログで表示し、選択する。
     *
     * @param div {@link FutangendogakuShoninMainDiv 負担限度額認定申請承認（一括）Div}
     * @return 負担限度額認定申請承認（一括）Divを持つResponseData
     */
    public ResponseData<FutangendogakuShoninMainDiv> onClose_btnOpenHiShoninRiyu(FutangendogakuShoninMainDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 負担限度額認定申請承認（一括）の「作成年度」が フォーカスアウト
     *
     * @param div FutangendogakuShoninMainDiv
     * @return ResponseData<FutangendogakuShoninMainDiv>
     */
    public ResponseData<FutangendogakuShoninMainDiv> onChange_futansakuseiNendo(FutangendogakuShoninMainDiv div) {
        createhandler(div).onChange_futansakuseiNendo();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div FutangendogakuShoninMainDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<FutangendogakuShoninMainDiv> onBeforeCilck_btnBatchchek(FutangendogakuShoninMainDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateForの未入力チェック(pairs, div);
        if (div.getShinseiPrint().disabledPublishCheckBox()) {
            getValidationHandler().validateFor発行日の未入力チェック(pairs, div);
        }
        if (div.getTxtShinseibiJoken().getFromValue() != null && div.getTxtShinseibiJoken().getToValue() != null) {
            getValidationHandler().validateFor申請日終了と申請日開始の比較チェック(pairs, div);
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下のバッチ用パラメータを作成します。
     *
     * @param div FutangendogakuShoninMainDiv のクラスファイル
     * @return ResponseData DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter
     */
    public ResponseData<DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter> onClick_btnBatchRegister(FutangendogakuShoninMainDiv div) {
        FutanGendogakuNinteiIkkatsu futangendogaku = new FutanGendogakuNinteiIkkatsu();
        return ResponseData.of(futangendogaku.createFutanGendogakuIkkatsuNinteiParameter(div)).respond();
    }

    private FutangendogakuShoninMainHandler createhandler(FutangendogakuShoninMainDiv div) {
        return new FutangendogakuShoninMainHandler(div);
    }

    private FutangendogakuShoninMainValidationHandler getValidationHandler() {
        return new FutangendogakuShoninMainValidationHandler();
    }
}
