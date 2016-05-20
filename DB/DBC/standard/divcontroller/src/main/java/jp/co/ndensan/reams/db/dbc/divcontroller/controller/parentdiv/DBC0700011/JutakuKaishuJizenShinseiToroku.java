/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0700011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.DBC0700011StateName.更新完了;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.DBC0700011StateName.照会;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.DBC0700011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.JutakuKaishuJizenShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0700011.JutakuKaishuJizenShinseiTorokuDivHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
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
    private static final RString 非表示用フラグ_TRUE = new RString("true");
    private static final RString 要介護状態区分_KEY = new RString("threeUp");
    private static final RString 要介護状態区分_VALUE = new RString("要介護状態区分３段階変更による");
    private static final RString 住宅住所変更_KEY = new RString("changeAddress");
    private static final RString 住宅住所変更_VALUE = new RString("住宅住所変更による");

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
        div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().onLoad(識別コード);
        div.getKaigoShikakuKihonShaPanel().getCcdKaigoShikakuKihon().onLoad(識別コード);

        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        RString state = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (state != null) {
            FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
            RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
            handler.登録以外初期化(被保険者番号, サービス提供年月, 整理番号);
        } else {
            state = 登録モード;
            ViewStateHolder.put(ViewStateKeys.処理モード, 登録モード);
            RString 整理番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.
                    getコード()).nextString();
            ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        }
        handler.項目表示制御処理(state);
        if (照会モード.equals(state)) {
            return ResponseData.of(div).setState(照会);
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
     * 「個人検索へ戻る」ボタンクリックメソッドです。
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onClick_btnBackToResult(JutakuKaishuJizenShinseiTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0700011TransitionEventName.検索条件).respond();
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
        RString state = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        handler.タブ選択変更(state, 被保険者番号);
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
     * 「過去の住宅改修費を確認する」ボタン
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     * @return ResponseData<JutakuKaishuJizenShinseiTorokuDiv>
     */
    public ResponseData<JutakuKaishuJizenShinseiTorokuDiv> onClick_btnRireki(JutakuKaishuJizenShinseiTorokuDiv div) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        handler.住宅改修内容のチェック();
        HihokenshaNo hihokenshaNo = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        handler.過去の住宅改修費取得(hihokenshaNo);
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
        RString seiriNo = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        KeyValueDataSource 要介護状態区分 = new KeyValueDataSource(要介護状態区分_KEY, 要介護状態区分_VALUE);
        KeyValueDataSource 住宅住所変更 = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);

        handler.住宅改修内容のチェック();
        handler.費用額合計の設定();

        if (!非表示用フラグ_TRUE.equals(div.getHidSandannkaiMsgFlg()) && handler.要介護状態３段階変更の有効性チェック(hihokenshaNo)
                && !selectedItems.contains(要介護状態区分)) {
            if (!ResponseHolder.isReRequest()) {
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
                return ResponseData.of(div).respond();
            }
        } else if (!非表示用フラグ_TRUE.equals(div.getHidSandannkaiMsgFlg()) && !handler.要介護状態３段階変更の有効性チェック(hihokenshaNo)
                && selectedItems.contains(要介護状態区分)) {
            if (!ResponseHolder.isReRequest()) {
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
                return ResponseData.of(div).respond();
            }
        }
        QuestionMessage msg = 限度額リセットチェック(div, hihokenshaNo);
        if (msg != null) {
            if (QuestionMessage.NO_MESSAGE.getCode().equals(msg.getCode())) {
                return ResponseData.of(div).respond();
            } else {
                return ResponseData.of(div).addMessage(msg).respond();
            }
        }

        boolean 限度額のチェック結果 = handler.限度額チェック(hihokenshaNo, seiriNo);
        if (!限度額のチェック結果) {
            if (!非表示用フラグ_TRUE.equals(div.getHidLimitNGMsgDisplayedFlg())) {
                QuestionMessage message = new QuestionMessage(
                        DbcErrorMessages.対象年月被保険者データなし.getMessage().getCode(),
                        DbcErrorMessages.対象年月被保険者データなし.getMessage().evaluate());
                div.setHidLimitNGMsgDisplayedFlg(非表示用フラグ_TRUE);
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcErrorMessages.対象年月被保険者データなし.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                selectedItems.remove(住宅住所変更);
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().setSelectedItems(selectedItems);
            } else {
                div.setHidLimitNGMsgDisplayedFlg(RString.EMPTY);
                return ResponseData.of(div).respond();
            }
        }
        handler.支払結果の設定(hihokenshaNo);
        return ResponseData.of(div).respond();
    }

    private QuestionMessage 限度額リセットチェック(JutakuKaishuJizenShinseiTorokuDiv div,
            HihokenshaNo hihokenshaNo) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        KeyValueDataSource 住宅住所変更 = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        if (!非表示用フラグ_TRUE.equals(div.getHidLimitMsgNotNeedFlg())
                && !handler.改修住所変更による限度額リセットチェック(hihokenshaNo)
                && !selectedItems.contains(住宅住所変更)) {
            if (!非表示用フラグ_TRUE.equals(div.getHidLimitMsgDisplayedFlg())) {
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
                div.setHidLimitMsgDisplayedFlg(非表示用フラグ_TRUE);
            } else {
                div.setHidLimitMsgDisplayedFlg(RString.EMPTY);
                return new QuestionMessage(QuestionMessage.NO_MESSAGE.getCode(), QuestionMessage.NO_MESSAGE.evaluate());
            }
        } else if (!非表示用フラグ_TRUE.equals(div.getHidLimitMsgNotNeedFlg())
                && handler.改修住所変更による限度額リセットチェック(hihokenshaNo)
                && selectedItems.contains(住宅住所変更)) {
            if (!非表示用フラグ_TRUE.equals(div.getHidLimitMsgDisplayedFlg())) {
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
                div.setHidLimitMsgNotNeedFlg(非表示用フラグ_TRUE);
            } else {
                div.setHidLimitMsgNotNeedFlg(RString.EMPTY);
                return new QuestionMessage(QuestionMessage.NO_MESSAGE.getCode(), QuestionMessage.NO_MESSAGE.evaluate());
            }
        }
        return null;
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
        if (!削除モード.equals(state)) {
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
        if (!削除モード.equals(state)) {
            確認対象変更有無チェック結果 = handler.確認対象変更有無チェック();
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

        boolean 保存結果 = handler.申請内容の保存(state);
        RString 氏名漢字 = div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().get氏名漢字();
        if (保存結果) {
            div.getJutakuJizenKanryo().getCcdKanryoMessage().setMessage(UrInformationMessages.保存終了,
                    hihokenshaNo.value(), 氏名漢字, true);
        } else {
            div.getJutakuJizenKanryo().getCcdKanryoMessage().setMessage(UrErrorMessages.異常終了,
                    hihokenshaNo.value(), 氏名漢字, false);
        }
        handler.承認結果通知書作成(hihokenshaNo, 識別コード, seiriNo, state);

        return ResponseData.of(div).setState(更新完了);
    }

    /**
     * 画面データ変更有無チェック処理
     *
     * @param div JutakuKaishuJizenShinseiTorokuDiv
     */
    public void dataChangeCheck(JutakuKaishuJizenShinseiTorokuDiv div) {
        JutakuKaishuJizenShinseiTorokuDivHandler handler = getHandler(div);
        RString state = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (!削除モード.equals(state) && !登録モード.equals(state)) {
            if (!非表示用フラグ_TRUE.equals(div.getHidDataChangeFlg())) {
                handler.画面データ変更有無();
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
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.code());
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
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.code());
        div.setJigyoshaMode(DataPassingConverter.serialize(jigyoshaMode));
        return ResponseData.of(div).respond();
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
