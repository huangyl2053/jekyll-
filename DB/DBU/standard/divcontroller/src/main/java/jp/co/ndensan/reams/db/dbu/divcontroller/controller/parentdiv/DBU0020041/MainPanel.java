/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020041;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.DBU0020041TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.MainPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0020041.MainPanelHandler;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.DivcontrollerMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICallbackMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.SingleButtonType;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author yebangqiang
 */
public class MainPanel {

    private static final RString 様式種類_008 = new RString("008");
    private static final RString 様式種類_108 = new RString("108");
    private static final RString 様式種類_009 = new RString("009");
    private static final RString 様式種類_109 = new RString("109");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 完了 = new RString("完了");

    /**
     * 画面ロードメソッド
     *
     * @param div
     * @return
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        MainPanelHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
//        RString entity = ViewStateHolder.get(ViewStateKeys.償還払請求パラメータ, XXX.class);
        // TODO entityから様式種類を取得
        RString 引き継ぎデータEntity = new RString("");
        RString 様式種類 = new RString("");
        List<DbT7021JigyoHokokuTokeiDataEntity> 更新前データリスト = handler.get更新前データリスト(引き継ぎデータEntity);
        if (!更新前データリスト.isEmpty()) {
            handler.initializeKihoneria(更新前データリスト.get(0));
            handler.initializeTabList(更新前データリスト, 様式種類);
        }
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            handler.disableMainPanel();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンークをリックして時実行するメソッド
     *
     * @param div
     * @return
     */
    public ResponseData<MainPanelDiv> onClick_btnSave(MainPanelDiv div) {
        MainPanelHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
        // XXX entity = ViewStateHolder.get(ViewStateKeys.償還払請求パラメータ, XXX.class);
        // TODO entityから様式種類を取得
        RString 様式種類 = new RString("");
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (handler.get修正データ(様式種類).isEmpty()) {
                throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
            } else if (様式種類_008.equalsIgnoreCase(様式種類) || 様式種類_108.equalsIgnoreCase(様式種類)) {
                if (!div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuShinseiSu().getValue().add(
                        div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuShinseiSu().getValue()).add(
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuShinseiSu().getValue()).add(
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeiKatsuKaigoShinseiSu().getValue()).add(
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShinseiSu().getValue()).equals(
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiShinseiSu())) {
                    throw new ApplicationException(UrWarningMessages.相違.getMessage().replace("計", "合計計算結果"));
                }
            } else if (様式種類_009.equalsIgnoreCase(様式種類) || 様式種類_109.equalsIgnoreCase(様式種類)) {
                if (handler.is第4段階データ整合(
                        div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouShinseiSu().getValue(),
                        div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouShinseiSu().getValue(),
                        div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiShinseiSu().getValue())
                        || handler.is第4段階データ整合(
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouShokujihiGengakuNinteiSu().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouShokujihiGengakuNinteiSu().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiShokujihiGengakuNinteiSu().getValue())
                        || handler.is第4段階データ整合(
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouShokujiGengakuNinteiKei().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouShokujiGengakuNinteiKei().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiShokujiGengakuNinteiKei().getValue())
                        || handler.is第4段階データ整合(
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouKyojuhiGengakuNinteiSu().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouKyojuhiGengakuNinteiSu().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiKyojuhiGengakuNinteiSu().getValue())
                        || handler.is第4段階データ整合(
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouKyojuhiGengakuNinteiKei().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouKyojuhiGengakuNinteiKei().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiKyojuhiGengakuNinteiKei().getValue())
                        || handler.is第4段階データ整合(
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouSJGengakuNinteiSu().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouSJGengakuNinteiSu().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiSJGengakuNinteiSu().getValue())
                        || handler.is第4段階データ整合(
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouSJGengakuNinteiKei().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouSJGengakuNinteiKei().getValue(),
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiSJGengakuNinteiKei().getValue())) {
                    throw new ApplicationException(UrWarningMessages.相違.getMessage().replace("合計", "合計計算結果"));

                }
            } else if (handler.get修正データ(様式種類).size() > 0) {
                ResponseData<MainPanelDiv> response = new ResponseData<>();
                ICallbackMethod methodYes = DivcontrollerMethod.method(SingleButtonType.Free, "onClick_btnSave_onYes");
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate(), "はい", "いいえ");
                ICallbackMethod[] methods = {methodYes};
                message.addInvokeMethod(methods);
                response.addMessage(message);
                response.data = div;
                return response;
            }

        } else if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            // 「ビジネス設計_DBUMN91003_事業報告（月報）補正発行.xlsx」の「事業報告月報詳細データの削除」を呼び出す
            // 引数：削除条件オブジェクト
            // TODO
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<MainPanelDiv> onClick_btnSave_onYes(MainPanelDiv div) {
        // TODO
        return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
    }

    /**
     * 戻るボタンークをリックして時実行するメソッド
     *
     * @param div
     * @return
     */
    public ResponseData<MainPanelDiv> onClick_btnBack(MainPanelDiv div) {
        MainPanelHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
        // XXX entity = ViewStateHolder.get(ViewStateKeys.償還払請求パラメータ, XXX.class);
        // TODO entityから様式種類を取得
        RString 様式種類 = new RString("");
        if (handler.get修正データ(様式種類).isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBU0020041TransitionEventName.補正発行検索に戻る).respond();
        } else if (handler.get修正データ(様式種類).size() > 0) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return MainPanelHandler.of(div);
    }
}
