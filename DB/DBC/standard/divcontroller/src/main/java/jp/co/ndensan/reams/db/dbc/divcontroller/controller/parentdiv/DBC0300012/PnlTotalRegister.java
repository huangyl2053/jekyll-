package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0300012;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.hokenjuryoininharaitoriatsukai.HokenJuryoIninHaraiToriatsukaiResult;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.DBC0300012StateName.deleted;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.DBC0300012StateName.saved;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.DBC0300012TransitionEventName.処理完了;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.PnlTotalRegisterDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0300012.PnlTotalRegisterHandler;
import jp.co.ndensan.reams.db.dbc.service.report.jyuryoitakuatukaijigyoshatorokutsuchisho.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約事業者登録・追加・修正・照会_登録
 *
 * @reamsid_L DBC-2120-020 panhe
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
        PnlTotalRegisterHandler handler = getHandler(div);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (処理モード == null) {
            処理モード = 登録;
            ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード);
        }
        if (登録.equals(処理モード)) {
            handler.set登録初期データ();
            return ResponseData.of(div).respond();
        }
        JuryoininKeiyakuJigyosha data = ViewStateHolder
                .get(ViewStateKeys.詳細データ, JuryoininKeiyakuJigyosha.class);
        JuryoininKeiyakuJigyosha record = handler.getRecord(data);
        ViewStateHolder.put(ViewStateKeys.詳細データ, record);

        handler.set初期データ(処理モード, record);

        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン
     *
     * @param div PnlTotalRegisterDiv
     * @return ResponseData
     */
    public ResponseData<PnlTotalRegisterDiv> onClick_btnSave(PnlTotalRegisterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        PnlTotalRegisterHandler handler = getHandler(div);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        JuryoininKeiyakuJigyosha data = ViewStateHolder
                .get(ViewStateKeys.詳細データ, JuryoininKeiyakuJigyosha.class);
        if (削除.equals(処理モード) || 登録.equals(処理モード)) {
            int result = handler.save画面データ(処理モード, data);
            handler.set保存完了(処理モード, result);
            if (削除.equals(処理モード)) {
                return ResponseData.of(div).setState(deleted);
            }
            RString 契約事業者番号 = div.getPnlKeyakuJigyosya().getTxtJigyosyakeiyakuNo().getValue();
            ViewStateHolder.put(ViewStateKeys.契約事業者番号, 契約事業者番号);
            return ResponseData.of(div).setState(saved);
        }
        boolean changeFlg = handler.has画面変更有無(処理モード, data);
        if (!changeFlg) {
            InformationMessage message = new InformationMessage(
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else {
            int result = handler.save画面データ(処理モード, data);
            handler.set保存完了(処理モード, result);
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
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        JuryoininKeiyakuJigyosha data = ViewStateHolder
                .get(ViewStateKeys.詳細データ, JuryoininKeiyakuJigyosha.class);
        boolean changeFlg = handler.has画面変更有無(処理モード, data);
        if (changeFlg) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(処理完了).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(処理完了).respond();
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
     * 「発行する」ボタン
     *
     * @param div PnlTotalRegisterDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(PnlTotalRegisterDiv div) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        RString 契約事業者番号;
        if (登録.equals(処理モード)) {
            契約事業者番号 = ViewStateHolder.get(ViewStateKeys.契約事業者番号, RString.class);
        } else {
            JuryoininKeiyakuJigyosha data = ViewStateHolder
                    .get(ViewStateKeys.詳細データ, JuryoininKeiyakuJigyosha.class);
            契約事業者番号 = data.get契約事業者番号();
        }
        HokenJuryoIninHaraiToriatsukaiResult result = getHandler(div).get発行データ(契約事業者番号);
        FlexibleDate 発行日 = new FlexibleDate(div.getPnlHakoubi().getTxtHakoubi().getValue().toDateString());
        return ResponseData.of(new JyuryoItakuAtukaiJigyoshaTorokuTsuchishoPrintService().print(result.getEntity(), 発行日)).respond();
    }

    /**
     * onClick_onBlur
     *
     * @param div PnlTotalRegisterDiv
     * @return ResponseData
     */
    public ResponseData<PnlTotalRegisterDiv> onClick_onBlur(PnlTotalRegisterDiv div) {
        PnlTotalRegisterHandler handler = getHandler(div);
        handler.set送付先口座種別();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_onOkClose
     *
     * @param div PnlTotalRegisterDiv
     * @return ResponseData
     */
    public ResponseData<PnlTotalRegisterDiv> onClick_onOkClose(PnlTotalRegisterDiv div) {
        PnlTotalRegisterHandler handler = getHandler(div);
        handler.set送付先口座種別();
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
