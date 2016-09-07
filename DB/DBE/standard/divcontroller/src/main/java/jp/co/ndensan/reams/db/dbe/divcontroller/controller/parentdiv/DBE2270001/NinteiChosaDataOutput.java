/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2270001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.NinteiChosaDataOutputBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosadataoutput.NinteiChosaDataOutputBatchParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2270001.NinteiChosaDataOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2270001.NinteiChosaDataOutputHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2270001.NinteiChosaDataOutputValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosadataoutput.NinteiChosaDataOutputFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査データ出力（モバイル）のクラスです。
 *
 * @reamsid_L DBE-1860-010 duanzhanli
 */
public class NinteiChosaDataOutput {

    /**
     * 認定調査データ出力（モバイル）の初期化です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinteiChosaDataOutputDiv> onLoad(NinteiChosaDataOutputDiv div) {
        getHandler(div).load();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査一覧の設定メッソドです。
     *
     * @param div コントロールdiv
     * @return ResponseData<NinteiChosaDataOutputDiv>
     */
    public ResponseData<NinteiChosaDataOutputDiv> onClick_btnKensaku(NinteiChosaDataOutputDiv div) {

        List<NinteiChosaDataOutputBusiness> businessList
                = NinteiChosaDataOutputFinder.createInstance().getChosaChikuList(getHandler(div).setParameter()).records();
        getHandler(div).set共通ボタン();
        getHandler(div).get認定調査一覧(businessList);
        if (businessList.isEmpty()) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getValidationHandler().checkデータ存在());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアメッソドです。
     *
     * @param div コントロールdiv
     * @return ResponseData<NinteiChosaDataOutputDiv>
     */
    public ResponseData<NinteiChosaDataOutputDiv> onClick_btnKyufuJissekiSearchClear(NinteiChosaDataOutputDiv div) {
        getHandler(div).clear検索条件();
        return ResponseData.of(div).respond();
    }

    /**
     * バッチ呼び出す前にチェック処理を行う。
     *
     * @param div コントロールdiv
     * @return ResponseData<NinteiChosaDataOutputDiv>
     */
    public ResponseData<NinteiChosaDataOutputDiv> onClick_BeforeCheck(NinteiChosaDataOutputDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler().check対象行選択(div));
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * HokenshaListの設定onChangeメッソドです。
     *
     * @param div コントロールdiv
     * @return ResponseData<NinteiChosaDataOutputDiv>
     */
    public ResponseData<NinteiChosaDataOutputDiv> onChange_Hokensha(NinteiChosaDataOutputDiv div) {
        getHandler(div).setHdnShichosonCode();
        return ResponseData.of(div).respond();
    }

    /**
     * バッチ呼び出すメッソドです。
     *
     * @param div コントロールdiv
     * @return ResponseData<NinteiChosaDataOutputDiv>
     */
    public ResponseData<NinteiChosaDataOutputBatchParamter> onClick_btnExecute(NinteiChosaDataOutputDiv div) {
        return ResponseData.of(getHandler(div).getBatchParameter()).respond();
    }

    private NinteiChosaDataOutputHandler getHandler(NinteiChosaDataOutputDiv div) {
        return new NinteiChosaDataOutputHandler(div);
    }

    private NinteiChosaDataOutputValidationHandler getValidationHandler() {
        return new NinteiChosaDataOutputValidationHandler();
    }
}
