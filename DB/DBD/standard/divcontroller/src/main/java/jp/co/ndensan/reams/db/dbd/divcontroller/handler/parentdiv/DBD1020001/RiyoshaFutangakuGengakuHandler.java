/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.business.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.DBD1020001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.RiyoshaFutangakuGengakuPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.ddlShinseiIchiran_Row;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuService;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 利用者負担額減額申請のハンドラークラスです。
 *
 * @reamsid_L DBD-3600-010 xuyue
 */
public class RiyoshaFutangakuGengakuHandler {

    private final RiyoshaFutangakuGengakuPanelDiv div;

    private final RString 申請メニュー = new RString("DBDMN21002");
    private final RString 承認メニュー = new RString("DBDMN22002");
    private static final RString BTNUPDATE_FIELDNAME = new RString("btnUpdate");
    private static final RString 申請情報を = new RString("申請情報を");
    private static final RString 承認情報を = new RString("承認情報を");
    private static final RString 申請情報を追加する = new RString("申請情報を追加する");
    private static final RString 承認情報を追加する = new RString("承認情報を追加する");
    private static final RString 申請情報 = new RString("申請情報");
    private static final RString 承認情報 = new RString("承認情報");
    private static final RString 承認する_KEY = new RString("key0");
    private static final RString 承認しない_KEY = new RString("key1");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div 利用者負担額減額申請のコントロールdiv
     */
    public RiyoshaFutangakuGengakuHandler(RiyoshaFutangakuGengakuPanelDiv div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     *
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> initialize() {

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);

        div.getCcdAtenaInfo().onLoad(識別コード);
        div.getCcdShinseiJoho().initialize(識別コード);
        div.getCcdKaigoKihon().onLoad(被保険者番号);
        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            div.getBtnInputNew().setText(申請情報を追加する);
            div.getRiyoshaFutangakuGengakuShinseiDetail().setTitle(申請情報);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(BTNUPDATE_FIELDNAME, 申請情報を.toString());
            申請情報エリ状態(false);

        } else if (ResponseHolder.getMenuID().equals(承認メニュー)) {
            div.getBtnInputNew().setText(承認情報を追加する);
            div.getRiyoshaFutangakuGengakuShinseiDetail().setTitle(承認情報);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(BTNUPDATE_FIELDNAME, 承認情報を.toString());
            承認情報エリア状態(承認する_KEY, true);
            div.getBtnConfirm().setDisplayNone(true);
            div.getBtnShinseiKakutei().setDisplayNone(true);
        }

        if (!ResponseHolder.isReRequest()
                && (被保険者番号 == null || 被保険者番号.getColumnValue().isEmpty())) {
            div.getBtnShowGemmenJoho().setDisabled(true);
            div.getBtnInputNew().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNUPDATE_FIELDNAME, true);
            div.getDdlShinseiIchiran().setDisabled(true);
            InformationMessage message = new InformationMessage(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode(),
                    DbdInformationMessages.受給共通_被保データなし.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else if (new RString(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }

        RiyoshaFutangakuGengakuService service = RiyoshaFutangakuGengakuService.createInstance();
        List<RiyoshaFutangakuGengaku> 利用者負担額減額の情報List = service.load利用者負担額減額申請All(被保険者番号);
        if (利用者負担額減額の情報List != null) {
            ViewStateHolder.put(Dbd1020001Keys.DB利用者負担額減額情報List, new ArrayList<>(利用者負担額減額の情報List));
            一覧エリアの設定(利用者負担額減額の情報List);
        }

        PersonalData personalData = toPersonalData();
        AccessLogger.log(AccessLogType.照会, personalData);
        前排他の設定();
        ViewStateHolder.put(Dbd1020001Keys.新規申請の履歴番号, 0);

        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    /**
     * 「承認情報を確定する」ボタン押下の処理です。
     */
    public void 承認情報を確定するボタン押下() {
        div.getDdlShinseiIchiran().setDisabled(false);

        ArrayList<RiyoshaFutangakuGengakuViewState> existsViewStateList = ViewStateHolder.get(Dbd1020001Keys.利用者負担額減額情報ListのViewState, ArrayList.class);
        if (existsViewStateList == null) {
            existsViewStateList = new ArrayList<>();
        }
        RiyoshaFutangakuGengaku 該当DB申請 = ViewStateHolder.get(Dbd1020001Keys.該当DB申請, RiyoshaFutangakuGengaku.class);
        RiyoshaFutangakuGengakuViewState 該当申請のViewState = ViewStateHolder.get(Dbd1020001Keys.該当申請のViewState, RiyoshaFutangakuGengakuViewState.class);

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShoKisaiHokenshaNo 証記載保険者番号;
        int 履歴番号;
        EntityDataState state;
        GemmenGengakuShinsei gemmenGengakuShinsei;
        RiyoshaFutangakuGengakuBuilder builder;
        if (該当DB申請 != null) {
            証記載保険者番号 = 該当DB申請.get証記載保険者番号();
            履歴番号 = 該当DB申請.get履歴番号();

            boolean 変更あり = 申請情報_変更あり(該当DB申請);
            if (変更あり) {
                state = EntityDataState.Modified;
            } else {
                state = EntityDataState.Unchanged;
            }
            if (該当DB申請.getGemmenGengakuShinseiList().size() > 0) {
                gemmenGengakuShinsei = 該当DB申請.getGemmenGengakuShinseiList().get(0);
            } else {
                Integer 新規申請の履歴番号 = ViewStateHolder.get(Dbd1020001Keys.新規申請の履歴番号, Integer.class);
                履歴番号 = 新規申請の履歴番号 - 1;
                ViewStateHolder.put(Dbd1020001Keys.新規申請の履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(証記載保険者番号, 被保険者番号, GemmenGengakuShurui.利用者負担額減額.code(), 履歴番号);
            }
            builder = 該当DB申請.createBuilderForEdit();
        } else {
            state = EntityDataState.Added;
            証記載保険者番号 = get証記載保険者番号(div.getTxtShinseiYmd().getValue());

            if (該当申請のViewState != null) {
                履歴番号 = 該当申請のViewState.getRiyoshaFutangakuGengaku().get履歴番号();
                gemmenGengakuShinsei = 該当申請のViewState.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0);
                builder = 該当申請のViewState.getRiyoshaFutangakuGengaku().createBuilderForEdit();
            } else {
                Integer 新規申請の履歴番号 = ViewStateHolder.get(Dbd1020001Keys.新規申請の履歴番号, Integer.class);
                履歴番号 = 新規申請の履歴番号 - 1;
                ViewStateHolder.put(Dbd1020001Keys.新規申請の履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(証記載保険者番号, 被保険者番号, GemmenGengakuShurui.利用者負担額減額.code(), 履歴番号);
                builder = new RiyoshaFutangakuGengaku(証記載保険者番号, 被保険者番号, 履歴番号).createBuilderForEdit();
            }
        }

        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder = setGemmenGengakuShinseiBuilderBy入力データ(gemmenGengakuShinsei.createBuilderForEdit());
        RString 旧措置 = div.getDdlKyusochiKubun().getSelectedKey();
        RString 決定区分 = div.getRadKetteiKubun().getSelectedKey();
        RString 決定区分コード;
        RString 決定区分TXT;
        HokenKyufuRitsu 給付率;
        FlexibleDate 適用開始年月日 = FlexibleDate.EMPTY;
        FlexibleDate 適用終了年月日 = FlexibleDate.EMPTY;
        RString 非承認理由 = RString.EMPTY;
        if (承認する_KEY.equals(決定区分)) {
            給付率 = new HokenKyufuRitsu(div.getTxtKyufuRitsu().getValue());
            適用開始年月日 = div.getTxtTekiyoYmd().getValue();
            適用終了年月日 = div.getTxtYukoKigenYmd().getValue();
            決定区分コード = KetteiKubun.承認する.getコード();
            決定区分TXT = KetteiKubun.承認する.get名称();
        } else {
            給付率 = HokenKyufuRitsu.ZERO;
            決定区分コード = KetteiKubun.承認しない.getコード();
            決定区分TXT = KetteiKubun.承認しない.get名称();
            非承認理由 = div.getTxtHiShoninRiyu().getText();
            旧措置 = KyuSochishaKubun.非該当.getコード();
        }
        builder.set給付率(給付率);
        builder.set適用開始年月日(適用開始年月日);
        builder.set適用終了年月日(適用終了年月日);
        builder.set非承認理由(非承認理由);
        builder.set決定区分(決定区分コード);
        builder.set申請事由(div.getTxtShinseiRiyu().getValue());
        builder.set申請年月日(div.getTxtShinseiYmd().getValue());
        builder.set旧措置者有無(KyuSochishaKubun.旧措置.getコード().equals(旧措置));
        builder.set決定年月日(div.getTxtKettaiYmd().getValue());
        builder.setGemmenGengakuShinsei(gemmenGengakuShinseiBuilder.build());

        RiyoshaFutangakuGengakuViewState inputView = new RiyoshaFutangakuGengakuViewState(builder.build(), state, 履歴番号);

        ArrayList<RiyoshaFutangakuGengakuViewState> newViewStateList = new ArrayList<>();
        newViewStateList.add(inputView);
        for (RiyoshaFutangakuGengakuViewState existViewState : existsViewStateList) {
            if (existViewState.getRiyoshaFutangakuGengaku().get履歴番号() != inputView.getRiyoshaFutangakuGengaku().get履歴番号()) {
                newViewStateList.add(existViewState);
            }
        }
        ViewStateHolder.put(Dbd1020001Keys.利用者負担額減額情報ListのViewState, newViewStateList);

        List<ddlShinseiIchiran_Row> pageList = div.getDdlShinseiIchiran().getDataSource();
        boolean is新規 = true;
        RString 状態 = RString.EMPTY;
        if (EntityDataState.Added == state) {
            状態 = 追加;
        } else if (EntityDataState.Modified == state) {
            状態 = 修正;
        }
        for (ddlShinseiIchiran_Row row : pageList) {
            if (row.getHiddenShoKisaiHokenshaNo().equals(証記載保険者番号.getColumnValue())
                    && row.getHiddenShinseiRirekiNo().equals(new RString(履歴番号))) {
                row.getTxtShinseiYMD().setValue(div.getTxtShinseiYmd().getValue());
                row.setShinseiRiyu(div.getTxtShinseiRiyu().getValue());
                row.setJotai(状態);
                row.setKetteiKubun(決定区分TXT);
                row.getTxtKetteiYMD().setValue(div.getTxtKettaiYmd().getValue());
                row.getTxtTekiyoYMD().setValue(適用開始年月日);
                row.getTxtYukoKigen().setValue(適用終了年月日);
                row.setKyusochishaUmu(KyuSochishaKubun.旧措置.getコード().equals(旧措置));
                row.getTxtKyufuritsu().setValue(給付率.getColumnValue());
                row.setShoninShinaiRiyu(非承認理由);
                is新規 = false;
            }
        }
        List<ddlShinseiIchiran_Row> newRowList = new ArrayList<>(pageList);
        if (is新規) {
            ddlShinseiIchiran_Row row = new ddlShinseiIchiran_Row();
            row.setJotai(追加);
            row.getTxtShinseiYMD().setValue(div.getTxtShinseiYmd().getValue());
            row.setShinseiRiyu(div.getTxtShinseiRiyu().getValue());
            row.setKetteiKubun(div.getRadKetteiKubun().getSelectedValue());
            row.getTxtKetteiYMD().setValue(div.getTxtKettaiYmd().getValue());
            row.getTxtTekiyoYMD().setValue(適用開始年月日);
            row.getTxtYukoKigen().setValue(適用終了年月日);
            row.setKyusochishaUmu(KyuSochishaKubun.旧措置.getコード().equals(旧措置));
            row.getTxtKyufuritsu().setValue(給付率.getColumnValue());
            row.setShoninShinaiRiyu(非承認理由);
            row.setHiddenShoKisaiHokenshaNo(証記載保険者番号.getColumnValue());
            row.setHiddenShinseiRirekiNo(new RString(履歴番号));

            newRowList.add(row);
        }
        Collections.sort(newRowList, new RiyoshaFutangakuGengakuRowComparator());
        div.getDdlShinseiIchiran().setDataSource(newRowList);
        入力情報をクリア();
        承認情報エリア状態(承認する_KEY, true);
        div.getBtnConfirm().setDisplayNone(true);
    }

    /**
     * 「申請情報を確定する」ボタン押下の処理です。
     */
    public void 申請情報を確定するボタン押下() {
        div.getDdlShinseiIchiran().setDisabled(false);

        ArrayList<RiyoshaFutangakuGengakuViewState> existsViewStateList = ViewStateHolder.get(Dbd1020001Keys.利用者負担額減額情報ListのViewState, ArrayList.class);
        if (existsViewStateList == null) {
            existsViewStateList = new ArrayList<>();
        }
        RiyoshaFutangakuGengaku 該当DB申請 = ViewStateHolder.get(Dbd1020001Keys.該当DB申請, RiyoshaFutangakuGengaku.class);
        RiyoshaFutangakuGengakuViewState 該当申請のViewState = ViewStateHolder.get(Dbd1020001Keys.該当申請のViewState, RiyoshaFutangakuGengakuViewState.class);

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShoKisaiHokenshaNo 証記載保険者番号;
        int 履歴番号;
        EntityDataState state;
        GemmenGengakuShinsei gemmenGengakuShinsei;
        RiyoshaFutangakuGengakuBuilder builder;

        if (該当DB申請 != null) {
            証記載保険者番号 = 該当DB申請.get証記載保険者番号();
            履歴番号 = 該当DB申請.get履歴番号();

            boolean 変更あり = 申請情報_変更あり(該当DB申請);
            if (変更あり) {
                state = EntityDataState.Modified;
            } else {
                state = EntityDataState.Unchanged;
            }
            if (該当DB申請.getGemmenGengakuShinseiList().size() > 0) {
                gemmenGengakuShinsei = 該当DB申請.getGemmenGengakuShinseiList().get(0);
            } else {
                Integer 新規申請の履歴番号 = ViewStateHolder.get(Dbd1020001Keys.新規申請の履歴番号, Integer.class);
                履歴番号 = 新規申請の履歴番号 - 1;
                ViewStateHolder.put(Dbd1020001Keys.新規申請の履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(証記載保険者番号, 被保険者番号, GemmenGengakuShurui.利用者負担額減額.code(), 履歴番号);
            }
            builder = 該当DB申請.createBuilderForEdit();
        } else {
            state = EntityDataState.Added;
            証記載保険者番号 = get証記載保険者番号(div.getTxtShinseiYmd().getValue());

            if (該当申請のViewState != null) {
                履歴番号 = 該当申請のViewState.getRiyoshaFutangakuGengaku().get履歴番号();
                gemmenGengakuShinsei = 該当申請のViewState.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0);
                builder = 該当申請のViewState.getRiyoshaFutangakuGengaku().createBuilderForEdit();
            } else {
                Integer 新規申請の履歴番号 = ViewStateHolder.get(Dbd1020001Keys.新規申請の履歴番号, Integer.class);
                履歴番号 = 新規申請の履歴番号 - 1;
                ViewStateHolder.put(Dbd1020001Keys.新規申請の履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(証記載保険者番号, 被保険者番号, GemmenGengakuShurui.利用者負担額減額.code(), 履歴番号);
                builder = new RiyoshaFutangakuGengaku(証記載保険者番号, 被保険者番号, 履歴番号).createBuilderForEdit();
            }
        }

        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder = setGemmenGengakuShinseiBuilderBy入力データ(gemmenGengakuShinsei.createBuilderForEdit());
        builder.set申請事由(div.getTxtShinseiRiyu().getValue());
        builder.set申請年月日(div.getTxtShinseiYmd().getValue());
        builder.setGemmenGengakuShinsei(gemmenGengakuShinseiBuilder.build());
        RiyoshaFutangakuGengakuViewState inputView = new RiyoshaFutangakuGengakuViewState(builder.build(), state, 履歴番号);

        ArrayList<RiyoshaFutangakuGengakuViewState> newViewStateList = new ArrayList<>();
        newViewStateList.add(inputView);
        for (RiyoshaFutangakuGengakuViewState existViewState : existsViewStateList) {
            if (existViewState.getRiyoshaFutangakuGengaku().get履歴番号() != inputView.getRiyoshaFutangakuGengaku().get履歴番号()) {
                newViewStateList.add(existViewState);
            }
        }
        ViewStateHolder.put(Dbd1020001Keys.利用者負担額減額情報ListのViewState, newViewStateList);

        List<ddlShinseiIchiran_Row> pageList = div.getDdlShinseiIchiran().getDataSource();
        boolean is新規 = true;
        RString 状態 = RString.EMPTY;
        if (EntityDataState.Added == state) {
            状態 = 追加;
        } else if (EntityDataState.Modified == state) {
            状態 = 修正;
        }

        for (ddlShinseiIchiran_Row row : pageList) {
            if (row.getHiddenShoKisaiHokenshaNo().equals(証記載保険者番号.getColumnValue())
                    && row.getHiddenShinseiRirekiNo().equals(new RString(履歴番号))) {
                row.getTxtShinseiYMD().setValue(div.getTxtShinseiYmd().getValue());
                row.setShinseiRiyu(div.getTxtShinseiRiyu().getValue());
                row.setJotai(状態);
                is新規 = false;
            }
        }
        List<ddlShinseiIchiran_Row> newRowList = new ArrayList<>(pageList);
        if (is新規) {
            ddlShinseiIchiran_Row row = new ddlShinseiIchiran_Row();
            row.getTxtShinseiYMD().setValue(div.getTxtShinseiYmd().getValue());
            row.setShinseiRiyu(div.getTxtShinseiRiyu().getValue());
            row.setJotai(追加);
            row.setHiddenShoKisaiHokenshaNo(証記載保険者番号.getColumnValue());
            row.setHiddenShinseiRirekiNo(new RString(履歴番号));

            newRowList.add(row);
        }
        Collections.sort(newRowList, new RiyoshaFutangakuGengakuRowComparator());
        div.getDdlShinseiIchiran().setDataSource(newRowList);
        入力情報をクリア();
        申請情報エリ状態(false);
    }

    /**
     * 「申請情報を追加する/承認情報を追加する」ボタン押下の処理です。
     */
    public void 追加するボタン押下() {
        該当情報ViewStateのクリア();
        入力情報をクリア();

        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            申請情報エリ状態(true);
        } else if (ResponseHolder.getMenuID().equals(承認メニュー)) {
            div.getRadKetteiKubun().setSelectedKey(承認する_KEY);
            div.getTxtKettaiYmd().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
            承認情報エリア状態(承認する_KEY, true);
            div.getBtnConfirm().setDisplayNone(false);
        }
    }

    /**
     * 申請一覧の修正ボタン押下の処理です。
     */
    public void 申請一覧の修正ボタンをクリック() {

        該当情報ViewStateのクリア();
        入力情報をクリア();
        div.getDdlShinseiIchiran().setDisabled(true);

        ddlShinseiIchiran_Row row = div.getDdlShinseiIchiran().getActiveRow();

        RiyoshaFutangakuGengaku 該当DB申請 = get該当DB申請(row);
        if (該当DB申請 != null) {
            ViewStateHolder.put(Dbd1020001Keys.該当DB申請, 該当DB申請);
        }
        RiyoshaFutangakuGengakuViewState 該当申請のViewState = get該当申請のViewState(row);
        if (該当申請のViewState != null) {
            ViewStateHolder.put(Dbd1020001Keys.該当申請のViewState, 該当申請のViewState);
        }

        FlexibleDate 申請日 = row.getTxtShinseiYMD().getValue();
        RString 申請理由 = row.getShinseiRiyu();
        RString 決定区分 = row.getKetteiKubun();
        RString 決定区分RadInx;
        if (KetteiKubun.承認する.get名称().equals(決定区分) || 決定区分.isEmpty()) {
            決定区分RadInx = 承認する_KEY;
        } else {
            決定区分RadInx = 承認しない_KEY;
        }
        FlexibleDate 決定日 = row.getTxtKetteiYMD().getValue();
        FlexibleDate 適用日 = row.getTxtTekiyoYMD().getValue();
        FlexibleDate 有効期限 = row.getTxtYukoKigen().getValue();
        boolean 旧措置有無 = row.getKyusochishaUmu();
        Decimal 給付率 = row.getTxtKyufuritsu().getValue();
        RString 承認しない理由 = row.getShoninShinaiRiyu();

        div.getTxtShinseiYmd().setValue(申請日);
        div.getTxtShinseiRiyu().setValue(申請理由);
        div.getCcdShinseiJoho().set減免減額申請情報(減免減額申請共有子Divの設定(), 申請日);
        div.getRadKetteiKubun().setSelectedKey(決定区分RadInx);
        div.getTxtKettaiYmd().setValue(決定日);
        div.getTxtTekiyoYmd().setValue(適用日);
        div.getTxtYukoKigenYmd().setValue(有効期限);
        div.getDdlKyusochiKubun().setDataSource(getDdlKyusochiKubun());

        if (旧措置有無) {
            div.getDdlKyusochiKubun().setSelectedKey(KyuSochishaKubun.旧措置.getコード());
        } else {
            div.getDdlKyusochiKubun().setSelectedKey(KyuSochishaKubun.非該当.getコード());
        }
        div.getTxtKyufuRitsu().setValue(給付率);
        div.getTxtHiShoninRiyu().setValue(承認しない理由);

        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            申請情報エリ状態(true);
            div.getBtnShinseiKakutei().setDisplayNone(false);
        } else if (ResponseHolder.getMenuID().equals(承認メニュー)) {
            承認情報エリア状態(決定区分RadInx, false);
            div.getBtnConfirm().setDisplayNone(false);
        }
    }

    /**
     * 申請一覧の削除ボタン押下の処理です。
     */
    public void 申請一覧の削除ボタンをクリック() {

        ArrayList<RiyoshaFutangakuGengakuViewState> list = ViewStateHolder.get(Dbd1020001Keys.利用者負担額減額情報ListのViewState, ArrayList.class);
        if (list == null) {
            list = new ArrayList<>();
        }

        ddlShinseiIchiran_Row row = div.getDdlShinseiIchiran().getActiveRow();

        if (追加.equals(row.getJotai())) {
            div.getDdlShinseiIchiran().getDataSource().remove(row);

            for (RiyoshaFutangakuGengakuViewState joho : list) {
                if (joho.getRiyoshaFutangakuGengaku().get証記載保険者番号().getColumnValue().equals(row.getHiddenShoKisaiHokenshaNo())
                        && new RString(joho.getRiyoshaFutangakuGengaku().get履歴番号()).equals(row.getHiddenShinseiRirekiNo())) {
                    list.remove(joho);
                    break;
                }
            }
            ViewStateHolder.put(Dbd1020001Keys.利用者負担額減額情報ListのViewState, list);
        } else {
            row.setJotai(削除);

            ArrayList<RiyoshaFutangakuGengakuViewState> newList = new ArrayList<>();
            for (RiyoshaFutangakuGengakuViewState joho : list) {
                if (joho.getRiyoshaFutangakuGengaku().get証記載保険者番号().getColumnValue().equals(row.getHiddenShoKisaiHokenshaNo())
                        && new RString(joho.getRiyoshaFutangakuGengaku().get履歴番号()).equals(row.getHiddenShinseiRirekiNo())) {
                    RiyoshaFutangakuGengakuViewState deleteJoho = joho.createBuilderForEdit().setState(EntityDataState.Deleted).build();
                    newList.add(deleteJoho);
                } else {
                    newList.add(joho);
                }
            }
            ViewStateHolder.put(Dbd1020001Keys.利用者負担額減額情報ListのViewState, newList);
        }
    }

    /**
     * viewStateの破棄処理です。
     */
    public void viewState破棄() {
        ViewStateHolder.put(Dbd1020001Keys.利用者負担額減額情報ListのViewState, null);
        入力情報をクリア();
    }

    /**
     * 申請情報エリ状態の設定です。
     *
     * @param is確定ボタン表示 true:表示 false:非表示
     */
    public void 申請情報エリ状態(boolean is確定ボタン表示) {
        div.getRadKetteiKubun().setDisabled(true);
        div.getTxtKettaiYmd().setDisabled(true);
        div.getTxtTekiyoYmd().setDisabled(true);
        div.getTxtYukoKigenYmd().setDisabled(true);
        div.getDdlKyusochiKubun().setDisabled(true);
        div.getTxtKyufuRitsu().setDisabled(true);
        div.getBtnHiShoninRiyu().setDisabled(true);
        div.getTxtHiShoninRiyu().setDisabled(true);
        div.getBtnShinseiKakutei().setDisplayNone(!is確定ボタン表示);
        div.getBtnConfirm().setDisplayNone(true);
    }

    /**
     * 承認情報エリ状態の設定です。
     *
     * @param 決定区分 承認する:key0, 承認しない:key1
     * @param is初期 true:初期
     */
    public void 承認情報エリア状態(RString 決定区分, boolean is初期) {
        div.getRadKetteiKubun().setDisabled(false);
        div.getTxtKettaiYmd().setDisabled(false);

        if (承認する_KEY.equals(決定区分)) {
            div.getTxtTekiyoYmd().setDisabled(false);
            div.getTxtYukoKigenYmd().setDisabled(false);
            div.getDdlKyusochiKubun().setDisabled(false);
            div.getTxtKyufuRitsu().setDisabled(false);
            div.getBtnHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
            div.getDdlKyusochiKubun().setDataSource(getDdlKyusochiKubun());
            if (is初期) {
                div.getDdlKyusochiKubun().setSelectedKey(KyuSochishaKubun.非該当.getコード());
            }

        } else {
            div.getTxtTekiyoYmd().setDisabled(true);
            div.getTxtYukoKigenYmd().setDisabled(true);
            div.getDdlKyusochiKubun().setDisabled(true);
            div.getTxtKyufuRitsu().setDisabled(true);
            div.getBtnHiShoninRiyu().setDisabled(false);
            div.getTxtHiShoninRiyu().setDisabled(false);
        }
    }

    /**
     * アクセスログのPersonalDataを取得する処理です。
     *
     * @return PersonalData
     */
    public PersonalData toPersonalData() {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);

        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

    /**
     * 有効期限を取得する処理です。
     */
    public void get有効期限By適用日() {
        RiyoshaFutangakuGengakuService service = RiyoshaFutangakuGengakuService.createInstance();

        FlexibleDate 適用日 = div.getTxtTekiyoYmd().getValue();
        FlexibleDate 有効期限 = service.estimate有効期限(適用日);
        div.getTxtYukoKigenYmd().setValue(有効期限);
    }

    /**
     * 申請一覧変更有無チェックを行います。
     *
     * @return true:変更あり false:変更なし
     */
    public boolean 申請一覧_変更あり() {
        ArrayList<RiyoshaFutangakuGengakuViewState> list = ViewStateHolder.get(Dbd1020001Keys.利用者負担額減額情報ListのViewState, ArrayList.class);
        if (list == null || list.isEmpty()) {
            return false;
        }
        boolean 変更あり = false;
        for (RiyoshaFutangakuGengakuViewState joho : list) {
            if (EntityDataState.Unchanged != joho.getState()) {
                変更あり = true;
            }
        }
        return 変更あり;
    }

    /**
     * 申請一覧適用期間重複チェックを行います。
     *
     * @return true:重複データあり false:重複データなし
     */
    public boolean 適用期間重複あり() {
        ArrayList<RiyoshaFutangakuGengakuViewState> list = ViewStateHolder.get(Dbd1020001Keys.利用者負担額減額情報ListのViewState, ArrayList.class);
        if (list == null || list.isEmpty()) {
            return false;
        }
        FlexibleDate 適用日１;
        FlexibleDate 適用日２;
        FlexibleDate 有効期限１;
        FlexibleDate 有効期限２;
        RiyoshaFutangakuGengakuViewState joho１;
        RiyoshaFutangakuGengakuViewState joho２;
        for (int i = 0, size = list.size(); i < size - 1; i++) {
            joho１ = list.get(i);
            適用日１ = joho１.getRiyoshaFutangakuGengaku().get適用開始年月日();
            有効期限１ = joho１.getRiyoshaFutangakuGengaku().get適用終了年月日();
            if (適用日１ == null || 適用日１.isEmpty() || 有効期限１ == null || 有効期限１.isEmpty()) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                joho２ = list.get(j);
                適用日２ = joho２.getRiyoshaFutangakuGengaku().get適用開始年月日();
                有効期限２ = joho２.getRiyoshaFutangakuGengaku().get適用終了年月日();
                if (適用日２ == null || 適用日２.isEmpty() || 有効期限２ == null || 有効期限２.isEmpty()) {
                    continue;
                }
                if (適用日２.isBeforeOrEquals(適用日１) && 有効期限１.isBeforeOrEquals(有効期限２)
                        || 適用日１.isBeforeOrEquals(適用日２) && 有効期限２.isBeforeOrEquals(有効期限１)
                        || 適用日１.isBeforeOrEquals(有効期限２)
                        || 有効期限１.isBeforeOrEquals(適用日２)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 申請情報エリアの入力情報をクリアします。
     */
    public void 入力情報をクリア() {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);

        div.getTxtShinseiYmd().clearValue();
        div.getTxtShinseiRiyu().clearValue();
        div.getCcdShinseiJoho().initialize(識別コード);
        div.getRadKetteiKubun().clearSelectedItem();
        div.getTxtKettaiYmd().clearValue();
        div.getTxtTekiyoYmd().clearValue();
        div.getTxtYukoKigenYmd().clearValue();
        div.getDdlKyusochiKubun().getDataSource().clear();
        div.getDdlKyusochiKubun().setDataSource(getDdlKyusochiKubun());
        div.getTxtKyufuRitsu().clearValue();
        div.getTxtHiShoninRiyu().clearValue();
    }

    private void 一覧エリアの設定(List<RiyoshaFutangakuGengaku> 利用者負担額減額の情報List) {

        ddlShinseiIchiran_Row row;
        List<ddlShinseiIchiran_Row> rowList = new ArrayList<>();

        ArrayList<RiyoshaFutangakuGengakuViewState> viewStateList = new ArrayList<>();

        RString 決定区分TXT = RString.EMPTY;
        for (RiyoshaFutangakuGengaku joho : 利用者負担額減額の情報List) {

            決定区分TXT = RString.EMPTY;
            if (KetteiKubun.承認する.getコード().equals(joho.get決定区分())) {
                決定区分TXT = KetteiKubun.承認する.get名称();
            } else if (KetteiKubun.承認しない.getコード().equals(joho.get決定区分())) {
                決定区分TXT = KetteiKubun.承認しない.get名称();
            }
            row = new ddlShinseiIchiran_Row();
            row.getTxtShinseiYMD().setValue(joho.get申請年月日());
            row.setShinseiRiyu(joho.get申請事由());
            row.setKetteiKubun(決定区分TXT);
            row.getTxtKetteiYMD().setValue(joho.get決定年月日());
            row.getTxtTekiyoYMD().setValue(joho.get適用開始年月日());
            row.getTxtYukoKigen().setValue(joho.get適用終了年月日());
            row.setKyusochishaUmu(joho.is旧措置者有無());
            if (joho.get給付率() != null) {
                row.getTxtKyufuritsu().setValue(joho.get給付率().getColumnValue());
            }
            row.setShoninShinaiRiyu(joho.get非承認理由());
            row.setHiddenShoKisaiHokenshaNo(joho.get証記載保険者番号().getColumnValue());
            row.setHiddenShinseiRirekiNo(new RString(joho.get履歴番号()));

            rowList.add(row);
            viewStateList.add(new RiyoshaFutangakuGengakuViewState(joho, EntityDataState.Unchanged, joho.get履歴番号()));
        }
        div.getDdlShinseiIchiran().setDataSource(rowList);
        ViewStateHolder.put(Dbd1020001Keys.利用者負担額減額情報ListのViewState, viewStateList);
    }

    private GemmenGengakuShinseiBuilder setGemmenGengakuShinseiBuilderBy入力データ(GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder) {
        if (div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行区分() != null) {
            gemmenGengakuShinseiBuilder.set申請届出代行区分(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行区分().getCode());
        }
        gemmenGengakuShinseiBuilder.set申請届出者氏名(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名());
        gemmenGengakuShinseiBuilder.set申請届出者氏名カナ(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名カナ());
        gemmenGengakuShinseiBuilder.set申請届出者続柄(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者続柄());
        gemmenGengakuShinseiBuilder.set申請届出代行事業者番号(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行事業者番号());
        if (div.getCcdShinseiJoho().get減免減額申請情報().get事業者区分() != null) {
            gemmenGengakuShinseiBuilder.set事業者区分(div.getCcdShinseiJoho().get減免減額申請情報().get事業者区分().getCode());
        }
        gemmenGengakuShinseiBuilder.set申請届出者郵便番号(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者郵便番号());
        gemmenGengakuShinseiBuilder.set申請届出者住所(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者住所());
        gemmenGengakuShinseiBuilder.set申請届出者電話番号(div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者電話番号());
        return gemmenGengakuShinseiBuilder;
    }

    private List<KeyValueDataSource> getDdlKyusochiKubun() {
        List<KeyValueDataSource> syuSochishaKubun = new ArrayList<>();
        for (KyuSochishaKubun code : KyuSochishaKubun.values()) {
            KeyValueDataSource data = new KeyValueDataSource(code.getコード(), code.get名称());
            syuSochishaKubun.add(data);
        }
        return syuSochishaKubun;
    }

    private ShinseiJoho 減免減額申請共有子Divの設定() {
        RiyoshaFutangakuGengakuViewState joho = ViewStateHolder.get(Dbd1020001Keys.該当申請のViewState, RiyoshaFutangakuGengakuViewState.class);
        ShinseiTodokedeDaikoKubunCode 申請届出代行区分 = null;
        AtenaMeisho 申請届出者氏名 = null;
        AtenaKanaMeisho 申請届出者氏名カナ = null;
        RString 申請届出者続柄 = RString.EMPTY;
        YubinNo 申請届出者郵便番号 = null;
        AtenaJusho 申請届出者住所 = null;
        TelNo 申請届出者電話番号 = null;
        JigyoshaNo 申請届出代行事業者番号 = null;
        JigyoshaKubun 事業者区分 = null;

        if (joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().size() > 0) {
            if (joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出代行区分() != null) {
                申請届出代行区分 = ShinseiTodokedeDaikoKubunCode.toValue(joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出代行区分());
            }
            申請届出者氏名 = joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出者氏名();
            申請届出者氏名カナ = joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出者氏名カナ();
            申請届出者続柄 = joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出者続柄();
            if (joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出代行事業者番号() != null) {
                申請届出代行事業者番号 = joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出代行事業者番号();
            }
            if (joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get事業者区分() != null) {
                事業者区分 = JigyoshaKubun.toValue(joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get事業者区分());
            }
            申請届出者郵便番号 = joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出者郵便番号();
            申請届出者住所 = joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出者住所();
            申請届出者電話番号 = joho.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0).get申請届出者電話番号();
        }
        return new ShinseiJoho(申請届出代行区分,
                申請届出者氏名, 申請届出者氏名カナ, 申請届出者続柄, 申請届出代行事業者番号, 事業者区分, 申請届出者郵便番号, 申請届出者住所, 申請届出者電話番号);

    }

    private boolean 申請情報_変更あり(RiyoshaFutangakuGengaku 該当DB申請) {

        if (ResponseHolder.getMenuID().equals(申請メニュー)) {
            return !(is等しい(該当DB申請.get申請事由(), div.getTxtShinseiRiyu().getValue())
                    && 該当DB申請.get申請年月日().equals(div.getTxtShinseiYmd().getValue())
                    && is減免減額申請共有子Div等しい(該当DB申請));
        }
        return !(is等しい(該当DB申請.get申請事由(), div.getTxtShinseiRiyu().getValue())
                && 該当DB申請.get申請年月日().equals(div.getTxtShinseiYmd().getValue())
                && is減免減額申請共有子Div等しい(該当DB申請)
                && is承認情報等しい(該当DB申請));
    }

    /**
     * 該当選択行のDB情報を取得します。
     *
     * @param row 該当選択行
     * @return DB情報
     */
    public RiyoshaFutangakuGengaku get該当DB申請(ddlShinseiIchiran_Row row) {
        List<RiyoshaFutangakuGengaku> dbDatalist = ViewStateHolder.get(Dbd1020001Keys.DB利用者負担額減額情報List, ArrayList.class);
        if (dbDatalist != null) {
            for (RiyoshaFutangakuGengaku joho : dbDatalist) {
                if (joho.get証記載保険者番号().getColumnValue().equals(row.getHiddenShoKisaiHokenshaNo())
                        && new RString(joho.get履歴番号()).equals(row.getHiddenShinseiRirekiNo())) {
                    return joho;
                }
            }
        }
        return null;
    }

    private RiyoshaFutangakuGengakuViewState get該当申請のViewState(ddlShinseiIchiran_Row row) {
        List<RiyoshaFutangakuGengakuViewState> existsViewStateList = ViewStateHolder.get(Dbd1020001Keys.利用者負担額減額情報ListのViewState, List.class);
        if (existsViewStateList != null) {
            for (RiyoshaFutangakuGengakuViewState joho : existsViewStateList) {
                if (joho.getRiyoshaFutangakuGengaku().get証記載保険者番号().getColumnValue().equals(row.getHiddenShoKisaiHokenshaNo())
                        && new RString(joho.getRiyoshaFutangakuGengaku().get履歴番号()).equals(row.getHiddenShinseiRirekiNo())) {
                    return joho;
                }
            }
        }
        return null;
    }

    private boolean is承認情報等しい(RiyoshaFutangakuGengaku 該当DB申請) {

        RString 決定区分 = div.getRadKetteiKubun().getSelectedKey();
        RString 決定区分コード = RString.EMPTY;

        if (承認する_KEY.equals(決定区分)) {
            決定区分コード = KetteiKubun.承認する.getコード();
        } else if (承認しない_KEY.equals(決定区分)) {
            決定区分コード = KetteiKubun.承認しない.getコード();
        }
        boolean is旧措置者有無 = false;
        if (div.getDdlKyusochiKubun().getSelectedValue().equals(KyuSochishaKubun.旧措置.get名称())) {
            is旧措置者有無 = true;
        }

        Decimal 給付率data = 該当DB申請.get給付率() == null ? HokenKyufuRitsu.ZERO.getColumnValue() : 該当DB申請.get給付率().getColumnValue();
        return is等しい(該当DB申請.get決定区分(), 決定区分コード)
                && 該当DB申請.get決定年月日().equals(div.getTxtKettaiYmd().getValue())
                && 該当DB申請.get適用開始年月日().equals(div.getTxtTekiyoYmd().getValue())
                && 該当DB申請.get適用終了年月日().equals(div.getTxtYukoKigenYmd().getValue())
                && 該当DB申請.is旧措置者有無() == is旧措置者有無
                && 給付率data.compareTo(div.getTxtKyufuRitsu().getValue()) == 0
                && is等しい(該当DB申請.get非承認理由(), div.getTxtHiShoninRiyu().getValue());
    }

    private boolean is減免減額申請共有子Div等しい(RiyoshaFutangakuGengaku 該当DB申請) {
        GemmenGengakuShinsei gemmenGengakuShinsei;
        if (該当DB申請.getGemmenGengakuShinseiList().size() > 0) {
            gemmenGengakuShinsei = 該当DB申請.getGemmenGengakuShinseiList().get(0);
        } else {
            gemmenGengakuShinsei = new GemmenGengakuShinsei(ShoKisaiHokenshaNo.EMPTY, HihokenshaNo.EMPTY, GemmenGengakuShurui.利用者負担額減額.code(), 0);
        }

        RString 申請届出代行区分page = get申請届出代行区分page();

        RString 申請届出者氏名data = get申請届出者氏名data(gemmenGengakuShinsei);
        RString 申請届出者氏名page = get申請届出者氏名page();

        RString 申請届出者氏名カナdata = get申請届出者氏名カナdata(gemmenGengakuShinsei);
        RString 申請届出者氏名カナpage = get申請届出者氏名カナpage();

        RString 申請届出代行事業者番号data = get申請届出代行事業者番号data(gemmenGengakuShinsei);
        RString 申請届出代行事業者番号page = get申請届出代行事業者番号page();

        RString 事業者区分page = 事業者区分page();

        RString 申請届出者郵便番号data = get申請届出者郵便番号data(gemmenGengakuShinsei);
        RString 申請届出者郵便番号page = get申請届出者郵便番号page();

        RString 申請届出者住所data = get申請届出者住所data(gemmenGengakuShinsei);
        RString 申請届出者住所page = get申請届出者住所page();

        RString 申請届出者電話番号data = get申請届出者電話番号data(gemmenGengakuShinsei);
        RString 申請届出者電話番号page = get申請届出者電話番号page();

        return is等しい(gemmenGengakuShinsei.get申請届出代行区分(), 申請届出代行区分page)
                && is等しい(申請届出者氏名data, 申請届出者氏名page)
                && is等しい(申請届出者氏名カナdata, 申請届出者氏名カナpage)
                && is等しい(gemmenGengakuShinsei.get申請届出者続柄(), div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者続柄())
                && is等しい(申請届出代行事業者番号data, 申請届出代行事業者番号page)
                && is等しい(gemmenGengakuShinsei.get事業者区分(), 事業者区分page)
                && is等しい(申請届出者郵便番号data, 申請届出者郵便番号page)
                && is等しい(申請届出者住所data, 申請届出者住所page)
                && is等しい(申請届出者電話番号data, 申請届出者電話番号page);

    }

    private RString get申請届出代行区分page() {
        RString 申請届出代行区分page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行区分() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行区分().getCode();
        return 申請届出代行区分page;
    }

    private RString get申請届出者氏名data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        RString 申請届出者氏名data = gemmenGengakuShinsei.get申請届出者氏名() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者氏名().getColumnValue();
        return 申請届出者氏名data;
    }

    private RString get申請届出者氏名page() {
        RString 申請届出者氏名page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名().getColumnValue();
        return 申請届出者氏名page;
    }

    private RString get申請届出者氏名カナdata(GemmenGengakuShinsei gemmenGengakuShinsei) {
        RString 申請届出者氏名カナdata = gemmenGengakuShinsei.get申請届出者氏名カナ() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者氏名カナ().getColumnValue();
        return 申請届出者氏名カナdata;
    }

    private RString get申請届出者氏名カナpage() {
        RString 申請届出者氏名カナpage = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名カナ() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者氏名カナ().getColumnValue();
        return 申請届出者氏名カナpage;
    }

    private RString get申請届出代行事業者番号data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        RString 申請届出代行事業者番号data = gemmenGengakuShinsei.get申請届出代行事業者番号() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出代行事業者番号().getColumnValue();
        return 申請届出代行事業者番号data;
    }

    private RString get申請届出代行事業者番号page() {
        RString 申請届出代行事業者番号page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行事業者番号() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出代行事業者番号().getColumnValue();
        return 申請届出代行事業者番号page;
    }

    private RString 事業者区分page() {
        RString 事業者区分page = div.getCcdShinseiJoho().get減免減額申請情報().get事業者区分() == null ? RString.EMPTY : div.getCcdShinseiJoho().get減免減額申請情報().get事業者区分().getCode();
        return 事業者区分page;
    }

    private RString get申請届出者郵便番号data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        RString 申請届出者郵便番号data = gemmenGengakuShinsei.get申請届出者郵便番号() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者郵便番号().getColumnValue();
        return 申請届出者郵便番号data;
    }

    private RString get申請届出者郵便番号page() {
        RString 申請届出者郵便番号page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者郵便番号() == null
                ? RString.EMPTY : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者郵便番号().getColumnValue();
        return 申請届出者郵便番号page;
    }

    private RString get申請届出者住所data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        RString 申請届出者住所data = gemmenGengakuShinsei.get申請届出者住所() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者住所().getColumnValue();
        return 申請届出者住所data;
    }

    private RString get申請届出者住所page() {
        RString 申請届出者住所page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者住所() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者住所().getColumnValue();
        return 申請届出者住所page;
    }

    private RString get申請届出者電話番号data(GemmenGengakuShinsei gemmenGengakuShinsei) {
        RString 申請届出者電話番号data = gemmenGengakuShinsei.get申請届出者電話番号() == null ? RString.EMPTY : gemmenGengakuShinsei.get申請届出者電話番号().getColumnValue();
        return 申請届出者電話番号data;
    }

    private RString get申請届出者電話番号page() {
        RString 申請届出者電話番号page = div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者電話番号() == null ? RString.EMPTY
                : div.getCcdShinseiJoho().get減免減額申請情報().get申請届出者電話番号().getColumnValue();
        return 申請届出者電話番号page;
    }

    private boolean is等しい(RString beforeVal, RString afterVal) {
        if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal == null || afterVal.isEmpty())) {
            return true;
        } else if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal != null && !afterVal.isEmpty())) {
            return false;
        }
        return beforeVal.equals(afterVal);
    }

    private ShoKisaiHokenshaNo get証記載保険者番号(FlexibleDate 申請日) {

        HokenshaListLoader loader = HokenshaListLoader.createInstance();
        HokenshaList hokenshaList = loader.getShichosonCodeNameList(GyomuBunrui.介護事務);

        HihokenshaDaichoManager manager = new HihokenshaDaichoManager();
        HihokenshaDaicho daicho = manager.find最新被保険者台帳(申請日);
        if (daicho == null) {
            return new ShoKisaiHokenshaNo(RString.EMPTY);
        }
        if (daicho.get広住特措置元市町村コード() != null && !daicho.get広住特措置元市町村コード().isEmpty()) {
            return hokenshaList.get(daicho.get広住特措置元市町村コード()).get証記載保険者番号();
        }
        return hokenshaList.get(daicho.get市町村コード()).get証記載保険者番号();
    }

    private void 前排他の設定() {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("RiyoshaFutanGengaku")));
        RealInitialLocker.lock(排他キー);
    }

    private void 該当情報ViewStateのクリア() {
        ViewStateHolder.put(Dbd1020001Keys.該当DB申請, null);
        ViewStateHolder.put(Dbd1020001Keys.該当申請のViewState, null);
    }

    /**
     * ViewStateのComparatorです。
     */
    public static class RiyoshaFutangakuGengakuComparator implements Comparator<RiyoshaFutangakuGengakuViewState> {

        @Override
        public int compare(RiyoshaFutangakuGengakuViewState s1, RiyoshaFutangakuGengakuViewState s2) {

            int result = !s1.getRiyoshaFutangakuGengaku().get申請年月日().isBeforeOrEquals(s2.getRiyoshaFutangakuGengaku().get申請年月日())
                    ? 1 : (s1.getRiyoshaFutangakuGengaku().get申請年月日().equals(s2.getRiyoshaFutangakuGengaku().get申請年月日()) ? 0 : -1);

            if (result == 0 && EntityDataState.Added != s1.getState() && EntityDataState.Added != s2.getState()) {
                result = s1.getShorigoRirekiNo() > s2.getShorigoRirekiNo() ? 1 : -1;
            }
            if (result == 0 && EntityDataState.Added == s1.getState()) {
                result = 1;
            } else if (result == 0 && EntityDataState.Added == s2.getState()) {
                result = -1;
            }
            return result;
        }

    }

    /**
     * 申請一覧エリアデータのComparatorです。（「申請年月日」の降順でソート）
     */
    public static class RiyoshaFutangakuGengakuRowComparator implements Comparator<ddlShinseiIchiran_Row> {

        @Override
        public int compare(ddlShinseiIchiran_Row row1, ddlShinseiIchiran_Row row2) {

            int result = !row2.getTxtShinseiYMD().getValue().isBeforeOrEquals(row1.getTxtShinseiYMD().getValue())
                    ? 1 : (row2.getTxtShinseiYMD().getValue().equals(row1.getTxtShinseiYMD().getValue()) ? 0 : -1);

            if (result == 0 && 追加.equals(row1.getJotai()) && 追加.equals(row2.getJotai())) {
                result = row2.getHiddenShinseiRirekiNo().compareTo(row1.getHiddenShinseiRirekiNo());
            }
            if (result == 0 && 追加.equals(row2.getJotai())) {
                result = 1;
            } else if (result == 0 && 追加.equals(row1.getJotai())) {
                result = -1;
            }
            return result;
        }
    }

    /**
     * Dbe2210001Keys
     */
    public enum Dbd1020001Keys {

        /**
         * DB利用者負担額減額情報List
         */
        DB利用者負担額減額情報List,
        /**
         * 利用者負担額減額情報ListのViewState
         */
        利用者負担額減額情報ListのViewState,
        /**
         * 該当DB申請
         */
        該当DB申請,
        /**
         * 該当申請のViewState
         */
        該当申請のViewState,
        /**
         * 新規申請の履歴番号
         */
        新規申請の履歴番号
    }

}
