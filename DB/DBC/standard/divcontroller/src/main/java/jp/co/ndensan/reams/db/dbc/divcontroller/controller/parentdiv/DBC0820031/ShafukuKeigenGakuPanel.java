/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820031;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShafukukeigenServiceResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoHenkoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.DBC0820031StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.DBC0820031TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.ShafukuKeigenGakuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820031.ShafukuKeigenGakuPanelHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(社福軽減額）のクラスです。
 *
 * @reamsid_L DBC-1030-080 xuhao
 */
public class ShafukuKeigenGakuPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");

    /**
     * onLoad
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onLoad(ShafukuKeigenGakuPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = 明細検索キー.get被保険者番号();
        FlexibleYearMonth サービス年月 = 明細検索キー.getサービス年月();
        RString 整理番号 = 明細検索キー.get整理番号();
        JigyoshaNo 事業者番号 = 明細検索キー.get事業者番号();
        RString 様式番号 = 明細検索キー.get様式番号();
        RString 明細番号 = 明細検索キー.get明細番号();
        RDate 申請日 = 明細検索キー.get申請日();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);

        ShafukuKeigenGakuPanelHandler handler = getHandler(div);

        List<ShokanShakaiFukushiHojinKeigengakuResult> 法人軽減額リスト = get法人軽減額リスト(被保険者番号, サービス年月,
                整理番号, 事業者番号, 様式番号, 明細番号);

        handler.initialize(法人軽減額リスト, 識別コード, 被保険者番号, サービス年月, 申請日, 事業者番号, 様式番号, 明細番号);

        List<ShafukukeigenServiceResult> サービス種類リスト = SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                getShafukukeigenServiceList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        ViewStateHolder.put(ViewStateKeys.サービス種類集計情報, (ArrayList<ShafukukeigenServiceResult>) サービス種類リスト);

        List<ShakaiFukushiHojinRiyoshaFutanKeigen> 軽減額List = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShafukukeigenKeigenrichiList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        ViewStateHolder.put(ViewStateKeys.軽減率情報, (ArrayList<ShakaiFukushiHojinRiyoshaFutanKeigen>) 軽減額List);

        ShikibetsuNoKanri entity = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShikibetsuNoKanri(サービス年月, 様式番号);
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            handler.getボタンを制御(entity, 明細検索キー);
        }

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            handler.init_Delete();
            return ResponseData.of(div).setState(DBC0820031StateName.削除モード);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnAdd
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnAdd(ShafukuKeigenGakuPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        List<ShafukukeigenServiceResult> サービス種類リスト = ViewStateHolder.get(ViewStateKeys.サービス種類集計情報, ArrayList.class);
        List<ShakaiFukushiHojinRiyoshaFutanKeigen> 軽減額List = ViewStateHolder.get(ViewStateKeys.軽減率情報, ArrayList.class);
        ShafukuKeigenGakuPanelHandler handler = getHandler(div);
        handler.setサービス種類DDL(サービス種類リスト, true);
        handler.set軽減率DDL(軽減額List, true);
        handler.initializeByAdd();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_dgModify
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_dgModify(ShafukuKeigenGakuPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        List<ShafukukeigenServiceResult> サービス種類リスト = ViewStateHolder.get(ViewStateKeys.サービス種類集計情報, ArrayList.class);
        List<ShakaiFukushiHojinRiyoshaFutanKeigen> 軽減額List = ViewStateHolder.get(ViewStateKeys.軽減率情報, ArrayList.class);
        ShafukuKeigenGakuPanelHandler handler = getHandler(div);
        handler.setサービス種類DDL(サービス種類リスト, false);
        handler.set軽減率DDL(軽減額List, false);
        handler.initializeByModify();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_dgDelete
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_dgDelete(ShafukuKeigenGakuPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        List<ShafukukeigenServiceResult> サービス種類リスト = ViewStateHolder.get(ViewStateKeys.サービス種類集計情報, ArrayList.class);
        List<ShakaiFukushiHojinRiyoshaFutanKeigen> 軽減額List = ViewStateHolder.get(ViewStateKeys.軽減率情報, ArrayList.class);
        ShafukuKeigenGakuPanelHandler handler = getHandler(div);
        handler.setサービス種類DDL(サービス種類リスト, false);
        handler.set軽減率DDL(軽減額List, false);
        handler.initializeByDelete();
        return ResponseData.of(div).respond();
    }

    /**
     * onChange_serviceShurui
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onChange_serviceShurui(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).set受領すべき利用者負担の総額(ViewStateHolder.get(ViewStateKeys.サービス種類集計情報, List.class));
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_Calculation
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_Calculation(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).initializeByCalculation();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_Clean
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_Clean(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).initializeByClean();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_Cancel
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_Cancel(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).initializeByCancel();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_Confirm
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_Confirm(ShafukuKeigenGakuPanelDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        List<ShokanShakaiFukushiHojinKeigengakuResult> 法人軽減額リスト = ViewStateHolder.get(ViewStateKeys.社福軽減額一覧情報, ArrayList.class);
        List<ShafukukeigenServiceResult> サービス種類リスト = ViewStateHolder.get(ViewStateKeys.サービス種類集計情報, ArrayList.class);
        getHandler(div).initializeByConfirm(状態, 法人軽減額リスト, サービス種類リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_CommonCancel
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_CommonCancel(ShafukuKeigenGakuPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.一覧に戻る).respond();
        }
        boolean flag = getHandler(div).is内容変更状態();
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.一覧に戻る).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_CommonConfirm
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_CommonConfirm(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, true);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「基本情報」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKihoninfo(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKyufuMeisai(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.給付費明細).respond();
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnTokuteiShiryohi(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnServiceKeikakuhi(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnTokuteinyushosha(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnGokeiinfo(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKyufuhiMeisaiJutoku(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKinkyujiShoteiShikan(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKinkyujiShisetsu(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnShokujihiyo(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnSeikyugaku(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.請求額集計).respond();
    }

    private ShafukuKeigenGakuPanelHandler getHandler(ShafukuKeigenGakuPanelDiv div) {
        return ShafukuKeigenGakuPanelHandler.of(div);
    }

    private List<ShokanShakaiFukushiHojinKeigengakuResult> get法人軽減額リスト(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        List<ShokanShakaiFukushiHojinKeigengakuResult> dbJohoViewList = getDbJohoViewList(被保険者番号, サービス年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
        if (!dbJohoViewList.isEmpty()) {
            return dbJohoViewList;
        }

        List<ShokanShakaiFukushiHojinKeigengakuResult> 法人軽減額リスト = ShokanbaraiJyokyoShokai.createInstance()
                .getSeikyuShakaifukushiHoujinKeigengaku(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        ViewStateHolder.put(ViewStateKeys.社福軽減額一覧情報, (ArrayList<ShokanShakaiFukushiHojinKeigengakuResult>) 法人軽減額リスト);
        return 法人軽減額リスト;
    }

    private List<ShokanShakaiFukushiHojinKeigengakuResult> getDbJohoViewList(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        DbJohoViewState dbJohoViewState = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        List<ShokanShakaiFukushiHojinKeigengakuResult> dbJohoViewList = new ArrayList<>();
        if (dbJohoViewState == null || dbJohoViewState.get償還払請求社会福祉法人軽減額データList() == null
                || dbJohoViewState.get償還払請求社会福祉法人軽減額データList().isEmpty()) {
            return dbJohoViewList;
        }
        for (ShokanShakaiFukushiHojinKeigengakuResult dbJohoView : dbJohoViewState.get償還払請求社会福祉法人軽減額データList()) {
            ShokanShakaiFukushiHojinKeigengaku 法人軽減額 = dbJohoView.getShokanShakai();
            if (被保険者番号.equals(法人軽減額.get被保険者番号())
                    && サービス年月.equals(法人軽減額.getサービス提供年月())
                    && 整理番号.equals(法人軽減額.get整理番号())
                    && 事業者番号.equals(法人軽減額.get事業者番号())
                    && 様式番号.equals(法人軽減額.get様式番号())
                    && 明細番号.equals(法人軽減額.get明細番号())) {
                dbJohoViewList.add(dbJohoView);
            }
        }
        return dbJohoViewList;
    }

    private void putViewState(ShafukuKeigenGakuPanelDiv div, boolean 確定フラグ) {
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = 明細検索キー.get被保険者番号();
        FlexibleYearMonth サービス年月 = 明細検索キー.getサービス年月();
        RString 整理番号 = 明細検索キー.get整理番号();
        JigyoshaNo 事業者番号 = 明細検索キー.get事業者番号();
        RString 様式番号 = 明細検索キー.get様式番号();
        RString 明細番号 = 明細検索キー.get明細番号();
        RDate 申請日 = 明細検索キー.get申請日();

        DbJohoViewState dbJohoViewState = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ArrayList<ShokanShakaiFukushiHojinKeigengakuResult> 法人軽減額リスト = getキー以外のDbJohoViewList(dbJohoViewState,
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);

        ShafukuKeigenGakuPanelHandler handler = getHandler(div);
        法人軽減額リスト.addAll(handler.get法人軽減額リスト(被保険者番号, サービス年月, 申請日, 事業者番号, 様式番号, 明細番号));
        dbJohoViewState.set償還払請求社会福祉法人軽減額データList(法人軽減額リスト);

        if (確定フラグ) {
            RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
            if (登録.equals(処理モード)) {
                Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap
                        = dbJohoViewState.get証明書入力済フラグMap();
                ShomeishoNyuryokuFlag 証明書入力済フラグ = 証明書入力済フラグMap.get(明細検索キー);
                if (handler.is内容変更状態()) {
                    証明書入力済フラグ.set社福軽減額_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力あり);
                    証明書入力済フラグMap.put(明細検索キー, 証明書入力済フラグ);
                    dbJohoViewState.set証明書入力済フラグMap(証明書入力済フラグMap);
                }

                ShomeishoNyuryokuKanryoKubunType 証明書入力済区分 = SyokanbaraihiShikyuShinseiManager.createInstance()
                        .証明書InputCheck(証明書入力済フラグ, 様式番号, サービス年月);
                Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap
                        = dbJohoViewState.get証明書入力完了フラグMap();
                証明書入力完了フラグMap.put(明細検索キー, 証明書入力済区分);
                dbJohoViewState.set証明書入力完了フラグMap(証明書入力完了フラグMap);
                if (ShomeishoNyuryokuKanryoKubunType.入力未完了 == 証明書入力済区分) {
                    // TODO エラー
                }
            }
            if (修正.equals(処理モード) && handler.is内容変更状態()) {
                Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap
                        = dbJohoViewState.get証明書変更済フラグMap();
                ShomeishoHenkoFlag 証明書変更済フラグ = 証明書変更済フラグMap.get(明細検索キー);
                証明書変更済フラグ.set社福軽減額_証明書変更済フラグ(ShomeishoHenkoKubunType.変更あり);
                証明書変更済フラグMap.put(明細検索キー, 証明書変更済フラグ);
                dbJohoViewState.set証明書変更済フラグMap(証明書変更済フラグMap);
            }
        }

        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJohoViewState);
    }

    private ArrayList<ShokanShakaiFukushiHojinKeigengakuResult> getキー以外のDbJohoViewList(DbJohoViewState dbJohoViewState,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        ArrayList<ShokanShakaiFukushiHojinKeigengakuResult> dbJohoViewList = new ArrayList<>();
        if (dbJohoViewState == null || dbJohoViewState.get償還払請求社会福祉法人軽減額データList() == null
                || dbJohoViewState.get償還払請求社会福祉法人軽減額データList().isEmpty()) {
            return dbJohoViewList;
        }
        for (ShokanShakaiFukushiHojinKeigengakuResult dbJohoView : dbJohoViewState.get償還払請求社会福祉法人軽減額データList()) {
            ShokanShakaiFukushiHojinKeigengaku 法人軽減額 = dbJohoView.getShokanShakai();
            if (被保険者番号.equals(法人軽減額.get被保険者番号())
                    && サービス年月.equals(法人軽減額.getサービス提供年月())
                    && 整理番号.equals(法人軽減額.get整理番号())
                    && 事業者番号.equals(法人軽減額.get事業者番号())
                    && 様式番号.equals(法人軽減額.get様式番号())
                    && 明細番号.equals(法人軽減額.get明細番号())) {
                continue;
            }
            dbJohoViewList.add(dbJohoView);
        }
        return dbJohoViewList;
    }
}
