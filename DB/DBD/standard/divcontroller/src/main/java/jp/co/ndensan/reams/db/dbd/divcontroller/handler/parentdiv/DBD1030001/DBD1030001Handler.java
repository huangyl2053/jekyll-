/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigenBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigenIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shakaifukushihojinkeigen.ShakaifukuRiyoshaFutanKeigenToJotai;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shakaifukushihojinkeigen.GemmenKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001Div;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenManager;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenService;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;

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
    private final RString 漢字承認する = new RString("承認する");
    private final RString 漢字承認しない = new RString("承認しない");
    private final RString 承認情報 = new RString("承認情報");
    private static final RString 申請メニューID = new RString("DBDMN21004");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString NAME_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final Decimal DECIMAL_25 = new Decimal("25.0");
    private static final Decimal DECIMAL_100 = new Decimal("100");

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
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 申請一覧情報 申請一覧情報
     * @return 情報と状態ArrayList
     */
    public ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> onLoad(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号, List<ShakaifukuRiyoshaFutanKeigen> 申請一覧情報) {
        div.getShafukuRiyoshaKeigen().getCcdAtenaInfo().initialize(識別コード);
        div.getShafukuRiyoshaKeigen().getCcdShikakuKihon().initialize(被保険者番号);
        div.getShafukuRiyoshaKeigen().setHihokenshaNo(被保険者番号.getColumnValue());
        RString メニューID = ResponseHolder.getMenuID();
        if (申請メニューID.equals(メニューID)) {
            div.getBtnAddShinsei().setText(申請情報を追加する);
            div.getBtnShoninKakutei().setDisplayNone(true);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(保存する, "申請情報を");
        } else {
            div.getBtnAddShinsei().setText(承認情報を追加する);
            div.getShafukuRiyoshaKeigen().getShinseiDetail().setTitle(承認情報);
            div.getBtnShinseiKakutei().setDisplayNone(true);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(保存する, "承認情報を");
        }
        List<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態List = 情報と状態初期化(申請一覧情報);
        List<dgShinseiList_Row> dataSourceList = getDataSource(情報と状態List);
        div.getDgShinseiList().setDataSource(dataSourceList);
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList = new ArrayList<>(情報と状態List);
        入力パネルをClose状態表示か(true);
        div.getShafukuRiyoshaKeigen().getBtnCloseSetaiJoho().setDisplayNone(true);
        PersonalData personalData = PersonalData.of(識別コード, new ExpandedInformation(CODE_0003, NAME_被保険者番号, 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.照会, personalData);
        RealInitialLocker.lock(new LockingKey(new RString("DB").concat(被保険者番号.getColumnValue().concat("ShafukuKeigen"))));
        List<dgShinseiList_Row> rows = div.getDgShinseiList().getDataSource();
        for (dgShinseiList_Row row : rows) {
            if (row.getKetteiKubun() == null || row.getKetteiKubun().isEmpty()) {
                div.getBtnAddShinsei().setDisabled(true);
            } else {
                if (申請メニューID.equals(ResponseHolder.getMenuID())) {
                    row.setModifyButtonState((DataGridButtonState.Disabled));
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                    row.setSelectable(Boolean.FALSE);
                }
            }
        }
        return 情報と状態ArrayList;
    }

    private void 入力パネルをClose状態表示か(boolean isClose状態) {
        div.getTxtShinseiYMD().setDisabled(isClose状態);
        div.getTxtShinseiRiyu().setDisabled(isClose状態);
        div.getCcdShinseiJoho().setDisabled(isClose状態);
        div.getShoninJoho().setDisabled(isClose状態);
        div.getBtnBackToShinseiList().setDisabled(isClose状態);
        div.getBtnShinseiKakutei().setDisabled(isClose状態);
        div.getBtnShoninKakutei().setDisabled(isClose状態);
    }

    private void 一覧パネルをClose状態表示か(boolean isClose状態) {
        div.getBtnAddShinsei().setDisabled(isClose状態);
        div.getDgShinseiList().setDisabled(isClose状態);
    }

    /**
     * 世帯所得一覧の初期化処理です。
     *
     * @param 識別コード 識別コード
     */
    public void 世帯所得一覧の初期化(ShikibetsuCode 識別コード) {
        YMDHMS 現在年月日日時時分秒 = YMDHMS.now();
        div.getCcdSetaiShotokuIchiran().initialize(
                識別コード,
                new FlexibleDate(現在年月日日時時分秒.getDate().toDateString()),
                new HizukeConfig().get所得年度(),
                現在年月日日時時分秒);
    }

    /**
     * 申請一覧データ取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請一覧情報
     */
    public List<ShakaifukuRiyoshaFutanKeigen> 申請一覧データ準備(HihokenshaNo 被保険者番号) {
        return ShakaiFukushiHojinKeigenService.createIntance().load社会福祉法人等利用者負担軽減申請All(被保険者番号);
    }

    private List<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態初期化(List<ShakaifukuRiyoshaFutanKeigen> 申請一覧情報) {
        List<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態List = new ArrayList<>();
        for (ShakaifukuRiyoshaFutanKeigen 情報 : 申請一覧情報) {
            ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 = new ShakaifukuRiyoshaFutanKeigenToJotai(情報, RString.EMPTY, 情報.get履歴番号());
            情報と状態List.add(情報と状態);
        }
        return 情報と状態List;
    }

    /**
     * 申請一覧データからDataSource取得処理です。
     *
     * @param 情報と状態List 情報と状態List
     * @return DataSource
     */
    public List<dgShinseiList_Row> getDataSource(List<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態List) {
        List<dgShinseiList_Row> dataSourceList = new ArrayList<>();
        for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態List) {
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報 = 情報と状態.get社会福祉法人等利用者負担軽減情報();
            dgShinseiList_Row dataSource = new dgShinseiList_Row();
            dataSource.setJotai(情報と状態.get状態());
            TextBoxFlexibleDate 申請年月日 = new TextBoxFlexibleDate();
            申請年月日.setValue(社会福祉法人等利用者負担軽減情報.get申請年月日());
            dataSource.setTxtShinseiYMD(申請年月日);
            dataSource.setShinseiRiyu(社会福祉法人等利用者負担軽減情報.get申請事由());
            RString 決定区分 = get決定区分(社会福祉法人等利用者負担軽減情報.get決定区分());
            dataSource.setKetteiKubun(決定区分);
            TextBoxFlexibleDate 決定年月日 = new TextBoxFlexibleDate();
            決定年月日.setValue(社会福祉法人等利用者負担軽減情報.get決定年月日());
            dataSource.setTxtKetteiYMD(決定年月日);
            if (漢字承認する.equals(決定区分)) {
                setDataSource(dataSource, 社会福祉法人等利用者負担軽減情報);
            } else {
                dataSource.setTxtKetteiYMD(決定年月日);
                TextBoxFlexibleDate 適用開始年月日 = new TextBoxFlexibleDate();
                適用開始年月日.setValue(FlexibleDate.EMPTY);
                dataSource.setTxtTekiyoYMD(適用開始年月日);
                TextBoxFlexibleDate 適用終了年月日 = new TextBoxFlexibleDate();
                適用終了年月日.setValue(FlexibleDate.EMPTY);
                dataSource.setTxtYukoKigenYMD(適用終了年月日);
                dataSource.setShoninShinaiRiyu(社会福祉法人等利用者負担軽減情報.get非承認理由());
                dataSource.setKeigenJiyu(RString.EMPTY);
                dataSource.setKyotakuServiceGentei(RString.EMPTY);
                dataSource.setKojuhiShokuhiGentei(RString.EMPTY);
                dataSource.setKyusochiUnitGataKoshitsuGentei(RString.EMPTY);
                dataSource.setKakuninNo(RString.EMPTY);
            }
            dataSource.setDataId(DataPassingConverter.serialize(社会福祉法人等利用者負担軽減情報.identifier()));
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private void setDataSource(dgShinseiList_Row dataSource, ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報) {
        if (社会福祉法人等利用者負担軽減情報.get軽減率_分子() != null
            && 社会福祉法人等利用者負担軽減情報.get軽減率_分母() != null
            && 社会福祉法人等利用者負担軽減情報.get軽減率_分母().compareTo(Decimal.ZERO) != 0) {
            dataSource.setKeigenRitsu(new RString(社会福祉法人等利用者負担軽減情報.get軽減率_分子().toString())
                    .concat("/").concat(社会福祉法人等利用者負担軽減情報.get軽減率_分母().toString()));
        }
        TextBoxFlexibleDate 適用開始年月日 = new TextBoxFlexibleDate();
        適用開始年月日.setValue(社会福祉法人等利用者負担軽減情報.get適用開始年月日());
        dataSource.setTxtTekiyoYMD(適用開始年月日);
        TextBoxFlexibleDate 適用終了年月日 = new TextBoxFlexibleDate();
        適用終了年月日.setValue(社会福祉法人等利用者負担軽減情報.get適用終了年月日());
        dataSource.setTxtYukoKigenYMD(適用終了年月日);
        if (社会福祉法人等利用者負担軽減情報.get減免区分() != null && !社会福祉法人等利用者負担軽減情報.get減免区分().isEmpty()) {
            dataSource.setKeigenJiyu(GemmenKubun.toValue(社会福祉法人等利用者負担軽減情報.get減免区分()).get名称());
        } else {
            dataSource.setKeigenJiyu(RString.EMPTY);
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
        dataSource.setKakuninNo(社会福祉法人等利用者負担軽減情報.get確認番号());
        dataSource.setShoninShinaiRiyu(RString.EMPTY);
    }

    private RString get決定区分(RString 決定区分) {
        if (null == 決定区分) {
            return RString.EMPTY;
        }
        if (承認する.equals(決定区分)) {
            return 漢字承認する;
        } else if (承認しない.equals(決定区分)) {
            return 漢字承認しない;
        }
        return RString.EMPTY;
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を追加する」（また「承認情報を追加する」）を押下する。
     *
     * @param 識別コード 識別コード
     */
    public void onClick_btnAddShinsei(ShikibetsuCode 識別コード) {
        一覧パネルをClose状態表示か(true);
        入力パネルをClose状態表示か(false);
        if (申請情報を追加する.equals(div.getBtnAddShinsei().getText())) {
            状態２画面表示();
        } else if (承認情報を追加する.equals(div.getBtnAddShinsei().getText())) {
            状態５画面表示(識別コード);
        }
    }

    private void 状態５画面表示(ShikibetsuCode 識別コード) {
        div.getTxtShinseiRiyu().setDisabled(false);
        div.getTxtShinseiYMD().setDisabled(false);
        div.getTxtShinseiYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtShinseiRiyu().setValue(RString.EMPTY);
        div.getRadKetteiKubun().setSelectedKey(KEY0);
        div.getTxtTekiyoYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtYukoKigenYMD().setValue(FlexibleDate.EMPTY);
        GemmenKubun 減免区分初期値 = get減免区分初期値(識別コード);
        div.getDdlKeigenJiyu().setSelectedKey(減免区分初期値.getコード());
        div.getTxtKetteiYMD().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
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

    private GemmenKubun get減免区分初期値(ShikibetsuCode 識別コード) {
        FlexibleDate 申請日 = div.getTxtShinseiYMD().getValue();
        if (null == 申請日 || 申請日.isEmpty()) {
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
        div.getDdlKeigenJiyu().setSelectedKey(RString.EMPTY);
        div.getTxtKetteiYMD().setValue(FlexibleDate.EMPTY);
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
        div.getShafukuRiyoshaKeigen().getBtnShowSetaiJoho().setDisabled(false);
        div.getShafukuRiyoshaKeigen().getBtnShowGenmenJoho().setDisabled(false);
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
     * DataSouce情報取得処理する。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @return 情報と状態
     */
    public ShakaifukuRiyoshaFutanKeigenToJotai get情報と状態BySelectDataSouce(ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        dgShinseiList_Row dataSouce = div.getDgShinseiList().getActiveRow();
        return get情報FromDataSouce(dataSouce, 情報と状態ArrayList);
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧の修正ボタン」を押下する。
     *
     * @param 識別コード 識別コード
     * @param 情報と状態 情報と状態
     */
    public void onClick_onSelectByModifyButton(ShikibetsuCode 識別コード, ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態) {
        一覧パネルをClose状態表示か(true);
        入力パネルをClose状態表示か(false);
        dgShinseiList_Row dataSouce = div.getDgShinseiList().getActiveRow();
        if (申請情報を追加する.equals(div.getBtnAddShinsei().getText())) {
            状態３画面表示(dataSouce, 情報と状態, 識別コード);
        } else if (承認情報を追加する.equals(div.getBtnAddShinsei().getText())) {
            状態６画面表示(dataSouce, 情報と状態, 識別コード);
        }
    }

    private ShakaifukuRiyoshaFutanKeigenToJotai get情報FromDataSouce(
            dgShinseiList_Row dataSouce, ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        ShakaifukuRiyoshaFutanKeigenIdentifier id
                = DataPassingConverter.deserialize(dataSouce.getDataId(), ShakaifukuRiyoshaFutanKeigenIdentifier.class);
        for (ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 : 情報と状態ArrayList) {
            if (id.equals(情報と状態.get社会福祉法人等利用者負担軽減情報().identifier())) {
                return 情報と状態;
            }
        }
        return null;
    }

    private void 状態６画面表示(dgShinseiList_Row dataSouce, ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態, ShikibetsuCode 識別コード) {
        div.getCcdShinseiJoho().set減免減額申請情報(getShinseiJoho(情報と状態), dataSouce.getTxtShinseiYMD().getValue());
        承認情報エリア画面表示(dataSouce, 識別コード);
        RString 状態 = 情報と状態.get状態();
        if (状態_追加.equals(状態)) {
            div.getTxtShinseiYMD().setDisabled(false);
            div.getTxtShinseiRiyu().setDisabled(false);
        } else {
            div.getTxtShinseiYMD().setDisabled(true);
            div.getTxtShinseiRiyu().setDisabled(true);
        }
        div.getShafukuRiyoshaKeigen().getBtnShowSetaiJoho().setDisabled(false);
        div.getShafukuRiyoshaKeigen().getBtnShowGenmenJoho().setDisabled(false);
        div.getBtnBackToShinseiList().setDisabled(false);
        div.getBtnShoninKakutei().setDisplayNone(false);
        div.getBtnShinseiKakutei().setDisplayNone(true);
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
        if (gemmenGengakuShinsei.get申請届出代行区分() != null && !gemmenGengakuShinsei.get申請届出代行区分().isEmpty()) {
            申請届出代行区分 = ShinseiTodokedeDaikoKubunCode.toValue(gemmenGengakuShinsei.get申請届出代行区分());
        }
        JigyoshaKubun 事業者区分 = null;
        if (gemmenGengakuShinsei.get事業者区分() != null && !gemmenGengakuShinsei.get事業者区分().isEmpty()) {
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

    private void 状態３画面表示(dgShinseiList_Row dataSouce, ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態, ShikibetsuCode 識別コード) {
        div.getCcdShinseiJoho().set減免減額申請情報(getShinseiJoho(情報と状態), dataSouce.getTxtShinseiYMD().getValue());
        承認情報エリア画面表示(dataSouce, 識別コード);
        状態３制御();
    }

    private void 状態３制御() {
        div.getShafukuRiyoshaKeigen().getBtnShowSetaiJoho().setDisabled(false);
        div.getShafukuRiyoshaKeigen().getBtnShowGenmenJoho().setDisabled(false);
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
        div.getBtnSelectHiShoninRiyu().setDisabled(true);
        div.getTxtHiShoninRiyu().setDisabled(true);
        div.getBtnBackToShinseiList().setDisabled(false);
        div.getBtnShoninKakutei().setDisplayNone(true);
        div.getBtnShinseiKakutei().setDisplayNone(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(再検索する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧へ, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
    }

    private void 承認情報エリア画面表示(dgShinseiList_Row dataSouce, ShikibetsuCode 識別コード) {
        div.getTxtShinseiYMD().setValue(dataSouce.getTxtShinseiYMD().getValue());
        div.getTxtShinseiRiyu().setValue(dataSouce.getShinseiRiyu());
        if (漢字承認する.equals(dataSouce.getKetteiKubun())) {
            div.getRadKetteiKubun().setSelectedKey(KEY0);
            div.getTxtTekiyoYMD().setDisabled(false);
            div.getTxtYukoKigenYMD().setDisabled(false);
            div.getDdlKeigenJiyu().setDisabled(false);
            div.getTxtKeigenRitsuBunshi().setDisabled(false);
            div.getTxtKeigenRitsuBunbo().setDisabled(false);
            div.getChkTokureiTaisho().setDisabled(false);
            div.getChkKyotakuServiceGentei().setDisabled(false);
            div.getChkKyojuhiShokuhiGentei().setDisabled(false);
            div.getChkKyusochiUnitGataJunKoshitsu().setDisabled(false);
            div.getTxtKakuninNo().setDisabled(false);
            div.getBtnSelectHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
        } else if (漢字承認しない.equals(dataSouce.getKetteiKubun())) {
            div.getRadKetteiKubun().setSelectedKey(KEY1);
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
            div.getBtnSelectHiShoninRiyu().setDisabled(false);
            div.getTxtHiShoninRiyu().setDisabled(false);
        } else {
            if (!申請メニューID.equals(ResponseHolder.getMenuID())) {
                div.getDdlKeigenJiyu().setDisabled(false);
                div.getTxtKeigenRitsuBunshi().setDisabled(false);
                div.getTxtKeigenRitsuBunbo().setDisabled(false);
                div.getChkTokureiTaisho().setDisabled(false);
                div.getChkKyotakuServiceGentei().setDisabled(false);
                div.getChkKyojuhiShokuhiGentei().setDisabled(false);
                div.getChkKyusochiUnitGataJunKoshitsu().setDisabled(false);
                div.getTxtKakuninNo().setDisabled(false);
                div.getBtnSelectHiShoninRiyu().setDisabled(true);
                div.getTxtHiShoninRiyu().setDisabled(true);
                div.getRadKetteiKubun().setSelectedKey(KEY0);
                div.getTxtTekiyoYMD().setValue(FlexibleDate.EMPTY);
                div.getTxtYukoKigenYMD().setValue(FlexibleDate.EMPTY);
                GemmenKubun 減免区分初期値 = get減免区分初期値(識別コード);
                div.getDdlKeigenJiyu().setSelectedKey(減免区分初期値.getコード());
                div.getTxtKetteiYMD().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
                div.getTxtKeigenRitsuBunshi().setValue(DECIMAL_25);
                div.getTxtKeigenRitsuBunbo().setValue(DECIMAL_100);
                List<RString> selectedKeys = new ArrayList<>();
                div.getChkTokureiTaisho().setSelectedItemsByKey(selectedKeys);
                div.getChkKyotakuServiceGentei().setSelectedItemsByKey(selectedKeys);
                div.getChkKyojuhiShokuhiGentei().setSelectedItemsByKey(selectedKeys);
                div.getChkKyusochiUnitGataJunKoshitsu().setSelectedItemsByKey(selectedKeys);
                return;
            }
        }
        div.getTxtKetteiYMD().setValue(dataSouce.getTxtKetteiYMD().getValue());
        div.getTxtTekiyoYMD().setValue(dataSouce.getTxtTekiyoYMD().getValue());
        div.getTxtYukoKigenYMD().setValue(dataSouce.getTxtYukoKigenYMD().getValue());
        if (dataSouce.getKeigenJiyu() != null) {
            div.getDdlKeigenJiyu().setSelectedValue(dataSouce.getKeigenJiyu());
        } else {
            div.getDdlKeigenJiyu().setSelectedKey(RString.EMPTY);
        }
        if (dataSouce.getKeigenRitsu() != null && !dataSouce.getKeigenRitsu().isEmpty()) {
            List<RString> 軽減率List = dataSouce.getKeigenRitsu().split("/");
            div.getTxtKeigenRitsuBunshi().setValue(new Decimal(軽減率List.get(0).toString()));
            div.getTxtKeigenRitsuBunbo().setValue(new Decimal(軽減率List.get(1).toString()));
        } else {
            div.getTxtKeigenRitsuBunshi().clearValue();
            div.getTxtKeigenRitsuBunbo().clearValue();
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
     * dataSourceの削除する。
     *
     * @param 削除DataSouce 削除DataSouce
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @return 情報と状態ArrayList
     */
    public ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> dataSourceの削除(dgShinseiList_Row 削除DataSouce,
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        ShakaifukuRiyoshaFutanKeigenIdentifier id
                = DataPassingConverter.deserialize(削除DataSouce.getDataId(), ShakaifukuRiyoshaFutanKeigenIdentifier.class);
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
        List<dgShinseiList_Row> newDataSouceList = getDataSource(情報と状態ArrayList);
        div.getDgShinseiList().setDataSource(newDataSouceList);
        return 情報と状態ArrayList;
    }

    /**
     * 元状態変更する。
     *
     * @param dataSouce dataSouce
     * @param 状態 状態
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @return new情報と状態ArrayList
     */
    public ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 元状態変更(dgShinseiList_Row dataSouce,
            RString 状態, ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        ShakaifukuRiyoshaFutanKeigenIdentifier id
                = DataPassingConverter.deserialize(dataSouce.getDataId(), ShakaifukuRiyoshaFutanKeigenIdentifier.class);
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
        List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
        div.getDgShinseiList().setDataSource(newDataSouceList);
        return new情報と状態ArrayList;
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を確定する」（また「承認情報を確定する」）を押下する。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @param 編集情報 編集情報
     * @param 追加履歴番号 追加履歴番号
     * @param 最初情報 最初情報
     * @param 被保険者番号 被保険者番号
     * @return new情報と状態ArrayList
     */
    public ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報を確定(
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList,
            ShakaifukuRiyoshaFutanKeigenToJotai 編集情報, Integer 追加履歴番号,
            ShakaifukuRiyoshaFutanKeigenToJotai 最初情報, HihokenshaNo 被保険者番号) {
        ShoKisaiHokenshaNo 証記載保険者番号;
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> new情報と状態ArrayList;
        if (null == 編集情報) {
            RString 決定区分 = RString.EMPTY;
            証記載保険者番号 = ShoKisaiHokenshaNo.EMPTY;
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報
                    = get社会福祉法人等利用者負担軽減申請の情報From画面(true, 0, 決定区分, 証記載保険者番号, 追加履歴番号, 被保険者番号);
            new情報と状態ArrayList = 追加社会福祉法人等利用者負担軽減申請の情報(画面社会福祉法人等利用者負担軽減申請情報, 情報と状態ArrayList);
        } else {
            RString 決定区分 = 編集情報.get社会福祉法人等利用者負担軽減情報().get決定区分();
            証記載保険者番号 = 編集情報.get社会福祉法人等利用者負担軽減情報().get証記載保険者番号();
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報
                    = get社会福祉法人等利用者負担軽減申請の情報From画面(
                            false, 編集情報.get社会福祉法人等利用者負担軽減情報().get履歴番号(), 決定区分, 証記載保険者番号, 追加履歴番号, 被保険者番号);
            new情報と状態ArrayList = 修正社会福祉法人等利用者負担軽減申請の情報(
                    画面社会福祉法人等利用者負担軽減申請情報, 情報と状態ArrayList, 編集情報, 最初情報);
        }
        情報エリアクリア();
        一覧パネルをClose状態表示か(false);
        入力パネルをClose状態表示か(true);
        return new情報と状態ArrayList;
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「情報エリア のデータをクリアする。
     *
     */
    public void 情報エリアクリア() {
        div.getTxtShinseiYMD().clearValue();
        div.getTxtShinseiRiyu().clearValue();
        div.getRadKetteiKubun().clearSelectedItem();
        div.getTxtKetteiYMD().clearValue();
        div.getTxtTekiyoYMD().clearValue();
        div.getTxtYukoKigenYMD().clearValue();
        div.getTxtKeigenRitsuBunshi().clearValue();
        List<RString> selectedKeys = new ArrayList<>();
        div.getChkTokureiTaisho().setSelectedItemsByKey(selectedKeys);
        div.getChkKyotakuServiceGentei().setSelectedItemsByKey(selectedKeys);
        div.getChkKyojuhiShokuhiGentei().setSelectedItemsByKey(selectedKeys);
        div.getChkKyusochiUnitGataJunKoshitsu().setSelectedItemsByKey(selectedKeys);
        div.getTxtKakuninNo().clearValue();
        div.getTxtHiShoninRiyu().clearValue();
        ShinseiJoho shinseiJoho = new ShinseiJoho(null, AtenaMeisho.EMPTY, AtenaKanaMeisho.EMPTY,
                RString.EMPTY, JigyoshaNo.EMPTY, null, YubinNo.EMPTY, AtenaJusho.EMPTY, TelNo.EMPTY);
        div.getCcdShinseiJoho().set減免減額申請情報(shinseiJoho, FlexibleDate.EMPTY);
        一覧パネルをClose状態表示か(false);
        入力パネルをClose状態表示か(true);
    }

    private ShakaifukuRiyoshaFutanKeigen get社会福祉法人等利用者負担軽減申請の情報From画面(
            boolean is新規, int 履歴番号, RString 決定区分, ShoKisaiHokenshaNo 証記載保険者番号, Integer 追加履歴番号, HihokenshaNo 被保険者番号) {
        if (is新規 && (null == 追加履歴番号 || 追加履歴番号 == 0)) {
            追加履歴番号 = -1;
        } else {
            追加履歴番号 = 履歴番号;
        }
        RString メニューID = ResponseHolder.getMenuID();
        if (証記載保険者番号.isEmpty()) {
            証記載保険者番号 = get証記載保険者番号();
        }
        ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減申請の情報
                = new ShakaifukuRiyoshaFutanKeigen(証記載保険者番号, 被保険者番号, 追加履歴番号);
        ShakaifukuRiyoshaFutanKeigenBuilder builder = 社会福祉法人等利用者負担軽減申請の情報.createBuilderForEdit();
        builder.set申請年月日(div.getTxtShinseiYMD().getValue());
        builder.set申請事由(div.getTxtShinseiRiyu().getValue());
        if (!申請メニューID.equals(メニューID)) {
            builder.set決定区分(get決定区分From画面());
        } else if (決定区分 != null && !決定区分.isEmpty()) {
            builder.set決定区分(決定区分);
        }
        builder.set決定年月日(div.getTxtKetteiYMD().getValue());
        builder.set適用開始年月日(div.getTxtTekiyoYMD().getValue());
        builder.set適用終了年月日(div.getTxtYukoKigenYMD().getValue());
        builder.set減免区分(div.getDdlKeigenJiyu().getSelectedKey());
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
        GemmenGengakuShinsei 減免減額申請 = get減免減額申請From画面(証記載保険者番号, 追加履歴番号, 被保険者番号);
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

    private GemmenGengakuShinsei get減免減額申請From画面(ShoKisaiHokenshaNo 証記載保険者番号, Integer 追加履歴番号, HihokenshaNo 被保険者番号) {
        GemmenGengakuShinsei 減免減額申請 = new GemmenGengakuShinsei(証記載保険者番号,
                被保険者番号, GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード(), 追加履歴番号);
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

    private ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 修正社会福祉法人等利用者負担軽減申請の情報(ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報,
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList, ShakaifukuRiyoshaFutanKeigenToJotai 編集情報,
            ShakaifukuRiyoshaFutanKeigenToJotai 最初情報) {
        ShakaifukuRiyoshaFutanKeigenToJotai 修正後社会福祉法人等利用者負担軽減申請情報
                = get修正後社会福祉法人等利用者負担軽減申請情報(画面社会福祉法人等利用者負担軽減申請情報, 最初情報);
        return 修正情報と状態(修正後社会福祉法人等利用者負担軽減申請情報, 編集情報, 情報と状態ArrayList);
    }

    private ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 修正情報と状態(ShakaifukuRiyoshaFutanKeigenToJotai 修正後社会福祉法人等利用者負担軽減申請情報,
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
            List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
            div.getDgShinseiList().setDataSource(newDataSouceList);
            return new情報と状態ArrayList;
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
            List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
            div.getDgShinseiList().setDataSource(newDataSouceList);
            return new情報と状態ArrayList;
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
        List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
        div.getDgShinseiList().setDataSource(newDataSouceList);
        return new情報と状態ArrayList;
    }

    private ShakaifukuRiyoshaFutanKeigenToJotai get修正後社会福祉法人等利用者負担軽減申請情報(
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報, ShakaifukuRiyoshaFutanKeigenToJotai 編集情報) {
        ShakaifukuRiyoshaFutanKeigen 情報 = 編集情報.get社会福祉法人等利用者負担軽減情報();
        ShakaifukuRiyoshaFutanKeigenBuilder builder = 情報.createBuilderForEdit();
        boolean 変更ある = 軽減率_分母_分子Builder(builder, 画面社会福祉法人等利用者負担軽減申請情報, 情報);
        boolean is承認しない = false;
        if (null == 情報.get決定区分()) {
            if (画面社会福祉法人等利用者負担軽減申請情報.get決定区分() != null && !画面社会福祉法人等利用者負担軽減申請情報.get決定区分().isEmpty()) {
                builder.set決定区分(画面社会福祉法人等利用者負担軽減申請情報.get決定区分());
                変更ある = true;
            }
        } else if (!情報.get決定区分().equals(画面社会福祉法人等利用者負担軽減申請情報.get決定区分())) {
            builder.set決定区分(画面社会福祉法人等利用者負担軽減申請情報.get決定区分());
            変更ある = true;
        } else {
            builder.set決定区分(情報.get決定区分());
            if (承認しない.equals(画面社会福祉法人等利用者負担軽減申請情報.get決定区分())) {
                is承認しない = true;
            }
        }
        if (!is承認しない) {
            変更ある = set修正後社会福祉法人等利用者負担軽減申請情報(builder, 変更ある, 画面社会福祉法人等利用者負担軽減申請情報, 情報);
            if (set修正後社会福祉法人等利用者負担軽減申請情報By承認する(builder, 画面社会福祉法人等利用者負担軽減申請情報, 情報)) {
                変更ある = true;
            }
        } else {
            if (null == 情報.get非承認理由()) {
                if (画面社会福祉法人等利用者負担軽減申請情報.get非承認理由() != null
                    && !画面社会福祉法人等利用者負担軽減申請情報.get非承認理由().isEmpty()) {
                    builder.set非承認理由(画面社会福祉法人等利用者負担軽減申請情報.get非承認理由());
                    変更ある = true;
                }
            } else if (!情報.get非承認理由().equals(画面社会福祉法人等利用者負担軽減申請情報.get非承認理由())) {
                builder.set非承認理由(画面社会福祉法人等利用者負担軽減申請情報.get非承認理由());
                変更ある = true;
            }
        }
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 画面社会福祉法人等利用者負担軽減申請情報.getGemmenGengakuShinseiList();
        GemmenGengakuShinsei 減免減額申請;
        if (!情報.getGemmenGengakuShinseiList().isEmpty()) {
            減免減額申請 = 情報.getGemmenGengakuShinseiList().get(0);
        } else {
            減免減額申請 = new GemmenGengakuShinsei(get証記載保険者番号(),
                    情報.get被保険者番号(), GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード(), 情報.get履歴番号());
        }
        GemmenGengakuShinsei 画面減免減額申請 = gemmenGengakuShinseiList.get(0);
        GemmenGengakuShinseiBuilder 減免減額申請Builder = 画面減免減額申請.createBuilderForEdit();
        boolean 減免減額申請変更 = 減免減額申請変更(減免減額申請, 画面減免減額申請);
        if (減免減額申請変更) {
            set修正後社会福祉法人等利用者負担軽減申請情報_減免減額申請(画面減免減額申請, 減免減額申請Builder);
            builder.setGemmenGengakuShinsei(減免減額申請Builder.build());
            変更ある = 減免減額申請変更;
        }
        RString 編集前状態 = 編集情報.get状態();
        ShakaifukuRiyoshaFutanKeigen 編集後情報 = builder.build();
        return get編集後情報と状態By編集後情報(編集後情報, 変更ある, 編集前状態);
    }

    private boolean set修正後社会福祉法人等利用者負担軽減申請情報By承認する(ShakaifukuRiyoshaFutanKeigenBuilder builder,
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報, ShakaifukuRiyoshaFutanKeigen 情報) {
        boolean 変更ある = false;
        if (null == 情報.get適用終了年月日()) {
            if (画面社会福祉法人等利用者負担軽減申請情報.get適用終了年月日() != null
                && !画面社会福祉法人等利用者負担軽減申請情報.get適用終了年月日().isEmpty()) {
                builder.set適用終了年月日(画面社会福祉法人等利用者負担軽減申請情報.get適用終了年月日());
                変更ある = true;
            }
        } else if (!情報.get適用終了年月日().equals(画面社会福祉法人等利用者負担軽減申請情報.get適用終了年月日())) {
            builder.set適用終了年月日(画面社会福祉法人等利用者負担軽減申請情報.get適用終了年月日());
            変更ある = true;
        }
        if (null == 情報.get適用開始年月日()) {
            if (画面社会福祉法人等利用者負担軽減申請情報.get適用開始年月日() != null
                && !画面社会福祉法人等利用者負担軽減申請情報.get適用開始年月日().isEmpty()) {
                builder.set適用開始年月日(画面社会福祉法人等利用者負担軽減申請情報.get適用開始年月日());
                変更ある = true;
            }
        } else if (!情報.get適用開始年月日().equals(画面社会福祉法人等利用者負担軽減申請情報.get適用開始年月日())) {
            builder.set適用開始年月日(画面社会福祉法人等利用者負担軽減申請情報.get適用開始年月日());
            変更ある = true;
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
        return 変更ある;
    }

    private boolean 減免減額申請変更(GemmenGengakuShinsei 減免減額申請, GemmenGengakuShinsei 画面減免減額申請) {
        if (null == 画面減免減額申請.get事業者区分() && 減免減額申請.get事業者区分() != null && !減免減額申請.get事業者区分().isEmpty()
            || (画面減免減額申請.get事業者区分() != null && !画面減免減額申請.get事業者区分().equals(減免減額申請.get事業者区分()))) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出代行事業者番号()
            && 減免減額申請.get申請届出代行事業者番号() != null && !減免減額申請.get申請届出代行事業者番号().isEmpty()
            || (画面減免減額申請.get申請届出代行事業者番号() != null
                && !画面減免減額申請.get申請届出代行事業者番号().equals(減免減額申請.get申請届出代行事業者番号()))) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出代行区分() && 減免減額申請.get申請届出代行区分() != null && !減免減額申請.get申請届出代行区分().isEmpty()
            || (画面減免減額申請.get申請届出代行区分() != null && !画面減免減額申請.get申請届出代行区分().equals(減免減額申請.get申請届出代行区分()))) {
            return true;
        }
        return 減免減額申請変更2(減免減額申請, 画面減免減額申請);
    }

    private boolean 減免減額申請変更2(GemmenGengakuShinsei 減免減額申請, GemmenGengakuShinsei 画面減免減額申請) {
        if (null == 画面減免減額申請.get申請届出者住所() && 減免減額申請.get申請届出者住所() != null && !減免減額申請.get申請届出者住所().isEmpty()
            || (画面減免減額申請.get申請届出者住所() != null && !画面減免減額申請.get申請届出者住所().equals(減免減額申請.get申請届出者住所()))) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出者氏名() && 減免減額申請.get申請届出者氏名() != null && !減免減額申請.get申請届出者氏名().isEmpty()
            || !画面減免減額申請.get申請届出者氏名().equals(減免減額申請.get申請届出者氏名())) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出者氏名カナ()
            && 減免減額申請.get申請届出者氏名カナ() != null && !減免減額申請.get申請届出者氏名カナ().isEmpty()
            || (画面減免減額申請.get申請届出者氏名カナ() != null
                && !画面減免減額申請.get申請届出者氏名カナ().equals(減免減額申請.get申請届出者氏名カナ()))) {
            return true;
        }
        return 減免減額申請変更3(減免減額申請, 画面減免減額申請);
    }

    private boolean 減免減額申請変更3(GemmenGengakuShinsei 減免減額申請, GemmenGengakuShinsei 画面減免減額申請) {
        if (null == 画面減免減額申請.get申請届出者続柄() && 減免減額申請.get申請届出者続柄() != null && !減免減額申請.get申請届出者続柄().isEmpty()
            || (画面減免減額申請.get申請届出者続柄() != null && !画面減免減額申請.get申請届出者続柄().equals(減免減額申請.get申請届出者続柄()))) {
            return true;
        }
        if (null == 画面減免減額申請.get申請届出者郵便番号()
            && 減免減額申請.get申請届出者郵便番号() != null && !減免減額申請.get申請届出者郵便番号().isEmpty()
            || (画面減免減額申請.get申請届出者郵便番号() != null
                && !画面減免減額申請.get申請届出者郵便番号().equals(減免減額申請.get申請届出者郵便番号()))) {
            return true;
        }
        return null == 画面減免減額申請.get申請届出者電話番号()
               && 減免減額申請.get申請届出者電話番号() != null && !減免減額申請.get申請届出者電話番号().isEmpty()
               || (画面減免減額申請.get申請届出者電話番号() != null
                   && !画面減免減額申請.get申請届出者電話番号().equals(減免減額申請.get申請届出者電話番号()));
    }

    private void set修正後社会福祉法人等利用者負担軽減申請情報_減免減額申請(
            GemmenGengakuShinsei gemmenGengakuShinsei, GemmenGengakuShinseiBuilder 減免減額申請Builder) {
        if (gemmenGengakuShinsei.get事業者区分() != null) {
            減免減額申請Builder.set事業者区分(gemmenGengakuShinsei.get事業者区分());
        }
        if (gemmenGengakuShinsei.get申請届出代行事業者番号() != null) {
            減免減額申請Builder.set申請届出代行事業者番号(gemmenGengakuShinsei.get申請届出代行事業者番号());
        }
        if (gemmenGengakuShinsei.get申請届出代行区分() != null) {
            減免減額申請Builder.set申請届出代行区分(gemmenGengakuShinsei.get申請届出代行区分());
        }
        if (gemmenGengakuShinsei.get申請届出者住所() != null) {
            減免減額申請Builder.set申請届出者住所(gemmenGengakuShinsei.get申請届出者住所());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名() != null) {
            減免減額申請Builder.set申請届出者氏名(gemmenGengakuShinsei.get申請届出者氏名());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名カナ() != null) {
            減免減額申請Builder.set申請届出者氏名カナ(gemmenGengakuShinsei.get申請届出者氏名カナ());
        }
        if (gemmenGengakuShinsei.get申請届出者続柄() != null) {
            減免減額申請Builder.set申請届出者続柄(gemmenGengakuShinsei.get申請届出者続柄());
        }
        if (gemmenGengakuShinsei.get申請届出者郵便番号() != null) {
            減免減額申請Builder.set申請届出者郵便番号(gemmenGengakuShinsei.get申請届出者郵便番号());
        }
        if (gemmenGengakuShinsei.get申請届出者電話番号() != null) {
            減免減額申請Builder.set申請届出者電話番号(gemmenGengakuShinsei.get申請届出者電話番号());
        }
    }

    private boolean set修正後社会福祉法人等利用者負担軽減申請情報(ShakaifukuRiyoshaFutanKeigenBuilder builder, boolean is変更ある,
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報, ShakaifukuRiyoshaFutanKeigen 情報) {
        boolean 変更ある = false;
        if (null == 情報.get決定年月日()) {
            if (画面社会福祉法人等利用者負担軽減申請情報.get決定年月日() != null && !画面社会福祉法人等利用者負担軽減申請情報.get決定年月日().isEmpty()) {
                builder.set決定年月日(画面社会福祉法人等利用者負担軽減申請情報.get決定年月日());
                変更ある = true;
            }
        } else if (!情報.get決定年月日().equals(画面社会福祉法人等利用者負担軽減申請情報.get決定年月日())) {
            builder.set決定年月日(画面社会福祉法人等利用者負担軽減申請情報.get決定年月日());
            変更ある = true;
        } else {
            builder.set決定年月日(情報.get決定年月日());
        }
        if (null == 情報.get減免区分()) {
            if (画面社会福祉法人等利用者負担軽減申請情報.get減免区分() != null && !画面社会福祉法人等利用者負担軽減申請情報.get減免区分().isEmpty()) {
                builder.set減免区分(画面社会福祉法人等利用者負担軽減申請情報.get減免区分());
                変更ある = true;
            }
        } else if (!情報.get減免区分().equals(画面社会福祉法人等利用者負担軽減申請情報.get減免区分())) {
            builder.set減免区分(画面社会福祉法人等利用者負担軽減申請情報.get減免区分());
            変更ある = true;
        } else {
            builder.set減免区分(情報.get減免区分());
        }
        if (set修正後社会福祉法人等利用者負担軽減申請情報2(builder, 画面社会福祉法人等利用者負担軽減申請情報, 情報)) {
            変更ある = true;
        }
        if (is変更ある) {
            return is変更ある;
        } else {
            return 変更ある;
        }
    }

    private boolean set修正後社会福祉法人等利用者負担軽減申請情報2(ShakaifukuRiyoshaFutanKeigenBuilder builder,
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報, ShakaifukuRiyoshaFutanKeigen 情報) {
        boolean 変更ある = false;
        if (null == 情報.get申請事由()) {
            if (画面社会福祉法人等利用者負担軽減申請情報.get申請事由() != null && !画面社会福祉法人等利用者負担軽減申請情報.get申請事由().isEmpty()) {
                builder.set申請事由(画面社会福祉法人等利用者負担軽減申請情報.get申請事由());
                変更ある = true;
            }
        } else if (!情報.get申請事由().equals(画面社会福祉法人等利用者負担軽減申請情報.get申請事由())) {
            builder.set申請事由(画面社会福祉法人等利用者負担軽減申請情報.get申請事由());
            変更ある = true;
        } else {
            builder.set申請事由(情報.get申請事由());
        }
        if (null == 情報.get申請年月日()) {
            if (画面社会福祉法人等利用者負担軽減申請情報.get申請年月日() != null && !画面社会福祉法人等利用者負担軽減申請情報.get申請年月日().isEmpty()) {
                builder.set申請年月日(画面社会福祉法人等利用者負担軽減申請情報.get申請年月日());
                変更ある = true;
            }
        } else if (!情報.get申請年月日().equals(画面社会福祉法人等利用者負担軽減申請情報.get申請年月日())) {
            builder.set申請年月日(画面社会福祉法人等利用者負担軽減申請情報.get申請年月日());
            変更ある = true;
        } else {
            builder.set申請年月日(情報.get申請年月日());
        }
        if (null == 情報.get確認番号()) {
            if (画面社会福祉法人等利用者負担軽減申請情報.get確認番号() != null && !画面社会福祉法人等利用者負担軽減申請情報.get確認番号().isEmpty()) {
                builder.set確認番号(画面社会福祉法人等利用者負担軽減申請情報.get確認番号());
                変更ある = true;
            }
        } else if (!情報.get確認番号().equals(画面社会福祉法人等利用者負担軽減申請情報.get確認番号())) {
            builder.set確認番号(画面社会福祉法人等利用者負担軽減申請情報.get確認番号());
            変更ある = true;
        } else {
            builder.set確認番号(情報.get確認番号());
        }
        return 変更ある;
    }

    private boolean 軽減率_分母_分子Builder(ShakaifukuRiyoshaFutanKeigenBuilder builder,
            ShakaifukuRiyoshaFutanKeigen 画面社会福祉法人等利用者負担軽減申請情報, ShakaifukuRiyoshaFutanKeigen 情報) {
        boolean 変更ある = false;
        if (null == 画面社会福祉法人等利用者負担軽減申請情報.get軽減率_分子()) {
            if (情報.get軽減率_分子() != null && 情報.get軽減率_分子().compareTo(Decimal.ZERO) != 0) {
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
            if (情報.get軽減率_分母() != null && 情報.get軽減率_分母().compareTo(Decimal.ZERO) != 0) {
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

    private ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 追加社会福祉法人等利用者負担軽減申請の情報(
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減申請情報,
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        FlexibleDate 申請日 = 社会福祉法人等利用者負担軽減申請情報.get申請年月日();
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> new情報と状態ArrayList = new ArrayList<>();
        if (情報と状態ArrayList.isEmpty()) {
            new情報と状態ArrayList.add(new ShakaifukuRiyoshaFutanKeigenToJotai(社会福祉法人等利用者負担軽減申請情報, 状態_追加, 0));
            List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
            div.getDgShinseiList().setDataSource(newDataSouceList);
            return new情報と状態ArrayList;
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
        List<dgShinseiList_Row> newDataSouceList = getDataSource(new情報と状態ArrayList);
        div.getDgShinseiList().setDataSource(newDataSouceList);
        return new情報と状態ArrayList;
    }

    /**
     * 前排他を解除する。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void 前排他の解除(HihokenshaNo 被保険者番号) {
        RealInitialLocker.release(new LockingKey(new RString("DB").concat(被保険者番号.getColumnValue()).concat("ShafukuKeigen")));
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を保存する」を押下する。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void onClick_btnUpdate(ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList,
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        PersonalData personalData = PersonalData.of(識別コード,
                new ExpandedInformation(CODE_0003, NAME_被保険者番号, 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.更新, personalData);
        ShakaiFukushiHojinKeigenManager.createIntance().更新処理(情報と状態ArrayList, 申請メニューID.equals(ResponseHolder.getMenuID()));
        前排他の解除(被保険者番号);
        div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
    }

    /**
     * 変更有無チェックです。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @return 変更有無
     */
    public boolean 変更有無チェック(ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList) {
        return !情報と状態ArrayList.isEmpty() && !isすべての状態列が空(情報と状態ArrayList);
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
     * 社会福祉法人等利用者負担軽減申請画面を「決定区分」を押下する。
     *
     */
    public void onClick_radKetteiKubun() {
        RString selectKey = div.getRadKetteiKubun().getSelectedKey();
        if (KEY0.equals(selectKey)) {
            div.getBtnSelectHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
            div.getTxtTekiyoYMD().setDisabled(false);
            div.getTxtYukoKigenYMD().setDisabled(false);
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
        }
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を適用日入力する。
     *
     */
    public void onBlur_txtTekiyoYMD() {
        FlexibleDate 適用日 = div.getTxtTekiyoYMD().getValue();
        if (null == 適用日 || !適用日.isValid() || 適用日.isEmpty()) {
            return;
        }
        FlexibleDate 有効期限 = ShakaiFukushiHojinKeigenService.createIntance().estimate有効期限(適用日);
        div.getTxtYukoKigenYMD().setValue(有効期限);
    }

}
