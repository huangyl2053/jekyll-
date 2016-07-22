/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5250001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuBatchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250001.HanteiKekkaJohoShutsuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250001.HanteiKekkaJohoShutsuryokuValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 判定結果情報出力（介護認定審査会）クラスです。
 *
 * @reamsid_L DBE-0180-010 xuyannan
 */
public class HanteiKekkaJohoShutsuryoku {

    private static final RString モード = new RString("hanteiKekka");
    private static final RString 発行帳票 = new RString("2");
    private static final RString 帳票発行ボタン = new RString("btnHanteiKekkaIchiran");

    /**
     * 判定結果情報出力（介護認定審査会）Divを初期化します。
     *
     * @param div 判定結果情報出力（介護認定審査会）Div
     * @return ResponseData<HanteiKekkaJohoShutsuryokuDiv> 判定結果情報出力（介護認定審査会）Div
     */
    public ResponseData<HanteiKekkaJohoShutsuryokuDiv> onLoad(HanteiKekkaJohoShutsuryokuDiv div) {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(帳票発行ボタン, false);
        div.getCcdIShinsakaiIchiranList().initialize(モード);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会データ空チェックを実施します。
     *
     * @param div 判定結果情報出力（介護認定審査会）Div
     * @return ResponseData<NenreiTotatsuTorokushaListDiv>
     */
    public ResponseData<HanteiKekkaJohoShutsuryokuDiv> onClick_Check(HanteiKekkaJohoShutsuryokuDiv div) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (getValidationHandler(div).データ空チェック(validPairs).iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        } else if (getValidationHandler(div).未選択チェック(validPairs).iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * パラメーターを作成します。
     *
     * @param div バッチパラメータ情報Div
     * @return ResponseData<HanteiKekkaJohoShuturyokuBatchParameter>
     */
    public ResponseData<HanteiKekkaJohoShuturyokuBatchParameter> onClick_btnAction(HanteiKekkaJohoShutsuryokuDiv div) {
        HanteiKekkaJohoShuturyokuBatchParameter parameter = new HanteiKekkaJohoShuturyokuBatchParameter();
        parameter.setHakkouTyouhyou(発行帳票);
        parameter.setKaisaiBangouList(div.getCcdIShinsakaiIchiranList().get開催番号List());
        return ResponseData.of(parameter).respond();
    }

    private HanteiKekkaJohoShutsuryokuValidationHandler getValidationHandler(HanteiKekkaJohoShutsuryokuDiv div) {
        return new HanteiKekkaJohoShutsuryokuValidationHandler(div);
    }
}
