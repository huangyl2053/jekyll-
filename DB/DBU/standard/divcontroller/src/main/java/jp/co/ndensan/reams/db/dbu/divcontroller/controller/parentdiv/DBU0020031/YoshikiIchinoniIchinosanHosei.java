/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020031;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020031.DBU0020031StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020031.DBU0020031TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020031.YoshikiIchinoniIchinosanHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020031.YoshikiIchinoniIchinosanHoseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * 事業報告（月報）補正発行_様式１の２、様式１の３補正のクラスです。
 *
 * @reamsid_L DBU-1100-030 wangkanglei
 */
public class YoshikiIchinoniIchinosanHosei {

    private static final RString 削除状態 = new RString("削除");
    private static final RString 更新 = new RString("更新");
    private static final RString 合計計算結果 = new RString("合計計算結果");
    private static final RString 計 = new RString("計");
    private static final RString 様式種類_11 = new RString("11");
    private static final RString 様式種類_12 = new RString("12");
    private static final RString 様式種類_21 = new RString("21");
    private static final RString 様式種類_22 = new RString("22");
    private static final RString 様式種類_31 = new RString("31");
    private static final RString 様式種類_32 = new RString("32");
    private static final RString 食費_居住費3 = new RString("(3)食費・居住費に係る負担限度額認定（総括）");
    private static final RString 食費_居住費6 = new RString("(6)食費・居住費に係る負担限度額認定（再掲：第２号被保険者分）");
    private static final RString 利用者負担滅額4 = new RString("(4)利用者負担滅額・免除認定（総括）");
    private static final RString 利用者負担滅額7 = new RString("(7)利用者負担滅額・免除認定（再掲：第２号被保険者分）");
    private static final RString 介護老人福祉5 = new RString("(5)介護老人福祉施設旧措置入所者に係る滅額・免除認定（総括）");
    private static final RString 介護老人福祉8 = new RString("(8)介護老人福祉施設旧措置入所者に係る滅額・免除認定（再掲：第２号被保険者分）");
    private static final RString 修正状態 = new RString("更新");
    private static final Code 集計番号_０７１０ = new Code("0710");
    private static final Code 集計番号_０６００ = new Code("0600");
    private static final Code 集計番号_０７２０ = new Code("0720");
    private static final Code 集計番号_０７０２ = new Code("0702");
    private static final Code 集計番号_１０１０ = new Code("1010");
    private static final Code 集計番号_０９００ = new Code("0900");
    private static final Code 集計番号_１０２０ = new Code("1020");
    private static final Code 集計番号_１００２ = new Code("1002");

    /**
     * 画面初期化処理です。
     *
     * @param div YoshikiIchinoniIchinosanHoseiDiv
     * @return ResponseData
     */
    public ResponseData<YoshikiIchinoniIchinosanHoseiDiv> onload(YoshikiIchinoniIchinosanHoseiDiv div) {
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        getHandler(div).set基本情報エリア(引き継ぎデータ, 状態);
        Map<RString, ArrayList<RString>> map = getHandler(div).set様式種類();
        ViewStateHolder.put(ViewStateKeys.様式種類_11, map.get(様式種類_11));
        ViewStateHolder.put(ViewStateKeys.様式種類_12, map.get(様式種類_12));
        ViewStateHolder.put(ViewStateKeys.様式種類_21, map.get(様式種類_21));
        ViewStateHolder.put(ViewStateKeys.様式種類_22, map.get(様式種類_22));
        ViewStateHolder.put(ViewStateKeys.様式種類_31, map.get(様式種類_31));
        ViewStateHolder.put(ViewStateKeys.様式種類_32, map.get(様式種類_32));
        IStateEnumerations stateName = initialize(div, 引き継ぎデータ, 状態, map);
        return ResponseData.of(div).setState(stateName);
    }

    /**
     * 「該当一覧へ戻る」ボタンの機能処理です。
     *
     * @param div YoshikiIchinoniIchinosanHoseiDiv
     * @return ResponseData
     */
    public ResponseData<YoshikiIchinoniIchinosanHoseiDiv> onClick_Element3(YoshikiIchinoniIchinosanHoseiDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        if (!ResponseHolder.isReRequest()) {
            if (削除状態.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020031TransitionEventName.補正発行検索に戻る).respond();
            }
            List<RString> 様式種類List11 = ViewStateHolder.get(ViewStateKeys.様式種類_11, List.class);
            List<RString> 様式種類List12 = ViewStateHolder.get(ViewStateKeys.様式種類_12, List.class);
            List<RString> 様式種類List21 = ViewStateHolder.get(ViewStateKeys.様式種類_21, List.class);
            List<RString> 様式種類List22 = ViewStateHolder.get(ViewStateKeys.様式種類_22, List.class);
            List<RString> 様式種類List31 = ViewStateHolder.get(ViewStateKeys.様式種類_31, List.class);
            List<RString> 様式種類List32 = ViewStateHolder.get(ViewStateKeys.様式種類_32, List.class);
            List<JigyoHokokuTokeiData> 修正データリスト = getHandler(div).get修正データリスト(引き継ぎデータ,
                    様式種類List11,
                    様式種類List12,
                    様式種類List21,
                    様式種類List22,
                    様式種類List31,
                    様式種類List32,
                    ViewStateHolder.get(ViewStateKeys.食費_居住費データリスト, List.class),
                    ViewStateHolder.get(ViewStateKeys.利用者負担滅額データリスト, List.class),
                    ViewStateHolder.get(ViewStateKeys.特定負担限度額データリスト, List.class),
                    ViewStateHolder.get(ViewStateKeys.利用者負担データリスト, List.class));
            if (null == 修正データリスト || 修正データリスト.isEmpty()) {
                return ResponseData.of(div).forwardWithEventName(DBU0020031TransitionEventName.補正発行検索に戻る).respond();
            }
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBU0020031TransitionEventName.補正発行検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンの機能処理です。
     *
     * @param div YoshikiIchinoniIchinosanHoseiDiv
     * @return ResponseData
     */
    public ResponseData<YoshikiIchinoniIchinosanHoseiDiv> onClick_Element2(YoshikiIchinoniIchinosanHoseiDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(
                ViewStateKeys.事業報告基本, JigyoHokokuGeppoParameter.class);
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        List<RString> 様式種類List11 = ViewStateHolder.get(ViewStateKeys.様式種類_11, List.class);
        List<RString> 様式種類List12 = ViewStateHolder.get(ViewStateKeys.様式種類_12, List.class);
        List<RString> 様式種類List21 = ViewStateHolder.get(ViewStateKeys.様式種類_21, List.class);
        List<RString> 様式種類List22 = ViewStateHolder.get(ViewStateKeys.様式種類_22, List.class);
        List<RString> 様式種類List31 = ViewStateHolder.get(ViewStateKeys.様式種類_31, List.class);
        List<RString> 様式種類List32 = ViewStateHolder.get(ViewStateKeys.様式種類_32, List.class);

        List<JigyoHokokuTokeiData> 食費_居住費データリスト = ViewStateHolder.get(
                ViewStateKeys.食費_居住費データリスト, List.class);
        List<JigyoHokokuTokeiData> 利用者負担滅額データリスト = ViewStateHolder.get(
                ViewStateKeys.利用者負担滅額データリスト, List.class);
        List<JigyoHokokuTokeiData> 特定負担限度額データリスト = ViewStateHolder.get(
                ViewStateKeys.特定負担限度額データリスト, List.class);
        List<JigyoHokokuTokeiData> 利用者負担データリスト = ViewStateHolder.get(
                ViewStateKeys.利用者負担データリスト, List.class);

        if (削除状態.equals(状態)) {

            if (様式種類List11.contains(様式種類) || 様式種類List21.contains(様式種類)) {
                getHandler(div).delete(食費_居住費データリスト);
            } else if (様式種類List31.contains(様式種類) || 様式種類List12.contains(様式種類)) {
                getHandler(div).delete(利用者負担滅額データリスト);
            } else if (様式種類List22.contains(様式種類) || 様式種類List32.contains(様式種類)) {
                getHandler(div).delete(特定負担限度額データリスト);
                getHandler(div).delete(利用者負担データリスト);
            }
            div.getKanryoMessage().getCcdKaigoKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(削除状態.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020031StateName.完了状態);
        }
        List<JigyoHokokuTokeiData> 修正データリスト = getHandler(div).get修正データリスト(引き継ぎデータ,
                様式種類List11,
                様式種類List12,
                様式種類List21,
                様式種類List22,
                様式種類List31,
                様式種類List32,
                ViewStateHolder.get(ViewStateKeys.食費_居住費データリスト, List.class),
                ViewStateHolder.get(ViewStateKeys.利用者負担滅額データリスト, List.class),
                ViewStateHolder.get(ViewStateKeys.特定負担限度額データリスト, List.class),
                ViewStateHolder.get(ViewStateKeys.利用者負担データリスト, List.class));
        if (null == 修正データリスト || 修正データリスト.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
        if (様式種類List11.contains(様式種類) || 様式種類List21.contains(様式種類)) {
            if (getHandler(div).is整合性チェック_NG() && !ResponseHolder.isReRequest()) {
                WarningMessage message = new WarningMessage(UrWarningMessages.相違.getMessage().getCode(),
                        UrWarningMessages.相違.getMessage().replace(計.toString(), 合計計算結果.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).update(修正データリスト);
            div.getKanryoMessage().getCcdKaigoKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace(更新.toString()).evaluate()));
            return ResponseData.of(div).setState(DBU0020031StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    private IStateEnumerations initialize(YoshikiIchinoniIchinosanHoseiDiv div,
            JigyoHokokuGeppoParameter 引き継ぎデータ,
            RString 状態,
            Map<RString, ArrayList<RString>> 様式種類Map) {
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        List<RString> list11 = 様式種類Map.get(様式種類_11);
        List<RString> list12 = 様式種類Map.get(様式種類_12);
        List<RString> list21 = 様式種類Map.get(様式種類_21);
        List<RString> list22 = 様式種類Map.get(様式種類_22);
        List<RString> list31 = 様式種類Map.get(様式種類_31);
        List<RString> list32 = 様式種類Map.get(様式種類_32);
        if (list11.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 食費_居住費3List = getHandler(div).get事業報告月報詳細データリスト(
                    引き継ぎデータ, 集計番号_０７１０);
            getHandler(div).set食費_居住費(食費_居住費3List);
            div.getPanelDaisan().setTitle(食費_居住費3);
            ViewStateHolder.put(ViewStateKeys.食費_居住費データリスト, (Serializable) 食費_居住費3List);
            if (修正状態.equals(状態)) {
                return DBU0020031StateName.修正状態1;
            }
            return DBU0020031StateName.削除状態1;
        } else if (list21.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 食費_居住費6List = getHandler(div).get事業報告月報詳細データリスト(
                    引き継ぎデータ, 集計番号_１０１０);
            getHandler(div).set食費_居住費(食費_居住費6List);
            div.getPanelDaisan().setTitle(食費_居住費6);
            ViewStateHolder.put(ViewStateKeys.食費_居住費データリスト, (Serializable) 食費_居住費6List);
            if (修正状態.equals(状態)) {
                return DBU0020031StateName.修正状態1;
            }
            return DBU0020031StateName.削除状態1;
        } else if (list31.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 利用者負担滅額4List = getHandler(div).get事業報告月報詳細データリスト(
                    引き継ぎデータ, 集計番号_０６００);
            getHandler(div).set利用者負担滅額(利用者負担滅額4List);
            div.getPanelDaiyon().setTitle(利用者負担滅額4);
            ViewStateHolder.put(ViewStateKeys.利用者負担滅額データリスト, (Serializable) 利用者負担滅額4List);
            if (修正状態.equals(状態)) {
                return DBU0020031StateName.修正状態2;
            }
            return DBU0020031StateName.削除状態2;
        } else if (list12.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 利用者負担滅額7List = getHandler(div).get事業報告月報詳細データリスト(
                    引き継ぎデータ, 集計番号_０９００);
            getHandler(div).set利用者負担滅額(利用者負担滅額7List);
            div.getPanelDaiyon().setTitle(利用者負担滅額7);
            ViewStateHolder.put(ViewStateKeys.利用者負担滅額データリスト, (Serializable) 利用者負担滅額7List);
            if (修正状態.equals(状態)) {
                return DBU0020031StateName.修正状態2;
            }
            return DBU0020031StateName.削除状態2;
        } else if (list22.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 特定負担限度額5List = getHandler(div).get事業報告月報詳細データリスト(
                    引き継ぎデータ, 集計番号_０７２０);
            List<JigyoHokokuTokeiData> 利用者負担5List = getHandler(div).get事業報告月報詳細データリスト(
                    引き継ぎデータ, 集計番号_０７０２);
            getHandler(div).set特定負担限度額と利用者負担(特定負担限度額5List, 利用者負担5List);
            div.getPanelDaigo().setTitle(介護老人福祉5);
            ViewStateHolder.put(ViewStateKeys.特定負担限度額データリスト, (Serializable) 特定負担限度額5List);
            ViewStateHolder.put(ViewStateKeys.利用者負担データリスト, (Serializable) 利用者負担5List);
            if (修正状態.equals(状態)) {
                return DBU0020031StateName.修正状態3;
            }
            return DBU0020031StateName.削除状態3;
        } else if (list32.contains(様式種類)) {
            List<JigyoHokokuTokeiData> 特定負担限度額8List = getHandler(div).get事業報告月報詳細データリスト(
                    引き継ぎデータ, 集計番号_１０２０);
            List<JigyoHokokuTokeiData> 利用者負担8List = getHandler(div).get事業報告月報詳細データリスト(
                    引き継ぎデータ, 集計番号_１００２);
            getHandler(div).set特定負担限度額と利用者負担(特定負担限度額8List, 利用者負担8List);
            div.getPanelDaigo().setTitle(介護老人福祉8);
            ViewStateHolder.put(ViewStateKeys.特定負担限度額データリスト, (Serializable) 特定負担限度額8List);
            ViewStateHolder.put(ViewStateKeys.利用者負担データリスト, (Serializable) 利用者負担8List);
            if (修正状態.equals(状態)) {
                return DBU0020031StateName.修正状態3;
            }
            return DBU0020031StateName.削除状態3;
        }
        return DBU0020031StateName.NoChange;
    }

    private YoshikiIchinoniIchinosanHoseiHandler getHandler(YoshikiIchinoniIchinosanHoseiDiv div) {
        return new YoshikiIchinoniIchinosanHoseiHandler(div);
    }

}
