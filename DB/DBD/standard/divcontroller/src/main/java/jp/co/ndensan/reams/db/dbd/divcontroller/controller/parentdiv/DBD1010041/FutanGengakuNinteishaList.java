/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1010041;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD205010.DBD205010_FutanGendoGakuNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010041.DBD1010041StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010041.FutanGengakuNinteishaListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010041.FutanGengakuNinteishaListHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010041.FutanGengakuNinteishaListValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 負担限度額認定者リスト画面のDivControllerです。
 *
 * @reamsid_L DBD-3960-010 xuejm
 */
public class FutanGengakuNinteishaList {

    private static final RString 認定者リスト = new RString("ninteisha");
    private static final RString 対象年度 = new RString("taishoNendo");

    /**
     * 画面初期化処理です。
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return ResponseData<FutanGengakuNinteishaListDiv>
     */
    public ResponseData<FutanGengakuNinteishaListDiv> onLoad(FutanGengakuNinteishaListDiv div) {
        createhandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「該当者リスト」と「認定者リスト」ラジオを操作です。
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return ResponseData<FutanGengakuNinteishaListDiv>
     */
    public ResponseData<FutanGengakuNinteishaListDiv> radTaishoList_onChange(FutanGengakuNinteishaListDiv div) {
        createhandler(div).radTaishoList_onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 対象年度と基準日ラジオを操作です。
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return ResponseData<FutanGengakuNinteishaListDiv>
     */
    public ResponseData<FutanGengakuNinteishaListDiv> radTaishoKikanShitei_onChange(FutanGengakuNinteishaListDiv div) {
        createhandler(div).radTaishoKikanShitei_onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象年度」の変更」の処理です。
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return ResponseData<FutanGengakuNinteishaListDiv>
     */
    public ResponseData<FutanGengakuNinteishaListDiv> taishoYM_onChange(FutanGengakuNinteishaListDiv div) {
        createhandler(div).taishoYM_onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「リスト作成を実行する」ボタンを押下のチェック処理します。
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return ResponseData<FutanGengakuNinteishaListDiv>
     */
    public ResponseData<FutanGengakuNinteishaListDiv> onBeforeCilck_batchcheck(FutanGengakuNinteishaListDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.getRadTaishoList().getSelectedKey().equals(認定者リスト)) {
            if (div.getRadTaishoKikanShitei().getSelectedKey().equals(対象年度)) {
                getValidationHandler().validateFor対象年度と課税判定等基準日の未入力チェック(pairs, div);
            } else {
                getValidationHandler().validateFor基準日の未入力チェック(pairs, div);
            }
            getValidationHandler().validateFor所得年度の未入力チェック(pairs, div);
        } else {
            getValidationHandler().validateFor基準日の未入力チェック(pairs, div);
            getValidationHandler().validateFor所得年度の未入力チェック(pairs, div);
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).setState(DBD1010041StateName.バッチ実行);

    }

    /**
     * 「リスト作成を実行する」ボタンを押下のバッチパラメータ作成。
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return ResponseData<DBD205010_FutanGendoGakuNinteishaListParameter>
     */
    public ResponseData<DBD205010_FutanGendoGakuNinteishaListParameter> onClick_btnBatchExecute(FutanGengakuNinteishaListDiv div) {
        FutanGendogakuNinteiNinteishaIchiran futangendogaku = new FutanGendogakuNinteiNinteishaIchiran();
        return ResponseData.of(futangendogaku.createParameter(div)).respond();
    }

    private FutanGengakuNinteishaListHandler createhandler(FutanGengakuNinteishaListDiv div) {
        return new FutanGengakuNinteishaListHandler(div);
    }

    private FutanGengakuNinteishaListValidationHandler getValidationHandler() {
        return new FutanGengakuNinteishaListValidationHandler();
    }

}
