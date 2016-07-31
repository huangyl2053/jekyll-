/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukinitsuNokiKanri;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTani;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.FutsuChoshuKirikaeKeisanHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.HeijunkaUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho8Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoIraikingakuKeisanHoho12Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoIraikingakuKeisanHoho2Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoIraikingakuKeisanHoho4Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoIraikingakuKeisanHoho6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoIraikingakuKeisanHoho8Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiMaeFucho10Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiMaeFucho6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiMaeFucho8Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiTsuki10GatsuHosoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiTsuki12GatsuHosoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiTsuki2GatsuHosoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiTsuki4GatsuHosoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiTsuki6GatsuHosoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiTsuki8GatsuHosoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo4Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo8Gatsu;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.TokubetsuChoshuTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.dgKibetsuJoho_Row;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukinitsuNokiKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.tokucho.TokuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * システム管理情報（特別徴収）画面Handlerクラスです。
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public final class TokubetsuChoshuTotalHandler {

    private final TokubetsuChoshuTotalDiv div;
    private static final RString 未作成 = new RString("未作成");
    private static final RString 作成済 = new RString("作成済");
    private static final FlexibleYear 平成12年 = new FlexibleYear("2000");
    private static final RString 合併情報区分_合併なし = new RString("0");
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString 合併旧市町村表示区分_表示あり = new RString("1");
    private static final RString 月の期_00 = new RString("00");
    private static final RString 括弧_左 = new RString("(");
    private static final RString 括弧_右 = new RString(")");
    private static final RString 納期限 = new RString("txtNokigen");
    private static final RString 保険者構成エラーメッセージ
            = new RString("保険者が単一市町村または広域市町村ではないため処理の継続");
    private static final RString 業務コンフィグ不整合エラー
            = new RString("業務Configが不整合です。期割計算_普徴切替方法の期に該当する期が存在しません。");
    private static final RString 変更理由 = new RString("を使用して更新");
    private static final RString FORMAT = new RString("%02d");
    private static final RString 一月 = new RString("01");
    private static final RString 二月 = new RString("02");
    private static final RString 三月 = new RString("03");
    private static final RString 四月 = new RString("04");
    private static final RString 五月 = new RString("05");
    private static final RString 六月 = new RString("06");
    private static final RString 七月 = new RString("07");
    private static final RString 八月 = new RString("08");
    private static final RString 九月 = new RString("09");
    private static final RString 十月 = new RString("10");
    private static final RString 十一月 = new RString("11");
    private static final RString 十二月 = new RString("12");

    private TokubetsuChoshuTotalHandler(TokubetsuChoshuTotalDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div システム管理情報（特別徴収）Div
     * @return システム管理情報（特別徴収）Handler
     */
    public static TokubetsuChoshuTotalHandler of(TokubetsuChoshuTotalDiv div) {
        return new TokubetsuChoshuTotalHandler(div);
    }

    /**
     * 初期化設定メッソドです。
     */
    public void set初期化() {
        HizukeConfig config = new HizukeConfig();
        FlexibleYear 調定年度 = config.get調定年度();
        if (調定年度.isEmpty()) {
            List<KeyValueDataSource> list = new ArrayList<>();
            list.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
            div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setDataSource(list);
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setDataSource(list);
            return;
        }
        set調定年度DDL(調定年度);
        div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setSelectedKey(調定年度.toDateString());
        set市町村指定DDL(調定年度);
    }

    /**
     * 初期値の設定
     *
     * @param 調定年度 FlexibleYear
     */
    public void set初期値(FlexibleYear 調定年度) {
        set特別徴収期別情報Grid(調定年度);
        set端数調整DDL();
        set平準化６_８月分の初期値();
        set平準化８月分の初期値();
        set普通徴収切替計算方法初期値();
        set特徴開始月の初期値();
        set年額基準年度の初期値(調定年度);
        set特別徴収依頼金額計算方法の初期値();
        set特別徴収新規対象者の前半普通徴収の初期値();
    }

    /**
     * 調定年度DDLを設定する
     *
     * @param 調定年度 FlexibleYear
     */
    public void set調定年度DDL(FlexibleYear 調定年度) {
        RString 新年度管理情報 = 未作成;
        ShoriDateKanriManager manager = InstanceProvider.create(ShoriDateKanriManager.class);
        ShoriDateKanri result = manager.get基準年月日(ShoriName.新年度管理情報作成.get名称(), 調定年度.plusYear(1));
        if (result == null) {
            新年度管理情報 = 未作成;
        } else if (result.get基準年月日() != null && !result.get基準年月日().isEmpty()) {
            新年度管理情報 = 作成済;
        }
        if (作成済.equals(新年度管理情報)) {
            調定年度 = 調定年度.plusYear(1);
        }
        div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setDataSource(create調定年度DDL(調定年度, 平成12年));
    }

    private List<KeyValueDataSource> create調定年度DDL(FlexibleYear 調定年度, FlexibleYear 調定開始年度) {
        List<KeyValueDataSource> list = new ArrayList<>();
        if (調定開始年度.isBeforeOrEquals(調定年度)) {
            while (調定開始年度.isBeforeOrEquals(調定年度)) {
                KeyValueDataSource kv = new KeyValueDataSource(調定年度.toDateString(),
                        調定年度.wareki().toDateString());
                list.add(kv);
                調定年度 = 調定年度.minusYear(1);
            }
        } else {
            while (調定年度.isBeforeOrEquals(調定開始年度)) {
                KeyValueDataSource kv = new KeyValueDataSource(調定開始年度.toDateString(),
                        調定開始年度.wareki().toDateString());
                list.add(kv);
                調定開始年度 = 調定開始年度.minusYear(1);
            }
        }

        return list;
    }

    /**
     * 市町村指定DDLを設定する
     *
     * @param 調定年度 FlexibleYear
     */
    public void set市町村指定DDL(FlexibleYear 調定年度) {
        FlexibleYear 不均一納期期限 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.ランク管理情報_不均一納期期限,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        if (不均一納期期限.isBefore(調定年度)) {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(false);
            return;
        }
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報.get導入形態コード() == null) {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(false);
            return;
        }
        if (is市町村指定DDL表示(市町村セキュリティ情報)) {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(true);
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setDataSource(create市町村指定DDL(市町村セキュリティ情報, 調定年度));
            if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().getDataSource().isEmpty()) {
                div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setSelectedIndex(0);
            }
        } else {
            div.getKonkaiShoriNaiyo().getDdlShichosonSelect().setVisible(false);
        }
    }

    private Boolean is市町村指定DDL表示(ShichosonSecurityJoho 市町村セキュリティ情報) {
        if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
            RString 合併情報区分 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            if (合併情報区分_合併なし.equals(合併情報区分)) {
                return false;
            } else if (合併情報区分_合併あり.equals(合併情報区分)) {
                return true;
            }
        } else if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
            return true;
        } else {
            前排他キーの解除();
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage()
                    .replace(保険者構成エラーメッセージ.toString()).evaluate());
        }
        return false;
    }

    private List<KeyValueDataSource> create市町村指定DDL(ShichosonSecurityJoho 市町村セキュリティ情報, FlexibleYear 調定年度) {
        List<KeyValueDataSource> 市町村指定DDL = new ArrayList<>();
        FukinitsuNokiKanriManager manager = InstanceProvider.create(FukinitsuNokiKanriManager.class);
        List<FukinitsuNokiKanri> 不均一納期リスト = manager.get市町村コード(調定年度);
        if (不均一納期リスト == null || 不均一納期リスト.isEmpty()) {
            return 市町村指定DDL;
        }
        Map<RString, RString> hashMap = new HashMap<>();
        for (FukinitsuNokiKanri 不均一納期 : 不均一納期リスト) {
            if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
                set合併市町村DDL(不均一納期, hashMap);
            } else if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
                set構成市町村DDL(不均一納期, hashMap);
            }
        }
        List<RString> tmpList = new ArrayList<>();
        Set<Map.Entry<RString, RString>> set = hashMap.entrySet();
        for (Map.Entry<RString, RString> entry : set) {
            tmpList.add(entry.getKey());
        }
        Collections.sort(tmpList);

        for (int i = 0; i < tmpList.size(); i++) {
            市町村指定DDL.add(new KeyValueDataSource(tmpList.get(i), hashMap.get(tmpList.get(i))));
        }
        return 市町村指定DDL;
    }

    private void set合併市町村DDL(FukinitsuNokiKanri 不均一納期, Map<RString, RString> hashMap) {
        KyuShichosonCodeJoho 合併市町村情報 = KyuShichosonCode
                .getKyuShichosonCodeJoho(不均一納期.get市町村コード(), DonyuKeitaiCode.事務単一);
        if (合併市町村情報 != null && 合併市町村情報.is合併市町村有無フラグ()
                && !合併市町村情報.get旧市町村コード情報List().isEmpty()) {
            List<KyuShichosonCode> 旧市町村コード情報List = 合併市町村情報.get旧市町村コード情報List();
            for (KyuShichosonCode コード情報 : 旧市町村コード情報List) {
                if (不均一納期.get市町村コード().equals(コード情報.get旧市町村コード())) {
                    hashMap.put(不均一納期.get市町村コード().getColumnValue(), コード情報.get旧市町村名称());
                }
            }
        }
    }

    private void set構成市町村DDL(FukinitsuNokiKanri 不均一納期, Map<RString, RString> hashMap) {
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        SearchResult<ShichosonCodeYoriShichoson> 構成市町村マスタ
                = finder.shichosonCodeYoriShichosonJoho(不均一納期.get市町村コード());
        if (構成市町村マスタ == null || 構成市町村マスタ.records().isEmpty()) {
            return;
        }
        List<ShichosonCodeYoriShichoson> 構成市町村List = 構成市町村マスタ.records();
        for (int i = 0; i < 構成市町村List.size(); i++) {
            if (合併旧市町村表示区分_表示あり.equals(構成市町村List.get(i).get合併旧市町村表示有無())
                    && 不均一納期.get市町村コード().equals(構成市町村List.get(i).get市町村コード())) {
                hashMap.put(不均一納期.get市町村コード().getColumnValue(),
                        構成市町村List.get(i).get市町村名称());
            }
        }
    }

    private void set特別徴収期別情報Grid(FlexibleYear 調定年度) {
        List<dgKibetsuJoho_Row> rowList = new ArrayList<>();
        List<RString> 期別List = create期別List();
        if (div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho()
                    .getGridSetting().getColumn(納期限).setVisible(false);
        } else {
            div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho()
                    .getGridSetting().getColumn(納期限).setVisible(true);
        }
        RDate nowDate = RDate.getNowDate();
        rowList.add(create特別徴収期別情報Grid(調定年度, 四月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期1, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分1, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 五月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期2, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分2, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 六月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期3, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分3, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 七月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期4, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分4, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 八月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期5, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分5, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 九月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期6, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分6, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 十月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期7, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分7, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 十一月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期8, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分8, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 十二月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期9, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分9, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 一月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期10, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分10, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 二月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期11, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分11, nowDate, SubGyomuCode.DBB介護賦課)));
        rowList.add(create特別徴収期別情報Grid(調定年度, 三月, 期別List,
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月の期12, nowDate, SubGyomuCode.DBB介護賦課),
                DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分12, nowDate, SubGyomuCode.DBB介護賦課)));
        div.getTokubetsuChoshu().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho().setDataSource(rowList);
        チェック選択制御();
    }

    /**
     * チェック選択制御
     */
    public void チェック選択制御() {
        int rowId = 0;
        RString ki = 月の期_00;
        for (dgKibetsuJoho_Row row : div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu()
                .getDgKibetsuJoho().getDataSource()) {
            if (row.getSelected()) {
                rowId = rowId + 1;
                ki = new RString(String.format(FORMAT.toString(), rowId));
                row.setTxtKi(ki);
            } else {
                row.setTxtKi(RString.EMPTY);
            }
            row.setTxtTsukinoKi(ki);

            if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
                if (row.getSelected()) {
                    row.getTxtNokigen().setDisabled(false);
                } else {
                    row.getTxtNokigen().setDisabled(true);
                }
            }
        }
    }

    private dgKibetsuJoho_Row create特別徴収期別情報Grid(FlexibleYear 調定年度, RString 月,
            List<RString> 期別List, RString 月の期, RString 月処理区分) {
        dgKibetsuJoho_Row row = new dgKibetsuJoho_Row();
        if (is選択(月, 期別List)) {
            row.setSelected(Boolean.TRUE);
        }
        row.setTxtTsuki(月);
        row.setTxtTsukinoKi(月の期);
        row.getDdlTsukiShoriKbn().setDataSource(create月処理区分DDL());
        row.getDdlTsukiShoriKbn().setSelectedKey(月処理区分);
        if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            NokiManager nokiManager = new NokiManager();
            Noki noki = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_特別徴収,
                    new RYear(調定年度.toDateString()), GennenKanen.現年度,
                    Integer.parseInt(月の期.toString()));
            if (noki != null) {
                row.getTxtNokigen().setValue(new FlexibleDate(noki.get納期限().toDateString()));
            }
        }
        return row;
    }

    private List<RString> create期別List() {
        List<RString> list = new ArrayList();
        RDate nowDate = RDate.getNowDate();
        list.add(DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別テーブル1, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別テーブル2, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別テーブル3, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別テーブル4, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別テーブル5, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別テーブル6, nowDate, SubGyomuCode.DBB介護賦課));
        return list;
    }

    private Boolean is選択(RString 月, List<RString> 期別List) {
        for (int i = 0; i < 期別List.size(); i++) {
            if (月.equals(期別List.get(i))) {
                return true;
            }
        }
        return false;
    }

    private List<KeyValueDataSource> create月処理区分DDL() {
        List<KeyValueDataSource> list = new ArrayList<>();
        list.add(new KeyValueDataSource(TokuchokiJohoTsukiShoriKubun.なし.getコード(),
                TokuchokiJohoTsukiShoriKubun.なし.get名称()));
        list.add(new KeyValueDataSource(TokuchokiJohoTsukiShoriKubun.特徴仮算定.getコード(),
                TokuchokiJohoTsukiShoriKubun.特徴仮算定.get名称()));
        list.add(new KeyValueDataSource(TokuchokiJohoTsukiShoriKubun.特徴仮算定異動.getコード(),
                TokuchokiJohoTsukiShoriKubun.特徴仮算定異動.get名称()));
        list.add(new KeyValueDataSource(TokuchokiJohoTsukiShoriKubun.未使用.getコード(),
                TokuchokiJohoTsukiShoriKubun.未使用.get名称()));
        list.add(new KeyValueDataSource(TokuchokiJohoTsukiShoriKubun.本算定.getコード(),
                TokuchokiJohoTsukiShoriKubun.本算定.get名称()));
        list.add(new KeyValueDataSource(TokuchokiJohoTsukiShoriKubun.本算定異動.getコード(),
                TokuchokiJohoTsukiShoriKubun.本算定異動.get名称()));
        list.add(new KeyValueDataSource(TokuchokiJohoTsukiShoriKubun.随時.getコード(),
                TokuchokiJohoTsukiShoriKubun.随時.get名称()));
        return list;
    }

    private void set端数調整DDL() {
        List<KeyValueDataSource> list = new ArrayList<>();
        list.add(new KeyValueDataSource(HasuChoseiTani._1.getコード(), HasuChoseiTani._1.get略称()));
        list.add(new KeyValueDataSource(HasuChoseiTani._10.getコード(), HasuChoseiTani._10.get略称()));
        list.add(new KeyValueDataSource(HasuChoseiTani._100.getコード(), HasuChoseiTani._100.get略称()));
        list.add(new KeyValueDataSource(HasuChoseiTani._1000.getコード(), HasuChoseiTani._1000.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getKibetsuHokenryo().getDdlHasu().setDataSource(list);
        RString 端数 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別端数, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getKibetsuHokenryo().getDdlHasu().setSelectedKey(端数);

    }

    private void set平準化６_８月分の初期値() {
        List<KeyValueDataSource> ddList = new ArrayList<>();
        RDate nowDate = RDate.getNowDate();
        ddList.add(new KeyValueDataSource(TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.getコード(),
                TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.get名称()));
        ddList.add(new KeyValueDataSource(TokuchoHeijunkaKeisanHoho6Gatsu.前半と後半を１_１にする.getコード(),
                TokuchoHeijunkaKeisanHoho6Gatsu.前半と後半を１_１にする.get名称()));
        ddList.add(new KeyValueDataSource(TokuchoHeijunkaKeisanHoho6Gatsu.年額より４月分を引いた額を５期で割る.getコード(),
                TokuchoHeijunkaKeisanHoho6Gatsu.年額より４月分を引いた額を５期で割る.get名称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka6GatsuKeisanHoho().getDdlHeijunkaKeisanHoho().setDataSource(ddList);
        RString 計算方法 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_6月分, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka6GatsuKeisanHoho().getDdlHeijunkaKeisanHoho().setSelectedKey(計算方法);

        List<KeyValueDataSource> radList = new ArrayList<>();
        radList.add(new KeyValueDataSource(HeijunkaUmu.する.getコード(), HeijunkaUmu.する.get名称()));
        radList.add(new KeyValueDataSource(HeijunkaUmu.しない.getコード(), HeijunkaUmu.しない.get名称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka6GatsuKeisanHoho().getRadGengakuHeijunKa().setDataSource(radList);
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka6GatsuKeisanHoho().getRadZogakuHeijunKa().setDataSource(radList);
        RString 減額時平準化 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_6月分減額, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka6GatsuKeisanHoho().getRadGengakuHeijunKa().setSelectedKey(減額時平準化);

        RString 増額時平準化 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_6月分増額, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka6GatsuKeisanHoho().getRadZogakuHeijunKa().setSelectedKey(増額時平準化);
    }

    private void set平準化８月分の初期値() {
        List<KeyValueDataSource> ddList = new ArrayList<>();
        RDate nowDate = RDate.getNowDate();
        ddList.add(new KeyValueDataSource(TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.getコード(),
                TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get名称()));
        ddList.add(new KeyValueDataSource(TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.getコード(),
                TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.get名称()));
        ddList.add(new KeyValueDataSource(
                TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.getコード(),
                TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.get名称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka8GatsuKeisanHoho().getDdlHeijunka8GatsuKeisanHoho().setDataSource(ddList);
        RString 計算方法 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_8月分, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka8GatsuKeisanHoho().getDdlHeijunka8GatsuKeisanHoho().setSelectedKey(計算方法);

        List<KeyValueDataSource> radList = new ArrayList<>();
        radList.add(new KeyValueDataSource(HeijunkaUmu.する.getコード(), HeijunkaUmu.する.get名称()));
        radList.add(new KeyValueDataSource(HeijunkaUmu.しない.getコード(), HeijunkaUmu.しない.get名称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka8GatsuKeisanHoho().getRad8GatsuGengakuHeijunKa().setDataSource(radList);
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka8GatsuKeisanHoho().getRad8GatsuZogakuHeijunKa().setDataSource(radList);
        RString 減額時平準化 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_8月分減額, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka8GatsuKeisanHoho().getRad8GatsuGengakuHeijunKa().setSelectedKey(減額時平準化);

        RString 増額時平準化 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_8月分増額, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka8GatsuKeisanHoho().getRad8GatsuZogakuHeijunKa().setSelectedKey(増額時平準化);
    }

    private void set普通徴収切替計算方法初期値() {
        List<KeyValueDataSource> ddList = new ArrayList<>();
        ddList.add(new KeyValueDataSource(FutsuChoshuKirikaeKeisanHoho.重複させない.getコード(),
                FutsuChoshuKirikaeKeisanHoho.重複させない.get名称()));
        ddList.add(new KeyValueDataSource(FutsuChoshuKirikaeKeisanHoho.重複させる.getコード(),
                FutsuChoshuKirikaeKeisanHoho.重複させる.get名称()));
        ddList.add(new KeyValueDataSource(FutsuChoshuKirikaeKeisanHoho.指定期以降重複させる.getコード(),
                FutsuChoshuKirikaeKeisanHoho.指定期以降重複させる.get名称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeKeisanHoho().setDataSource(ddList);
        RString 計算方法 = DbBusinessConfig.get(ConfigNameDBB.期割計算_普徴切替方法, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);

        List<KeyValueDataSource> kiList = new ArrayList<>();
        List<RString> rsList = create普徴情報月処理区分List();
        for (int i = 0; i < rsList.size(); i++) {
            if (FuchokiJohoTsukiShoriKubun.本算定異動.getコード().equals(rsList.get(i))) {
                RString kv = new RString(String.format(FORMAT.toString(), i + 1));
                kiList.add(new KeyValueDataSource(kv, kv));
            }
        }
        div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeJufukuStKi().setDataSource(kiList);

        if (!FutsuChoshuKirikaeKeisanHoho.重複させない.getコード().equals(計算方法)
                && !FutsuChoshuKirikaeKeisanHoho.重複させる.getコード().equals(計算方法)) {
            div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                    .getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeKeisanHoho()
                    .setSelectedKey(FutsuChoshuKirikaeKeisanHoho.指定期以降重複させる.getコード());
            if (!kiList.contains(new KeyValueDataSource(計算方法, 計算方法))) {
                throw new ApplicationException(業務コンフィグ不整合エラー.toString());
            }
            div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                    .getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeJufukuStKi().setSelectedKey(計算方法);
        } else {
            div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                    .getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeKeisanHoho().setSelectedKey(計算方法);
            div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                    .getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeJufukuStKi().setSelectedKey(kiList.get(0).getKey());
            div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                    .getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeJufukuStKi().setDisabled(true);
        }
    }

    private List<RString> create普徴情報月処理区分List() {
        List<RString> list = new ArrayList<>();
        RDate nowDate = RDate.getNowDate();
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分1, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分2, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分3, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分4, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分5, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分6, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分7, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分8, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分9, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分10, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分11, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分12, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分13, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分14, nowDate, SubGyomuCode.DBB介護賦課));
        return list;
    }

    private void set特徴開始月の初期値() {
        List<KeyValueDataSource> gatsu04List = new ArrayList<>();
        RDate nowDate = RDate.getNowDate();
        gatsu04List.add(new KeyValueDataSource(TokuchoKaishiTsuki4GatsuHosoku.特別徴収しない.getコード(),
                TokuchoKaishiTsuki4GatsuHosoku.特別徴収しない.get略称()));
        gatsu04List.add(new KeyValueDataSource(TokuchoKaishiTsuki4GatsuHosoku._10月.getコード(),
                TokuchoKaishiTsuki4GatsuHosoku._10月.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl4GatsuHosoku().setDataSource(gatsu04List);
        RString key_04月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_4月捕捉, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl4GatsuHosoku().setSelectedKey(key_04月捕捉);

        List<KeyValueDataSource> gatsu06List = new ArrayList<>();
        gatsu06List.add(new KeyValueDataSource(TokuchoKaishiTsuki6GatsuHosoku.特別徴収しない.getコード(),
                TokuchoKaishiTsuki6GatsuHosoku.特別徴収しない.get略称()));
        gatsu06List.add(new KeyValueDataSource(TokuchoKaishiTsuki6GatsuHosoku._12月.getコード(),
                TokuchoKaishiTsuki6GatsuHosoku._12月.get略称()));
        gatsu06List.add(new KeyValueDataSource(TokuchoKaishiTsuki6GatsuHosoku._04月.getコード(),
                TokuchoKaishiTsuki6GatsuHosoku._04月.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl6GatsuHosoku().setDataSource(gatsu06List);
        RString key_06月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl6GatsuHosoku().setSelectedKey(key_06月捕捉);

        List<KeyValueDataSource> gatsu08List = new ArrayList<>();
        gatsu08List.add(new KeyValueDataSource(TokuchoKaishiTsuki8GatsuHosoku.特別徴収しない.getコード(),
                TokuchoKaishiTsuki8GatsuHosoku.特別徴収しない.get略称()));
        gatsu08List.add(new KeyValueDataSource(TokuchoKaishiTsuki8GatsuHosoku._02月.getコード(),
                TokuchoKaishiTsuki8GatsuHosoku._02月.get略称()));
        gatsu08List.add(new KeyValueDataSource(TokuchoKaishiTsuki8GatsuHosoku._04月.getコード(),
                TokuchoKaishiTsuki8GatsuHosoku._04月.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl8GatsuHosoku().setDataSource(gatsu08List);
        RString key_08月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_8月捕捉, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl8GatsuHosoku().setSelectedKey(key_08月捕捉);

        List<KeyValueDataSource> gatsu10List = new ArrayList<>();
        gatsu10List.add(new KeyValueDataSource(TokuchoKaishiTsuki10GatsuHosoku.特別徴収しない.getコード(),
                TokuchoKaishiTsuki10GatsuHosoku.特別徴収しない.get略称()));
        gatsu10List.add(new KeyValueDataSource(TokuchoKaishiTsuki10GatsuHosoku._04月.getコード(),
                TokuchoKaishiTsuki10GatsuHosoku._04月.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl10GatsuHosoku().setDataSource(gatsu10List);
        RString key_10月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_10月捕捉, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl10GatsuHosoku().setSelectedKey(key_10月捕捉);

        List<KeyValueDataSource> gatsu12List = new ArrayList<>();
        gatsu12List.add(new KeyValueDataSource(TokuchoKaishiTsuki12GatsuHosoku.特別徴収しない.getコード(),
                TokuchoKaishiTsuki12GatsuHosoku.特別徴収しない.get略称()));
        gatsu12List.add(new KeyValueDataSource(TokuchoKaishiTsuki12GatsuHosoku._06月.getコード(),
                TokuchoKaishiTsuki12GatsuHosoku._06月.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl12GatsuHosoku().setDataSource(gatsu12List);
        RString key_12月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_12月捕捉, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl12GatsuHosoku().setSelectedKey(key_12月捕捉);

        List<KeyValueDataSource> gatsu02List = new ArrayList<>();
        gatsu02List.add(new KeyValueDataSource(TokuchoKaishiTsuki2GatsuHosoku.特別徴収しない.getコード(),
                TokuchoKaishiTsuki2GatsuHosoku.特別徴収しない.get略称()));
        gatsu02List.add(new KeyValueDataSource(TokuchoKaishiTsuki2GatsuHosoku._08月.getコード(),
                TokuchoKaishiTsuki2GatsuHosoku._08月.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl2GatsuHosoku().setDataSource(gatsu02List);
        RString key_02月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_2月捕捉, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl2GatsuHosoku().setSelectedKey(key_02月捕捉);
    }

    private void set年額基準年度の初期値(FlexibleYear 調定年度) {
        List<KeyValueDataSource> gatsu04List = new ArrayList<>();
        RDate nowDate = RDate.getNowDate();
        gatsu04List.add(new KeyValueDataSource(TokuchoNengakuKijunNendo4Gatsu.当年度.getコード(),
                get基準年度値(TokuchoNengakuKijunNendo4Gatsu.当年度.getコード(),
                        TokuchoNengakuKijunNendo4Gatsu.当年度.get名称(), 調定年度)));
        gatsu04List.add(new KeyValueDataSource(TokuchoNengakuKijunNendo4Gatsu.翌年度.getコード(),
                get基準年度値(TokuchoNengakuKijunNendo4Gatsu.翌年度.getコード(),
                        TokuchoNengakuKijunNendo4Gatsu.翌年度.get名称(), 調定年度)));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getNengakuKijunNendo().getDdl4GatsuKaishiNengakuKijunNendo().setDataSource(gatsu04List);
        RString key_04月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_4月開始, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getNengakuKijunNendo().getDdl4GatsuKaishiNengakuKijunNendo().setSelectedKey(key_04月開始);

        List<KeyValueDataSource> gatsu06List = new ArrayList<>();
        gatsu06List.add(new KeyValueDataSource(TokuchoNengakuKijunNendo6Gatsu.当年度.getコード(),
                get基準年度値(TokuchoNengakuKijunNendo6Gatsu.当年度.getコード(),
                        TokuchoNengakuKijunNendo6Gatsu.当年度.get名称(), 調定年度)));
        gatsu06List.add(new KeyValueDataSource(TokuchoNengakuKijunNendo6Gatsu.翌年度.getコード(),
                get基準年度値(TokuchoNengakuKijunNendo6Gatsu.翌年度.getコード(),
                        TokuchoNengakuKijunNendo6Gatsu.翌年度.get名称(), 調定年度)));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getNengakuKijunNendo().getDdl6GatsuKaishiNengakuKijunNendo().setDataSource(gatsu06List);
        RString key_06月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_6月開始, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getNengakuKijunNendo().getDdl6GatsuKaishiNengakuKijunNendo().setSelectedKey(key_06月開始);

        List<KeyValueDataSource> gatsu08List = new ArrayList<>();
        gatsu08List.add(new KeyValueDataSource(TokuchoNengakuKijunNendo8Gatsu.当年度.getコード(),
                get基準年度値(TokuchoNengakuKijunNendo8Gatsu.当年度.getコード(),
                        TokuchoNengakuKijunNendo8Gatsu.当年度.get名称(), 調定年度)));
        gatsu08List.add(new KeyValueDataSource(TokuchoNengakuKijunNendo8Gatsu.翌年度.getコード(),
                get基準年度値(TokuchoNengakuKijunNendo8Gatsu.翌年度.getコード(),
                        TokuchoNengakuKijunNendo8Gatsu.翌年度.get名称(), 調定年度)));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getNengakuKijunNendo().getDdl8GatsuKaishiNengakuKijunNendo().setDataSource(gatsu08List);
        RString key_08月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_8月開始, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getNengakuKijunNendo().getDdl8GatsuKaishiNengakuKijunNendo().setSelectedKey(key_08月開始);
    }

    private RString get基準年度値(RString キー, RString 定義名, FlexibleYear 調定年度) {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(定義名);
        rsb.append(括弧_左);
        rsb.append(調定年度.plusYear(Integer.parseInt(キー.toString()) - 1).wareki().toDateString());
        rsb.append(括弧_右);
        return rsb.toRString();
    }

    private void set特別徴収依頼金額計算方法の初期値() {
        List<KeyValueDataSource> gatsu12List = new ArrayList<>();
        RDate nowDate = RDate.getNowDate();
        gatsu12List.add(new KeyValueDataSource(
                TokuchoIraikingakuKeisanHoho12Gatsu.特徴開始月以降の普通徴収額.getコード(),
                TokuchoIraikingakuKeisanHoho12Gatsu.特徴開始月以降の普通徴収額.get略称()));
        gatsu12List.add(new KeyValueDataSource(
                TokuchoIraikingakuKeisanHoho12Gatsu.年額除12乗本徴収月数除年金支給回数.getコード(),
                TokuchoIraikingakuKeisanHoho12Gatsu.年額除12乗本徴収月数除年金支給回数.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl12GatsuKaishiIraiKingakuKeisanHoho().setDataSource(gatsu12List);
        RString key_12月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_12月開始, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl12GatsuKaishiIraiKingakuKeisanHoho().setSelectedKey(key_12月開始);

        List<KeyValueDataSource> gatsu02List = new ArrayList<>();
        gatsu02List.add(new KeyValueDataSource(
                TokuchoIraikingakuKeisanHoho2Gatsu.特徴開始月以降の普通徴収額.getコード(),
                TokuchoIraikingakuKeisanHoho2Gatsu.特徴開始月以降の普通徴収額.get略称()));
        gatsu02List.add(new KeyValueDataSource(
                TokuchoIraikingakuKeisanHoho2Gatsu.年額除12乗本徴収月数除年金支給回数.getコード(),
                TokuchoIraikingakuKeisanHoho2Gatsu.年額除12乗本徴収月数除年金支給回数.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl2GatsuKaishiIraiKingakuKeisanHoho().setDataSource(gatsu02List);
        RString key_02月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_2月開始, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl2GatsuKaishiIraiKingakuKeisanHoho().setSelectedKey(key_02月開始);

        List<KeyValueDataSource> gatsu04List = new ArrayList<>();
        gatsu04List.add(new KeyValueDataSource(
                TokuchoIraikingakuKeisanHoho4Gatsu.年額除12乗仮徴収月数除年金支給回数.getコード(),
                TokuchoIraikingakuKeisanHoho4Gatsu.年額除12乗仮徴収月数除年金支給回数.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl4GatsuKaishiIraiKingakuKeisanHoho().setDataSource(gatsu04List);
        RString key_04月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_4月開始, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl4GatsuKaishiIraiKingakuKeisanHoho().setSelectedKey(key_04月開始);

        List<KeyValueDataSource> gatsu06List = new ArrayList<>();
        gatsu06List.add(new KeyValueDataSource(
                TokuchoIraikingakuKeisanHoho6Gatsu.年額除12乗仮徴収月数除年金支給回数.getコード(),
                TokuchoIraikingakuKeisanHoho6Gatsu.年額除12乗仮徴収月数除年金支給回数.get略称()));
        gatsu06List.add(new KeyValueDataSource(
                TokuchoIraikingakuKeisanHoho6Gatsu.年額を納期数_5期_で割る.getコード(),
                TokuchoIraikingakuKeisanHoho6Gatsu.年額を納期数_5期_で割る.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl6GatsuKaishiIraiKingakuKeisanHoho().setDataSource(gatsu06List);
        RString key_06月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_6月開始, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl6GatsuKaishiIraiKingakuKeisanHoho().setSelectedKey(key_06月開始);

        List<KeyValueDataSource> gatsu08List = new ArrayList<>();
        gatsu08List.add(new KeyValueDataSource(
                TokuchoIraikingakuKeisanHoho8Gatsu.年額除12乗仮徴収月数除年金支給回数.getコード(),
                TokuchoIraikingakuKeisanHoho8Gatsu.年額除12乗仮徴収月数除年金支給回数.get略称()));
        gatsu08List.add(new KeyValueDataSource(
                TokuchoIraikingakuKeisanHoho8Gatsu.年額を納期数_4期_で割る.getコード(),
                TokuchoIraikingakuKeisanHoho8Gatsu.年額を納期数_4期_で割る.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl8GatsuKaishiIraiKingakuKeisanHoho().setDataSource(gatsu08List);
        RString key_08月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_8月開始, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl8GatsuKaishiIraiKingakuKeisanHoho().setSelectedKey(key_08月開始);
    }

    private void set特別徴収新規対象者の前半普通徴収の初期値() {
        List<KeyValueDataSource> gatsu06List = new ArrayList<>();
        RDate nowDate = RDate.getNowDate();
        gatsu06List.add(new KeyValueDataSource(
                TokuchoKaishiMaeFucho6Gatsu.特別徴収開始前の仮算定納期で普通徴収しない.getコード(),
                TokuchoKaishiMaeFucho6Gatsu.特別徴収開始前の仮算定納期で普通徴収しない.get略称()));
        gatsu06List.add(new KeyValueDataSource(
                TokuchoKaishiMaeFucho6Gatsu.特別徴収開始前の仮算定納期で普通徴収する.getコード(),
                TokuchoKaishiMaeFucho6Gatsu.特別徴収開始前の仮算定納期で普通徴収する.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getTokubetsuChoshuShinkishaZenhan().getDdl6GatsuKaishiZenhan().setDataSource(gatsu06List);
        RString key_06月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_6月, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getTokubetsuChoshuShinkishaZenhan().getDdl6GatsuKaishiZenhan().setSelectedKey(key_06月開始);

        List<KeyValueDataSource> gatsu08List = new ArrayList<>();
        gatsu08List.add(new KeyValueDataSource(
                TokuchoKaishiMaeFucho8Gatsu.特別徴収開始前の本算定納期で普通徴収しない.getコード(),
                TokuchoKaishiMaeFucho8Gatsu.特別徴収開始前の本算定納期で普通徴収しない.get略称()));
        gatsu08List.add(new KeyValueDataSource(
                TokuchoKaishiMaeFucho8Gatsu.特別徴収開始前の本算定納期で普通徴収する.getコード(),
                TokuchoKaishiMaeFucho8Gatsu.特別徴収開始前の本算定納期で普通徴収する.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getTokubetsuChoshuShinkishaZenhan().getDdl8GatsuKaishiZenhan().setDataSource(gatsu08List);
        RString key_08月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_8月, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getTokubetsuChoshuShinkishaZenhan().getDdl8GatsuKaishiZenhan().setSelectedKey(key_08月開始);

        List<KeyValueDataSource> gatsu10List = new ArrayList<>();
        gatsu10List.add(new KeyValueDataSource(
                TokuchoKaishiMaeFucho10Gatsu.年度前半の本算定納期で普通徴収しない.getコード(),
                TokuchoKaishiMaeFucho10Gatsu.年度前半の本算定納期で普通徴収しない.get略称()));
        gatsu10List.add(new KeyValueDataSource(
                TokuchoKaishiMaeFucho10Gatsu.年度前半の本算定納期で普通徴収する.getコード(),
                TokuchoKaishiMaeFucho10Gatsu.年度前半の本算定納期で普通徴収する.get略称()));
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getTokubetsuChoshuShinkishaZenhan().getDdl10GatsuKaishiZenhan().setDataSource(gatsu10List);
        RString key_10月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_10月, nowDate,
                SubGyomuCode.DBB介護賦課);
        div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getTokubetsuChoshuShinkishaZenhan().getDdl10GatsuKaishiZenhan().setSelectedKey(key_10月開始);
    }

    /**
     * 納期限を保存する。
     *
     * @param 調定年度 FlexibleYear
     */
    public void save納期限(FlexibleYear 調定年度) {
        for (dgKibetsuJoho_Row row : div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                .getKibetsuJohoHasu().getDgKibetsuJoho().getDataSource()) {
            if (row.getSelected()) {
                NokiManager nokiManager = new NokiManager();
                Noki noki = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_特別徴収,
                        new RYear(調定年度.toDateString()),
                        GennenKanen.現年度,
                        Integer.parseInt(row.getTxtKi().toString()));
                if (!new RDate(row.getTxtNokigen().getValue().toString()).equals(noki.get納期限())) {
                    noki = noki.createBuilderForEdit()
                            .set納期限(new RDate(row.getTxtNokigen().getValue().toString())).build();
                    new NokiManager().save納期(noki);
                }
            }
        }
    }

    /**
     * 業務コンフィグを更新する。
     */
    public void save業務コンフィグ() {
        update暫定期数();
        update設定納期数();
        update月の期();
        update特徴情報月処理区分();
        update期別テーブル();
        update普徴切替方法();
        update平準化計算方法_6月分();
        update平準化計算方法_6月分減額();
        update平準化計算方法_6月分増額();
        update平準化計算方法_8月分();
        update平準化計算方法_8月分減額();
        update平準化計算方法_8月分増額();
        update特徴開始月_4月捕捉();
        update特徴開始月_6月捕捉();
        update特徴開始月_8月捕捉();
        update特徴開始月_10月捕捉();
        update特徴開始月_12月捕捉();
        update特徴開始月_2月捕捉();
        update年額基準年度_4月開始();
        update年額基準年度_6月開始();
        update年額基準年度_8月開始();
        update依頼金額計算方法_12月開始();
        update依頼金額計算方法_2月開始();
        update依頼金額計算方法_4月開始();
        update依頼金額計算方法_6月開始();
        update依頼金額計算方法_8月開始();
        update特徴開始前普通徴収_6月();
        update特徴開始前普通徴収_8月();
        update特徴開始前普通徴収_10月();
    }

    private void update暫定期数() {
        int 暫定期数 = 0;
        for (dgKibetsuJoho_Row row : div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu()
                .getDgKibetsuJoho().getDataSource()) {
            if (TokuchokiJohoTsukiShoriKubun.特徴仮算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || TokuchokiJohoTsukiShoriKubun.特徴仮算定異動.getコード()
                    .equals(row.getDdlTsukiShoriKbn().getSelectedKey())) {
                暫定期数 = 暫定期数 + 1;
            }
        }
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特徴期情報_仮算定期数,
                new RString(String.valueOf(暫定期数)), set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update設定納期数() {
        int 設定納期数 = 0;
        for (dgKibetsuJoho_Row row : div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu()
                .getDgKibetsuJoho().getDataSource()) {
            if (TokuchokiJohoTsukiShoriKubun.特徴仮算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || TokuchokiJohoTsukiShoriKubun.特徴仮算定異動.getコード()
                    .equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || TokuchokiJohoTsukiShoriKubun.本算定.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || TokuchokiJohoTsukiShoriKubun.本算定異動.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())
                    || TokuchokiJohoTsukiShoriKubun.随時.getコード().equals(row.getDdlTsukiShoriKbn().getSelectedKey())) {
                設定納期数 = 設定納期数 + 1;
            }
        }
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特徴期情報_設定納期数,
                new RString(String.valueOf(設定納期数)), set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update月の期() {
        List<ConfigNameDBB> 月の期キーList = create月の期キーList();
        int i = 0;
        for (dgKibetsuJoho_Row row : div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                .getKibetsuJohoHasu().getDgKibetsuJoho().getDataSource()) {
            BusinessConfig.update(SubGyomuCode.DBB介護賦課, 月の期キーList.get(i),
                    row.getTxtTsukinoKi(), set変更理由(), RString.EMPTY, RDate.getNowDate());
            i = i + 1;
        }
    }

    private List<ConfigNameDBB> create月の期キーList() {
        List<ConfigNameDBB> list = new ArrayList();
        list.add(ConfigNameDBB.特徴期情報_月の期1);
        list.add(ConfigNameDBB.特徴期情報_月の期2);
        list.add(ConfigNameDBB.特徴期情報_月の期3);
        list.add(ConfigNameDBB.特徴期情報_月の期4);
        list.add(ConfigNameDBB.特徴期情報_月の期5);
        list.add(ConfigNameDBB.特徴期情報_月の期6);
        list.add(ConfigNameDBB.特徴期情報_月の期7);
        list.add(ConfigNameDBB.特徴期情報_月の期8);
        list.add(ConfigNameDBB.特徴期情報_月の期9);
        list.add(ConfigNameDBB.特徴期情報_月の期10);
        list.add(ConfigNameDBB.特徴期情報_月の期11);
        list.add(ConfigNameDBB.特徴期情報_月の期12);
        return list;
    }

    private void update特徴情報月処理区分() {
        List<RString> 特徴情報月処理区分List = create特徴情報月処理区分List();
        List<ConfigNameDBB> 特徴情報月処理区分キーList = create特徴情報月処理区分キーList();
        int i = 0;
        for (dgKibetsuJoho_Row row : div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                .getKibetsuJohoHasu().getDgKibetsuJoho().getDataSource()) {
            if (!row.getDdlTsukiShoriKbn().getSelectedKey().equals(特徴情報月処理区分List.get(i))) {
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, 特徴情報月処理区分キーList.get(i),
                        row.getDdlTsukiShoriKbn().getSelectedKey(), set変更理由(), RString.EMPTY, RDate.getNowDate());
            }
            i = i + 1;
        }
    }

    private List<RString> create特徴情報月処理区分List() {
        List<RString> list = new ArrayList<>();
        RDate nowDate = RDate.getNowDate();
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分1, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分2, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分3, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分4, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分5, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分6, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分7, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分8, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分9, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分10, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分11, nowDate, SubGyomuCode.DBB介護賦課));
        list.add(DbBusinessConfig.get(ConfigNameDBB.特徴期情報_月処理区分12, nowDate, SubGyomuCode.DBB介護賦課));
        return list;
    }

    private List<ConfigNameDBB> create特徴情報月処理区分キーList() {
        List<ConfigNameDBB> list = new ArrayList();
        list.add(ConfigNameDBB.特徴期情報_月処理区分1);
        list.add(ConfigNameDBB.特徴期情報_月処理区分2);
        list.add(ConfigNameDBB.特徴期情報_月処理区分3);
        list.add(ConfigNameDBB.特徴期情報_月処理区分4);
        list.add(ConfigNameDBB.特徴期情報_月処理区分5);
        list.add(ConfigNameDBB.特徴期情報_月処理区分6);
        list.add(ConfigNameDBB.特徴期情報_月処理区分7);
        list.add(ConfigNameDBB.特徴期情報_月処理区分8);
        list.add(ConfigNameDBB.特徴期情報_月処理区分9);
        list.add(ConfigNameDBB.特徴期情報_月処理区分10);
        list.add(ConfigNameDBB.特徴期情報_月処理区分11);
        list.add(ConfigNameDBB.特徴期情報_月処理区分12);
        return list;
    }

    private void update期別テーブル() {
        List<RString> 期別List = create期別List();
        List<ConfigNameDBB> 期別キーList = create期別キーList();
        int i = 0;
        for (dgKibetsuJoho_Row row : div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                .getKibetsuJohoHasu().getDgKibetsuJoho().getDataSource()) {
            if (row.getSelected()) {
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, 期別キーList.get(i),
                        row.getTxtTsuki(), set変更理由(), RString.EMPTY, RDate.getNowDate());
                i = i + 1;
            }
        }
        if (i < 期別List.size()) {
            for (int j = i; j < 期別List.size(); j++) {
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, 期別キーList.get(j),
                        RString.EMPTY, set変更理由(), RString.EMPTY, RDate.getNowDate());
            }
        }
    }

    private List<ConfigNameDBB> create期別キーList() {
        List<ConfigNameDBB> list = new ArrayList();
        list.add(ConfigNameDBB.特別徴収_期別テーブル1);
        list.add(ConfigNameDBB.特別徴収_期別テーブル2);
        list.add(ConfigNameDBB.特別徴収_期別テーブル3);
        list.add(ConfigNameDBB.特別徴収_期別テーブル4);
        list.add(ConfigNameDBB.特別徴収_期別テーブル5);
        list.add(ConfigNameDBB.特別徴収_期別テーブル6);
        return list;
    }

    private void update平準化計算方法_6月分() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka6GatsuKeisanHoho().getDdlHeijunkaKeisanHoho().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_平準化計算方法_6月分,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update平準化計算方法_6月分減額() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka6GatsuKeisanHoho().getRadGengakuHeijunKa().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_平準化計算方法_6月分減額,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update平準化計算方法_6月分増額() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka6GatsuKeisanHoho().getRadZogakuHeijunKa().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_平準化計算方法_6月分増額,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update平準化計算方法_8月分() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka8GatsuKeisanHoho().getDdlHeijunka8GatsuKeisanHoho().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_平準化計算方法_8月分,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update平準化計算方法_8月分減額() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka8GatsuKeisanHoho().getRad8GatsuGengakuHeijunKa().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_平準化計算方法_8月分減額,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update平準化計算方法_8月分増額() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getHeijunka8GatsuKeisanHoho().getRad8GatsuZogakuHeijunKa().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_平準化計算方法_8月分増額,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update普徴切替方法() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                .getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeKeisanHoho().getSelectedKey();
        if (FutsuChoshuKirikaeKeisanHoho.指定期以降重複させる.getコード().equals(key)) {
            RString 期のキー = div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho()
                    .getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeJufukuStKi().getSelectedKey();
            BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.期割計算_普徴切替方法,
                    期のキー, set変更理由(), RString.EMPTY, RDate.getNowDate());
        } else {
            BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.期割計算_普徴切替方法,
                    key, set変更理由(), RString.EMPTY, RDate.getNowDate());
        }
    }

    private void update特徴開始月_4月捕捉() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl4GatsuHosoku().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_特徴開始月_4月捕捉,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update特徴開始月_6月捕捉() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl6GatsuHosoku().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_特徴開始月_6月捕捉,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update特徴開始月_8月捕捉() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl8GatsuHosoku().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_特徴開始月_8月捕捉,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update特徴開始月_10月捕捉() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl10GatsuHosoku().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_特徴開始月_10月捕捉,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update特徴開始月_12月捕捉() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl12GatsuHosoku().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_特徴開始月_12月捕捉,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update特徴開始月_2月捕捉() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getTokuchoKaishiTsuki().getDdl2GatsuHosoku().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_特徴開始月_2月捕捉,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update年額基準年度_4月開始() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getNengakuKijunNendo().getDdl4GatsuKaishiNengakuKijunNendo().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_年額基準年度_4月開始,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update年額基準年度_6月開始() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getNengakuKijunNendo().getDdl6GatsuKaishiNengakuKijunNendo().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_年額基準年度_6月開始,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update年額基準年度_8月開始() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo()
                .getNengakuKijunNendo().getDdl8GatsuKaishiNengakuKijunNendo().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_年額基準年度_8月開始,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update依頼金額計算方法_12月開始() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl12GatsuKaishiIraiKingakuKeisanHoho().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_依頼金額計算方法_12月開始,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update依頼金額計算方法_2月開始() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl2GatsuKaishiIraiKingakuKeisanHoho().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_依頼金額計算方法_2月開始,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update依頼金額計算方法_4月開始() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl4GatsuKaishiIraiKingakuKeisanHoho().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_依頼金額計算方法_4月開始,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update依頼金額計算方法_6月開始() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl6GatsuKaishiIraiKingakuKeisanHoho().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_依頼金額計算方法_6月開始,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update依頼金額計算方法_8月開始() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getIraiKingakuKeisanHoho().getDdl8GatsuKaishiIraiKingakuKeisanHoho().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_依頼金額計算方法_8月開始,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update特徴開始前普通徴収_6月() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getTokubetsuChoshuShinkishaZenhan().getDdl6GatsuKaishiZenhan().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_特徴開始前普通徴収_6月,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update特徴開始前普通徴収_8月() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getTokubetsuChoshuShinkishaZenhan().getDdl8GatsuKaishiZenhan().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_特徴開始前普通徴収_8月,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private void update特徴開始前普通徴収_10月() {
        RString key = div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho()
                .getTokubetsuChoshuShinkishaZenhan().getDdl10GatsuKaishiZenhan().getSelectedKey();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.特別徴収_特徴開始前普通徴収_10月,
                key, set変更理由(), RString.EMPTY, RDate.getNowDate());
    }

    private RString set変更理由() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RStringBuilder rst = new RStringBuilder();
        rst.append(controlData.getMenuID()).append(変更理由);
        return rst.toRString();
    }

    /**
     * 前排他キーのセット
     *
     * @return Boolean
     */
    public Boolean 前排他キーのセット() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除
     */
    public void 前排他キーの解除() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        RealInitialLocker.release(排他キー);
    }
}
