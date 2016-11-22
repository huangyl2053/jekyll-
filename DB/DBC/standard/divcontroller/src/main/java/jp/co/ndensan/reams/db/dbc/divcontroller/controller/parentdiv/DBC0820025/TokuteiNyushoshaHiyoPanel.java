/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820025;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoHenkoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.DBC0820021TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025.DBC0820025StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025.DBC0820025TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025.TokuteiNyushoshaHiyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025.dgdTokuteiYichiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820025.TokuteiNyushoshaHiyoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払い費支給申請決定_サービス提供証明書(特定入所者費用）のクラスです。
 *
 * @reamsid_L DBC-1030-120 wangkanglei
 */
public class TokuteiNyushoshaHiyoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onLoad(TokuteiNyushoshaHiyoPanelDiv div) {

        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();

        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(様式番号,
                サービス年月);
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        getHandler(div).setヘッダエリア(識別コード, 被保険者番号);
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> viewstateServiceHiyoList = new ArrayList<>();
        if (dbJoho != null && dbJoho.get償還払請求特定入所者介護サービス費用データList() != null) {
            viewstateServiceHiyoList = dbJoho.get償還払請求特定入所者介護サービス費用データList();
        }

        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> serviceHiyoList
                = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteyiNyushosyaKaigoserviceHiyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                        null);
        ViewStateHolder.put(ViewStateKeys.サービス費用データ, (Serializable) serviceHiyoList);
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> 表示用サービス費用データ = get表示用サービス費用データ(
                getRealViewStateData(viewstateServiceHiyoList, meisaiPar), serviceHiyoList);

        getHandler(div).set特定入所者費用一覧グリッド(表示用サービス費用データ);

        getHandler(div).set登録エリア制御(false);

        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());

        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(shikibetsuNoKanri, getCount(meisaiPar));
        }

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            getHandler(div).set削除状態();
            return ResponseData.of(div).setState(DBC0820025StateName.削除モード);
        }
        return ResponseData.of(div).setState(DBC0820025StateName.新規修正モード);
    }

    private List<ShokanTokuteiNyushoshaKaigoServiceHiyo> getRealViewStateData(List<ShokanTokuteiNyushoshaKaigoServiceHiyo> viewstateServiceHiyoList,
            ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> list = new ArrayList<>();
        for (ShokanTokuteiNyushoshaKaigoServiceHiyo entity : viewstateServiceHiyoList) {

            if (isRealViewStateData(entity, meisaiPar)) {
                list.add(entity);
            }
        }

        return list;
    }

    private boolean isRealViewStateData(ShokanTokuteiNyushoshaKaigoServiceHiyo entity, ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {

        return entity.get被保険者番号().getColumnValue().equals(meisaiPar.get被保険者番号().getColumnValue())
                && entity.getサービス提供年月().compareTo(meisaiPar.getサービス年月()) == 0 && entity.get整理番号().equals(meisaiPar.get整理番号())
                && entity.get事業者番号().compareTo(meisaiPar.get事業者番号()) == 0
                && entity.get様式番号().equals(meisaiPar.get様式番号()) && entity.get明細番号().equals(meisaiPar.get明細番号());
    }

    private List<ShokanTokuteiNyushoshaKaigoServiceHiyo> get表示用サービス費用データ(List<ShokanTokuteiNyushoshaKaigoServiceHiyo> viewstateServiceHiyoList,
            List<ShokanTokuteiNyushoshaKaigoServiceHiyo> serviceHiyoList) {
        if (viewstateServiceHiyoList == null || viewstateServiceHiyoList.isEmpty()) {
            return serviceHiyoList;
        }

        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> list = new ArrayList<>();

        for (ShokanTokuteiNyushoshaKaigoServiceHiyo サービス費用 : viewstateServiceHiyoList) {

            if (サービス費用.toEntity().getState() == null || EntityDataState.Added.equals(サービス費用.toEntity().getState())) {
                list.add(サービス費用);
                continue;
            }

            if (EntityDataState.Modified.equals(サービス費用.toEntity().getState()) || EntityDataState.Deleted.equals(サービス費用.toEntity().getState())) {
                list.add(サービス費用);
                serviceHiyoList.remove(getRemoveServiceHiyoList(サービス費用, serviceHiyoList));
            }

        }

        list.addAll(serviceHiyoList);
        return list;
    }

    private ShokanTokuteiNyushoshaKaigoServiceHiyo getRemoveServiceHiyoList(ShokanTokuteiNyushoshaKaigoServiceHiyo サービス費用,
            List<ShokanTokuteiNyushoshaKaigoServiceHiyo> serviceHiyoList) {

        for (ShokanTokuteiNyushoshaKaigoServiceHiyo entity : serviceHiyoList) {

            if (isUpdated(entity, サービス費用)) {

                return entity;
            }
        }
        return null;
    }

    private boolean isUpdated(ShokanTokuteiNyushoshaKaigoServiceHiyo entity, ShokanTokuteiNyushoshaKaigoServiceHiyo サービス費用) {
        return entity.get被保険者番号().getColumnValue().equals(サービス費用.get被保険者番号().getColumnValue())
                && entity.getサービス提供年月().compareTo(サービス費用.getサービス提供年月()) == 0 && entity.get整理番号().equals(サービス費用.get整理番号())
                && entity.get事業者番号().compareTo(サービス費用.get事業者番号()) == 0
                && entity.get様式番号().equals(サービス費用.get様式番号()) && entity.get明細番号().equals(サービス費用.get明細番号())
                && entity.get連番().equals(サービス費用.get連番());
    }

    private int getCount(ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        return SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanKihonCount(被保険者番号,
                サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 追加ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnAdd(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).set登録エリア制御(true);
        getHandler(div).readOnly特定入所者費登録エリア(false);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).clear特定入所者費登録エリア();
        return createResponse(div);
    }

    /**
     * グリッドの修正ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_dgdModify(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).set登録エリア制御(true);
        getHandler(div).readOnly特定入所者費登録エリア(false);
        getHandler(div).clear特定入所者費登録エリア();
        getHandler(div).set特定入所者費登録エリア();
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * グリッドの削除ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_dgdDelete(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).set登録エリア制御(true);
        getHandler(div).readOnly特定入所者費登録エリア(true);
        getHandler(div).clear特定入所者費登録エリア();
        getHandler(div).set特定入所者費登録エリア();
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * 特定入所者費登録エリアの「計算する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKeisan(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).click計算結果();
        return createResponse(div);
    }

    /**
     * 特定入所者費登録エリアの「クリアする」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnClear(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).clear特定入所者費登録エリア();
        return createResponse(div);
    }

    /**
     * 特定入所者費登録エリアの「取消する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnCancel(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).cancel特定入所者費登録エリア();
        return createResponse(div);
    }

    /**
     * 特定入所者費登録エリアの「確定する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnConfirm(TokuteiNyushoshaHiyoPanelDiv div) {
        dgdTokuteiYichiran_Row dgdRow;
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (登録.equals(状態)) {
            dgdRow = new dgdTokuteiYichiran_Row();
        } else {
            dgdRow = getHandler(div).getSelectedRow();
        }
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> serviceHiyoList = ViewStateHolder.get(
                ViewStateKeys.サービス費用データ, List.class);
        getHandler(div).modifyRow(dgdRow, 状態, serviceHiyoList);
        getHandler(div).set登録エリア制御(false);
        ViewStateHolder.remove(ViewStateKeys.状態);
        return createResponse(div);
    }

    /**
     * 共通エリア「証明書一覧へ戻る」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnFree(TokuteiNyushoshaHiyoPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.一覧に戻る).respond();
        }
        if (getHandler(div).isChange()) {
            return clear入力内容(div);
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.一覧に戻る).respond();
        }
    }

    private ResponseData<TokuteiNyushoshaHiyoPanelDiv> clear入力内容(TokuteiNyushoshaHiyoPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().getCode(),
                    DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDBBAK, DbJohoViewState.class);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
            return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.一覧に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private ShomeishoNyuryokuFlag set入力有無フラグ(
            TokuteiNyushoshaHiyoPanelDiv div, DbJohoViewState dbJoho, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        ShomeishoNyuryokuFlag nyuryokuFlag = new ShomeishoNyuryokuFlag();
        ShomeishoHenkoFlag henkoFlag = new ShomeishoHenkoFlag();
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = dbJoho.get証明書入力済フラグMap();
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap = dbJoho.get証明書変更済フラグMap();
        if (証明書入力済フラグMap == null) {
            証明書入力済フラグMap = new HashMap<>();
        }
        if (証明書変更済フラグMap == null) {
            証明書変更済フラグMap = new HashMap<>();
        }
        nyuryokuFlag = set証明書入力済フラグMap(証明書入力済フラグMap, kensakuParameter, nyuryokuFlag);
        henkoFlag = set証明書変更済フラグMap(証明書変更済フラグMap, kensakuParameter, henkoFlag);

        set証明書フラグ(処理モード, getHandler(div).isChange(), nyuryokuFlag, 証明書入力済フラグMap, kensakuParameter, dbJoho, henkoFlag, 証明書変更済フラグMap);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
        return nyuryokuFlag;
    }

    private void set証明書フラグ(
            RString 処理モード, boolean is変更あり, ShomeishoNyuryokuFlag nyuryokuFlag,
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap,
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter, DbJohoViewState dbJoho, ShomeishoHenkoFlag henkoFlag,
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap) {
        if (登録.equals(処理モード)) {
            if (is変更あり) {
                nyuryokuFlag.set特定入所者費用_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力あり);
            } else {
                nyuryokuFlag.set特定入所者費用_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
            }
            証明書入力済フラグMap.put(kensakuParameter, nyuryokuFlag);
            dbJoho.set証明書入力済フラグMap(証明書入力済フラグMap);
        }
        if (修正.equals(処理モード)) {
            if (is変更あり) {
                henkoFlag.set特定入所者費用_証明書変更済フラグ(ShomeishoHenkoKubunType.変更あり);
            } else {
                henkoFlag.set特定入所者費用_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
            }
            証明書変更済フラグMap.put(kensakuParameter, henkoFlag);
            dbJoho.set証明書変更済フラグMap(証明書変更済フラグMap);
        }
    }

    private ShomeishoHenkoFlag set証明書変更済フラグMap(
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap,
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter, ShomeishoHenkoFlag henkoFlag) {
        for (Map.Entry<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> mapValue : 証明書変更済フラグMap.entrySet()) {
            ShoukanharaihishinseimeisaikensakuParameter parameter = mapValue.getKey();
            if (is同じキー(parameter, kensakuParameter)) {
                henkoFlag = mapValue.getValue();
                証明書変更済フラグMap.remove(parameter);
            }
        }
        return henkoFlag;
    }

    private boolean is同じキー(
            ShoukanharaihishinseimeisaikensakuParameter parameter, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        return parameter.getサービス年月().equals(kensakuParameter.getサービス年月())
                && parameter.get事業者番号().equals(kensakuParameter.get事業者番号())
                && parameter.get整理番号().equals(kensakuParameter.get整理番号())
                && parameter.get明細番号().equals(kensakuParameter.get明細番号())
                && parameter.get様式番号().equals(kensakuParameter.get様式番号())
                && parameter.get被保険者番号().equals(kensakuParameter.get被保険者番号());
    }

    private ShomeishoNyuryokuFlag set証明書入力済フラグMap(
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap,
            ShoukanharaihishinseimeisaikensakuParameter kensakuParameter, ShomeishoNyuryokuFlag nyuryokuFlag) {
        for (Map.Entry<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> mapValue : 証明書入力済フラグMap.entrySet()) {
            ShoukanharaihishinseimeisaikensakuParameter parameter = mapValue.getKey();
            if (is同じキー(parameter, kensakuParameter)) {
                nyuryokuFlag = mapValue.getValue();
                証明書入力済フラグMap.remove(parameter);
            }
        }
        return nyuryokuFlag;
    }

    /**
     * 「申請を保存する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKakutei(TokuteiNyushoshaHiyoPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);

        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShomeishoNyuryokuFlag nyuryokuFlag = set入力有無フラグ(div, dbJoho, kensakuParameter);
        ShomeishoNyuryokuFlag flag = ViewStateHolder.get(ViewStateKeys.証明書入力済フラグ, ShomeishoNyuryokuFlag.class);
        SyokanbaraihiShikyuShinseiManager manager = SyokanbaraihiShikyuShinseiManager.createInstance();
        ShomeishoNyuryokuKanryoKubunType 証明書入力済区分 = manager.証明書InputCheck(
                nyuryokuFlag, kensakuParameter.get様式番号(), kensakuParameter.getサービス年月());
        if (flag == null) {
            flag = new ShomeishoNyuryokuFlag();
        }
        setDB出力用ViewState(div);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            set証明書入力完了フラグ(証明書入力済区分, dbJoho, kensakuParameter);
        }
        ViewStateHolder.put(ViewStateKeys.証明書入力済フラグ, flag);
        return ResponseData.of(div).forwardWithEventName(DBC0820021TransitionEventName.一覧に戻る).respond();
    }

    private void set証明書入力完了フラグ(
            ShomeishoNyuryokuKanryoKubunType 証明書入力済区分, DbJohoViewState dbJoho, ShoukanharaihishinseimeisaikensakuParameter kensakuParameter) {
        Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> kanryoFlagMap = dbJoho.get証明書入力完了フラグMap();
        if (kanryoFlagMap == null) {
            kanryoFlagMap = new HashMap<>();
        }
        for (Map.Entry<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> mapValue : kanryoFlagMap.entrySet()) {
            ShoukanharaihishinseimeisaikensakuParameter parameter = mapValue.getKey();
            if (parameter.getサービス年月().equals(kensakuParameter.getサービス年月())
                    && parameter.get事業者番号().equals(kensakuParameter.get事業者番号())
                    && parameter.get整理番号().equals(kensakuParameter.get整理番号())
                    && parameter.get明細番号().equals(kensakuParameter.get明細番号())
                    && parameter.get様式番号().equals(kensakuParameter.get様式番号())
                    && parameter.get被保険者番号().equals(kensakuParameter.get被保険者番号())) {
                kanryoFlagMap.remove(parameter);
            }
        }
        kanryoFlagMap.put(kensakuParameter, ShomeishoNyuryokuKanryoKubunType.入力完了);
        dbJoho.set証明書入力完了フラグMap(kanryoFlagMap);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
        if (証明書入力済区分 == ShomeishoNyuryokuKanryoKubunType.入力未完了) {
            throw new ApplicationException(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力.getMessage());
        }
    }

    private void setDB出力用ViewState(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        } else {
            ShokanKihon 請求基本データ = get請求基本データ(dbJoho);
            ShokanKihon shokanKihon = 請求基本データ.createBuilderForEdit().
                    set特定入所者介護サービス費等請求額(div.getPanelTokutei().getTxtHiyogakuTotal().getValue().intValue()).build();
            ArrayList<ShokanKihon> list = new ArrayList<>();
            list.add(shokanKihon);
            dbJoho.set償還払請求基本データList(list);
        }

        if (dbJoho.get償還払請求特定入所者介護サービス費用データList() == null || dbJoho.get償還払請求特定入所者介護サービス費用データList().isEmpty()) {
            dbJoho.set償還払請求特定入所者介護サービス費用データList(new ArrayList<>(get償還払請求特定入所者介護サービス費用(div)));
        } else {

            List<ShokanTokuteiNyushoshaKaigoServiceHiyo> list = dbJoho.get償還払請求特定入所者介護サービス費用データList();
            List<ShokanTokuteiNyushoshaKaigoServiceHiyo> realData = getCurrentData(list);
            if (!realData.isEmpty()) {
                list.removeAll(realData);

            }
            list.addAll(new ArrayList<>(get償還払請求特定入所者介護サービス費用(div)));

        }

        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, dbJoho);
    }

    private ShokanKihon get請求基本データ(DbJohoViewState dbJoho) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        for (ShokanKihon entity : dbJoho.get償還払請求基本データList()) {
            if (entity.get被保険者番号().getColumnValue().equals(meisaiPar.get被保険者番号().getColumnValue())
                    && entity.getサービス提供年月().compareTo(meisaiPar.getサービス年月()) == 0 && entity.get整理番号().equals(meisaiPar.get整理番号())
                    && entity.get事業者番号().compareTo(meisaiPar.get事業者番号()) == 0
                    && entity.get様式番号().equals(meisaiPar.get様式番号()) && entity.get明細番号().equals(meisaiPar.get明細番号())) {
                return entity;
            }
        }
        return null;
    }

    private List<ShokanTokuteiNyushoshaKaigoServiceHiyo> getCurrentData(List<ShokanTokuteiNyushoshaKaigoServiceHiyo> list) {
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> realData = new ArrayList<>();
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);

        for (ShokanTokuteiNyushoshaKaigoServiceHiyo entity : list) {

            if (isRealViewStateData(entity, meisaiPar)) {
                realData.add(entity);
            }
        }

        return realData;
    }

    private List<ShokanTokuteiNyushoshaKaigoServiceHiyo> get償還払請求特定入所者介護サービス費用(TokuteiNyushoshaHiyoPanelDiv div) {

        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);

        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> serviceHiyoList = ViewStateHolder.get(
                ViewStateKeys.サービス費用データ, List.class);

        return getHandler(div).保存処理(meisaiPar, serviceHiyoList);

    }

    private TokuteiNyushoshaHiyoPanelHandler getHandler(TokuteiNyushoshaHiyoPanelDiv div) {
        return new TokuteiNyushoshaHiyoPanelHandler(div);
    }

    private ResponseData<TokuteiNyushoshaHiyoPanelDiv> createResponse(TokuteiNyushoshaHiyoPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「基本情報」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKihoninfo(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKyufuMeisai(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.給付費明細).respond();
    }

    /**
     * 「特定診療費」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnTokuteiShinryouhi(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnServiceKeikakuhi(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「合計情報」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnGokeiinfo(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細（住特）」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKyufuhiMeisaiJutoku(
            TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKinkyujiShoteiShikan(
            TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 「緊急時施設療養費」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKinkyujiShisetsu(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnShokujihiyo(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnSeikyugaku(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnShafuku(TokuteiNyushoshaHiyoPanelDiv div) {
        DbJohoViewState dbJoho = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (dbJoho == null) {
            dbJoho = new DbJohoViewState();
        }
        ShoukanharaihishinseimeisaikensakuParameter kensakuParameter = ViewStateHolder.get(
                ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        set入力有無フラグ(div, dbJoho, kensakuParameter);
        setDB出力用ViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.社福軽減額).respond();
    }

}
