/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020091;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091.DBU0020091StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091.DBU0020091TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091.YoshikiNinonanaHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020091.YoshikiNinonanaHoseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業報告（月報）補正発行_様式２の７補正のクラスです。
 *
 * @reamsid_L DBU-1100-080 lijunjun
 */
public class YoshikiNinonanaHosei {

    private static final RString MSG_KEE = new RString("計");
    private static final RString MSG_GOUKEIKEISANNKEKKA = new RString("合計計算結果");
    private static final RString 更新 = new RString("更新");
    private static final RString 削除 = new RString("削除");
    private static final RString 様式種類_039 = new RString("039");
    private static final RString 様式種類_139 = new RString("139");
    private static final RString 様式種類_239 = new RString("239");
    private static final RString 様式種類_040 = new RString("040");
    private static final RString 様式種類_140 = new RString("140");
    private static final RString 様式種類_240 = new RString("240");
    private static final Code 集計番号_0701 = new Code("0701");
    private static final Code 集計番号_0702 = new Code("0702");
    private static final Code 集計番号_0703 = new Code("0703");
    private static final Code 集計番号_0704 = new Code("0704");
    private static final Code 集計番号_0705 = new Code("0705");
    private static final Code 集計番号_0706 = new Code("0706");
    private static final Code 集計番号_0707 = new Code("0707");
    private static final Code 集計番号_0801 = new Code("0801");
    private static final Code 集計番号_0802 = new Code("0802");
    private static final Code 集計番号_0803 = new Code("0803");
    private static final Code 集計番号_0804 = new Code("0804");
    private static final Code 集計番号_0805 = new Code("0805");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div YoshikiNinonanaHoseiDiv
     * @return ResponseData<YoshikiNinonanaHoseiDiv>
     */
    public ResponseData<YoshikiNinonanaHoseiDiv> onLoad(YoshikiNinonanaHoseiDiv div) {
        YoshikiNinonanaHoseiHandler handler = getHandler(div);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        handler.setViewState(引き継ぎデータ);
        handler.onLoad(引き継ぎデータ, 様式種類);
        set高額介護(div);
        set高額医療合算介護(div);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (様式種類.equalsIgnoreCase(様式種類_039)
                    || 様式種類.equalsIgnoreCase(様式種類_139)
                    || 様式種類.equalsIgnoreCase(様式種類_239)) {
                handler.setServive1非活性();
                return ResponseData.of(div).setState(DBU0020091StateName.削除状態1);
            } else if (様式種類.equalsIgnoreCase(様式種類_040)
                    || 様式種類.equalsIgnoreCase(様式種類_140)
                    || 様式種類.equalsIgnoreCase(様式種類_240)) {
                handler.setServive2非活性();
                return ResponseData.of(div).setState(DBU0020091StateName.削除状態2);
            }
        }
        if (更新.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (様式種類.equalsIgnoreCase(様式種類_039)
                    || 様式種類.equalsIgnoreCase(様式種類_139)
                    || 様式種類.equalsIgnoreCase(様式種類_239)) {
                return ResponseData.of(div).setState(DBU0020091StateName.修正状態1);
            } else if (様式種類.equalsIgnoreCase(様式種類_040)
                    || 様式種類.equalsIgnoreCase(様式種類_140)
                    || 様式種類.equalsIgnoreCase(様式種類_240)) {
                return ResponseData.of(div).setState(DBU0020091StateName.修正状態2);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンの機能処理です。
     *
     * @param div YoshikiNinonanaHoseiDiv
     * @return ResponseData<YoshikiNinonanaHoseiDiv>
     */
    public ResponseData<YoshikiNinonanaHoseiDiv> onClick_btnModUpdate(YoshikiNinonanaHoseiDiv div) {
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        YoshikiNinonanaHoseiHandler handler = getHandler(div);
        List<JigyoHokokuTokeiData> 利用者負担第四段階 = ViewStateHolder.get(ViewStateKeys.利用者負担第四段階, List.class);
        List<JigyoHokokuTokeiData> 利用者負担第三段階 = ViewStateHolder.get(ViewStateKeys.利用者負担第三段階, List.class);
        List<JigyoHokokuTokeiData> 利用者負担第二段階 = ViewStateHolder.get(ViewStateKeys.利用者負担第二段階, List.class);
        List<JigyoHokokuTokeiData> 利用者負担第一段階 = ViewStateHolder.get(ViewStateKeys.利用者負担第一段階, List.class);
        List<JigyoHokokuTokeiData> 高額介護_合計 = ViewStateHolder.get(ViewStateKeys.高額介護_合計, List.class);
        List<JigyoHokokuTokeiData> 再掲利用者負担第三段階 = ViewStateHolder.get(ViewStateKeys.再掲利用者負担第三段階, List.class);
        List<JigyoHokokuTokeiData> 再掲利用者負担第二段階 = ViewStateHolder.get(ViewStateKeys.再掲利用者負担第二段階, List.class);

        List<JigyoHokokuTokeiData> 現役並み所得者 = ViewStateHolder.get(ViewStateKeys.現役並み所得者, List.class);
        List<JigyoHokokuTokeiData> 一般 = ViewStateHolder.get(ViewStateKeys.一般, List.class);
        List<JigyoHokokuTokeiData> 低所得者Ⅱ = ViewStateHolder.get(ViewStateKeys.低所得者Ⅱ, List.class);
        List<JigyoHokokuTokeiData> 低所得者Ⅰ = ViewStateHolder.get(ViewStateKeys.低所得者Ⅰ, List.class);
        List<JigyoHokokuTokeiData> 高額医療合算介護_合計 = ViewStateHolder.get(ViewStateKeys.高額医療合算介護_合計, List.class);

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)) && !ResponseHolder.isReRequest()) {

            handler.delete(利用者負担第四段階);
            handler.delete(利用者負担第三段階);
            handler.delete(利用者負担第二段階);
            handler.delete(利用者負担第一段階);
            handler.delete(高額介護_合計);
            handler.delete(再掲利用者負担第三段階);
            handler.delete(再掲利用者負担第二段階);
            handler.delete(現役並み所得者);
            handler.delete(一般);
            handler.delete(低所得者Ⅱ);
            handler.delete(低所得者Ⅰ);
            handler.delete(高額医療合算介護_合計);
            handler.show削除正常終了();
            return ResponseData.of(div).setState(DBU0020091StateName.完了状態);
        }
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト(引き継ぎデータ,
                様式種類, 利用者負担第四段階, 利用者負担第三段階, 利用者負担第二段階, 利用者負担第一段階,
                高額介護_合計, 再掲利用者負担第三段階, 再掲利用者負担第二段階, 現役並み所得者,
                一般, 低所得者Ⅱ, 低所得者Ⅰ, 高額医療合算介護_合計);
        if (handler.is修正データ無し(修正データリスト) && !ResponseHolder.isReRequest()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
        if (handler.is整合性チェック_NG() && !ResponseHolder.isReRequest()) {
            WarningMessage message = new WarningMessage(UrWarningMessages.相違.getMessage().getCode(),
                    UrWarningMessages.相違.getMessage().replace(
                            MSG_KEE.toString(), MSG_GOUKEIKEISANNKEKKA.toString()).evaluate());
            return ResponseData.of(div).addMessage(message).respond();

        }
        if (new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.update(修正データリスト);
            handler.show更新正常終了();
            return ResponseData.of(div).setState(DBU0020091StateName.完了状態);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「該当一覧へ戻る」ボタンの機能処理です。
     *
     * @param div YoshikiNinonanaHoseiDiv
     * @return ResponseData<YoshikiNinonanaHoseiDiv>
     */
    public ResponseData<YoshikiNinonanaHoseiDiv> onClick_btnModBack(YoshikiNinonanaHoseiDiv div) {
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        List<JigyoHokokuTokeiData> 利用者負担第四段階 = ViewStateHolder.get(ViewStateKeys.利用者負担第四段階, List.class);
        List<JigyoHokokuTokeiData> 利用者負担第三段階 = ViewStateHolder.get(ViewStateKeys.利用者負担第三段階, List.class);
        List<JigyoHokokuTokeiData> 利用者負担第二段階 = ViewStateHolder.get(ViewStateKeys.利用者負担第二段階, List.class);
        List<JigyoHokokuTokeiData> 利用者負担第一段階 = ViewStateHolder.get(ViewStateKeys.利用者負担第一段階, List.class);
        List<JigyoHokokuTokeiData> 高額介護_合計 = ViewStateHolder.get(ViewStateKeys.高額介護_合計, List.class);
        List<JigyoHokokuTokeiData> 再掲利用者負担第三段階 = ViewStateHolder.get(ViewStateKeys.再掲利用者負担第三段階, List.class);
        List<JigyoHokokuTokeiData> 再掲利用者負担第二段階 = ViewStateHolder.get(ViewStateKeys.再掲利用者負担第二段階, List.class);

        List<JigyoHokokuTokeiData> 現役並み所得者 = ViewStateHolder.get(ViewStateKeys.現役並み所得者, List.class);
        List<JigyoHokokuTokeiData> 一般 = ViewStateHolder.get(ViewStateKeys.一般, List.class);
        List<JigyoHokokuTokeiData> 低所得者Ⅱ = ViewStateHolder.get(ViewStateKeys.低所得者Ⅱ, List.class);
        List<JigyoHokokuTokeiData> 低所得者Ⅰ = ViewStateHolder.get(ViewStateKeys.低所得者Ⅰ, List.class);
        List<JigyoHokokuTokeiData> 高額医療合算介護_合計 = ViewStateHolder.get(ViewStateKeys.高額医療合算介護_合計, List.class);
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        YoshikiNinonanaHoseiHandler handler = getHandler(div);
        if (DBU0020091StateName.削除状態1.getName()
                .equals(状態) || DBU0020091StateName.削除状態1.getName().equals(状態)) {
            return ResponseData.of(div).forwardWithEventName(DBU0020091TransitionEventName.補正発行検索に戻る).respond();
        }
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト(引き継ぎデータ,
                様式種類, 利用者負担第四段階, 利用者負担第三段階, 利用者負担第二段階, 利用者負担第一段階,
                高額介護_合計, 再掲利用者負担第三段階, 再掲利用者負担第二段階, 現役並み所得者, 一般, 低所得者Ⅱ,
                低所得者Ⅰ, 高額医療合算介護_合計);
        if (handler.is修正データ無し(修正データリスト)) {
            return ResponseData.of(div).forwardWithEventName(DBU0020091TransitionEventName.補正発行検索に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBU0020091TransitionEventName.補正発行検索に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * set高額介護
     *
     * @param div YoshikiNinonanaHoseiDiv
     */
    public void set高額介護(YoshikiNinonanaHoseiDiv div) {
        YoshikiNinonanaHoseiHandler handler = getHandler(div);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
        List<JigyoHokokuTokeiData> 利用者負担第四段階 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0701);
        List<JigyoHokokuTokeiData> 利用者負担第三段階 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0702);
        List<JigyoHokokuTokeiData> 利用者負担第二段階 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0703);
        List<JigyoHokokuTokeiData> 利用者負担第一段階 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0704);
        List<JigyoHokokuTokeiData> 高額介護_合計 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0705);
        List<JigyoHokokuTokeiData> 再掲利用者負担第三段階 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0706);
        List<JigyoHokokuTokeiData> 再掲利用者負担第二段階 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0707);
        ViewStateHolder.put(ViewStateKeys.利用者負担第四段階, (Serializable) 利用者負担第四段階);
        ViewStateHolder.put(ViewStateKeys.利用者負担第三段階, (Serializable) 利用者負担第三段階);
        ViewStateHolder.put(ViewStateKeys.利用者負担第二段階, (Serializable) 利用者負担第二段階);
        ViewStateHolder.put(ViewStateKeys.利用者負担第一段階, (Serializable) 利用者負担第一段階);
        ViewStateHolder.put(ViewStateKeys.高額介護_合計, (Serializable) 高額介護_合計);
        ViewStateHolder.put(ViewStateKeys.再掲利用者負担第三段階, (Serializable) 再掲利用者負担第三段階);
        ViewStateHolder.put(ViewStateKeys.再掲利用者負担第二段階, (Serializable) 再掲利用者負担第二段階);
    }

    /**
     * set高額医療合算介護
     *
     * @param div YoshikiNinonanaHoseiDiv
     */
    public void set高額医療合算介護(YoshikiNinonanaHoseiDiv div) {
        YoshikiNinonanaHoseiHandler handler = getHandler(div);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
        List<JigyoHokokuTokeiData> 現役並み所得者 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0801);
        List<JigyoHokokuTokeiData> 一般 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0802);
        List<JigyoHokokuTokeiData> 低所得者Ⅱ = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0803);
        List<JigyoHokokuTokeiData> 低所得者Ⅰ = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0804);
        List<JigyoHokokuTokeiData> 高額医療合算介護_合計 = handler.get事業報告月報詳細データリスト(
                引き継ぎデータ, 集計番号_0805);
        ViewStateHolder.put(ViewStateKeys.現役並み所得者, (Serializable) 現役並み所得者);
        ViewStateHolder.put(ViewStateKeys.一般, (Serializable) 一般);
        ViewStateHolder.put(ViewStateKeys.低所得者Ⅱ, (Serializable) 低所得者Ⅱ);
        ViewStateHolder.put(ViewStateKeys.低所得者Ⅰ, (Serializable) 低所得者Ⅰ);
        ViewStateHolder.put(ViewStateKeys.高額医療合算介護_合計, (Serializable) 高額医療合算介護_合計);
    }

    private YoshikiNinonanaHoseiHandler getHandler(YoshikiNinonanaHoseiDiv div) {
        return new YoshikiNinonanaHoseiHandler(div);
    }

}
