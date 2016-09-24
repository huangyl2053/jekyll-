/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1100011;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoKanyurekiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoDataResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoHoji;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoKanyurekiResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.DBC1100011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.DBC1100011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.KogakuGassanShikyuShinseiTorokuAllPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.dgKanyuRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.dgShinseiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100011.KogakuGassanShikyuShinseiTorokuAllPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100011.KogakuGassanShikyuShinseiTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassan.KogakuGassanShikyuShinseiToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 高額合算支給申請書登録のクラスです。
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuAllPanel {

    private static final RString 照会 = new RString("照会");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 同一被保険者のデータ = new RString("同一被保険者のデータ");
    private static final RString RSTRING_ONE = new RString("1");
    private static final RString RSTRING_TWO = new RString("2");
    private static final RString RSTRING_THREE = new RString("3");
    private static final RString 排他情報 = new RString("DBCHihokenshaNo");
    private static final RString 申請情報を保存する = new RString("btnSaveHenkoTorisage");
    private static final int INT_6 = 6;
    private static final RString 完了メッセージ = new RString("高額合算支給申請情報の登録が完了しました。");
    private static final RString 支給申請書整理番号 = new RString("支給申請書整理番号：");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuAllPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onLoad(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.高額合算申請書状態, null);
        ViewStateHolder.put(ViewStateKeys.加入歴状態, null);
        KogakuGassanShinseishoDataResult 引き継ぎデータ
                = ViewStateHolder.get(ViewStateKeys.高額介護申請書用データ, KogakuGassanShinseishoDataResult.class);
        RString 照会モード = ViewStateHolder.get(ViewStateKeys.照会モード, RString.class);
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        KogakuGassanShinseishoHoji 高額合算申請書保持 = handler.initialize(引き継ぎデータ, 照会モード);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書保持Entity, 高額合算申請書保持);
        if (!RString.isNullOrEmpty(照会モード)) {
            前排他の設定(div);
        }
        if (RSTRING_ONE.equals(高額合算申請書保持.get申請状態())) {
            handler.申請登録状態初期表示に設定();
            handler.onChange_ddlShinseiTaisyoNendo();
            handler.onChange_ddlShokisaiHokenshaNo();
            div.getTxtKaigoShikyuShinseishoSeiriBango4().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
            return ResponseData.of(div).setState(DBC1100011StateName.申請登録);
        } else if (RSTRING_TWO.equals(高額合算申請書保持.get申請状態()) || RSTRING_THREE.equals(高額合算申請書保持.get申請状態())) {
            if (引き継ぎデータ != null) {
                HihokenshaNo 被保険者番号 = 引き継ぎデータ.get被保険者番号();
                FlexibleYear 対象年度 = 引き継ぎデータ.get対象年度();
                HokenshaNo 保険者番号 = 引き継ぎデータ.get保険者番号();
                RString 整理番号 = 引き継ぎデータ.get整理番号();
                Decimal 履歴番号 = 引き継ぎデータ.get履歴番号();
                KogakuGassanShinseishoIdentifier identifier = new KogakuGassanShinseishoIdentifier(
                        被保険者番号, 対象年度, 保険者番号, 整理番号, 履歴番号);
                KogakuGassanShinseishoResult 高額合算申請書 = 高額合算申請書保持.get高額合算申請書(identifier);
                ViewStateHolder.put(ViewStateKeys.高額合算申請書, 高額合算申請書);
                handler.initializePanel(高額合算申請書.get高額合算申請書());
                ViewStateHolder.put(ViewStateKeys.高額合算申請書状態, 修正);
            }
            div.getTxtKaigoShikyuShinseishoSeiriBango4().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(true);
            return ResponseData.of(div).setState(DBC1100011StateName.変更取下げ);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 画面状態状態遷移時画面タイトルを設定のイベントです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuAllPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onStateTransition(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString メニューID = controlData.getMenuID();
        RString タイトル = handler.画面タイトルを設定(メニューID);
        if (DBC1100011StateName.変更取下げ.getName().equals(ResponseHolder.getState())
                && !div.getBtnAddShinsei().isVisible()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請情報を保存する, true);
        }
        return ResponseData.of(div).rootTitle(タイトル).respond();
    }

    /**
     * 申請対象年度DDLのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onChange_ddlShinseiTaisyoNendo(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        handler.onChange_ddlShinseiTaisyoNendo();
        return ResponseData.of(div).respond();
    }

    /**
     * 提出保険者番号DDLのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onChange_ddlShokisaiHokenshaNo(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        handler.onChange_ddlShokisaiHokenshaNo();
        return ResponseData.of(div).respond();
    }

    /**
     * 自己負担額証明書交付申請有CheckBoxのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onChange_chkKofuShinseiUmu(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        if (Collections.EMPTY_LIST.equals(div.getChkKofuShinseiUmu().getSelectedKeys())) {
            div.getDdlShikyuShinseiKeitai().setRequired(true);
        } else {
            div.getDdlShikyuShinseiKeitai().setRequired(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 申請情報グリッド「追加」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_dgShinseiJohoAdd(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.資格対象者, null);
        return ResponseData.of(div).forwardWithEventName(DBC1100011TransitionEventName.対象者検索).respond();
    }

    /**
     * 画面のonActiveメソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuAllPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onActive(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (対象者 == null) {
            return ResponseData.of(div).respond();
        }
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        boolean 重複有無 = handler.重複チェック(被保険者番号);
        if (重複有無) {
            throw new ApplicationException(UrErrorMessages.既に存在.getMessage().replace(同一被保険者のデータ.toString()));
        }
        RString 前排他キー = 排他情報.concat(被保険者番号.getColumnValue());
        排他制御(前排他キー);
        handler.申請登録状態初期表示に設定();
        handler.onChange_ddlShinseiTaisyoNendo();
        handler.onChange_ddlShokisaiHokenshaNo();
        div.getTxtKaigoShikyuShinseishoSeiriBango4().setReadOnly(true);
        div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
        div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
        div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
        handler.画面内共有子DIV初期化処理新規場合(対象者);
        handler.新規初期値取得設定();
        onChange_chkKofuShinseiUmu(div);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書, null);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書状態, 追加);
        return ResponseData.of(div).setState(DBC1100011StateName.申請登録加入履歴一覧);
    }

    /**
     * 申請情報グリッド「修正」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_dgShinseiJohoModify(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        dgShinseiIchiran_Row row = div.getDgShinseiIchiran().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 保険者番号 = new HokenshaNo(row.getTxtHokenshaNo());
        RString 整理番号 = row.getTxtSeiriNo();
        Decimal 履歴番号 = new Decimal(row.getTxtRirekiNo().toString());
        KogakuGassanShinseishoIdentifier identifier = new KogakuGassanShinseishoIdentifier(
                被保険者番号, 対象年度, 保険者番号, 整理番号, 履歴番号);
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        KogakuGassanShinseishoResult 高額合算申請書 = 高額合算申請書保持.get高額合算申請書(identifier);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書, 高額合算申請書);
        handler.onClick_dgShinseiJohoModify(高額合算申請書.get高額合算申請書());
        ViewStateHolder.put(ViewStateKeys.高額合算申請書状態, 修正);
        return ResponseData.of(div).setState(DBC1100011StateName.申請登録加入履歴一覧);
    }

    /**
     * 申請情報グリッド「削除」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_dgShinseiJohoDelete(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        dgShinseiIchiran_Row row = div.getDgShinseiIchiran().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 保険者番号 = new HokenshaNo(row.getTxtHokenshaNo());
        RString 整理番号 = row.getTxtSeiriNo();
        Decimal 履歴番号 = new Decimal(row.getTxtRirekiNo().toString());
        KogakuGassanShinseishoIdentifier identifier = new KogakuGassanShinseishoIdentifier(
                被保険者番号, 対象年度, 保険者番号, 整理番号, 履歴番号);
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        KogakuGassanShinseishoResult 高額合算申請書 = 高額合算申請書保持.get高額合算申請書(identifier);
        KogakuGassanShinseishoDataResult 引き継ぎデータ
                = ViewStateHolder.get(ViewStateKeys.高額介護申請書用データ, KogakuGassanShinseishoDataResult.class);
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持New = handler.高額合算申請書編集(
                高額合算申請書, 高額合算申請書保持, 削除, 引き継ぎデータ, 対象者);
        handler.申請情報グリッドへ反映(高額合算申請書保持New, false);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書保持Entity, 高額合算申請書保持New);
        return ResponseData.of(div).respond();
    }

    /**
     * 申請情報グリッド「選択」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_dgShinseiJohoSelect(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        dgShinseiIchiran_Row row = div.getDgShinseiIchiran().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 保険者番号 = new HokenshaNo(row.getTxtHokenshaNo());
        RString 整理番号 = row.getTxtSeiriNo();
        Decimal 履歴番号 = new Decimal(row.getTxtRirekiNo().toString());
        KogakuGassanShinseishoIdentifier identifier = new KogakuGassanShinseishoIdentifier(
                被保険者番号, 対象年度, 保険者番号, 整理番号, 履歴番号);
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        KogakuGassanShinseishoResult 高額合算申請書 = 高額合算申請書保持.get高額合算申請書(identifier);
        handler.onClick_dgShinseiJohoSelect(高額合算申請書.get高額合算申請書());
        ViewStateHolder.put(ViewStateKeys.高額合算申請書状態, 照会);
        return ResponseData.of(div).setState(DBC1100011StateName.申請登録加入履歴一覧);
    }

    /**
     * 「加入情報を追加する」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_btnKanyuJohoTsuika(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        handler.onClick_btnKanyuJohoTsuika();
        ViewStateHolder.put(ViewStateKeys.加入歴, null);
        ViewStateHolder.put(ViewStateKeys.加入歴状態, 追加);
        return ResponseData.of(div).setState(DBC1100011StateName.申請登録加入履歴情報);
    }

    /**
     * 加入履歴グリッド「修正」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_dgKanyRirekiModify(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        dgKanyuRirekiIchiran_Row row = div.getDgKanyuRirekiIchiran().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 保険者番号 = new HokenshaNo(row.getTxtHokenshaNo());
        RString 整理番号 = row.getTxtSeiriNo();
        RString 加入歴番号 = row.getTxtKanyurekiNo();
        int 履歴番号 = Integer.parseInt(row.getTxtRirekiNo().toString());
        KogakuGassanShinseishoKanyurekiIdentifier identifier = new KogakuGassanShinseishoKanyurekiIdentifier(
                被保険者番号, 対象年度, 保険者番号, 整理番号, 加入歴番号, 履歴番号);
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        KogakuGassanShinseishoKanyurekiResult 加入歴 = 高額合算申請書保持.get加入歴(identifier);
        handler.onClick_dgKanyurekiModify();
        ViewStateHolder.put(ViewStateKeys.加入歴, 加入歴);
        ViewStateHolder.put(ViewStateKeys.加入歴状態, 修正);
        return ResponseData.of(div).setState(DBC1100011StateName.申請登録加入履歴情報);
    }

    /**
     * 加入履歴グリッド「削除」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_dgKanyRirekiDelete(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        dgKanyuRirekiIchiran_Row row = div.getDgKanyuRirekiIchiran().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 保険者番号 = new HokenshaNo(row.getTxtHokenshaNo());
        RString 整理番号 = row.getTxtSeiriNo();
        RString 加入歴番号 = row.getTxtKanyurekiNo();
        int 履歴番号 = Integer.parseInt(row.getTxtRirekiNo().toString());
        KogakuGassanShinseishoKanyurekiIdentifier identifier = new KogakuGassanShinseishoKanyurekiIdentifier(
                被保険者番号, 対象年度, 保険者番号, 整理番号, 加入歴番号, 履歴番号);
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        KogakuGassanShinseishoKanyurekiResult 加入歴 = 高額合算申請書保持.get加入歴(identifier);
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持New = handler.加入歴編集(加入歴, 高額合算申請書保持, 削除, 対象者);
        handler.加入履歴グリッドへ反映(高額合算申請書保持New);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書保持Entity, 高額合算申請書保持New);
        return ResponseData.of(div).respond();
    }

    /**
     * 「加入履歴に戻る」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_btnKanyuRirekiModoru(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        handler.onClick_btnKanyuRirekiModoru();
        return ResponseData.of(div).setState(DBC1100011StateName.申請登録加入履歴一覧);
    }

    /**
     * 「加入情報を確定する」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_btnKanyuRirekKakutei(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuValidationHandler validationHandler = getValidationhandler(div);
        ValidationMessageControlPairs 加入情報確定Pairs = validationHandler.validate加入情報を確定する();
        if (加入情報確定Pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(加入情報確定Pairs).respond();
        }
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        KogakuGassanShinseishoKanyurekiResult 加入歴 = ViewStateHolder.get(ViewStateKeys.加入歴, KogakuGassanShinseishoKanyurekiResult.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        RString 加入歴状態 = ViewStateHolder.get(ViewStateKeys.加入歴状態, RString.class);
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持New = handler.加入歴編集(加入歴, 高額合算申請書保持, 加入歴状態, 対象者);
        handler.加入履歴グリッドへ反映(高額合算申請書保持New);
        div.getKanyuRirekiIchiran().setIsOpen(true);
        div.getKanyuRirekiInput().setIsOpen(false);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書保持Entity, 高額合算申請書保持New);
        return ResponseData.of(div).setState(DBC1100011StateName.申請登録加入履歴一覧);
    }

    /**
     * 「申請情報に戻る」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_btnShinseiJohoModoru(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
            RString 高額合算申請書状態 = ViewStateHolder.get(ViewStateKeys.高額合算申請書状態, RString.class);
            if (追加.equals(高額合算申請書状態)) {
                RString 被保険者番号 = ViewStateHolder.get(
                        ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号().getColumnValue();
                排他解除(排他情報.concat(被保険者番号));
            } else if (修正.equals(高額合算申請書状態)) {
                RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.高額合算申請書,
                        KogakuGassanShinseishoResult.class).get高額合算申請書().get被保険者番号().getColumnValue();
                排他解除(排他情報.concat(被保険者番号));
            }
            handler.onClick_btnShinseiJohoModoru();
            KogakuGassanShinseishoHoji 高額合算申請書保持
                    = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
            if (RSTRING_ONE.equals(高額合算申請書保持.get申請状態())) {
                div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
                div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
                div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
                return ResponseData.of(div).setState(DBC1100011StateName.申請登録);
            } else if (RSTRING_TWO.equals(高額合算申請書保持.get申請状態()) || RSTRING_THREE.equals(高額合算申請書保持.get申請状態())) {
                div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(true);
                div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(true);
                div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(true);
                return ResponseData.of(div).setState(DBC1100011StateName.変更取下げ);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力内容を確定する」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_btnNaiyoKakutei(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuValidationHandler validationHandler = getValidationhandler(div);
        ValidationMessageControlPairs 入力内容確定Pairs = validationHandler.validate入力内容を確定する();
        if (入力内容確定Pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(入力内容確定Pairs).respond();
        }
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        KogakuGassanShinseishoResult 高額合算申請書 = ViewStateHolder.get(ViewStateKeys.高額合算申請書, KogakuGassanShinseishoResult.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        RString 高額合算申請書状態 = ViewStateHolder.get(ViewStateKeys.高額合算申請書状態, RString.class);
        KogakuGassanShinseishoDataResult 引き継ぎデータ
                = ViewStateHolder.get(ViewStateKeys.高額介護申請書用データ, KogakuGassanShinseishoDataResult.class);
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持New = handler.高額合算申請書編集(
                高額合算申請書, 高額合算申請書保持, 高額合算申請書状態, 引き継ぎデータ, 対象者);
        handler.申請情報グリッドへ反映(高額合算申請書保持New, false);
        handler.onClick_btnShinseiJohoModoru();
        ViewStateHolder.put(ViewStateKeys.高額合算申請書保持Entity, 高額合算申請書保持New);
        if (RSTRING_ONE.equals(高額合算申請書保持.get申請状態())) {
            div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
            return ResponseData.of(div).setState(DBC1100011StateName.申請登録);
        } else if (RSTRING_TWO.equals(高額合算申請書保持.get申請状態()) || RSTRING_THREE.equals(高額合算申請書保持.get申請状態())) {
            div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(true);
            return ResponseData.of(div).setState(DBC1100011StateName.変更取下げ);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「検索画面に戻る」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_btnBackKensaku(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        RString 照会モード = ViewStateHolder.get(ViewStateKeys.照会モード, RString.class);
        if (!RString.isNullOrEmpty(照会モード)) {
            return ResponseData.of(div).forwardWithEventName(DBC1100011TransitionEventName.戻る).respond();
        }
        if (変更有無判定(div) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            if (!RString.isNullOrEmpty(照会モード) && div.getDgShinseiIchiran().getDataSource() != null) {
                for (dgShinseiIchiran_Row row : div.getDgShinseiIchiran().getDataSource()) {
                    排他解除(排他情報.concat(row.getTxtHihokenshaNo()));
                }
            }
            return ResponseData.of(div).forwardWithEventName(DBC1100011TransitionEventName.戻る).respond();
        }
        if (!変更有無判定(div)) {
            return ResponseData.of(div).forwardWithEventName(DBC1100011TransitionEventName.戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請情報を保存する」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_btnSave(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuValidationHandler validationHandler = getValidationhandler(div);
        ValidationMessageControlPairs 申請情報保存Pairs = validationHandler.validate申請情報を保存する();
        if (申請情報保存Pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(申請情報保存Pairs).respond();
        }
        if (new RString(DbzInformationMessages.内容変更なしで保存不可
                .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        boolean 変更有無 = handler.変更有無チェック();
        if (変更有無 && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        } else if (!変更有無 && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            KogakuGassanShinseishoHoji 高額合算申請書保持
                    = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
            KogakuGassanShikyuShinseiToroku bussiness = KogakuGassanShikyuShinseiToroku.createInstance();
            KogakuGassanShinseishoDataResult 画面項目 = new KogakuGassanShinseishoDataResult();
            画面項目.set対象年度(new FlexibleYear(div.getDdlShinseiTaishoNendo().getSelectedKey()));
            画面項目.set保険者番号(new HokenshaNo(div.getTxtTeishutsuHokenshaNo().getValue()));
            画面項目.set整理番号(div.getTxtKaigoShikyuShinseishoSeiriBango4().getValue());
            画面項目.set履歴番号(div.getTxtRirekiBango().getValue());
            画面項目.set申請年月日(rDateToFixibleDate(div.getTxtShinseiYMD().getValue()));
            画面項目.set支給申請書整理番号_追加用(div.getTxtKaigoShikyuShinseishoSeiriBango1().getValue()
                    .concat(div.getTxtKaigoShikyuShinseishoSeiriBango2().getValue())
                    .concat(div.getTxtKaigoShikyuShinseishoSeiriBango3().getValue()).padZeroToLeft(INT_6));
            画面項目.set支給申請書整理番号_更新用(RString.EMPTY.concat(div.getTxtKaigoShikyuShinseishoSeiriBango1().getValue())
                    .concat(div.getTxtKaigoShikyuShinseishoSeiriBango2().getValue())
                    .concat(div.getTxtKaigoShikyuShinseishoSeiriBango3().getValue().padZeroToLeft(INT_6))
                    .concat(div.getTxtKaigoShikyuShinseishoSeiriBango4().getValue().padZeroToLeft(INT_6)));
            画面項目.set国保支給申請書整理番号(RString.isNullOrEmpty(div.getTxtIryoShikyuShinseishoSeiriBango2().getValue())
                    && RString.isNullOrEmpty(div.getTxtIryoShikyuShinseishoSeiriBango3().getValue())
                    && RString.isNullOrEmpty(div.getTxtIryoShikyuShinseishoSeiriBango4().getValue())
                    ? RString.EMPTY
                    : RString.EMPTY.concat(div.getTxtIryoShikyuShinseishoSeiriBango1().getValue())
                    .concat(div.getTxtIryoShikyuShinseishoSeiriBango2().getValue())
                    .concat(div.getTxtIryoShikyuShinseishoSeiriBango3().getValue().padZeroToLeft(INT_6))
                    .concat(div.getTxtIryoShikyuShinseishoSeiriBango4().getValue().padZeroToLeft(INT_6)));
            画面項目.set支給申請形態(div.getDdlShikyuShinseiKeitai().getSelectedKey());
            画面項目.set自己負担額証明書交付申請の有無(Collections.EMPTY_LIST.equals(div.getChkKofuShinseiUmu().getSelectedKeys()) ? RSTRING_ONE : RSTRING_TWO);
            RString 整理番号New = bussiness.getKogakuGassanShikyuShinseishoTorokuKoshin(高額合算申請書保持, 画面項目);
            if (div.getDgShinseiIchiran().getDataSource() != null) {
                for (dgShinseiIchiran_Row row : div.getDgShinseiIchiran().getDataSource()) {
                    排他解除(排他情報.concat(row.getTxtHihokenshaNo()));
                }
            }
            RString messageTaisho1;
            if (DBC1100011StateName.申請登録.getName().equals(ResponseHolder.getState())) {
                messageTaisho1 = RString.EMPTY.concat(div.getTxtKaigoShikyuShinseishoSeiriBango1().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango2().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango3().getValue().padZeroToLeft(INT_6))
                        .concat(整理番号New);
            } else {
                messageTaisho1 = RString.EMPTY.concat(div.getTxtKaigoShikyuShinseishoSeiriBango1().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango2().getValue())
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango3().getValue().padZeroToLeft(INT_6))
                        .concat(div.getTxtKaigoShikyuShinseishoSeiriBango4().getValue().padZeroToLeft(INT_6));
            }
            div.getCcdKanryoMessage().setSuccessMessage(完了メッセージ, 支給申請書整理番号.concat(messageTaisho1), RString.EMPTY);
            return ResponseData.of(div).setState(DBC1100011StateName.処理完了);
        }
        return ResponseData.of(div).respond();
    }

    private boolean 変更有無判定(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        KogakuGassanShinseishoResult 高額合算申請書 = ViewStateHolder.get(ViewStateKeys.高額合算申請書, KogakuGassanShinseishoResult.class);
        KogakuGassanShinseishoKanyurekiResult 加入歴 = ViewStateHolder.get(ViewStateKeys.加入歴, KogakuGassanShinseishoKanyurekiResult.class);
        RString 高額合算申請書状態 = ViewStateHolder.get(ViewStateKeys.高額合算申請書状態, RString.class);
        RString 加入歴状態 = ViewStateHolder.get(ViewStateKeys.加入歴状態, RString.class);
        boolean 登録場合判定フラグ = 追加.equals(高額合算申請書状態) || 追加.equals(加入歴状態);
        return 登録場合判定フラグ || (修正.equals(高額合算申請書状態) && handler.高額合算申請書変更判定(高額合算申請書.get高額合算申請書()).hasChanged())
                || (修正.equals(加入歴状態) && handler.加入歴編集(加入歴.get高額合算申請書加入歴()).hasChanged());
    }

    private void 前排他の設定(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) throws PessimisticLockingException {
        List<dgShinseiIchiran_Row> rowList = div.getDgShinseiIchiran().getDataSource();
        if (rowList != null && !rowList.isEmpty()) {
            for (dgShinseiIchiran_Row row : rowList) {
                排他制御(排他情報.concat(row.getTxtHihokenshaNo()));
            }
        }
    }

    private void 排他制御(RString 前排他キー) throws PessimisticLockingException {
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
    }

    private void 排他解除(RString 前排他キー) {
        LockingKey key = new LockingKey(前排他キー);
        RealInitialLocker.release(key);
    }

    private FlexibleDate rDateToFixibleDate(RDate date) {
        if (date == null || new RString(date.toString()).isEmpty()) {
            return null;
        }
        return new FlexibleDate(date.toString());
    }

    private KogakuGassanShikyuShinseiTorokuAllPanelHandler getHandler(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        return new KogakuGassanShikyuShinseiTorokuAllPanelHandler(div);
    }

    private KogakuGassanShikyuShinseiTorokuValidationHandler getValidationhandler(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        return new KogakuGassanShikyuShinseiTorokuValidationHandler(div);
    }
}
