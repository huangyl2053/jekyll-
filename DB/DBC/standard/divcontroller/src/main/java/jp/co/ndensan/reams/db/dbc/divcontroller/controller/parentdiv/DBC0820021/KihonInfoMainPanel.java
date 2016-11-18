/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.DBC0820021StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.DBC0820021TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.KihonInfoMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820021.KihonInfoMainPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820021.KihonInfoMainPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
        DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (db情報 == null) {
            db情報 = new DbJohoViewState();
        }
        ArrayList<ShokanKihon> 請求基本データList = db情報.get償還払請求基本データList();
        if (null == 請求基本データList) {
            請求基本データList = new ArrayList<>();
        }
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            ShoukanharaihishinseimeisaikensakuParameter parameter = new ShoukanharaihishinseimeisaikensakuParameter(
                    被保険者番号, サービス年月, 申請日, 整理番号, 事業者番号, 様式番号, 固定明細番号);
            ViewStateHolder.put(ViewStateKeys.明細検索キー, parameter);
        }
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(meisaiPar.get様式番号(),
                meisaiPar.getサービス年月());
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        getHandler(div).setヘッダエリア(識別コード, 被保険者番号);
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);

        if (明細番号 == null || 明細番号.isEmpty()) {
            getHandler(div).set初期基本情報();
            getHandler(div).set画面の個別設定(サービス年月, list, 様式番号);
        } else {
            ShokanKihon shokanKihon = null;
            if (!請求基本データList.isEmpty()) {
                ShokanKihon 請求基本データ = getHandler(div).judgeIsContained(請求基本データList, 被保険者番号, 整理番号, サービス年月,
                        事業者番号, 申請日, 明細番号, 様式番号);
                if (null != 請求基本データ) {
                    shokanKihon = 請求基本データ;
                }
            }
            if (null == shokanKihon) {
                shokanKihon = ShokanbaraiJyokyoShokai.createInstance()
                        .getShokanbarayiSeikyukihonDetail(被保険者番号,
                                サービス年月,
                                整理番号,
                                事業者番号,
                                様式番号,
                                明細番号);
                if (null != shokanKihon) {
                    db情報.set償還払請求基本データList(請求基本データList);
                }
            }

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
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDBBAK, db情報);
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
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = (QuestionMessage) DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄
                    .getMessage();
            return ResponseData.of(div).addMessage(message).respond();
        } else {
            //再リクエストの場合の処理
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDBBAK, DbJohoViewState.class);
                ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
                return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.一覧に戻る).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタン のンメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnConfirm(KihonInfoMainPanelDiv div) {
        if (ResponseHolder.isWarningIgnoredRequest()) {
            return ResponseData.of(div).respond();
        }
        return commentEvent(div, DBC0820021TransitionEventName.一覧に戻る);
    }

    private ResponseData<KihonInfoMainPanelDiv> commentEvent(KihonInfoMainPanelDiv div, DBC0820021TransitionEventName eventName) {
        List<RString> 様式番号List = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        judge画面のチェック(div, 様式番号List, サービス年月, 様式番号, eventName);
        if (null == eventName) {
            return ResponseData.of(div).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(eventName).respond();
        }
    }

    private ResponseData<KihonInfoMainPanelDiv> judge証明書入力済のチェック(KihonInfoMainPanelDiv div,
            ShoukanharaihishinseimeisaikensakuParameter meisaiPar,
            FlexibleYearMonth サービス年月, DBC0820021TransitionEventName eventName) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            ShomeishoNyuryokuKanryoKubunType 証明書入力完了フラグ = SyokanbaraihiShikyuShinseiManager.createInstance()
                    .証明書InputCheck(ViewStateHolder.get(ViewStateKeys.証明書入力済フラグ, ShomeishoNyuryokuFlag.class), 識別コード.getColumnValue(), サービス年月);
            if (証明書入力完了フラグ.equals(ShomeishoNyuryokuKanryoKubunType.入力完了)) {
                db情報.get証明書入力完了フラグMap().put(meisaiPar, 証明書入力完了フラグ);
                ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
            } else if (証明書入力完了フラグ.equals(ShomeishoNyuryokuKanryoKubunType.入力未完了)) {
                db情報.get証明書入力完了フラグMap().put(meisaiPar, 証明書入力完了フラグ);
                ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
                throw new ApplicationException(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力.toString());
            }
        }
        return ResponseData.of(div).forwardWithEventName(eventName).respond();
    }

    private void set支給申請(KihonInfoMainPanelDiv div,
            List<RString> 様式番号List,
            RString 様式番号, ShoukanharaihishinseimeisaikensakuParameter meisaiPar, ShokanKihon shokanKihon) {
        DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = db情報.get証明書入力済フラグMap();
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap = db情報.get証明書入力完了フラグMap();

        if (null == 証明書入力済フラグMap) {
            証明書入力済フラグMap = new HashMap<>();
        }
        if (null == 証明書入力完了フラグMap) {
            証明書入力完了フラグMap = new HashMap<>();
        }

        db情報.set証明書入力完了フラグMap(証明書入力完了フラグMap);

        ShomeishoNyuryokuFlag 証明書入力済フラグ = ViewStateHolder.get(ViewStateKeys.証明書入力済フラグ, ShomeishoNyuryokuFlag.class);
        ShokanKihon original基本データ = shokanKihon;
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            shokanKihon = getHandler(div).saveAdd(meisaiPar, shokanKihon, 様式番号, 様式番号List);
            if (null != shokanKihon) {
                証明書入力済フラグ.set基本情報_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力あり);
            } else {
                証明書入力済フラグ.set基本情報_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
            }
            証明書入力済フラグMap.put(meisaiPar, 証明書入力済フラグ);
            db情報.set証明書入力済フラグMap(証明書入力済フラグMap);
        } else {
            shokanKihon = getHandler(div).saveModified(meisaiPar, shokanKihon, 様式番号, 様式番号List);
            if (getHandler(div).judgeIs内容変更(original基本データ, shokanKihon)) {
                shokanKihon = shokanKihon.modified();
            }
        }
        ArrayList<ShokanKihon> 請求基本データList = db情報.get償還払請求基本データList();
        if (null == 請求基本データList) {
            請求基本データList = new ArrayList<>();
        }
        if (請求基本データList.isEmpty()) {
            請求基本データList.add(shokanKihon);
            db情報.set償還払請求基本データList(請求基本データList);
        } else {
            ShokanKihon 既存データ = getHandler(div).judgeIsContained(請求基本データList, shokanKihon);
            if (null != 既存データ) {
                db情報.get償還払請求基本データList().remove(既存データ);
            }
            db情報.get償還払請求基本データList().add(shokanKihon);
        }
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
    }

    private ResponseData<KihonInfoMainPanelDiv> judge画面のチェック(KihonInfoMainPanelDiv div,
            List<RString> 様式番号List,
            FlexibleYearMonth サービス年月,
            RString 様式番号, DBC0820021TransitionEventName eventName) {
        if (!ResponseHolder.isWarningIgnoredRequest()) {
            ValidationMessageControlPairs pairs = getHandler(div).get入力チェックメッセージ(
                    様式番号List, サービス年月, 様式番号);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return 保存処理Check(div, eventName);
    }

    private boolean is日数３０日超過(RDate 入所_院年月日, RDate 退所_院年月日) {
        int 期間_日数 = 退所_院年月日.plusDay(NUM_1).getBetweenDays(入所_院年月日);
        return 日数 < 期間_日数;
    }

    private ResponseData<KihonInfoMainPanelDiv> 保存処理Check(KihonInfoMainPanelDiv div, DBC0820021TransitionEventName eventName) {
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        ShokanKihon shokanKihon = ViewStateHolder.get(ViewStateKeys.基本データ, ShokanKihon.class);
        List<RString> 様式番号List = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);

        getHandler(div).set明細番号(明細検索キー.get明細番号());
        Map<RString, Object> map = getHandler(div).get画面項目();
        RDate 入所_院年月日 = (RDate) map.get(KEY_1);
        RDate 退所_院年月日 = (RDate) map.get(KEY_2);
        if (!ResponseHolder.isReRequest() && (入所_院年月日 != null && 退所_院年月日 != null)) {
            if (is日数３０日超過(入所_院年月日, 退所_院年月日)) {
                WarningMessage message = new WarningMessage(DbcWarningMessages.日数３０日超過.getMessage().getCode(),
                        DbcWarningMessages.日数３０日超過.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message.replace(入所年月日.toString(), 退所年月日.toString())).respond();
            }
        } else {
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return 保存処理Check2(div, 入所_院年月日, 退所_院年月日, eventName, 様式番号List,
                        様式番号, 明細検索キー, shokanKihon);
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return 保存処理Check2(div, 入所_院年月日, 退所_院年月日, eventName, 様式番号List,
                様式番号, 明細検索キー, shokanKihon);
    }

    private ResponseData<KihonInfoMainPanelDiv> 保存処理Check2(KihonInfoMainPanelDiv div, RDate 入所_院年月日, RDate 退所_院年月日,
            DBC0820021TransitionEventName eventName,
            List<RString> 様式番号List,
            RString 様式番号, ShoukanharaihishinseimeisaikensakuParameter meisaiPar, ShokanKihon shokanKihon) {
        Map<RString, Object> map = getHandler(div).get画面項目();
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        if (!ResponseHolder.isReRequest() && (入所_院年月日 != null && 退所_院年月日 != null)) {
            int 期間_日数 = 退所_院年月日.plusDay(NUM_1).getBetweenDays(入所_院年月日);
            Decimal 外泊日数 = (Decimal) map.get(KEY_3);
            Decimal 入所_院実日数 = (Decimal) map.get(KEY_4);
            if (外泊日数 == null) {
                外泊日数 = Decimal.ZERO;
            }
            if (入所_院実日数 == null) {
                入所_院実日数 = Decimal.ZERO;
            }
            if (check入所日と退所日の期間日数(外泊日数, 入所_院実日数, 期間_日数)) {
                WarningMessage message = new WarningMessage(UrWarningMessages.相違.getMessage().getCode(),
                        UrWarningMessages.相違.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message.replace(入所院実日数_外泊日数.toString(),
                        期間日数.toString())).respond();
            }
        } else {
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                set支給申請(div, 様式番号List, 様式番号, meisaiPar, shokanKihon);
                return judge証明書入力済のチェック(div, meisaiPar, サービス年月, eventName);
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                ResponseData.of(div).respond();
            }
        }
        set支給申請(div, 様式番号List, 様式番号, meisaiPar, shokanKihon);
        return judge証明書入力済のチェック(div, meisaiPar, サービス年月, eventName);
    }

    private boolean check入所日と退所日の期間日数(Decimal 外泊日数, Decimal 入所_院実日数, int 期間_日数) {
        int 外泊_入所日数 = 外泊日数.add(入所_院実日数).intValue();
        return 期間_日数 < 外泊_入所日数;
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
        return commentEvent(div, DBC0820021TransitionEventName.給付費明細);
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
        return commentEvent(div, DBC0820021TransitionEventName.特定診療費);
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
        return commentEvent(div, DBC0820021TransitionEventName.サービス計画費);
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
        return commentEvent(div, DBC0820021TransitionEventName.特定入所者費用);
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
        return commentEvent(div, DBC0820021TransitionEventName.合計情報);
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
        return commentEvent(div, DBC0820021TransitionEventName.給付費明細_住特);
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
        return commentEvent(div, DBC0820021TransitionEventName.緊急時_所定疾患);
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
        return commentEvent(div, DBC0820021TransitionEventName.緊急時施設療養費);
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
        return commentEvent(div, DBC0820021TransitionEventName.食事費用);
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
        return commentEvent(div, DBC0820021TransitionEventName.請求額集計);
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
        return commentEvent(div, DBC0820021TransitionEventName.社福軽減額);
    }

    private void getViewState(KihonInfoMainPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter paramter = getHandler(div).putViewState(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.申請日, RDate.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class));
        ViewStateHolder.put(ViewStateKeys.明細検索キー, paramter);
    }

    private KihonInfoMainPanelHandler getHandler(KihonInfoMainPanelDiv div) {
        return new KihonInfoMainPanelHandler(div);
    }

    private KihonInfoMainPanelValidationHandler getValidationHandler(KihonInfoMainPanelDiv div) {
        return new KihonInfoMainPanelValidationHandler(div);
    }
}
