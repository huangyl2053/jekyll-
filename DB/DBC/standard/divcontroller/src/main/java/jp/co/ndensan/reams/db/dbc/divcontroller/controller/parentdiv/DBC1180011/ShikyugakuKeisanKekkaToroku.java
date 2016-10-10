/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1180011;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuGakuKeisanKekkaIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyugakuKeisanKekkaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShikyuGakuKeisanKekkaHosei;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShikyuGakuKeisanKekkaRelate;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.DBC1180011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.DBC1180011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.ShikyugakuKeisanKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.dgKogakuGassanShikyuGakuKeisanKekka_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1180011.ShikyugakuKeisanKekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1180011.ShikyugakuKeisanKekkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassan.KogakuGassanShikyuShinseiTorokuManager;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassan.KogakuGassanShikyugakuKeisanKekkaToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * 高額合算支給額計算結果登録のクラスです。
 *
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class ShikyugakuKeisanKekkaToroku {

    private static final RString 排他情報 = new RString("DBCHihokenshaNo");
    private static final RString CODE_003 = new RString("003");
    private static final int INT_1 = 1;
    private static final RString 名称_被保険者番号 = new RString("被保険者番号");
    private static final RString 追加 = new RString("追加");
    private static final RString 照会 = new RString("照会");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 計算結果を保存する = new RString("btnSave");
    private static final RString 完了メッセージ = new RString("高額合算支給額計算結果の更新が正常に行われました");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onLoad(ShikyugakuKeisanKekkaTorokuDiv div) {
        if (ResponseHolder.isReRequest()
                && new RString(DbcInformationMessages.被保険者でないデータ
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        if ((被保険者番号 == null || RString.EMPTY.equals(
                被保険者番号.getColumnValue())) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcInformationMessages.被保険者でないデータ.getMessage()).respond();
        }
        div.setReadOnly(true);
        RString 前排他キー = 排他情報.concat(対象者.get被保険者番号().getColumnValue());
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        div.setReadOnly(false);
        アクセスログを出力_照会(対象者);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.initialize(対象者);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタンのメソッドです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_btnKensaku(ShikyugakuKeisanKekkaTorokuDiv div) {
        セッションクリア();
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        FlexibleYear 検索年度開始 = div.getTxtKensakuTaishoNendo().getFromValue() == null ? null
                : new FlexibleYear(div.getTxtKensakuTaishoNendo().getFromValue().getNendo().toDateString());
        FlexibleYear 検索年度終了 = div.getTxtKensakuTaishoNendo().getToValue() == null ? null
                : new FlexibleYear(div.getTxtKensakuTaishoNendo().getToValue().getNendo().toDateString());
        boolean 履歴表示 = !Collections.EMPTY_LIST.equals(div.getChkRirekiHyoji().getSelectedKeys());
        KogakuGassanShikyugakuKeisanKekkaToroku service = KogakuGassanShikyugakuKeisanKekkaToroku.createInstance();
        List<KogakuGassanShikyuGakuKeisanKekkaRelate> resultList
                = service.selectShikyugakuKeisanKekka(被保険者番号, 検索年度開始, 検索年度終了, 履歴表示);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.setRow(resultList);
        if (resultList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        KogakuGassanShikyuGakuKeisanKekkaHosei 支給額計算結果情報 = new KogakuGassanShikyuGakuKeisanKekkaHosei();
        支給額計算結果情報.set高額合算支給額計算結果データ(resultList);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果情報, 支給額計算結果情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 画面状態状態遷移時画面共通ボタンを設定のイベントです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuAllPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onStateTransition(
            ShikyugakuKeisanKekkaTorokuDiv div) {
        RString 状態名 = ResponseHolder.getState();
        RString 状態 = ViewStateHolder.get(ViewStateKeys.支給額計算結果状態, RString.class);
        boolean flg1 = DBC1180011StateName.計算結果入力.getName().equals(状態名);
        boolean flg2 = 追加.equals(状態) || 修正.equals(状態) || 削除.equals(状態);
        if (flg1 && flg2) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(計算結果を保存する, true);
        } else {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(計算結果を保存する, false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「計算結果を追加する」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_btnKeisanKekka(ShikyugakuKeisanKekkaTorokuDiv div) {
        ShikyugakuKeisanKekkaTorokuValidationHandler validationhandler = getValidationHandler(div);
        ValidationMessageControlPairs 追加Pairs = validationhandler.validate計算結果を追加する();
        if (追加Pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(追加Pairs).respond();
        }
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.照会状態設定(false);
        handler.onClick_btnKeisanKekka();
        div.getChkSaiso().setReadOnly(true);
        div.getBtnUchiwakeAdd().setDisabled(false);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果状態, 追加);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowSelectButtonColumn(false);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowModifyButtonColumn(true);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowDeleteButtonColumn(true);
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        FlexibleYear 対象年度 = new FlexibleYear(div.getTxtTaishoNendo().getValue().getYear().toDateString());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(div.getTxtShoKisaiHokenshaNoa().getValue());
        RString 支給申請書整理番号 = div.getTxtShikyuShinseishoSeiriNo().getValue();
        int 履歴番号 = INT_1;
        KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekkaRelate(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                履歴番号
        );
        ViewStateHolder.put(ViewStateKeys.支給額計算結果, 支給額計算結果);
        return ResponseData.of(div).setState(DBC1180011StateName.計算結果入力);
    }

    /**
     * 支給額結果グリッド「選択」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_dgShikyuGakuKeisanKekkaSelect(ShikyugakuKeisanKekkaTorokuDiv div) {
        KogakuGassanShikyuGakuKeisanKekkaHosei 支給額計算結果情報
                = ViewStateHolder.get(ViewStateKeys.支給額計算結果情報, KogakuGassanShikyuGakuKeisanKekkaHosei.class);
        dgKogakuGassanShikyuGakuKeisanKekka_Row row = div.getDgKogakuGassanShikyuGakuKeisanKekka().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo().getValue().getYear().toDateString());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(row.getTxtShoKisaiHokenshaNo());
        RString 支給申請書整理番号 = row.getTxtShikyuShinseishoSeiriNo();
        int 履歴番号 = Integer.parseInt(row.getTxtRirekiNo().toString());
        KogakuGassanShikyuGakuKeisanKekkaIdentifier identifier = new KogakuGassanShikyuGakuKeisanKekkaIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                履歴番号
        );
        KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果 = 支給額計算結果情報.get高額合算支給額計算結果(identifier);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        div.getTxtStatusFlg().setValue(照会);
        handler.照会状態設定(true);
        handler.onClick_dgShikyuGakuKeisanKekkaSelect(支給額計算結果);
        div.getChkSaiso().setReadOnly(true);
        div.getBtnUchiwakeAdd().setDisabled(true);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowSelectButtonColumn(true);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowModifyButtonColumn(false);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowDeleteButtonColumn(false);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果, 支給額計算結果);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果状態, 照会);
        return ResponseData.of(div).respond();
    }

    /**
     * 支給額結果グリッド「修正」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_dgShikyuGakuKeisanKekkaModify(ShikyugakuKeisanKekkaTorokuDiv div) {
        KogakuGassanShikyuGakuKeisanKekkaHosei 支給額計算結果情報
                = ViewStateHolder.get(ViewStateKeys.支給額計算結果情報, KogakuGassanShikyuGakuKeisanKekkaHosei.class);
        dgKogakuGassanShikyuGakuKeisanKekka_Row row = div.getDgKogakuGassanShikyuGakuKeisanKekka().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo().getValue().getYear().toDateString());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(row.getTxtShoKisaiHokenshaNo());
        RString 支給申請書整理番号 = row.getTxtShikyuShinseishoSeiriNo();
        int 履歴番号 = Integer.parseInt(row.getTxtRirekiNo().toString());
        KogakuGassanShikyuGakuKeisanKekkaIdentifier identifier = new KogakuGassanShikyuGakuKeisanKekkaIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                履歴番号
        );
        KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果 = 支給額計算結果情報.get高額合算支給額計算結果(identifier);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        div.getTxtStatusFlg().setValue(修正);
        handler.照会状態設定(false);
        handler.onClick_dgShikyuGakuKeisanKekkaSelect(支給額計算結果);
        if (支給額計算結果.get送付年月() != null && !RString.isNullOrEmpty(支給額計算結果.get送付年月().toDateString())) {
            div.getChkSaiso().setReadOnly(false);
        } else {
            div.getChkSaiso().setReadOnly(true);
        }
        div.getBtnUchiwakeAdd().setDisabled(true);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowSelectButtonColumn(false);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowModifyButtonColumn(true);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowDeleteButtonColumn(true);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果, 支給額計算結果);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果状態, 修正);
        return ResponseData.of(div).respond();
    }

    /**
     * 支給額結果グリッド「削除」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_dgShikyuGakuKeisanKekkaDelete(ShikyugakuKeisanKekkaTorokuDiv div) {
        KogakuGassanShikyuGakuKeisanKekkaHosei 支給額計算結果情報
                = ViewStateHolder.get(ViewStateKeys.支給額計算結果情報, KogakuGassanShikyuGakuKeisanKekkaHosei.class);
        dgKogakuGassanShikyuGakuKeisanKekka_Row row = div.getDgKogakuGassanShikyuGakuKeisanKekka().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo().getValue().getYear().toDateString());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(row.getTxtShoKisaiHokenshaNo());
        RString 支給申請書整理番号 = row.getTxtShikyuShinseishoSeiriNo();
        int 履歴番号 = Integer.parseInt(row.getTxtRirekiNo().toString());
        KogakuGassanShikyuGakuKeisanKekkaIdentifier identifier = new KogakuGassanShikyuGakuKeisanKekkaIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                履歴番号
        );
        KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果 = 支給額計算結果情報.get高額合算支給額計算結果(identifier);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        div.getTxtStatusFlg().setValue(削除);
        handler.照会状態設定(true);
        handler.onClick_dgShikyuGakuKeisanKekkaSelect(支給額計算結果);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowSelectButtonColumn(true);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowModifyButtonColumn(false);
        div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getChkSaiso().setReadOnly(true);
        div.getBtnUchiwakeAdd().setDisabled(true);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果, 支給額計算結果);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果状態, 削除);
        return ResponseData.of(div).respond();
    }

    /**
     * 「内訳を追加する」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_btnUchiwakeAdd(ShikyugakuKeisanKekkaTorokuDiv div) {
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.onClick_btnUchiwakeAdd();
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細, null);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細状態, 追加);
        return ResponseData.of(div).respond();
    }

    /**
     * 支給結果明細グリッド「選択」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_dgShikyugakuKeisanKekkaMeisaiSelect(ShikyugakuKeisanKekkaTorokuDiv div) {
        KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果
                = ViewStateHolder.get(ViewStateKeys.支給額計算結果, KogakuGassanShikyuGakuKeisanKekkaRelate.class);
        dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row row = div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(row.getTxtUchiwakeHokenshaNo());
        RString 支給申請書整理番号 = row.getTxtShikyuShinseishoSeiriNo();
        RString 明細番号 = row.getTxtMeisanNo();
        Decimal 履歴番号 = new Decimal(row.getTxtRirekiNo().toString());
        KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier identifier = new KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                明細番号,
                履歴番号
        );
        KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細 = 支給額計算結果.get高額合算支給額計算結果(identifier);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.onClick_dgShikyugakuKeisanKekkaMeisaiSelect(支給額計算結果明細);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細, 支給額計算結果明細);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細状態, 照会);
        return ResponseData.of(div).respond();
    }

    /**
     * 支給結果明細グリッド「修正」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_dgShikyugakuKeisanKekkaMeisaiModify(ShikyugakuKeisanKekkaTorokuDiv div) {
        KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果
                = ViewStateHolder.get(ViewStateKeys.支給額計算結果, KogakuGassanShikyuGakuKeisanKekkaRelate.class);
        dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row row = div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(row.getTxtUchiwakeHokenshaNo());
        RString 支給申請書整理番号 = row.getTxtShikyuShinseishoSeiriNo();
        RString 明細番号 = row.getTxtMeisanNo();
        Decimal 履歴番号 = new Decimal(row.getTxtRirekiNo().toString());
        KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier identifier = new KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                明細番号,
                履歴番号
        );
        KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細 = 支給額計算結果.get高額合算支給額計算結果(identifier);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.onClick_dgShikyugakuKeisanKekkaMeisaiModify(支給額計算結果明細);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細, 支給額計算結果明細);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細状態, 修正);
        return ResponseData.of(div).respond();
    }

    /**
     * 支給結果明細グリッド「削除」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_dgShikyugakuKeisanKekkaMeisaiDelete(ShikyugakuKeisanKekkaTorokuDiv div) {
        KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果
                = ViewStateHolder.get(ViewStateKeys.支給額計算結果, KogakuGassanShikyuGakuKeisanKekkaRelate.class);
        dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row row = div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai().getClickedItem();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 証記載保険者番号 = new HokenshaNo(row.getTxtUchiwakeHokenshaNo());
        RString 支給申請書整理番号 = row.getTxtShikyuShinseishoSeiriNo();
        RString 明細番号 = row.getTxtMeisanNo();
        Decimal 履歴番号 = new Decimal(row.getTxtRirekiNo().toString());
        KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier identifier = new KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                明細番号,
                履歴番号
        );
        KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細 = 支給額計算結果.get高額合算支給額計算結果(identifier);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.onClick_dgShikyugakuKeisanKekkaMeisaiDelete(支給額計算結果明細);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細, 支給額計算結果明細);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細状態, 削除);
        return ResponseData.of(div).respond();
    }

    /**
     * [対象計算期間終了年月日]変更時のイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onChange_txtTaishoKeisanKikan(ShikyugakuKeisanKekkaTorokuDiv div) {
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.onChange_txtTaishoKeisanKikan();
        return ResponseData.of(div).respond();
    }

    /**
     * [① 70歳以上負担額]変更時のイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onBlur_txtOver70Futangaku(ShikyugakuKeisanKekkaTorokuDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.支給額計算結果明細状態, RString.class);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.再計算処理(状態);
        return ResponseData.of(div).respond();
    }

    /**
     * 「内訳一覧に戻る」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_btnUchiwakeIchiramModoru(ShikyugakuKeisanKekkaTorokuDiv div) {
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        handler.onClick_btnUchiwakeIchiramModoru();
        return ResponseData.of(div).respond();
    }

    /**
     * 「内訳を確定する」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_btnUchiwakeKakutei(ShikyugakuKeisanKekkaTorokuDiv div) {
        ShikyugakuKeisanKekkaTorokuValidationHandler validationhandler = getValidationHandler(div);
        ValidationMessageControlPairs 確定Pairs = validationhandler.validate内訳を確定する();
        if (確定Pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(確定Pairs).respond();
        }
        KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果
                = ViewStateHolder.get(ViewStateKeys.支給額計算結果, KogakuGassanShikyuGakuKeisanKekkaRelate.class);
        KogakuGassanShikyugakuKeisanKekkaMeisai 支給額計算結果明細
                = ViewStateHolder.get(ViewStateKeys.支給額計算結果明細, KogakuGassanShikyugakuKeisanKekkaMeisai.class);
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
        支給額計算結果明細 = handler.支給額計算結果明細編集(支給額計算結果明細, 対象者);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.支給額計算結果明細状態, RString.class);
        if (削除.equals(状態)) {
            支給額計算結果 = 支給額計算結果.createBuilderForEdit().delete高額合算支給額計算結果明細(支給額計算結果明細).build();
        } else {
            支給額計算結果 = 支給額計算結果.createBuilderForEdit().set高額合算支給額計算結果明細(支給額計算結果明細).build();
        }
        handler.支給額結果明細グリッド(支給額計算結果.get高額合算支給額計算結果list());
        handler.onClick_btnUchiwakeIchiramModoru();
        handler.内訳合計額計算処理();
        ViewStateHolder.put(ViewStateKeys.支給額計算結果, 支給額計算結果);
        return ResponseData.of(div).respond();
    }

    /**
     * 内訳入力途中タブ変更時のイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onChange_tab(ShikyugakuKeisanKekkaTorokuDiv div) {
        if (!div.getShikyugakuKeisanKekkaTorokuDetailPanel().isReadOnly()
                && !div.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().isDisplayNone()) {
            throw new ApplicationException(DbcErrorMessages.内訳入力途中.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「計算結果一覧に戻る」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_btnBackToIchiran(ShikyugakuKeisanKekkaTorokuDiv div) {
        if (!div.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().isDisplayNone()) {
            throw new ApplicationException(DbcErrorMessages.内訳入力途中.getMessage());
        }
        RString 状態 = ViewStateHolder.get(ViewStateKeys.支給額計算結果状態, RString.class);
        if ((追加.equals(状態) || 修正.equals(状態)) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())
                || (!追加.equals(状態) && !修正.equals(状態))) {
            ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
            handler.画面項目クリア();
            return ResponseData.of(div).setState(DBC1180011StateName.計算結果一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_btnResearch(ShikyugakuKeisanKekkaTorokuDiv div) {
        前排他解除();
        return ResponseData.of(div).forwardWithEventName(DBC1180011TransitionEventName.再検索).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_btnSearchResult(ShikyugakuKeisanKekkaTorokuDiv div) {
        前排他解除();
        return ResponseData.of(div).forwardWithEventName(DBC1180011TransitionEventName.検索結果一覧).respond();
    }

    /**
     * 「計算結果を保存する」ボタンのイベントです。
     *
     * @param div ShikyugakuKeisanKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShikyugakuKeisanKekkaTorokuDiv> onClick_btnSave(ShikyugakuKeisanKekkaTorokuDiv div) {
        if (!div.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().isDisplayNone()) {
            throw new ApplicationException(DbcErrorMessages.内訳入力途中.getMessage());
        }
        RString 状態 = ViewStateHolder.get(ViewStateKeys.支給額計算結果状態, RString.class);
        ShikyugakuKeisanKekkaTorokuValidationHandler validationhandler = getValidationHandler(div);
        if (追加.equals(状態) || 修正.equals(状態)) {
            ValidationMessageControlPairs 保存Pairs = validationhandler.validate計算結果を保存する();
            if (保存Pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(保存Pairs).respond();
            }
        }
        if (!ResponseHolder.isReRequest() && 削除.equals(状態)) {
            ValidationMessageControlPairs 整合性Pairs = validationhandler.validate整合性チェック();
            if (整合性Pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(整合性Pairs).respond();
            }
        }
        if (!ResponseHolder.isWarningIgnoredRequest() && new RString(
                DbcWarningMessages.高額合算支給額計算結果削除確認_支給決定情報あり
                .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        if (!ResponseHolder.isReRequest() || ResponseHolder.isWarningIgnoredRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            ShikyugakuKeisanKekkaTorokuHandler handler = getHandler(div);
            KogakuGassanShikyuGakuKeisanKekkaRelate 支給額計算結果
                    = ViewStateHolder.get(ViewStateKeys.支給額計算結果, KogakuGassanShikyuGakuKeisanKekkaRelate.class);
            KogakuGassanShikyuShinseiTorokuManager maneger = KogakuGassanShikyuShinseiTorokuManager.createInstance();
            if (修正.equals(状態)) {
                支給額計算結果 = handler.支給額計算結果編集(支給額計算結果, 状態);
                maneger.saveModify(支給額計算結果);
            } else if (削除.equals(状態)) {
                maneger.saveDelete(支給額計算結果);
            } else {
                支給額計算結果 = handler.支給額計算結果編集(支給額計算結果, 状態);
                maneger.saveAdd(支給額計算結果);
            }
            前排他解除();
            アクセスログを出力_更新(対象者);
            div.getCcdKanryoMessage().setMessage(完了メッセージ,
                    対象者.get被保険者番号().getColumnValue(), div.getCcdKaigoAtenaInfo().get氏名漢字(), true);
            return ResponseData.of(div).setState(DBC1180011StateName.処理完了);
        }
        return ResponseData.of(div).respond();
    }

    private void アクセスログを出力_照会(TaishoshaKey 対象者) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                名称_被保険者番号, 対象者.get被保険者番号().getColumnValue());
        PersonalData personalData = PersonalData.of(対象者.get識別コード(), expandedInfo);
        AccessLogger.log(AccessLogType.照会, personalData);
    }

    private void アクセスログを出力_更新(TaishoshaKey 対象者) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                名称_被保険者番号, 対象者.get被保険者番号().getColumnValue());
        PersonalData personalData = PersonalData.of(対象者.get識別コード(), expandedInfo);
        AccessLogger.log(AccessLogType.更新, personalData);
    }

    private void 前排他解除() {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        RString 前排他キー = 排他情報.concat(対象者.get被保険者番号().getColumnValue());
        LockingKey key = new LockingKey(前排他キー);
        RealInitialLocker.release(key);
    }

    private void セッションクリア() {
        ViewStateHolder.put(ViewStateKeys.支給額計算結果情報, null);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果, null);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細, null);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果状態, null);
        ViewStateHolder.put(ViewStateKeys.支給額計算結果明細状態, null);
    }

    private ShikyugakuKeisanKekkaTorokuHandler getHandler(ShikyugakuKeisanKekkaTorokuDiv div) {
        return new ShikyugakuKeisanKekkaTorokuHandler(div);
    }

    private ShikyugakuKeisanKekkaTorokuValidationHandler getValidationHandler(ShikyugakuKeisanKekkaTorokuDiv div) {
        return new ShikyugakuKeisanKekkaTorokuValidationHandler(div);
    }
}
