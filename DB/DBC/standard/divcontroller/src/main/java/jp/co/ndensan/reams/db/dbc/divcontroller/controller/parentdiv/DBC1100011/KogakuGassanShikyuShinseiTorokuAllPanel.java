/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1100011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoKanyureki;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoKanyurekiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoDataResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoHoji;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoRelate;
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
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
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
    private static final RString 申請情報を保存する_申請登録 = new RString("btnSaveShinseiToroku");
    private static final RString 申請情報を保存する_変更取下げ = new RString("btnSaveHenkoTorisage");
    private static final int INT_6 = 6;
    private static final RString 完了メッセージ = new RString("高額合算支給申請情報の登録が完了しました。");
    private static final RString 支給申請書整理番号 = new RString("支給申請書整理番号：");
    private static final RString CODE_003 = new RString("003");
    private static final RString 名称_被保険者番号 = new RString("被保険者番号");
    private static final RString 整理番号TMP = new RString("000000");
    private static final RString DBCMN61001 = new RString("DBCMN61001");
    private static final RString DBCMN61005 = new RString("DBCMN61005");
    private static final RString DBCMN61009 = new RString("DBCMN61009");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuAllPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onLoad(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        if (ResponseHolder.isReRequest()
                && new RString(UrErrorMessages.該当データなし
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            ViewStateHolder.put(ViewStateKeys.チェック回数, false);
            handler.申請登録状態初期表示に設定();
            handler.onChange_ddlShinseiTaisyoNendo();
            handler.onChange_ddlShokisaiHokenshaNo();
            div.getTxtKaigoShikyuShinseishoSeiriBango4().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
            return ResponseData.of(div).setState(DBC1100011StateName.申請登録);
        }
        ViewStateHolder.put(ViewStateKeys.チェック回数, true);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書状態, null);
        ViewStateHolder.put(ViewStateKeys.加入歴状態, null);
        KogakuGassanShinseishoDataResult 引き継ぎデータ
                = ViewStateHolder.get(ViewStateKeys.高額介護申請書用データ, KogakuGassanShinseishoDataResult.class);
        RString 照会モード = ViewStateHolder.get(ViewStateKeys.照会モード, RString.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持 = handler.initialize(引き継ぎデータ, 照会モード);
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString メニューID = controlData.getMenuID();
        if (!申請登録状態(メニューID) && 高額合算申請書保持.get高額合算申請書().isEmpty()) {
            return ResponseData.of(div).addMessage(UrErrorMessages.該当データなし.getMessage()).respond();
        }
        ViewStateHolder.put(ViewStateKeys.高額合算申請書保持Entity, 高額合算申請書保持);
        if (RString.isNullOrEmpty(照会モード)) {
            前排他の設定(div);
        }
        if (申請登録状態(メニューID)) {
            handler.申請登録状態初期表示に設定();
            handler.onChange_ddlShinseiTaisyoNendo();
            handler.onChange_ddlShokisaiHokenshaNo();
            div.getTxtKaigoShikyuShinseishoSeiriBango4().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
            return ResponseData.of(div).setState(DBC1100011StateName.申請登録);
        } else {
            if (引き継ぎデータ != null) {
                HihokenshaNo 被保険者番号 = 引き継ぎデータ.get被保険者番号();
                FlexibleYear 対象年度 = 引き継ぎデータ.get対象年度();
                HokenshaNo 保険者番号 = 引き継ぎデータ.get保険者番号();
                RString 整理番号 = 引き継ぎデータ.get整理番号();
                Decimal 履歴番号 = 引き継ぎデータ.get履歴番号();
                KogakuGassanShinseishoIdentifier identifier = new KogakuGassanShinseishoIdentifier(
                        被保険者番号, 対象年度, 保険者番号, 整理番号, 履歴番号);
                KogakuGassanShinseishoRelate 高額合算申請書 = 高額合算申請書保持.get高額合算申請書(identifier);
                正常の場合(高額合算申請書, handler);
                ViewStateHolder.put(ViewStateKeys.高額合算申請書状態, 修正);
            }
            div.getDdlShinseiTaishoNendo().setReadOnly(true);
            if (照会モード != null) {
                div.getTxtKaigoShikyuShinseishoSeiriBango4().setReadOnly(true);
                return ResponseData.of(div).setState(DBC1100011StateName.変更取下げ);
            }
            if (RSTRING_THREE.equals(高額合算申請書保持.get申請状態())) {
                div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(true);
                div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(true);
                div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(true);
            } else {
                div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
                div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
                div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
            }
            div.getTxtKaigoShikyuShinseishoSeiriBango4().setReadOnly(true);
            return ResponseData.of(div).setState(DBC1100011StateName.変更取下げ);
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
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        if (DBC1100011StateName.申請登録加入履歴一覧.getName().equals(ResponseHolder.getState())
                && RSTRING_TWO.equals(高額合算申請書保持.get申請状況())) {
            div.getTabShinseiTorokuPanel2().setVisible(false);
            div.getTabShinseiTorokuPanel3().setVisible(false);
            div.getTabShinseiTorokuPanel4().setVisible(false);
        } else {
            div.getTabShinseiTorokuPanel2().setVisible(true);
            div.getTabShinseiTorokuPanel3().setVisible(true);
            div.getTabShinseiTorokuPanel4().setVisible(true);
        }
        boolean flg
                = ViewStateHolder.get(ViewStateKeys.チェック回数, Boolean.class);
        if (DBC1100011StateName.申請登録.getName().equals(ResponseHolder.getState())
                && !flg) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請情報を保存する_申請登録, true);
        }
        RString 照会モード = ViewStateHolder.get(ViewStateKeys.照会モード, RString.class);
        if (照会モード != null) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請情報を保存する_変更取下げ, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請情報を保存する_変更取下げ, false);

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
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString メニューID = controlData.getMenuID();
        KogakuGassanShinseishoRelate 高額合算申請書Relate;
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        handler.onClick_btnShinseiJohoModoru();
        handler.画面内共有子DIV初期化処理新規場合(対象者);
        if (申請登録状態(メニューID)) {
            handler.申請登録状態初期設定();
            handler.onChange_ddlShinseiTaisyoNendo();
            handler.onChange_ddlShokisaiHokenshaNo();
            div.getTxtKaigoShikyuShinseishoSeiriBango4().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
            handler.新規初期値取得設定();
            onChange_chkKofuShinseiUmu(div);
            FlexibleYear 対象年度 = new FlexibleYear(div.getDdlShinseiTaishoNendo().getSelectedKey());
            HokenshaNo 保険者番号 = new HokenshaNo(div.getTxtTeishutsuHokenshaNo().getValue());
            RString 整理番号Tmp = 整理番号TMP;
            Decimal 履歴番号 = Decimal.ONE;
            高額合算申請書Relate = new KogakuGassanShinseishoRelate(
                    被保険者番号, 対象年度, 保険者番号, 整理番号Tmp, 履歴番号);
        } else if (高額合算申請書保持.is訂正フラグ()) {
            FlexibleYear 対象年度 = 高額合算申請書保持.get対象年度();
            HokenshaNo 保険者番号 = 高額合算申請書保持.get保険者番号();
            RString 整理番号 = 高額合算申請書保持.get整理番号();
            Decimal 履歴番号 = 高額合算申請書保持.get履歴番号();
            高額合算申請書Relate = new KogakuGassanShinseishoRelate(
                    被保険者番号, 対象年度, 保険者番号, 整理番号, 履歴番号);
        } else {
            FlexibleYear 対象年度 = 高額合算申請書保持.get対象年度();
            HokenshaNo 保険者番号 = 高額合算申請書保持.get保険者番号();
            RString 整理番号 = 高額合算申請書保持.get整理番号();
            Decimal 履歴番号 = 高額合算申請書保持.get履歴番号().add(Decimal.ONE);
            高額合算申請書Relate = new KogakuGassanShinseishoRelate(
                    被保険者番号, 対象年度, 保険者番号, 整理番号, 履歴番号);
        }
        ViewStateHolder.put(ViewStateKeys.高額合算申請書, 高額合算申請書Relate);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書状態, 追加);
        return ResponseData.of(div).setState(DBC1100011StateName.申請登録加入履歴一覧);
    }

    private boolean 申請登録状態(RString メニューID) {
        return DBCMN61001.equals(メニューID) || DBCMN61005.equals(メニューID) || DBCMN61009.equals(メニューID);
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
        KogakuGassanShinseishoRelate 高額合算申請書 = 高額合算申請書保持.get高額合算申請書(identifier);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書, 高額合算申請書);
        handler.onClick_dgShinseiJohoModify(高額合算申請書, 高額合算申請書保持.get申請状況());
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
        KogakuGassanShinseishoRelate 高額合算申請書 = 高額合算申請書保持.get高額合算申請書(identifier);
        KogakuGassanShinseishoDataResult 引き継ぎデータ
                = ViewStateHolder.get(ViewStateKeys.高額介護申請書用データ, KogakuGassanShinseishoDataResult.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持New = handler.高額合算申請書編集(
                高額合算申請書, 高額合算申請書保持, 削除, 引き継ぎデータ, 被保険者番号);
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
        KogakuGassanShinseishoRelate 高額合算申請書 = 高額合算申請書保持.get高額合算申請書(identifier);
        handler.onClick_dgShinseiJohoSelect(高額合算申請書, 高額合算申請書保持.get申請状況());
        ViewStateHolder.put(ViewStateKeys.高額合算申請書状態, 照会);
        div.getBtnBackShinseiIchiran().setVisible(false);
        div.getBtnKakuteiShintei().setVisible(false);
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
        KogakuGassanShinseishoRelate 高額合算申請書
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書, KogakuGassanShinseishoRelate.class);
        KogakuGassanShinseishoKanyureki 加入歴 = 高額合算申請書.get高額合算申請書加入歴(identifier);
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
        KogakuGassanShinseishoRelate 高額合算申請書
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書, KogakuGassanShinseishoRelate.class);
        KogakuGassanShinseishoKanyureki 加入歴 = 高額合算申請書.get高額合算申請書加入歴(identifier);
        KogakuGassanShinseishoRelate 高額合算申請書New = handler.加入歴編集(加入歴, 高額合算申請書, 削除);
        handler.加入履歴グリッドへ反映(高額合算申請書New);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書, 高額合算申請書New);
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
        KogakuGassanShinseishoKanyureki 加入歴 = ViewStateHolder.get(ViewStateKeys.加入歴, KogakuGassanShinseishoKanyureki.class);
        KogakuGassanShinseishoRelate 高額合算申請書
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書, KogakuGassanShinseishoRelate.class);
        RString 加入歴状態 = ViewStateHolder.get(ViewStateKeys.加入歴状態, RString.class);
        KogakuGassanShinseishoRelate 高額合算申請書保持New = handler.加入歴編集(加入歴, 高額合算申請書, 加入歴状態);
        handler.加入履歴グリッドへ反映(高額合算申請書保持New);
        div.getKanyuRirekiIchiran().setIsOpen(true);
        div.getKanyuRirekiInput().setIsOpen(false);
        ViewStateHolder.put(ViewStateKeys.高額合算申請書, 高額合算申請書保持New);
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
                        KogakuGassanShinseishoRelate.class).get被保険者番号().getColumnValue();
                排他解除(排他情報.concat(被保険者番号));
            }
            handler.onClick_btnShinseiJohoModoru();
            IUrControlData controlData = UrControlDataFactory.createInstance();
            RString メニューID = controlData.getMenuID();
            if (申請登録状態(メニューID)) {
                div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
                div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
                div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
                return ResponseData.of(div).setState(DBC1100011StateName.申請登録);
            } else {
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
        KogakuGassanShinseishoRelate 高額合算申請書 = ViewStateHolder.get(ViewStateKeys.高額合算申請書, KogakuGassanShinseishoRelate.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持
                = ViewStateHolder.get(ViewStateKeys.高額合算申請書保持Entity, KogakuGassanShinseishoHoji.class);
        RString 高額合算申請書状態 = ViewStateHolder.get(ViewStateKeys.高額合算申請書状態, RString.class);
        KogakuGassanShinseishoDataResult 引き継ぎデータ
                = ViewStateHolder.get(ViewStateKeys.高額介護申請書用データ, KogakuGassanShinseishoDataResult.class);
        KogakuGassanShinseishoHoji 高額合算申請書保持New = handler.高額合算申請書編集(
                高額合算申請書, 高額合算申請書保持, 高額合算申請書状態, 引き継ぎデータ, null);
        handler.申請情報グリッドへ反映(高額合算申請書保持New, false);
        handler.onClick_btnShinseiJohoModoru();
        ViewStateHolder.put(ViewStateKeys.高額合算申請書保持Entity, 高額合算申請書保持New);
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString メニューID = controlData.getMenuID();
        if (申請登録状態(メニューID)) {
            div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(false);
            div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(false);
            return ResponseData.of(div).setState(DBC1100011StateName.申請登録);
        } else {
            div.getTxtIryoShikyuShinseishoSeiriBango2().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango3().setReadOnly(true);
            div.getTxtIryoShikyuShinseishoSeiriBango4().setReadOnly(true);
            return ResponseData.of(div).setState(DBC1100011StateName.変更取下げ);
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
            if (RString.isNullOrEmpty(照会モード) && div.getDgShinseiIchiran().getDataSource() != null) {
                for (dgShinseiIchiran_Row row : div.getDgShinseiIchiran().getDataSource()) {
                    排他解除(排他情報.concat(row.getTxtHihokenshaNo()));
                }
            }
            return ResponseData.of(div).forwardWithEventName(DBC1100011TransitionEventName.戻る).respond();
        }
        if (!変更有無判定(div) && div.getDgShinseiIchiran().getDataSource() != null) {
            for (dgShinseiIchiran_Row row : div.getDgShinseiIchiran().getDataSource()) {
                排他解除(排他情報.concat(row.getTxtHihokenshaNo()));
            }
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
            KogakuGassanShinseishoDataResult 画面項目 = 画面項目編集(div);
            RString 整理番号New = bussiness.getKogakuGassanShikyuShinseishoTorokuKoshin(高額合算申請書保持, 画面項目);
            if (div.getDgShinseiIchiran().getDataSource() != null) {
                List<PersonalData> personalDataList = new ArrayList<>();
                for (dgShinseiIchiran_Row row : div.getDgShinseiIchiran().getDataSource()) {
                    排他解除(排他情報.concat(row.getTxtHihokenshaNo()));
                    IShikibetsuTaisho 被保険者情報 = bussiness.被保険者名の取得(new HihokenshaNo(row.getTxtHihokenshaNo()));
                    ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                            名称_被保険者番号, row.getTxtHihokenshaNo());
                    PersonalData personalData = PersonalData.of(被保険者情報.get識別コード(), expandedInfo);
                    personalDataList.add(personalData);
                }
                AccessLogger.log(AccessLogType.更新, personalDataList);
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

    /**
     * 「完了する」ボタンのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuShinseiTorokuAllPanelDiv> onClick_btnComplete(
            KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC1100011TransitionEventName.完了).respond();
    }

    private KogakuGassanShinseishoDataResult 画面項目編集(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
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
        画面項目.set申請代表者氏名(div.getTxtDaihyoshaShimei().getValue() == null ? null
                : new AtenaMeisho(div.getTxtDaihyoshaShimei().getValue()));
        画面項目.set申請代表者郵便番号(div.getTxtDaihyoshaYubinNo().getValue());
        画面項目.set申請代表者住所(div.getTxtDaihyoshaJusho().getValue());
        画面項目.set申請代表者電話番号(div.getTxtDaihyoshaTelNo().getDomain());
        return 画面項目;
    }

    private boolean 変更有無判定(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        KogakuGassanShikyuShinseiTorokuAllPanelHandler handler = getHandler(div);
        KogakuGassanShinseishoRelate 高額合算申請書 = ViewStateHolder.get(ViewStateKeys.高額合算申請書, KogakuGassanShinseishoRelate.class);
        RString 高額合算申請書状態 = ViewStateHolder.get(ViewStateKeys.高額合算申請書状態, RString.class);
        RString 加入歴状態 = ViewStateHolder.get(ViewStateKeys.加入歴状態, RString.class);
        boolean 登録場合判定フラグ = 追加.equals(高額合算申請書状態) || 追加.equals(加入歴状態);
        return 登録場合判定フラグ || (修正.equals(高額合算申請書状態) && handler.高額合算申請書変更判定(高額合算申請書).hasChanged());
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

    private void 正常の場合(KogakuGassanShinseishoRelate 高額合算申請書, KogakuGassanShikyuShinseiTorokuAllPanelHandler handler) {
        if (高額合算申請書 != null) {
            ViewStateHolder.put(ViewStateKeys.高額合算申請書, 高額合算申請書);
            handler.initializePanel(高額合算申請書);
        }
    }

    private KogakuGassanShikyuShinseiTorokuAllPanelHandler getHandler(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        return new KogakuGassanShikyuShinseiTorokuAllPanelHandler(div);
    }

    private KogakuGassanShikyuShinseiTorokuValidationHandler getValidationhandler(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        return new KogakuGassanShikyuShinseiTorokuValidationHandler(div);
    }
}
