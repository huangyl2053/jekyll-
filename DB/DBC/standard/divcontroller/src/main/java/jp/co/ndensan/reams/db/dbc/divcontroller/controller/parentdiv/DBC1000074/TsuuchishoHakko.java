/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1000074;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.kijunshunyugakutekiyokettei.DBC190010_kijunsyunyuKetteiTsuchisyosakuseiParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000074.TsuuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000074.TsuuchishoHakkoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000074.TsuuchishoHakkoValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 基準収入額決定通知書発行のクラスです。
 *
 * @reamsid_L DBC-4610-010 qinzhen
 */
public class TsuuchishoHakko {

    private static final RString 入力チェック_申請 = new RString("申請");
    private static final RString 入力チェック_決定 = new RString("決定");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div TsuuchishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<TsuuchishoHakkoDiv> onLoad(TsuuchishoHakkoDiv div) {
        getHandler(div).initialize();
        getHandler(div).set文書番号();
        getHandler(div).set制御処理();

        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタンを切り替えた時に、前回対象日時と、申請年月日or決定年月日を初期化する。
     *
     * @param div TsuuchishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<TsuuchishoHakkoDiv> onChange_Chushutsukikan(TsuuchishoHakkoDiv div) {
        getHandler(div).set制御処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 文書番号ccdのonChangeです。
     *
     * @param div TsuuchishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<TsuuchishoHakkoDiv> onChange_BunshoBangoInput(TsuuchishoHakkoDiv div) {
        getHandler(div).set文書番号();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力チェックするボタン押下です。
     *
     * @param div TsuuchishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<TsuuchishoHakkoDiv> onClick_btnExcuteCheck(TsuuchishoHakkoDiv div) {
        getHandler(div).set出力順の入力チェック();
        RString 入力チェック_flag = getHandler(div).set入力チェック();
        if (入力チェック_申請.equals(入力チェック_flag)) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).申請年月日チェックValidate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        } else if (入力チェック_決定.equals(入力チェック_flag)) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).決定年月日チェックValidate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div TsuuchishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<DBC190010_kijunsyunyuKetteiTsuchisyosakuseiParameter> onClick_btnExcute(TsuuchishoHakkoDiv div) {
        TsuuchishoHakkoHandler handler = getHandler(div);

        handler.release前排他();
        return ResponseData.of(handler.setBatchParameter(div)).respond();
    }

    private TsuuchishoHakkoHandler getHandler(TsuuchishoHakkoDiv div) {
        return new TsuuchishoHakkoHandler(div);
    }

    private TsuuchishoHakkoValidationHandler getValidationHandler(TsuuchishoHakkoDiv div) {
        return new TsuuchishoHakkoValidationHandler(div);
    }
}
