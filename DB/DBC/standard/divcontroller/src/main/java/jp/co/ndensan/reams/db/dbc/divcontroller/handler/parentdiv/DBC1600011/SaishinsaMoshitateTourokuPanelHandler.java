/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1600011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.KyufuJissekiGaitoshaBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.SaishinsaMoshitateJohoBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuCollect;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.ServiceCodeBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.ServiceShuruiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.TokuteiSinryoShikibetsuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitate_MoshitateshaKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1600011.SaishinsaMoshitateTourokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1600011.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護給付費再審査申立書作成のハンドラクラスです。
 *
 * @reamsid_L DBC-2230-010 chenxiangyu
 */
public class SaishinsaMoshitateTourokuPanelHandler {

    private final SaishinsaMoshitateTourokuPanelDiv div;
    private static final RString サービスコード = new RString("txtServiceCode");
    private static final RString 証記載保険者番号 = new RString("txtShokisaiNo");
    private static final RString 申立日 = new RString("txtMoshitateYMD");
    private static final RString 申立日申立者区分 = new RString("txtMoshitateshaKubun");
    private static final RString 申立単位 = new RString("txtMoshitateTani");
    private static final RString 申立事由_項目 = new RString("txtMoshitateJiyuKomoku");
    private static final RString 申立事由_理由 = new RString("txtMoshitateJiyuRiyu");
    private static final RString 送付年月 = new RString("txtKokuhorenSofuYM");
    private static final RString 再審査申立情報一覧 = new RString("再審査申立情報一覧");
    private static final RString 給付実績該当者一覧 = new RString("給付実績該当者一覧");
    private static final RString 広域保険者番号 = new RString("000000");
    private static final RString 特定診療費 = new RString("20");
    private static final RString FALSE = new RString("f");
    private static final RString TRUE = new RString("t");
    private static final RString FOUR_SPACES = new RString("    ");
    private static final RString COLON = new RString("：");
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final RString WIDTH_L = new RString("L");
    private static final RString WIDTH_XL = new RString("XL");
    private static final RString KEY0 = new RString("key0");
    private static final RString 登録モード = new RString("登録モード");
    private static final RString 修正モード = new RString("修正モード");
    private static final RString 削除モード = new RString("削除モード");
    private static final RString 再審査申立情報一覧モード = new RString("再審査申立情報一覧");
    private static final RString 給付実績該当者一覧モード = new RString("給付実績該当者一覧");

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public SaishinsaMoshitateTourokuPanelHandler(SaishinsaMoshitateTourokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化します。
     */
    public void onLoad() {
        div.setHdn再検索フラグ(FALSE);
    }

    /**
     * 再審査申立情報一覧画面の状態に設定します。
     */
    public void setState再審査申立情報一覧画面() {
        div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().setWidth(WIDTH_XL);
        div.getKyufuJissekiGaitoshaListPanel().setTitle(再審査申立情報一覧);
        DataGridSetting 再審査申立情報グリッド = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha()
                .getGridSetting();
        再審査申立情報グリッド.setIsShowDeleteButtonColumn(true);
        再審査申立情報グリッド.setIsShowModifyButtonColumn(true);
        再審査申立情報グリッド.setIsShowSelectButtonColumn(false);
        再審査申立情報グリッド.getColumn(サービスコード).setVisible(true);
        再審査申立情報グリッド.getColumn(証記載保険者番号).setVisible(true);
        再審査申立情報グリッド.getColumn(申立日).setVisible(true);
        再審査申立情報グリッド.getColumn(申立日申立者区分).setVisible(true);
        再審査申立情報グリッド.getColumn(申立単位).setVisible(true);
        再審査申立情報グリッド.getColumn(申立事由_項目).setVisible(true);
        再審査申立情報グリッド.getColumn(申立事由_理由).setVisible(true);
        再審査申立情報グリッド.getColumn(送付年月).setVisible(true);
    }

    /**
     * 給付実績該当者一覧画面の状態に設定します。
     */
    public void setState給付実績該当者一覧画面() {
        div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().setWidth(WIDTH_L);
        div.getKyufuJissekiGaitoshaListPanel().setTitle(給付実績該当者一覧);
        DataGridSetting 再審査申立情報グリッド = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha()
                .getGridSetting();
        再審査申立情報グリッド.setIsShowDeleteButtonColumn(false);
        再審査申立情報グリッド.setIsShowModifyButtonColumn(false);
        再審査申立情報グリッド.setIsShowSelectButtonColumn(true);
        再審査申立情報グリッド.getColumn(サービスコード).setVisible(false);
        再審査申立情報グリッド.getColumn(証記載保険者番号).setVisible(false);
        再審査申立情報グリッド.getColumn(申立日).setVisible(false);
        再審査申立情報グリッド.getColumn(申立日申立者区分).setVisible(false);
        再審査申立情報グリッド.getColumn(申立単位).setVisible(false);
        再審査申立情報グリッド.getColumn(申立事由_項目).setVisible(false);
        再審査申立情報グリッド.getColumn(申立事由_理由).setVisible(false);
        再審査申立情報グリッド.getColumn(送付年月).setVisible(false);
    }

    /**
     * 再審査申立情報一覧を画面に表示します。
     *
     * @param 再審査申立情報一覧 再審査申立情報一覧
     */
    public void set再審査申立情報一覧(List<SaishinsaMoshitateJohoBusiness> 再審査申立情報一覧) {
        List<dgHihokenshaSearchGaitosha_Row> rowList = new ArrayList();
        if (再審査申立情報一覧 != null) {
            for (SaishinsaMoshitateJohoBusiness 再審査申立情報 : 再審査申立情報一覧) {
                RString 国保連送付年月 = RString.EMPTY;
                if (!RString.isNullOrEmpty(再審査申立情報.get国保連送付年月())) {
                    国保連送付年月 = new FlexibleYearMonth(再審査申立情報.get国保連送付年月())
                            .wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
                }
                dgHihokenshaSearchGaitosha_Row row = new dgHihokenshaSearchGaitosha_Row(
                        再審査申立情報.get事業所番号(),
                        再審査申立情報.get事業者名(),
                        再審査申立情報.get被保険者番号(),
                        再審査申立情報.get氏名(),
                        new FlexibleYearMonth(再審査申立情報.getサービス提供年月())
                        .wareki().firstYear(FirstYear.ICHI_NEN).toDateString(),
                        再審査申立情報.getサービス種類コード().concat(再審査申立情報.getサービス項目コード()),
                        再審査申立情報.get証記載保険者番号(),
                        new FlexibleDate(再審査申立情報.get申立年月日()).wareki().toDateString(),
                        KagoMoshitate_MoshitateshaKubun.toValue(再審査申立情報.get申立者区分コード()).get名称(),
                        再審査申立情報.get申立単位数(),
                        CodeMaster.getCodeMeisho(
                                SubGyomuCode.DBC介護給付,
                                DBCCodeShubetsu.再審査申立事由コード_上２桁_申立対象項目コード.getコード(),
                                new Code(再審査申立情報.get申立事由コード().substring(ZERO, TWO)),
                                FlexibleDate.getNowDate()),
                        CodeMaster.getCodeMeisho(
                                SubGyomuCode.DBC介護給付,
                                DBCCodeShubetsu.再審査申立事由コード_下２桁_申立理由番号.getコード(),
                                new Code(再審査申立情報.get申立事由コード().substring(TWO)),
                                FlexibleDate.getNowDate()),
                        国保連送付年月);
                rowList.add(row);
            }
        }
        div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().setDataSource(rowList);
        setState再審査申立情報一覧画面();
    }

    /**
     * 給付実績一覧を画面に表示します。
     *
     * @param 給付実績一覧 給付実績一覧
     */
    public void set給付実績一覧(List<KyufuJissekiGaitoshaBusiness> 給付実績一覧) {
        List<dgHihokenshaSearchGaitosha_Row> rowList = new ArrayList();
        if (給付実績一覧 != null) {
            for (KyufuJissekiGaitoshaBusiness 給付実績情報 : 給付実績一覧) {
                dgHihokenshaSearchGaitosha_Row row = new dgHihokenshaSearchGaitosha_Row();
                row.setTxtJigyoshaNo(給付実績情報.get事業所番号());
                row.setTxtJigyoshaName(給付実績情報.get事業者名());
                row.setTxtHiHoekNo(給付実績情報.get被保険者番号());
                row.setTxtName(給付実績情報.get氏名());
                row.setTxtShokisaiNo(給付実績情報.get証記載保険者番号());
                row.setTxtTeikyoYM(new FlexibleYearMonth(
                        給付実績情報.getサービス提供年月()).wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
                rowList.add(row);
            }
        }
        div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().setDataSource(rowList);
        setState給付実績該当者一覧画面();
    }

    /**
     * 再審査申立書登録表示初期化します。
     *
     * @param 画面モード 画面モード
     * @param サービス種類リスト サービス種類リスト
     * @param サービスコードリスト サービスコードリスト
     * @param 特定診療識別リスト 特定診療識別リスト
     */
    public void 再審査申立書登録表示初期化(
            RString 画面モード,
            List<ServiceShuruiBusiness> サービス種類リスト,
            List<ServiceCodeBusiness> サービスコードリスト,
            List<TokuteiSinryoShikibetsuBusiness> 特定診療識別リスト) {
        RString 被保険者番号 = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha()
                .getActiveRow().getTxtHiHoekNo();
        div.getKagoMoshitatePanel().getCommonKaigoshikakuKihonChildDiv2().initialize(new HihokenshaNo(被保険者番号));
        div.setHdn被保険者番号(被保険者番号);
        if (サービス種類リスト != null) {
            List<KeyValueDataSource> dataSourceList = new ArrayList();
            for (ServiceShuruiBusiness サービス種類 : サービス種類リスト) {
                KeyValueDataSource dataSource = new KeyValueDataSource();
                dataSource.setKey(サービス種類.getサービス種類コード().concat(FOUR_SPACES));
                if (!RString.isNullOrEmpty(サービス種類.getサービス種類略称())) {
                    dataSource.setValue(サービス種類.getサービス種類コード().concat(COLON).concat(
                            サービス種類.getサービス種類略称()));
                } else {
                    dataSource.setValue(サービス種類.getサービス種類コード().concat(COLON));
                }
                dataSourceList.add(dataSource);
            }
            div.getKagoMoshitatePanel().getDropDownList3().setDataSource(dataSourceList);
            div.getKagoMoshitatePanel().getDropDownList3().setIsBlankLine(true);
        }
        if (サービスコードリスト != null) {
            List<KeyValueDataSource> dataSourceList = new ArrayList();
            for (ServiceCodeBusiness サービスコード値 : サービスコードリスト) {
                KeyValueDataSource dataSource = new KeyValueDataSource();
                dataSource.setKey(サービスコード値.getサービス種類コード().concat(サービスコード値.getサービス項目コード()));
                dataSource.setValue(サービスコード値.getサービス種類コード()
                        .concat(サービスコード値.getサービス項目コード())
                        .concat(COLON)
                        .concat(サービスコード値.getサービス略称()));
                dataSourceList.add(dataSource);
            }
            div.getKagoMoshitatePanel().getDropDownList6().setDataSource(dataSourceList);
            div.getKagoMoshitatePanel().getDropDownList6().setIsBlankLine(true);
        }
        if (特定診療識別リスト != null) {
            List<KeyValueDataSource> dataSourceList = new ArrayList();
            for (TokuteiSinryoShikibetsuBusiness 特定診療識別 : 特定診療識別リスト) {
                KeyValueDataSource dataSource = new KeyValueDataSource();
                dataSource.setKey(特定診療識別.getサービス種類コード().concat(特定診療識別.getサービス項目コード()));
                RString サービス名称 = RString.EMPTY;
                if (!RString.isNullOrEmpty(特定診療識別.getサービス名称())) {
                    サービス名称 = 特定診療識別.getサービス名称();
                }
                dataSource.setValue(特定診療識別.getサービス種類コード()
                        .concat(特定診療識別.getサービス項目コード())
                        .concat(COLON)
                        .concat(サービス名称));
                dataSourceList.add(dataSource);
            }
            div.getKagoMoshitatePanel().getDropDownList7().setDataSource(dataSourceList);
            div.getKagoMoshitatePanel().getDropDownList7().setIsBlankLine(true);
        }
        dgHihokenshaSearchGaitosha_Row row = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow();
        div.getKagoMoshitatePanel().getTextBox2().setValue(row.getTxtJigyoshaNo());
        div.getKagoMoshitatePanel().getTextBox3().setValue(row.getTxtJigyoshaName());
        div.getKagoMoshitatePanel().getTextBox5().setValue(row.getTxtTeikyoYM());
        div.getKagoMoshitatePanel().getTextBox7().setValue(row.getTxtShokisaiNo());
        div.setHdn履歴番号(new RString(ONE));
        set申立理由DDL();
        set申立対象項目DDL();
        set申立者区分DDL();
        SaishinsaMoshitateTourokuCollect collect = DataPassingConverter.deserialize(
                div.getHdn一覧検索条件(),
                SaishinsaMoshitateTourokuCollect.class);
        int activeRowId = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getId();
        div.setHdnActiveRowId(new RString(activeRowId));
        if (登録モード.equals(画面モード)) {
            KyufuJissekiGaitoshaBusiness 給付実績情報 = collect.get給付実績情報List().get(activeRowId);
            AccessLogger.log(AccessLogType.照会, toPersonalData(
                    new ShikibetsuCode(給付実績情報.get識別コード()),
                    new HihokenshaNo(被保険者番号)));
            div.getKagoMoshitatePanel().getCommonKaigpAtenainfoChildDiv1().initialize(
                    new ShikibetsuCode(給付実績情報.get識別コード()));
            div.setHdn識別コード(給付実績情報.get識別コード());
            div.getKagoMoshitatePanel().getTextBox11().setValue(給付実績情報.get証記載保険者名());
            div.getKagoMoshitatePanel().getRadioButton1().setSelectedIndex(ZERO);
            div.getKagoMoshitatePanel().getDropDownList3().setSelectedIndex(ZERO);
            div.getKagoMoshitatePanel().getDropDownList6().setSelectedIndex(ZERO);
            div.getKagoMoshitatePanel().getDropDownList7().setSelectedIndex(ZERO);
            div.getTextBoxDate1().setReadOnly(false);
            div.getTextBox12().setReadOnly(false);
            div.getDropDownList2().setReadOnly(false);
            div.getDropDownList4().setReadOnly(false);
            div.getDropDownList5().setReadOnly(false);
            div.getKagoMoshitatePanel().getDropDownList3().setReadOnly(false);
            div.getKagoMoshitatePanel().getDropDownList6().setReadOnly(true);
            div.getKagoMoshitatePanel().getDropDownList7().setReadOnly(true);
            div.getKagoMoshitatePanel().getDropDownList2().setSelectedIndex(ZERO);
            div.getKagoMoshitatePanel().getDropDownList4().setSelectedIndex(ZERO);
            div.getKagoMoshitatePanel().getDropDownList5().setSelectedIndex(ZERO);
            div.getKagoMoshitatePanel().getTextBoxDate1().setValue(null);
            div.getKagoMoshitatePanel().getTextBox12().setValue(RString.EMPTY);
            div.getKagoMoshitatePanel().getCheckBoxList1().setSelectedItemsByKey(new ArrayList());
            if (RString.isNullOrEmpty(div.getKagoMoshitatePanel().getTextBox6().getValue())) {
                div.getKagoMoshitatePanel().getCheckBoxList1().setReadOnly(true);
            } else {
                div.getKagoMoshitatePanel().getCheckBoxList1().setReadOnly(false);
            }
            div.setHdn画面モード(登録モード);
        } else {
            SaishinsaMoshitateJohoBusiness 再審査申立情報 = collect.get再審査申立情報List().get(activeRowId);
            AccessLogger.log(AccessLogType.照会, toPersonalData(
                    new ShikibetsuCode(再審査申立情報.get識別コード()), new HihokenshaNo(被保険者番号)));
            div.getKagoMoshitatePanel().getCommonKaigpAtenainfoChildDiv1().initialize(
                    new ShikibetsuCode(再審査申立情報.get識別コード()));
            div.setHdn識別コード(再審査申立情報.get識別コード());
            if (!RString.isNullOrEmpty(再審査申立情報.get国保連送付年月())) {
                div.getKagoMoshitatePanel().getTextBox6().setValue(new FlexibleYearMonth(再審査申立情報.get国保連送付年月())
                        .wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
            }
            div.getKagoMoshitatePanel().getTextBox11().setValue(再審査申立情報.get証記載保険者名());
            div.getDropDownList3().setIsBlankLine(true);
            div.getDropDownList6().setIsBlankLine(true);
            div.getDropDownList7().setIsBlankLine(true);
            if (特定診療費.equals(再審査申立情報.get申立事由コード().substring(ZERO, TWO))) {
                setDDLSelectedByKey(div.getKagoMoshitatePanel().getDropDownList7(), 再審査申立情報.getサービス種類コード()
                        .concat(再審査申立情報.getサービス項目コード()));
            } else if (RString.isNullOrEmpty(再審査申立情報.getサービス項目コード())) {
                setDDLSelectedByKey(div.getKagoMoshitatePanel().getDropDownList3(), 再審査申立情報.getサービス種類コード()
                        .concat(FOUR_SPACES));
            } else if (!RString.isNullOrEmpty(再審査申立情報.getサービス項目コード())) {
                setDDLSelectedByKey(div.getKagoMoshitatePanel().getDropDownList6(), 再審査申立情報.getサービス種類コード()
                        .concat(再審査申立情報.getサービス項目コード()));
            }
            div.getKagoMoshitatePanel().getTextBoxDate1().setValue(new RDate(再審査申立情報.get申立年月日().toString()));
            div.getKagoMoshitatePanel().getDropDownList2().setSelectedKey(再審査申立情報.get申立者区分コード());
            div.getKagoMoshitatePanel().getTextBox12().setValue(再審査申立情報.get申立単位数());
            div.getKagoMoshitatePanel().getDropDownList4().setSelectedKey(再審査申立情報.get申立事由コード().substring(ZERO, TWO));
            List<RString> keys = new ArrayList();
            if (TRUE.equals(再審査申立情報.get国保連再送付有フラグ())) {
                keys.add(KEY0);
            }
            div.getKagoMoshitatePanel().getCheckBoxList1().setSelectedItemsByKey(keys);
            div.getKagoMoshitatePanel().getDropDownList5().setSelectedKey(再審査申立情報.get申立事由コード().substring(TWO));
            div.setHdn履歴番号(再審査申立情報.get履歴番号());
            setState再審査申立書登録表示初期化(再審査申立情報, 画面モード);
        }
    }

    /**
     * 保険者リストを設定します。
     */
    public void set保険者リスト() {
        if (is広域保険者()) {
            div.getSearchToKyufujissekiPanel().getHokenshaList().loadHokenshaList();
            div.getSearchToKyufujissekiPanel().getHokenshaList().setDisplayNone(false);
        } else {
            div.getSearchToKyufujissekiPanel().getHokenshaList().setDisplayNone(true);
        }
    }

    /**
     * 保険者リストを設定します。
     *
     * @return 保険者リストの値
     */
    public RString get保険者リストの値() {
        if (is広域保険者()) {
            return div.getSearchToKyufujissekiPanel().getHokenshaList().getSelectedItem().get市町村コード().value();
        } else {
            return null;
        }
    }

    /**
     * 保険者番号の選択値を取得します。
     *
     * @param 原始保険者番号 原始保険者番号
     * @return 保険者番号の選択値
     */
    public RString get保険者番号の選択値(RString 原始保険者番号) {
        RString 保険者番号の選択値 = null;
        if (is広域保険者()) {
            if (RString.isNullOrEmpty(原始保険者番号)) {
                保険者番号の選択値 = 広域保険者番号;
            } else {
                保険者番号の選択値 = 原始保険者番号;
            }
        }
        return 保険者番号の選択値;
    }

    /**
     * 広域保険者の判定です。
     *
     * @return 広域保険者かどうか
     */
    public boolean is広域保険者() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString loginUserId = controlData.getLoginInfo().getUserId();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho
                .getShichosonSecurityJoho(GyomuBunrui.介護事務, loginUserId);
        return DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value());
    }

    /**
     * 入力の検索条件と検索結果一覧を一時保存します。
     *
     * @param 再審査申立情報一覧 再審査申立情報一覧
     * @param 給付実績一覧 給付実績該当者一覧
     */
    public void set一時検索条件(
            List<SaishinsaMoshitateJohoBusiness> 再審査申立情報一覧,
            List<KyufuJissekiGaitoshaBusiness> 給付実績一覧) {
        SaishinsaMoshitateTourokuCollect collect = new SaishinsaMoshitateTourokuCollect();
        collect.set被保険者番号(div.getSearchToKyufujissekiPanel().getTxtHihoNo().getValue());
        collect.set事業所番号(div.getCcdJigyoshaSentaku().getNyuryokuShisetsuKodo());
        collect.set保険者番号(get保険者リストの値());
        if (div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getFromValue() != null) {
            collect.set提供年月開始(div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getFromValue()
                    .getYearMonth().toDateString());
        }
        if (div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getToValue() != null) {
            collect.set提供年月終了(div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getToValue()
                    .getYearMonth().toDateString());
        }
        collect.set再審査申立情報List(再審査申立情報一覧);
        collect.set給付実績情報List(給付実績一覧);
        if (再審査申立情報一覧 != null) {
            collect.set一覧モード(再審査申立情報一覧モード);
        } else if (給付実績一覧 != null) {
            collect.set一覧モード(給付実績該当者一覧モード);
        }
        div.setHdn一覧検索条件(DataPassingConverter.serialize(collect));
    }

    /**
     * 画面情報をクリアします。
     */
    public void clear() {
        div.getTextBox2().clearValue();
        div.getTextBox3().clearValue();
        div.getTextBox5().clearValue();
        div.getTextBox6().clearValue();
        div.getTextBox7().clearValue();
        div.getTextBox11().clearValue();
        div.getTextBox12().clearValue();
        div.getRadioButton1().clearSelectedItem();
        div.getTextBoxDate1().clearValue();
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(
                new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

    private void setDDLSelectedByKey(DropDownList ddl, RString value) {
        if (!ddl.getDataSource().isEmpty()) {
            ddl.setSelectedKey(value);
        }
    }

    private void setState再審査申立書登録表示初期化(SaishinsaMoshitateJohoBusiness 再審査申立情報, RString 画面モード) {
        if (修正モード.equals(画面モード)) {
            div.getTextBoxDate1().setReadOnly(false);
            div.getTextBox12().setReadOnly(false);
            div.getDropDownList2().setReadOnly(false);
            div.getDropDownList4().setReadOnly(false);
            div.getDropDownList5().setReadOnly(false);
            if (RString.isNullOrEmpty(div.getKagoMoshitatePanel().getTextBox6().getValue())) {
                div.getKagoMoshitatePanel().getCheckBoxList1().setReadOnly(true);
            } else {
                div.getKagoMoshitatePanel().getCheckBoxList1().setReadOnly(false);
            }
            if (特定診療費.equals(再審査申立情報.get申立事由コード().substring(ZERO, TWO))) {
                div.getKagoMoshitatePanel().getDropDownList3().setReadOnly(true);
                div.getKagoMoshitatePanel().getDropDownList6().setReadOnly(true);
                div.getKagoMoshitatePanel().getDropDownList7().setReadOnly(false);
            } else if (RString.isNullOrEmpty(再審査申立情報.getサービス項目コード())) {
                div.getKagoMoshitatePanel().getDropDownList3().setReadOnly(false);
                div.getKagoMoshitatePanel().getDropDownList6().setReadOnly(true);
                div.getKagoMoshitatePanel().getDropDownList7().setReadOnly(true);
            } else if (!RString.isNullOrEmpty(再審査申立情報.getサービス項目コード())) {
                div.getKagoMoshitatePanel().getDropDownList3().setReadOnly(true);
                div.getKagoMoshitatePanel().getDropDownList6().setReadOnly(false);
                div.getKagoMoshitatePanel().getDropDownList7().setReadOnly(true);
            }
            div.setHdn画面モード(修正モード);
        } else {
            div.getKagoMoshitatePanel().getTextBoxDate1().setReadOnly(true);
            div.getKagoMoshitatePanel().getDropDownList2().setReadOnly(true);
            div.getKagoMoshitatePanel().getTextBox12().setReadOnly(true);
            div.getKagoMoshitatePanel().getDropDownList4().setReadOnly(true);
            div.getKagoMoshitatePanel().getDropDownList5().setReadOnly(true);
            div.getKagoMoshitatePanel().getCheckBoxList1().setReadOnly(true);
            div.getKagoMoshitatePanel().getDropDownList3().setReadOnly(true);
            div.getKagoMoshitatePanel().getDropDownList6().setReadOnly(true);
            div.getKagoMoshitatePanel().getDropDownList7().setReadOnly(true);
            div.setHdn画面モード(削除モード);
        }
        if (特定診療費.equals(再審査申立情報.get申立事由コード().substring(ZERO, TWO))) {
            div.getKagoMoshitatePanel().getRadioButton1().setSelectedIndex(TWO);
        } else if (RString.isNullOrEmpty(再審査申立情報.getサービス項目コード())) {
            div.getKagoMoshitatePanel().getRadioButton1().setSelectedIndex(ZERO);
        } else if (!RString.isNullOrEmpty(再審査申立情報.getサービス項目コード())) {
            div.getKagoMoshitatePanel().getRadioButton1().setSelectedIndex(ONE);
        }
    }

    private void set申立理由DDL() {
        List<KeyValueDataSource> 申立理由DateSource = new ArrayList<>();
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(
                SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.再審査申立事由コード_下２桁_申立理由番号.getコード(),
                FlexibleDate.getNowDate());
        for (UzT0007CodeEntity entity : codeList) {
            RStringBuilder 申立理由 = new RStringBuilder();
            申立理由.append(entity.getコード().value());
            申立理由.append(COLON);
            申立理由.append(entity.getコード名称());
            申立理由DateSource.add(new KeyValueDataSource(entity.getコード().value(), 申立理由.toRString()));
        }
        div.getKagoMoshitatePanel().getDropDownList5().setDataSource(申立理由DateSource);
        div.getKagoMoshitatePanel().getDropDownList5().setIsBlankLine(true);
    }

    private void set申立対象項目DDL() {
        List<KeyValueDataSource> 申立対象項目DateSource = new ArrayList<>();
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(
                SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.再審査申立事由コード_上２桁_申立対象項目コード.getコード(),
                FlexibleDate.getNowDate());
        for (UzT0007CodeEntity entity : codeList) {
            RStringBuilder 申立対象項目 = new RStringBuilder();
            申立対象項目.append(entity.getコード().value());
            申立対象項目.append(COLON);
            申立対象項目.append(entity.getコード名称());
            申立対象項目DateSource.add(new KeyValueDataSource(entity.getコード().value(), 申立対象項目.toRString()));
        }
        div.getKagoMoshitatePanel().getDropDownList4().setDataSource(申立対象項目DateSource);
        div.getKagoMoshitatePanel().getDropDownList4().setIsBlankLine(true);
    }

    private void set申立者区分DDL() {
        List<KeyValueDataSource> 申立者区分DateSource = new ArrayList<>();
        for (KagoMoshitate_MoshitateshaKubun kagoMoshitateEnum : KagoMoshitate_MoshitateshaKubun.values()) {
            RStringBuilder 申立者区分 = new RStringBuilder();
            申立者区分.append(kagoMoshitateEnum.getコード());
            申立者区分.append(COLON);
            申立者区分.append(kagoMoshitateEnum.get名称());
            申立者区分DateSource.add(new KeyValueDataSource(kagoMoshitateEnum.getコード(), 申立者区分.toRString()));
        }
        div.getKagoMoshitatePanel().getDropDownList2().setDataSource(申立者区分DateSource);
        div.getKagoMoshitatePanel().getDropDownList2().setIsBlankLine(true);
    }
}
