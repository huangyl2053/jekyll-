/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0020021;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.DBU0020021StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.DBU0020021TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.JigyoHokokuGeppoYoshikiIchiHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0020021.JigyoHokokuGeppoYoshikiIchiHoseiHandler;
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
 * 事業報告（月報）補正発行_様式１補正画面です。
 */
public class JigyoHokokuGeppoYoshikiIchiHosei {

    private static final RString MSG_TGHIHOKENSHASU = new RString("当月末現在の被保険者数");
    private static final RString MSG_ZGHIHOKENSHASUKSRESULT = new RString("前月末世帯数から増減した被保険者数の計算結果");
    private static final RString MSG_KOUSIN = new RString("更新");
    private static final RString MSG_SAKUJO = new RString("削除");

    /**
     * 画面初期化処理です。
     *
     * @param div HiHokennshaDiv のクラスファイル。
     * @return ResponseData<HiHokennshaDiv>
     */
    public ResponseData<JigyoHokokuGeppoYoshikiIchiHoseiDiv> onload(JigyoHokokuGeppoYoshikiIchiHoseiDiv div) {
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        JigyoHokokuGeppoYoshikiIchiHoseiHandler handler = getHandler(div);
        handler.setViewState(引き継ぎデータ, 状態);
        handler.onLoad(引き継ぎデータ);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンの機能処理です。(状態_修正の場合)
     *
     * @param div HiHokennshaDiv のクラスファイル。
     * @return ResponseData<HiHokennshaDiv>
     */
    public ResponseData<JigyoHokokuGeppoYoshikiIchiHoseiDiv> onClick_btnModUpdate(JigyoHokokuGeppoYoshikiIchiHoseiDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        JigyoHokokuGeppoYoshikiIchiHoseiHandler handler = getHandler(div);
        if (DBU0020021StateName.削除状態.getName().equals(状態) && !ResponseHolder.isReRequest()) {
            handler.delete(引き継ぎデータ);
            InformationMessage message = new InformationMessage(
                    UrInformationMessages.正常終了.getMessage().getCode(),
                    UrInformationMessages.正常終了.getMessage().replace(MSG_SAKUJO.toString()).evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト(引き継ぎデータ);
        if (handler.is修正データ無し(修正データリスト) && !ResponseHolder.isReRequest()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
        if (handler.is整合性チェック_NG()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrWarningMessages.相違.getMessage().getCode(),
                        UrWarningMessages.相違.getMessage().replace(
                                MSG_TGHIHOKENSHASU.toString(), MSG_ZGHIHOKENSHASUKSRESULT.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
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
            return ResponseData.of(div).setState(DBU0020021StateName.完了状態);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「該当一覧へ戻る」ボタンの機能処理です。(状態_修正の場合)
     *
     * @param div HiHokennshaDiv のクラスファイル。
     * @return ResponseData<HiHokennshaDiv>
     */
    public ResponseData<JigyoHokokuGeppoYoshikiIchiHoseiDiv> onClick_btnModBack(JigyoHokokuGeppoYoshikiIchiHoseiDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.被保険者, JigyoHokokuGeppoParameter.class);
        JigyoHokokuGeppoYoshikiIchiHoseiHandler handler = getHandler(div);
        if (DBU0020021StateName.削除状態.getName().equals(状態)) {
            return ResponseData.of(div).forwardWithEventName(DBU0020021TransitionEventName.補正発行検索に戻る).respond();
        }
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト(引き継ぎデータ);
        if (handler.is修正データ無し(修正データリスト)) {
            return ResponseData.of(div).forwardWithEventName(DBU0020021TransitionEventName.補正発行検索に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBU0020021TransitionEventName.補正発行検索に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private JigyoHokokuGeppoYoshikiIchiHoseiHandler getHandler(JigyoHokokuGeppoYoshikiIchiHoseiDiv parentDiv) {
        return new JigyoHokokuGeppoYoshikiIchiHoseiHandler(parentDiv);
    }
}
