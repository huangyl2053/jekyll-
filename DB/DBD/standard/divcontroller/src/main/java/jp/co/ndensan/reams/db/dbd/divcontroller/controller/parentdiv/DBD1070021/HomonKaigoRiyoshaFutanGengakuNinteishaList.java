/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1070021;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD202010.DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070021.DBD1070021StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070021.HomonKaigoRiyoshaFutanGengakuNinteishaListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1070021.HomonKaigoRiyoshaFutanGengakuNinteishaListHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1070021.HomonKaigoRiyoshaFutanGengakuNinteishaListValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 訪問介護利用者負担額減額認定者リスト画面のDivControllerです。
 *
 * @reamsid_L DBD-3970-010 xuejm
 */
public class HomonKaigoRiyoshaFutanGengakuNinteishaList {

    private static final RString 対象年度 = new RString("taishoNendo");

    /**
     * 画面初期化処理です。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv>
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv> onLoad(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        createhandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「該当者リスト」と「認定者リスト」ラジオを操作です。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv>
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv> radTaishoList_onChange(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        createhandler(div).radTaishoList_onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 対象年度と基準日ラジオを操作です。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv>
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv> radTaishoKikanShitei_onChange(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        createhandler(div).radTaishoKikanShitei_onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象年度」の変更」の処理です。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv>
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv> taishoYM_onChange(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        createhandler(div).taishoYM_onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 「リスト作成を実行する」ボタンを押下のチェック処理します。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv>
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv> onBeforeCilck_batchcheck(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.getRadTaishoKikanShitei().getSelectedKey().equals(対象年度)) {
            getValidationHandler().validateFor対象年度と課税判定等基準日の未入力チェック(pairs, div);
        } else {
            getValidationHandler().validateFor基準日の未入力チェック(pairs, div);
        }
        getValidationHandler().validateFor所得年度の未入力チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).setState(DBD1070021StateName.バッチ実行);
    }

    /**
     * 「リスト作成を実行する」ボタンを押下のバッチパラメータ作成。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return ResponseData<HomonKaigoRiyoshaFutanGakuNinteishaListParameter>
     */
    public ResponseData<DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter> onClick_btnBatchExecute(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        HomonKaigoRiyoshaFutangakuGengakuNinteishaList homonkrfgnl = new HomonKaigoRiyoshaFutangakuGengakuNinteishaList();
        return ResponseData.of(homonkrfgnl.createParameter(div)).respond();
    }

    private HomonKaigoRiyoshaFutanGengakuNinteishaListHandler createhandler(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        return new HomonKaigoRiyoshaFutanGengakuNinteishaListHandler(div);
    }

    private HomonKaigoRiyoshaFutanGengakuNinteishaListValidationHandler getValidationHandler() {
        return new HomonKaigoRiyoshaFutanGengakuNinteishaListValidationHandler();
    }
}
