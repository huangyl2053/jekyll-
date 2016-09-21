/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0110001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB011001.DBB011001_TokuchoKarisanteiFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB011003.DBB011003_TokuchoKarisanteiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001.TokutyoKariSanteiFukaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0110001.TokutyoKariSanteiFukaHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0110001.TokutyoKariSanteiFukaValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 画面設計_DBBGM33001_特徴仮算定賦課
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 */
public class TokutyoKariSanteiFuka {

    private static final RString DBBMN33001 = new RString("DBBMN33001");
    private static final RString DBBMN33002 = new RString("DBBMN33002");
    private static final RString 特徴仮算定賦課 = new RString("特徴仮算定賦課");
    private static final RString 特徴仮算定通知書一括発行 = new RString("特徴仮算定通知書一括発行");
    
    /**
     * コントロールdivが「生成」された際の処理です。(オンロード) .
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokutyoKariSanteiFukaDiv> onLoad(TokutyoKariSanteiFukaDiv div) {
        TokutyoKariSanteiFukaHandler handler = getHandler(div);
        handler.initialize();
        if(DBBMN33001.equals(ResponseHolder.getMenuID())){
            return ResponseData.of(div).rootTitle(特徴仮算定賦課).respond();
        }else if(DBBMN33002.equals(ResponseHolder.getMenuID())){
            return ResponseData.of(div).rootTitle(特徴仮算定通知書一括発行).respond();
        }else{
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 特徴仮算定通知書一括発行を「実行する」を押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     *
     */
    public ResponseData<DBB011003_TokuchoKarisanteiTsuchishoHakkoParameter> onClick_btnSantei(TokutyoKariSanteiFukaDiv div) {
        DBB011003_TokuchoKarisanteiTsuchishoHakkoParameter param = getHandler(div).特徴仮算定通知書一括発行BatchParam(div);
        return ResponseData.of(param).respond();
    }

    /**
     * 特徴仮算定賦課を「実行する」を押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     *
     */
    public ResponseData<DBB011001_TokuchoKarisanteiFukaParameter> onClick_btnTsuchishoSakusei(TokutyoKariSanteiFukaDiv div) {
        DBB011001_TokuchoKarisanteiFukaParameter param = getHandler(div).特徴仮算定賦課BatchParam(div);
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
