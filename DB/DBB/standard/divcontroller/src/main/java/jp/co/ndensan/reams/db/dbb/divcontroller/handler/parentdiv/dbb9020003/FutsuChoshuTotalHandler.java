/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb9020003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.FuchoSyoriTaisho;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.KanendoSaishutsu;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.KozaTaishoshaSyutsuryoku;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.NonyuTsuchishoRenchoKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.ZanteiHeichoshaFuchobunChoshuUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.ZanteiKeisanHasuChosei;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.ZanteiKeisanIdoHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.FuchoZanteiKeisanHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTani;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofusyoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.TsuchishoPrintConditions;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003.FutsuChoshuTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003.dgGenNendoKibetsuJoho_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003.dgKaNendoKibetsuJoho_Row;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.noki.nokikanri.NokiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets._IServletControlData;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * システム管理情報（普通徴収）
 */
public final class FutsuChoshuTotalHandler {

    private final FutsuChoshuTotalDiv div;
    private static final RString 未作成 = new RString("未作成");
    private static final RString 作成済 = new RString("作成済");
    private static final RString 管理情報 = new RString("新年度管理情報");
    private static final RString メッセージ = new RString("保険者が単一市町村または広域市町村ではないため処理の継続");
    private static final RString メッセージ２ = new RString("現年度のxx月のyy");
    private static final RString メッセージ３ = new RString("過年度のxx月のyy");
    private static final RString メッセージ４ = new RString("選択をONにできる数");
    private static final RString メッセージ５ = new RString("12以下");
    private static final RString 当行月 = new RString("xx");
    private static final RString セル名 = new RString("yy");
    private static final RString 発行日 = new RString("発行日");
    private static final RString 納期限 = new RString("納期限");
    private static final RString 納期_自 = new RString("納期（自）");
    private static final RString 納期_至 = new RString("納期（至）");
    private static final RString コード種別 = new RString("0002");
    private static final FlexibleYear 平成12年 = new FlexibleYear("2000");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString FOURTEEN = new RString("14");
    private static final RString FIFTEEN = new RString("15");
    private static final int 数字１５ = 15;
    private static final int 数字１３ = 13;
    private static final int 数字１２ = 12;
    private static final int 数字１０ = 10;
    private static final int 数字７ = 7;
    private static final int 数字６ = 6;
    private static final int 数字５ = 5;
    private static final int 数字４ = 4;
    private static final int 数字１ = 1;
    private static final int 数字０ = 0;
    private static final RString 月の期_00 = new RString("00");
    private static final RString 第４月 = new RString("04");
    private static final RString 第５月 = new RString("05");

    private FutsuChoshuTotalHandler(FutsuChoshuTotalDiv div) {
        this.div = div;
    }

    /**
     * 生成されたインタフェースを返します
     *
     * @param div システム管理情報（普通徴収）画面Div
     * @return FutsuChoshuTotalHandler
     */
    public static FutsuChoshuTotalHandler of(FutsuChoshuTotalDiv div) {
        return new FutsuChoshuTotalHandler(div);
    }

    /**
     * 調定年度DDLの設定
     */
    public void set調定年度DDL() {
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConifg.get(
                ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        RString 新年度管理情報;
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        ShoriDateKanri result = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課, 管理情報, 調定年度.plusYear(1));
        if (result == null) {
            新年度管理情報 = 未作成;
        } else if (result.get基準年月日().isEmpty()) {
            新年度管理情報 = 未作成;
        } else {
            新年度管理情報 = 作成済;
        }

        if (未作成.equals(新年度管理情報)) {
            div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setDataSource(set選択可能年度(調定年度));
        } else {
            div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setDataSource(set選択可能年度(調定年度.plusYear(1)));
        }
        div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setSelectedIndex(数字０);
    }

    private List<KeyValueDataSource> set選択可能年度(FlexibleYear 調定年度) {
        List<KeyValueDataSource> keyValueData = new ArrayList<>();
        while (平成12年.isBeforeOrEquals(調定年度)) {
            keyValueData.add(new KeyValueDataSource(調定年度.toDateString(),
                    調定年度.wareki().firstYear(FirstYear.ICHI_NEN).toDateString()));
            調定年度 = 調定年度.minusYear(1);
        }
        return keyValueData;
    }

    private List<KeyValueDataSource> set市町村指定DDL(KaigoDonyuKeitai 介護導入形態, FlexibleYear 調定年度) {
        List<KeyValueDataSource> 市町村 = new ArrayList<>();
        if (DonyuKeitaiCode.事務単一.getCode().equals(介護導入形態.get導入形態コード().getCode())) {
            // TODO QA No.534(Redmine#80710)
            市町村.add(new KeyValueDataSource(new RString("001"), new RString("shanghai")));
        } else {
            // TODO QA No.534(Redmine#80710)
            市町村.add(new KeyValueDataSource(new RString("002"), new RString("beijing")));
        }
        return 市町村;
    }

    /**
     * 市町村指定設定
     */
    public void set市町村指定() {
        FlexibleYear 調定年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 不均一納期期限 = new FlexibleYear(DbBusinessConifg.get(
                ConfigNameDBB.ランク管理情報_不均一納期期限, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));

        if (不均一納期期限.isBefore(調定年度)) {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(false);
        } else {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(true);
            // TODO QA No.534(Redmine#80710)
            KaigoDonyuKeitai 介護導入形態 = KaigoDonyuKeitaiManager.createInstance().
                    get介護導入形態(GyomuBunrui.介護事務, DonyuKeitaiCode.事務広域);

            導入形態判定(介護導入形態, 調定年度);
        }
    }

    private void 導入形態判定(KaigoDonyuKeitai 介護導入形態, FlexibleYear 調定年度) {
        if (DonyuKeitaiCode.事務単一.getCode().equals(介護導入形態.get導入形態コード().getCode())) {
            RString 合併情報区分 = DbBusinessConifg.get(
                    ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            if (ZERO.equals(合併情報区分)) {
                div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(false);
            } else if (ONE.equals(合併情報区分)) {
                div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setDataSource(set市町村指定DDL(介護導入形態, 調定年度));
            }
        } else if (DonyuKeitaiCode.事務広域.getCode().equals(介護導入形態.get導入形態コード().getCode())) {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setDataSource(set市町村指定DDL(介護導入形態, 調定年度));
        } else {
            前排他キーの解除();
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace(メッセージ.toString()));
        }
    }

    /**
     * 初期値の設定
     */
    public void set初期値() {
        set現年度期別情報Gird();
        set期別保険料();
        set暫定計算方法();
        set過年度期別情報Grid();
    }

    private void initGird(RString 普通徴収_期別テーブル, RString 普徴期情報_月の期,
            RString 普徴期情報_月処理区分, RString 普徴期情報_処理対象, RString 普徴期情報_納付書の型,
            RString 普徴期情報_納付書の印字位置, RString 普徴期情報_コンビニカット印字位置,
            RString 普徴期情報_コンビニ連帳印字位置, RString 普徴期情報_ブック開始位置,
            RString 普徴期情報_納通連帳区分, RString 普徴期情報_通知書プリント条件,
            RString 普徴期情報_口座対象者プリント条件, dgGenNendoKibetsuJoho_Row row) {
        if (普通徴収_期別テーブル.equals(row.getTxtTsuki())) {
            row.setSelected(Boolean.TRUE);
        }
        row.setTxtTsukinoKi(普徴期情報_月の期);
        row.getDdlTsukiShoriKbn().setSelectedKey(普徴期情報_月処理区分);
        row.getDdlShoriTaisho().setSelectedKey(普徴期情報_処理対象);
        if (row.getSelected() && !div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            Noki noki = new NokiManager().get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                    new RYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey()),
                    GennenKanen.現年度, Integer.parseInt(row.getTxtTsukinoKi().toString()));
            if (noki != null) {
                row.getTxtHakkoYMD().setValue(new FlexibleDate(noki.get通知書発行日().toDateString()));
                row.getTxtNokigenYMD().setValue(new FlexibleDate(noki.get納期限().toDateString()));
                row.getTxtNokigenStYMD().setValue(new FlexibleDate(noki.get納期開始日().toDateString()));
                row.getTxtNokigenEdYMD().setValue(new FlexibleDate(noki.get納期終了日().toDateString()));
            }
        }
        row.getDdlNofushoKata().setSelectedKey(普徴期情報_納付書の型);
        row.getDdlInjiIchi().setSelectedKey(普徴期情報_納付書の印字位置);
        row.getDdlCVSCutInjiIchi().setSelectedKey(普徴期情報_コンビニカット印字位置);
        row.getDdlCVSRenChoInjiIchi().setSelectedKey(普徴期情報_コンビニ連帳印字位置);
        row.getDdlBookStInjiIchi().setSelectedKey(普徴期情報_ブック開始位置);
        row.getDdlRenchoKbn().setSelectedKey(普徴期情報_納通連帳区分);
        row.getDdlOutputJoken().setSelectedKey(普徴期情報_通知書プリント条件);
        row.getDdlKozaTaishoshaOutput().setSelectedKey(普徴期情報_口座対象者プリント条件);
    }

    private List<dgGenNendoKibetsuJoho_Row> create現年度期別情報Gird() {
        int i = 1;
        int m = 数字４;
        List<dgGenNendoKibetsuJoho_Row> list = new ArrayList<>();
        while (i < 数字１５) {
            dgGenNendoKibetsuJoho_Row row = new dgGenNendoKibetsuJoho_Row();
            row.getDdlTsukiShoriKbn().setDataSource(set月処理区分ddl());
            row.getDdlShoriTaisho().setDataSource(set処理対象ddl());
            if (div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
                row.getTxtHakkoYMD().setVisible(false);
                row.getTxtNokigenYMD().setVisible(false);
                row.getTxtNokigenStYMD().setVisible(false);
                row.getTxtNokigenEdYMD().setVisible(false);
            } else {
                row.getTxtHakkoYMD().setVisible(true);
                row.getTxtNokigenYMD().setVisible(true);
                row.getTxtNokigenStYMD().setVisible(true);
                row.getTxtNokigenEdYMD().setVisible(true);
            }
            row.getDdlNofushoKata().setDataSource(set納付書の型ddl());
            row.getDdlInjiIchi().setDataSource(set印字位置ddl());
            row.getDdlCVSCutInjiIchi().setDataSource(setＣＶＳカット印字位置ddl());
            row.getDdlCVSRenChoInjiIchi().setDataSource(setＣＶＳ連帳印字位置ddl());
            row.getDdlBookStInjiIchi().setDataSource(setブック開始位置ddl());
            row.getDdlRenchoKbn().setDataSource(set納入通知書連帳区分ddl());
            row.getDdlOutputJoken().setDataSource(set納付書出力条件ddl());
            row.getDdlKozaTaishoshaOutput().setDataSource(set口座対象者出力ddl());
            if (i == 数字１０) {
                m = 1;
            }
            row.setTxtTsuki(new RString(String.format("%02d", m)));
            list.add(row);
            i = i + 1;
            m = m + 1;
        }
        return list;
    }

    private void set現年度期別情報Gird() {

        List<Enum> 普通徴収_期別テーブル = create普通徴収_期別テーブル();
        List<Enum> 普徴期情報_月の期 = create普徴期情報_月の期();
        List<Enum> 普徴期情報_月処理区分 = create普徴期情報_月処理区分();
        List<Enum> 普徴期情報_処理対象 = create普徴期情報_処理対象();
        List<Enum> 普徴期情報_納付書の型 = create普徴期情報_納付書の型();
        List<Enum> 普徴期情報_納付書の印字位置 = create普徴期情報_納付書の印字位置();
        List<Enum> 普徴期情報_コンビニカット印字位置 = create普徴期情報_コンビニカット印字位置();
        List<Enum> 普徴期情報_コンビニ連帳印字位置 = create普徴期情報_コンビニ連帳印字位置();
        List<Enum> 普徴期情報_ブック開始位置 = create普徴期情報_ブック開始位置();
        List<Enum> 普徴期情報_納通連帳区分 = create普徴期情報_納通連帳区分();
        List<Enum> 普徴期情報_通知書プリント条件 = create普徴期情報_通知書プリント条件();
        List<Enum> 普徴期情報_口座対象者プリント条件 = create普徴期情報_口座対象者プリント条件();

        int i = 0;
        List<dgGenNendoKibetsuJoho_Row> list = create現年度期別情報Gird();
        for (dgGenNendoKibetsuJoho_Row row : list) {
            initGird(DbBusinessConifg.get(普通徴収_期別テーブル.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_月の期.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_月処理区分.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_処理対象.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_納付書の型.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_納付書の印字位置.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_コンビニカット印字位置.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_コンビニ連帳印字位置.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_ブック開始位置.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_納通連帳区分.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_通知書プリント条件.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(普徴期情報_口座対象者プリント条件.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    row);
            i = i + 1;
        }

        list = set現年度Grid制御(list);
        div.getFutsuChoshu().getDgGenNendoKibetsuJoho().setDataSource(list);
    }

    private void set期別保険料() {
        div.getFutsuChoshu().getDdlHasu().setDataSource(set端数ddl());
        div.getFutsuChoshu().getDdlHasu().setSelectedKey(DbBusinessConifg.get(ConfigNameDBB.普通徴収_期別端数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
    }

    private void set暫定計算方法() {
        div.getFutsuChoshu().getDdlFukaHoho().setDataSource(set賦課方法ddl());
        div.getFutsuChoshu().getDdlFukaHoho().setSelectedKey(DbBusinessConifg.get(ConfigNameDBB.普通徴収_仮算定賦課方法,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        div.getFutsuChoshu().getDdlIdoHoho().setDataSource(set異動方法ddl());
        div.getFutsuChoshu().getDdlIdoHoho().setSelectedKey(DbBusinessConifg.get(ConfigNameDBB.普通徴収_仮算定異動方法,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        List<KeyValueDataSource> 端数調整 = new ArrayList<>();
        端数調整.add(new KeyValueDataSource(ZanteiKeisanHasuChosei.あり.getコード(),
                ZanteiKeisanHasuChosei.あり.get略称()));
        端数調整.add(new KeyValueDataSource(ZanteiKeisanHasuChosei.なし.getコード(),
                ZanteiKeisanHasuChosei.なし.get略称()));
        div.getFutsuChoshu().getRadHasuChosei().setDataSource(端数調整);
        div.getFutsuChoshu().getRadHasuChosei().setSelectedKey(DbBusinessConifg.get(ConfigNameDBB.普通徴収_仮算定端数調整有無,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        div.getFutsuChoshu().getRadHeichoSha().setDataSource(set暫定併徴者普徴分徴収有無());
        div.getFutsuChoshu().getRadHeichoSha().setSelectedKey(DbBusinessConifg.get(ConfigNameDBB.普通徴収_仮算定併徴者普徴分徴収有無,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
    }

    private List<dgKaNendoKibetsuJoho_Row> create過年度期別情報Grid() {
        List<dgKaNendoKibetsuJoho_Row> list = new ArrayList<>();
        int i = 1;
        int m = 数字４;
        while (i < 数字１３) {
            dgKaNendoKibetsuJoho_Row row = new dgKaNendoKibetsuJoho_Row();
            row.getDdlNofushoKata().setDataSource(set納付書の型ddl2());
            row.getDdlInjiIchi().setDataSource(set印字位置ddl());
            row.getDdlCVSCutInjiIchi().setDataSource(setＣＶＳカット印字位置ddl2());
            row.getDdlCVSRenChoInjiIchi().setDataSource(setＣＶＳ連帳印字位置ddl2());
            row.getDdlBookStInjiIchi().setDataSource(setブック開始位置ddl());
            row.getDdlOutputJoken().setDataSource(set納付書出力条件ddl());
            row.getDdlKozaTaishoshaOutput().setDataSource(set口座対象者出力ddl());
            List<KeyValueDataSource> 過年度の歳出 = new ArrayList<>();
            過年度の歳出.add(new KeyValueDataSource(KanendoSaishutsu.過年度.getコード(),
                    KanendoSaishutsu.過年度.get名称()));
            過年度の歳出.add(new KeyValueDataSource(KanendoSaishutsu.現年度.getコード(),
                    KanendoSaishutsu.現年度.get名称()));
            row.getDdlSaiShutsu().setDataSource(過年度の歳出);
            if (div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
                row.getTxtHakkoYMD().setVisible(false);
                row.getTxtNokigenYMD().setVisible(false);
                row.getTxtNokigenStYMD().setVisible(false);
                row.getTxtNokigenEtYMD().setVisible(false);
            } else {
                row.getTxtHakkoYMD().setVisible(true);
                row.getTxtNokigenYMD().setVisible(true);
                row.getTxtNokigenStYMD().setVisible(true);
                row.getTxtNokigenEtYMD().setVisible(true);
            }
            if (i == 数字１０) {
                m = 1;
            }
            row.setTxtTsuki(new RString(String.format("%02d", m)));
            list.add(row);
            i = i + 1;
            m = m + 1;
        }
        return list;
    }

    private void set過年度期別情報Grid() {
        List<dgKaNendoKibetsuJoho_Row> list = create過年度期別情報Grid();
        List<Enum> 過年度_期別テーブル = create過年度_期別テーブル();
        List<Enum> 過年度期情報_月の期 = create過年度期情報_月の期();
        List<Enum> 過年度期情報_納付書の型 = create過年度期情報_納付書の型();
        List<Enum> 過年度期情報_納付書の印字位置 = create過年度期情報_納付書の印字位置();
        List<Enum> 過年度期情報_コンビニカット印字位置 = create過年度期情報_コンビニカット印字位置();
        List<Enum> 過年度期情報_コンビニ連帳印字位置 = create過年度期情報_コンビニ連帳印字位置();
        List<Enum> 過年度期情報_ブック開始位置 = create過年度期情報_ブック開始位置();
        List<Enum> 過年度期情報_通知書プリント条件 = create過年度期情報_通知書プリント条件();
        List<Enum> 過年度期情報_口座対象者プリント条件 = create過年度期情報_口座対象者プリント条件();

        int i = 0;
        for (dgKaNendoKibetsuJoho_Row row : list) {
            initGird2(
                    DbBusinessConifg.get(過年度_期別テーブル.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(過年度期情報_月の期.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(過年度期情報_納付書の型.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(過年度期情報_納付書の印字位置.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(過年度期情報_コンビニカット印字位置.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(過年度期情報_コンビニ連帳印字位置.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(過年度期情報_ブック開始位置.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(過年度期情報_通知書プリント条件.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    DbBusinessConifg.get(過年度期情報_口座対象者プリント条件.get(i), RDate.getNowDate(), SubGyomuCode.DBB介護賦課),
                    row);
            i = i + 1;
        }
        list = set過年度Grid制御(list);
        div.getFutsuChoshu().getDgKaNendoKibetsuJoho().setDataSource(list);
    }

    private void initGird2(RString 過年度_期別テーブル, RString 過年度期情報_月の期,
            RString 過年度期情報_納付書の型, RString 過年度期情報_納付書の印字位置,
            RString 過年度期情報_コンビニカット印字位置, RString 過年度期情報_コンビニ連帳印字位置,
            RString 過年度期情報_ブック開始位置, RString 過年度期情報_通知書プリント条件,
            RString 過年度期情報_口座対象者プリント条件, dgKaNendoKibetsuJoho_Row row) {
        if (過年度_期別テーブル.equals(row.getTxtTsuki())) {
            row.setSelected(Boolean.TRUE);
        }
        row.setTxtTsukinoKi(過年度期情報_月の期);
        if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            Noki noki = new NokiManager().get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                    new RYear((new RDate(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().
                                    getSelectedValue().toString())).getYear().toDateString()),
                    GennenKanen.過年度, Integer.parseInt(row.getTxtTsukinoKi().toString()));
            if (noki != null) {
                row.getTxtHakkoYMD().setValue(new FlexibleDate(noki.get通知書発行日().toDateString()));
                row.getTxtNokigenYMD().setValue(new FlexibleDate(noki.get納期限().toDateString()));
                row.getTxtNokigenStYMD().setValue(new FlexibleDate(noki.get納期開始日().toDateString()));
                row.getTxtNokigenEtYMD().setValue(new FlexibleDate(noki.get納期終了日().toDateString()));
            }
        }

        row.getDdlNofushoKata().setSelectedKey(過年度期情報_納付書の型);

        row.getDdlInjiIchi().setSelectedKey(過年度期情報_納付書の印字位置);

        row.getDdlCVSCutInjiIchi().setSelectedKey(過年度期情報_コンビニカット印字位置);

        row.getDdlCVSRenChoInjiIchi().setSelectedKey(過年度期情報_コンビニ連帳印字位置);
        row.getDdlBookStInjiIchi().setSelectedKey(過年度期情報_ブック開始位置);
        row.getDdlOutputJoken().setSelectedKey(過年度期情報_通知書プリント条件);
        row.getDdlKozaTaishoshaOutput().setSelectedKey(過年度期情報_口座対象者プリント条件);

        if (第４月.equals(row.getTxtTsuki())) {
            row.getDdlSaiShutsu().setSelectedKey(DbBusinessConifg.get(
                    ConfigNameDBB.過年度期情報_過年度の歳出1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        } else if (第５月.equals(row.getTxtTsuki())) {
            row.getDdlSaiShutsu().setSelectedKey(DbBusinessConifg.get(
                    ConfigNameDBB.過年度期情報_過年度の歳出2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        } else {
            row.getDdlSaiShutsu().setIsBlankLine(true);
            row.getDdlSaiShutsu().setDisabled(true);
        }
    }

    /**
     * 現年度期別情報Gridの「納付書の型」変更時の処理
     *
     * @param row dgGenNendoKibetsuJoho_Row
     * @return dgGenNendoKibetsuJoho_Row
     */
    public dgGenNendoKibetsuJoho_Row set納付書の型変更(dgGenNendoKibetsuJoho_Row row) {
        RString 納付書の型 = row.getDdlNofushoKata().getSelectedKey();
        if (NofusyoType.なし.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(true);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(true);
        } else if (NofusyoType.期毎.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(false);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(true);
        } else if (NofusyoType.銀振型5期.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(false);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(true);
        } else if (NofusyoType.銀振型4期.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(false);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(true);
        } else if (NofusyoType.ブック.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(true);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(false);
        } else if (NofusyoType.コンビニ.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(true);
            row.getDdlCVSCutInjiIchi().setDisabled(false);
            row.getDdlCVSRenChoInjiIchi().setDisabled(false);
            row.getDdlBookStInjiIchi().setDisabled(true);
        } else if (NofusyoType.その他.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(true);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(true);
        }
        return row;
    }

    /**
     * 過年度期別情報Gridの「納付書の型」変更時の処理
     *
     * @param row dgKaNendoKibetsuJoho_Row
     * @return dgKaNendoKibetsuJoho_Row
     */
    public dgKaNendoKibetsuJoho_Row set納付書の型変更2(dgKaNendoKibetsuJoho_Row row) {
        RString 納付書の型 = row.getDdlNofushoKata().getSelectedKey();
        if (NofusyoType.期毎.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(false);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(true);
        } else if (NofusyoType.銀振型5期.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(false);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(true);
        } else if (NofusyoType.銀振型4期.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(false);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(true);
        } else if (NofusyoType.ブック.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(true);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(false);
        } else if (NofusyoType.コンビニ.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(true);
            row.getDdlCVSCutInjiIchi().setDisabled(false);
            row.getDdlCVSRenChoInjiIchi().setDisabled(false);
            row.getDdlBookStInjiIchi().setDisabled(true);
        } else if (NofusyoType.その他.getコード().equals(納付書の型)) {
            row.getDdlInjiIchi().setDisabled(true);
            row.getDdlCVSCutInjiIchi().setDisabled(true);
            row.getDdlCVSRenChoInjiIchi().setDisabled(true);
            row.getDdlBookStInjiIchi().setDisabled(true);
        }
        return row;
    }

    /**
     * 暫定計算方法の「賦課方法」変更時の処理
     */
    public void set賦課方法変更() {
        RString 賦課方法説明 = CodeMaster.getCode(SubGyomuCode.DBB介護賦課, new CodeShubetsu(コード種別),
                new Code(div.getFutsuChoshu().getZanteiKeisanHoho().getDdlFukaHoho().getSelectedKey()),
                new FlexibleDate(RDate.getNowDate().toDateString())).getコード名称();
        div.getFutsuChoshu().getZanteiKeisanHoho().getTxtFukaHohoHelp().setValue(賦課方法説明);
    }

    /**
     * 現年度Gridの選択ON/OFFの制御
     *
     * @param list List<dgGenNendoKibetsuJoho_Row>
     * @return List<dgGenNendoKibetsuJoho_Row>
     */
    public List<dgGenNendoKibetsuJoho_Row> set現年度Grid制御(List<dgGenNendoKibetsuJoho_Row> list) {
        int rowId = 1;
        RString ki = 月の期_00;
        for (dgGenNendoKibetsuJoho_Row row : list) {
            if (row.getSelected()) {
                ki = new RString(String.format("%02d", rowId));
                row.setTxtKi(ki);
                row.setTxtTsukinoKi(ki);
                rowId = rowId + 1;

                row.getDdlShoriTaisho().setDisabled(false);
                if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
                    row.getTxtHakkoYMD().setDisabled(false);
                    row.getTxtNokigenYMD().setDisabled(false);
                    row.getTxtNokigenStYMD().setDisabled(false);
                    row.getTxtNokigenEdYMD().setDisabled(false);
                }
                row.getDdlNofushoKata().setDisabled(false);
                row = set納付書の型変更(row);
                row.getDdlRenchoKbn().setDisabled(false);
                row.getDdlOutputJoken().setDisabled(false);
                row.getDdlKozaTaishoshaOutput().setDisabled(false);
            } else {
                row.setTxtKi(RString.EMPTY);
                row.setTxtTsukinoKi(ki);
                row.getDdlShoriTaisho().setSelectedKey(FuchoSyoriTaisho.なし.getコード());
                row.getDdlShoriTaisho().setDisabled(true);
                if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
                    row.getTxtHakkoYMD().setValue(null);
                    row.getTxtHakkoYMD().setDisabled(true);
                    row.getTxtNokigenYMD().setValue(null);
                    row.getTxtNokigenYMD().setDisabled(true);
                    row.getTxtNokigenStYMD().setValue(null);
                    row.getTxtNokigenStYMD().setDisabled(true);
                    row.getTxtNokigenEdYMD().setValue(null);
                    row.getTxtNokigenEdYMD().setDisabled(true);
                }
                row.getDdlNofushoKata().setDisabled(true);
                row.getDdlInjiIchi().setDisabled(true);
                row.getDdlCVSCutInjiIchi().setDisabled(true);
                row.getDdlCVSRenChoInjiIchi().setDisabled(true);
                row.getDdlBookStInjiIchi().setDisabled(true);
                row.getDdlRenchoKbn().setDisabled(true);
                row.getDdlOutputJoken().setDisabled(true);
                row.getDdlKozaTaishoshaOutput().setDisabled(true);
            }
        }
        int size = list.size() - 1;
        while (size >= 0) {
            if (list.get(size).getSelected()) {
                break;
            }
            list.get(size).setTxtTsukinoKi(月の期_00);
            size = size - 1;
        }
        return list;
    }

    /**
     * 過年度Gridの選択ON/OFFの制御
     *
     * @param list List<dgGenNendoKibetsuJoho_Row>
     * @return List<dgGenNendoKibetsuJoho_Row>
     */
    public List<dgKaNendoKibetsuJoho_Row> set過年度Grid制御(List<dgKaNendoKibetsuJoho_Row> list) {
        int rowId = 1;
        RString ki = 月の期_00;
        for (dgKaNendoKibetsuJoho_Row row : list) {
            if (row.getSelected()) {
                ki = new RString(String.format("%02d", rowId));
                row.setTxtKi(ki);
                row.setTxtTsukinoKi(ki);
                rowId = rowId + 1;

                if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
                    row.getTxtHakkoYMD().setDisabled(false);
                    row.getTxtNokigenYMD().setDisabled(false);
                    row.getTxtNokigenStYMD().setDisabled(false);
                    row.getTxtNokigenEtYMD().setDisabled(false);
                }
                row.getDdlNofushoKata().setDisabled(false);
                row = set納付書の型変更2(row);
                row.getDdlRenchoKbn().setDisabled(false);
                row.getDdlOutputJoken().setDisabled(false);
                row.getDdlKozaTaishoshaOutput().setDisabled(false);
                row.getDdlSaiShutsu().setDisabled(false);
            } else {
                row.setTxtKi(RString.EMPTY);
                row.setTxtTsukinoKi(ki);
                if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
                    row.getTxtHakkoYMD().setValue(null);
                    row.getTxtHakkoYMD().setDisabled(true);
                    row.getTxtNokigenYMD().setValue(null);
                    row.getTxtNokigenYMD().setDisabled(true);
                    row.getTxtNokigenStYMD().setValue(null);
                    row.getTxtNokigenStYMD().setDisabled(true);
                    row.getTxtNokigenEtYMD().setValue(null);
                    row.getTxtNokigenEtYMD().setDisabled(true);
                }
                row.getDdlNofushoKata().setDisabled(true);
                row.getDdlInjiIchi().setDisabled(true);
                row.getDdlCVSCutInjiIchi().setDisabled(true);
                row.getDdlCVSRenChoInjiIchi().setDisabled(true);
                row.getDdlBookStInjiIchi().setDisabled(true);
                row.getDdlRenchoKbn().setDisabled(true);
                row.getDdlOutputJoken().setDisabled(true);
                row.getDdlKozaTaishoshaOutput().setDisabled(true);
                row.getDdlSaiShutsu().setDisabled(true);
            }
        }
        int size = list.size() - 1;
        while (size >= 0) {
            if (list.get(size).getSelected()) {
                break;
            }
            list.get(size).setTxtTsukinoKi(月の期_00);
            size = size - 1;
        }
        return list;
    }

    /**
     * 現年度の発行日～納期（至）の入力チェック
     */
    public void 現年度入力チェック() {
        if (div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            return;
        }
        for (dgGenNendoKibetsuJoho_Row row : div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getDataSource()) {
            if (!row.getTxtKi().isNullOrEmpty()) {
                if (row.getTxtHakkoYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(row, null, 発行日).toString()));
                }
                if (row.getTxtNokigenYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(row, null, 納期限).toString()));
                }
                if (row.getTxtNokigenStYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(row, null, 納期_自).toString()));
                }
                if (row.getTxtNokigenEdYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(row, null, 納期_至).toString()));
                }
            }
        }
    }

    /**
     * 過年度の発行日～納期（至）の入力チェック
     */
    public void 過年度入力チェック() {
        if (div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            return;
        }
        for (dgKaNendoKibetsuJoho_Row row : div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getDataSource()) {
            if (!row.getTxtKi().isNullOrEmpty()) {
                if (row.getTxtHakkoYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(null, row, 発行日).toString()));
                }
                if (row.getTxtNokigenYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(null, row, 納期限).toString()));
                }
                if (row.getTxtNokigenStYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(null, row, 納期_自).toString()));
                }
                if (row.getTxtNokigenEtYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(null, row, 納期_至).toString()));
                }
            }
        }
    }

    private RString setメッセージ(dgGenNendoKibetsuJoho_Row row, dgKaNendoKibetsuJoho_Row row2, RString columnName) {
        RStringBuilder message;
        if (row != null) {
            message = new RStringBuilder(メッセージ２);
            message.replace(当行月, row.getTxtTsuki());
            message.replace(セル名, columnName);
        } else {
            message = new RStringBuilder(メッセージ３);
            message.replace(当行月, row2.getTxtTsuki());
            message.replace(セル名, columnName);
        }
        return message.toRString();
    }

    /**
     * 過年度グリッド内の選択数のチェック
     */
    public void 選択数チェック() {
        int i = 0;
        for (dgGenNendoKibetsuJoho_Row row : div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getDataSource()) {
            if (row.getSelected()) {
                i = i + 数字１;
            }
        }
        if (i > 数字１２) {
            throw new ApplicationException(UrErrorMessages.項目に対する制約.getMessage().replace(
                    メッセージ４.toString(), メッセージ５.toString()));
        }
    }

    /**
     * 保存処理
     */
    public void set保存処理() {
        update(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey(), ConfigNameDBB.日付関連_調定年度);
        List<Enum> 普通徴収_期別テーブル = create普通徴収_期別テーブル();
        List<Enum> 普徴期情報_月の期 = create普徴期情報_月の期();
        List<Enum> 普徴期情報_月処理区分 = create普徴期情報_月処理区分();
        List<Enum> 普徴期情報_処理対象 = create普徴期情報_処理対象();
        List<Enum> 普徴期情報_納付書の型 = create普徴期情報_納付書の型();
        List<Enum> 普徴期情報_納付書の印字位置 = create普徴期情報_納付書の印字位置();
        List<Enum> 普徴期情報_コンビニカット印字位置 = create普徴期情報_コンビニカット印字位置();
        List<Enum> 普徴期情報_コンビニ連帳印字位置 = create普徴期情報_コンビニ連帳印字位置();
        List<Enum> 普徴期情報_ブック開始位置 = create普徴期情報_ブック開始位置();
        List<Enum> 普徴期情報_納通連帳区分 = create普徴期情報_納通連帳区分();
        List<Enum> 普徴期情報_通知書プリント条件 = create普徴期情報_通知書プリント条件();
        List<Enum> 普徴期情報_口座対象者プリント条件 = create普徴期情報_口座対象者プリント条件();
        int i = 0;
        int 普徴期情報_仮算定期数 = 0;
        int 普徴期情報_定例納期数 = 0;
        int 普徴期情報_設定納期数 = 0;
        for (dgGenNendoKibetsuJoho_Row row : div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getDataSource()) {
            if (FuchokiJohoTsukiShoriKubun.普徴仮算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.普徴仮算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())) {
                普徴期情報_仮算定期数 = 普徴期情報_仮算定期数 + 数字１;
            }
            if (FuchokiJohoTsukiShoriKubun.普徴仮算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.普徴仮算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.本算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.本算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())) {
                普徴期情報_定例納期数 = 普徴期情報_定例納期数 + 数字１;
            }
            if (FuchokiJohoTsukiShoriKubun.普徴仮算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.普徴仮算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.本算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.本算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.普徴仮算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.普徴仮算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())) {
                普徴期情報_設定納期数 = 普徴期情報_設定納期数 + 数字１;
            }

            update(row.getTxtTsukinoKi(), 普徴期情報_月の期.get(i));
            if (row.getSelected()) {
                NokiManager nokiManager = new NokiManager();
                Noki noki = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                        new RYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey()),
                        GennenKanen.現年度,
                        Integer.parseInt(row.getTxtKi().toString()));
                noki = noki.createBuilderForEdit().
                        set通知書発行日(new RDate(row.getTxtHakkoYMD().getValue().toString())).
                        set納期限(new RDate(row.getTxtNokigenYMD().getValue().toString())).
                        set納期開始日(new RDate(row.getTxtNokigenStYMD().getValue().toString())).
                        set納期終了日(new RDate(row.getTxtNokigenEdYMD().getValue().toString())).build();
                new NokiManager().save納期(noki);

                if (i == 数字１２) {
                    update(FOURTEEN, 普通徴収_期別テーブル.get(i));
                } else if (i == 数字１３) {
                    update(FIFTEEN, 普通徴収_期別テーブル.get(i));
                } else {
                    update(row.getTxtTsuki(), 普通徴収_期別テーブル.get(i));
                }
                update(row.getDdlTsukiShoriKbn().getSelectedKey(), 普徴期情報_月処理区分.get(i));
                update(row.getDdlShoriTaisho().getSelectedKey(), 普徴期情報_処理対象.get(i));
                update(row.getDdlNofushoKata().getSelectedKey(), 普徴期情報_納付書の型.get(i));
                update(row.getDdlInjiIchi().getSelectedKey(), 普徴期情報_納付書の印字位置.get(i));
                update(row.getDdlCVSCutInjiIchi().getSelectedKey(), 普徴期情報_コンビニカット印字位置.get(i));
                update(row.getDdlCVSRenChoInjiIchi().getSelectedKey(), 普徴期情報_コンビニ連帳印字位置.get(i));
                update(row.getDdlBookStInjiIchi().getSelectedKey(), 普徴期情報_ブック開始位置.get(i));
                update(row.getDdlRenchoKbn().getSelectedKey(), 普徴期情報_納通連帳区分.get(i));
                update(row.getDdlOutputJoken().getSelectedKey(), 普徴期情報_通知書プリント条件.get(i));
                update(row.getDdlKozaTaishoshaOutput().getSelectedKey(), 普徴期情報_口座対象者プリント条件.get(i));
            } else {
                update(RString.EMPTY, 普通徴収_期別テーブル.get(i));
            }
            i = i + 1;
        }
        update(new RString(String.valueOf(普徴期情報_仮算定期数)), ConfigNameDBB.普徴期情報_仮算定期数);
        update(new RString(String.valueOf(普徴期情報_定例納期数)), ConfigNameDBB.普徴期情報_定例納期数);
        update(new RString(String.valueOf(普徴期情報_設定納期数)), ConfigNameDBB.普徴期情報_定例納期数);
        update(div.getFutsuChoshu().getDdlHasu().getSelectedKey(), ConfigNameDBB.普通徴収_期別端数);
        update(div.getFutsuChoshu().getDdlFukaHoho().getSelectedKey(), ConfigNameDBB.普通徴収_仮算定賦課方法);
        update(div.getFutsuChoshu().getDdlIdoHoho().getSelectedKey(), ConfigNameDBB.普通徴収_仮算定異動方法);
        update(div.getFutsuChoshu().getRadHasuChosei().getSelectedKey(), ConfigNameDBB.普通徴収_仮算定端数調整有無);
        update(div.getFutsuChoshu().getRadHeichoSha().getSelectedKey(), ConfigNameDBB.普通徴収_仮算定併徴者普徴分徴収有無);

        save保存処理2();
    }

    private void save保存処理2() {
        List<Enum> 過年度_期別テーブル = create過年度_期別テーブル();
        List<Enum> 過年度期情報_月の期 = create過年度期情報_月の期();
        List<Enum> 過年度期情報_納付書の型 = create過年度期情報_納付書の型();
        List<Enum> 過年度期情報_納付書の印字位置 = create過年度期情報_納付書の印字位置();
        List<Enum> 過年度期情報_コンビニカット印字位置 = create過年度期情報_コンビニカット印字位置();
        List<Enum> 過年度期情報_コンビニ連帳印字位置 = create過年度期情報_コンビニ連帳印字位置();
        List<Enum> 過年度期情報_ブック開始位置 = create過年度期情報_ブック開始位置();
        List<Enum> 過年度期情報_通知書プリント条件 = create過年度期情報_通知書プリント条件();
        List<Enum> 過年度期情報_口座対象者プリント条件 = create過年度期情報_口座対象者プリント条件();
        int i = 0;
        int 過年度期情報_設定納期数 = 0;
        for (dgKaNendoKibetsuJoho_Row row : div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getDataSource()) {
            if (row.getSelected()) {
                過年度期情報_設定納期数 = 過年度期情報_設定納期数 + 1;
                update(row.getTxtTsuki(), 過年度_期別テーブル.get(i));
                update(row.getDdlNofushoKata().getSelectedKey(), 過年度期情報_納付書の型.get(i));
                update(row.getDdlInjiIchi().getSelectedKey(), 過年度期情報_納付書の印字位置.get(i));
                update(row.getDdlCVSCutInjiIchi().getSelectedKey(), 過年度期情報_コンビニカット印字位置.get(i));
                update(row.getDdlCVSRenChoInjiIchi().getSelectedKey(), 過年度期情報_コンビニ連帳印字位置.get(i));
                update(row.getDdlBookStInjiIchi().getSelectedKey(), 過年度期情報_ブック開始位置.get(i));
                update(row.getDdlOutputJoken().getSelectedKey(), 過年度期情報_通知書プリント条件.get(i));
                update(row.getDdlKozaTaishoshaOutput().getSelectedKey(), 過年度期情報_口座対象者プリント条件.get(i));
                if (第４月.equals(row.getTxtTsuki())) {
                    update(row.getDdlSaiShutsu().getSelectedKey(), ConfigNameDBB.過年度期情報_過年度の歳出1);
                } else if (第５月.equals(row.getTxtTsuki())) {
                    update(row.getDdlSaiShutsu().getSelectedKey(), ConfigNameDBB.過年度期情報_過年度の歳出2);
                }
                NokiManager nokiManager = new NokiManager();
                Noki noki = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                        new RYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey()),
                        GennenKanen.現年度,
                        Integer.parseInt(row.getTxtKi().toString()));
                noki = noki.createBuilderForEdit().
                        set通知書発行日(new RDate(row.getTxtHakkoYMD().getValue().toString())).
                        set納期限(new RDate(row.getTxtNokigenYMD().getValue().toString())).
                        set納期開始日(new RDate(row.getTxtNokigenStYMD().getValue().toString())).
                        set納期終了日(new RDate(row.getTxtNokigenEtYMD().getValue().toString())).build();
                new NokiManager().save納期(noki);
            } else {
                update(RString.EMPTY, 過年度_期別テーブル.get(i));
            }
            update(row.getTxtTsukinoKi(), 過年度期情報_月の期.get(i));

            i = i + 1;
        }
        update(new RString(String.valueOf(過年度期情報_設定納期数)), ConfigNameDBB.過年度期情報_設定納期数);
    }

    private void update(RString value, Enum key) {
        if (!value.equals(DbBusinessConifg.get(key, RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            BusinessConfig.update(SubGyomuCode.DBB介護賦課, key, value, RString.EMPTY,
                    RString.EMPTY, RDate.getNowDate());
        }
    }

    private List<Enum> create過年度期情報_口座対象者プリント条件() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件1);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件2);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件3);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件4);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件5);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件6);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件7);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件8);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件9);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件10);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件11);
        list.add(ConfigNameDBB.過年度期情報_口座対象者プリント条件12);
        return list;
    }

    private List<Enum> create過年度期情報_通知書プリント条件() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件1);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件2);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件3);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件4);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件5);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件6);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件7);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件8);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件9);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件10);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件11);
        list.add(ConfigNameDBB.過年度期情報_通知書プリント条件12);
        return list;
    }

    private List<Enum> create過年度期情報_ブック開始位置() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置1);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置2);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置3);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置4);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置5);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置6);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置7);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置8);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置9);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置10);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置11);
        list.add(ConfigNameDBB.過年度期情報_ブック開始位置12);
        return list;
    }

    private List<Enum> create過年度期情報_コンビニ連帳印字位置() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置1);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置2);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置3);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置4);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置5);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置6);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置7);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置8);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置9);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置10);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置11);
        list.add(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置12);
        return list;
    }

    private List<Enum> create過年度期情報_コンビニカット印字位置() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置1);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置2);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置3);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置4);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置5);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置6);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置7);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置8);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置9);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置10);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置11);
        list.add(ConfigNameDBB.過年度期情報_コンビニカット印字位置12);
        return list;
    }

    private List<Enum> create過年度期情報_納付書の印字位置() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置1);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置2);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置3);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置4);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置5);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置6);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置7);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置8);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置9);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置10);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置11);
        list.add(ConfigNameDBB.過年度期情報_納付書の印字位置12);
        return list;
    }

    private List<Enum> create過年度期情報_納付書の型() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.過年度期情報_納付書の型1);
        list.add(ConfigNameDBB.過年度期情報_納付書の型2);
        list.add(ConfigNameDBB.過年度期情報_納付書の型3);
        list.add(ConfigNameDBB.過年度期情報_納付書の型4);
        list.add(ConfigNameDBB.過年度期情報_納付書の型5);
        list.add(ConfigNameDBB.過年度期情報_納付書の型6);
        list.add(ConfigNameDBB.過年度期情報_納付書の型7);
        list.add(ConfigNameDBB.過年度期情報_納付書の型8);
        list.add(ConfigNameDBB.過年度期情報_納付書の型9);
        list.add(ConfigNameDBB.過年度期情報_納付書の型10);
        list.add(ConfigNameDBB.過年度期情報_納付書の型11);
        list.add(ConfigNameDBB.過年度期情報_納付書の型12);
        return list;
    }

    private List<Enum> create過年度期情報_月の期() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.過年度期情報_月の期1);
        list.add(ConfigNameDBB.過年度期情報_月の期2);
        list.add(ConfigNameDBB.過年度期情報_月の期3);
        list.add(ConfigNameDBB.過年度期情報_月の期4);
        list.add(ConfigNameDBB.過年度期情報_月の期5);
        list.add(ConfigNameDBB.過年度期情報_月の期6);
        list.add(ConfigNameDBB.過年度期情報_月の期7);
        list.add(ConfigNameDBB.過年度期情報_月の期8);
        list.add(ConfigNameDBB.過年度期情報_月の期9);
        list.add(ConfigNameDBB.過年度期情報_月の期10);
        list.add(ConfigNameDBB.過年度期情報_月の期11);
        list.add(ConfigNameDBB.過年度期情報_月の期12);
        return list;
    }

    private List<Enum> create過年度_期別テーブル() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.過年度_期別テーブル1);
        list.add(ConfigNameDBB.過年度_期別テーブル2);
        list.add(ConfigNameDBB.過年度_期別テーブル3);
        list.add(ConfigNameDBB.過年度_期別テーブル4);
        list.add(ConfigNameDBB.過年度_期別テーブル5);
        list.add(ConfigNameDBB.過年度_期別テーブル6);
        list.add(ConfigNameDBB.過年度_期別テーブル7);
        list.add(ConfigNameDBB.過年度_期別テーブル8);
        list.add(ConfigNameDBB.過年度_期別テーブル9);
        list.add(ConfigNameDBB.過年度_期別テーブル10);
        list.add(ConfigNameDBB.過年度_期別テーブル11);
        list.add(ConfigNameDBB.過年度_期別テーブル12);
        return list;
    }

    private List<Enum> create普徴期情報_口座対象者プリント条件() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件1);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件2);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件3);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件4);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件5);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件6);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件7);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件8);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件9);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件10);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件11);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件12);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件13);
        list.add(ConfigNameDBB.普徴期情報_口座対象者プリント条件14);
        return list;
    }

    private List<Enum> create普徴期情報_通知書プリント条件() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件1);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件2);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件3);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件4);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件5);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件6);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件7);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件8);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件9);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件10);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件11);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件12);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件13);
        list.add(ConfigNameDBB.普徴期情報_通知書プリント条件14);
        return list;
    }

    private List<Enum> create普徴期情報_納通連帳区分() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分1);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分2);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分3);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分4);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分5);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分6);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分7);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分8);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分9);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分10);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分11);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分12);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分13);
        list.add(ConfigNameDBB.普徴期情報_納通連帳区分14);
        return list;
    }

    private List<Enum> create普徴期情報_ブック開始位置() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置1);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置2);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置3);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置4);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置5);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置6);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置7);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置8);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置9);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置10);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置11);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置12);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置13);
        list.add(ConfigNameDBB.普徴期情報_ブック開始位置14);
        return list;
    }

    private List<Enum> create普徴期情報_コンビニ連帳印字位置() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置1);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置2);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置3);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置4);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置5);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置6);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置7);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置8);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置9);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置10);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置11);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置12);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置13);
        list.add(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置14);
        return list;
    }

    private List<Enum> create普徴期情報_コンビニカット印字位置() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置1);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置2);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置3);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置4);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置5);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置6);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置7);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置8);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置9);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置10);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置11);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置12);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置13);
        list.add(ConfigNameDBB.普徴期情報_コンビニカット印字位置14);

        return list;
    }

    private List<Enum> create普徴期情報_納付書の印字位置() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置1);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置2);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置3);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置4);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置5);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置6);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置7);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置8);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置9);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置10);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置11);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置12);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置13);
        list.add(ConfigNameDBB.普徴期情報_納付書の印字位置14);
        return list;
    }

    private List<Enum> create普徴期情報_納付書の型() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_納付書の型1);
        list.add(ConfigNameDBB.普徴期情報_納付書の型2);
        list.add(ConfigNameDBB.普徴期情報_納付書の型3);
        list.add(ConfigNameDBB.普徴期情報_納付書の型4);
        list.add(ConfigNameDBB.普徴期情報_納付書の型5);
        list.add(ConfigNameDBB.普徴期情報_納付書の型6);
        list.add(ConfigNameDBB.普徴期情報_納付書の型7);
        list.add(ConfigNameDBB.普徴期情報_納付書の型8);
        list.add(ConfigNameDBB.普徴期情報_納付書の型9);
        list.add(ConfigNameDBB.普徴期情報_納付書の型10);
        list.add(ConfigNameDBB.普徴期情報_納付書の型11);
        list.add(ConfigNameDBB.普徴期情報_納付書の型12);
        list.add(ConfigNameDBB.普徴期情報_納付書の型13);
        list.add(ConfigNameDBB.普徴期情報_納付書の型14);
        return list;
    }

    private List<Enum> create普徴期情報_処理対象() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_処理対象1);
        list.add(ConfigNameDBB.普徴期情報_処理対象2);
        list.add(ConfigNameDBB.普徴期情報_処理対象3);
        list.add(ConfigNameDBB.普徴期情報_処理対象4);
        list.add(ConfigNameDBB.普徴期情報_処理対象5);
        list.add(ConfigNameDBB.普徴期情報_処理対象6);
        list.add(ConfigNameDBB.普徴期情報_処理対象7);
        list.add(ConfigNameDBB.普徴期情報_処理対象8);
        list.add(ConfigNameDBB.普徴期情報_処理対象9);
        list.add(ConfigNameDBB.普徴期情報_処理対象10);
        list.add(ConfigNameDBB.普徴期情報_処理対象11);
        list.add(ConfigNameDBB.普徴期情報_処理対象12);
        list.add(ConfigNameDBB.普徴期情報_処理対象13);
        list.add(ConfigNameDBB.普徴期情報_処理対象14);
        return list;
    }

    private List<Enum> create普徴期情報_月処理区分() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_月処理区分1);
        list.add(ConfigNameDBB.普徴期情報_月処理区分2);
        list.add(ConfigNameDBB.普徴期情報_月処理区分3);
        list.add(ConfigNameDBB.普徴期情報_月処理区分4);
        list.add(ConfigNameDBB.普徴期情報_月処理区分5);
        list.add(ConfigNameDBB.普徴期情報_月処理区分6);
        list.add(ConfigNameDBB.普徴期情報_月処理区分7);
        list.add(ConfigNameDBB.普徴期情報_月処理区分8);
        list.add(ConfigNameDBB.普徴期情報_月処理区分9);
        list.add(ConfigNameDBB.普徴期情報_月処理区分10);
        list.add(ConfigNameDBB.普徴期情報_月処理区分11);
        list.add(ConfigNameDBB.普徴期情報_月処理区分12);
        list.add(ConfigNameDBB.普徴期情報_月処理区分13);
        list.add(ConfigNameDBB.普徴期情報_月処理区分14);
        return list;
    }

    private List<Enum> create普徴期情報_月の期() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普徴期情報_月の期1);
        list.add(ConfigNameDBB.普徴期情報_月の期2);
        list.add(ConfigNameDBB.普徴期情報_月の期3);
        list.add(ConfigNameDBB.普徴期情報_月の期4);
        list.add(ConfigNameDBB.普徴期情報_月の期5);
        list.add(ConfigNameDBB.普徴期情報_月の期6);
        list.add(ConfigNameDBB.普徴期情報_月の期7);
        list.add(ConfigNameDBB.普徴期情報_月の期8);
        list.add(ConfigNameDBB.普徴期情報_月の期9);
        list.add(ConfigNameDBB.普徴期情報_月の期10);
        list.add(ConfigNameDBB.普徴期情報_月の期11);
        list.add(ConfigNameDBB.普徴期情報_月の期12);
        list.add(ConfigNameDBB.普徴期情報_月の期13);
        list.add(ConfigNameDBB.普徴期情報_月の期14);
        return list;
    }

    private List<Enum> create普通徴収_期別テーブル() {
        List<Enum> list = new ArrayList<>();
        list.add(ConfigNameDBB.普通徴収_期別テーブル1);
        list.add(ConfigNameDBB.普通徴収_期別テーブル2);
        list.add(ConfigNameDBB.普通徴収_期別テーブル3);
        list.add(ConfigNameDBB.普通徴収_期別テーブル4);
        list.add(ConfigNameDBB.普通徴収_期別テーブル5);
        list.add(ConfigNameDBB.普通徴収_期別テーブル6);
        list.add(ConfigNameDBB.普通徴収_期別テーブル7);
        list.add(ConfigNameDBB.普通徴収_期別テーブル8);
        list.add(ConfigNameDBB.普通徴収_期別テーブル9);
        list.add(ConfigNameDBB.普通徴収_期別テーブル10);
        list.add(ConfigNameDBB.普通徴収_期別テーブル11);
        list.add(ConfigNameDBB.普通徴収_期別テーブル12);
        list.add(ConfigNameDBB.普通徴収_期別テーブル13);
        list.add(ConfigNameDBB.普通徴収_期別テーブル14);
        return list;
    }

    private List<KeyValueDataSource> set月処理区分ddl() {
        List<KeyValueDataSource> 月処理区分 = new ArrayList<>();
        月処理区分.add(new KeyValueDataSource(FuchokiJohoTsukiShoriKubun.なし.getコード(),
                FuchokiJohoTsukiShoriKubun.なし.get名称()));
        月処理区分.add(new KeyValueDataSource(FuchokiJohoTsukiShoriKubun.普徴仮算定.getコード(),
                FuchokiJohoTsukiShoriKubun.普徴仮算定.get名称()));
        月処理区分.add(new KeyValueDataSource(FuchokiJohoTsukiShoriKubun.普徴仮算定異動.getコード(),
                FuchokiJohoTsukiShoriKubun.普徴仮算定異動.get名称()));
        月処理区分.add(new KeyValueDataSource(FuchokiJohoTsukiShoriKubun.特徴仮算定異動.getコード(),
                FuchokiJohoTsukiShoriKubun.特徴仮算定異動.get名称()));
        月処理区分.add(new KeyValueDataSource(FuchokiJohoTsukiShoriKubun.本算定.getコード(),
                FuchokiJohoTsukiShoriKubun.本算定.get名称()));
        月処理区分.add(new KeyValueDataSource(FuchokiJohoTsukiShoriKubun.本算定異動.getコード(),
                FuchokiJohoTsukiShoriKubun.本算定異動.get名称()));
        月処理区分.add(new KeyValueDataSource(FuchokiJohoTsukiShoriKubun.随時.getコード(),
                FuchokiJohoTsukiShoriKubun.随時.get名称()));
        月処理区分.add(new KeyValueDataSource(FuchokiJohoTsukiShoriKubun.現年随時.getコード(),
                FuchokiJohoTsukiShoriKubun.現年随時.get名称()));
        return 月処理区分;
    }

    private List<KeyValueDataSource> set処理対象ddl() {
        List<KeyValueDataSource> 処理対象 = new ArrayList<>();
        処理対象.add(new KeyValueDataSource(FuchoSyoriTaisho.なし.getコード(), FuchoSyoriTaisho.なし.get名称()));
        処理対象.add(new KeyValueDataSource(FuchoSyoriTaisho.全件対象.getコード(), FuchoSyoriTaisho.全件対象.get名称()));
        処理対象.add(new KeyValueDataSource(FuchoSyoriTaisho.異動分のみ対象.getコード(), FuchoSyoriTaisho.異動分のみ対象.get名称()));
        return 処理対象;
    }

    private List<KeyValueDataSource> set納付書の型ddl() {
        List<KeyValueDataSource> 納付書の型 = new ArrayList<>();
        納付書の型.add(new KeyValueDataSource(NofusyoType.なし.getコード(), NofusyoType.なし.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.期毎.getコード(), NofusyoType.期毎.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.銀振型5期.getコード(), NofusyoType.銀振型5期.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.銀振型4期.getコード(), NofusyoType.銀振型4期.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.ブック.getコード(), NofusyoType.ブック.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.コンビニ.getコード(), NofusyoType.コンビニ.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.その他.getコード(), NofusyoType.その他.get名称()));
        return 納付書の型;
    }

    private List<KeyValueDataSource> set納付書の型ddl2() {
        List<KeyValueDataSource> 納付書の型 = new ArrayList<>();
        納付書の型.add(new KeyValueDataSource(NofusyoType.期毎.getコード(), NofusyoType.期毎.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.銀振型5期.getコード(), NofusyoType.銀振型5期.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.銀振型4期.getコード(), NofusyoType.銀振型4期.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.ブック.getコード(), NofusyoType.ブック.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.コンビニ.getコード(), NofusyoType.コンビニ.get名称()));
        納付書の型.add(new KeyValueDataSource(NofusyoType.その他.getコード(), NofusyoType.その他.get名称()));
        return 納付書の型;
    }

    private List<KeyValueDataSource> set印字位置ddl() {
        List<KeyValueDataSource> 印字位置 = new ArrayList<>();
        int i = 1;
        while (i < 数字１３) {
            印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)), new RString(String.valueOf(i))));
            i = i + 1;
        }
        return 印字位置;
    }

    private List<KeyValueDataSource> setＣＶＳカット印字位置ddl() {
        List<KeyValueDataSource> ＣＶＳカット印字位置 = new ArrayList<>();
        int i = 1;
        while (i < 数字１３) {
            ＣＶＳカット印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)), new RString(String.valueOf(i))));
            i = i + 1;
        }
        return ＣＶＳカット印字位置;
    }

    private List<KeyValueDataSource> setＣＶＳカット印字位置ddl2() {
        List<KeyValueDataSource> ＣＶＳカット印字位置 = new ArrayList<>();
        int i = 1;
        while (i < 数字５) {
            ＣＶＳカット印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)), new RString(String.valueOf(i))));
            i = i + 1;
        }
        return ＣＶＳカット印字位置;
    }

    private List<KeyValueDataSource> setＣＶＳ連帳印字位置ddl() {
        List<KeyValueDataSource> ＣＶＳ連帳印字位置 = new ArrayList<>();
        int i = 1;
        while (i < 数字１３) {
            ＣＶＳ連帳印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)), new RString(String.valueOf(i))));
            i = i + 1;
        }
        return ＣＶＳ連帳印字位置;
    }

    private List<KeyValueDataSource> setＣＶＳ連帳印字位置ddl2() {
        List<KeyValueDataSource> ＣＶＳ連帳印字位置 = new ArrayList<>();
        int i = 1;
        while (i < 数字７) {
            ＣＶＳ連帳印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)), new RString(String.valueOf(i))));
            i = i + 1;
        }
        return ＣＶＳ連帳印字位置;
    }

    private List<KeyValueDataSource> setブック開始位置ddl() {
        List<KeyValueDataSource> ブック開始位置 = new ArrayList<>();
        int i = 1;
        while (i < 数字６) {
            ブック開始位置.add(new KeyValueDataSource(new RString(String.valueOf(i)), new RString(String.valueOf(i))));
            i = i + 1;
        }
        return ブック開始位置;
    }

    private List<KeyValueDataSource> set納入通知書連帳区分ddl() {
        List<KeyValueDataSource> 納入通知書連帳区分 = new ArrayList<>();
        納入通知書連帳区分.add(new KeyValueDataSource(NonyuTsuchishoRenchoKubun.カット紙.getコード(),
                NonyuTsuchishoRenchoKubun.カット紙.get名称()));
        納入通知書連帳区分.add(new KeyValueDataSource(NonyuTsuchishoRenchoKubun.連帳.getコード(),
                NonyuTsuchishoRenchoKubun.連帳.get名称()));
        return 納入通知書連帳区分;
    }

    private List<KeyValueDataSource> set納付書出力条件ddl() {
        List<KeyValueDataSource> 納付書出力条件 = new ArrayList<>();
        納付書出力条件.add(new KeyValueDataSource(TsuchishoPrintConditions.なし.getコード(),
                TsuchishoPrintConditions.なし.get名称()));
        納付書出力条件.add(new KeyValueDataSource(TsuchishoPrintConditions.全被保険者_異動時は異動分全件.getコード(),
                TsuchishoPrintConditions.全被保険者_異動時は異動分全件.get略称()));
        納付書出力条件.add(new KeyValueDataSource(TsuchishoPrintConditions.差引き保険料１円以上の被保険者.getコード(),
                TsuchishoPrintConditions.差引き保険料１円以上の被保険者.get略称()));
        納付書出力条件.add(new KeyValueDataSource(TsuchishoPrintConditions.保険料変更有りで差引き保険料１円以上の被保険者_異動分のみ.getコード(),
                TsuchishoPrintConditions.保険料変更有りで差引き保険料１円以上の被保険者_異動分のみ.get略称()));
        納付書出力条件.add(new KeyValueDataSource(TsuchishoPrintConditions.差引き保険料０円以外で確定保険料がある被保険者_当初のみ.getコード(),
                TsuchishoPrintConditions.差引き保険料０円以外で確定保険料がある被保険者_当初のみ.get略称()));
        return 納付書出力条件;
    }

    private List<KeyValueDataSource> set口座対象者出力ddl() {
        List<KeyValueDataSource> 口座対象者出力 = new ArrayList<>();
        口座対象者出力.add(new KeyValueDataSource(KozaTaishoshaSyutsuryoku.する.getコード(),
                KozaTaishoshaSyutsuryoku.する.get名称()));
        口座対象者出力.add(new KeyValueDataSource(KozaTaishoshaSyutsuryoku.しない.getコード(),
                KozaTaishoshaSyutsuryoku.しない.get名称()));
        return 口座対象者出力;
    }

    private List<KeyValueDataSource> set端数ddl() {
        List<KeyValueDataSource> 端数 = new ArrayList<>();
        端数.add(new KeyValueDataSource(HasuChoseiTani._1.getコード(),
                HasuChoseiTani._1.get略称()));
        端数.add(new KeyValueDataSource(HasuChoseiTani._10.getコード(),
                HasuChoseiTani._10.get略称()));
        端数.add(new KeyValueDataSource(HasuChoseiTani._100.getコード(),
                HasuChoseiTani._100.get略称()));
        端数.add(new KeyValueDataSource(HasuChoseiTani._1000.getコード(),
                HasuChoseiTani._1000.get略称()));
        return 端数;
    }

    private List<KeyValueDataSource> set賦課方法ddl() {
        List<KeyValueDataSource> 賦課方法 = new ArrayList<>();
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.仮算定賦課なし.getコード(),
                FuchoZanteiKeisanHoho.仮算定賦課なし.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.前年度_最終期保険料額.getコード(),
                FuchoZanteiKeisanHoho.前年度_最終期保険料額.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.前年度末_基準年額_今納期数.getコード(),
                FuchoZanteiKeisanHoho.前年度末_基準年額_今納期数.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.前年度末_基準年額_前納期数.getコード(),
                FuchoZanteiKeisanHoho.前年度末_基準年額_前納期数.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.前年度_確定年額_今納期数.getコード(),
                FuchoZanteiKeisanHoho.前年度_確定年額_今納期数.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_全納期数.getコード(),
                FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_全納期数.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_賦課納期数.getコード(),
                FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_賦課納期数.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数.getコード(),
                FuchoZanteiKeisanHoho.今年度_基準年額_今納期数.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.前年度_基準年額乗３分の４_今納期数.getコード(),
                FuchoZanteiKeisanHoho.前年度_基準年額乗３分の４_今納期数.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.前年度_確定年額乗３分の４_今納期数.getコード(),
                FuchoZanteiKeisanHoho.前年度_確定年額乗３分の４_今納期数.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_段階補正.getコード(),
                FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_段階補正.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.その他.getコード(),
                FuchoZanteiKeisanHoho.その他.get略称()));
        return 賦課方法;
    }

    private List<KeyValueDataSource> set異動方法ddl() {
        List<KeyValueDataSource> 異動方法 = new ArrayList<>();
        異動方法.add(new KeyValueDataSource(ZanteiKeisanIdoHoho._4月喪失のみ0円にする.getコード(),
                ZanteiKeisanIdoHoho._4月喪失のみ0円にする.get名称()));
        異動方法.add(new KeyValueDataSource(ZanteiKeisanIdoHoho.喪失月以降0円にする.getコード(),
                ZanteiKeisanIdoHoho.喪失月以降0円にする.get名称()));
        return 異動方法;
    }

    private List<KeyValueDataSource> set暫定併徴者普徴分徴収有無() {
        List<KeyValueDataSource> 暫定併徴者普徴分徴収有無 = new ArrayList<>();
        暫定併徴者普徴分徴収有無.add(new KeyValueDataSource(ZanteiHeichoshaFuchobunChoshuUmu.徴収する.getコード(),
                ZanteiHeichoshaFuchobunChoshuUmu.徴収する.get名称()));
        暫定併徴者普徴分徴収有無.add(new KeyValueDataSource(ZanteiHeichoshaFuchobunChoshuUmu.徴収しない.getコード(),
                ZanteiHeichoshaFuchobunChoshuUmu.徴収しない.get名称()));
        return 暫定併徴者普徴分徴収有無;
    }

    /**
     * 前排他キーのセット
     *
     * @return boolean
     */
    public boolean 前排他キーのセット() {
        LockingKey 排他キー = new LockingKey(((_IServletControlData) _ControlDataHolder.getControlData()).getGamenID());
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除
     */
    public void 前排他キーの解除() {
        LockingKey 排他キー = new LockingKey(((_IServletControlData) _ControlDataHolder.getControlData()).getGamenID());
        RealInitialLocker.release(排他キー);
    }
}
