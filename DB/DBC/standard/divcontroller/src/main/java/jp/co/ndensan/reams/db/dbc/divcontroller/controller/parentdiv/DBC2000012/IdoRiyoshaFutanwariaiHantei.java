/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000012;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000012.DBC2000012StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000012.IdoRiyoshaFutanwariaiHanteiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000012.IdoRiyoshaFutanwariaiHanteiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * IdoRiyoshaFutanwariaiHantei_異動分利用者負担割合判定のクラスです。
 *
 * @reamsid_L DBC-4950-010 liuxiaoyu
 */
public class IdoRiyoshaFutanwariaiHantei {

    private static final RString KEY0 = new RString("key0");
    private static final RString ERRORFLAG_ERROR = new RString("1");
    private static final RString 実行する = new RString("btnBatchRegister");

    /**
     * 画面の初期化です。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<IdoRiyoshaFutanwariaiHanteiDiv> onLoad(IdoRiyoshaFutanwariaiHanteiDiv div) {
        RDateTime 画面起動時_今回終了時間 = getHandler(div).onLoad();
        if (null != 画面起動時_今回終了時間) {
            ViewStateHolder.put(ViewStateKeys.画面起動時_今回終了時間, 画面起動時_今回終了時間);
        } else {
            ViewStateHolder.put(ViewStateKeys.画面起動時_今回終了時間, RDate.getNowDateTime());
        }
        return ResponseData.of(div).setState(DBC2000012StateName.初期表示);
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
        return ResponseData.of(div).setState(DBC2000012StateName.初期表示);
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

    /**
     * 画面状態状態遷移時画面タイトルを設定のイベントです。
     *
     * @param div 画面Div
     * @return ResponseData<IdoRiyoshaFutanwariaiHanteiDiv>
     */
    public ResponseData<IdoRiyoshaFutanwariaiHanteiDiv> onStateTransition(
            IdoRiyoshaFutanwariaiHanteiDiv div) {
        RString errorFlag = DataPassingConverter.deserialize(div.getErrorFlag(), RString.class);
        if (ERRORFLAG_ERROR.equals(errorFlag)) {
            throw new ApplicationException(DbcErrorMessages.年次判定未処理.getMessage());
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する, false);
        return ResponseData.of(div).respond();
    }

    private IdoRiyoshaFutanwariaiHanteiHandler getHandler(IdoRiyoshaFutanwariaiHanteiDiv div) {
        return IdoRiyoshaFutanwariaiHanteiHandler.of(div);
    }
}
