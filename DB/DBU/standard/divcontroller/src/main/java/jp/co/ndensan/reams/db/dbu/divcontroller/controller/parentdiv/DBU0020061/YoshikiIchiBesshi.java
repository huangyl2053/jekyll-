/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020061;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061.DBU0020061TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061.YoshikiIchiBesshiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0020061.YoshikiIchiBesshiHandler;
import jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業報告（月報）補正発行_様式１(別紙)のクラス
 */
public class YoshikiIchiBesshi {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * 画面ロードメソッド
     *
     * @param div YoshikiIchiBesshiDiv
     * @return ResponseData<YoshikiIchiBesshiDiv>
     */
    public ResponseData<YoshikiIchiBesshiDiv> onLoad(YoshikiIchiBesshiDiv div) {
        YoshikiIchiBesshiHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
        RString 引き継ぎデータEntity = new RString(" ");
        List<JigyoHokokuTokeiData> 更新前データリスト = handler.get更新前データリスト();
        if (!更新前データリスト.isEmpty()) {
            handler.initializeKihoneria(更新前データリスト.get(0));
            handler.更新前データリスト初期化(更新前データリスト);
        }
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンークをリックして時実行するメソッド
     *
     * @param div YoshikiIchiBesshiDiv
     * @return ResponseData<YoshikiIchiBesshiDiv>
     */
    public ResponseData<YoshikiIchiBesshiDiv> onClick_btnSave(YoshikiIchiBesshiDiv div) {
        YoshikiIchiBesshiHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
        // RString entity = ViewStateHolder.get(ViewStateKeys.償還払請求パラメータ, XXX.class);
//        RString 引き継ぎデータEntity = new RString("");
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト();
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (修正データリスト.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            }
            handler.世帯数整合性チェック(div);
            if (修正データリスト.size() > 0) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
            }
            JigyoHokokuGeppoHoseiHako.createInstance().updateJigyoHokokuGeppoData(
                    修正データリスト);
        } else if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            JigyoHokokuGeppoHoseiHako.createInstance().deleteJigyoHokokuGeppoData(
                    修正データリスト);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンークをリックして時実行するメソッド
     *
     * @param div YoshikiIchiBesshiDiv
     * @return ResponseData<YoshikiIchiBesshiDiv>
     */
    public ResponseData<YoshikiIchiBesshiDiv> onClick_btnBack(YoshikiIchiBesshiDiv div) {
        YoshikiIchiBesshiHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
//        RString 引き継ぎデータentity = new RString("");
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト();
        if (修正データリスト.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(
                    DBU0020061TransitionEventName.補正発行検索に戻る).respond();
        } else if (修正データリスト.size() > 0) {

            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(
                        DBU0020061TransitionEventName.補正発行検索に戻る).respond();
            }

        }
        return ResponseData.of(div).respond();
    }

    private YoshikiIchiBesshiHandler getHandler(YoshikiIchiBesshiDiv div) {
        return YoshikiIchiBesshiHandler.of(div);
    }

}
