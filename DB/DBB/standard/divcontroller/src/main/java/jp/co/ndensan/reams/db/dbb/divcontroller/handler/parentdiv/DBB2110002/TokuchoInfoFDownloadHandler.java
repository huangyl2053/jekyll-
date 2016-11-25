/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2110002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchoinfofdownloadinfo.TokuchoInfoFDownloadInfo;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002.TokuchoInfoFDownloadDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002.dgShoriKakunin_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002.dgTsukiShoriSelect_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002.dgkoikiShoriSelect_Row;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoinfoshoridatekanri.TokuchoInfoShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBB2110002_特徴送付情報ダウンロードのクラスです。
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class TokuchoInfoFDownloadHandler {

    private final TokuchoInfoFDownloadDiv div;
    private static final RString STR_00 = new RString("00");
    private static final RString KEY0 = new RString("key0");
    private static final RString 特徴異動情報作成 = new RString("特徴異動情報作成");
    private static final RString 特徴依頼情報作成 = new RString("特徴依頼情報作成");
    private static final RString SPACE = new RString(" ");
    private static final RString STR_月 = new RString("月");
    private static final RString 月_1 = new RString("1月");
    private static final RString 月_2 = new RString("2月");
    private static final RString 月_3 = new RString("3月");
    private static final RString 月_4 = new RString("4月");
    private static final RString 月_5 = new RString("5月");
    private static final RString 月_6 = new RString("6月");
    private static final RString 月_7 = new RString("7月");
    private static final RString 月_8 = new RString("8月");
    private static final RString 月_9 = new RString("9月");
    private static final RString 月_10 = new RString("10月");
    private static final RString 月_11 = new RString("11月");
    private static final RString 月_12 = new RString("12月");
    private static final int INT_0 = 0;
    private static final int INT_6 = 6;
    private static final int INT_4 = 4;
    private static final RString STR_済 = new RString("済");
    private static final RString STR_1 = new RString("1");
    private static final RString STR_2 = new RString("2");
    private static final RString STR_3 = new RString("3");
    private static final RString STR_4 = new RString("4");
    private static final RString STR_5 = new RString("5");
    private static final RString STR_6 = new RString("6");
    private static final RString STR_7 = new RString("7");
    private static final RString STR_8 = new RString("8");
    private static final RString STR_9 = new RString("9");
    private static final RString STR_01 = new RString("01");
    private static final RString STR_02 = new RString("02");
    private static final RString STR_03 = new RString("03");
    private static final RString STR_04 = new RString("04");
    private static final RString STR_05 = new RString("05");
    private static final RString STR_06 = new RString("06");
    private static final RString STR_07 = new RString("07");
    private static final RString STR_08 = new RString("08");
    private static final RString STR_09 = new RString("09");
    private static final RString STR_10 = new RString("10");
    private static final RString STR_11 = new RString("11");
    private static final RString STR_12 = new RString("12");
    private static final RString STR_0001 = new RString("0001");
    private static final RString STR_0002 = new RString("0002");
    private static final RString STR_0003 = new RString("0003");
    private static final RString STR_0004 = new RString("0004");
    private static final RString STR_0005 = new RString("0005");
    private static final RString STR_0006 = new RString("0006");
    private static final RString STR_0007 = new RString("0007");
    private static final RString STR_0008 = new RString("0008");
    private static final RString STR_0009 = new RString("0009");
    private static final RString STR_0010 = new RString("0010");
    private static final RString STR_0011 = new RString("0011");
    private static final RString STR_0012 = new RString("0012");
    private static final RString ダウンロードボタン = new RString("btnTsukiShiteiDownLoad");

    /**
     * コンストラクタです。
     *
     * @param div TokuchoInfoFDownloadDiv
     */
    public TokuchoInfoFDownloadHandler(TokuchoInfoFDownloadDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     */
    public void initialize() {
        RDate 調定年度 = new RDate(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課).toString());
        FlexibleYear year = new FlexibleYear(調定年度.getYear().toDateString());
        div.getTokuchoInfoDownloadShoriNaiyo().getTxtShoriNendo().setValue(調定年度);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().getKey();
        List<AuthorityItem> authorityItem = ShichosonSecurityJoho.getShichosonShikibetsuId(
                ControlDataHolder.getUserId());
        AuthorityItem 市町村識別ID = null;
        if (authorityItem != null && !authorityItem.isEmpty()) {
            市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(
                    ControlDataHolder.getUserId()).get(INT_0);
        }
        処理対象月制御();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            if (市町村識別ID != null) {
                市町村制御(市町村識別ID.getItemId());
            }
            div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().setDisabled(true);
            RString selectKey = div.getShoriTaishoShichoshonTsuki().getDdlShichosonSelect().getSelectedKey();
            市町村処理対象グリッド設定(selectKey);
            市町村処理状況グリッド設定(selectKey, year);
        } else {
            div.getTokuchoInfoDownloadShoriNaiyo().getRadShichosonSelect().setVisible(false);
            div.getTokuchoInfoDownloadShoriNaiyo().getDdlShichosonSelect().setVisible(false);
            div.getTokuchoInfoDownloadShoriNaiyo().getRadTsukiSelect().setSelectedKey(KEY0);
            単一処理対象グリッド設定();
            単一処理状況グリッド設定(year);
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(ダウンロードボタン, true);
    }

    private void 市町村処理状況グリッド設定(RString 市町村ID, FlexibleYear year) {
        List<RString> 状況済月 = TokuchoInfoShoriDateKanri.createInstance().get状況済月();
        Map<RString, RString> 処理月Map = get処理月Map();
        List<dgShoriKakunin_Row> 処理状況Rows = new ArrayList<>();
        List<RString> 処理月List = get処理状況グリッド処理月List();
        for (RString 処理月 : 処理月List) {
            dgShoriKakunin_Row row = new dgShoriKakunin_Row();
            row.getTxtTsuki().setValue(処理月);
            if (月_7.equals(処理月)) {
                row.getTxtShoriMei().setValue(特徴依頼情報作成);
            } else {
                row.getTxtShoriMei().setValue(特徴異動情報作成);
            }
            row.getTxtShoriNichiji().setValue(get市町村ID処理日付(市町村ID, year));
            if (状況済月.contains(処理月Map.get(処理月))) {
                row.getTxtJokyo().setValue(STR_済);
            } else {
                row.getTxtJokyo().setValue(RString.EMPTY);
            }
            処理状況Rows.add(row);
        }
        div.getTokuchoInfoDownloadShoriKakunin().getDgShoriKakunin().setDataSource(処理状況Rows);
    }

    private void 単一処理状況グリッド設定(FlexibleYear year) {
        List<RString> 状況済月 = TokuchoInfoShoriDateKanri.createInstance().get状況済月();
        Map<RString, RString> 処理月Map = get処理月Map();
        List<dgShoriKakunin_Row> 処理状況Rows = new ArrayList<>();
        List<RString> 処理月List = get処理状況グリッド処理月List();
        for (RString 処理月 : 処理月List) {
            dgShoriKakunin_Row row = new dgShoriKakunin_Row();
            row.getTxtTsuki().setValue(処理月);
            if (月_7.equals(処理月)) {
                row.getTxtShoriMei().setValue(特徴依頼情報作成);
            } else {
                row.getTxtShoriMei().setValue(特徴異動情報作成);
            }
            row.getTxtShoriNichiji().setValue(get単一月処理日付(year));
            if (状況済月.contains(処理月Map.get(処理月))) {
                row.getTxtJokyo().setValue(STR_済);
            } else {
                row.getTxtJokyo().setValue(RString.EMPTY);
            }
            処理状況Rows.add(row);
        }
        div.getTokuchoInfoDownloadShoriKakunin().getDgShoriKakunin().setDataSource(処理状況Rows);
    }

    private RString get市町村ID処理日付(RString 市町村ID, FlexibleYear year) {
        List<RString> 処理名List = new ArrayList<>();
        処理名List.add(ShoriName.特徴異動情報作成.get名称());
        処理名List.add(ShoriName.特徴依頼情報作成.get名称());
        ShoriDateKanri shoriDateKanri = TokuchoInfoShoriDateKanri.createInstance().
                get市町村処理日付(year, new RString(STR_00.toString() + 市町村ID.toString()), 処理名List);
        return get処理日時パターン(shoriDateKanri);
    }

    private RString get単一月処理日付(FlexibleYear year) {
        RString 処理名;
        RString 年度内連番;
        Map<RString, RString> 処理月Map = get処理状況グリッド処理月();
        RString 選択月 = div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().getSelectedValue();
        if (STR_7.equals(div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().getSelectedKey())) {
            処理名 = ShoriName.特徴依頼情報作成.get名称();
            年度内連番 = STR_0001;
        } else {
            処理名 = ShoriName.特徴異動情報作成.get名称();
            年度内連番 = 処理月Map.get(選択月);
        }
        ShoriDateKanri shoriDateKanri = TokuchoInfoShoriDateKanri.createInstance().
                get単一処理日付(処理名, year, 年度内連番);
        return get処理日時パターン(shoriDateKanri);
    }

    private void 単一処理対象グリッド設定() {
        List<TokuchoInfoFDownloadInfo> ファイル対象List = TokuchoInfoShoriDateKanri.createInstance().getファイル対象();
        List<RString> 状況済月 = TokuchoInfoShoriDateKanri.createInstance().get状況済月();
        List<dgTsukiShoriSelect_Row> 単一Rows = new ArrayList<>();
        for (TokuchoInfoFDownloadInfo ファイル対象 : ファイル対象List) {
            dgTsukiShoriSelect_Row row = new dgTsukiShoriSelect_Row();
            row.getTxtFileMei().setValue(ファイル対象.getファイル名());
            row.getTxtSakuseiInfoName().setValue(ファイル対象.get情報名());
            RDate 作成日 = ファイル対象.get作成日時().getDate();
            RTime 作成時 = ファイル対象.get作成日時().getTime();
            row.getTxtZenSakuseiNichiji().setValue(new RString(
                    作成日.wareki().toDateString().toString() + SPACE
                    + 作成時.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
            row.getTxtMonth().setValue(new RString(作成日.getMonthValue()).concat(STR_月));
            row.getTxtSakuseiTime().setValue(new RString(ファイル対象.get作成日時().toString()));
            RString 月 = 作成日.toDateString().substring(INT_4, INT_6);
            if (状況済月.contains(月) && ファイル対象.isファイル存在()) {
                row.setSelectable(Boolean.TRUE);
            } else {
                row.setSelectable(Boolean.FALSE);
            }
            単一Rows.add(row);
        }
        div.getTsukiShoriSelect().getDgTsukiShoriSelect().setDataSource(単一Rows);
    }

    private void 市町村処理対象グリッド設定(RString 市町村ID) {
        List<TokuchoInfoFDownloadInfo> ファイル対象List = TokuchoInfoShoriDateKanri.createInstance().getファイル対象By市町村(市町村ID);
        List<RString> 状況済月 = TokuchoInfoShoriDateKanri.createInstance().get状況済月();
        List<dgTsukiShoriSelect_Row> 広域Rows = new ArrayList<>();
        for (TokuchoInfoFDownloadInfo ファイル対象 : ファイル対象List) {
            dgTsukiShoriSelect_Row row = new dgTsukiShoriSelect_Row();
            row.getTxtFileMei().setValue(ファイル対象.getファイル名());
            row.getTxtSakuseiInfoName().setValue(ファイル対象.get情報名());
            RDate 作成日 = ファイル対象.get作成日時().getDate();
            RTime 作成時 = ファイル対象.get作成日時().getTime();
            row.getTxtZenSakuseiNichiji().setValue(new RString(
                    作成日.wareki().toDateString().toString() + SPACE
                    + 作成時.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
            row.getTxtMonth().setValue(new RString(作成日.getMonthValue()).concat(STR_月));
            row.getTxtSakuseiTime().setValue(new RString(ファイル対象.get作成日時().toString()));
            RString 月 = 作成日.toDateString().substring(INT_4, INT_6);
            if (状況済月.contains(月) && ファイル対象.isファイル存在()) {
                row.setSelectable(Boolean.TRUE);
            } else {
                row.setSelectable(Boolean.FALSE);
            }
            広域Rows.add(row);
        }
        div.getTsukiShoriSelect().getDgTsukiShoriSelect().setDataSource(広域Rows);
    }

    private void 月処理対象グリッド設定() {
        RString 選択月 = div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().getSelectedKey();
        List<TokuchoInfoFDownloadInfo> ファイル対象List = TokuchoInfoShoriDateKanri.createInstance().getファイル対象();
        List<RString> 状況済月 = TokuchoInfoShoriDateKanri.createInstance().get状況済月();
        List<dgkoikiShoriSelect_Row> 広域Rows = new ArrayList<>();
        for (TokuchoInfoFDownloadInfo ファイル対象 : ファイル対象List) {
            RDate 作成日 = ファイル対象.get作成日時().getDate();
            if (!選択月.equals(new RString(作成日.getMonthValue()))) {
                continue;
            }
            dgkoikiShoriSelect_Row row = new dgkoikiShoriSelect_Row();
            RString ファイル名 = ファイル対象.getファイル名();
            row.getTxtFileMei().setValue(ファイル名);
            row.getTxtSakuseiInfoName().setValue(ファイル対象.get情報名());
            RTime 作成時 = ファイル対象.get作成日時().getTime();
            row.getTxtZenSakuseiNichiji().setValue(new RString(
                    作成日.wareki().toDateString().toString() + SPACE
                    + 作成時.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
            row.getTxtMonth().setValue(new RString(作成日.getMonthValue()).concat(STR_月));
            row.getTxtSakuseiTime().setValue(new RString(ファイル対象.get作成日時().toString()));
            RString 市町村識別ID = ファイル名.substring(ファイル名.length() - INT_6, ファイル名.length() - INT_4);
            KoseiShichosonJoho 市町村 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID);
            if (市町村 != null) {
                row.getTxtCityCode().setValue(市町村.get市町村コード().value());
                row.getTxtCityName().setValue(市町村.get市町村名称());
            }
            RString 月 = 作成日.toDateString().substring(INT_4, INT_6);
            if (状況済月.contains(月) && ファイル対象.isファイル存在()) {
                row.setSelectable(Boolean.TRUE);
            } else {
                row.setSelectable(Boolean.FALSE);
            }
            広域Rows.add(row);
        }
        div.getKoikiShoriSelect().getDgkoikiShoriSelect().setDataSource(広域Rows);
    }

    private void 市町村制御(RString 市町村識別ID) {
        List<KeyValueDataSource> 市町村DataSourceList = new ArrayList<>();
        if (!STR_00.equals(市町村識別ID)) {
            ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
            if (市町村セキュリティ情報 != null) {
                RString 市町村ID = 市町村セキュリティ情報.get市町村情報().get市町村識別ID();
                RString コード名称 = new RString(市町村セキュリティ情報.get市町村情報().get市町村コード().getColumnValue().toString()
                        + SPACE.toString() + 市町村セキュリティ情報.get市町村情報().get市町村名称().toString());
                市町村DataSourceList.add(new KeyValueDataSource(市町村ID, コード名称));
            }
            div.getShoriTaishoShichoshonTsuki().getDdlShichosonSelect().setDataSource(市町村DataSourceList);
            if (!市町村DataSourceList.isEmpty()) {
                div.getShoriTaishoShichoshonTsuki().getDdlShichosonSelect().setSelectedIndex(INT_0);
            }
            return;
        }
        List<KoikiZenShichosonJoho> 構成市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
        List<RString> 市町村IDList = new ArrayList<>();
        if (構成市町村List != null && !構成市町村List.isEmpty()) {
            for (KoikiZenShichosonJoho 構成市町村 : 構成市町村List) {
                RString 市町村ID = 構成市町村.get市町村識別ID();
                if (市町村IDList.contains(市町村ID)) {
                    continue;
                }
                市町村IDList.add(市町村ID);
                RString コード名称 = new RString(構成市町村.get市町村コード().getColumnValue().toString()
                        + SPACE.toString() + 構成市町村.get市町村名称().toString());
                市町村DataSourceList.add(new KeyValueDataSource(市町村ID, コード名称));
            }
        }
        div.getShoriTaishoShichoshonTsuki().getDdlShichosonSelect().setDataSource(市町村DataSourceList);
        if (!市町村DataSourceList.isEmpty()) {
            div.getShoriTaishoShichoshonTsuki().getDdlShichosonSelect().setSelectedIndex(INT_0);
        }
    }

    private List<RString> get構成市町村IDList() {
        List<RString> 市町村識別IDList = new ArrayList<>();
        List<KoikiZenShichosonJoho> 構成市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
        if (構成市町村List != null && !構成市町村List.isEmpty()) {
            for (KoikiZenShichosonJoho 構成市町村 : 構成市町村List) {
                市町村識別IDList.add(構成市町村.get市町村識別ID());
            }
        }
        return 市町村識別IDList;
    }

    private void 処理対象月制御() {
        div.getShoriTaishoShichoshonTsuki().getDdlTsuki().setDataSource(get処理対象月DataSource());
        int 選択月 = RDate.getNowDate().getMonthValue();
        div.getShoriTaishoShichoshonTsuki().getDdlTsuki().setSelectedKey(new RString(選択月));
    }

    private List<KeyValueDataSource> get処理対象月DataSource() {
        List<KeyValueDataSource> keiyakuServiceShuruiList = new ArrayList<>();
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_4, 月_4));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_5, 月_5));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_6, 月_6));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_7, 月_7));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_8, 月_8));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_9, 月_9));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_10, 月_10));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_11, 月_11));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_12, 月_12));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_1, 月_1));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_2, 月_2));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_3, 月_3));
        return keiyakuServiceShuruiList;
    }

    private Map<RString, RString> get処理状況グリッド処理月() {
        Map<RString, RString> 処理月Map = new HashMap<>();
        処理月Map.put(月_4, STR_0001);
        処理月Map.put(月_5, STR_0002);
        処理月Map.put(月_6, STR_0003);
        処理月Map.put(月_7, STR_0004);
        処理月Map.put(月_8, STR_0005);
        処理月Map.put(月_9, STR_0006);
        処理月Map.put(月_10, STR_0007);
        処理月Map.put(月_11, STR_0008);
        処理月Map.put(月_12, STR_0009);
        処理月Map.put(月_1, STR_0010);
        処理月Map.put(月_2, STR_0011);
        処理月Map.put(月_3, STR_0012);
        return 処理月Map;
    }

    private List<RString> get処理状況グリッド処理月List() {
        List<RString> 処理月List = new ArrayList<>();
        処理月List.add(月_4);
        処理月List.add(月_5);
        処理月List.add(月_6);
        処理月List.add(月_7);
        処理月List.add(月_8);
        処理月List.add(月_9);
        処理月List.add(月_10);
        処理月List.add(月_11);
        処理月List.add(月_12);
        処理月List.add(月_1);
        処理月List.add(月_2);
        処理月List.add(月_3);
        return 処理月List;
    }

    private RString get処理日時パターン(ShoriDateKanri shoriDateKanri) {
        if (shoriDateKanri == null || shoriDateKanri.get基準日時() == null) {
            return RString.EMPTY;
        }
        YMDHMS 基準日時 = shoriDateKanri.get基準日時();
        if (基準日時.isEmpty()) {
            return RString.EMPTY;
        }
        RDate 年月日 = 基準日時.getDate();
        RTime 時刻 = 基準日時.getRDateTime().getTime();
        RString 前回処理日時 = new RString(年月日.wareki().toDateString().toString() + SPACE
                + 時刻.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        return 前回処理日時;
    }

    /**
     * 「処理対象市町村」の切替のメソッドです。
     *
     */
    public void 処理対象市町村切替() {
        if (!KEY0.equals(div.getTokuchoInfoDownloadShoriNaiyo().
                getRadShichosonSelect().getSelectedKey())) {
            return;
        }
        div.getTokuchoInfoDownloadShoriNaiyo().getRadTsukiSelect().clearSelectedItem();
        div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().setDisabled(true);
        div.getTokuchoInfoDownloadShoriNaiyo().getDdlShichosonSelect().setDisabled(false);
        RString 市町村Id = div.getTokuchoInfoDownloadShoriNaiyo().getDdlShichosonSelect().getSelectedKey();
        if (RString.isNullOrEmpty(市町村Id)) {
            return;
        }
        RDate 処理年度 = div.getTokuchoInfoDownloadShoriNaiyo().getTxtShoriNendo().getValue();
        FlexibleYear year = new FlexibleYear(処理年度.getYear().toDateString());
        市町村処理状況グリッド設定(市町村Id, year);
        市町村処理対象グリッド設定(市町村Id);
    }

    /**
     * 「処理対象月」の切替のメソッドです。
     *
     */
    public void 処理対象月切替() {
        if (!KEY0.equals(div.getTokuchoInfoDownloadShoriNaiyo().
                getRadTsukiSelect().getSelectedKey())) {
            return;
        }
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().getKey();
        if (!DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            RDate 調定年度 = new RDate(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                    SubGyomuCode.DBB介護賦課).toString());
            FlexibleYear year = new FlexibleYear(調定年度.getYear().toDateString());
            単一処理状況グリッド設定(year);
            return;
        }
        div.getTokuchoInfoDownloadShoriNaiyo().getRadShichosonSelect().clearSelectedItem();
        div.getTokuchoInfoDownloadShoriNaiyo().getDdlShichosonSelect().setDisabled(true);
        div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().setDisabled(false);
        RString 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(
                ControlDataHolder.getUserId()).get(INT_0).getItemId();
        RDate 処理年度 = div.getTokuchoInfoDownloadShoriNaiyo().getTxtShoriNendo().getValue();
        FlexibleYear year = new FlexibleYear(処理年度.getYear().toDateString());
        RString 処理名;
        RString 年度内連番;
        Map<RString, RString> 処理月Map = get処理状況グリッド処理月();
        RString 選択月 = div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().getSelectedValue();
        if (STR_7.equals(div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().getSelectedKey())) {
            処理名 = ShoriName.特徴依頼情報作成.get名称();
            年度内連番 = STR_0001;
        } else {
            処理名 = ShoriName.特徴異動情報作成.get名称();
            年度内連番 = 処理月Map.get(選択月);
        }
        RString 処理日時;
        if (!STR_00.equals(市町村識別ID)) {
            ShoriDateKanri shoriDateKanri = TokuchoInfoShoriDateKanri.createInstance().get月処理日付(year, 処理名, 年度内連番,
                    new RString(STR_00.toString() + 市町村識別ID.toString()));
            処理日時 = get処理日時パターン(shoriDateKanri);
        } else {
            List<RString> 市町村識別IDList = get構成市町村IDList();
            ShoriDateKanri shoriDateKanri = TokuchoInfoShoriDateKanri.createInstance().
                    get広域職員処理日付(year, 処理名, 年度内連番, 市町村識別IDList);
            処理日時 = get処理日時パターン(shoriDateKanri);
        }
        List<dgShoriKakunin_Row> 処理状況Rows = new ArrayList<>();
        List<RString> 処理月List = get処理状況グリッド処理月List();
        List<RString> 状況済月 = TokuchoInfoShoriDateKanri.createInstance().get状況済月();
        Map<RString, RString> map = get処理月Map();
        for (RString 処理月 : 処理月List) {
            dgShoriKakunin_Row row = new dgShoriKakunin_Row();
            row.getTxtTsuki().setValue(処理月);
            if (月_7.equals(処理月)) {
                row.getTxtShoriMei().setValue(特徴依頼情報作成);
            } else {
                row.getTxtShoriMei().setValue(特徴異動情報作成);
            }
            row.getTxtShoriNichiji().setValue(処理日時);
            if (状況済月.contains(map.get(処理月))) {
                row.getTxtJokyo().setValue(STR_済);
            } else {
                row.getTxtJokyo().setValue(RString.EMPTY);
            }
            処理状況Rows.add(row);
        }
        div.getTokuchoInfoDownloadShoriKakunin().getDgShoriKakunin().setDataSource(処理状況Rows);
        月処理対象グリッド設定();
    }

    /**
     * 「処理対象市町村DropdownListのonChangeメソッドです。
     *
     */
    public void 処理対象市町村onChange() {
        処理対象市町村切替();
    }

    /**
     * 処理対象月DropdownListのonChangeメソッドです。
     *
     */
    public void 処理対象月onChange() {
        処理対象月切替();
    }

    /**
     * ダウンロード取得メソッドです。
     *
     * @return TokuchoInfoFDownloadInfo
     */
    public TokuchoInfoFDownloadInfo getダウンロードFile() {
        if (div.getKoikiShoriSelect().getDgkoikiShoriSelect().getSelectedItems() != null
                && !div.getKoikiShoriSelect().getDgkoikiShoriSelect().getSelectedItems().isEmpty()) {
            TokuchoInfoFDownloadInfo ダウンロードInfo = new TokuchoInfoFDownloadInfo();
            dgkoikiShoriSelect_Row 選択row = div.getKoikiShoriSelect().getDgkoikiShoriSelect().getSelectedItems().get(INT_0);
            ダウンロードInfo.setファイル名(選択row.getTxtFileMei().getValue());
            RDateTime 作成日時 = TokuchoInfoShoriDateKanri.createInstance().
                    getダウンロードDateTime(選択row.getTxtFileMei().getValue(), 選択row.getTxtSakuseiTime().getValue());
            ダウンロードInfo.set作成日時(作成日時);
            return ダウンロードInfo;
        } else if (div.getTsukiShoriSelect().getDgTsukiShoriSelect().getSelectedItems() != null
                && !div.getTsukiShoriSelect().getDgTsukiShoriSelect().getSelectedItems().isEmpty()) {
            TokuchoInfoFDownloadInfo ダウンロードInfo = new TokuchoInfoFDownloadInfo();
            dgTsukiShoriSelect_Row 選択row = div.getTsukiShoriSelect().getDgTsukiShoriSelect().getSelectedItems().get(INT_0);
            ダウンロードInfo.setファイル名(選択row.getTxtFileMei().getValue());
            RDateTime 作成日時 = TokuchoInfoShoriDateKanri.createInstance().
                    getダウンロードDateTime(選択row.getTxtFileMei().getValue(), 選択row.getTxtSakuseiTime().getValue());
            ダウンロードInfo.set作成日時(作成日時);
            return ダウンロードInfo;
        }
        return null;
    }

    /**
     * 処理対象選択のonChangeメソッドです。
     *
     */
    public void onChange_dgkoikiShoriSelect() {
        List<dgkoikiShoriSelect_Row> 処理対象Rows = div.getKoikiShoriSelect().getDgkoikiShoriSelect().getSelectedItems();
        if (処理対象Rows.isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(ダウンロードボタン, true);
        } else {
            dgkoikiShoriSelect_Row 選択Row = div.getKoikiShoriSelect().getDgkoikiShoriSelect().getActiveRow();
            処理対象Rows.clear();
            処理対象Rows.add(選択Row);
            div.getKoikiShoriSelect().getDgkoikiShoriSelect().setSelectedItems(処理対象Rows);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(ダウンロードボタン, false);
        }
    }

    /**
     * 処理対象選択のonChangeメソッドです。
     *
     */
    public void onChange_dgTsukiShoriSelect() {
        List<dgTsukiShoriSelect_Row> 処理対象Rows = div.getTsukiShoriSelect().getDgTsukiShoriSelect().getSelectedItems();
        if (処理対象Rows.isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(ダウンロードボタン, true);
        } else {
            dgTsukiShoriSelect_Row 選択Row = div.getTsukiShoriSelect().getDgTsukiShoriSelect().getActiveRow();
            処理対象Rows.clear();
            処理対象Rows.add(選択Row);
            div.getTsukiShoriSelect().getDgTsukiShoriSelect().setSelectedItems(処理対象Rows);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(ダウンロードボタン, false);
        }
    }

    private Map<RString, RString> get処理月Map() {
        Map<RString, RString> 処理月Map = new HashMap<>();
        処理月Map.put(月_4, STR_04);
        処理月Map.put(月_5, STR_05);
        処理月Map.put(月_6, STR_06);
        処理月Map.put(月_7, STR_07);
        処理月Map.put(月_8, STR_08);
        処理月Map.put(月_9, STR_09);
        処理月Map.put(月_10, STR_10);
        処理月Map.put(月_11, STR_11);
        処理月Map.put(月_12, STR_12);
        処理月Map.put(月_1, STR_01);
        処理月Map.put(月_2, STR_02);
        処理月Map.put(月_3, STR_03);
        return 処理月Map;
    }
}
