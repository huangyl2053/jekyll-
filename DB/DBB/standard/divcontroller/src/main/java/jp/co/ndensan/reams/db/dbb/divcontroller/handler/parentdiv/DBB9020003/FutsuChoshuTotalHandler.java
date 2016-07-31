/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukinitsuNokiKanri;
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
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukinitsuNokiKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.noki.nokikanri.NokiManager;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * システム管理情報（普通徴収）
 *
 * @reamsid_L DBB-1770-050 xupeng
 */
public final class FutsuChoshuTotalHandler {

    private final FutsuChoshuTotalDiv div;
    private static final RString 現年度 = new RString("現年度");
    private static final RString 未作成 = new RString("未作成");
    private static final RString 作成済 = new RString("作成済");
    private static final RString 合併旧市町村表示区分_表示あり = new RString("1");
    private static final RString メッセージ = new RString("保険者が単一市町村または広域市町村ではないため処理の継続");
    private static final RString メッセージ_現年度 = new RString("現年度のxx月のyy");
    private static final RString メッセージ_過年度 = new RString("過年度のxx月のyy");
    private static final RString メッセージ_正常 = new RString("システム管理登録_普通徴収保存処理は正常に行われました");
    private static final RString MSG = new RString("調定年度：");
    private static final RString MSG_NENNDO = new RString("年度");
    private static final RString 当行月 = new RString("xx");
    private static final RString セル名 = new RString("yy");
    private static final RString 発行日 = new RString("発行日");
    private static final RString 納期限 = new RString("納期限");
    private static final RString 納期_自 = new RString("納期（自）");
    private static final RString 納期_至 = new RString("納期（至）");
    private static final RString 納期限_自 = new RString("納期限（自）");
    private static final RString 納期限_至 = new RString("納期限（至）");
    private static final RString コード種別 = new RString("0002");
    private static final FlexibleYear 平成12年 = new FlexibleYear("2000");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString FOURTEEN = new RString("14");
    private static final RString FIFTEEN = new RString("15");
    private static final int 数字_１５ = 15;
    private static final int 数字_１３ = 13;
    private static final int 数字_１２ = 12;
    private static final int 数字_１０ = 10;
    private static final int 数字_８ = 8;
    private static final int 数字_７ = 7;
    private static final int 数字_６ = 6;
    private static final int 数字_５ = 5;
    private static final int 数字_４ = 4;
    private static final int 数字_３ = 3;
    private static final int 数字_２ = 2;
    private static final int 数字_１ = 1;
    private static final RString 月の期_00 = new RString("00");
    private static final RString 第４月 = new RString("04");
    private static final RString 第５月 = new RString("05");
    private static final RDate システム日時 = RDate.getNowDate();
    private static final RString 書式 = new RString("%02d");
    private static final RString 変更理由 = new RString("を使用して更新");

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
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(
                ConfigNameDBB.日付関連_調定年度, システム日時, SubGyomuCode.DBB介護賦課));
        RString 新年度管理情報;
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        ShoriDateKanri result = manager.get基準年月日(ShoriName.新年度管理情報作成.get名称(), 調定年度.plusYear(1));
        if (result == null) {
            新年度管理情報 = 未作成;
        } else if (result.get基準年月日() == null || result.get基準年月日().isEmpty()) {
            新年度管理情報 = 未作成;
        } else {
            新年度管理情報 = 作成済;
        }

        if (未作成.equals(新年度管理情報)) {
            div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setDataSource(set選択可能年度(調定年度));
        } else {
            div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setDataSource(set選択可能年度(調定年度.plusYear(1)));
        }
        div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setSelectedKey(調定年度.toDateString());
    }

    private List<KeyValueDataSource> set選択可能年度(FlexibleYear 調定年度) {
        List<KeyValueDataSource> keyValueData = new ArrayList<>();
        for (; 平成12年.isBeforeOrEquals(調定年度); 調定年度 = 調定年度.minusYear(1)) {
            keyValueData.add(new KeyValueDataSource(調定年度.toDateString(),
                    調定年度.wareki().firstYear(FirstYear.ICHI_NEN).toDateString()));
        }
        return keyValueData;
    }

    private List<KeyValueDataSource> set市町村指定DDL(ShichosonSecurityJoho 市町村セキュリティ情報, FlexibleYear 調定年度) {
        List<KeyValueDataSource> 市町村 = new ArrayList<>();
        FukinitsuNokiKanriManager manager = InstanceProvider.create(FukinitsuNokiKanriManager.class);
        List<FukinitsuNokiKanri> 不均一納期リスト = manager.get市町村コード(調定年度);
        if (不均一納期リスト == null || 不均一納期リスト.isEmpty()) {
            return 市町村;
        }
        for (FukinitsuNokiKanri 不均一納期 : 不均一納期リスト) {
            if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
                set合併市町村DDL(不均一納期, 市町村);
            } else if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
                set構成市町村DDL(不均一納期, 市町村);
            }
        }
        return 市町村;
    }

    private void set合併市町村DDL(FukinitsuNokiKanri 不均一納期, List<KeyValueDataSource> 市町村) {
        KyuShichosonCodeJoho 合併市町村情報 = KyuShichosonCode
                .getKyuShichosonCodeJoho(不均一納期.get市町村コード(), DonyuKeitaiCode.事務単一);
        if (合併市町村情報 != null && 合併市町村情報.is合併市町村有無フラグ()
                && !合併市町村情報.get旧市町村コード情報List().isEmpty()) {
            for (KyuShichosonCode コード情報 : 合併市町村情報.get旧市町村コード情報List()) {
                if (不均一納期.get市町村コード().equals(コード情報.get旧市町村コード())) {
                    市町村.add(new KeyValueDataSource(不均一納期.get市町村コード().getColumnValue(),
                            コード情報.get旧市町村名称()));
                    break;
                }
            }
        }
    }

    private void set構成市町村DDL(FukinitsuNokiKanri 不均一納期, List<KeyValueDataSource> 市町村) {
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        SearchResult<ShichosonCodeYoriShichoson> 構成市町村マスタ
                = finder.shichosonCodeYoriShichosonJoho(不均一納期.get市町村コード());
        if (構成市町村マスタ == null || 構成市町村マスタ.records().isEmpty()) {
            return;
        }
        for (int i = 0; i < 構成市町村マスタ.records().size(); i++) {
            if (合併旧市町村表示区分_表示あり.equals(構成市町村マスタ.records().get(i).get合併旧市町村表示有無())
                    && 不均一納期.get市町村コード().equals(構成市町村マスタ.records().get(i).get市町村コード())) {
                市町村.add(new KeyValueDataSource(不均一納期.get市町村コード().getColumnValue(),
                        構成市町村マスタ.records().get(i).get市町村名称()));
            }
        }
    }

    /**
     * 市町村指定設定
     */
    public void set市町村指定() {
        FlexibleYear 調定年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 不均一納期期限 = new FlexibleYear(DbBusinessConfig.get(
                ConfigNameDBB.ランク管理情報_不均一納期期限, システム日時, SubGyomuCode.DBB介護賦課));

        if (不均一納期期限.isBefore(調定年度)) {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(false);
            return;
        }

        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報.get導入形態コード() == null) {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(false);
            return;
        }

        導入形態判定(市町村セキュリティ情報, 調定年度);
        if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().getDataSource().isEmpty()) {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setSelectedIndex(0);
        }
    }

    private void 導入形態判定(ShichosonSecurityJoho 市町村セキュリティ情報, FlexibleYear 調定年度) {
        if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
            RString 合併情報区分 = DbBusinessConfig.get(
                    ConfigNameDBU.合併情報管理_合併情報区分, システム日時, SubGyomuCode.DBU介護統計報告);
            if (ZERO.equals(合併情報区分)) {
                div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(false);
            } else if (ONE.equals(合併情報区分)) {
                div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(true);
                div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setDataSource(set市町村指定DDL(市町村セキュリティ情報, 調定年度));
            }
        } else if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(true);
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setDataSource(set市町村指定DDL(市町村セキュリティ情報, 調定年度));
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

    private void initGird_現年度(RString 普通徴収_期別テーブル, RString 普徴期情報_月の期,
            RString 普徴期情報_月処理区分, RString 普徴期情報_処理対象, RString 普徴期情報_納付書の型,
            RString 普徴期情報_納付書の印字位置, RString 普徴期情報_コンビニカット印字位置,
            RString 普徴期情報_コンビニ連帳印字位置, RString 普徴期情報_ブック開始位置,
            RString 普徴期情報_納通連帳区分, RString 普徴期情報_通知書プリント条件,
            RString 普徴期情報_口座対象者プリント条件, dgGenNendoKibetsuJoho_Row row) {
        if (普通徴収_期別テーブル.equals(row.getTxtTsuki())
                || (FOURTEEN.equals(普通徴収_期別テーブル) && 第４月.equals(row.getTxtTsuki()))
                || (FIFTEEN.equals(普通徴収_期別テーブル) && 第５月.equals(row.getTxtTsuki()))) {
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
        int m = 数字_４;

        if (div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getGridSetting().getColumns().get(数字_５).setVisible(false);
            div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getGridSetting().getColumns().get(数字_６).setVisible(false);
            div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getGridSetting().getColumns().get(数字_７).setVisible(false);
            div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getGridSetting().getColumns().get(数字_８).setVisible(false);
        } else {
            div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getGridSetting().getColumns().get(数字_５).setVisible(true);
            div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getGridSetting().getColumns().get(数字_６).setVisible(true);
            div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getGridSetting().getColumns().get(数字_７).setVisible(true);
            div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getGridSetting().getColumns().get(数字_８).setVisible(true);
        }

        List<dgGenNendoKibetsuJoho_Row> list = new ArrayList<>();
        for (int i = 1; i < 数字_１５; i = i + 1) {
            dgGenNendoKibetsuJoho_Row row = new dgGenNendoKibetsuJoho_Row();
            row.getDdlTsukiShoriKbn().setDataSource(set月処理区分ddl());
            row.getDdlShoriTaisho().setDataSource(set処理対象ddl());
            row.getDdlNofushoKata().setDataSource(set納付書の型ddl());
            row.getDdlInjiIchi().setDataSource(set印字位置ddl());
            row.getDdlCVSCutInjiIchi().setDataSource(setＣＶＳカット印字位置ddl());
            row.getDdlCVSRenChoInjiIchi().setDataSource(setＣＶＳ連帳印字位置ddl());
            row.getDdlBookStInjiIchi().setDataSource(setブック開始位置ddl());
            row.getDdlRenchoKbn().setDataSource(set納入通知書連帳区分ddl());
            row.getDdlOutputJoken().setDataSource(set納付書出力条件ddl());
            row.getDdlKozaTaishoshaOutput().setDataSource(set口座対象者出力ddl());
            if (i == 数字_１０) {
                m = 1;
            }
            row.setTxtTsuki(new RString(String.format(書式.toString(), m)));
            list.add(row);
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
            initGird_現年度(DbBusinessConfig.get(普通徴収_期別テーブル.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_月の期.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_月処理区分.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_処理対象.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_納付書の型.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_納付書の印字位置.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_コンビニカット印字位置.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_コンビニ連帳印字位置.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_ブック開始位置.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_納通連帳区分.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_通知書プリント条件.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(普徴期情報_口座対象者プリント条件.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    row);
            i = i + 1;
        }

        list = set現年度Grid制御(list);
        div.getFutsuChoshu().getDgGenNendoKibetsuJoho().setDataSource(list);
    }

    private void set期別保険料() {
        div.getFutsuChoshu().getDdlHasu().setDataSource(set端数ddl());
        div.getFutsuChoshu().getDdlHasu().setSelectedKey(DbBusinessConfig.get(ConfigNameDBB.普通徴収_期別端数,
                システム日時, SubGyomuCode.DBB介護賦課));
    }

    private void set暫定計算方法() {
        div.getFutsuChoshu().getDdlFukaHoho().setDataSource(set賦課方法ddl());
        div.getFutsuChoshu().getDdlFukaHoho().setSelectedKey(DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定賦課方法,
                システム日時, SubGyomuCode.DBB介護賦課));
        RString 賦課方法説明 = CodeMaster.getCode(SubGyomuCode.DBB介護賦課, new CodeShubetsu(コード種別),
                new Code(div.getFutsuChoshu().getZanteiKeisanHoho().getDdlFukaHoho().getSelectedKey()),
                new FlexibleDate(システム日時.toDateString())).getコード名称();
        div.getFutsuChoshu().getZanteiKeisanHoho().getTxtFukaHohoHelp().setValue(賦課方法説明);
        div.getFutsuChoshu().getDdlIdoHoho().setDataSource(set異動方法ddl());
        div.getFutsuChoshu().getDdlIdoHoho().setSelectedKey(DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動方法,
                システム日時, SubGyomuCode.DBB介護賦課));
        List<KeyValueDataSource> 端数調整 = new ArrayList<>();
        端数調整.add(new KeyValueDataSource(ZanteiKeisanHasuChosei.あり.getコード(),
                ZanteiKeisanHasuChosei.あり.get略称()));
        端数調整.add(new KeyValueDataSource(ZanteiKeisanHasuChosei.なし.getコード(),
                ZanteiKeisanHasuChosei.なし.get略称()));
        div.getFutsuChoshu().getRadHasuChosei().setDataSource(端数調整);
        div.getFutsuChoshu().getRadHasuChosei().setSelectedKey(DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定端数調整有無,
                システム日時, SubGyomuCode.DBB介護賦課));
        div.getFutsuChoshu().getRadHeichoSha().setDataSource(set暫定併徴者普徴分徴収有無());
        div.getFutsuChoshu().getRadHeichoSha().setSelectedKey(DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定併徴者普徴分徴収有無,
                システム日時, SubGyomuCode.DBB介護賦課));
    }

    private List<dgKaNendoKibetsuJoho_Row> create過年度期別情報Grid() {
        List<dgKaNendoKibetsuJoho_Row> list = new ArrayList<>();
        int m = 数字_４;
        if (div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getGridSetting().getColumns().get(数字_３).setVisible(false);
            div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getGridSetting().getColumns().get(数字_４).setVisible(false);
            div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getGridSetting().getColumns().get(数字_５).setVisible(false);
            div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getGridSetting().getColumns().get(数字_６).setVisible(false);
        } else {
            div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getGridSetting().getColumns().get(数字_３).setVisible(true);
            div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getGridSetting().getColumns().get(数字_４).setVisible(true);
            div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getGridSetting().getColumns().get(数字_５).setVisible(true);
            div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getGridSetting().getColumns().get(数字_６).setVisible(true);
        }

        for (int i = 1; i < 数字_１３; i = i + 1) {
            dgKaNendoKibetsuJoho_Row row = new dgKaNendoKibetsuJoho_Row();
            row.getDdlNofushoKata().setDataSource(set納付書の型ddl_過年度());
            row.getDdlInjiIchi().setDataSource(set印字位置ddl());
            row.getDdlCVSCutInjiIchi().setDataSource(setＣＶＳカット印字位置ddl_過年度());
            row.getDdlCVSRenChoInjiIchi().setDataSource(setＣＶＳ連帳印字位置ddl_過年度());
            row.getDdlBookStInjiIchi().setDataSource(setブック開始位置ddl());
            row.getDdlOutputJoken().setDataSource(set納付書出力条件ddl());
            row.getDdlKozaTaishoshaOutput().setDataSource(set口座対象者出力ddl());
            List<KeyValueDataSource> 過年度の歳出 = new ArrayList<>();
            過年度の歳出.add(new KeyValueDataSource(KanendoSaishutsu.過年度.getコード(),
                    KanendoSaishutsu.過年度.get名称()));
            過年度の歳出.add(new KeyValueDataSource(KanendoSaishutsu.現年度.getコード(),
                    KanendoSaishutsu.現年度.get名称()));
            row.getDdlSaiShutsu().setDataSource(過年度の歳出);
            if (i == 数字_１０) {
                m = 1;
            }
            row.setTxtTsuki(new RString(String.format(書式.toString(), m)));
            list.add(row);
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
            initGird_過年度(
                    DbBusinessConfig.get(過年度_期別テーブル.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(過年度期情報_月の期.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(過年度期情報_納付書の型.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(過年度期情報_納付書の印字位置.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(過年度期情報_コンビニカット印字位置.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(過年度期情報_コンビニ連帳印字位置.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(過年度期情報_ブック開始位置.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(過年度期情報_通知書プリント条件.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    DbBusinessConfig.get(過年度期情報_口座対象者プリント条件.get(i), システム日時, SubGyomuCode.DBB介護賦課),
                    row);
            i = i + 1;
        }
        list = set過年度Grid制御(list);
        div.getFutsuChoshu().getDgKaNendoKibetsuJoho().setDataSource(list);
    }

    private void initGird_過年度(RString 過年度_期別テーブル, RString 過年度期情報_月の期,
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
            row.getDdlSaiShutsu().setSelectedKey(DbBusinessConfig.get(
                    ConfigNameDBB.過年度期情報_過年度の歳出1, システム日時, SubGyomuCode.DBB介護賦課));
        } else if (第５月.equals(row.getTxtTsuki())) {
            row.getDdlSaiShutsu().setSelectedKey(DbBusinessConfig.get(
                    ConfigNameDBB.過年度期情報_過年度の歳出2, システム日時, SubGyomuCode.DBB介護賦課));
        } else {
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
    public dgKaNendoKibetsuJoho_Row set納付書の型変更_過年度(dgKaNendoKibetsuJoho_Row row) {
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
                new FlexibleDate(システム日時.toDateString())).getコード名称();
        div.getFutsuChoshu().getZanteiKeisanHoho().getTxtFukaHohoHelp().setValue(賦課方法説明);
    }

    private List<dgGenNendoKibetsuJoho_Row> set現年度Grid制御(List<dgGenNendoKibetsuJoho_Row> list) {
        int rowId = 1;
        RString ki = 月の期_00;
        for (dgGenNendoKibetsuJoho_Row row : list) {
            if (row.getSelected()) {
                ki = new RString(String.format(書式.toString(), rowId));
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

        for (int size = list.size() - 1; size >= 0; size = size - 1) {
            if (list.get(size).getSelected()) {
                break;
            }
            list.get(size).setTxtTsukinoKi(月の期_00);
        }
        return list;
    }

    private List<dgKaNendoKibetsuJoho_Row> set過年度Grid制御(List<dgKaNendoKibetsuJoho_Row> list) {
        int rowId = 1;
        RString ki = 月の期_00;
        for (dgKaNendoKibetsuJoho_Row row : list) {
            if (row.getSelected()) {
                ki = new RString(String.format(書式.toString(), rowId));
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
                row = set納付書の型変更_過年度(row);
                row.getDdlRenchoKbn().setDisabled(false);
                row.getDdlOutputJoken().setDisabled(false);
                row.getDdlKozaTaishoshaOutput().setDisabled(false);
                if (第４月.equals(row.getTxtTsuki())) {
                    row.getDdlSaiShutsu().setDisabled(false);
                    row.getDdlSaiShutsu().setSelectedKey(DbBusinessConfig.get(
                            ConfigNameDBB.過年度期情報_過年度の歳出1, システム日時, SubGyomuCode.DBB介護賦課));
                } else if (第５月.equals(row.getTxtTsuki())) {
                    row.getDdlSaiShutsu().setDisabled(false);
                    row.getDdlSaiShutsu().setSelectedKey(DbBusinessConfig.get(
                            ConfigNameDBB.過年度期情報_過年度の歳出2, システム日時, SubGyomuCode.DBB介護賦課));
                }
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

        for (int size = list.size() - 1; size >= 0; size = size - 1) {
            if (list.get(size).getSelected()) {
                break;
            }
            list.get(size).setTxtTsukinoKi(月の期_00);
        }
        return list;
    }

    private void 現年度入力チェック() {
        if (div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            return;
        }
        for (dgGenNendoKibetsuJoho_Row row : div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getDataSource()) {
            if (row.getTxtKi() != null && !row.getTxtKi().isEmpty()) {
                if (row.getTxtHakkoYMD().getValue() == null || row.getTxtHakkoYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(row, null, 発行日).toString()));
                }
                if (row.getTxtNokigenYMD().getValue() == null || row.getTxtNokigenYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(row, null, 納期限).toString()));
                }
                if (row.getTxtNokigenStYMD().getValue() == null || row.getTxtNokigenStYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(row, null, 納期限_自).toString()));
                }
                if (row.getTxtNokigenEdYMD().getValue() == null || row.getTxtNokigenEdYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(row, null, 納期限_至).toString()));
                }
            }
        }
    }

    private void 過年度入力チェック() {
        if (div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            return;
        }
        for (dgKaNendoKibetsuJoho_Row row : div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getDataSource()) {
            if (row.getTxtKi() != null && !row.getTxtKi().isEmpty()) {
                if (row.getTxtHakkoYMD().getValue() == null || row.getTxtHakkoYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(null, row, 発行日).toString()));
                }
                if (row.getTxtNokigenYMD().getValue() == null || row.getTxtNokigenYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(null, row, 納期限).toString()));
                }
                if (row.getTxtNokigenStYMD().getValue() == null || row.getTxtNokigenStYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(null, row, 納期_自).toString()));
                }
                if (row.getTxtNokigenEtYMD().getValue() == null || row.getTxtNokigenEtYMD().getValue().isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                            replace(setメッセージ(null, row, 納期_至).toString()));
                }
            }
        }
    }

    private RString setメッセージ(dgGenNendoKibetsuJoho_Row row, dgKaNendoKibetsuJoho_Row row2, RString columnName) {
        RStringBuilder message;
        if (row != null) {
            message = new RStringBuilder(メッセージ_現年度);
            message.replace(当行月, row.getTxtTsuki());
            message.replace(セル名, columnName);
        } else {
            message = new RStringBuilder(メッセージ_過年度);
            message.replace(当行月, row2.getTxtTsuki());
            message.replace(セル名, columnName);
        }
        return message.toRString();
    }

    /**
     * 保存処理
     *
     * @return 調定年度
     */
    public RString set保存処理() {
        RString 理由 = get変更理由();
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
                普徴期情報_仮算定期数 = 普徴期情報_仮算定期数 + 数字_１;
            }
            if (FuchokiJohoTsukiShoriKubun.普徴仮算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.普徴仮算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.本算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.本算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())) {
                普徴期情報_定例納期数 = 普徴期情報_定例納期数 + 数字_１;
            }
            if (FuchokiJohoTsukiShoriKubun.普徴仮算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.普徴仮算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.本算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.本算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.現年随時.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || FuchokiJohoTsukiShoriKubun.随時.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())) {
                普徴期情報_設定納期数 = 普徴期情報_設定納期数 + 数字_１;
            }

            update(row.getTxtTsukinoKi(), 普徴期情報_月の期.get(i), 理由);
            if (row.getSelected()) {
                if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
                    NokiManager nokiManager = new NokiManager();
                    Noki noki = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                            new RYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey()),
                            GennenKanen.現年度,
                            Integer.parseInt(row.getTxtKi().toString()));
                    save納期(noki, row);
                }
                if (i == 数字_１２) {
                    update(FOURTEEN, 普通徴収_期別テーブル.get(i), 理由);
                } else if (i == 数字_１３) {
                    update(FIFTEEN, 普通徴収_期別テーブル.get(i), 理由);
                } else {
                    update(row.getTxtTsuki(), 普通徴収_期別テーブル.get(i), 理由);
                }
                update(row.getDdlTsukiShoriKbn().getSelectedKey(), 普徴期情報_月処理区分.get(i), 理由);
                update(row.getDdlShoriTaisho().getSelectedKey(), 普徴期情報_処理対象.get(i), 理由);
                update(row.getDdlNofushoKata().getSelectedKey(), 普徴期情報_納付書の型.get(i), 理由);
                update(row.getDdlInjiIchi().getSelectedKey(), 普徴期情報_納付書の印字位置.get(i), 理由);
                update(row.getDdlCVSCutInjiIchi().getSelectedKey(), 普徴期情報_コンビニカット印字位置.get(i), 理由);
                update(row.getDdlCVSRenChoInjiIchi().getSelectedKey(), 普徴期情報_コンビニ連帳印字位置.get(i), 理由);
                update(row.getDdlBookStInjiIchi().getSelectedKey(), 普徴期情報_ブック開始位置.get(i), 理由);
                update(row.getDdlRenchoKbn().getSelectedKey(), 普徴期情報_納通連帳区分.get(i), 理由);
                update(row.getDdlOutputJoken().getSelectedKey(), 普徴期情報_通知書プリント条件.get(i), 理由);
                update(row.getDdlKozaTaishoshaOutput().getSelectedKey(), 普徴期情報_口座対象者プリント条件.get(i), 理由);
            } else {
                update(RString.EMPTY, 普通徴収_期別テーブル.get(i), 理由);
            }
            i = i + 1;
        }
        update(new RString(String.valueOf(普徴期情報_仮算定期数)), ConfigNameDBB.普徴期情報_仮算定期数, 理由);
        update(new RString(String.valueOf(普徴期情報_定例納期数)), ConfigNameDBB.普徴期情報_定例納期数, 理由);
        update(new RString(String.valueOf(普徴期情報_設定納期数)), ConfigNameDBB.普徴期情報_設定納期数, 理由);
        update(div.getFutsuChoshu().getDdlHasu().getSelectedKey(), ConfigNameDBB.普通徴収_期別端数, 理由);
        update(div.getFutsuChoshu().getDdlFukaHoho().getSelectedKey(), ConfigNameDBB.普通徴収_仮算定賦課方法, 理由);
        update(div.getFutsuChoshu().getDdlIdoHoho().getSelectedKey(), ConfigNameDBB.普通徴収_仮算定異動方法, 理由);
        update(div.getFutsuChoshu().getRadHasuChosei().getSelectedKey(), ConfigNameDBB.普通徴収_仮算定端数調整有無, 理由);
        update(div.getFutsuChoshu().getRadHeichoSha().getSelectedKey(), ConfigNameDBB.普通徴収_仮算定併徴者普徴分徴収有無, 理由);

        save保存処理_過年度();
        return div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedValue();
    }

    private void save納期(Noki noki, dgGenNendoKibetsuJoho_Row row) {
        if (!noki.get通知書発行日().equals(new RDate(row.getTxtHakkoYMD().getValue().toString()))
                || !noki.get納期限().equals(new RDate(row.getTxtNokigenYMD().getValue().toString()))
                || !noki.get納期開始日().equals(new RDate(row.getTxtNokigenStYMD().getValue().toString()))
                || !noki.get納期終了日().equals(new RDate(row.getTxtNokigenEdYMD().getValue().toString()))) {
            noki = noki.createBuilderForEdit().
                    set通知書発行日(new RDate(row.getTxtHakkoYMD().getValue().toString())).
                    set納期限(new RDate(row.getTxtNokigenYMD().getValue().toString())).
                    set納期開始日(new RDate(row.getTxtNokigenStYMD().getValue().toString())).
                    set納期終了日(new RDate(row.getTxtNokigenEdYMD().getValue().toString())).build();
            new NokiManager().save納期(noki);
        }
    }

    private void save納期_過年度(Noki noki, dgKaNendoKibetsuJoho_Row row) {
        if (!noki.get通知書発行日().equals(new RDate(row.getTxtHakkoYMD().getValue().toString()))
                || !noki.get納期限().equals(new RDate(row.getTxtNokigenYMD().getValue().toString()))
                || !noki.get納期開始日().equals(new RDate(row.getTxtNokigenStYMD().getValue().toString()))
                || !noki.get納期終了日().equals(new RDate(row.getTxtNokigenEtYMD().getValue().toString()))) {
            noki = noki.createBuilderForEdit().
                    set通知書発行日(new RDate(row.getTxtHakkoYMD().getValue().toString())).
                    set納期限(new RDate(row.getTxtNokigenYMD().getValue().toString())).
                    set納期開始日(new RDate(row.getTxtNokigenStYMD().getValue().toString())).
                    set納期終了日(new RDate(row.getTxtNokigenEtYMD().getValue().toString())).build();
            new NokiManager().save納期(noki);
        }
    }

    private void save保存処理_過年度() {
        RString 理由 = get変更理由();
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
                update(row.getTxtTsuki(), 過年度_期別テーブル.get(i), 理由);
                update(row.getDdlNofushoKata().getSelectedKey(), 過年度期情報_納付書の型.get(i), 理由);
                update(row.getDdlInjiIchi().getSelectedKey(), 過年度期情報_納付書の印字位置.get(i), 理由);
                update(row.getDdlCVSCutInjiIchi().getSelectedKey(), 過年度期情報_コンビニカット印字位置.get(i), 理由);
                update(row.getDdlCVSRenChoInjiIchi().getSelectedKey(), 過年度期情報_コンビニ連帳印字位置.get(i), 理由);
                update(row.getDdlBookStInjiIchi().getSelectedKey(), 過年度期情報_ブック開始位置.get(i), 理由);
                update(row.getDdlOutputJoken().getSelectedKey(), 過年度期情報_通知書プリント条件.get(i), 理由);
                update(row.getDdlKozaTaishoshaOutput().getSelectedKey(), 過年度期情報_口座対象者プリント条件.get(i), 理由);
                if (第４月.equals(row.getTxtTsuki())) {
                    update(row.getDdlSaiShutsu().getSelectedKey(), ConfigNameDBB.過年度期情報_過年度の歳出1, 理由);
                } else if (第５月.equals(row.getTxtTsuki())) {
                    update(row.getDdlSaiShutsu().getSelectedKey(), ConfigNameDBB.過年度期情報_過年度の歳出2, 理由);
                }
                if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
                    NokiManager nokiManager = new NokiManager();
                    Noki noki = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                            new RYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey()),
                            GennenKanen.過年度,
                            Integer.parseInt(row.getTxtKi().toString()));
                    save納期_過年度(noki, row);
                }
            } else {
                update(RString.EMPTY, 過年度_期別テーブル.get(i), 理由);
            }
            update(row.getTxtTsukinoKi(), 過年度期情報_月の期.get(i), 理由);

            i = i + 1;
        }
        update(new RString(String.valueOf(過年度期情報_設定納期数)), ConfigNameDBB.過年度期情報_設定納期数, 理由);
    }

    private RString get変更理由() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RStringBuilder rst = new RStringBuilder();
        rst.append(controlData.getMenuID()).append(変更理由);
        return rst.toRString();
    }

    private void update(RString value, Enum key, RString 理由) {
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, key, value, 理由,
                RString.EMPTY, システム日時);
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

    private List<KeyValueDataSource> set納付書の型ddl_過年度() {
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
        for (int i = 1; i < 数字_１３; i = i + 1) {
            印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)), new RString(String.valueOf(i))));
        }
        return 印字位置;
    }

    private List<KeyValueDataSource> setＣＶＳカット印字位置ddl() {
        List<KeyValueDataSource> ＣＶＳカット印字位置 = new ArrayList<>();
        for (int i = 1; i < 数字_１３; i = i + 1) {
            ＣＶＳカット印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)).padZeroToLeft(数字_２),
                    new RString(String.valueOf(i))));
        }
        return ＣＶＳカット印字位置;
    }

    private List<KeyValueDataSource> setＣＶＳカット印字位置ddl_過年度() {
        List<KeyValueDataSource> ＣＶＳカット印字位置 = new ArrayList<>();
        for (int i = 1; i < 数字_５; i = i + 1) {
            ＣＶＳカット印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)).padZeroToLeft(数字_２),
                    new RString(String.valueOf(i))));
        }
        return ＣＶＳカット印字位置;
    }

    private List<KeyValueDataSource> setＣＶＳ連帳印字位置ddl() {
        List<KeyValueDataSource> ＣＶＳ連帳印字位置 = new ArrayList<>();
        for (int i = 1; i < 数字_１３; i = i + 1) {
            ＣＶＳ連帳印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)).padZeroToLeft(数字_２),
                    new RString(String.valueOf(i))));
        }
        return ＣＶＳ連帳印字位置;
    }

    private List<KeyValueDataSource> setＣＶＳ連帳印字位置ddl_過年度() {
        List<KeyValueDataSource> ＣＶＳ連帳印字位置 = new ArrayList<>();
        for (int i = 1; i < 数字_７; i = i + 1) {
            ＣＶＳ連帳印字位置.add(new KeyValueDataSource(new RString(String.valueOf(i)).padZeroToLeft(数字_２),
                    new RString(String.valueOf(i))));
        }
        return ＣＶＳ連帳印字位置;
    }

    private List<KeyValueDataSource> setブック開始位置ddl() {
        List<KeyValueDataSource> ブック開始位置 = new ArrayList<>();
        for (int i = 1; i < 数字_６; i = i + 1) {
            ブック開始位置.add(new KeyValueDataSource(new RString(String.valueOf(i)).padZeroToLeft(数字_２),
                    new RString(String.valueOf(i))));
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
                TsuchishoPrintConditions.全被保険者_異動時は異動分全件.get名称()));
        納付書出力条件.add(new KeyValueDataSource(TsuchishoPrintConditions.差引き保険料１円以上の被保険者.getコード(),
                TsuchishoPrintConditions.差引き保険料１円以上の被保険者.get名称()));
        納付書出力条件.add(new KeyValueDataSource(TsuchishoPrintConditions.保険料変更有りで差引き保険料１円以上の被保険者_異動分のみ.getコード(),
                TsuchishoPrintConditions.保険料変更有りで差引き保険料１円以上の被保険者_異動分のみ.get名称()));
        納付書出力条件.add(new KeyValueDataSource(TsuchishoPrintConditions.差引き保険料０円以外で確定保険料がある被保険者_当初のみ.getコード(),
                TsuchishoPrintConditions.差引き保険料０円以外で確定保険料がある被保険者_当初のみ.get名称()));
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
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正.getコード(),
                FuchoZanteiKeisanHoho.今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_一律.getコード(),
                FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_一律.get略称()));
        賦課方法.add(new KeyValueDataSource(FuchoZanteiKeisanHoho.千代田区独自算定.getコード(),
                FuchoZanteiKeisanHoho.千代田区独自算定.get略称()));
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
     * 現年度と過年度入力チェック
     */
    public void 現年度と過年度入力チェック() {
        if (現年度.equals(div.getFutsuChoshu().getTabFuCho().getSelectedItem().getTitle())) {
            現年度入力チェック();
            過年度入力チェック();
        } else {
            過年度入力チェック();
            現年度入力チェック();
        }
    }

    /**
     * 過年度Gridの選択変更
     */
    public void change_dgKaNendoKibetsuJoho() {
        set過年度Grid制御(div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getDataSource());
    }

    /**
     * 現年度Gridの選択変更
     */
    public void change_dgGenNendoKibetsuJoho() {
        set現年度Grid制御(div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getDataSource());
    }

    /**
     * 完了Message
     *
     * @param 調定年度 RString
     */
    public void setMessage(RString 調定年度) {
        RStringBuilder message = new RStringBuilder(MSG);
        message.append(調定年度).append(MSG_NENNDO);
        div.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(message.toRString(), メッセージ_正常, RString.EMPTY, true);
    }

    /**
     * 現年度期別情報Gridの「納付書の型」変更
     */
    public void change_現年度_納付書の型() {
        List<dgGenNendoKibetsuJoho_Row> list = div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getDataSource();
        dgGenNendoKibetsuJoho_Row row = div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getClickedItem();
        list.set(div.getFutsuChoshu().getDgGenNendoKibetsuJoho().getClickedRowId(), set納付書の型変更(row));
        div.getFutsuChoshu().getDgGenNendoKibetsuJoho().setDataSource(list);
    }

    /**
     * 過年度期別情報Gridの「納付書の型」変更
     */
    public void change_過年度_納付書の型() {
        List<dgKaNendoKibetsuJoho_Row> list = div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getDataSource();
        dgKaNendoKibetsuJoho_Row row = div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getClickedItem();
        list.set(div.getFutsuChoshu().getDgKaNendoKibetsuJoho().getClickedRowId(), set納付書の型変更_過年度(row));
        div.getFutsuChoshu().getDgKaNendoKibetsuJoho().setDataSource(list);
    }

    /**
     * 前排他キーのセット
     *
     * @return boolean
     */
    public boolean 前排他キーのセット() {
        LockingKey 排他キー = new LockingKey(UrControlDataFactory.createInstance().getMenuID());
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除
     */
    public void 前排他キーの解除() {
        LockingKey 排他キー = new LockingKey(UrControlDataFactory.createInstance().getMenuID());
        RealInitialLocker.release(排他キー);
    }
}
