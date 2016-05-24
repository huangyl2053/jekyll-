/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020051;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020051.DBU0020051StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020051.DBU0020051TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020051.YoshikiIchinogoHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020051.YoshikiIchinogoHoseiCheckHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020051.YoshikiIchinogoHoseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 画面設計_DBUMN91003_事業報告（月報）補正発行_様式１の５補正
 *
 * @reamsid_L DBU-1100-050 quxiaodong
 */
public class YoshikiIchinogoHosei {

    private static final RString 削除状態 = new RString("削除");
    private static final RString 更新 = new RString("更新");
    private static final RString 合計計算結果 = new RString("合計計算結果");
    private static final RString 要支援計と要介護計の合計計算結果 = new RString("要支援計と要介護計の合計計算結果");
    private static final RString 要支援計 = new RString("要支援計");
    private static final RString 要介護計 = new RString("要介護計");
    private static final RString 合計 = new RString("合計");

    /**
     * 画面初期化処理です
     *
     * @param div YoshikiIchinogoHoseiDiv
     * @return ResponseData
     */
    public ResponseData<YoshikiIchinogoHoseiDiv> onload(YoshikiIchinogoHoseiDiv div) {
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        getHandler(div).set基本情報エリア(引き継ぎデータ, 状態);
        IStateEnumerations stateName = getHandler(div).initialize(引き継ぎデータ, 状態);
        return ResponseData.of(div).setState(stateName);
    }

    /**
     * 「該当一覧へ戻る」ボタンの機能処理です。
     *
     * @param div YoshikiIchinoniIchinosanHoseiDiv
     * @return ResponseData
     */
    public ResponseData<YoshikiIchinogoHoseiDiv> onClick_btnBack(YoshikiIchinogoHoseiDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        if (!ResponseHolder.isReRequest()) {
            if (削除状態.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020051TransitionEventName.補正発行検索に戻る).respond();
            }
            List<JigyoHokokuTokeiData> 修正データリスト = getHandler(div).get修正データリスト(引き継ぎデータ);
            if (null == 修正データリスト || 修正データリスト.isEmpty()) {
                return ResponseData.of(div).forwardWithEventName(DBU0020051TransitionEventName.補正発行検索に戻る).respond();
            }
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBU0020051TransitionEventName.補正発行検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンの機能処理です。
     *
     * @param div YoshikiIchinoniIchinosanHoseiDiv
     * @return ResponseData
     */
    public ResponseData<YoshikiIchinogoHoseiDiv> onClick_btnUpdate(YoshikiIchinogoHoseiDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        if (削除状態.equals(状態)) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).delete(引き継ぎデータ);
                div.getPnlKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                        UrInformationMessages.正常終了.getMessage().replace(削除状態.toString()).evaluate()));
                return ResponseData.of(div).setState(DBU0020051StateName.完了状態);
            }
            if (new RString(UrInformationMessages.正常終了.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())) {
                return ResponseData.of(div).respond();
            }
        }
        List<JigyoHokokuTokeiData> 修正データリスト = getHandler(div).get修正データリスト(引き継ぎデータ);
        if (null == 修正データリスト || 修正データリスト.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }

        if (!getCheckHandler(div).is整合性チェック1() && !ResponseHolder.isReRequest()) {
            WarningMessage message = new WarningMessage(UrWarningMessages.相違.getMessage().getCode(),
                    UrWarningMessages.相違.getMessage().replace(要支援計.toString(), 合計計算結果.toString()).evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (!getCheckHandler(div).is整合性チェック2() && !ResponseHolder.isReRequest()) {
            WarningMessage message = new WarningMessage(UrWarningMessages.相違.getMessage().getCode(),
                    UrWarningMessages.相違.getMessage().replace(要介護計.toString(), 合計計算結果.toString()).evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (!getCheckHandler(div).is整合性チェック3() && !ResponseHolder.isReRequest()) {
            WarningMessage message = new WarningMessage(UrWarningMessages.相違.getMessage().getCode(),
                    UrWarningMessages.相違.getMessage().replace(合計.toString(),
                            要支援計と要介護計の合計計算結果.toString()).evaluate());
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
            getHandler(div).update(修正データリスト);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                    .replace(更新.toString())).respond();
        }
        if (new RString(UrInformationMessages.正常終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getPnlKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(更新.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020051StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    private YoshikiIchinogoHoseiHandler getHandler(YoshikiIchinogoHoseiDiv div) {
        return new YoshikiIchinogoHoseiHandler(div);
    }

    private YoshikiIchinogoHoseiCheckHandler getCheckHandler(YoshikiIchinogoHoseiDiv div) {
        return new YoshikiIchinogoHoseiCheckHandler(div);
    }

}
