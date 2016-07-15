/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020041;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.DBU0020041StateName;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.DBU0020041StateName.修正状態1;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.DBU0020041StateName.修正状態2;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.DBU0020041StateName.削除状態3;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.DBU0020041StateName.削除状態4;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.DBU0020041TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.YoshikiIchinoyonHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020041.YoshikiIchinoyonHoseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * Mainパーネルクラスです。
 *
 * @reamsid_L DBU-1100-040 yebangqiang
 */
public class YoshikiIchinoyonHosei {

    private static final RString 様式種類_008 = new RString("008");
    private static final RString 様式種類_108 = new RString("108");
    private static final RString 様式種類_009 = new RString("009");
    private static final RString 様式種類_109 = new RString("109");
    private static final RString 修正_状態 = new RString("更新");
    private static final RString 削除_状態 = new RString("削除");
    private static final RString MSG_SAKJYO = new RString("削除");
    private static final RString MSG_KOSIN = new RString("更新");
    private static final RString MSG_KEI = new RString("計");
    private static final RString MSG_GOKEI = new RString("合計");
    private static final RString MSG_GOKEIKEKA = new RString("合計計算結果");

    /**
     * 画面ロードメソッドです。
     *
     * @param div 画面DIV
     * @return 画面初期化
     */
    public ResponseData<YoshikiIchinoyonHoseiDiv> onLoad(YoshikiIchinoyonHoseiDiv div) {
        YoshikiIchinoyonHoseiHandler handler = getHandler(div);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        List<JigyoHokokuTokeiData> 更新前データリスト = handler.get更新前データリスト(引き継ぎデータ, 様式種類);
        handler.initializeKihoneria(引き継ぎデータ);
        handler.initializeTabList(更新前データリスト, 様式種類);
        ViewStateHolder.put(ViewStateKeys.様式１の４業報告統計データ_リスト, (Serializable) 更新前データリスト);
        final RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正_状態.equals(状態)) {
            if (様式種類_008.equals(様式種類) || 様式種類_108.equals(様式種類)) {
                return ResponseData.of(div).setState(修正状態1);
            } else if (様式種類_009.equals(様式種類) || 様式種類_109.equals(様式種類)) {
                return ResponseData.of(div).setState(修正状態2);
            }
        } else if (削除_状態.equals(状態)) {
            handler.disableMainPanel();
            if (様式種類_008.equals(様式種類) || 様式種類_108.equals(様式種類)) {
                return ResponseData.of(div).setState(削除状態3);
            } else if (様式種類_009.equals(様式種類) || 様式種類_109.equals(様式種類)) {
                return ResponseData.of(div).setState(削除状態4);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンをリックして時実行するメソッドです。
     *
     * @param div 画面DIV
     * @return 本画面
     */
    public ResponseData<YoshikiIchinoyonHoseiDiv> onClick_btnSave(YoshikiIchinoyonHoseiDiv div) {
        YoshikiIchinoyonHoseiHandler handler = getHandler(div);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        List<JigyoHokokuTokeiData> 業報告統計データ = ViewStateHolder.get(
                ViewStateKeys.様式１の４業報告統計データ_リスト, List.class);
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        if (削除_状態.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            handler.delete(業報告統計データ);
            div.getKanryoMessage().getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(MSG_SAKJYO.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020041StateName.完了状態);
        }

        List<JigyoHokokuTokeiData> 修正データ = handler.get修正データ(業報告統計データ, 様式種類);
        if (修正_状態.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (修正データ.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else if (様式種類_008.equals(様式種類) || 様式種類_108.equals(様式種類)) {
                return 修正データ更新(handler.is合計結果チェック_NG(div), div, 修正データ, 様式種類);
            } else if (様式種類_009.equals(様式種類) || 様式種類_109.equals(様式種類)) {
                return 修正データ更新(handler.is整合性チェック_NG(handler, div), div, 修正データ, 様式種類);
            }
        }
        return ResponseData.of(div).setState(DBU0020041StateName.完了状態);
    }

    private ResponseData<YoshikiIchinoyonHoseiDiv> 修正データ更新(boolean チェック結果, YoshikiIchinoyonHoseiDiv div,
            List<JigyoHokokuTokeiData> 修正データ, RString 様式種類) {
        if (チェック結果) {
            if (!ResponseHolder.isReRequest() && (様式種類_008.equals(様式種類) || 様式種類_108.equals(様式種類))) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                MSG_KEI.toString(), MSG_GOKEIKEKA.toString())).respond();
            } else if (!ResponseHolder.isReRequest() && (様式種類_009.equals(様式種類) || 様式種類_109.equals(様式種類))) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                MSG_GOKEI.toString(), MSG_GOKEIKEKA.toString())).respond();
            }
            if (new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                    && !修正データ.isEmpty()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        } else if (!ResponseHolder.isReRequest() && !修正データ.isEmpty()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            JigyoHokokuGeppoHoseiHako.createInstance().updateJigyoHokokuGeppoEntity(
                    修正データ);
            div.getKanryoMessage().getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(MSG_KOSIN.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020041StateName.完了状態);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 戻るボタンをリックして時実行するメソッドです。
     *
     * @param div 画面DIV
     * @return 該当一覧へ戻る
     */
    public ResponseData<YoshikiIchinoyonHoseiDiv> onClick_btnBack(YoshikiIchinoyonHoseiDiv div) {
        YoshikiIchinoyonHoseiHandler handler = getHandler(div);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        List<JigyoHokokuTokeiData> 業報告統計データ = ViewStateHolder.get(
                ViewStateKeys.様式１の４業報告統計データ_リスト, List.class);
        final List<JigyoHokokuTokeiData> 修正データ = handler.get修正データ(業報告統計データ, 様式種類);
        if (修正データ.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBU0020041TransitionEventName.補正発行検索に戻る).respond();
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBU0020041TransitionEventName.補正発行検索に戻る).
                        respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private YoshikiIchinoyonHoseiHandler getHandler(YoshikiIchinoyonHoseiDiv div) {
        return YoshikiIchinoyonHoseiHandler.of(div);
    }
}
