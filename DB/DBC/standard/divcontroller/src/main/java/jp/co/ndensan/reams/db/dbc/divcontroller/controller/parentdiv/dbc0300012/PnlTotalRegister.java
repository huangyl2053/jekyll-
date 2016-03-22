package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0300012;

import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.DBC0300012StateName.saved;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.DBC0300012TransitionEventName.検索に戻る;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.PnlTotalRegisterDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0300012.PnlTotalRegisterHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約事業者登録・追加・修正・照会_登録
 */
public class PnlTotalRegister {

    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");

    /**
     * 初期表示
     *
     * @param div PnlTotalRegisterDiv
     * @return ResponseData
     */
    public ResponseData<PnlTotalRegisterDiv> onLoad(PnlTotalRegisterDiv div) {
        ResponseData<PnlTotalRegisterDiv> responseData = new ResponseData<>();
        PnlTotalRegisterHandler handler = getHandler(div);
        handler.set初期データ();

        responseData.data = div;
        return responseData;
    }

    /**
     * 「保存する」ボタン
     *
     * @param div PnlTotalRegisterDiv
     * @return ResponseData
     */
    public ResponseData<PnlTotalRegisterDiv> onClick_btnSave(PnlTotalRegisterDiv div) {
        PnlTotalRegisterHandler handler = getHandler(div);
        RString states = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (削除.equals(states) || 登録.equals(states)) {
            int result = handler.save画面データ();
            handler.set保存完了(result);
            return ResponseData.of(div).setState(saved);
        }
        boolean changeFlg = false;
        if (!ResponseHolder.isReRequest()) {
            changeFlg = handler.has画面変更有無();
        }
        if (!changeFlg) {
            if (!ResponseHolder.isReRequest()) {
                InformationMessage message = new InformationMessage(
                        DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                        DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            return ResponseData.of(div).respond();
        } else {
            int result = handler.save画面データ();
            handler.set保存完了(result);
            return ResponseData.of(div).setState(saved);
        }
    }

    /**
     * 「取消する」ボタン
     *
     * @param div PnlTotalRegisterDiv
     * @return ResponseData
     */
    public ResponseData<PnlTotalRegisterDiv> onClick_btnCancel(PnlTotalRegisterDiv div) {
        PnlTotalRegisterHandler handler = getHandler(div);
        boolean changeFlg = handler.has画面変更有無();
        if (changeFlg) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
        }
    }

    /**
     * 「契約事業者情報を送付先へコピーする」ボタン
     *
     * @param div PnlTotalRegisterDiv
     * @return ResponseData
     */
    public ResponseData<PnlTotalRegisterDiv> onClick_btnCopy(PnlTotalRegisterDiv div) {
        PnlTotalRegisterHandler handler = getHandler(div);
        handler.copy画面データ();
        return ResponseData.of(div).respond();
    }

    /**
     * Handlerクラスを取得する
     *
     * @param div PnlTotalRegisterDiv
     * @return PnlTotalRegisterHandler
     */
    private PnlTotalRegisterHandler getHandler(PnlTotalRegisterDiv div) {
        return PnlTotalRegisterHandler.of(div);
    }
}
