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
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShomeishoGridList;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
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
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
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
    private static final RString 処理_空白 = RString.EMPTY;
    private static final RString 固定明細番号 = new RString("0001");
    private static final RString 証明書戻り_0 = new RString("0");
    private static final RString 証明書戻り_1 = new RString("1");

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
            dbから初期化データ取得(請求基本データList, 被保険者番号, 整理番号, サービス年月, 事業者番号, 申請日, 明細番号, 様式番号,
                    div, db情報, list);
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
            db情報 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .delShokanSyomeisyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, db情報);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
            return ResponseData.of(div).setState(DBC0820021StateName.削除モード);
        } else {
            HokenKyufuRitsu 保険給付率 = JutakuKaishuJizenShinsei.createInstance().getKyufuritsu(被保険者番号, サービス年月);
            getHandler(div).set登録状態(保険給付率);
            if (保険給付率 != null) {
                ViewStateHolder.put(ViewStateKeys.給付率, 保険給付率.value());
            }
        }
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
        return ResponseData.of(div).setState(DBC0820021StateName.新規修正モード);
    }

    private void dbから初期化データ取得(ArrayList<ShokanKihon> 請求基本データList, HihokenshaNo 被保険者番号, RString 整理番号,
            FlexibleYearMonth サービス年月, JigyoshaNo 事業者番号, RDate 申請日, RString 明細番号, RString 様式番号,
            KihonInfoMainPanelDiv div, DbJohoViewState db情報, ArrayList<RString> list) {
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

    /**
     * 「証明書一覧へ戻る」ボタンのンメソッドます。
     *
     * @param div KihonInfoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoMainPanelDiv> onClick_btnFree(KihonInfoMainPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.証明書戻り, 証明書戻り_0);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.一覧に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = (QuestionMessage) DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄
                    .getMessage();
            return ResponseData.of(div).addMessage(message).respond();
        } else if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDBBAK, DbJohoViewState.class);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
            return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.一覧に戻る).respond();
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
        ViewStateHolder.put(ViewStateKeys.証明書戻り, 証明書戻り_1);
        return commentEvent(div, DBC0820021TransitionEventName.一覧に戻る);
    }

    private ResponseData<KihonInfoMainPanelDiv> commentEvent(KihonInfoMainPanelDiv div, DBC0820021TransitionEventName eventName) {
        List<RString> 様式番号List = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                    ShoukanharaihishinseimeisaikensakuParameter.class);
            if (!証明書グリッド存在チェック(db情報, 明細検索キー)) {
                ShomeishoGridList 証明書グリッド = new ShomeishoGridList();
                証明書グリッド.set処理(処理_空白);
                証明書グリッド.set事業者番号(明細検索キー.get事業者番号().value());
                証明書グリッド.set明細(明細検索キー.get明細番号());
                証明書グリッド.setサービス提供証明書(明細検索キー.get様式番号());
                db情報.get証明書グリッドリスト().add(証明書グリッド);
                ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
            }
        }
        return judge画面のチェック(div, 様式番号List, サービス年月, 様式番号, eventName);
    }

    private Boolean 証明書グリッド存在チェック(DbJohoViewState db情報, ShoukanharaihishinseimeisaikensakuParameter 明細検索キー) {
        for (ShomeishoGridList 証明書グリッド : db情報.get証明書グリッドリスト()) {
            if (明細検索キー.get事業者番号().value().equals(証明書グリッド.get事業者番号())
                    && 明細検索キー.get明細番号().equals(証明書グリッド.get明細())
                    && 明細検索キー.get様式番号().equals(証明書グリッド.getサービス提供証明書())) {
                return true;
            }
        }
        return false;
    }

    private ResponseData<KihonInfoMainPanelDiv> judge証明書入力済のチェック(KihonInfoMainPanelDiv div,
            ShoukanharaihishinseimeisaikensakuParameter meisaiPar,
            FlexibleYearMonth サービス年月, DBC0820021TransitionEventName eventName) {
        DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            ShomeishoNyuryokuKanryoKubunType 証明書入力完了フラグ = SyokanbaraihiShikyuShinseiManager.createInstance()
                    .証明書InputCheck(db情報.get証明書入力済フラグMap().get(meisaiPar), meisaiPar.get様式番号(), サービス年月);
            if (証明書入力完了フラグ.equals(ShomeishoNyuryokuKanryoKubunType.入力完了)) {
                db情報.get証明書入力完了フラグMap().put(meisaiPar, 証明書入力完了フラグ);
                ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
            } else if (証明書入力完了フラグ.equals(ShomeishoNyuryokuKanryoKubunType.入力未完了)) {
                db情報.get証明書入力完了フラグMap().put(meisaiPar, 証明書入力完了フラグ);
                ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
                証明書情報未入力チェック(eventName);
            }
        }
        return ResponseData.of(div).forwardWithEventName(eventName).respond();
    }

    private void 証明書情報未入力チェック(DBC0820021TransitionEventName eventName) {
        if (DBC0820021TransitionEventName.一覧に戻る.equals(eventName)) {
            throw new ApplicationException(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力.getMessage().evaluate());
        }
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
        ValidationMessageControlPairs pairs2 = new ValidationMessageControlPairs();
        getValidationHandler(div).validateFor入所と退所間の日数チェック(pairs2);
        getValidationHandler(div).validateFor入所日と退所日の期間日数チェック(pairs2);
        if (pairs2.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs2).respond();
        }
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        ShokanKihon shokanKihon = ViewStateHolder.get(ViewStateKeys.基本データ, ShokanKihon.class);
        set支給申請(div, 様式番号List, 様式番号, 明細検索キー, shokanKihon);
        return judge証明書入力済のチェック(div, 明細検索キー, サービス年月, eventName);
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
