/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1070001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuToJotai;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.homonkaigogemmen.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.HomonKaigoRiyoshaFutanGengakuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.homonkaigogemmen.HomonKaigoRiryoshaFutangakuGengakuService;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 訪問介護利用者負担額減額申請画面ハンドラクラスです。
 *
 * @reamsid_L DBD-3730-010 wangjie2
 */
public class HomonKaigoRiyoshaFutanGengakuHandler {

    private final HomonKaigoRiyoshaFutanGengakuMainDiv div;
    private static final RString 申請メニュー = new RString("DBDMN21003");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString NAME_被保険者番号 = new RString("被保険者番号");
    private static final Decimal DECIMAI_100 = new Decimal("100");
    private final RString 承認する = new RString("1");
    private final RString 承認しない = new RString("0");
    private final RString 漢字承認する = new RString("承認する");
    private final RString 漢字承認しない = new RString("承認しない");
    private final RString 申請情報を追加する = new RString("申請情報を追加する");
    private final RString 承認情報を追加する = new RString("承認情報を追加する");
    private final RString 承認情報を確定する = new RString("承認情報を確定する");
    private final RString 承認情報 = new RString("承認情報");
    private final RString 保存する = new RString("btnSave");
    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");
    private final RString 障害者手帳_有_Key = new RString("key0");
    private final RString 障害者手帳_無_Key = new RString("key1");
    private final RString 承認する_Key = new RString("key0");
    private final RString 承認しない_Key = new RString("key1");

    /**
     * コンストラクタです。
     *
     * @param div 訪問介護利用者負担額減額申請Div
     */
    public HomonKaigoRiyoshaFutanGengakuHandler(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 申請一覧情報 申請一覧情報
     * @return 情報と状態List
     */
    public List<HomonKaigoRiyoshaFutangakuGengakuToJotai> onLoad(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号, List<HomonKaigoRiyoshaFutangakuGengaku> 申請一覧情報) {
        div.getHomonKaigoRiyoshaFutanGengaku().setHihokenshaNo(被保険者番号.getColumnValue());
        div.getCcdAtenaInfo().initialize(識別コード);
        div.getCcdShikakuKihon().initialize(被保険者番号);
        List<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態List = 情報と状態初期化(申請一覧情報);
        div.getDgShinseiList().setDataSource(getDataSource(情報と状態List));
        div.getCcdShinseiJoho().initialize(識別コード);
        div.getDdlHobetsuKubun().setDataSource(get法別区分DataSource());
        if (申請メニュー.equals(ResponseHolder.getMenuID())) {
            div.getBtnAddShinsei().setText(申請情報を追加する);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(保存する, "申請情報を");
        } else {
            div.getBtnAddShinsei().setText(承認情報を追加する);
            div.getHomonKaigoGengakuShinseiDetail().setTitle(承認情報);
            div.getBtnAddShinseiJoho().setText(承認情報を確定する);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(保存する, "承認情報を");
        }
        ボタン制御();
        close情報エリア(true);
        PersonalData personalData = PersonalData.of(識別コード, new ExpandedInformation(CODE_0003, NAME_被保険者番号, 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.照会, personalData);
        RealInitialLocker.lock(new LockingKey(new RString("DB").concat(被保険者番号.getColumnValue().concat("HomonKaigoGengaku"))));
        return 情報と状態List;
    }

    private List<KeyValueDataSource> get法別区分DataSource() {
        List<KeyValueDataSource> 法別区分 = new ArrayList<>();
        法別区分.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (HobetsuKubun hobetsuKubun : HobetsuKubun.values()) {
            法別区分.add(new KeyValueDataSource(hobetsuKubun.getコード(), hobetsuKubun.get名称()));
        }
        return 法別区分;
    }

    public void ボタン制御() {
        for (dgShinseiList_Row row : div.getDgShinseiList().getDataSource()) {
            if (row.getKetteiKubun() == null || row.getKetteiKubun().isEmpty()) {
                div.getBtnAddShinsei().setDisabled(true);
            } else {
                if (申請メニュー.equals(ResponseHolder.getMenuID())) {
                    row.setModifyButtonState((DataGridButtonState.Disabled));
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                    row.setSelectable(Boolean.FALSE);
                }
            }
        }
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
     * 情報エリア制御処理です。
     *
     * @param isClose isClose
     */
    public void close情報エリア(boolean isClose) {
        div.getTxtShinseiYMD().setDisabled(isClose);
        div.getTxtShinseiRiyu().setDisabled(isClose);
        div.getCcdShinseiJoho().setDisabled(isClose);
        div.getShogaishaTecho().setDisabled(isClose);
        div.getDdlKettaiKubun().setDisabled(isClose);
        div.getTxtKettaiYmd().setDisabled(isClose);
        div.getTxtTekiyoYmd().setDisabled(isClose);
        div.getTxtYukoKigen().setDisabled(isClose);
        div.getDdlHobetsuKubun().setDisabled(isClose);
        div.getTxtKyufuRitsu().setDisabled(isClose);
        div.getTxtKohiFutanshaNo().setDisabled(isClose);
        div.getTxtKohiJyukyshaNo().setDisabled(isClose);
        div.getBtnOpenHiShoninRiyu().setDisabled(isClose);
        div.getTxtHiShoninRiyu().setDisabled(isClose);
        div.getBtnReturnShinseiIchiran().setDisabled(isClose);
        div.getBtnAddShinseiJoho().setDisabled(isClose);
    }

    /**
     * 申請一覧エリア制御処理です。
     *
     * @param isClose isClose
     */
    public void close申請一覧エリア(boolean isClose) {
        div.getBtnAddShinsei().setDisabled(isClose);
        div.getDgShinseiList().setDisabled(isClose);
    }

    private List<dgShinseiList_Row> getDataSource(List<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態List) {
        List<dgShinseiList_Row> rowList = new ArrayList<>();
        for (HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態 : 情報と状態List) {
            HomonKaigoRiyoshaFutangakuGengaku 情報 = 情報と状態.get訪問介護利用者負担額減額情報();
            dgShinseiList_Row row = new dgShinseiList_Row();
            row.setJotai(情報と状態.get状態());
            TextBoxFlexibleDate 申請日 = new TextBoxFlexibleDate();
            申請日.setValue(情報.get申請年月日());
            row.setTxtShinseiYMD(申請日);
            row.setShinseiRiyu(情報.get申請事由());
            row.setKetteiKubun(get決定区分(情報.get決定区分()));
            TextBoxFlexibleDate 決定日 = new TextBoxFlexibleDate();
            if (!isNullOrEmpty(情報.get決定年月日())) {
                決定日.setValue(情報.get決定年月日());
            }
            row.setTxtKetteiYMD(決定日);
            TextBoxFlexibleDate 適用日 = new TextBoxFlexibleDate();
            if (!isNullOrEmpty(情報.get適用開始年月日())) {
                適用日.setValue(情報.get適用開始年月日());
            }
            row.setTxtTekiyoYMD(適用日);
            TextBoxFlexibleDate 有効期限 = new TextBoxFlexibleDate();
            if (!isNullOrEmpty(情報.get適用終了年月日())) {
                有効期限.setValue(情報.get適用終了年月日());
            }
            row.setTxtYukoKigen(有効期限);
            if (!isNullOrEmpty(情報.get法別区分())) {
                row.setHobetsuKubun(HobetsuKubun.toValue(情報.get法別区分()).get名称());
            }
            if (情報.get給付率() != null) {
                TextBoxNum 給付率 = new TextBoxNum();
                給付率.setValue(情報.get給付率().getColumnValue());
                row.setTxtKyufuritsu(給付率);
            }
            row.setKohiFutanshaNo(情報.get公費負担者番号());
            row.setKohiJukyushaNo(情報.get公費受給者番号());
            row.setShogaishaNo(情報.get障害者手帳番号());
            row.setShoninShinaiRiyu(情報.get非承認理由());
            row.setDataId(DataPassingConverter.serialize(情報.identifier()));
            rowList.add(row);
        }
        if (rowList.size() < 2) {
            return rowList;
        }
        for (int i = 0; i < rowList.size(); i++) {
            dgShinseiList_Row Row = rowList.get(i);
            if (Row.getKetteiKubun() == null || Row.getKetteiKubun().isEmpty()) {
                rowList.remove(i);
                rowList.add(0, Row);
            }
        }
        return rowList;
    }

    private boolean isNullOrEmpty(RString value) {
        return null == value || value.isEmpty();
    }

    private boolean isNullOrEmpty(FlexibleDate value) {
        return null == value || value.isEmpty();
    }

    private RString get決定区分(RString 決定区分) {
        if (承認する.equals(決定区分)) {
            return 漢字承認する;
        } else if (承認しない.equals(決定区分)) {
            return 漢字承認しない;
        }
        return RString.EMPTY;
    }

    private List<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態初期化(List<HomonKaigoRiyoshaFutangakuGengaku> 申請一覧情報) {
        List<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態List = new ArrayList<>();
        for (HomonKaigoRiyoshaFutangakuGengaku 申請情報 : 申請一覧情報) {
            情報と状態List.add(new HomonKaigoRiyoshaFutangakuGengakuToJotai(申請情報, RString.EMPTY, 申請情報.get履歴番号()));
        }
        return 情報と状態List;
    }

    /**
     * 申請一覧情報の取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請一覧情報
     */
    public List<HomonKaigoRiyoshaFutangakuGengaku> get申請一覧情報(HihokenshaNo 被保険者番号) {
        return HomonKaigoRiryoshaFutangakuGengakuService.createIntance().load訪問介護利用者負担額減額申請All(被保険者番号);
    }

    /**
     * 申請一覧の削除ボタンを押下処理です。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     */
    public void onSelectByDeleteButton(ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList) {
        dgShinseiList_Row row = div.getDgShinseiList().getActiveRow();
        RString 状態 = row.getJotai();
        HomonKaigoRiyoshaFutangakuGengakuIdentifier id
                = DataPassingConverter.deserialize(row.getDataId(), HomonKaigoRiyoshaFutangakuGengakuIdentifier.class);
        if (状態.isEmpty() || 状態_修正.equals(状態)) {
            for (int index = 0; index < 情報と状態ArrayList.size(); index++) {
                if (id.equals(情報と状態ArrayList.get(index).get訪問介護利用者負担額減額情報().identifier())) {
                    情報と状態ArrayList.get(index).set状態(状態_削除);
                }
            }
        } else if (状態_追加.equals(状態)) {
            for (int index = 0; index < 情報と状態ArrayList.size(); index++) {
                if (id.equals(情報と状態ArrayList.get(index).get訪問介護利用者負担額減額情報().identifier())) {
                    情報と状態ArrayList.remove(index);
                }
            }
        }
        履歴番号修正(情報と状態ArrayList);
        div.getDgShinseiList().setDataSource(getDataSource(情報と状態ArrayList));
        ボタン制御();
    }

    private void 履歴番号修正(ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList) {
        int 履歴番号 = 1;
        for (int index = 情報と状態ArrayList.size() - 1; index >= 0; index--) {
            if (情報と状態ArrayList.get(index).get新履歴番号() != 0 && !情報と状態ArrayList.get(index).get状態().equals(状態_削除)) {
                情報と状態ArrayList.get(index).set新履歴番号(履歴番号);
                履歴番号 += 1;
            }
        }
    }

    /**
     * 「申請情報を追加する」（また「承認情報を追加する」）を押下処理です。
     *
     * @param 識別コード 識別コード
     */
    public void onClick_btnAddShinsei(ShikibetsuCode 識別コード) {
        close情報エリア(false);
        close申請一覧エリア(true);
        set申請情報_追加(識別コード);
        追加制御();
    }

    private void 追加制御() {
        div.getTxtShinseiYMD().setDisabled(false);
        div.getTxtShinseiRiyu().setDisabled(false);
        if (申請メニュー.equals(ResponseHolder.getMenuID())) {
            div.getDdlKettaiKubun().setDisabled(true);
            div.getTxtKettaiYmd().setDisabled(true);
            div.getTxtTekiyoYmd().setDisabled(true);
            div.getTxtYukoKigen().setDisabled(true);
            div.getDdlHobetsuKubun().setDisabled(true);
            div.getTxtKyufuRitsu().setDisabled(true);
            div.getTxtKohiFutanshaNo().setDisabled(true);
            div.getTxtKohiJyukyshaNo().setDisabled(true);
            div.getBtnOpenHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
        } else {
            div.getDdlKettaiKubun().setDisabled(false);
            div.getTxtKettaiYmd().setDisabled(false);
            div.getTxtTekiyoYmd().setDisabled(false);
            div.getTxtYukoKigen().setDisabled(false);
            div.getDdlHobetsuKubun().setDisabled(false);
            div.getTxtKyufuRitsu().setDisabled(false);
            div.getTxtKohiFutanshaNo().setDisabled(false);
            div.getTxtKohiJyukyshaNo().setDisabled(false);
            div.getBtnOpenHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
        }
    }

    private void set申請情報_追加(ShikibetsuCode 識別コード) {
        div.getTxtShinseiYMD().setValue(FlexibleDate.getNowDate());
        div.getTxtShinseiRiyu().clearValue();
        div.getCcdShinseiJoho().initialize(識別コード);
        div.getRadShogaishaTechoUmu().setSelectedKey(障害者手帳_有_Key);
        div.getTxtShogaishaTechoTokyu().clearValue();
        div.getTxtShogaishaTechoNo().clearValue();
        div.getTxtShogaishaTechoKofuYMD().clearValue();
        div.getTxtShogaishaTechoTokyu().setDisabled(false);
        div.getTxtShogaishaTechoNo().setDisabled(false);
        div.getTxtShogaishaTechoKofuYMD().setDisabled(false);
        div.getDdlKettaiKubun().setSelectedKey(承認する_Key);
        if (申請メニュー.equals(ResponseHolder.getMenuID())) {
            div.getTxtKettaiYmd().clearValue();
            div.getTxtTekiyoYmd().clearValue();
            div.getTxtYukoKigen().clearValue();
        } else {
            div.getTxtKettaiYmd().setValue(FlexibleDate.getNowDate());
            div.getTxtTekiyoYmd().setValue(get適用日初期値());
            HomonKaigoRiryoshaFutangakuGengakuService service = HomonKaigoRiryoshaFutangakuGengakuService.createIntance();
            div.getTxtYukoKigen().setValue(service.estimate有効期限(div.getTxtTekiyoYmd().getValue()));
        }
        div.getTxtKohiFutanshaNo().clearValue();
        div.getTxtKohiJyukyshaNo().clearValue();
        div.getTxtHiShoninRiyu().clearValue();
        if (申請メニュー.equals(ResponseHolder.getMenuID())) {
            div.getDdlHobetsuKubun().setSelectedKey(RString.EMPTY);
            div.getTxtKyufuRitsu().clearValue();
        } else {
            div.getDdlHobetsuKubun().setSelectedKey(HobetsuKubun.障害ヘルプ全額免除.getコード());
            div.getTxtKyufuRitsu().setValue(DECIMAI_100);
        }
    }

    private FlexibleDate get適用日初期値() {
        List<dgShinseiList_Row> rows = div.getDgShinseiList().getDataSource();
        if (rows.isEmpty()) {
            return FlexibleDate.getNowDate();
        } else {
            for (dgShinseiList_Row row : rows) {
                if (row.getKetteiKubun().equals(漢字承認する)) {
                    return new FlexibleDate(row.getTxtYukoKigen().
                            getValue().plusDay(1).toString());
                }
            }
        }
        return FlexibleDate.getNowDate();
    }

    /**
     * 「障害者手帳有無」を押下処理です。
     *
     */
    public void onChange_radShogaishaTechoUmu() {
        if (障害者手帳_有_Key.equals(div.getRadShogaishaTechoUmu().getSelectedKey())) {
            div.getTxtShogaishaTechoTokyu().setDisabled(false);
            div.getTxtShogaishaTechoNo().setDisabled(false);
            div.getTxtShogaishaTechoKofuYMD().setDisabled(false);
        } else {
            div.getTxtShogaishaTechoTokyu().clearValue();
            div.getTxtShogaishaTechoNo().clearValue();
            div.getTxtShogaishaTechoKofuYMD().clearValue();
            div.getTxtShogaishaTechoTokyu().setDisabled(true);
            div.getTxtShogaishaTechoNo().setDisabled(true);
            div.getTxtShogaishaTechoKofuYMD().setDisabled(true);
        }
    }

    /**
     * 「決定区分」を押下処理です。
     *
     */
    public void onChange_ddlKettaiKubun() {
        if (承認する_Key.equals(div.getDdlKettaiKubun().getSelectedKey())) {
            div.getTxtHiShoninRiyu().clearValue();
            div.getBtnOpenHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
            div.getDdlHobetsuKubun().setDisabled(false);
            div.getTxtKyufuRitsu().setDisabled(false);
            div.getTxtKohiFutanshaNo().setDisabled(false);
            div.getTxtKohiJyukyshaNo().setDisabled(false);
        } else {
            div.getDdlHobetsuKubun().setSelectedValue(RString.EMPTY);
            div.getTxtKyufuRitsu().clearValue();
            div.getTxtKohiFutanshaNo().clearValue();
            div.getTxtKohiJyukyshaNo().clearValue();
            div.getBtnOpenHiShoninRiyu().setDisabled(false);
            div.getTxtHiShoninRiyu().setDisabled(false);
            div.getDdlHobetsuKubun().setDisabled(true);
            div.getTxtKyufuRitsu().setDisabled(true);
            div.getTxtKohiFutanshaNo().setDisabled(true);
            div.getTxtKohiJyukyshaNo().setDisabled(true);
        }
    }

    /**
     * 変更有無チェック処理です。
     *
     * @return is変更
     */
    public boolean 変更有無チェック() {
        List<dgShinseiList_Row> rowList = div.getDgShinseiList().getDataSource();
        for (dgShinseiList_Row row : rowList) {
            if (!isNullOrEmpty(row.getJotai())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 「申請情報を保存する」（また「承認情報を保存する」）ボタンを押下処理です。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 最初申請一覧情報 最初申請一覧情報
     */
    public void onClick_btnUpdate(ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList,
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, List<HomonKaigoRiyoshaFutangakuGengaku> 最初申請一覧情報) {
        PersonalData personalData = PersonalData.of(識別コード,
                new ExpandedInformation(CODE_0003, NAME_被保険者番号, 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.更新, personalData);
        HomonKaigoRiryoshaFutangakuGengakuService.createIntance()
                .更新処理(情報と状態ArrayList, 申請メニュー.equals(ResponseHolder.getMenuID()), 最初申請一覧情報);
        前排他の解除(被保険者番号);
        div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
    }

    /**
     * 「法別区分ddl」を押下処理です。
     *
     */
    public void onChange_ddlHobetsuKubun() {
        HomonKaigoRiryoshaFutangakuGengakuService service = HomonKaigoRiryoshaFutangakuGengakuService.createIntance();
        HobetsuKubun 法別区分 = null;
        if (!div.getDdlHobetsuKubun().getSelectedKey().isEmpty()) {
            法別区分 = HobetsuKubun.toValue(div.getDdlHobetsuKubun().getSelectedKey());
        }
        div.getTxtKohiFutanshaNo().setValue(service.create公費負担者番号(法別区分));
        if (法別区分 != null && div.getTxtTekiyoYmd().getValue() != null && !div.getTxtTekiyoYmd().getValue().isEmpty()) {
            div.getTxtKyufuRitsu().setValue(new Decimal(service.decide給付率(法別区分, div.getTxtTekiyoYmd().getValue())));
        }
    }

    /**
     * 「適用日」を押下処理です。
     *
     */
    public void onBlur_txtTekiyoYmd() {
        if (div.getTxtYukoKigen() == null || div.getTxtYukoKigen().getValue().isEmpty()) {
            HomonKaigoRiryoshaFutangakuGengakuService service = HomonKaigoRiryoshaFutangakuGengakuService.createIntance();
            div.getTxtYukoKigen().setValue(service.estimate有効期限(div.getTxtTekiyoYmd().getValue()));
        }
    }

    /**
     * 「公費受給者番号」を押下処理です。
     *
     */
    public void onBlur_txtKohiJyukyshaNo() {
        HomonKaigoRiryoshaFutangakuGengakuService service = HomonKaigoRiryoshaFutangakuGengakuService.createIntance();
        RString チェックディジットが付与された公費負担者番号
                = service.appendModulus10(div.getTxtKohiJyukyshaNo().getValue());
        if (チェックディジットが付与された公費負担者番号.isEmpty()) {
            div.getTxtKohiJyukyushaNoCheckDigit().clearValue();
        } else {
            div.getTxtKohiJyukyushaNoCheckDigit()
                    .setValue(チェックディジットが付与された公費負担者番号.substring(チェックディジットが付与された公費負担者番号.length() - 1));
        }
    }

    /**
     * DataSouce情報取得処理する。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @return 情報と状態
     */
    public HomonKaigoRiyoshaFutangakuGengakuToJotai get情報と状態BySelectDataSouce(
            ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList) {
        dgShinseiList_Row row = div.getDgShinseiList().getActiveRow();
        HomonKaigoRiyoshaFutangakuGengakuIdentifier id
                = DataPassingConverter.deserialize(row.getDataId(), HomonKaigoRiyoshaFutangakuGengakuIdentifier.class);
        for (HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態 : 情報と状態ArrayList) {
            if (id.equals(情報と状態.get訪問介護利用者負担額減額情報().identifier())) {
                return 情報と状態;
            }
        }
        return null;
    }

    /**
     * 申請一覧の修正ボタンを押下処理です。
     *
     * @param 情報と状態 情報と状態
     */
    public void onSelectByModifyButton(HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態) {
        close情報エリア(false);
        close申請一覧エリア(true);
        set申請情報エリア(情報と状態);
        if (申請メニュー.equals(ResponseHolder.getMenuID())) {
            一覧申請修正制御();
        } else {
            一覧承認修正制御(情報と状態);
        }
    }

    private void 一覧承認修正制御(HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態) {
        boolean is追加 = 状態_追加.equals(情報と状態.get状態());
        div.getTxtShinseiYMD().setDisabled(!is追加);
        div.getTxtShinseiRiyu().setDisabled(!is追加);
        div.getTxtKettaiYmd().setDisabled(false);
        div.getTxtTekiyoYmd().setDisabled(false);
        div.getTxtYukoKigen().setDisabled(false);
        div.getDdlKettaiKubun().setDisabled(false);
        if (承認しない.equals(情報と状態.get訪問介護利用者負担額減額情報().get決定区分())) {
            div.getDdlHobetsuKubun().setDisabled(true);
            div.getTxtKyufuRitsu().setDisabled(true);
            div.getTxtKohiFutanshaNo().setDisabled(true);
            div.getTxtKohiJyukyshaNo().setDisabled(true);
            div.getBtnOpenHiShoninRiyu().setDisabled(false);
            div.getTxtHiShoninRiyu().setDisabled(false);
        } else {
            div.getDdlHobetsuKubun().setDisabled(false);
            div.getTxtKyufuRitsu().setDisabled(false);
            div.getTxtKohiFutanshaNo().setDisabled(false);
            div.getTxtKohiJyukyshaNo().setDisabled(false);
            div.getBtnOpenHiShoninRiyu().setDisabled(true);
            div.getTxtHiShoninRiyu().setDisabled(true);
        }
        if (!情報と状態.get訪問介護利用者負担額減額情報().is障害者手帳有無()) {
            div.getTxtShogaishaTechoTokyu().setDisabled(true);
            div.getTxtShogaishaTechoNo().setDisabled(true);
            div.getTxtShogaishaTechoKofuYMD().setDisabled(true);
        } else {
            div.getTxtShogaishaTechoTokyu().setDisabled(false);
            div.getTxtShogaishaTechoNo().setDisabled(false);
            div.getTxtShogaishaTechoKofuYMD().setDisabled(false);
        }
    }

    private void 一覧申請修正制御() {
        div.getTxtShinseiYMD().setDisabled(false);
        div.getTxtShinseiRiyu().setDisabled(false);
        div.getCcdShinseiJoho().setDisabled(false);
        div.getShogaishaTecho().setDisabled(false);
        div.getDdlKettaiKubun().setDisabled(true);
        div.getTxtKettaiYmd().setDisabled(true);
        div.getTxtTekiyoYmd().setDisabled(true);
        div.getTxtYukoKigen().setDisabled(true);
        div.getDdlHobetsuKubun().setDisabled(true);
        div.getTxtKyufuRitsu().setDisabled(true);
        div.getTxtKohiFutanshaNo().setDisabled(true);
        div.getTxtKohiJyukyshaNo().setDisabled(true);
        div.getBtnOpenHiShoninRiyu().setDisabled(true);
        div.getTxtHiShoninRiyu().setDisabled(true);
    }

    private void set申請情報エリア(HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態) {
        HomonKaigoRiyoshaFutangakuGengaku 情報 = 情報と状態.get訪問介護利用者負担額減額情報();
        div.getTxtShinseiYMD().setValue(情報.get申請年月日());
        div.getTxtShinseiRiyu().setValue(情報.get申請事由());
        div.getCcdShinseiJoho().set減免減額申請情報(getShinseiJoho(情報), 情報.get申請年月日());
        if (情報.is障害者手帳有無()) {
            div.getRadShogaishaTechoUmu().setSelectedKey(障害者手帳_有_Key);
        } else {
            div.getRadShogaishaTechoUmu().setSelectedKey(障害者手帳_無_Key);
            div.getTxtShogaishaTechoTokyu().setDisabled(true);
            div.getTxtShogaishaTechoNo().setDisabled(true);
            div.getTxtShogaishaTechoKofuYMD().setDisabled(true);
        }
        div.getTxtShogaishaTechoTokyu().setValue(情報.get障害者手帳等級());
        div.getTxtShogaishaTechoNo().setValue(情報.get障害者手帳番号());
        if (情報.get障害者手帳交付年月日() != null) {
            div.getTxtShogaishaTechoKofuYMD().setValue(情報.get障害者手帳交付年月日());
        } else {
            div.getTxtShogaishaTechoKofuYMD().clearValue();
        }
        if (承認しない.equals(情報.get決定区分())) {
            div.getDdlKettaiKubun().setSelectedKey(承認しない_Key);
        } else {
            div.getDdlKettaiKubun().setSelectedKey(承認する_Key);
        }
        if (情報.get決定年月日() != null) {
            div.getTxtKettaiYmd().setValue(情報.get決定年月日());
        } else if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
            div.getTxtKettaiYmd().setValue(FlexibleDate.getNowDate());
        } else {
            div.getTxtKettaiYmd().clearValue();
        }
        if (情報.get適用開始年月日() != null) {
            div.getTxtTekiyoYmd().setValue(情報.get適用開始年月日());
        } else if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
            div.getTxtTekiyoYmd().setValue(get適用日初期値());
        } else {
            div.getTxtTekiyoYmd().clearValue();
        }
        if (情報.get適用終了年月日() != null) {
            div.getTxtYukoKigen().setValue(情報.get適用終了年月日());
        } else if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
            HomonKaigoRiryoshaFutangakuGengakuService service = HomonKaigoRiryoshaFutangakuGengakuService.createIntance();
            div.getTxtYukoKigen().setValue(service.estimate有効期限(div.getTxtTekiyoYmd().getValue()));
        } else {
            div.getTxtYukoKigen().clearValue();
        }
        div.getDdlHobetsuKubun().setSelectedKey(get法別区分Key(情報.get法別区分()));
        if (情報.get給付率() != null) {
            div.getTxtKyufuRitsu().setValue(情報.get給付率().getColumnValue());
        } else {
            div.getTxtKyufuRitsu().clearValue();
        }
        if (情報.get公費負担者番号() != null) {
            div.getTxtKohiFutanshaNo().setValue(情報.get公費負担者番号());
        } else {
            div.getTxtKohiFutanshaNo().clearValue();
        }
        if (!RString.isNullOrEmpty(情報.get公費受給者番号())) {
            div.getTxtKohiJyukyshaNo().setValue(情報.get公費受給者番号().substring(0, 情報.get公費受給者番号().length()));
            div.getTxtKohiJyukyushaNoCheckDigit().setValue(情報.get公費受給者番号().substring(情報.get公費受給者番号().length() - 1));
        } else {
            div.getTxtKohiJyukyshaNo().clearValue();
            div.getTxtKohiJyukyushaNoCheckDigit().clearValue();
        }
        if (情報.get非承認理由() != null) {
            div.getTxtHiShoninRiyu().setValue(情報.get非承認理由());
        } else {
            div.getTxtHiShoninRiyu().clearValue();
        }
    }

    private RString get法別区分Key(RString 法別区分) {
        if (null == 法別区分 || 法別区分.isEmpty()) {
            return RString.EMPTY;
        }
        return 法別区分;
    }

    private ShinseiJoho getShinseiJoho(HomonKaigoRiyoshaFutangakuGengaku 情報) {
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 情報.getGemmenGengakuShinseiList();
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

    /**
     * 前排他の解除処理です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void 前排他の解除(HihokenshaNo 被保険者番号) {
        RealInitialLocker
                .release(new LockingKey(new RString("DB").concat(被保険者番号.getColumnValue().concat("HomonKaigoGengaku"))));
    }

    /**
     * 「申請情報を確定する」（また「承認情報を確定する」）ボタンを押下処理です。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @param 編集前情報 編集情報
     * @param 追加履歴番号 追加履歴番号
     * @param 被保険者番号 被保険者番号
     */
    public void onClick_btnConfirm(ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList,
            HomonKaigoRiyoshaFutangakuGengakuToJotai 編集前情報, Integer 追加履歴番号, HihokenshaNo 被保険者番号) {

        HomonKaigoRiyoshaFutangakuGengakuToJotai 画面情報 = get情報と状態From画面(追加履歴番号, 被保険者番号);

        if (編集前情報 == null) {
            追加処理(情報と状態ArrayList, 画面情報);
        } else {
            if (状態_追加.equals(編集前情報.get状態())) {
                削除処理(情報と状態ArrayList, 編集前情報);
                追加処理(情報と状態ArrayList, 画面情報);
            } else {
                削除処理(情報と状態ArrayList, 編集前情報);
                修正情報と状態(編集前情報);
                追加処理(情報と状態ArrayList, 編集前情報);
            }
        }
        div.getDgShinseiList().setDataSource(getDataSource(情報と状態ArrayList));
        close情報エリア(true);
        close申請一覧エリア(false);
        ボタン制御();
    }

    private void 削除処理(ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList,
            HomonKaigoRiyoshaFutangakuGengakuToJotai 編集情報) {

        HomonKaigoRiyoshaFutangakuGengaku 情報 = 編集情報.get訪問介護利用者負担額減額情報();
        HomonKaigoRiyoshaFutangakuGengakuIdentifier id = 情報.identifier();
        int size = 情報と状態ArrayList.size();

        for (int index = 0; index < size; index++) {
            HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態 = 情報と状態ArrayList.get(index);
            if (id.equals(情報と状態.get訪問介護利用者負担額減額情報().identifier())) {
                情報と状態ArrayList.remove(index);
                return;
            }
        }
    }

    private void 修正情報と状態(HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態) {
        HomonKaigoRiyoshaFutangakuGengaku 情報 = 情報と状態.get訪問介護利用者負担額減額情報();
        HomonKaigoRiyoshaFutangakuGengakuBuilder builder = 情報.createBuilderForEdit();
        if (障害者手帳_有_Key.equals(div.getRadShogaishaTechoUmu().getSelectedKey())) {
            builder.set障害者手帳有無(true);
            builder.set障害者手帳番号(div.getTxtShogaishaTechoNo().getValue());
            builder.set障害者手帳等級(div.getTxtShogaishaTechoTokyu().getValue());
            if (div.getTxtShogaishaTechoKofuYMD() != null) {
                builder.set障害者手帳交付年月日(div.getTxtShogaishaTechoKofuYMD().getValue());
            } else {
                builder.set障害者手帳交付年月日(FlexibleDate.EMPTY);
            }
        } else {
            builder.set障害者手帳有無(false);
            builder.set障害者手帳番号(RString.EMPTY);
            builder.set障害者手帳等級(RString.EMPTY);
            builder.set障害者手帳交付年月日(FlexibleDate.EMPTY);
        }

        builder.set申請年月日(div.getTxtShinseiYMD().getValue());
        if (div.getTxtShinseiRiyu().getValue() != null) {
            builder.set申請事由(div.getTxtShinseiRiyu().getValue());
        } else {
            builder.set申請事由(RString.EMPTY);
        }
        if (!申請メニュー.equals(ResponseHolder.getMenuID()) && 承認する_Key.equals(div.getDdlKettaiKubun().getSelectedKey())) {
            builder.set非承認理由(RString.EMPTY);
            builder.set決定区分(承認する);
            builder.set法別区分(div.getDdlHobetsuKubun().getSelectedKey());
            builder.set給付率(new HokenKyufuRitsu(div.getTxtKyufuRitsu().getValue()));
            builder.set公費負担者番号(div.getTxtKohiFutanshaNo().getValue());
            builder.set公費受給者番号(div.getTxtKohiJyukyshaNo().getValue()
                    .concat(div.getTxtKohiJyukyushaNoCheckDigit().getValue()));
        }
        if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
            builder.set決定年月日(div.getTxtKettaiYmd().getValue());
            builder.set適用開始年月日(div.getTxtTekiyoYmd().getValue());
            builder.set適用終了年月日(div.getTxtYukoKigen().getValue());
            if (承認しない_Key.equals(div.getDdlKettaiKubun().getSelectedKey())) {
                builder.set決定区分(承認しない);
                builder.set非承認理由(div.getTxtHiShoninRiyu().getValue());
                builder.set法別区分(RString.EMPTY);
                builder.set給付率(null);
                builder.set公費負担者番号(RString.EMPTY);
                builder.set公費受給者番号(RString.EMPTY);
            }
        }
        List<GemmenGengakuShinsei> 減免減額申請リスト = 情報.getGemmenGengakuShinseiList();
        if (null == 減免減額申請リスト || 減免減額申請リスト.isEmpty()) {
            builder.setGemmenGengakuShinsei(
                    get減免減額申請From画面(情報.get証記載保険者番号(), 情報.get履歴番号(), 情報.get被保険者番号()));
        } else {
            GemmenGengakuShinsei 減免減額申請 = 減免減額申請リスト.get(0);
            builder.setGemmenGengakuShinsei(get修正減免減額申請(減免減額申請));
        }
        情報と状態.set訪問介護利用者負担額減額情報(builder.build());
        if (isNullOrEmpty(情報と状態.get状態()) || 状態_修正.equals(情報と状態.get状態()) || 状態_削除.equals(情報と状態.get状態())) {
            情報と状態.set状態(状態_修正);
        }
    }

    private GemmenGengakuShinsei get修正減免減額申請(GemmenGengakuShinsei 減免減額申請) {
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

    private void 追加処理(ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList,
            HomonKaigoRiyoshaFutangakuGengakuToJotai 画面情報) {

        if (申請メニュー.equals(ResponseHolder.getMenuID())) {
            画面情報.set新履歴番号(0);
            情報と状態ArrayList.add(画面情報);
            return;
        }

        if (!申請メニュー.equals(ResponseHolder.getMenuID()) && 情報と状態ArrayList.isEmpty()) {
            画面情報.set新履歴番号(1);
            情報と状態ArrayList.add(画面情報);
            return;
        }

        int size = 情報と状態ArrayList.size();
        int 履歴番号 = 1;
        boolean isAdded = false;
        for (int index = size - 1; index >= 0; index--) {
            HomonKaigoRiyoshaFutangakuGengakuToJotai 情報 = 情報と状態ArrayList.get(index);
            if (情報.get訪問介護利用者負担額減額情報().get決定区分() == null
                    || 情報.get訪問介護利用者負担額減額情報().get決定区分().isEmpty()) {
                continue;
            }
            if (画面情報.get訪問介護利用者負担額減額情報().get適用開始年月日()
                    .isBefore(情報.get訪問介護利用者負担額減額情報().get適用開始年月日()) && !isAdded) {
                画面情報.set新履歴番号(履歴番号);
                情報と状態ArrayList.add(index + 1, 画面情報);
                履歴番号 += 1;
                isAdded = true;
            } else if (画面情報.get訪問介護利用者負担額減額情報().get適用開始年月日()
                    .equals(情報.get訪問介護利用者負担額減額情報().get適用開始年月日()) && !isAdded) {
                if (画面情報.get訪問介護利用者負担額減額情報().get決定区分().equals(漢字承認しない)) {
                    画面情報.set新履歴番号(履歴番号);
                    情報と状態ArrayList.add(index + 1, 画面情報);
                    履歴番号 += 1;
                    isAdded = true;
                }
            }
            if (!情報.get状態().equals(状態_削除)) {
                情報.set新履歴番号(履歴番号);
                履歴番号 += 1;
            }
        }
        if (!isAdded) {
            画面情報.set新履歴番号(履歴番号);
            情報と状態ArrayList.add(0, 画面情報);
        }
    }

    private HomonKaigoRiyoshaFutangakuGengakuToJotai get情報と状態From画面(Integer 追加履歴番号, HihokenshaNo 被保険者番号) {
        ShoKisaiHokenshaNo 証記載保険者番号 = get証記載保険者番号();
        HomonKaigoRiyoshaFutangakuGengaku 情報 = new HomonKaigoRiyoshaFutangakuGengaku(証記載保険者番号, 被保険者番号, 追加履歴番号);
        HomonKaigoRiyoshaFutangakuGengakuBuilder builder = 情報.createBuilderForEdit();
        builder.set申請年月日(div.getTxtShinseiYMD().getValue());
        if (div.getTxtShinseiRiyu().getValue() != null) {
            builder.set申請事由(div.getTxtShinseiRiyu().getValue());
        } else {
            builder.set申請事由(RString.EMPTY);
        }
        if (障害者手帳_有_Key.equals(div.getRadShogaishaTechoUmu().getSelectedKey())) {
            builder.set障害者手帳有無(true);
            builder.set障害者手帳番号(div.getTxtShogaishaTechoNo().getValue());
            builder.set障害者手帳等級(div.getTxtShogaishaTechoTokyu().getValue());
            if (div.getTxtShogaishaTechoKofuYMD() != null) {
                builder.set障害者手帳交付年月日(div.getTxtShogaishaTechoKofuYMD().getValue());
            } else {
                builder.set障害者手帳交付年月日(FlexibleDate.EMPTY);
            }
        } else {
            builder.set障害者手帳有無(false);
            builder.set障害者手帳番号(RString.EMPTY);
            builder.set障害者手帳等級(RString.EMPTY);
            builder.set障害者手帳交付年月日(FlexibleDate.EMPTY);
        }

        if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
            builder.set決定年月日(div.getTxtKettaiYmd().getValue());
            builder.set適用開始年月日(div.getTxtTekiyoYmd().getValue());
            builder.set適用終了年月日(div.getTxtYukoKigen().getValue());
            if (承認する_Key.equals(div.getDdlKettaiKubun().getSelectedKey())) {
                builder.set決定区分(承認する);
                builder.set法別区分(div.getDdlHobetsuKubun().getSelectedKey());
                builder.set給付率(new HokenKyufuRitsu(div.getTxtKyufuRitsu().getValue()));
                builder.set公費負担者番号(div.getTxtKohiFutanshaNo().getValue());
                builder.set公費受給者番号(div.getTxtKohiJyukyshaNo().getValue()
                        .concat(div.getTxtKohiJyukyushaNoCheckDigit().getValue()));
            } else {
                builder.set決定区分(承認しない);
                builder.set非承認理由(div.getTxtHiShoninRiyu().getValue());
                builder.set法別区分(RString.EMPTY);
                builder.set給付率(null);
                builder.set公費負担者番号(RString.EMPTY);
                builder.set公費受給者番号(RString.EMPTY);
            }
        }
        builder.setGemmenGengakuShinsei(get減免減額申請From画面(証記載保険者番号, 追加履歴番号, 被保険者番号));
        return new HomonKaigoRiyoshaFutangakuGengakuToJotai(builder.build(), 状態_追加, 追加履歴番号);
    }

    private GemmenGengakuShinsei get減免減額申請From画面(ShoKisaiHokenshaNo 証記載保険者番号, Integer 追加履歴番号, HihokenshaNo 被保険者番号) {
        GemmenGengakuShinsei 減免減額申請 = new GemmenGengakuShinsei(証記載保険者番号,
                被保険者番号, GemmenGengakuShurui.訪問介護利用者負担額減額.getコード(), 追加履歴番号);
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

}
