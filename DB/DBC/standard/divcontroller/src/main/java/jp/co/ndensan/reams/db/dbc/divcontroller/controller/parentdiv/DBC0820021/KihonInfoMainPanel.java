/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820021;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.DBC0820021StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.DBC0820021TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.KihonInfoMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820021.KihonInfoMainPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820021.KihonInfoMainPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払支給申請_サービス提供証明書_基本情報画面のクラスです。
 *
 * @reamsid_L DBC-1030-020 wangkanglei
 */
public class KihonInfoMainPanel {

    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 入所院実日数_外泊日数 = new RString("入所(院)実日数＋外泊日数");
    private static final RString 期間日数 = new RString("入所(院)日・退所(院)日の間に収まる日数");
    private static final RString 固定明細番号 = new RString("0001");
    private static final int NUM_1 = 1;
    private static final int 日数 = 30;
    private static final RString 入所年月日 = new RString("入所年月日");
    private static final RString 退所年月日 = new RString("退所年月日");
    private static final RString KEY_1 = new RString("1");
    private static final RString KEY_2 = new RString("2");
    private static final RString KEY_3 = new RString("3");
    private static final RString KEY_4 = new RString("4");

    /**
     * 画面初期化処理のメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onLoad(KihonInfoMainPanelDiv div) {

        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ViewStateHolder.put(ViewStateKeys.申請日, 申請日);
        ArrayList<RString> list = getHandler(div).put様式番号ViewState();
        ViewStateHolder.put(ViewStateKeys.様式番号List, list);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            ShoukanharaihishinseimeisaikensakuParameter parameter = new ShoukanharaihishinseimeisaikensakuParameter(
                    被保険者番号, サービス年月, 申請日, 整理番号, 事業者番号, 様式番号, 固定明細番号);
            ViewStateHolder.put(ViewStateKeys.明細検索キー, parameter);
        }
        ShoukanharaihishinseikensakuParameter 償還払費申請検索 = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(償還払費申請検索.getYoshikiNo(),
                償還払費申請検索.getServiceTeikyoYM());
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        getHandler(div).setヘッダエリア(識別コード, 被保険者番号);
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);

        if (明細番号 == null || 明細番号.isEmpty()) {
            getHandler(div).set初期基本情報();
            getHandler(div).set画面の個別設定(サービス年月, list, 様式番号);
        } else {
            ShokanKihon shokanKihon = ShokanbaraiJyokyoShokai.createInstance()
                    .getShokanbarayiSeikyukihonDetail(被保険者番号,
                            サービス年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号);
            if (shokanKihon == null) {
                throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
            }
            getHandler(div).set基本情報(shokanKihon, サービス年月, list, 様式番号);
            ViewStateHolder.put(ViewStateKeys.基本データ, shokanKihon);
        }

        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri entity = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                    ShoukanharaihishinseimeisaikensakuParameter.class);
            getHandler(div).getボタンを制御(entity, 明細検索キー);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            getHandler(div).set削除状態();
            return ResponseData.of(div).setState(DBC0820021StateName.削除モード);
        } else {
            HokenKyufuRitsu 保険給付率 = JutakuKaishuJizenShinsei.createInstance().getKyufuritsu(被保険者番号, サービス年月);
            getHandler(div).set登録状態(保険給付率);
            if (保険給付率 != null) {
                ViewStateHolder.put(ViewStateKeys.給付率, 保険給付率.value());
            }
        }
        return ResponseData.of(div).setState(DBC0820021StateName.新規修正モード);
    }

    /**
     * 「証明書一覧へ戻る」ボタンのンメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnFree(KihonInfoMainPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.一覧に戻る).respond();
        }
        boolean flag = getHandler(div).get内容変更状態(
                ViewStateHolder.get(ViewStateKeys.基本データ, ShokanKihon.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.様式番号List, List.class),
                ViewStateHolder.get(ViewStateKeys.様式番号, RString.class));
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.一覧に戻る).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請を保存する」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnSave(KihonInfoMainPanelDiv div) {
        try {
            List<RString> 様式番号List = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
            FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
            RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
            boolean flag = getHandler(div).get内容変更状態(ViewStateHolder.get(ViewStateKeys.基本データ, ShokanKihon.class),
                    サービス年月,
                    様式番号List,
                    様式番号);
            if (flag) {
                return check入力項目(div, 様式番号List, サービス年月, 様式番号);
            } else {
                return check内容変更(div);
            }
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    /**
     * 「申請を削除する」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnDelete(KihonInfoMainPanelDiv div) {
        try {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).保存処理(
                        ViewStateHolder.get(ViewStateKeys.明細検索キー,
                                ShoukanharaihishinseimeisaikensakuParameter.class),
                        ViewStateHolder.get(ViewStateKeys.基本データ, ShokanKihon.class),
                        ViewStateHolder.get(ViewStateKeys.処理モード, RString.class),
                        ViewStateHolder.get(ViewStateKeys.様式番号List, List.class));
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace(削除.toString())).respond();
            }
            return ResponseData.of(div).respond();
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    private ResponseData<KihonInfoMainPanelDiv> check内容変更(KihonInfoMainPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KihonInfoMainPanelDiv> check入力項目(KihonInfoMainPanelDiv div,
            List<RString> 様式番号List,
            FlexibleYearMonth サービス年月,
            RString 様式番号) {
        boolean 相違Flag = !new RString(UrWarningMessages.相違.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        boolean 日数３０日超過Flag = !new RString(DbcWarningMessages.日数３０日超過.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        boolean 正常終了Flag = !new RString(UrInformationMessages.正常終了.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        if (!ResponseHolder.isWarningIgnoredRequest()
                && 相違Flag
                && 日数３０日超過Flag
                && 正常終了Flag) {
            ValidationMessageControlPairs pairs = getHandler(div).get入力チェックメッセージ(
                    様式番号List, サービス年月, 様式番号);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return 保存処理(div, 登録, 相違Flag, 日数３０日超過Flag, 正常終了Flag);
    }

    private ResponseData<KihonInfoMainPanelDiv> 保存処理(KihonInfoMainPanelDiv div, RString 状態,
            boolean 相違Flag,
            boolean 日数３０日超過Flag,
            boolean 正常終了Flag) {
        Map<RString, Object> map = getHandler(div).get画面項目();
        RDate 入所_院年月日 = (RDate) map.get(KEY_1);
        RDate 退所_院年月日 = (RDate) map.get(KEY_2);
        if (相違Flag && 日数３０日超過Flag && 正常終了Flag && (入所_院年月日 != null && 退所_院年月日 != null)) {
            int 期間_日数 = 退所_院年月日.plusDay(NUM_1).getBetweenDays(入所_院年月日);
            if (日数 < 期間_日数) {
                WarningMessage message = new WarningMessage(DbcWarningMessages.日数３０日超過.getMessage().getCode(),
                        DbcWarningMessages.日数３０日超過.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message.replace(入所年月日.toString(), 退所年月日.toString())).respond();
            }
        }
        if (相違Flag && 正常終了Flag && (入所_院年月日 != null && 退所_院年月日 != null)) {
            int 期間_日数 = 退所_院年月日.plusDay(NUM_1).getBetweenDays(入所_院年月日);
            Decimal 外泊日数 = (Decimal) map.get(KEY_3);
            Decimal 入所_院実日数 = (Decimal) map.get(KEY_4);
            if (外泊日数 == null) {
                外泊日数 = Decimal.ZERO;
            }
            if (入所_院実日数 == null) {
                入所_院実日数 = Decimal.ZERO;
            }
            int 外泊_入所日数 = 外泊日数.add(入所_院実日数).intValue();
            if (期間_日数 < 外泊_入所日数) {
                WarningMessage message = new WarningMessage(UrWarningMessages.相違.getMessage().getCode(),
                        UrWarningMessages.相違.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message.replace(入所院実日数_外泊日数.toString(),
                        期間日数.toString())).respond();
            }
        }
        if (new RString(UrWarningMessages.相違.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RString 明細番号 = getHandler(div).保存処理(
                    ViewStateHolder.get(ViewStateKeys.明細検索キー,
                            ShoukanharaihishinseimeisaikensakuParameter.class),
                    ViewStateHolder.get(ViewStateKeys.基本データ, ShokanKihon.class),
                    ViewStateHolder.get(ViewStateKeys.処理モード, RString.class),
                    ViewStateHolder.get(ViewStateKeys.様式番号List, List.class));
            getHandler(div).set明細番号(明細番号);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(状態.toString()))
                    .respond();
        }

        if (!new RString(UrInformationMessages.正常終了.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() != MessageDialogSelectedResult.No) {
            RString 明細番号 = getHandler(div).保存処理(
                    ViewStateHolder.get(ViewStateKeys.明細検索キー,
                            ShoukanharaihishinseimeisaikensakuParameter.class),
                    ViewStateHolder.get(ViewStateKeys.基本データ, ShokanKihon.class),
                    ViewStateHolder.get(ViewStateKeys.処理モード, RString.class),
                    ViewStateHolder.get(ViewStateKeys.様式番号List, List.class));
            getHandler(div).set明細番号(明細番号);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(状態.toString()))
                    .respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「給付費明細」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnKyufuMeisai(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.給付費明細).respond();
    }

    /**
     * 「特定診療費」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnTokuteiShiryohi(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnServiceKeikakuhi(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnTokuteinyushosha(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnGokeiinfo(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細（住特）」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnKyufuhiMeisaiJutoku(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnKinkyujiShoteiShikan(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 「緊急時施設療養費」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnKinkyujiShisetsu(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnShokujihiyo(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnSeikyugaku(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタンのメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnShafuku(KihonInfoMainPanelDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.社福軽減額).respond();
    }

    private void getViewState(KihonInfoMainPanelDiv div) {
        ShoukanharaihishinseikensakuParameter paramter = getHandler(div).putViewState(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class));
        ViewStateHolder.put(ViewStateKeys.申請検索キー, paramter);
    }

    private KihonInfoMainPanelHandler getHandler(KihonInfoMainPanelDiv div) {
        return new KihonInfoMainPanelHandler(div);
    }

    private KihonInfoMainPanelValidationHandler getValidationHandler(KihonInfoMainPanelDiv div) {
        return new KihonInfoMainPanelValidationHandler(div);
    }
}
