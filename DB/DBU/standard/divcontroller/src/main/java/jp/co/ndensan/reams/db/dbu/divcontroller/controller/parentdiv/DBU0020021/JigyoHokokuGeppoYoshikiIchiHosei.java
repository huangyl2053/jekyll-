/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020021;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.DBU0020021StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.DBU0020021TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021.JigyoHokokuGeppoYoshikiIchiHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020021.JigyoHokokuGeppoYoshikiIchiHoseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
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
 * 事業報告（月報）補正発行_様式１補正画面です。
 *
 * @reamsid_L DBU-1100-060 zhangrui
 */
public class JigyoHokokuGeppoYoshikiIchiHosei {

    private static final RString MSG_TGHIHOKENSHASU = new RString("当月末現在の被保険者数");
    private static final RString MSG_ZGHIHOKENSHASUKSRESULT = new RString("前月末世帯数から増減した被保険者数の計算結果");
    private static final RString MSG_KOUSIN = new RString("更新");
    private static final RString MSG_SAKUJO = new RString("削除");
    private static final RString KEY_第1号被保険者数情報 = new RString("第1号被保険者数情報");
    private static final RString KEY_第1号被保険者増減内訳情報_当月中増 = new RString("第1号被保険者増減内訳情報_当月中増");
    private static final RString KEY_第1号被保険者増減内訳情報_当月中滅 = new RString("第1号被保険者増減内訳情報_当月中滅");

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
        Map<RString, List<JigyoHokokuTokeiData>> resultMap = handler.onLoad(引き継ぎデータ);
        ViewStateHolder.put(ViewStateKeys.第1号被保険者数情報, (Serializable) resultMap.get(KEY_第1号被保険者数情報));
        ViewStateHolder.put(ViewStateKeys.第1号被保険者増減内訳情報_当月中増,
                (Serializable) resultMap.get(KEY_第1号被保険者増減内訳情報_当月中増));
        ViewStateHolder.put(ViewStateKeys.第1号被保険者増減内訳情報_当月中滅,
                (Serializable) resultMap.get(KEY_第1号被保険者増減内訳情報_当月中滅));
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
        List<JigyoHokokuTokeiData> 第1号被保険者数情報
                = ViewStateHolder.get(ViewStateKeys.第1号被保険者数情報, List.class);
        List<JigyoHokokuTokeiData> 第1号被保険者増減内訳情報_当月中増
                = ViewStateHolder.get(ViewStateKeys.第1号被保険者増減内訳情報_当月中増, List.class);
        List<JigyoHokokuTokeiData> 第1号被保険者増減内訳情報_当月中滅
                = ViewStateHolder.get(ViewStateKeys.第1号被保険者増減内訳情報_当月中滅, List.class);
        JigyoHokokuGeppoYoshikiIchiHoseiHandler handler = getHandler(div);
        if (MSG_SAKUJO.equals(状態) && !ResponseHolder.isReRequest()) {
            handler.delete(第1号被保険者数情報);
            handler.delete(第1号被保険者増減内訳情報_当月中増);
            handler.delete(第1号被保険者増減内訳情報_当月中滅);
            div.getKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(MSG_SAKUJO.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020021StateName.完了状態);
        }
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト(
                第1号被保険者数情報, 第1号被保険者増減内訳情報_当月中増, 第1号被保険者増減内訳情報_当月中滅);
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
            div.getKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(MSG_KOUSIN.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020021StateName.完了状態);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「該当一覧へ戻る」ボタンの機能処理です。(状態_修正の場合)
     *
     * @param div HiHokennshaDiv のクラスファイル。
     * @return ResponseData<HiHokennshaDiv>
     */
    public ResponseData<JigyoHokokuGeppoYoshikiIchiHoseiDiv> onClick_btnModBack(JigyoHokokuGeppoYoshikiIchiHoseiDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        JigyoHokokuGeppoYoshikiIchiHoseiHandler handler = getHandler(div);
        if (MSG_SAKUJO.equals(状態)) {
            return ResponseData.of(div).forwardWithEventName(DBU0020021TransitionEventName.補正発行検索に戻る).respond();
        }
        List<JigyoHokokuTokeiData> 第1号被保険者数情報
                = ViewStateHolder.get(ViewStateKeys.第1号被保険者数情報, List.class);
        List<JigyoHokokuTokeiData> 第1号被保険者増減内訳情報_当月中増
                = ViewStateHolder.get(ViewStateKeys.第1号被保険者増減内訳情報_当月中増, List.class);
        List<JigyoHokokuTokeiData> 第1号被保険者増減内訳情報_当月中滅
                = ViewStateHolder.get(ViewStateKeys.第1号被保険者増減内訳情報_当月中滅, List.class);
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト(第1号被保険者数情報,
                第1号被保険者増減内訳情報_当月中増, 第1号被保険者増減内訳情報_当月中滅
        );
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
