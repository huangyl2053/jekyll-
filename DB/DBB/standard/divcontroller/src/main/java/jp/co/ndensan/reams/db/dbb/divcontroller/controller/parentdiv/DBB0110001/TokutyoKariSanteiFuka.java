/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0110001;

import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.TokuchoKariSanteiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001.TokutyoKariSanteiFukaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0110001.TokutyoKariSanteiFukaHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0110001.TokutyoKariSanteiFukaValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 画面設計_DBBGM33001_特徴仮算定賦課
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 */
public class TokutyoKariSanteiFuka {

    /**
     * コントロールdivが「生成」された際の処理です。(オンロード) .
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokutyoKariSanteiFukaDiv> onLoad(TokutyoKariSanteiFukaDiv div) {
        TokutyoKariSanteiFukaHandler handler = getHandler(div);
        handler.initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 特徴仮算定賦課を「実行する」を押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     *
     */
    public ResponseData<TokuchoKariSanteiParameter> btnSantei(TokutyoKariSanteiFukaDiv div) {
        TokuchoKariSanteiParameter param = getHandler(div).btncommon(div);
        return ResponseData.of(param).respond();
    }

    /**
     * 特徴仮算定賦課を「予約する」を押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoKariSanteiParameter> btnSanteiYoyaku(TokutyoKariSanteiFukaDiv div) {
        TokuchoKariSanteiParameter param = getHandler(div).btncommon(div);
        return ResponseData.of(param).respond();
    }

    /**
     * 発行日未入力チェックのンメソッドです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokutyoKariSanteiFukaDiv> publishDateCheck(TokutyoKariSanteiFukaDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).発行日未入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private TokutyoKariSanteiFukaHandler getHandler(TokutyoKariSanteiFukaDiv div) {
        return TokutyoKariSanteiFukaHandler.of(div);
    }

    private TokutyoKariSanteiFukaValidationHandler getValidationHandler(TokutyoKariSanteiFukaDiv div) {
        return new TokutyoKariSanteiFukaValidationHandler(div);
    }
}
