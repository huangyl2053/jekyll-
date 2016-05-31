/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020071;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.DBU0020071StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.DBU0020071TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuCheckHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuLoadHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuDataHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuLoadHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuCheckHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuDataHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuLoadHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuCheckHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuDataHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuLoadHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
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
 * 事業報告（月報）補正発行_様式２件数、単位数補正、費用額、給付費補正のクラス
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class HoseiHakkoYoshiki2KensuEtcTotalPanel {

    private static final RString 削除 = new RString("削除");
    private static final RString 更新 = new RString("更新");
    private static final RString 合計 = new RString("合計");
    private static final RString 要支援計 = new RString("要支援計");
    private static final RString 要介護計 = new RString("要介護計");
    private static final RString 合計計算結果 = new RString("合計計算結果");
    private static final RString 要支援計と要介護計の合計計算結果 = new RString("要支援計と要介護計の合計計算結果");

    /**
     * 画面初期化です。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     * @return ResponseData<HoseiHakkoYoshiki2KensuEtcTotalPanelDiv>
     */
    public ResponseData<HoseiHakkoYoshiki2KensuEtcTotalPanelDiv> onLoad(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuLoadHandler handler = getHandler(div);
        HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuLoadHandler handler4 = getHandler4(div);
        HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuLoadHandler handler5 = getHandler5(div);
        HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuLoadHandler handler6 = getHandler6(div);

        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
        handler.setViewState(引き継ぎデータ);

        handler.件数OnLoad(引き継ぎデータ);
        handler4.単位数OnLoad(引き継ぎデータ);
        handler5.費用額OnLoad(引き継ぎデータ);
        handler6.給付額OnLoad(引き継ぎデータ);

        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (更新.equals(状態)) {
            return ResponseData.of(div).setState(DBU0020071StateName.修正状態);
        } else if (削除.equals(状態)) {
            div.getPnlMain().setReadOnly(true);
            return ResponseData.of(div).setState(DBU0020071StateName.削除状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 更新処理
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     * @return ResponseData<HoseiHakkoYoshiki2KensuEtcTotalPanelDiv>
     */
    public ResponseData<HoseiHakkoYoshiki2KensuEtcTotalPanelDiv> onClick_btnModUpdate(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuLoadHandler handler = getHandler(div);
        HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuDataHandler handler2 = getHandler2(div);

        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)) && !ResponseHolder.isReRequest()) {
            handler.delete(引き継ぎデータ);
            div.getPnlKanryo()
                    .getCcdKanryoMessage().setSuccessMessage(new RString(
                                    UrInformationMessages.正常終了.getMessage().replace(削除.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020071StateName.完了状態);

        }
        List<JigyoHokokuTokeiData> 修正データリスト = get修正データ(div);
        if (handler2.is修正データ無し(修正データリスト) && !ResponseHolder.isReRequest()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        } else {
            return 修正データ更新(div, 修正データリスト, 整合性チェックNG_予防給付(div), 整合性チェックNG_介護給付(div), 整合性チェックNG_合計(div));
        }
    }

    private ResponseData<HoseiHakkoYoshiki2KensuEtcTotalPanelDiv> 修正データ更新(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div,
            List<JigyoHokokuTokeiData> 修正データリスト,
            boolean 整合性チェックNG_予防給付,
            boolean 整合性チェックNG_介護給付,
            boolean 整合性チェックNG_合計) {
        if (!ResponseHolder.isReRequest() && 整合性チェックNG_予防給付) {
            div.getPnlMain().set予防給付(RString.EMPTY);
            return ResponseData.of(div).addMessage(
                    UrWarningMessages.相違.getMessage().replace(
                            要支援計.toString(), 合計計算結果.toString())).respond();
        } else if (!ResponseHolder.isReRequest() && 整合性チェックNG_介護給付) {
            div.getPnlMain().set介護給付(RString.EMPTY);
            return ResponseData.of(div).addMessage(
                    UrWarningMessages.相違.getMessage().replace(
                            要介護計.toString(), 合計計算結果.toString())).respond();
        } else if (!ResponseHolder.isReRequest() && 整合性チェックNG_合計) {
            div.getPnlMain().set合計(RString.EMPTY);
            return ResponseData.of(div).addMessage(
                    UrWarningMessages.相違.getMessage().replace(
                            合計.toString(), 要支援計と要介護計の合計計算結果.toString())).respond();
        }

        if (整合性チェック_予防給付_はい(整合性チェックNG_予防給付, div)) {
            div.getPnlMain().set予防給付(RString.HALF_SPACE);
            if (整合性チェックNG_介護給付) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                要介護計.toString(), 合計計算結果.toString())).respond();
            } else if (整合性チェックNG_合計) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                合計.toString(), 要支援計と要介護計の合計計算結果.toString())).respond();
            } else {
                return ResponseData.of(div).addMessage(
                        new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
            }
        } else if (整合性チェック_介護給付_はい(整合性チェックNG_介護給付, div)) {
            div.getPnlMain().set介護給付(RString.HALF_SPACE);
            if (整合性チェックNG_合計) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                合計.toString(), 要支援計と要介護計の合計計算結果.toString())).respond();
            } else {
                return ResponseData.of(div).addMessage(
                        new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
            }
        } else if (整合性チェック_合計_はい(整合性チェックNG_合計, div)) {
            div.getPnlMain().set合計(RString.HALF_SPACE);
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            JigyoHokokuGeppoHoseiHako.createInstance().updateJigyoHokokuGeppoEntity(修正データリスト);
            div.getPnlKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(更新.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020071StateName.完了状態);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「該当一覧へ戻る」ボタンの機能処理です。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     * @return ResponseData<HoseiHakkoYoshiki2KensuEtcTotalPanelDiv>
     */
    public ResponseData<HoseiHakkoYoshiki2KensuEtcTotalPanelDiv> onClick_btnModBack(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuDataHandler handler1 = getHandler2(div);
        List<JigyoHokokuTokeiData> 修正データ = get修正データ(div);

        if (handler1.is修正データ無し(修正データ)) {
            return ResponseData.of(div).forwardWithEventName(DBU0020071TransitionEventName.補正発行検索に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBU0020071TransitionEventName.補正発行検索に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private List<JigyoHokokuTokeiData> get修正データ(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {

        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
        List<JigyoHokokuTokeiData> 修正データ = new ArrayList<>();
        List<JigyoHokokuTokeiData> 件数修正データ = getHandler2(div).get件数修正データリスト(引き継ぎデータ);
        List<JigyoHokokuTokeiData> 単位数修正データ = getHandler3(div).get単位数修正データリスト(引き継ぎデータ);
        List<JigyoHokokuTokeiData> 費用額修正データ = getHandler7(div).get費用額修正データリスト(引き継ぎデータ);
        List<JigyoHokokuTokeiData> 給付額修正データ = getHandler8(div).get給付額修正データリスト(引き継ぎデータ);
        修正データ.addAll(件数修正データ);
        修正データ.addAll(単位数修正データ);
        修正データ.addAll(費用額修正データ);
        修正データ.addAll(給付額修正データ);
        return 修正データ;
    }

    private boolean 整合性チェック_予防給付_はい(boolean 整合性チェック_予防給付, HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && 整合性チェック_予防給付 && div.getPnlMain().get予防給付().isNullOrEmpty();
    }

    private boolean 整合性チェック_介護給付_はい(boolean 整合性チェック_介護給付, HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && 整合性チェック_介護給付 && div.getPnlMain().get介護給付().isNullOrEmpty();
    }

    private boolean 整合性チェック_合計_はい(boolean 整合性チェック_合計, HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && 整合性チェック_合計 && div.getPnlMain().get合計().isNullOrEmpty();
    }

    private boolean 整合性チェックNG_予防給付(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return getHandler2(div).is整合性チェック_件数_NG1() || getHandler7(div).is整合性チェック_単位数_NG1()
                || getHandler9(div).is整合性チェック_費用額_NG1() || getHandler10(div).is整合性チェック_給付額_NG1();
    }

    private boolean 整合性チェックNG_介護給付(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return getHandler2(div).is整合性チェック_件数_NG2() || getHandler7(div).is整合性チェック_単位数_NG2()
                || getHandler9(div).is整合性チェック_費用額_NG2() || getHandler10(div).is整合性チェック_給付額_NG2();
    }

    private boolean 整合性チェックNG_合計(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return getHandler3(div).is整合性チェック_件数_NG3() || getHandler3(div).is整合性チェック_単位数_NG3()
                || getHandler9(div).is整合性チェック_費用額_NG3() || getHandler10(div).is整合性チェック_給付額_NG3();
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuLoadHandler getHandler(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuLoadHandler(div);
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuDataHandler getHandler2(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuDataHandler(div);
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuDataHandler getHandler3(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuDataHandler(div);
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuLoadHandler getHandler4(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuLoadHandler(div);
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuLoadHandler getHandler5(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuLoadHandler(div);
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuLoadHandler getHandler6(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuLoadHandler(div);
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuCheckHandler getHandler7(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuCheckHandler(div);
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuDataHandler getHandler8(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuDataHandler(div);
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuCheckHandler getHandler9(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuCheckHandler(div);
    }

    private HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuCheckHandler getHandler10(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        return new HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuCheckHandler(div);
    }

}
