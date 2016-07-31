/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020081;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081.DBU0020081StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081.DBU0020081TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiSeigoSeiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020081.YoshikiNinogoHoseiNinorokuHoseiSyuSeiDataHandler;
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
 * @reamsid_L DBU-1100-070 yebangqiang
 */
public class YoshikiNinogoHoseiNinorokuHosei {

    private static final RString 修正_状態 = new RString("更新");
    private static final RString 削除_状態 = new RString("削除");
    private static final RString MSG_SAKJYO = new RString("削除");
    private static final RString MSG_KOSIN = new RString("更新");
    private static final RString MSG_YOSIENKEI = new RString("要支援計");
    private static final RString MSG_YOKAIGOKEI = new RString("要介護計");
    private static final RString MSG_GOKEIKISANKEKA = new RString("合計計算結果");
    private static final RString MSG_GOKEI = new RString("合計");
    private static final RString MSG_YOSIENKEIGOKEI = new RString("要支援計と要介護計の合計計算結果");

    /**
     * 画面ロードメソッドです。
     *
     * @param div 画面DIV
     * @return 画面初期化
     */
    public ResponseData<YoshikiNinogoHoseiNinorokuHoseiDiv> onLoad(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        YoshikiNinogoHoseiNinorokuHoseiHandler handler = YoshikiNinogoHoseiNinorokuHoseiHandler.of(div);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        List<JigyoHokokuTokeiData> 事業報告更新前リスト = handler.initialize(引き継ぎデータ);
        ViewStateHolder.put(ViewStateKeys.様式２の５業報告統計データ_リスト, (Serializable) 事業報告更新前リスト);
        final RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (修正_状態.equals(状態)) {
            return ResponseData.of(div).setState(DBU0020081StateName.修正状態);
        } else if (削除_状態.equals(状態)) {
            handler.disableMainPanel();
            return ResponseData.of(div).setState(DBU0020081StateName.削除状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンをリックして時実行するメソッドです。
     *
     * @param div 画面DIV
     * @return 本画面
     */
    public ResponseData<YoshikiNinogoHoseiNinorokuHoseiDiv> onClick_btnSave(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        YoshikiNinogoHoseiNinorokuHoseiSeigoSeiHandler handler = getSeigoSeiHandler(div);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        List<JigyoHokokuTokeiData> 事業報告更新前リスト = ViewStateHolder.get(
                ViewStateKeys.様式２の５業報告統計データ_リスト, List.class);
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        if (削除_状態.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).delete(事業報告更新前リスト);
            div.getPnlKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(MSG_SAKJYO.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020081StateName.完了状態);
        }

        List<JigyoHokokuTokeiData> 修正データ = getSyuSeiDataHandler(div).get修正データ(事業報告更新前リスト, 様式種類);
        if (修正_状態.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (修正データ.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else {
                return 修正データ更新(div, 修正データ, handler.is予防要支援結果チェック_NG(),
                        handler.is介護要支援結果チェック_NG(), handler.is合計要支援結果チェック_NG());
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<YoshikiNinogoHoseiNinorokuHoseiDiv> 修正データ更新(
            YoshikiNinogoHoseiNinorokuHoseiDiv div, List<JigyoHokokuTokeiData> 修正データ, boolean 予防要支援結果チェック,
            boolean 介護要支援結果チェック, boolean 合計要支援結果チェック) {
        if (!ResponseHolder.isReRequest() && 予防要支援結果チェック) {
            div.set予防要支援結果(RString.EMPTY);
            return ResponseData.of(div).addMessage(
                    UrWarningMessages.相違.getMessage().replace(
                            MSG_YOSIENKEI.toString(), MSG_GOKEIKISANKEKA.toString())).respond();
        } else if (!ResponseHolder.isReRequest() && 介護要支援結果チェック) {
            div.set介護要支援結果(RString.EMPTY);
            return ResponseData.of(div).addMessage(
                    UrWarningMessages.相違.getMessage().replace(
                            MSG_YOKAIGOKEI.toString(), MSG_GOKEIKISANKEKA.toString())).respond();
        } else if (!ResponseHolder.isReRequest() && 合計要支援結果チェック) {
            div.set合計要支援結果(RString.EMPTY);
            return ResponseData.of(div).addMessage(
                    UrWarningMessages.相違.getMessage().replace(
                            MSG_GOKEI.toString(), MSG_YOSIENKEIGOKEI.toString())).respond();
        }
        if (is予防要支援はい(予防要支援結果チェック, div)) {
            div.set予防要支援結果(RString.FULL_SPACE);
            if (介護要支援結果チェック) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                MSG_YOKAIGOKEI.toString(), MSG_GOKEIKISANKEKA.toString())).respond();
            } else if (合計要支援結果チェック) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                MSG_GOKEI.toString(), MSG_YOSIENKEIGOKEI.toString())).respond();
            } else if (!修正データ.isEmpty()) {
                return ResponseData.of(div).addMessage(
                        new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
            }
        } else if (is介護要支援はい(介護要支援結果チェック, div)) {
            div.set介護要支援結果(RString.FULL_SPACE);
            if (合計要支援結果チェック) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                MSG_GOKEI.toString(), MSG_YOSIENKEIGOKEI.toString())).respond();
            } else if (!修正データ.isEmpty()) {
                return ResponseData.of(div).addMessage(
                        new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
            }
        } else if (is合計要支援はい(合計要支援結果チェック, div, 修正データ)) {
            div.set合計要支援結果(RString.FULL_SPACE);
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        ダイアログいいえチェック(予防要支援結果チェック, div, 介護要支援結果チェック, 合計要支援結果チェック);
        if (!ResponseHolder.isReRequest() && !修正データ.isEmpty()) {
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            JigyoHokokuGeppoHoseiHako.createInstance().updateJigyoHokokuGeppoEntity(
                    修正データ);
            div.getPnlKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(MSG_KOSIN.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020081StateName.完了状態);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private void ダイアログいいえチェック(boolean 予防要支援結果チェック, YoshikiNinogoHoseiNinorokuHoseiDiv div,
            boolean 介護要支援結果チェック, boolean 合計要支援結果チェック) {
        if ((new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No)
                || (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                        ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No)) {
            if (予防要支援結果チェック) {
                div.set予防要支援結果(RString.EMPTY);
            }
            if (介護要支援結果チェック) {
                div.set介護要支援結果(RString.EMPTY);
            }
            if (合計要支援結果チェック) {
                div.set合計要支援結果(RString.EMPTY);
            }
        }
    }

    private boolean is合計要支援はい(boolean 合計要支援結果チェック, YoshikiNinogoHoseiNinorokuHoseiDiv div,
            List<JigyoHokokuTokeiData> 修正データ) {
        return new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && 合計要支援結果チェック && div.get合計要支援結果().isNullOrEmpty() && !修正データ.isEmpty();
    }

    private boolean is介護要支援はい(boolean 介護要支援結果チェック, YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && 介護要支援結果チェック && div.get介護要支援結果().isNullOrEmpty();
    }

    private boolean is予防要支援はい(boolean 予防要支援結果チェック, YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && 予防要支援結果チェック && div.get予防要支援結果().isNullOrEmpty();
    }

    /**
     * 戻るボタンをクリックして時実行するメソッドです。
     *
     * @param div 画面DIV
     * @return 該当一覧へ戻る
     */
    public ResponseData<YoshikiNinogoHoseiNinorokuHoseiDiv> onClick_btnBack(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        List<JigyoHokokuTokeiData> 事業報告更新前リスト = ViewStateHolder.get(
                ViewStateKeys.様式２の５業報告統計データ_リスト, List.class);
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        List<JigyoHokokuTokeiData> 修正データ = getSyuSeiDataHandler(div).get修正データ(事業報告更新前リスト, 様式種類);
        if (修正データ.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBU0020081TransitionEventName.補正発行検索に戻る).respond();
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(
                    ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBU0020081TransitionEventName.補正発行検索に戻る).
                        respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private YoshikiNinogoHoseiNinorokuHoseiHandler getHandler(YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return YoshikiNinogoHoseiNinorokuHoseiHandler.of(div);
    }

    private YoshikiNinogoHoseiNinorokuHoseiSeigoSeiHandler getSeigoSeiHandler(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return YoshikiNinogoHoseiNinorokuHoseiSeigoSeiHandler.of(div);
    }

    private YoshikiNinogoHoseiNinorokuHoseiSyuSeiDataHandler getSyuSeiDataHandler(
            YoshikiNinogoHoseiNinorokuHoseiDiv div) {
        return YoshikiNinogoHoseiNinorokuHoseiSyuSeiDataHandler.of(div);
    }
}
