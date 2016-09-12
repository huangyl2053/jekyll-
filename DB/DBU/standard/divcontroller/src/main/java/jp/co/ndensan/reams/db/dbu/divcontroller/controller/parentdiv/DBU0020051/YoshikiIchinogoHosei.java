/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020051;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020051.DBU0020051StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020051.DBU0020051TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020051.YoshikiIchinogoHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020051.YoshikiIchinogoHoseiCheckHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020051.YoshikiIchinogoHoseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 画面設計_DBUMN91003_事業報告（月報）補正発行_様式１の５補正
 *
 * @reamsid_L DBU-1100-050 quxiaodong
 */
public class YoshikiIchinogoHosei {

    private static final RString 修正状態 = new RString("更新");
    private static final RString 削除状態 = new RString("削除");
    private static final RString 更新 = new RString("更新");
    private static final RString 合計計算結果 = new RString("合計計算結果");
    private static final RString 要支援計と要介護計の合計計算結果 = new RString("要支援計と要介護計の合計計算結果");
    private static final RString 要支援計 = new RString("要支援計");
    private static final RString 要介護計 = new RString("要介護計");
    private static final RString 合計 = new RString("合計");
    private static final RString 要介護 = new RString("(11)要介護(要支援)認定者数");
    private static final RString 居宅介護 = new RString("(12)居宅介護(介護予防)サビース受給者数");
    private static final RString 地域密着型 = new RString("(13)地域密着型(介護予防)サビース受給者数");
    private static final RString 施設介護 = new RString("(14)施設介護サビース受給者数");
    private static final Code 集計番号_1100 = new Code("1100");
    private static final Code 集計番号_1200 = new Code("1200");
    private static final Code 集計番号_1400 = new Code("1400");
    private static final Code 集計番号_1391 = new Code("1391");
    private static final Code 集計番号_1392 = new Code("1392");
    private static final Code 集計番号_1393 = new Code("1393");
    private static final RString 様式種類_11 = new RString("11");
    private static final RString 様式種類_21 = new RString("21");
    private static final RString 様式種類_31 = new RString("31");
    private static final RString 様式種類_41 = new RString("41");

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
        Map<RString, ArrayList<RString>> map = getHandler(div).set様式種類();
        ViewStateHolder.put(ViewStateKeys.様式種類_11, map.get(様式種類_11));
        ViewStateHolder.put(ViewStateKeys.様式種類_21, map.get(様式種類_21));
        ViewStateHolder.put(ViewStateKeys.様式種類_31, map.get(様式種類_31));
        ViewStateHolder.put(ViewStateKeys.様式種類_41, map.get(様式種類_41));
        IStateEnumerations stateName = initialize(div, 引き継ぎデータ, 状態, map);
        return ResponseData.of(div).setState(stateName);
    }

    private IStateEnumerations initialize(YoshikiIchinogoHoseiDiv div,
            JigyoHokokuGeppoParameter 引き継ぎデータ, RString 状態,
            Map<RString, ArrayList<RString>> 様式種類Map) {
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        List<RString> list11 = 様式種類Map.get(様式種類_11);
        List<RString> list21 = 様式種類Map.get(様式種類_21);
        List<RString> list31 = 様式種類Map.get(様式種類_31);
        List<RString> list41 = 様式種類Map.get(様式種類_41);
        if (list11.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 要介護list = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_1100);
            getHandler(div).set要介護認定者数(要介護list);
            div.getPnl11().setTitle(要介護);
            ViewStateHolder.put(ViewStateKeys.要介護データリスト, (Serializable) 要介護list);
            if (修正状態.equals(状態)) {
                return DBU0020051StateName.修正状態1;
            }
            return DBU0020051StateName.削除状態1;
        } else if (list21.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 居宅介護list = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_1200);
            getHandler(div).set居宅介護認定者数(居宅介護list);
            div.getPnl12().setTitle(居宅介護);
            ViewStateHolder.put(ViewStateKeys.居宅介護データリスト, (Serializable) 居宅介護list);
            if (修正状態.equals(状態)) {
                return DBU0020051StateName.修正状態2;
            }
            return DBU0020051StateName.削除状態2;
        } else if (list31.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 地域密着型list = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_1400);
            getHandler(div).set地域密着型認定者数(地域密着型list);
            div.getPnl13().setTitle(地域密着型);
            ViewStateHolder.put(ViewStateKeys.地域密着型データリスト, (Serializable) 地域密着型list);
            if (修正状態.equals(状態)) {
                return DBU0020051StateName.修正状態3;
            }
            return DBU0020051StateName.削除状態3;
        } else if (list41.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 施設介護list1 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_1391);
            List<JigyoHokokuTokeiData> 施設介護list2 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_1392);
            List<JigyoHokokuTokeiData> 施設介護list3 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_1393);
            getHandler(div).set施設介護認定者数1(施設介護list1);
            getHandler(div).set施設介護認定者数2(施設介護list2);
            getHandler(div).set施設介護認定者数3(施設介護list3);
            div.getPnl14().setTitle(施設介護);
            ViewStateHolder.put(ViewStateKeys.施設介護1データリスト, (Serializable) 施設介護list1);
            ViewStateHolder.put(ViewStateKeys.施設介護2データリスト, (Serializable) 施設介護list2);
            ViewStateHolder.put(ViewStateKeys.施設介護3データリスト, (Serializable) 施設介護list3);
            if (修正状態.equals(状態)) {
                return DBU0020051StateName.修正状態4;
            }
            return DBU0020051StateName.削除状態4;
        }
        return DBU0020051StateName.NoChange;
    }

    private List<JigyoHokokuTokeiData> get事業報告月報詳細データリスト(
            JigyoHokokuGeppoParameter 引き継ぎデータ, Code 集計番号) {
        JigyoHokokuGeppoDetalSearchParameter parameter
                = JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(
                        new FlexibleYear(引き継ぎデータ.get行報告年()),
                        引き継ぎデータ.get行報告月(),
                        new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                        引き継ぎデータ.get行集計対象月(),
                        引き継ぎデータ.get行統計対象区分(),
                        new LasdecCode(引き継ぎデータ.get行市町村コード()),
                        new Code(引き継ぎデータ.get行表番号()),
                        集計番号);
        return JigyoHokokuGeppoHoseiHako.createInstance().getJigyoHokokuGeppoDetal(parameter);
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
                return ResponseData.of(div).forwardWithEventName(
                        DBU0020051TransitionEventName.補正発行検索に戻る).respond();
            }
            List<RString> 様式種類List11 = ViewStateHolder.get(ViewStateKeys.様式種類_11, List.class);
            List<RString> 様式種類List21 = ViewStateHolder.get(ViewStateKeys.様式種類_21, List.class);
            List<RString> 様式種類List31 = ViewStateHolder.get(ViewStateKeys.様式種類_31, List.class);
            List<RString> 様式種類List41 = ViewStateHolder.get(ViewStateKeys.様式種類_41, List.class);
            List<JigyoHokokuTokeiData> 要介護データリスト = ViewStateHolder.
                    get(ViewStateKeys.要介護データリスト, List.class);
            List<JigyoHokokuTokeiData> 居宅介護データリスト = ViewStateHolder
                    .get(ViewStateKeys.居宅介護データリスト, List.class);
            List<JigyoHokokuTokeiData> 地域密着型データリスト = ViewStateHolder
                    .get(ViewStateKeys.地域密着型データリスト, List.class);
            List<JigyoHokokuTokeiData> 施設介護1データリスト = ViewStateHolder
                    .get(ViewStateKeys.施設介護1データリスト, List.class);
            List<JigyoHokokuTokeiData> 施設介護2データリスト = ViewStateHolder
                    .get(ViewStateKeys.施設介護2データリスト, List.class);
            List<JigyoHokokuTokeiData> 施設介護3データリスト = ViewStateHolder
                    .get(ViewStateKeys.施設介護3データリスト, List.class);
            List<JigyoHokokuTokeiData> 修正データリスト = getHandler(div).get修正データリスト(
                    引き継ぎデータ, 様式種類List11, 様式種類List21, 様式種類List31, 様式種類List41,
                    要介護データリスト, 居宅介護データリスト, 地域密着型データリスト,
                    施設介護1データリスト, 施設介護2データリスト, 施設介護3データリスト);
            if (null == 修正データリスト || 修正データリスト.isEmpty()) {
                return ResponseData.of(div).forwardWithEventName(
                        DBU0020051TransitionEventName.補正発行検索に戻る).respond();
            }
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(
                    DBU0020051TransitionEventName.補正発行検索に戻る).respond();
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
        List<JigyoHokokuTokeiData> 要介護データリスト = ViewStateHolder.
                get(ViewStateKeys.要介護データリスト, List.class);
        List<JigyoHokokuTokeiData> 居宅介護データリスト = ViewStateHolder
                .get(ViewStateKeys.居宅介護データリスト, List.class);
        List<JigyoHokokuTokeiData> 地域密着型データリスト = ViewStateHolder
                .get(ViewStateKeys.地域密着型データリスト, List.class);
        List<JigyoHokokuTokeiData> 施設介護1データリスト = ViewStateHolder
                .get(ViewStateKeys.施設介護1データリスト, List.class);
        List<JigyoHokokuTokeiData> 施設介護2データリスト = ViewStateHolder
                .get(ViewStateKeys.施設介護2データリスト, List.class);
        List<JigyoHokokuTokeiData> 施設介護3データリスト = ViewStateHolder
                .get(ViewStateKeys.施設介護3データリスト, List.class);
        if (削除状態.equals(状態)) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).delete(要介護データリスト);
                getHandler(div).delete(居宅介護データリスト);
                getHandler(div).delete(地域密着型データリスト);
                getHandler(div).delete(施設介護1データリスト);
                getHandler(div).delete(施設介護2データリスト);
                getHandler(div).delete(施設介護3データリスト);
                div.getPnlKanryo().getCcdKanryoMessage().setSuccessMessage(new RString(
                        UrInformationMessages.正常終了.getMessage().replace(削除状態.toString()).evaluate()));
                return ResponseData.of(div).setState(DBU0020051StateName.完了状態);
            }
            if (new RString(UrInformationMessages.正常終了.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())) {
                return ResponseData.of(div).respond();
            }
        }
        List<RString> 様式種類List11 = ViewStateHolder.get(ViewStateKeys.様式種類_11, List.class);
        List<RString> 様式種類List21 = ViewStateHolder.get(ViewStateKeys.様式種類_21, List.class);
        List<RString> 様式種類List31 = ViewStateHolder.get(ViewStateKeys.様式種類_31, List.class);
        List<RString> 様式種類List41 = ViewStateHolder.get(ViewStateKeys.様式種類_41, List.class);
        List<JigyoHokokuTokeiData> 修正データリスト = getHandler(div).get修正データリスト(
                引き継ぎデータ, 様式種類List11, 様式種類List21, 様式種類List31, 様式種類List41,
                要介護データリスト, 居宅介護データリスト, 地域密着型データリスト,
                施設介護1データリスト, 施設介護2データリスト, 施設介護3データリスト);
        if (null == 修正データリスト || 修正データリスト.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
        return 修正データ更新(div, 修正データリスト, !getCheckHandler(div).is整合性チェック1(),
                !getCheckHandler(div).is整合性チェック2(), !getCheckHandler(div).is整合性チェック3());
    }

    private ResponseData<YoshikiIchinogoHoseiDiv> 修正データ更新(
            YoshikiIchinogoHoseiDiv div, List<JigyoHokokuTokeiData> 修正データ, boolean 予防要支援結果チェック,
            boolean 介護要支援結果チェック, boolean 合計要支援結果チェック) {
        if (!ResponseHolder.isReRequest() && 予防要支援結果チェック) {
            div.set要支援計(RString.EMPTY);
            return ResponseData.of(div).addMessage(
                    UrWarningMessages.相違.getMessage().replace(
                            要支援計.toString(), 合計計算結果.toString())).respond();
        } else if (!ResponseHolder.isReRequest() && 介護要支援結果チェック) {
            div.set要介護計(RString.EMPTY);
            return ResponseData.of(div).addMessage(
                    UrWarningMessages.相違.getMessage().replace(
                            要介護計.toString(), 合計計算結果.toString())).respond();
        } else if (!ResponseHolder.isReRequest() && 合計要支援結果チェック) {
            div.set合計(RString.EMPTY);
            return ResponseData.of(div).addMessage(
                    UrWarningMessages.相違.getMessage().replace(
                            合計.toString(), 要支援計と要介護計の合計計算結果.toString())).respond();
        }

        if (is要支援はい(予防要支援結果チェック, div)) {
            div.set要支援計(RString.FULL_SPACE);
            if (介護要支援結果チェック) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                要介護計.toString(), 合計計算結果.toString())).respond();
            } else if (合計要支援結果チェック) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                合計.toString(), 要支援計と要介護計の合計計算結果.toString())).respond();
            } else if (!修正データ.isEmpty()) {
                return ResponseData.of(div).addMessage(
                        new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
            }
        } else if (is要介護はい(介護要支援結果チェック, div)) {
            div.set要介護計(RString.FULL_SPACE);
            if (合計要支援結果チェック) {
                return ResponseData.of(div).addMessage(
                        UrWarningMessages.相違.getMessage().replace(
                                合計.toString(), 要支援計と要介護計の合計計算結果.toString())).respond();
            } else if (!修正データ.isEmpty()) {
                return ResponseData.of(div).addMessage(
                        new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
            }
        } else if (is合計はい(合計要支援結果チェック, div, 修正データ)) {
            div.set合計(RString.FULL_SPACE);
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
                    UrInformationMessages.正常終了.getMessage().replace(更新.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020051StateName.完了状態);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private void ダイアログいいえチェック(boolean 予防要支援結果チェック, YoshikiIchinogoHoseiDiv div,
            boolean 介護要支援結果チェック, boolean 合計要支援結果チェック) {
        if ((new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No)
                || (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                        ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No)) {
            if (予防要支援結果チェック) {
                div.set要支援計(RString.EMPTY);
            }
            if (介護要支援結果チェック) {
                div.set要介護計(RString.EMPTY);
            }
            if (合計要支援結果チェック) {
                div.set合計(RString.EMPTY);
            }
        }
    }

    private boolean is合計はい(boolean 合計要支援結果チェック, YoshikiIchinogoHoseiDiv div,
            List<JigyoHokokuTokeiData> 修正データ) {
        return new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && 合計要支援結果チェック && div.get合計().isNullOrEmpty() && !修正データ.isEmpty();
    }

    private boolean is要介護はい(boolean 介護要支援結果チェック, YoshikiIchinogoHoseiDiv div) {
        return new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && 介護要支援結果チェック && div.get要介護計().isNullOrEmpty();
    }

    private boolean is要支援はい(boolean 予防要支援結果チェック, YoshikiIchinogoHoseiDiv div) {
        return new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && 予防要支援結果チェック && div.get要支援計().isNullOrEmpty();
    }

    private YoshikiIchinogoHoseiHandler getHandler(YoshikiIchinogoHoseiDiv div) {
        return new YoshikiIchinogoHoseiHandler(div);
    }

    private YoshikiIchinogoHoseiCheckHandler getCheckHandler(YoshikiIchinogoHoseiDiv div) {
        return new YoshikiIchinogoHoseiCheckHandler(div);
    }

}
