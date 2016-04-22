/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigenBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigenIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shakaifukushihojinkeigen.ShakaifukuRiyoshaFutanKeigenToJotai;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.business.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shakaifukushihojinkeigen.GemmenKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdWarningMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001Div;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenService;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shakaifukushihojinriyoshafutankeigen.ShakaiFukushiHojinRiyoshaFutanKeigenManager;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shinsei.GemmenGengakuShinseiManager;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urd.service.core.seikatsuhogo.SeikatsuhogoManagerFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 社会福祉法人等利用者負担軽減申請画面ハンドラクラスです。
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
public class DBD1030001Handler {

    private final DBD1030001Div div;
    private final RString 申請情報を追加する = new RString("申請情報を追加する");
    private final RString 承認情報を追加する = new RString("承認情報を追加する");
    private final RString 制限あり = new RString("制限あり");
    private final RString 保存する = new RString("btnUpdate");
    private final RString 再検索する = new RString("btnReSearch");
    private final RString 検索結果一覧へ = new RString("btnToSearchResult");
    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");
    private final RString 承認する = new RString("1");
    private final RString 承認しない = new RString("0");
    private static final RString 申請メニューID = new RString("DBDMN21004");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString NAME_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final Decimal DECIMAL_25 = new Decimal("25.0");
    private static final Decimal DECIMAL_100 = new Decimal("100");
    private static final Decimal DECIMAL_9 = new Decimal("9");
    private static final Decimal DECIMAL_10 = new Decimal("10");
    private static final Decimal DECIMAL_99 = new Decimal("99");
    private static final Decimal DECIMAL_99_9 = new Decimal("99.9");
    private static final Decimal DECIMAL_28 = new Decimal("28.0");
    private static final Decimal DECIMAL_53 = new Decimal("53.0");
    private static final Decimal DECIMAL_50 = new Decimal("50.0");
    private static final FlexibleDate FLEXIBLEDDTE_20060701 = new FlexibleDate("20060701");
    private static final FlexibleDate FLEXIBLEDDTE_20110331 = new FlexibleDate("20110331");

    /**
     * コンストラクタです。
     *
     * @param div 社会福祉法人等利用者負担軽減申請画面Div
     */
    public DBD1030001Handler(DBD1030001Div div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        ShikibetsuCode 識別コード = get識別コードFromViewState();
        HihokenshaNo 被保険者番号 = get被保険者番号FromViewState();
        div.getCcdAtenaInfo().onLoad(識別コード);
        div.getCcdShikakuKihon().onLoad(被保険者番号);
        div.getShafukuRiyoshaKeigen().setHihokenshaNo(被保険者番号.getColumnValue());
        RString メニューID = ResponseHolder.getMenuID();
        if (申請メニューID.equals(メニューID)) {
            if (被保険者番号.isEmpty()) {
                div.getBtnShowGenmenJoho().setDisabled(true);
                div.getBtnAddShinsei().setDisabled(true);
                div.getDgShinseiList().setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
                throw new ApplicationException(DbdInformationMessages.受給共通_被保データなし.getMessage());
            } else {
                div.getBtnAddShinsei().setText(申請情報を追加する);
                申請一覧エリア初期化(被保険者番号);
                CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(保存する, "申請情報を");
            }
        } else {
            div.getBtnAddShinsei().setText(承認情報を追加する);
            申請一覧エリア初期化(被保険者番号);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(保存する, "承認情報を");
        }
        div.getCcdShinseiJoho().initialize(識別コード);
        PersonalData personalData = PersonalData.of(識別コード, new ExpandedInformation(CODE_0003, NAME_被保険者番号, 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.照会, personalData);
        RealInitialLocker.lock(new LockingKey(new RString("DB").concat(被保険者番号.getColumnValue().concat("ShafukuKeigen"))));
    }

    private void 申請一覧エリア初期化(HihokenshaNo 被保険者番号) {
        List<ShakaifukuRiyoshaFutanKeigen> 申請一覧情報 = get申請一覧情報(被保険者番号);
        ArrayList<ShakaifukuRiyoshaFutanKeigen> 最初申請一覧情報 = new ArrayList<>(申請一覧情報);
        ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報, 最初申請一覧情報);
        List<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態List = 情報と状態初期化(申請一覧情報);
        List<dgShinseiList_Row> dataSourceList = getDataSource(情報と状態List);
        div.getDgShinseiList().setDataSource(dataSourceList);
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList = new ArrayList<>(情報と状態List);
        ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, 情報と状態ArrayList);
    }

    private List<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態初期化(List<ShakaifukuRiyoshaFutanKeigen> 申請一覧情報) {
        List<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態List = new ArrayList<>();
        for (ShakaifukuRiyoshaFutanKeigen 情報 : 申請一覧情報) {
            ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 = new ShakaifukuRiyoshaFutanKeigenToJotai(情報, RString.EMPTY, 情報.get履歴番号());
            情報と状態List.add(情報と状態);
        }
        return 情報と状態List;
    }

    private List<dgShinseiList_Row> getDataSource(List<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態List) {
        List<dgShinseiList_Row> dataSourceList = new ArrayList<>();
        if (情報と状態List != null && !情報と状態List.isEmpty()) {
            for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態List) {
                ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
                dgShinseiList_Row dataSource = new dgShinseiList_Row();
                dataSource.setJotai(情報と状態.get状態());
                dataSource.setKakuninNo(社会福祉法人等利用者負担軽減情報.get確認番号());
                TextBoxFlexibleDate 申請年月日 = new TextBoxFlexibleDate();
                申請年月日.setValue(社会福祉法人等利用者負担軽減情報.get申請年月日());
                dataSource.setTxtShinseiYMD(申請年月日);
                dataSource.setShinseiRiyu(社会福祉法人等利用者負担軽減情報.get申請事由());
                dataSource.setKetteiKubun(社会福祉法人等利用者負担軽減情報.get決定区分());
                TextBoxFlexibleDate 決定年月日 = new TextBoxFlexibleDate();
                決定年月日.setValue(社会福祉法人等利用者負担軽減情報.get決定年月日());
                dataSource.setTxtKetteiYMD(決定年月日);
                TextBoxFlexibleDate 適用開始年月日 = new TextBoxFlexibleDate();
                適用開始年月日.setValue(社会福祉法人等利用者負担軽減情報.get適用開始年月日());
                dataSource.setTxtTekiyoYMD(適用開始年月日);
                TextBoxFlexibleDate 適用終了年月日 = new TextBoxFlexibleDate();
                適用終了年月日.setValue(社会福祉法人等利用者負担軽減情報.get適用終了年月日());
                dataSource.setTxtYukoKigenYMD(適用終了年月日);
                dataSource.setKeigenJiyu(社会福祉法人等利用者負担軽減情報.get減免区分());
                if (社会福祉法人等利用者負担軽減情報.get軽減率_分子() != null && 社会福祉法人等利用者負担軽減情報.get軽減率_分母() != null) {
                    dataSource.setKeigenRitsu(new RString(社会福祉法人等利用者負担軽減情報.get軽減率_分子().toString())
                            .concat("/").concat(社会福祉法人等利用者負担軽減情報.get軽減率_分母().toString()));
                }
                dataSource.setChkTokureisochiTaishosha(社会福祉法人等利用者負担軽減情報.is生保扶助見直し特例有無());
                if (社会福祉法人等利用者負担軽減情報.is居宅サービス限定()) {
                    dataSource.setKyotakuServiceGentei(制限あり);
                } else {
                    dataSource.setKyotakuServiceGentei(RString.EMPTY);
                }
                if (社会福祉法人等利用者負担軽減情報.is居住費_食費のみ()) {
                    dataSource.setKojuhiShokuhiGentei(制限あり);
                } else {
                    dataSource.setKojuhiShokuhiGentei(RString.EMPTY);
                }
                if (社会福祉法人等利用者負担軽減情報.is旧措置者ユニット型個室のみ()) {
                    dataSource.setKyusochiUnitGataKoshitsuGentei(制限あり);
                } else {
                    dataSource.setKyusochiUnitGataKoshitsuGentei(RString.EMPTY);
                }
                dataSource.setShoninShinaiRiyu(社会福祉法人等利用者負担軽減情報.get非承認理由());
                dataSource.setDataId(DataPassingConverter.serialize(社会福祉法人等利用者負担軽減情報.identifier()));
                dataSourceList.add(dataSource);
            }
        }
        return dataSourceList;
    }

    private List<ShakaifukuRiyoshaFutanKeigen> get申請一覧情報(HihokenshaNo 被保険者番号) {
        return ShakaiFukushiHojinKeigenService.createIntance().load社会福祉法人等利用者負担軽減申請All(被保険者番号);
    }

    private ShikibetsuCode get識別コードFromViewState() {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        return 識別コード;
    }

    private HihokenshaNo get被保険者番号FromViewState() {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (null == 被保険者番号) {
            被保険者番号 = HihokenshaNo.EMPTY;
        }
        return 被保険者番号;
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を追加する」（また「承認情報を追加する」）を押下する。
     *
     */
    public void onClick_btnAddShinsei() {
        ViewStateHolder.put(DBD1030001ViewStateKey.編集社会福祉法人等利用者負担軽減申請の情報, null);
        if (申請情報を追加する.equals(div.getBtnAddShinsei().getText())) {
            状態２画面表示();
        } else if (承認情報を追加する.equals(div.getBtnAddShinsei().getText())) {
            状態５画面表示();
        }
        div.getCcdShinseiJoho().initialize(get識別コードFromViewState());
    }

    private void 状態５画面表示() {
        div.getTxtShinseiYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtShinseiRiyu().setValue(RString.EMPTY);
        div.getRadKetteiKubun().setSelectedKey(KEY0);
        div.getTxtTekiyoYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtYukoKigenYMD().setValue(FlexibleDate.EMPTY);
        GemmenKubun 減免区分初期値 = get減免区分初期値();
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(KEY0, 減免区分初期値.get名称());
        dataSourceList.add(dataSource);
        div.getDdlKeigenJiyu().setDataSource(dataSourceList);
        div.getTxtKeigenRitsuBunshi().setValue(DECIMAL_25);
        div.getTxtKeigenRitsuBunbo().setValue(DECIMAL_100);
        List<RString> selectedKeys = new ArrayList<>();
        div.getChkTokureiTaisho().setSelectedItemsByKey(selectedKeys);
        div.getChkKyotakuServiceGentei().setSelectedItemsByKey(selectedKeys);
        div.getChkKyojuhiShokuhiGentei().setSelectedItemsByKey(selectedKeys);
        div.getChkKyusochiUnitGataJunKoshitsu().setSelectedItemsByKey(selectedKeys);
        div.getBtnSelectHiShoninRiyu().setDisabled(true);
        div.getTxtHiShoninRiyu().setDisabled(true);
        div.getBtnBackToShinseiList().setDisabled(false);
        div.getBtnShinseiKakutei().setDisplayNone(true);
        div.getBtnShoninKakutei().setDisplayNone(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(再検索する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧へ, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
    }

    private GemmenKubun get減免区分初期値() {
        ShikibetsuCode 識別コード = get識別コードFromViewState();
        FlexibleDate 申請日 = div.getTxtShinseiYMD().getValue();
        if (null == 申請日) {
            申請日 = FlexibleDate.EMPTY;
        }
        return ShakaiFukushiHojinKeigenService.createIntance().find減免区分初期値(識別コード, 申請日);
    }

    private void 状態２画面表示() {
        div.getTxtShinseiYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtShinseiRiyu().setValue(RString.EMPTY);
        div.getRadKetteiKubun().setSelectedKey(KEY0);
        div.getTxtTekiyoYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtYukoKigenYMD().setValue(FlexibleDate.EMPTY);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        div.getDdlKeigenJiyu().setDataSource(dataSource);
        div.getTxtKeigenRitsuBunshi().setValue(null);
        div.getTxtKeigenRitsuBunbo().setValue(null);
        List<RString> selectedKeys = new ArrayList<>();
        div.getChkTokureiTaisho().setSelectedItemsByKey(selectedKeys);
        div.getChkKyotakuServiceGentei().setSelectedItemsByKey(selectedKeys);
        div.getChkKyojuhiShokuhiGentei().setSelectedItemsByKey(selectedKeys);
        div.getChkKyusochiUnitGataJunKoshitsu().setSelectedItemsByKey(selectedKeys);
        div.getTxtKakuninNo().setValue(RString.EMPTY);
        div.getTxtHiShoninRiyu().setValue(RString.EMPTY);
        状態２制御();
    }

    private void 状態２制御() {
        div.getBtnShowSetaiJoho().setDisabled(false);
        div.getBtnShowGenmenJoho().setDisabled(false);
        div.getTxtShinseiYMD().setDisabled(false);
        div.getTxtShinseiRiyu().setDisabled(false);
        div.getRadKetteiKubun().setDisabled(true);
        div.getTxtKetteiYMD().setDisabled(true);
        div.getTxtTekiyoYMD().setDisabled(true);
        div.getTxtYukoKigenYMD().setDisabled(true);
        div.getDdlKeigenJiyu().setDisabled(true);
        div.getTxtKeigenRitsuBunshi().setDisabled(true);
        div.getTxtKeigenRitsuBunbo().setDisabled(true);
        div.getChkTokureiTaisho().setDisabled(true);
        div.getChkKyotakuServiceGentei().setDisabled(true);
        div.getChkKyojuhiShokuhiGentei().setDisabled(true);
        div.getChkKyusochiUnitGataJunKoshitsu().setDisabled(true);
        div.getTxtKakuninNo().setDisabled(true);
        div.getTxtHiShoninRiyu().setDisabled(true);
        div.getBtnBackToShinseiList().setDisabled(false);
        div.getBtnShinseiKakutei().setDisplayNone(false);
        div.getBtnShoninKakutei().setDisplayNone(true);
        div.getBtnSelectHiShoninRiyu().setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(再検索する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧へ, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧の修正ボタン」を押下する。
     *
     */
    public void onClick_onSelectByModifyButton() {
        dgShinseiList_Row dataSouce = div.getDgShinseiList().getActiveRow();
        ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 = get情報FromDataSouce(dataSouce);
        ViewStateHolder.put(DBD1030001ViewStateKey.編集社会福祉法人等利用者負担軽減申請の情報, 情報と状態);
        if (申請情報を追加する.equals(div.getBtnAddShinsei().getText())) {
            状態３画面表示(dataSouce, 情報と状態);
        } else if (承認情報を追加する.equals(div.getBtnAddShinsei().getText())) {
            状態６画面表示(dataSouce, 情報と状態);
        }
    }

    private ShakaifukuRiyoshaFutanKeigenToJotai get情報FromDataSouce(dgShinseiList_Row dataSouce) {
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        ShakaifukuRiyoshaFutanKeigenIdentifier id
                = DataPassingConverter.deserialize(dataSouce.getDataId(), ShakaifukuRiyoshaFutanKeigenIdentifier.class);
        for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態ArrayList) {
            if (id.equals(情報と状態.get社会福祉法人等利用者負担軽減情報().identifier())) {
                return 情報と状態;
            }
        }
        return null;
    }

    private void 状態６画面表示(dgShinseiList_Row dataSouce, ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態) {
        div.getCcdShinseiJoho().set減免減額申請情報(getShinseiJoho(情報と状態), dataSouce.getTxtShinseiYMD().getValue());
        承認情報エリア画面表示(dataSouce);
        div.getBtnShowSetaiJoho().setDisabled(false);
        div.getBtnShowGenmenJoho().setDisabled(false);
        div.getBtnBackToShinseiList().setDisabled(false);
        div.getBtnShoninKakutei().setDisplayNone(true);
        div.getBtnShinseiKakutei().setDisplayNone(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(再検索する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧へ, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
    }

    private ShinseiJoho getShinseiJoho(ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態) {
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 情報と状態.get社会福祉法人等利用者負担軽減情報().getGemmenGengakuShinseiList();
        if (null == gemmenGengakuShinseiList || gemmenGengakuShinseiList.isEmpty()) {
            return new ShinseiJoho(null, AtenaMeisho.EMPTY, AtenaKanaMeisho.EMPTY,
                    RString.EMPTY, JigyoshaNo.EMPTY, null, YubinNo.EMPTY, AtenaJusho.EMPTY, TelNo.EMPTY);
        }
        GemmenGengakuShinsei gemmenGengakuShinsei = gemmenGengakuShinseiList.get(0);
        ShinseiTodokedeDaikoKubunCode 申請届出代行区分 = null;
        if (gemmenGengakuShinsei.get申請届出代行区分() != null) {
            申請届出代行区分 = ShinseiTodokedeDaikoKubunCode.toValue(gemmenGengakuShinsei.get申請届出代行区分());
        }
        JigyoshaKubun 事業者区分 = null;
        if (gemmenGengakuShinsei.get事業者区分() != null) {
            事業者区分 = JigyoshaKubun.toValue(gemmenGengakuShinsei.get事業者区分());
        }
        JigyoshaNo 事業者番号 = gemmenGengakuShinsei.get申請届出代行事業者番号();
        if (null == 事業者番号) {
            事業者番号 = JigyoshaNo.EMPTY;
        }
        return new ShinseiJoho(申請届出代行区分, gemmenGengakuShinsei.get申請届出者氏名(), gemmenGengakuShinsei.get申請届出者氏名カナ(),
                gemmenGengakuShinsei.get申請届出者続柄(), 事業者番号, 事業者区分, gemmenGengakuShinsei.get申請届出者郵便番号(),
                gemmenGengakuShinsei.get申請届出者住所(), gemmenGengakuShinsei.get申請届出者電話番号());
    }

    private void 状態３画面表示(dgShinseiList_Row dataSouce, ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態) {
        div.getCcdShinseiJoho().set減免減額申請情報(getShinseiJoho(情報と状態), dataSouce.getTxtShinseiYMD().getValue());
        承認情報エリア画面表示(dataSouce);
        状態３制御();
    }

    private void 状態３制御() {
        div.getBtnShowSetaiJoho().setDisabled(false);
        div.getBtnShowGenmenJoho().setDisabled(false);
        div.getTxtShinseiYMD().setDisabled(true);
        div.getTxtShinseiRiyu().setDisabled(true);
        div.getRadKetteiKubun().setDisabled(true);
        div.getTxtKetteiYMD().setDisabled(true);
        div.getTxtTekiyoYMD().setDisabled(true);
        div.getTxtYukoKigenYMD().setDisabled(true);
        div.getDdlKeigenJiyu().setDisabled(true);
        div.getTxtKeigenRitsuBunshi().setDisabled(true);
        div.getTxtKeigenRitsuBunbo().setDisabled(true);
        div.getChkTokureiTaisho().setDisabled(true);
        div.getChkKyotakuServiceGentei().setDisabled(true);
        div.getChkKyojuhiShokuhiGentei().setDisabled(true);
        div.getChkKyusochiUnitGataJunKoshitsu().setDisabled(true);
        div.getTxtKakuninNo().setDisabled(true);
        div.getTxtHiShoninRiyu().setDisabled(true);
        div.getBtnBackToShinseiList().setDisabled(false);
        div.getBtnShoninKakutei().setDisplayNone(true);
        div.getBtnShinseiKakutei().setDisplayNone(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(再検索する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧へ, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
    }

    private void 承認情報エリア画面表示(dgShinseiList_Row dataSouce) {
        div.getTxtShinseiYMD().setValue(dataSouce.getTxtShinseiYMD().getValue());
        div.getTxtShinseiRiyu().setValue(dataSouce.getShinseiRiyu());
        if (承認する.equals(dataSouce.getKetteiKubun())) {
            div.getRadKetteiKubun().setSelectedKey(KEY0);
            div.getDdlKeigenJiyu().setDisabled(false);
            div.getChkTokureiTaisho().setDisabled(false);
            div.getChkKyotakuServiceGentei().setDisabled(false);
            div.getChkKyojuhiShokuhiGentei().setDisabled(false);
            div.getChkKyusochiUnitGataJunKoshitsu().setDisabled(false);
            div.getTxtKakuninNo().setDisabled(false);
            div.getBtnSelectHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
        } else if (承認しない.equals(dataSouce.getKetteiKubun())) {
            div.getRadKetteiKubun().setSelectedKey(KEY1);
            div.getRadKetteiKubun().setSelectedKey(KEY0);
            div.getDdlKeigenJiyu().setDisabled(true);
            div.getChkTokureiTaisho().setDisabled(true);
            div.getChkKyotakuServiceGentei().setDisabled(true);
            div.getChkKyojuhiShokuhiGentei().setDisabled(true);
            div.getChkKyusochiUnitGataJunKoshitsu().setDisabled(true);
            div.getTxtKakuninNo().setDisabled(true);
            div.getBtnSelectHiShoninRiyu().setDisabled(false);
            div.getTxtHiShoninRiyu().setDisabled(false);
        }
        div.getTxtKetteiYMD().setValue(dataSouce.getTxtKetteiYMD().getValue());
        div.getTxtTekiyoYMD().setValue(dataSouce.getTxtTekiyoYMD().getValue());
        div.getTxtYukoKigenYMD().setValue(dataSouce.getTxtYukoKigenYMD().getValue());
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(KEY0, dataSouce.getKeigenJiyu()));
        div.getDdlKeigenJiyu().setDataSource(dataSource);
        if (dataSouce.getKeigenRitsu() != null && !dataSouce.getKeigenRitsu().isEmpty()) {
            List<RString> 軽減率List = dataSouce.getKeigenRitsu().split("/");
            div.getTxtKeigenRitsuBunshi().setValue(new Decimal(軽減率List.get(0).toString()));
            div.getTxtKeigenRitsuBunbo().setValue(new Decimal(軽減率List.get(1).toString()));
        }
        List<RString> 特例措置対象者SelectKeys = new ArrayList<>();
        if (dataSouce.getChkTokureisochiTaishosha()) {
            特例措置対象者SelectKeys.add(KEY0);
        }
        div.getChkTokureiTaisho().setSelectedItemsByKey(特例措置対象者SelectKeys);
        List<RString> 居宅サービス限定SelectKeys = getSelectKeys(dataSouce.getKyotakuServiceGentei());
        div.getChkKyotakuServiceGentei().setSelectedItemsByKey(居宅サービス限定SelectKeys);
        List<RString> 居住費_食費限定SelectKeys = getSelectKeys(dataSouce.getKojuhiShokuhiGentei());
        div.getChkKyojuhiShokuhiGentei().setSelectedItemsByKey(居住費_食費限定SelectKeys);
        List<RString> 旧措置ユニット型個室限定SelectKeys = getSelectKeys(dataSouce.getKyusochiUnitGataKoshitsuGentei());
        div.getChkKyusochiUnitGataJunKoshitsu().setSelectedItemsByKey(旧措置ユニット型個室限定SelectKeys);
        div.getTxtKakuninNo().setValue(dataSouce.getKakuninNo());
        div.getTxtHiShoninRiyu().setValue(dataSouce.getShoninShinaiRiyu());
    }

    private List<RString> getSelectKeys(RString information) {
        List<RString> selectKeys = new ArrayList<>();
        if (制限あり.equals(information)) {
            selectKeys.add(KEY0);
        }
        return selectKeys;
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧の削除ボタン」を押下する。
     *
     */
    public void onClick_onSelectByDeleteButton() {
        dgShinseiList_Row dataSouce = div.getDgShinseiList().getActiveRow();
        if (dataSouce.getKetteiKubun() != null && !dataSouce.getKetteiKubun().isEmpty()) {
            throw new ApplicationException(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage());
        }
        RString 状態 = dataSouce.getJotai();
        if (状態.isEmpty() || 状態_修正.equals(状態)) {
            元状態変更(dataSouce, 状態_削除);
        } else if (状態_追加.equals(状態)) {
            dataSourceの削除(dataSouce);
        }
    }

    private void dataSourceの削除(dgShinseiList_Row 削除DataSouce) {
        ShakaifukuRiyoshaFutanKeigenIdentifier id
                = DataPassingConverter.deserialize(削除DataSouce.getDataId(), ShakaifukuRiyoshaFutanKeigenIdentifier.class);
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 削除情報と状態 = new ArrayList<>();
        for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態ArrayList) {
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
            if (id.equals(社会福祉法人等利用者負担軽減情報.identifier())) {
                削除情報と状態.add(情報と状態);
            }
        }
        if (!削除情報と状態.isEmpty()) {
            情報と状態ArrayList.removeAll(削除情報と状態);
        }
        ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, 情報と状態ArrayList);
        List<dgShinseiList_Row> newDataSouceList = getDataSource(情報と状態ArrayList);
        div.getDgShinseiList().setDataSource(newDataSouceList);
    }

    private void 元状態変更(dgShinseiList_Row dataSouce, RString 状態) {
        ShakaifukuRiyoshaFutanKeigenIdentifier id
                = DataPassingConverter.deserialize(dataSouce.getDataId(), ShakaifukuRiyoshaFutanKeigenIdentifier.class);
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> new情報と状態ArrayList = new ArrayList<>();
        for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態ArrayList) {
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
            ShakaifukuRiyoshaFutanKeigenToJotai new情報と状態;
            if (id.equals(社会福祉法人等利用者負担軽減情報.identifier())) {
                new情報と状態 = new ShakaifukuRiyoshaFutanKeigenToJotai(
                        社会福祉法人等利用者負担軽減情報, 状態, 社会福祉法人等利用者負担軽減情報.get履歴番号());
            } else {
                new情報と状態 = 情報と状態;
            }
            new情報と状態ArrayList.add(new情報と状態);
        }
        ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
        List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
        div.getDgShinseiList().setDataSource(newDataSouceList);
    }

    private ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> get情報と状態ArrayList() {
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList
                = ViewStateHolder.get(DBD1030001ViewStateKey.申請一覧情報と状態, ArrayList.class);
        if (null == 情報と状態ArrayList) {
            情報と状態ArrayList = new ArrayList<>();
        }
        return 情報と状態ArrayList;
    }

    /**
     * 申請情報エリア入力内容があるを判断する。
     *
     * @return is申請情報エリア入力内容がある
     */
    public boolean is申請情報エリア入力内容がある() {
        return is入力内容がある(div.getTxtShinseiYMD().getValue())
                || is入力内容がある(div.getTxtShinseiRiyu().getValue())
                || is入力内容がある(div.getRadKetteiKubun().getSelectedKey())
                || is入力内容がある(div.getTxtKetteiYMD().getValue())
                || is入力内容がある(div.getTxtTekiyoYMD().getValue())
                || is入力内容がある(div.getTxtYukoKigenYMD().getValue())
                || is入力内容がある(div.getDdlKeigenJiyu().getSelectedKey())
                || is入力内容がある(div.getTxtKeigenRitsuBunshi().getText())
                || is入力内容がある(div.getTxtKeigenRitsuBunbo().getText())
                || is入力内容がある(div.getChkTokureiTaisho().getSelectedKeys())
                || is入力内容がある(div.getChkKyotakuServiceGentei().getSelectedKeys())
                || is入力内容がある(div.getChkKyojuhiShokuhiGentei().getSelectedKeys())
                || is入力内容がある(div.getChkKyusochiUnitGataJunKoshitsu().getSelectedKeys())
                || is入力内容がある(div.getTxtKakuninNo().getValue())
                || is入力内容がある(div.getTxtHiShoninRiyu().getValue());
    }

    private boolean is入力内容がある(RString 入力内容) {
        return !入力内容.isEmpty();
    }

    private boolean is入力内容がある(FlexibleDate 入力内容) {
        return 入力内容 != null && !入力内容.isEmpty();
    }

    private boolean is入力内容がある(List<RString> 入力内容) {
        return 入力内容 != null && !入力内容.isEmpty();
    }

    private void 申請日の未入力チェック() {
        if (!is入力内容がある(div.getTxtShinseiYMD().getValue())) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("申請日"));
        }
    }

    private void 決定区分の未入力チェック() {
        if (!is入力内容がある(div.getRadKetteiKubun().getSelectedKey())) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("決定区分"));
        }
    }

    private void 決定日の未入力チェック() {
        if (!is入力内容がある(div.getTxtKetteiYMD().getValue())) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("決定日"));
        }
    }

    private void 適用日の未入力チェック() {
        if (!is入力内容がある(div.getTxtTekiyoYMD().getValue())) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("適用日"));
        }
    }

    private void 有効期限の未入力チェック() {
        if (!is入力内容がある(div.getTxtYukoKigenYMD().getValue())) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("有効期限"));
        }
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を確定する」を押下する。
     *
     */
    public void onClick_btnShinseiKakutei() {
        申請日の未入力チェック();
        情報を確定する処理();
    }

    private void 情報を確定する処理() {
        ShakaifukuRiyoshaFutanKeigenToJotai 編集情報
                = ViewStateHolder.get(DBD1030001ViewStateKey.編集社会福祉法人等利用者負担軽減申請の情報, ShakaifukuRiyoshaFutanKeigenToJotai.class);
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        if (null == 編集情報) {
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報 = get社会福祉法人等利用者負担軽減申請の情報From画面(true, 0);
            追加社会福祉法人等利用者負担軽減申請の情報(画面社会福祉法人等利用者負担軽減申請情報, 情報と状態ArrayList);
        } else {
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報
                    = get社会福祉法人等利用者負担軽減申請の情報From画面(false, 編集情報.get社会福祉法人等利用者負担軽減情報().get履歴番号());
            修正社会福祉法人等利用者負担軽減申請の情報(画面社会福祉法人等利用者負担軽減申請情報, 情報と状態ArrayList, 編集情報);
        }
    }

    private ShakaifukuRiyoshaFutanKeigen get社会福祉法人等利用者負担軽減申請の情報From画面(
            boolean is新规, int 履歴番号) {
        Integer 追加履歴番号;
        if (is新规) {
            追加履歴番号 = ViewStateHolder.get(DBD1030001ViewStateKey.追加履歴番号, Integer.class);
            if (null == 追加履歴番号 || 追加履歴番号 == 0) {
                追加履歴番号 = -1;
            }
        } else {
            追加履歴番号 = 履歴番号;
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = get証記載保険者番号();
        ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減申請の情報
                = new ShakaifukuRiyoshaFutanKeigen(証記載保険者番号, get被保険者番号FromViewState(), 追加履歴番号);
        ViewStateHolder.put(DBD1030001ViewStateKey.追加履歴番号, 追加履歴番号 - 1);
        ShakaifukuRiyoshaFutanKeigenBuilder builder = 社会福祉法人等利用者負担軽減申請の情報.createBuilderForEdit();
        builder.set申請年月日(div.getTxtShinseiYMD().getValue());
        builder.set申請事由(div.getTxtShinseiRiyu().getValue());
        builder.set決定区分(get決定区分From画面());
        builder.set決定年月日(div.getTxtKetteiYMD().getValue());
        builder.set適用開始年月日(div.getTxtTekiyoYMD().getValue());
        builder.set適用終了年月日(div.getTxtYukoKigenYMD().getValue());
        builder.set減免区分(div.getDdlKeigenJiyu().getSelectedValue());
        if (div.getTxtKeigenRitsuBunshi().getValue() != null && div.getTxtKeigenRitsuBunbo().getValue() != null) {
            builder.set軽減率_分子(div.getTxtKeigenRitsuBunshi().getValue());
            builder.set軽減率_分母(div.getTxtKeigenRitsuBunbo().getValue());
        }
        builder.set生保扶助見直し特例有無(is特例措置対象者チェックオン());
        builder.set居宅サービス限定(is居宅サービス限定チェックオン());
        builder.set居住費_食費のみ(is居住費_食費限定チェックオン());
        builder.set旧措置者ユニット型個室のみ(is旧措置ユニット型個室限定チェックオン());
        builder.set確認番号(div.getTxtKakuninNo().getValue());
        builder.set非承認理由(div.getTxtHiShoninRiyu().getValue());
        GemmenGengakuShinsei 減免減額申請 = get減免減額申請From画面(証記載保険者番号, 追加履歴番号);
        builder.setGemmenGengakuShinsei(減免減額申請);
        return builder.build();
    }

    private ShoKisaiHokenshaNo get証記載保険者番号() {
        HokenshaList hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        HihokenshaDaichoManager 被保険者台帳manager = new HihokenshaDaichoManager();
        HihokenshaDaicho 被保険者台帳 = 被保険者台帳manager.find最新被保険者台帳(div.getTxtShinseiYMD().getValue());
        LasdecCode 広住特措置元市町村コード = 被保険者台帳.get広住特措置元市町村コード();
        HokenshaSummary hokenshaSummary;
        if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
            hokenshaSummary = hokenshaList.get(広住特措置元市町村コード);
        } else {
            hokenshaSummary = hokenshaList.get(被保険者台帳.get市町村コード());
        }
        return hokenshaSummary.get証記載保険者番号();
    }

    private GemmenGengakuShinsei get減免減額申請From画面(ShoKisaiHokenshaNo 証記載保険者番号, Integer 追加履歴番号) {
        GemmenGengakuShinsei 減免減額申請 = new GemmenGengakuShinsei(証記載保険者番号,
                get被保険者番号FromViewState(), GemmenGengakuShurui.訪問介護利用者負担額減額.getコード(), 追加履歴番号);
        GemmenGengakuShinseiBuilder builder = 減免減額申請.createBuilderForEdit();
        ShinseiJoho 減免減額申請情報 = div.getCcdShinseiJoho().get減免減額申請情報();
        if (減免減額申請情報.get申請届出代行区分() != null) {
            builder.set申請届出代行区分(減免減額申請情報.get申請届出代行区分().getCode());
        }
        if (null == 減免減額申請情報.get申請届出者氏名()) {
            builder.set申請届出者氏名(AtenaMeisho.EMPTY);
        } else {
            builder.set申請届出者氏名(減免減額申請情報.get申請届出者氏名());
        }
        if (null == 減免減額申請情報.get申請届出者氏名カナ()) {
            builder.set申請届出者氏名カナ(AtenaKanaMeisho.EMPTY);
        } else {
            builder.set申請届出者氏名カナ(減免減額申請情報.get申請届出者氏名カナ());
        }
        if (null == 減免減額申請情報.get申請届出者続柄()) {
            builder.set申請届出者続柄(RString.EMPTY);
        } else {
            builder.set申請届出者続柄(減免減額申請情報.get申請届出者続柄());
        }
        if (減免減額申請情報.get申請届出代行事業者番号() != null && !減免減額申請情報.get申請届出代行事業者番号().isEmpty()) {
            builder.set申請届出代行事業者番号(減免減額申請情報.get申請届出代行事業者番号());
        }
        if (減免減額申請情報.get事業者区分() != null) {
            builder.set事業者区分(減免減額申請情報.get事業者区分().getCode());
        }
        if (null == 減免減額申請情報.get申請届出者郵便番号()) {
            builder.set申請届出者郵便番号(YubinNo.EMPTY);
        } else {
            builder.set申請届出者郵便番号(減免減額申請情報.get申請届出者郵便番号());
        }
        if (null == 減免減額申請情報.get申請届出者住所()) {
            builder.set申請届出者住所(AtenaJusho.EMPTY);
        } else {
            builder.set申請届出者住所(減免減額申請情報.get申請届出者住所());
        }
        if (null == 減免減額申請情報.get申請届出者電話番号()) {
            builder.set申請届出者電話番号(TelNo.EMPTY);
        } else {
            builder.set申請届出者電話番号(減免減額申請情報.get申請届出者電話番号());
        }
        return builder.build();
    }

    private boolean is特例措置対象者チェックオン() {
        return div.getChkTokureiTaisho().getSelectedKeys().contains(KEY0);
    }

    private boolean is居宅サービス限定チェックオン() {
        return div.getChkKyotakuServiceGentei().getSelectedKeys().contains(KEY0);
    }

    private boolean is居住費_食費限定チェックオン() {
        return div.getChkKyojuhiShokuhiGentei().getSelectedKeys().contains(KEY0);
    }

    private boolean is旧措置ユニット型個室限定チェックオン() {
        return div.getChkKyusochiUnitGataJunKoshitsu().getSelectedKeys().contains(KEY0);
    }

    private RString get決定区分From画面() {
        if (KEY0.equals(div.getRadKetteiKubun().getSelectedKey())) {
            return 承認する;
        } else if (KEY1.equals(div.getRadKetteiKubun().getSelectedKey())) {
            return 承認しない;
        } else {
            return RString.EMPTY;
        }
    }

    private void 修正社会福祉法人等利用者負担軽減申請の情報(ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報,
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList, ShakaifukuRiyoshaFutanKeigenToJotai 編集情報) {
        ShakaifukuRiyoshaFutanKeigenToJotai 修正後社会福祉法人等利用者負担軽減申請情報
                = get修正後社会福祉法人等利用者負担軽減申請情報(画面社会福祉法人等利用者負担軽減申請情報, 編集情報);
        修正情報と状態(修正後社会福祉法人等利用者負担軽減申請情報, 編集情報, 情報と状態ArrayList);
    }

    private void 修正情報と状態(ShakaifukuRiyoshaFutanKeigenToJotai 修正後社会福祉法人等利用者負担軽減申請情報,
            ShakaifukuRiyoshaFutanKeigenToJotai 編集情報, ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        ShakaifukuRiyoshaFutanKeigen 修正後情報 = 修正後社会福祉法人等利用者負担軽減申請情報.get社会福祉法人等利用者負担軽減情報();
        int 履歴番号 = 編集情報.get新履歴番号();
        boolean is申請年月日変更 = !編集情報.get社会福祉法人等利用者負担軽減情報().get申請年月日()
                .equals(修正後社会福祉法人等利用者負担軽減申請情報.get社会福祉法人等利用者負担軽減情報().get申請年月日());
        int 削除位置 = 0;
        for (int 位置 = 0; 位置 < 情報と状態ArrayList.size(); 位置++) {
            ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 = 情報と状態ArrayList.get(位置);
            if (編集情報.get社会福祉法人等利用者負担軽減情報().identifier().equals(情報と状態.get社会福祉法人等利用者負担軽減情報().identifier())) {
                削除位置 = 位置;
            }
        }
        情報と状態ArrayList.remove(削除位置);
        FlexibleDate 申請日 = 修正後情報.get申請年月日();
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> new情報と状態ArrayList = new ArrayList<>();
        if (情報と状態ArrayList.isEmpty()) {
            new情報と状態ArrayList.add(new ShakaifukuRiyoshaFutanKeigenToJotai(
                    修正後情報, 修正後社会福祉法人等利用者負担軽減申請情報.get状態(), 履歴番号));
            ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
            List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
            div.getDgShinseiList().setDataSource(newDataSouceList);
            return;
        }
        boolean isAdded = false;
        int length = 情報と状態ArrayList.size();
        new情報と状態ArrayList.addAll(情報と状態ArrayList);
        if (!is申請年月日変更) {
            if (削除位置 > length - 1) {
                new情報と状態ArrayList.add(new ShakaifukuRiyoshaFutanKeigenToJotai(
                        修正後情報, 修正後社会福祉法人等利用者負担軽減申請情報.get状態(), 履歴番号));
            } else {
                new情報と状態ArrayList.add(削除位置, new ShakaifukuRiyoshaFutanKeigenToJotai(
                        修正後情報, 修正後社会福祉法人等利用者負担軽減申請情報.get状態(), 履歴番号));
            }
            ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
            List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
            div.getDgShinseiList().setDataSource(newDataSouceList);
            return;
        }
        new情報と状態ArrayList.add(null);
        for (int index = length - 1; index >= 0; index--) {
            ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 = 情報と状態ArrayList.get(index);
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
            int 履歴番号1 = 情報と状態.get新履歴番号();
            if (isAdded) {
                new情報と状態ArrayList.add(index, new ShakaifukuRiyoshaFutanKeigenToJotai(
                        社会福祉法人等利用者負担軽減情報, 情報と状態.get状態(), 履歴番号1 + 1));
                new情報と状態ArrayList.remove(index + 1);
            } else {
                if (申請日.isBefore(社会福祉法人等利用者負担軽減情報.get申請年月日())) {
                    new情報と状態ArrayList.add(index + 1, new ShakaifukuRiyoshaFutanKeigenToJotai(
                            修正後情報, 修正後社会福祉法人等利用者負担軽減申請情報.get状態(), 履歴番号1));
                    new情報と状態ArrayList.remove(index + 2);
                    new情報と状態ArrayList.add(index, new ShakaifukuRiyoshaFutanKeigenToJotai(
                            社会福祉法人等利用者負担軽減情報, 情報と状態.get状態(), 履歴番号1 + 1));
                    new情報と状態ArrayList.remove(index + 1);
                    isAdded = true;
                } else {
                    new情報と状態ArrayList.add(index + 1, new ShakaifukuRiyoshaFutanKeigenToJotai(
                            社会福祉法人等利用者負担軽減情報, 情報と状態.get状態(), 履歴番号1));
                    new情報と状態ArrayList.remove(index + 2);
                }
            }
            if (!isAdded && index == 0) {
                new情報と状態ArrayList.add(0, new ShakaifukuRiyoshaFutanKeigenToJotai(
                        修正後情報, 修正後社会福祉法人等利用者負担軽減申請情報.get状態(), 履歴番号1 + 1));
                new情報と状態ArrayList.remove(1);
            }
        }
        ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
        List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
        div.getDgShinseiList().setDataSource(newDataSouceList);
    }

    private ShakaifukuRiyoshaFutanKeigenToJotai get修正後社会福祉法人等利用者負担軽減申請情報(
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報, ShakaifukuRiyoshaFutanKeigenToJotai 編集情報) {
        ShakaifukuRiyoshaFutanKeigen 情報 = 編集情報.get社会福祉法人等利用者負担軽減情報();
        ShoKisaiHokenshaNo 証記載保険者番号 = 情報.get証記載保険者番号();
        HihokenshaNo 被保険者番号 = 情報.get被保険者番号();
        int 履歴番号 = 情報.get履歴番号();
        ShakaifukuRiyoshaFutanKeigen new情報 = new ShakaifukuRiyoshaFutanKeigen(証記載保険者番号, 被保険者番号, 履歴番号);
        ShakaifukuRiyoshaFutanKeigenBuilder builder = new情報.createBuilderForEdit();
        boolean 変更ある = 軽減率_分母_分子Builder(builder, 画面社会福祉法人等利用者負担軽減申請情報, 情報);
        変更ある = set修正後社会福祉法人等利用者負担軽減申請情報(builder, 変更ある, 画面社会福祉法人等利用者負担軽減申請情報, 情報);
        if (!情報.get適用終了年月日().equals(画面社会福祉法人等利用者負担軽減申請情報.get適用終了年月日())) {
            builder.set適用終了年月日(画面社会福祉法人等利用者負担軽減申請情報.get適用終了年月日());
            変更ある = true;
        } else {
            builder.set適用終了年月日(情報.get適用終了年月日());
        }
        if (!情報.get適用開始年月日().equals(画面社会福祉法人等利用者負担軽減申請情報.get適用開始年月日())) {
            builder.set適用開始年月日(画面社会福祉法人等利用者負担軽減申請情報.get適用開始年月日());
            変更ある = true;
        } else {
            builder.set適用開始年月日(情報.get適用開始年月日());
        }
        if (!情報.get非承認理由().equals(画面社会福祉法人等利用者負担軽減申請情報.get非承認理由())) {
            builder.set非承認理由(画面社会福祉法人等利用者負担軽減申請情報.get非承認理由());
            変更ある = true;
        } else {
            builder.set非承認理由(情報.get非承認理由());
        }
        if (情報.is生保扶助見直し特例有無() != 画面社会福祉法人等利用者負担軽減申請情報.is生保扶助見直し特例有無()) {
            builder.set生保扶助見直し特例有無(画面社会福祉法人等利用者負担軽減申請情報.is生保扶助見直し特例有無());
            変更ある = true;
        }
        if (情報.is居宅サービス限定() != 画面社会福祉法人等利用者負担軽減申請情報.is居宅サービス限定()) {
            builder.set居宅サービス限定(画面社会福祉法人等利用者負担軽減申請情報.is居宅サービス限定());
            変更ある = true;
        }
        if (情報.is居住費_食費のみ() != 画面社会福祉法人等利用者負担軽減申請情報.is居住費_食費のみ()) {
            builder.set居住費_食費のみ(画面社会福祉法人等利用者負担軽減申請情報.is居住費_食費のみ());
            変更ある = true;
        }
        if (情報.is旧措置者ユニット型個室のみ() != 画面社会福祉法人等利用者負担軽減申請情報.is旧措置者ユニット型個室のみ()) {
            builder.set旧措置者ユニット型個室のみ(画面社会福祉法人等利用者負担軽減申請情報.is旧措置者ユニット型個室のみ());
            変更ある = true;
        }
        builder.set生活保護受給有無(情報.is生活保護受給有無());
        builder.set老齢福祉年金受給有無(情報.is老齢福祉年金受給有無());
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 画面社会福祉法人等利用者負担軽減申請情報.getGemmenGengakuShinseiList();
        GemmenGengakuShinsei 減免減額申請 = 情報.getGemmenGengakuShinseiList().get(0);
        GemmenGengakuShinsei 画面減免減額申請 = gemmenGengakuShinseiList.get(0);
        boolean 減免減額申請変更 = 減免減額申請変更(減免減額申請, 画面減免減額申請);
        if (減免減額申請変更) {
            builder.setGemmenGengakuShinsei(
                    set修正後社会福祉法人等利用者負担軽減申請情報_減免減額申請(画面減免減額申請, 証記載保険者番号, 被保険者番号, 履歴番号));
            変更ある = 減免減額申請変更;
        } else {
            builder.setGemmenGengakuShinsei(
                    set修正後社会福祉法人等利用者負担軽減申請情報_減免減額申請(減免減額申請, 証記載保険者番号, 被保険者番号, 履歴番号));
        }
        RString 編集前状態 = 編集情報.get状態();
        ShakaifukuRiyoshaFutanKeigen 編集後情報 = builder.build();
        return get編集後情報と状態By編集後情報(編集後情報, 変更ある, 編集前状態);
    }

    private boolean 減免減額申請変更(GemmenGengakuShinsei 減免減額申請, GemmenGengakuShinsei 画面減免減額申請) {
        if (null == 画面減免減額申請.get事業者区分() && null == 減免減額申請.get事業者区分()
                || !画面減免減額申請.get事業者区分().equals(減免減額申請.get事業者区分())) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出代行事業者番号() && null == 減免減額申請.get申請届出代行事業者番号()
                || !画面減免減額申請.get申請届出代行事業者番号().equals(減免減額申請.get申請届出代行事業者番号())) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出代行区分() && null == 減免減額申請.get申請届出代行区分()
                || !画面減免減額申請.get申請届出代行区分().equals(減免減額申請.get申請届出代行区分())) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出者住所() && null == 減免減額申請.get申請届出者住所()
                || !画面減免減額申請.get申請届出者住所().equals(減免減額申請.get申請届出者住所())) {
            return true;
        }
        return 減免減額申請変更2(減免減額申請, 画面減免減額申請);
    }

    private boolean 減免減額申請変更2(GemmenGengakuShinsei 減免減額申請, GemmenGengakuShinsei 画面減免減額申請) {
        if (null == 画面減免減額申請.get申請届出者氏名() && null == 減免減額申請.get申請届出者氏名()
                || !画面減免減額申請.get申請届出者氏名().equals(減免減額申請.get申請届出者氏名())) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出者氏名カナ() && null == 減免減額申請.get申請届出者氏名カナ()
                || !画面減免減額申請.get申請届出者氏名カナ().equals(減免減額申請.get申請届出者氏名カナ())) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出者続柄() && null == 減免減額申請.get申請届出者続柄()
                || !画面減免減額申請.get申請届出者続柄().equals(減免減額申請.get申請届出者続柄())) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出者郵便番号() && null == 減免減額申請.get申請届出者郵便番号()
                || !画面減免減額申請.get申請届出者郵便番号().equals(減免減額申請.get申請届出者郵便番号())) {
            return true;
        }
        return null == 画面減免減額申請.get申請届出者電話番号() && null == 減免減額申請.get申請届出者電話番号()
                || !画面減免減額申請.get申請届出者電話番号().equals(減免減額申請.get申請届出者電話番号());
    }

    private GemmenGengakuShinsei set修正後社会福祉法人等利用者負担軽減申請情報_減免減額申請(GemmenGengakuShinsei gemmenGengakuShinsei,
            ShoKisaiHokenshaNo 証記載保険者番号, HihokenshaNo 被保険者番号, int 履歴番号) {
        GemmenGengakuShinsei newGemmenGengakuShinsei = new GemmenGengakuShinsei(
                証記載保険者番号, 被保険者番号, GemmenGengakuShurui.訪問介護利用者負担額減額.getコード(), 履歴番号);
        GemmenGengakuShinseiBuilder builder = newGemmenGengakuShinsei.createBuilderForEdit();
        if (gemmenGengakuShinsei.get事業者区分() != null) {
            builder.set事業者区分(gemmenGengakuShinsei.get事業者区分());
        }
        if (gemmenGengakuShinsei.get申請届出代行事業者番号() != null) {
            builder.set申請届出代行事業者番号(gemmenGengakuShinsei.get申請届出代行事業者番号());
        }
        if (gemmenGengakuShinsei.get申請届出代行区分() != null) {
            builder.set申請届出代行区分(gemmenGengakuShinsei.get申請届出代行区分());
        }
        if (gemmenGengakuShinsei.get申請届出者住所() != null) {
            builder.set申請届出者住所(gemmenGengakuShinsei.get申請届出者住所());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名() != null) {
            builder.set申請届出者氏名(gemmenGengakuShinsei.get申請届出者氏名());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名カナ() != null) {
            builder.set申請届出者氏名カナ(gemmenGengakuShinsei.get申請届出者氏名カナ());
        }
        if (gemmenGengakuShinsei.get申請届出者続柄() != null) {
            builder.set申請届出者続柄(gemmenGengakuShinsei.get申請届出者続柄());
        }
        if (gemmenGengakuShinsei.get申請届出者郵便番号() != null) {
            builder.set申請届出者郵便番号(gemmenGengakuShinsei.get申請届出者郵便番号());
        }
        if (gemmenGengakuShinsei.get申請届出者電話番号() != null) {
            builder.set申請届出者電話番号(gemmenGengakuShinsei.get申請届出者電話番号());
        }
        return builder.build();
    }

    private boolean set修正後社会福祉法人等利用者負担軽減申請情報(ShakaifukuRiyoshaFutanKeigenBuilder builder, boolean is変更ある,
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報, ShakaifukuRiyoshaFutanKeigen 情報) {
        boolean 変更ある = false;
        if (!情報.get決定区分().equals(画面社会福祉法人等利用者負担軽減申請情報.get決定区分())) {
            builder.set決定区分(画面社会福祉法人等利用者負担軽減申請情報.get決定区分());
            変更ある = true;
        } else {
            builder.set決定区分(情報.get決定区分());
        }
        if (!情報.get決定年月日().equals(画面社会福祉法人等利用者負担軽減申請情報.get決定年月日())) {
            builder.set決定年月日(画面社会福祉法人等利用者負担軽減申請情報.get決定年月日());
            変更ある = true;
        } else {
            builder.set決定年月日(情報.get決定年月日());
        }
        if (!情報.get減免区分().equals(画面社会福祉法人等利用者負担軽減申請情報.get減免区分())) {
            builder.set減免区分(画面社会福祉法人等利用者負担軽減申請情報.get減免区分());
            変更ある = true;
        } else {
            builder.set減免区分(情報.get減免区分());
        }
        if (!情報.get申請事由().equals(画面社会福祉法人等利用者負担軽減申請情報.get申請事由())) {
            builder.set申請事由(画面社会福祉法人等利用者負担軽減申請情報.get申請事由());
            変更ある = true;
        } else {
            builder.set申請事由(情報.get申請事由());
        }
        if (!情報.get申請年月日().equals(画面社会福祉法人等利用者負担軽減申請情報.get申請年月日())) {
            builder.set申請年月日(画面社会福祉法人等利用者負担軽減申請情報.get申請年月日());
            変更ある = true;
        } else {
            builder.set申請年月日(情報.get申請年月日());
        }
        if (!情報.get確認番号().equals(画面社会福祉法人等利用者負担軽減申請情報.get確認番号())) {
            builder.set確認番号(画面社会福祉法人等利用者負担軽減申請情報.get確認番号());
            変更ある = true;
        } else {
            builder.set確認番号(情報.get確認番号());
        }
        if (is変更ある) {
            return is変更ある;
        } else {
            return 変更ある;
        }
    }

    private boolean 軽減率_分母_分子Builder(ShakaifukuRiyoshaFutanKeigenBuilder builder,
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報, ShakaifukuRiyoshaFutanKeigen 情報) {
        boolean 変更ある = false;
        if (null == 画面社会福祉法人等利用者負担軽減申請情報.get軽減率_分子()) {
            if (情報.get軽減率_分子() != null) {
                変更ある = true;
            }
        } else {
            if (null == 情報.get軽減率_分子()
                    || 情報.get軽減率_分子().compareTo(画面社会福祉法人等利用者負担軽減申請情報.get軽減率_分子()) != 0) {
                builder.set軽減率_分子(画面社会福祉法人等利用者負担軽減申請情報.get軽減率_分子());
                変更ある = true;
            } else {
                builder.set軽減率_分子(情報.get軽減率_分子());
            }
        }
        if (null == 画面社会福祉法人等利用者負担軽減申請情報.get軽減率_分母()) {
            if (情報.get軽減率_分母() != null) {
                変更ある = true;
            }
        } else {
            if (null == 情報.get軽減率_分母()
                    || 情報.get軽減率_分母().compareTo(画面社会福祉法人等利用者負担軽減申請情報.get軽減率_分母()) != 0) {
                builder.set軽減率_分母(画面社会福祉法人等利用者負担軽減申請情報.get軽減率_分母());
                変更ある = true;
            } else {
                builder.set軽減率_分母(情報.get軽減率_分母());
            }
        }
        return 変更ある;
    }

    private ShakaifukuRiyoshaFutanKeigenToJotai get編集後情報と状態By編集後情報(
            ShakaifukuRiyoshaFutanKeigen 編集後情報, boolean 変更ある, RString 編集前状態) {
        if (null == 編集前状態 || 編集前状態.isEmpty() || 状態_削除.equals(編集前状態)) {
            if (変更ある) {
                return new ShakaifukuRiyoshaFutanKeigenToJotai(編集後情報, 状態_修正, 0);
            } else {
                return new ShakaifukuRiyoshaFutanKeigenToJotai(編集後情報, RString.EMPTY, 0);
            }
        } else if (状態_追加.equals(編集前状態)) {
            return new ShakaifukuRiyoshaFutanKeigenToJotai(編集後情報, 状態_追加, 0);
        } else if (状態_修正.equals(編集前状態)) {
            return new ShakaifukuRiyoshaFutanKeigenToJotai(編集後情報, 状態_修正, 0);
        }
        return null;
    }

    private void 追加社会福祉法人等利用者負担軽減申請の情報(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減申請情報,
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        FlexibleDate 申請日 = 社会福祉法人等利用者負担軽減申請情報.get申請年月日();
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> new情報と状態ArrayList = new ArrayList<>();
        if (情報と状態ArrayList.isEmpty()) {
            new情報と状態ArrayList.add(new ShakaifukuRiyoshaFutanKeigenToJotai(社会福祉法人等利用者負担軽減申請情報, 状態_追加, 0));
            ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
            List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
            div.getDgShinseiList().setDataSource(newDataSouceList);
            return;
        }
        boolean isAdded = false;
        int length = 情報と状態ArrayList.size();
        new情報と状態ArrayList.addAll(情報と状態ArrayList);
        new情報と状態ArrayList.add(null);
        for (int index = length - 1; index >= 0; index--) {
            ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 = 情報と状態ArrayList.get(index);
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
            int 履歴番号 = 情報と状態.get新履歴番号();
            if (isAdded) {
                new情報と状態ArrayList.add(index, new ShakaifukuRiyoshaFutanKeigenToJotai(
                        社会福祉法人等利用者負担軽減情報, 情報と状態.get状態(), 履歴番号 + 1));
                new情報と状態ArrayList.remove(index + 1);
            } else {
                if (申請日.isBefore(社会福祉法人等利用者負担軽減情報.get申請年月日())) {
                    new情報と状態ArrayList.add(index + 1, new ShakaifukuRiyoshaFutanKeigenToJotai(
                            社会福祉法人等利用者負担軽減申請情報, 状態_追加, 履歴番号));
                    new情報と状態ArrayList.remove(index + 2);
                    new情報と状態ArrayList.add(index, new ShakaifukuRiyoshaFutanKeigenToJotai(
                            社会福祉法人等利用者負担軽減情報, 情報と状態.get状態(), 履歴番号 + 1));
                    new情報と状態ArrayList.remove(index + 1);
                    isAdded = true;
                } else {
                    new情報と状態ArrayList.add(index + 1, new ShakaifukuRiyoshaFutanKeigenToJotai(
                            社会福祉法人等利用者負担軽減情報, 情報と状態.get状態(), 履歴番号));
                    new情報と状態ArrayList.remove(index + 2);
                }
            }
            if (!isAdded && index == 0) {
                new情報と状態ArrayList.add(0, new ShakaifukuRiyoshaFutanKeigenToJotai(
                        社会福祉法人等利用者負担軽減申請情報, 状態_追加, 履歴番号 + 1));
                new情報と状態ArrayList.remove(1);
            }
        }
        ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
        List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
        div.getDgShinseiList().setDataSource(newDataSouceList);
    }

    private GemmenGengakuShinsei get減免減額申請ByChange履歴番号(GemmenGengakuShinsei emmenGengakuShinsei, int 履歴番号) {
        GemmenGengakuShinsei newGemmenGengakuShinsei = new GemmenGengakuShinsei(
                emmenGengakuShinsei.get証記載保険者番号(),
                emmenGengakuShinsei.get被保険者番号(),
                GemmenGengakuShurui.訪問介護利用者負担額減額.getコード(),
                履歴番号);
        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder = newGemmenGengakuShinsei.createBuilderForEdit();
        if (emmenGengakuShinsei.get申請届出代行区分() != null) {
            gemmenGengakuShinseiBuilder.set申請届出代行区分(emmenGengakuShinsei.get申請届出代行区分());
        }
        if (emmenGengakuShinsei.get申請届出者氏名() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名(emmenGengakuShinsei.get申請届出者氏名());
        }
        if (emmenGengakuShinsei.get申請届出者氏名カナ() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名カナ(emmenGengakuShinsei.get申請届出者氏名カナ());
        }
        if (emmenGengakuShinsei.get申請届出者続柄() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者続柄(emmenGengakuShinsei.get申請届出者続柄());
        }
        if (emmenGengakuShinsei.get申請届出代行事業者番号() != null) {
            gemmenGengakuShinseiBuilder.set申請届出代行事業者番号(emmenGengakuShinsei.get申請届出代行事業者番号());
        }
        if (emmenGengakuShinsei.get事業者区分() != null) {
            gemmenGengakuShinseiBuilder.set事業者区分(emmenGengakuShinsei.get事業者区分());
        }
        if (emmenGengakuShinsei.get申請届出者郵便番号() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者郵便番号(emmenGengakuShinsei.get申請届出者郵便番号());
        }
        if (emmenGengakuShinsei.get申請届出者住所() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者住所(emmenGengakuShinsei.get申請届出者住所());
        }
        if (emmenGengakuShinsei.get申請届出者電話番号() != null) {
            gemmenGengakuShinseiBuilder.set申請届出者電話番号(emmenGengakuShinsei.get申請届出者電話番号());
        }
        return gemmenGengakuShinseiBuilder.build();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「承認情報を確定する」を押下する。
     *
     */
    public void onClick_btnShoninKakutei() {
        承認情報のチェック();
        情報を確定する処理();
    }

    private void 承認情報のチェック() {
        承認情報必須入力チェック();
        承認情報相関チェック１();
    }

    private void 承認情報相関チェック１() {
        FlexibleDate 適用開始日 = div.getTxtTekiyoYMD().getValue();
        FlexibleDate 法施工日 = get法施工日();
        ShakaiFukushiHojinKeigenService service = ShakaiFukushiHojinKeigenService.createIntance();
        if (!法施工日.isEmpty() && 適用開始日.isBefore(法施工日)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_適用日が法施行前.getMessage());
        }
        FlexibleDate 標準有効期限 = service.estimate有効期限(適用開始日);
        FlexibleDate 有効期限 = div.getTxtYukoKigenYMD().getValue();
        if (標準有効期限.isEmpty() || 標準有効期限.isBefore(有効期限)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_有効期限が年度外.getMessage());
        }
        if (有効期限.isBefore(適用開始日)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_有効期限が適用日以前.getMessage());
        }
        Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
        Decimal 減免率_分母 = div.getTxtKeigenRitsuBunbo().getValue();
        if (減免率_分子.compareTo(減免率_分母) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子が分母より大.getMessage());
        }
        List<RString> 居宅サービス限定SelectKeys = div.getChkKyotakuServiceGentei().getSelectedKeys();
        List<RString> 旧措置ユニット型個室SelectKeys = div.getChkKyusochiUnitGataJunKoshitsu().getSelectedKeys();
        if (!居宅サービス限定SelectKeys.isEmpty() && !旧措置ユニット型個室SelectKeys.isEmpty()) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択.getMessage());
        }
        承認情報相関チェック１_15(減免率_分子, 減免率_分母, 適用開始日, 居宅サービス限定SelectKeys, 旧措置ユニット型個室SelectKeys);
        if (!service.canBe利用者(get被保険者番号FromViewState(), 適用開始日)) {
            throw new ApplicationException(DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage());
        }
    }

    private void 承認情報相関チェック１_15(Decimal 減免率_分子, Decimal 減免率_分母, FlexibleDate 適用開始日,
            List<RString> 居宅サービス限定SelectKeys, List<RString> 旧措置ユニット型個室SelectKeys) {
        FlexibleDate 制度改正施行日_平成１７年１０月改正 = get制度改正施行日_平成１７年１０月改正();
        FlexibleDate 特例措置期間開始日 = get特例措置期間開始日();
        FlexibleDate 特例措置期間終了日 = get特例措置期間終了日();
        if (!制度改正施行日_平成１７年１０月改正.isEmpty() && 適用開始日.isBefore(制度改正施行日_平成１７年１０月改正)) {
            軽減率_分子_分母チェック1(減免率_分子, 減免率_分母);
        } else if (適用開始日.isBefore(FLEXIBLEDDTE_20060701)) {
            軽減率_分子_分母チェック2(減免率_分子, 減免率_分母);
        } else if (特例措置期間開始日.isBeforeOrEquals(適用開始日) && !特例措置期間終了日.isEmpty() && 適用開始日.isBeforeOrEquals(特例措置期間終了日)) {
            if (!居宅サービス限定SelectKeys.isEmpty() || isすべてがチェックオフ()) {
                軽減率_分子_分母チェック3(減免率_分子, 減免率_分母);
            } else {
                軽減率_分子_分母チェック4(減免率_分子, 減免率_分母);
            }
        } else if (!居宅サービス限定SelectKeys.isEmpty() || !旧措置ユニット型個室SelectKeys.isEmpty()) {
            if (減免率_分子.compareTo(DECIMAL_25) != 0 && 減免率_分子.compareTo(DECIMAL_50) != 0) {
                throw new ApplicationException(DbdWarningMessages.社会福祉法人減免_軽減率_特例措置期間.getMessage());
            }
            if (減免率_分母.compareTo(DECIMAL_100) != 0) {
                throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
            } else {
                軽減率_分子_分母チェック4(減免率_分子, 減免率_分母);
            }
        } else {
            if (減免率_分母.compareTo(DECIMAL_100) != 0) {
                throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
            }
            if (減免率_分子.compareTo(DECIMAL_100) == 0 && FLEXIBLEDDTE_20110331.isBefore(適用開始日) && is対象の被保険者が生活保護()) {
                throw new ApplicationException(DbdWarningMessages.社会福祉法人減免_非生活保護者_軽減率100.getMessage());
            } else {
                軽減率_分子チェック1(減免率_分子);
            }
        }
    }

    private boolean isすべてがチェックオフ() {
        List<RString> 居宅サービス限定SelectKeys = div.getChkKyotakuServiceGentei().getSelectedKeys();
        List<RString> 居居住費_食費限定SelectKeys = div.getChkKyojuhiShokuhiGentei().getSelectedKeys();
        List<RString> 旧措置ユニット型個室限定SelectKeys = div.getChkKyusochiUnitGataJunKoshitsu().getSelectedKeys();
        return !is入力内容がある(居宅サービス限定SelectKeys)
                && !is入力内容がある(居居住費_食費限定SelectKeys)
                && !is入力内容がある(旧措置ユニット型個室限定SelectKeys);
    }

    private boolean is対象の被保険者が生活保護() {
        return SeikatsuhogoManagerFactory.createInstance()
                .get生活保護(get識別コードFromViewState(), GyomuCode.DB介護保険, div.getTxtShinseiYMD().getValue()) != null;
    }

    private void 軽減率_分子チェック1(Decimal 減免率_分子) {
        if (減免率_分子.compareTo(Decimal.ONE) < 0 || 減免率_分子.compareTo(DECIMAL_99_9) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子は1から99の範囲.getMessage());
        }
    }

    private void 軽減率_分子_分母チェック1(Decimal 減免率_分子, Decimal 減免率_分母) {
        if (減免率_分子.compareTo(Decimal.ZERO) < 0 || 減免率_分子.compareTo(DECIMAL_9) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子は1桁整数.getMessage());
        }
        if (減免率_分母.compareTo(DECIMAL_10) < 0 || 減免率_分母.compareTo(DECIMAL_99) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は2桁整数.getMessage());
        }
    }

    private void 軽減率_分子_分母チェック2(Decimal 減免率_分子, Decimal 減免率_分母) {
        if (減免率_分子.compareTo(DECIMAL_10) < 0 || 減免率_分子.compareTo(DECIMAL_99) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子は2桁整数.getMessage());
        }
        if (減免率_分母.compareTo(DECIMAL_100) != 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
        }
    }

    private void 軽減率_分子_分母チェック4(Decimal 減免率_分子, Decimal 減免率_分母) {
        if (減免率_分子.compareTo(Decimal.ONE) < 0 || 減免率_分子.compareTo(DECIMAL_99_9) > 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分子は1から99の範囲.getMessage());
        }
        if (減免率_分母.compareTo(DECIMAL_100) != 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
        }
    }

    private void 軽減率_分子_分母チェック3(Decimal 減免率_分子, Decimal 減免率_分母) {
        if (減免率_分子.compareTo(DECIMAL_28) != 0 && 減免率_分子.compareTo(DECIMAL_53) != 0) {
            throw new ApplicationException(DbdWarningMessages.社会福祉法人減免_軽減率_特例措置期間.getMessage());
        }
        if (減免率_分母.compareTo(DECIMAL_100) != 0) {
            throw new ApplicationException(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage());
        }
    }

    private FlexibleDate get特例措置期間開始日() {
        RString 特例措置期間開始日RString = BusinessConfig.get(ConfigNameDBD.社会福祉法人軽減_特例措置期間開始日, RDate.getNowDate(), LasdecCode.EMPTY);
        if (null == 特例措置期間開始日RString || 特例措置期間開始日RString.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(特例措置期間開始日RString);
    }

    private FlexibleDate get特例措置期間終了日() {
        RString 特例措置期間終了日RString = BusinessConfig.get(ConfigNameDBD.社会福祉法人軽減_特例措置期間終了日, RDate.getNowDate(), LasdecCode.EMPTY);
        if (特例措置期間終了日RString.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(特例措置期間終了日RString);
    }

    private FlexibleDate get制度改正施行日_平成１７年１０月改正() {
        RString 制度改正施行日RString = BusinessConfig.get(ConfigNameDBU.制度改正施行日_平成１７年１０月改正, RDate.getNowDate(), LasdecCode.EMPTY);
        if (null == 制度改正施行日RString || 制度改正施行日RString.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(制度改正施行日RString);
    }

    private FlexibleDate get法施工日() {
        RString 法施工日RString = BusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), LasdecCode.EMPTY);
        if (null == 法施工日RString || 法施工日RString.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(法施工日RString);
    }

    private void 承認情報必須入力チェック() {
        申請日の未入力チェック();
        決定区分の未入力チェック();
        決定日の未入力チェック();
        適用日の未入力チェック();
        有効期限の未入力チェック();
    }

    /**
     * 前排他を解除する。
     *
     */
    public void 前排他の解除() {
        RealInitialLocker.release(new LockingKey(new RString("DB").concat(get被保険者番号FromViewState().getColumnValue()).concat("ShafukuKeigen")));
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を保存する」を押下する。
     *
     */
    public void onClick_btnUpdate() {
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        更新処理(情報と状態ArrayList);
        前排他の解除();
        div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
    }

    private void 更新処理(ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態ArrayList) {
            RString 状態 = 情報と状態.get状態();
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
            int 履歴番号 = 情報と状態.get新履歴番号();
            if (状態_削除.equals(状態)) {
                削除処理(社会福祉法人等利用者負担軽減情報);
            } else if (状態_修正.equals(状態)) {
                if (履歴番号 == 社会福祉法人等利用者負担軽減情報.get履歴番号()) {
                    修正処理(社会福祉法人等利用者負担軽減情報);
                } else {
                    削除処理(社会福祉法人等利用者負担軽減情報);
                    追加処理(get社会福祉法人等利用者負担軽減情報ByChange履歴番号(社会福祉法人等利用者負担軽減情報, 履歴番号));
                }
            } else if (状態_追加.equals(状態)) {
                追加処理(get社会福祉法人等利用者負担軽減情報ByChange履歴番号(社会福祉法人等利用者負担軽減情報, 履歴番号));
            } else if (履歴番号 != 社会福祉法人等利用者負担軽減情報.get履歴番号()) {
                削除処理(社会福祉法人等利用者負担軽減情報);
                追加処理(get社会福祉法人等利用者負担軽減情報ByChange履歴番号(社会福祉法人等利用者負担軽減情報, 履歴番号));
            }
        }
    }

    private ShakaifukuRiyoshaFutanKeigen get社会福祉法人等利用者負担軽減情報ByChange履歴番号(
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報, int 履歴番号) {
        ShakaifukuRiyoshaFutanKeigen new社会福祉法人等利用者負担軽減情報 = new ShakaifukuRiyoshaFutanKeigen(
                社会福祉法人等利用者負担軽減情報.get証記載保険者番号(),
                社会福祉法人等利用者負担軽減情報.get被保険者番号(),
                履歴番号);
        ShakaifukuRiyoshaFutanKeigenBuilder builder = new社会福祉法人等利用者負担軽減情報.createBuilderForEdit();
        builder.set申請年月日(社会福祉法人等利用者負担軽減情報.get申請年月日());
        builder.set申請事由(社会福祉法人等利用者負担軽減情報.get申請事由());
        builder.set決定区分(社会福祉法人等利用者負担軽減情報.get決定区分());
        builder.set決定年月日(社会福祉法人等利用者負担軽減情報.get決定年月日());
        builder.set適用開始年月日(社会福祉法人等利用者負担軽減情報.get適用開始年月日());
        builder.set適用終了年月日(社会福祉法人等利用者負担軽減情報.get適用終了年月日());
        builder.set減免区分(社会福祉法人等利用者負担軽減情報.get減免区分());
        if (社会福祉法人等利用者負担軽減情報.get軽減率_分子() != null) {
            builder.set軽減率_分子(社会福祉法人等利用者負担軽減情報.get軽減率_分子());
        }
        if (社会福祉法人等利用者負担軽減情報.get軽減率_分母() != null) {
            builder.set軽減率_分母(社会福祉法人等利用者負担軽減情報.get軽減率_分母());
        }
        builder.set生保扶助見直し特例有無(社会福祉法人等利用者負担軽減情報.is生保扶助見直し特例有無());
        builder.set居宅サービス限定(社会福祉法人等利用者負担軽減情報.is居宅サービス限定());
        builder.set居住費_食費のみ(社会福祉法人等利用者負担軽減情報.is居住費_食費のみ());
        builder.set旧措置者ユニット型個室のみ(社会福祉法人等利用者負担軽減情報.is旧措置者ユニット型個室のみ());
        builder.set確認番号(社会福祉法人等利用者負担軽減情報.get確認番号());
        builder.set非承認理由(社会福祉法人等利用者負担軽減情報.get非承認理由());
        builder.set生活保護受給有無(社会福祉法人等利用者負担軽減情報.is生活保護受給有無());
        builder.set老齢福祉年金受給有無(社会福祉法人等利用者負担軽減情報.is老齢福祉年金受給有無());
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 社会福祉法人等利用者負担軽減情報.getGemmenGengakuShinseiList();
        for (GemmenGengakuShinsei gemmenGengakuShinsei : gemmenGengakuShinseiList) {
            builder.setGemmenGengakuShinsei(get減免減額申請ByChange履歴番号(gemmenGengakuShinsei, 履歴番号));
        }
        return builder.build();
    }

    private void 削除処理(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報) {
        ShakaiFukushiHojinRiyoshaFutanKeigenManager 社会福祉法人等利用者負担軽減Manager = new ShakaiFukushiHojinRiyoshaFutanKeigenManager();
        GemmenGengakuShinseiManager 減免減額申請Manager = new GemmenGengakuShinseiManager();
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 社会福祉法人等利用者負担軽減情報.getGemmenGengakuShinseiList();
        for (GemmenGengakuShinsei gemmenGengakuShinsei : gemmenGengakuShinseiList) {
            減免減額申請Manager.delete減免減額申請(gemmenGengakuShinsei);
        }
        社会福祉法人等利用者負担軽減Manager.delete社会福祉法人等利用者負担軽減(
                new ShakaiFukushiHojinRiyoshaFutanKeigen(社会福祉法人等利用者負担軽減情報.toEntity()));
    }

    private void 修正処理(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報) {
        ArrayList<ShakaifukuRiyoshaFutanKeigen> 最初申請一覧情報 = ViewStateHolder.get(DBD1030001ViewStateKey.申請一覧情報, ArrayList.class);
        for (ShakaifukuRiyoshaFutanKeigen 最初申請情報 : 最初申請一覧情報) {
            if (最初申請情報.identifier().equals(社会福祉法人等利用者負担軽減情報.identifier())) {
                削除処理(最初申請情報);
            }
        }
        追加処理(社会福祉法人等利用者負担軽減情報);
    }

    private void 追加処理(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報) {
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 社会福祉法人等利用者負担軽減情報.getGemmenGengakuShinseiList();
        ShakaiFukushiHojinRiyoshaFutanKeigenManager 社会福祉法人等利用者負担軽減Manager = new ShakaiFukushiHojinRiyoshaFutanKeigenManager();
        GemmenGengakuShinseiManager 減免減額申請Manager = new GemmenGengakuShinseiManager();
        for (GemmenGengakuShinsei gemmenGengakuShinsei : gemmenGengakuShinseiList) {
            減免減額申請Manager.save減免減額申請(gemmenGengakuShinsei);
        }
        //TODO QA #82161 減免区分.ｺｰﾄﾞ
        ShakaifukuRiyoshaFutanKeigenBuilder builder = 社会福祉法人等利用者負担軽減情報.createBuilderForEdit();
        builder.set減免区分(new RString("10"));
        社会福祉法人等利用者負担軽減Manager.save社会福祉法人等利用者負担軽減(
                new ShakaiFukushiHojinRiyoshaFutanKeigen(builder.build().toEntity()));
    }

    /**
     * 変更有無チェックです。
     *
     */
    public void 変更有無チェック() {
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        if (情報と状態ArrayList.isEmpty() || isすべての状態列が空(情報と状態ArrayList)) {
            throw new ApplicationException(DbzInformationMessages.内容変更なしで保存不可.getMessage());
        }
    }

    private boolean isすべての状態列が空(ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態ArrayList) {
            RString 状態 = 情報と状態.get状態();
            if (状態 != null && !状態.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 相関チェック２です。
     *
     */
    public void 相関チェック２() {
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList
                = ViewStateHolder.get(DBD1030001ViewStateKey.申請一覧情報と状態, ArrayList.class);
        if (is減免減額_適用期間重複(情報と状態ArrayList)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_適用期間重複.getMessage());
        }
        for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態ArrayList) {
            ShakaifukuRiyoshaFutanKeigen 情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
            if (状態_追加.equals(情報と状態.get状態()) && ShakaiFukushiHojinKeigenService.createIntance()
                    .exsits確認番号In同一年度(情報.get確認番号(), 情報.get適用開始年月日())) {
                throw new ApplicationException(DbdErrorMessages.減免減額_確認番号が既に存在.getMessage());
            }
        }
    }

    private boolean is減免減額_適用期間重複(ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        int length = 情報と状態ArrayList.size();
        if (length < 2) {
            return false;
        }
        for (int index = 0; index <= length - 2; index++) {
            int index2 = index + 1;
            while (index2 <= length - 1) {
                ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 = 情報と状態ArrayList.get(index);
                ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態2 = 情報と状態ArrayList.get(index2);
                ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
                ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報2 = 情報と状態2.get社会福祉法人等利用者負担軽減情報();
                if (!社会福祉法人等利用者負担軽減情報.get適用終了年月日().isBeforeOrEquals(社会福祉法人等利用者負担軽減情報2.get適用開始年月日())
                        && !社会福祉法人等利用者負担軽減情報2.get適用終了年月日().isBeforeOrEquals(社会福祉法人等利用者負担軽減情報.get適用終了年月日())) {
                    return true;
                }
                index2++;
            }
        }
        return false;
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「決定区分」を押下する。
     *
     */
    public void onClick_radKetteiKubun() {
        RString selectKey = div.getRadKetteiKubun().getSelectedKey();
        if (KEY0.equals(selectKey)) {
            div.getBtnSelectHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
            div.getDdlKeigenJiyu().setDisabled(false);
            div.getTxtKeigenRitsuBunshi().setDisabled(false);
            div.getTxtKeigenRitsuBunbo().setDisabled(false);
            div.getChkTokureiTaisho().setDisabled(false);
            div.getChkKyotakuServiceGentei().setDisabled(false);
            div.getChkKyojuhiShokuhiGentei().setDisabled(false);
            div.getChkKyusochiUnitGataJunKoshitsu().setDisabled(false);
            div.getTxtKakuninNo().setDisabled(false);
        } else if (KEY1.equals(selectKey)) {
            div.getBtnSelectHiShoninRiyu().setDisabled(false);
            div.getTxtHiShoninRiyu().setDisabled(false);
            div.getDdlKeigenJiyu().setDisabled(true);
            div.getChkTokureiTaisho().setDisabled(true);
            div.getChkKyotakuServiceGentei().setDisabled(true);
            div.getChkKyojuhiShokuhiGentei().setDisabled(true);
            div.getChkKyusochiUnitGataJunKoshitsu().setDisabled(true);
            div.getTxtKakuninNo().setDisabled(true);
        }
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を適用日入力する。
     *
     */
    public void onClick_onBlur() {
        FlexibleDate 適用日 = div.getTxtTekiyoYMD().getValue();
        if (null == 適用日) {
            適用日 = FlexibleDate.EMPTY;
        }
        FlexibleDate 有効期限 = ShakaiFukushiHojinKeigenService.createIntance().estimate有効期限(適用日);
        div.getTxtYukoKigenYMD().setValue(有効期限);
    }

    /**
     * 引数定義<br/>
     *
     */
    public enum DBD1030001ViewStateKey {

        /**
         * 申請一覧情報です。
         */
        申請一覧情報,
        /**
         * 申請一覧情報と状態です。
         */
        申請一覧情報と状態,
        /**
         * 編集社会福祉法人等利用者負担軽減申請の情報です。
         */
        編集社会福祉法人等利用者負担軽減申請の情報,
        /**
         * 追加履歴番号です。
         */
        追加履歴番号;
    }

}
