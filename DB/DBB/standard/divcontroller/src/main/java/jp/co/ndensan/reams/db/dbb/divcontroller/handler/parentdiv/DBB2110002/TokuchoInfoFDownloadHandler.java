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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 画面設計_DBB2110002_特徴送付情報ダウンロードのクラスです。
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class TokuchoInfoFDownloadHandler {

    private final TokuchoInfoFDownloadDiv div;
    private static final RString 単一 = new RString("単一");
    private static final RString 広域 = new RString("広域");
    private static final RString STR_00 = new RString("00");
    private static final RString KEY0 = new RString("key0");
    private static final RString 特徴異動情報作成 = new RString("特徴異動情報作成");
    private static final RString 特徴依頼情報作成 = new RString("特徴依頼情報作成");
    private static final RString SPACE = new RString(" ");
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
    private static final RString STR_1 = new RString("1");
    private static final RString STR_2 = new RString("2");
    private static final RString STR_3 = new RString("3");
    private static final RString STR_4 = new RString("4");
    private static final RString STR_5 = new RString("5");
    private static final RString STR_6 = new RString("6");
    private static final RString STR_7 = new RString("7");
    private static final RString STR_8 = new RString("8");
    private static final RString STR_9 = new RString("9");
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
     * @return RString
     */
    public RString initialize() {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        div.getTokuchoInfoDownloadShoriNaiyo().getTxtShoriNendo().setValue(new RDate(調定年度.toString()));
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().getKey();
        処理対象月制御();
        List<RString> 市町村識別IDList = null;
        RString 画面状態 = 単一;
        AuthorityItem 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(
                ControlDataHolder.getUserId()).get(INT_0);
        KoseiShichosonJoho 市町村 = null;
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            市町村識別IDList = 市町村制御(市町村識別ID.getItemId());
            if (!STR_00.equals(市町村識別ID.getItemId())) {
                画面状態 = 広域;
            }
            市町村 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID.getItemId());
            div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().setDisabled(true);
        } else {
            div.getTokuchoInfoDownloadShoriNaiyo().getRadShichosonSelect().setVisible(false);
            div.getTokuchoInfoDownloadShoriNaiyo().getDdlShichosonSelect().setVisible(false);
            div.getTokuchoInfoDownloadShoriNaiyo().getRadTsukiSelect().setSelectedKey(KEY0);
        }
        処理状況グリッド設定(導入形態コード,
                div.getShoriTaishoShichoshonTsuki().getDdlShichosonSelect().getSelectedKey(), 市町村識別IDList);
        処理対象グリッド設定(画面状態, 市町村);
        return 画面状態;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @return RString
     */
    public TokuchoInfoFDownloadInfo getFile() {
        return TokuchoInfoShoriDateKanri.createInstance().getファイル対象().get(0);
    }

    private void 処理対象グリッド設定(RString 画面状態, KoseiShichosonJoho 市町村) {
        List<TokuchoInfoFDownloadInfo> ファイル対象List = TokuchoInfoShoriDateKanri.createInstance().getファイル対象();
        if (単一.equals(画面状態)) {
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
                row.getTxtMonth().setValue(new RString(作成日.getMonthValue()));
                単一Rows.add(row);
            }
            div.getTsukiShoriSelect().getDgTsukiShoriSelect().setDataSource(単一Rows);
        } else {
            List<dgkoikiShoriSelect_Row> 広域Rows = new ArrayList<>();
            for (TokuchoInfoFDownloadInfo ファイル対象 : ファイル対象List) {
                dgkoikiShoriSelect_Row row = new dgkoikiShoriSelect_Row();
                row.getTxtFileMei().setValue(ファイル対象.getファイル名());
                row.getTxtSakuseiInfoName().setValue(ファイル対象.get情報名());
                RDate 作成日 = ファイル対象.get作成日時().getDate();
                RTime 作成時 = ファイル対象.get作成日時().getTime();
                row.getTxtZenSakuseiNichiji().setValue(new RString(
                        作成日.wareki().toDateString().toString() + SPACE
                        + 作成時.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
                row.getTxtMonth().setValue(new RString(作成日.getMonthValue()));
                if (市町村 != null) {
                    row.getTxtCityCode().setValue(市町村.get市町村コード().value());
                    row.getTxtCityName().setValue(市町村.get市町村名称());
                }
                広域Rows.add(row);
            }
            div.getKoikiShoriSelect().getDgkoikiShoriSelect().setDataSource(広域Rows);
        }
    }

    private List<RString> 市町村制御(RString 市町村識別ID) {
        List<RString> 市町村識別IDList = new ArrayList<>();
        List<KeyValueDataSource> 市町村DataSourceList = new ArrayList<>();
        if (!STR_00.equals(市町村識別ID)) {
            KoseiShichosonJoho 市町村 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID);
            if (市町村 != null) {
                RString 市町村コード = 市町村.get市町村コード().getColumnValue();
                RString コード名称 = new RString(市町村コード.toString()
                        + SPACE.toString() + 市町村.get市町村名称().toString());
                市町村DataSourceList.add(new KeyValueDataSource(市町村コード, コード名称));
            }
        } else {
            List<KoikiZenShichosonJoho> 構成市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
            if (構成市町村List != null && !構成市町村List.isEmpty()) {
                for (KoikiZenShichosonJoho 構成市町村 : 構成市町村List) {
                    RString 市町村コード = 構成市町村.get市町村コード().getColumnValue();
                    RString コード名称 = new RString(市町村コード.toString()
                            + SPACE.toString() + 構成市町村.get市町村名称().toString());
                    市町村DataSourceList.add(new KeyValueDataSource(市町村コード, コード名称));
                    市町村識別IDList.add(構成市町村.get市町村識別ID());
                }
            }
        }
        div.getShoriTaishoShichoshonTsuki().getDdlShichosonSelect().setDataSource(市町村DataSourceList);
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

    private void 処理状況グリッド設定(RString 導入形態コード, RString 市町村識別ID, List<RString> 市町村識別IDList) {
        List<dgShoriKakunin_Row> 処理状況Rows = new ArrayList<>();
        Map<RString, RString> 処理月Map = get処理状況グリッド処理月();
        List<RString> 処理月List = get処理状況グリッド処理月List();
        for (RString 処理月 : 処理月List) {
            dgShoriKakunin_Row row = new dgShoriKakunin_Row();
            row.getTxtTsuki().setValue(処理月);
            if (月_7.equals(処理月)) {
                row.getTxtShoriMei().setValue(特徴依頼情報作成);
            } else {
                row.getTxtShoriMei().setValue(特徴異動情報作成);
            }
            row.getTxtShoriNichiji().setValue(get状況処理日時(導入形態コード, 市町村識別ID, 処理月Map.get(処理月), 市町村識別IDList));
            //TODO QA1412
            row.getTxtJokyo().setValue(RString.EMPTY);
            処理状況Rows.add(row);
        }
        div.getTokuchoInfoDownloadShoriKakunin().getDgShoriKakunin().setDataSource(処理状況Rows);
    }

    private RString get状況処理日時(RString 導入形態コード, RString 市町村識別ID, RString 連番param, List<RString> 市町村識別IDList) {
        RDate 処理年度 = div.getTokuchoInfoDownloadShoriNaiyo().getTxtShoriNendo().getValue();
        FlexibleYear year = new FlexibleYear(処理年度.getYear().toDateString());
        if (!DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            RString 処理名;
            RString 年度内連番;
            if (STR_7.equals(div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().getSelectedKey())) {
                処理名 = ShoriName.特徴依頼情報作成.get名称();
                年度内連番 = STR_0001;
            } else {
                処理名 = ShoriName.特徴依頼情報作成.get名称();
                年度内連番 = 連番param;
            }
            ShoriDateKanri shoriDateKanri = TokuchoInfoShoriDateKanri.createInstance().get単一処理日付(処理名, year, 年度内連番);
            if (shoriDateKanri == null || shoriDateKanri.get基準日時() == null) {
                return RString.EMPTY;
            }
            return get処理日時パターン(shoriDateKanri.get基準日時());
        }
        if (KEY0.equals(div.getTokuchoInfoDownloadShoriNaiyo().
                getRadShichosonSelect().getSelectedKey())) {
            RString 市町村ID = div.getTokuchoInfoDownloadShoriNaiyo().getDdlShichosonSelect().getSelectedKey();
            ShoriDateKanri shoriDateKanri = TokuchoInfoShoriDateKanri.createInstance().
                    get市町村処理日付(year, new RString(STR_00.toString() + 市町村ID.toString()));
            if (shoriDateKanri == null || shoriDateKanri.get基準日時() == null) {
                return RString.EMPTY;
            }
            return get処理日時パターン(shoriDateKanri.get基準日時());
        }
        RString 処理名;
        RString 年度内連番;
        if (STR_7.equals(div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().getSelectedKey())) {
            処理名 = ShoriName.特徴依頼情報作成.get名称();
            年度内連番 = STR_0001;
        } else {
            処理名 = ShoriName.特徴依頼情報作成.get名称();
            年度内連番 = 連番param;
        }
        if (!STR_00.equals(市町村識別ID)) {
            ShoriDateKanri shoriDateKanri = TokuchoInfoShoriDateKanri.createInstance().get月処理日付(year, 処理名, 年度内連番,
                    new RString(STR_00.toString() + 市町村識別ID.toString()));
            return get処理日時パターン(shoriDateKanri.get基準日時());
        }
        ShoriDateKanri shoriDateKanri = TokuchoInfoShoriDateKanri.createInstance().
                get広域職員処理日付(year, 処理名, 年度内連番, 市町村識別IDList);
        return get処理日時パターン(shoriDateKanri.get基準日時());
    }

    private Map<RString, RString> get処理状況グリッド処理月() {
        Map<RString, RString> 処理月Map = new HashMap<>();
        処理月Map.put(月_4, STR_0004);
        処理月Map.put(月_5, STR_0005);
        処理月Map.put(月_6, STR_0006);
        処理月Map.put(月_7, STR_0007);
        処理月Map.put(月_8, STR_0008);
        処理月Map.put(月_9, STR_0009);
        処理月Map.put(月_10, STR_0010);
        処理月Map.put(月_11, STR_0011);
        処理月Map.put(月_12, STR_0012);
        処理月Map.put(月_1, STR_0001);
        処理月Map.put(月_2, STR_0002);
        処理月Map.put(月_3, STR_0003);
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

    private RString get処理日時パターン(YMDHMS 基準日時) {
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
        div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().setDisabled(true);
        RString 市町村Id = div.getTokuchoInfoDownloadShoriNaiyo().getDdlShichosonSelect().getSelectedKey();
        if (RString.isNullOrEmpty(市町村Id)) {
            return;
        }
        RDate 処理年度 = div.getTokuchoInfoDownloadShoriNaiyo().getTxtShoriNendo().getValue();
        FlexibleYear year = new FlexibleYear(処理年度.getYear().toDateString());
        List<dgShoriKakunin_Row> rows = div
                .getTokuchoInfoDownloadShoriKakunin().getDgShoriKakunin().getDataSource();
        List<dgShoriKakunin_Row> 処理状況Rows = new ArrayList<>();
        for (dgShoriKakunin_Row row : rows) {
            ShoriDateKanri shoriDateKanri = TokuchoInfoShoriDateKanri.createInstance().
                    get市町村処理日付(year, new RString(STR_00.toString() + 市町村Id.toString()));
            if (shoriDateKanri == null || shoriDateKanri.get基準日時() == null) {
                continue;
            }
            row.getTxtShoriNichiji().setValue(get処理日時パターン(shoriDateKanri.get基準日時()));
            処理状況Rows.add(row);
        }
        div.getTokuchoInfoDownloadShoriKakunin().getDgShoriKakunin().setDataSource(処理状況Rows);
        //TODO
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
        div.getTokuchoInfoDownloadShoriNaiyo().getDdlShichosonSelect().setDisabled(true);
//        RString 処理対象月 = div.getTokuchoInfoDownloadShoriNaiyo().getDdlTsuki().getSelectedKey();
//        if (RString.isNullOrEmpty(処理対象月)) {
//            return;
//        }
        //TODO
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
     */
    public void getダウンロードFile() {
    }

}
