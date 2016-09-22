/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000012;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000012.IdoRiyoshaFutanwariaiHanteiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000012.IdoRiyoshaFutanwariaiHanteiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * IdoRiyoshaFutanwariaiHantei_異動分利用者負担割合判定のクラスです。
 *
 * @reamsid_L DBC-4950-010 liuxiaoyu
 */
public class IdoRiyoshaFutanwariaiHantei {

    private static final RString KEY0 = new RString("key0");

    /**
     * 画面の初期化です。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<IdoRiyoshaFutanwariaiHanteiDiv> onLoad(IdoRiyoshaFutanwariaiHanteiDiv div) {
        RDateTime 画面起動時_今回終了時間 = getHandler(div).onLoad();
        ViewStateHolder.put(ViewStateKeys.画面起動時_今回終了時間, 画面起動時_今回終了時間);
        return ResponseData.of(div).respond();
    }

    /**
     * 年度の変更処理です。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<IdoRiyoshaFutanwariaiHanteiDiv> onChange(IdoRiyoshaFutanwariaiHanteiDiv div) {
        getHandler(div).onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 起動確認
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<IdoRiyoshaFutanwariaiHanteiDiv> onClick_beforeBtnBatchRegister(
            IdoRiyoshaFutanwariaiHanteiDiv div) {
        RDateTime 画面起動時_今回終了時間 = ViewStateHolder.get(ViewStateKeys.画面起動時_今回終了時間, RDateTime.class);
        getHandler(div).入力チェック(画面起動時_今回終了時間);
        if (!ResponseHolder.isReRequest() && div.getChkTest().getSelectedKeys().contains(KEY0)) {
            QuestionMessage 利用者負担割合テストモード確認MESSAGE = new QuestionMessage(
                    DbcQuestionMessages.利用者負担割合テストモード確認.getMessage().getCode(),
                    DbcQuestionMessages.利用者負担割合テストモード確認.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(利用者負担割合テストモード確認MESSAGE).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンを押下します。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<DBC180020_IdoRiyoshaFutanwariaiHanteiParameter> onClick_btnBatchRegister(
            IdoRiyoshaFutanwariaiHanteiDiv div) {
        DBC180020_IdoRiyoshaFutanwariaiHanteiParameter parameter = getHandler(div).バッチ起動処理();
        return ResponseData.of(parameter).respond();
    }

    private IdoRiyoshaFutanwariaiHanteiHandler getHandler(IdoRiyoshaFutanwariaiHanteiDiv div) {
        return IdoRiyoshaFutanwariaiHanteiHandler.of(div);
    }
}
