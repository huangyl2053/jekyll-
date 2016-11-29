/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0700011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.DBC0700011StateName.更新完了;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.DBC0700011StateName.照会;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.DBC0700011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.JutakuKaishuJizenShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0700011.JutakuKaishuJizenShinseiTorokuDivHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 住宅改修費事前申請登録完了画面です。
 *
 * @reamsid_L DBC-0990-060 panhe
 */
public class JutakuKaishuJizenShinseiToroku {

    private static final RString 登録モード = new RString("登録");
    private static final RString 削除モード = new RString("削除");
    private static final RString 照会モード = new RString("照会");
    private static final RString 取消モード = new RString("取消");
    private static final RString 非表示用フラグ_TRUE = new RString("true");
    private static final RString 要介護状態区分_KEY = new RString("threeUp");
    private static final RString 要介護状態区分_VALUE = new RString("要介護状態区分３段階変更による");
    private static final RString 住宅住所変更_KEY = new RString("changeAddress");
    private static final RString 住宅住所変更_VALUE = new RString("住宅住所変更による");
    private static final RString 初期化済み = new RString("true");
    private static final RString 口座情報 = new RString("口座情報");
    private static final RString 住宅改修情報 = new RString("住宅改修情報");
    private static final RString 審査結果 = new RString("審査結果");
    private static final RString 事前申請情報 = new RString("事前申請情報");
    private static final RString 登録FLAG = new RString("登録");
    private static final RString 参照 = new RString("参照");
    private static final RString 事業者選択 = new RString("DBC0300011_事業者選択");

    /**
     * 初期化メソッドです
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onLoad(JutakuKaishuJizenShinseiTorokuDiv div) {

        HihokenshaNo 被保険者番号;
        ShikibetsuCode 識別コード;
        TaishoshaKey 引き継ぎデータEntity = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (引き継ぎデータEntity != null) {
            被保険者番号 = 引き継ぎデータEntity.get被保険者番号();
            識別コード = 引き継ぎデータEntity.get識別コード();
            ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
            ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        }

        被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getKaigoShikakuKihonShaPanel().getCcdKaigoShikakuKihon().initialize(識別コード);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().getCcdBunshoBango().initialize(ReportIdDBC.DBC100001.getReportId());

        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        RString state = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (state != null) {
            FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
            RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
            ViewStateHolder.put(ViewStateKeys.償還払支給住宅改修事前申請情報,
                    handler.登録以外初期化(被保険者番号, サービス提供年月, 整理番号));
        } else {
            state = 登録モード;
            RDate サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, RDate.class);
            div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiYMD().setValue(サービス年月);
            ViewStateHolder.put(ViewStateKeys.処理モード, 登録モード);
            RString 整理番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.
                    getコード()).nextString();
            ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        }
        handler.項目表示制御処理(state,
                ViewStateHolder.get(ViewStateKeys.償還払支給住宅改修事前申請情報, ShokanJutakuKaishuJizenShinsei.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, RDate.class),
                被保険者番号);
        if (照会モード.equals(state)) {
            return ResponseData.of(div).setState(照会);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 事業者契約番号と名称設定です。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onActive(JutakuKaishuJizenShinseiTorokuDiv div) {
        RString イベント名 = ResponseHolder.getBeforeEvent();
        if (事業者選択.equals(イベント名)) {
            JuryoininKeiyakuJigyosha tmp = ViewStateHolder.get(ViewStateKeys.詳細データ, JuryoininKeiyakuJigyosha.class);
            if (tmp != null) {
                div.getKaigoShikakuKihonShaPanel().getCcdJutakuKaishuJizenShinseiKoza().set契約事業者(tmp.get契約事業者番号());
                div.getKaigoShikakuKihonShaPanel().getCcdJutakuKaishuJizenShinseiKoza().set契約事業者名(tmp.get契約事業者名称());
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「本人情報をコピー」ボタン
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onClick_btnHonninJohoCopy(JutakuKaishuJizenShinseiTorokuDiv div) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        handler.本人情報をコピーする();
        return ResponseData.of(div).respond();
    }

    /**
     * 事業者・施設選択入力ガイドダイアログが閉じた後に実行されるイベントメソッドです。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onOkClose_btnJigyoshaInputGuide(JutakuKaishuJizenShinseiTorokuDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「申請一覧へ戻る」ボタンクリックメソッドです。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onClick_btnBackToSearch(JutakuKaishuJizenShinseiTorokuDiv div) {
        if (照会.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).forwardWithEventName(DBC0700011TransitionEventName.該当者一覧).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0700011TransitionEventName.該当者一覧).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * サービス年月入力値を変更する時のメソッドです。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onChange_txtServiceYM(JutakuKaishuJizenShinseiTorokuDiv div) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        handler.給付率設定(被保険者番号);
        div.setHidDataChangeFlg(非表示用フラグ_TRUE);
        return ResponseData.of(div).respond();
    }

    /**
     * 判定区分選択値を変更する時のメソッドです。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onChange_radJudgeKubun(JutakuKaishuJizenShinseiTorokuDiv div) {
        if (ShoninKubun.承認する.getコード().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getRadJudgeKubun().getSelectedKey())) {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason().clearValue();
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtShoninCondition().setDisabled(false);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason().setDisabled(true);
        } else {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtShoninCondition().clearValue();
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtShoninCondition().setDisabled(true);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * タグ選択変更のメソッドです
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onChange_Tab(JutakuKaishuJizenShinseiTorokuDiv div) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString selectedTab = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getSelectedItem().getTitle();
        ShokanJutakuKaishuJizenShinsei data = ViewStateHolder.get(ViewStateKeys.償還払支給住宅改修事前申請情報,
                ShokanJutakuKaishuJizenShinsei.class);

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        if (口座情報.equals(selectedTab) && !初期化済み.equals(div.getHidKozaJyohoFlg())) {
            handler.口座情報選択時(画面モード, data, 識別コード, 被保険者番号, 整理番号);
            div.setHidDataChangeFlg(RString.EMPTY);
        } else if (住宅改修情報.equals(selectedTab) && !初期化済み.equals(div.getHidJutakuKaisyuJyohoFlg())) {
            ShiharaiKekkaResult result = handler.住宅改修情報選択時(
                    画面モード, 被保険者番号,
                    識別コード,
                    data,
                    整理番号,
                    ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class));
            ViewStateHolder.put(ViewStateKeys.住宅改修データ, result);
            ViewStateHolder.put(ViewStateKeys.前回までの支払結果, result);
            ViewStateHolder.put(ViewStateKeys.限度額リセット値, (Serializable) handler.住宅改修データと限度額リセット値の保存());
            div.setHidDataChangeFlg(RString.EMPTY);
        } else if (審査結果.equals(selectedTab) && !初期化済み.equals(div.getHidSeikyuSummaryFlg())) {
            if (!登録モード.equals(画面モード)) {
                handler.loadTabShinsaKakka(data, 画面モード);
            } else {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getRadJudgeKubun()
                        .setSelectedKey(ShoninKubun.承認する.getコード());
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason()
                        .setDisabled(true);
            }
            div.setHidSeikyuSummaryFlg(初期化済み);
            div.setHidDataChangeFlg(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * チェックボックスの変更
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onClick_chkResetInfo(JutakuKaishuJizenShinseiTorokuDiv div) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        handler.チェックボックスの変更();
        return ResponseData.of(div).respond();
    }

    /**
     * 「限度額をチェックする」ボタン
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onClick_btnCheckGendogaku(JutakuKaishuJizenShinseiTorokuDiv div) {
        HihokenshaNo hihokenshaNo = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        KeyValueDataSource 要介護状態区分 = new KeyValueDataSource(要介護状態区分_KEY, 要介護状態区分_VALUE);
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);

        handler.住宅改修内容のチェック();
        handler.費用額合計の設定();
        handler.前回までの支払結果設定(hihokenshaNo);
        boolean 要介護状態３段階変更の判定 = true;
        if (ResponseHolder.isReRequest() && (is３段階変更MSG() || is改修住所MSG())) {
            要介護状態３段階変更の判定 = ViewStateHolder.get(ViewStateKeys.要介護状態３段階変更, Boolean.class);
        } else {
            要介護状態３段階変更の判定 = handler.要介護状態３段階変更の有効性チェック(hihokenshaNo);
            ViewStateHolder.put(ViewStateKeys.要介護状態３段階変更, 要介護状態３段階変更の判定);
        }

        if (要介護状態３段階変更の判定
                && !selectedItems.contains(要介護状態区分)) {
            if (!is３段階変更MSG() && !is改修住所MSG()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage().getCode(),
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems().add(要介護状態区分);
                div.setHidSandannkaiMsgFlg(非表示用フラグ_TRUE);
            } else {
                div.setHidSandannkaiMsgFlg(RString.EMPTY);
            }
        } else if (!要介護状態３段階変更の判定
                && selectedItems.contains(要介護状態区分)) {
            if (!is３段階変更MSG() && !is改修住所MSG()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().getCode(),
                        DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                selectedItems.remove(要介護状態区分);
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().setSelectedItems(selectedItems);
                div.setHidSandannkaiMsgFlg(非表示用フラグ_TRUE);
            } else {
                div.setHidSandannkaiMsgFlg(RString.EMPTY);
            }
        }
        QuestionMessage msg = 限度額リセットチェック(div, hihokenshaNo);
        if (msg != null && !QuestionMessage.NO_MESSAGE.getCode().equals(msg.getCode())) {
            return ResponseData.of(div).addMessage(msg).respond();
        }
        handler.支払結果の設定(hihokenshaNo);
        ViewStateHolder.put(ViewStateKeys.限度額リセット値, (Serializable) handler.住宅改修データと限度額リセット値の保存());
        ViewStateHolder.put(ViewStateKeys.一覧データ, (Serializable) handler.to住宅改修データを画面メモリに保存());
        return ResponseData.of(div).respond();
    }

    private QuestionMessage 限度額リセットチェック(JutakuKaishuJizenShinseiTorokuDiv div,
            HihokenshaNo hihokenshaNo) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        KeyValueDataSource 住宅住所変更 = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();

        boolean 改修住所変更 = true;
        if (ResponseHolder.isReRequest() && is改修住所MSG()) {
            改修住所変更 = ViewStateHolder.get(ViewStateKeys.改修住所重複, Boolean.class);
        } else {
            改修住所変更 = handler.改修住所変更による限度額リセットチェック(hihokenshaNo);
            ViewStateHolder.put(ViewStateKeys.改修住所重複, 改修住所変更);
        }

        if (!改修住所変更 && !selectedItems.contains(住宅住所変更)) {
            if (!is改修住所MSG()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().getCode(),
                        DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().evaluate());
                div.setHidLimitMsgDisplayedFlg(非表示用フラグ_TRUE);
                return message;
            }
            if (new RString(DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems().add(住宅住所変更);
                div.setHidLimitMsgDisplayedFlg(RString.EMPTY);
            } else {
                div.setHidLimitMsgDisplayedFlg(RString.EMPTY);
                return new QuestionMessage(QuestionMessage.NO_MESSAGE.getCode(), QuestionMessage.NO_MESSAGE.evaluate());
            }
        } else if (改修住所変更 && selectedItems.contains(住宅住所変更)) {
            if (!is改修住所MSG()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().getCode(),
                        DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().evaluate());
                div.setHidLimitMsgDisplayedFlg(非表示用フラグ_TRUE);
                return message;
            }
            if (new RString(DbcQuestionMessages.改修住所変更_限度額リセット対象外.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                selectedItems.remove(住宅住所変更);
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                        .getChkResetInfo().setSelectedItems(selectedItems);
                div.setHidLimitMsgNotNeedFlg(RString.EMPTY);
            } else {
                div.setHidLimitMsgNotNeedFlg(RString.EMPTY);
                return new QuestionMessage(QuestionMessage.NO_MESSAGE.getCode(), QuestionMessage.NO_MESSAGE.evaluate());
            }
        }
        return null;
    }

    private boolean is３段階変更MSG() {
        boolean 限度額リセット対象 = new RString(DbcQuestionMessages.要介護状態区分変更_限度額リセット対象.getMessage()
                .getCode()).equals(ResponseHolder.getMessageCode());
        boolean 限度額リセット対象外 = new RString(DbcQuestionMessages.要介護状態区分変更_限度額リセット対象外.getMessage()
                .getCode()).equals(ResponseHolder.getMessageCode());
        return 限度額リセット対象 || 限度額リセット対象外;
    }

    private boolean is改修住所MSG() {
        boolean 改修住所_限度額リセット対象 = new RString(DbcQuestionMessages.改修住所変更_限度額リセット対象.getMessage()
                .getCode()).equals(ResponseHolder.getMessageCode());
        boolean 改修住所_限度額リセット対象外 = new RString(DbcQuestionMessages.改修住所変更_限度額リセット対象外
                .getMessage().getCode()).equals(ResponseHolder.getMessageCode());
        return 改修住所_限度額リセット対象 || 改修住所_限度額リセット対象外;
    }

    /**
     * 「申請を保存する」ボタン
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onClick_btnSave(JutakuKaishuJizenShinseiTorokuDiv div) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        HihokenshaNo hihokenshaNo = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString seiriNo = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);

        RString state = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        boolean 入力チェック結果 = false;
        List<RString> 処理モード = new ArrayList<>();
        処理モード.add(削除モード);
        処理モード.add(取消モード);

        if (!処理モード.contains(state)) {
            入力チェック結果 = handler.入力チェック(state, hihokenshaNo);
        }
        if (入力チェック結果) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.旧措置者_保存確認.getMessage().getCode(),
                        DbcQuestionMessages.旧措置者_保存確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.旧措置者_保存確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }

        dataChangeCheck(div);

        boolean 確認対象変更有無チェック結果 = false;
        if (!処理モード.contains(state)) {

            確認対象変更有無チェック結果 = handler.確認対象変更有無チェック(
                    ViewStateHolder.get(ViewStateKeys.一覧データ, Map.class),
                    ViewStateHolder.get(ViewStateKeys.限度額リセット値, List.class));
        }
        if (確認対象変更有無チェック結果) {
            if (!非表示用フラグ_TRUE.equals(div.getHidInputCheckMsgDisplayedFlg())) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.限度額変更確認.getMessage().getCode(),
                        DbcQuestionMessages.限度額変更確認.getMessage().evaluate());
                div.setHidInputCheckMsgDisplayedFlg(非表示用フラグ_TRUE);
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.限度額変更確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                div.setHidInputCheckMsgDisplayedFlg(RString.EMPTY);
                return ResponseData.of(div).respond();
            }
        }
        if (削除モード.equals(state)) {
            if (!非表示用フラグ_TRUE.equals(div.getHidInputConfirmMsgDisplayedFlg())) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                div.setHidInputConfirmMsgDisplayedFlg(非表示用フラグ_TRUE);
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                div.setHidInputConfirmMsgDisplayedFlg(RString.EMPTY);
                return ResponseData.of(div).respond();
            }
        } else {
            if (!非表示用フラグ_TRUE.equals(div.getHidInputConfirmMsgDisplayedFlg())) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                div.setHidInputConfirmMsgDisplayedFlg(非表示用フラグ_TRUE);
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                div.setHidInputConfirmMsgDisplayedFlg(RString.EMPTY);
                return ResponseData.of(div).respond();
            }
        }

        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM()
                .getValue().getYearMonth().toDateString());
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        RString 様式番号 = handler.get様式番号(hihokenshaNo, サービス提供年月);
        ShokanJutakuKaishuJizenShinsei deleteData = ViewStateHolder.get(ViewStateKeys.償還払支給住宅改修事前申請情報,
                ShokanJutakuKaishuJizenShinsei.class);
        Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> data = ViewStateHolder
                .get(ViewStateKeys.住宅改修内容一覧_検索結果, Models.class);
        申請内容の保存(handler, state, hihokenshaNo, サービス提供年月, 整理番号, 様式番号, deleteData, data);
        RString 氏名漢字 = div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().get氏名漢字();
        div.getJutakuJizenKanryo().getCcdKanryoMessage().setMessage(UrInformationMessages.保存終了,
                hihokenshaNo.value(), 氏名漢字, true);
        ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請情報 = ViewStateHolder.get(
                ViewStateKeys.償還払支給住宅改修事前申請情報, ShokanJutakuKaishuJizenShinsei.class);
        handler.承認結果通知書作成(hihokenshaNo, 識別コード, seiriNo, state, 償還払支給住宅改修事前申請情報);

        return ResponseData.of(div).setState(更新完了);
    }

    private boolean 申請内容の保存(JutakuKaishuJizenShinseiTorokuDivHandler handler,
            RString state,
            HihokenshaNo hihokenshaNo,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 様式番号,
            ShokanJutakuKaishuJizenShinsei deleteData,
            Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> data) {
        boolean 保存結果;
        if (登録モード.equals(state)) {
            Map<RString, Object> map = handler.申請内容の保存_登録(state, hihokenshaNo, サービス提供年月, 整理番号, 様式番号);
            ViewStateHolder.put(ViewStateKeys.償還払支給住宅改修事前申請情報, (Serializable) map.get(事前申請情報));
            保存結果 = (boolean) map.get(登録FLAG);
        } else if (削除モード.equals(state)) {
            保存結果 = handler.申請内容の保存_削除(deleteData, data);
        } else {
            保存結果 = handler.申請内容の保存_取消と更新(state, hihokenshaNo, サービス提供年月, 整理番号, 様式番号, deleteData, data);
        }
        return 保存結果;
    }

    /**
     * 画面データ変更有無チェック処理
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     */
    public void dataChangeCheck(JutakuKaishuJizenShinseiTorokuDiv div) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        RString state = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (!削除モード.equals(state) && !登録モード.equals(state) && !取消モード.equals(state)) {
            if (!非表示用フラグ_TRUE.equals(div.getHidDataChangeFlg())) {
                handler.画面データ変更有無(ViewStateHolder.get(ViewStateKeys.償還払支給住宅改修事前申請情報,
                        ShokanJutakuKaishuJizenShinsei.class),
                        ViewStateHolder.get(ViewStateKeys.住宅改修データ, ShiharaiKekkaResult.class));
            }
            if (!非表示用フラグ_TRUE.equals(div.getHidDataChangeFlg())) {
                throw new ApplicationException(DbzQuestionMessages.内容変更なし処理中止確認.getMessage().evaluate());
            }
        }
    }

    /**
     * 「申請事業者参考」ボタンを押した後のメソッドです。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onBeforeOpenDialog_btnJigyosha(
            JutakuKaishuJizenShinseiTorokuDiv div) {
        JigyoshaMode jigyoshaMode = new JigyoshaMode();
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        div.setJigyoshaMode(DataPassingConverter.serialize(jigyoshaMode));
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者・施設選択入力ガイド」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onOkClose_btnJigyosha(
            JutakuKaishuJizenShinseiTorokuDiv div) {
        JigyoshaMode jigyoshaMode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtJigyoshaNo().setValue(jigyoshaMode
                .getJigyoshaNo().value());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtJigyoshaName().setPlaceHolder(jigyoshaMode
                .getJigyoshaName().value());
        return ResponseData.of(div).respond();
    }

    /**
     * 「作成事業者参考」ボタンを押した後のメソッドです。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onBeforeOpenDialog_btnSakuSeiJigyosha(
            JutakuKaishuJizenShinseiTorokuDiv div) {
        JigyoshaMode jigyoshaMode = new JigyoshaMode();
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        div.setJigyoshaMode(DataPassingConverter.serialize(jigyoshaMode));
        return ResponseData.of(div).respond();
    }

    /**
     * 「参考」ボタンをクリックします。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onClick_btnKeiyakuNo(JutakuKaishuJizenShinseiTorokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 参照);
        return ResponseData.of(div).forwardWithEventName(DBC0700011TransitionEventName.契約事業者検索).respond();
    }

    /**
     * 「事業者・施設選択入力ガイド」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onOkClose_btnSakuSeiJigyosha(
            JutakuKaishuJizenShinseiTorokuDiv div) {
        JigyoshaMode jigyoshaMode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaNo()
                .setValue(jigyoshaMode.getJigyoshaNo().value());
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaName()
                .setValue(jigyoshaMode.getJigyoshaName().value());
        return ResponseData.of(div).respond();
    }

    /**
     * Handlerクラスの取得
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return JutakuKaishuJizenShinseiTorokuHandler
     */
    private JutakuKaishuJizenShinseiTorokuDivHandler getHandler(JutakuKaishuJizenShinseiTorokuDiv div) {
        return JutakuKaishuJizenShinseiTorokuDivHandler.of(div);
    }
}
