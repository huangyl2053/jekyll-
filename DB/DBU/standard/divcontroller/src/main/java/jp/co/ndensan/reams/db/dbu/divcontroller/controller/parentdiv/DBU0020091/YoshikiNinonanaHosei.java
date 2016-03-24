/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020091;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091.DBU0020091StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091.DBU0020091TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091.YoshikiNinonanaHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020091.YoshikiNinonanaHoseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業報告（月報）補正発行_様式２の７補正のクラス
 */
public class YoshikiNinonanaHosei {

    private static final RString MSG_KOUSIN = new RString("更新");
    private static final RString MSG_SAKUJO = new RString("削除");
    private static final RString MSG_JI = new RString("計");
    private static final RString MSG_JIEGUO = new RString("合計計算結果");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 様式種類_039 = new RString("039");
    private static final RString 様式種類_139 = new RString("139");
    private static final RString 様式種類_239 = new RString("239");
    private static final RString 様式種類_040 = new RString("040");
    private static final RString 様式種類_140 = new RString("140");
    private static final RString 様式種類_240 = new RString("240");

    /**
     * onLoadのメソッド
     *
     * @param div YoshikiNinonanaHoseiDiv
     * @return ResponseData<YoshikiNinonanaHoseiDiv>
     */
    public ResponseData<YoshikiNinonanaHoseiDiv> onLoad(YoshikiNinonanaHoseiDiv div) {
        YoshikiNinonanaHoseiHandler handler = getHandler(div);
        JigyoHokokuGeppoParameter par = new JigyoHokokuGeppoParameter();
        par.set報告年月(new RString("201503"));
        par.set集計年月(new RString("201504"));
        par.set保険者コード(new RString("0010"));
        par.set市町村名称(new RString("張三"));
        ViewStateHolder.put(ViewStateKeys.事業報告基本, par);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
//        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        RString 状態 = new RString("修正");
        ViewStateHolder.put(ViewStateKeys.状態, 状態);
        RString 様式種類 = new RString("039");
//        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        handler.setViewState(引き継ぎデータ);
        handler.onLoad(引き継ぎデータ, 様式種類);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (様式種類.equalsIgnoreCase(様式種類_039)
                    || 様式種類.equalsIgnoreCase(様式種類_139)
                    || 様式種類.equalsIgnoreCase(様式種類_239)) {
                div.getPnlMain().getPnlServive1().setDisabled(true);
                return ResponseData.of(div).setState(DBU0020091StateName.削除状態1);
            } else if (様式種類.equalsIgnoreCase(様式種類_040)
                    || 様式種類.equalsIgnoreCase(様式種類_140)
                    || 様式種類.equalsIgnoreCase(様式種類_240)) {
                div.getPnlMain().getPnlService2().setDisabled(true);
                return ResponseData.of(div).setState(DBU0020091StateName.削除状態2);
            }
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
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
//        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        RString 様式種類 = new RString("039");
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        YoshikiNinonanaHoseiHandler handler = getHandler(div);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)) && !ResponseHolder.isReRequest()) {
            if (様式種類.equalsIgnoreCase(様式種類_039)
                    || 様式種類.equalsIgnoreCase(様式種類_139)
                    || 様式種類.equalsIgnoreCase(様式種類_239)) {
                handler.delete削除状態1(引き継ぎデータ);
                InformationMessage message = new InformationMessage(
                        UrInformationMessages.正常終了.getMessage().getCode(),
                        UrInformationMessages.正常終了.getMessage().replace(MSG_SAKUJO.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else if (様式種類.equalsIgnoreCase(様式種類_040)
                    || 様式種類.equalsIgnoreCase(様式種類_140)
                    || 様式種類.equalsIgnoreCase(様式種類_240)) {
                handler.delete削除状態2(引き継ぎデータ);
                InformationMessage message = new InformationMessage(
                        UrInformationMessages.正常終了.getMessage().getCode(),
                        UrInformationMessages.正常終了.getMessage().replace(MSG_SAKUJO.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト(引き継ぎデータ, 様式種類);

        if (handler.is修正データ無し(修正データリスト) && !ResponseHolder.isReRequest()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }

        if (handler.is整合性チェック_NG()) {
            get処理実行の確認(div);
        } else if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.update(修正データリスト);
            InformationMessage message = new InformationMessage(
                    UrInformationMessages.正常終了.getMessage().getCode(),
                    UrInformationMessages.正常終了.getMessage().replace(MSG_KOUSIN.toString()).evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrInformationMessages.正常終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getMessage(div);
            return ResponseData.of(div).setState(DBU0020091StateName.完了状態);
        }

        return ResponseData.of(div).respond();
    }

    private ResponseData<YoshikiNinonanaHoseiDiv> get処理実行の確認(YoshikiNinonanaHoseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrWarningMessages.相違.getMessage().getCode(),
                    UrWarningMessages.相違.getMessage().replace(
                            MSG_JI.toString(), MSG_JIEGUO.toString()).evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void getMessage(YoshikiNinonanaHoseiDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getPnlKanryo()
                    .getCcdKanryoMessage().setSuccessMessage(new RString(
                                    UrInformationMessages.正常終了.getMessage().replace("削除").evaluate()));
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getPnlKanryo()
                    .getCcdKanryoMessage().setSuccessMessage(new RString(
                                    UrInformationMessages.正常終了.getMessage().replace("更新").evaluate()));
        }
    }

    /**
     * 「該当一覧へ戻る」ボタンの機能処理です。
     *
     * @param div YoshikiNinonanaHoseiDiv
     * @return ResponseData<YoshikiNinonanaHoseiDiv>
     */
    public ResponseData<YoshikiNinonanaHoseiDiv> onClick_btnModBack(YoshikiNinonanaHoseiDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        RString 様式種類 = new RString("039");
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        YoshikiNinonanaHoseiHandler handler = getHandler(div);

        if (DBU0020091StateName.削除状態1.getName()
                .equals(状態) || DBU0020091StateName.削除状態1.getName().equals(状態)) {
            return ResponseData.of(div).forwardWithEventName(DBU0020091TransitionEventName.補正発行検索に戻る).respond();
        }
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト(引き継ぎデータ, 様式種類);

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

    private YoshikiNinonanaHoseiHandler getHandler(YoshikiNinonanaHoseiDiv div) {
        return new YoshikiNinonanaHoseiHandler(div);
    }

}
