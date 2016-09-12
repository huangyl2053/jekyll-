/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.shunojoho.ShunoJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.shunojoho.ShunoJohoResult;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukaManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.KibetsuManager;
import jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.choteikyotsu.ChoteiKyotsuManager;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 収納情報【共有子Div】のハンドラクラスです。
 *
 * @reamsid_L DBB-5710-010 xuxin
 */
public class ShunoJohoHandler {

    private static final FlexibleYear 平成12年 = new FlexibleYear("2000");
    private static final int INT_1 = 1;
    private static final RString 徴収方法_1 = new RString("1");
    private static final RString 徴収方法_2 = new RString("2");
//    private static final RString 取り込まない = new RString("0");
//    private static final RString 取り込む = new RString("1");

    private final ShunoJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShunoJohoDiv
     */
    public ShunoJohoHandler(ShunoJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期表示です。
     */
    public void init() {
        setDefault状態();
        setDDL初期化();
    }

    private void setDefault状態() {
        div.getTxtChoteiNendo().setReadOnly(true);
        div.getTxtFukaNendo().setReadOnly(true);
        div.getTxtTsuchiNo().setReadOnly(true);
        div.getBtnNendoChange().setDisabled(true);
        div.getShunoJohoTokucho().getTxtTokuChoteiGeoukei().setReadOnly(true);
        div.getShunoJohoTokucho().getTxtTokuShunyuGokei().setReadOnly(true);
        div.getShunoJohoFucho().getTxtFuChoteiGokei().setReadOnly(true);
        div.getShunoJohoFucho().getTxtFuShunyuGokei().setReadOnly(true);
    }

    /**
     * 調定年度DDLと賦課年度DDLの初期化です。
     */
    private void setDDL初期化() {
        RDate 適用基準日 = RDate.getNowDate();
        RString 調定年度r = getConfig値(ConfigNameDBB.日付関連_調定年度, 適用基準日);
        if (!RString.isNullOrEmpty(調定年度r)) {
            FlexibleYear 調定年度f = new FlexibleYear(調定年度r);
            ShoriDateKanriManager manager = new ShoriDateKanriManager();
            ShoriDateKanri 新年度管理情報 = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課,
                    ShoriName.新年度管理情報作成.get名称(), 調定年度f.plusYear(INT_1));
            boolean flag;
            flag = (新年度管理情報 == null) || (新年度管理情報.get基準年月日() == null)
                    || (新年度管理情報.get基準年月日().isEmpty());
            FlexibleYear 選択可能年度 = flag ? 調定年度f : 調定年度f.plusYear(INT_1);
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (int index = 選択可能年度.getYearValue(); 平成12年.getYearValue() <= index; index--) {
                FlexibleYear 調定年度 = new FlexibleYear(new RString(index));
                dataSource.add(new KeyValueDataSource(調定年度.seireki().toDateString(), 調定年度.wareki().toDateString()));
            }
            div.getDdlChoteiNendo().setDataSource(dataSource);
            div.getDdlFukaNendo().setDataSource(dataSource);
            div.getDdlChoteiNendo().setSelectedKey(調定年度f.seireki().toDateString());
            div.getDdlFukaNendo().setSelectedKey(調定年度f.seireki().toDateString());
        } else {
            div.getDdlChoteiNendo().getDataSource().clear();
            div.getDdlFukaNendo().getDataSource().clear();
        }
    }

    private RString getConfig値(Enum key, RDate 適用基準日) {
        return DbBusinessConfig.get(key, 適用基準日, SubGyomuCode.DBB介護賦課);
    }

    /**
     * 収納情報を表示します。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     */
    public void load(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        //収納情報の取得
        FukaManager 賦課Manager = new FukaManager();
        Fuka 介護賦課情報 = 賦課Manager.get介護賦課_履歴番号最新(調定年度, 賦課年度, 通知書番号);

        KibetsuManager 期別Manager = new KibetsuManager();
        List<Kibetsu> 介護期別情報List = 期別Manager.get介護期別_期昇順(調定年度, 賦課年度, 通知書番号, 介護賦課情報.get履歴番号());

        List<ShunoJohoResult> 特別徴収List = new ArrayList<>();
        List<ShunoJohoResult> 普通徴収List = new ArrayList<>();

        ChoteiKyotsuManager 調定共通Manager = new ChoteiKyotsuManager();
        for (Kibetsu 介護期別情報 : 介護期別情報List) {
            ShunoJohoResult 特別徴収 = new ShunoJohoResult();
            ShunoJohoResult 普通徴収 = new ShunoJohoResult();
            Decimal 調定ID = 介護期別情報.get調定ID();
            if (徴収方法_1.equals(介護期別情報.get徴収方法())) {
                特別徴収.set期(介護期別情報.get期());
                特別徴収.set調定ID(調定ID);
            }
            if (徴収方法_2.equals(介護期別情報.get徴収方法())) {
                普通徴収.set期(介護期別情報.get期());
                普通徴収.set調定ID(調定ID);
            }

            ChoteiKyotsu 調定共通情報 = 調定共通Manager.get調定共通情報(調定ID);
            Decimal 調定額 = 調定共通情報.get調定額();
            RDate 調定日 = 調定共通情報.get調定年月日();
            RDate 納期限 = 調定共通情報.get納期限();
            if (調定ID.equals(特別徴収.get調定ID())) {
                特別徴収.set調定額(調定額);
                特別徴収.set調定日(調定日);
                特別徴収.set納期限(納期限);
            }
            if (調定ID.equals(普通徴収.get調定ID())) {
                普通徴収.set調定額(調定額);
                普通徴収.set調定日(調定日);
                普通徴収.set納期限(納期限);
            }

//            Long 収納ID = 調定共通情報.get収納ID();
//            Shuno 収納情報 = ShunoManager.createInstance().get収納(収納ID);
//            ShunyuCollection 収入明細 = 収納情報.get収入明細();
//            Boolean 速報考慮 = false;
//            RString 速報考慮r = getConfig値(ConfigNameDBB.収納状況照会_速報取込区分, RDate.getNowDate());
//            if (取り込む.equals(速報考慮r)) {
//                速報考慮 = true;
//            }
//            Shunyu 収入情報 = 収入明細.get収入(速報考慮);
//            IShunoKingakuComponentSupply 収納金額 = 収入情報.get金額();
//            RDate 収入日 = 収入情報.get直近収入年月日();
//            RDate 領収日 = 収入情報.get直近領収年月日();
//            Decimal 収入額 = 収納金額.get本税();
//            Decimal 督促手数料 = 収納金額.get督促手数料();
//            Decimal 延滞金 = 収納金額.get延滞金();
            if (調定ID.equals(特別徴収.get調定ID())) {
//                特別徴収.set収入日(収入日);
//                特別徴収.set領収日(領収日);
//                特別徴収.set収入額(収入額);
//                特別徴収.set督促手数料(督促手数料);
//                特別徴収.set延滞金(延滞金);
                特別徴収List.add(特別徴収);
            }
            if (調定ID.equals(普通徴収.get調定ID())) {
//                普通徴収.set収入日(収入日);
//                普通徴収.set領収日(領収日);
//                普通徴収.set収入額(収入額);
//                普通徴収.set督促手数料(督促手数料);
//                普通徴収.set延滞金(延滞金);
                普通徴収List.add(普通徴収);
            }
        }
        //収納情報の表示
        div.getTxtChoteiNendo().setValue(調定年度.wareki().toDateString());
        div.getTxtFukaNendo().setValue(賦課年度.wareki().toDateString());
        div.getTxtTsuchiNo().setValue(通知書番号.value());
        if (!特別徴収List.isEmpty()) {
            List<dgTokucho_Row> dataSource特別 = new ArrayList<>();
            Decimal 調定額合計_特別徴収 = Decimal.ZERO;
            Decimal 収入額合計_特別徴収 = Decimal.ZERO;
            for (ShunoJohoResult result : 特別徴収List) {
                dgTokucho_Row row = new dgTokucho_Row();
                row.setTxtKi(new RString(result.get期()));
                row.setTxtChoteiGaku(new RString(result.get調定額().toString()));
//                row.setTxtShunyuGaku(new RString(result.get収入額().toString()));
//                row.setTxtShunyuYMD(result.get収入日().toDateString());
//                row.setTxtRyosyuYMD(result.get領収日().toDateString());
//                row.setTxtTokusokuTesuryo(new RString(result.get督促手数料().toString()));
//                row.setTxtEntaikin(new RString(result.get延滞金().toString()));
                row.setTxtChoteiYMD(result.get調定日().toDateString());
                row.setTxtNokigen(result.get納期限().toDateString());
                dataSource特別.add(row);
                調定額合計_特別徴収 = 調定額合計_特別徴収.add(result.get調定額());
//                収入額合計_特別徴収.add(result.get収入額());
            }
            div.getShunoJohoTokucho().getDgTokucho().setDataSource(dataSource特別);
            div.getShunoJohoTokucho().getTxtTokuChoteiGeoukei().setValue(調定額合計_特別徴収);
            div.getShunoJohoTokucho().getTxtTokuShunyuGokei().setValue(収入額合計_特別徴収);
        } else {
            div.getShunoJohoTokucho().getDgTokucho().init();
        }
        if (!普通徴収List.isEmpty()) {
            List<dgFucho_Row> dataSource普通 = new ArrayList<>();
            Decimal 調定額合計_普通徴収 = Decimal.ZERO;
            Decimal 収入額合計_普通徴収 = Decimal.ZERO;
            for (ShunoJohoResult result : 普通徴収List) {
                dgFucho_Row row = new dgFucho_Row();
                row.setTxtKi(new RString(result.get期()));
                row.setTxtChoteiGaku(new RString(result.get調定額().toString()));
//                row.setTxtShunyuGaku(new RString(result.get収入額().toString()));
//                row.setTxtShunyuYMD(result.get収入日().toDateString());
//                row.setTxtRyosyuYMD(result.get領収日().toDateString());
//                row.setTxtTokusokuTesuryo(new RString(result.get督促手数料().toString()));
//                row.setTxtEntaikin(new RString(result.get延滞金().toString()));
                row.setTxtChoteiYMD(result.get調定日().toDateString());
                row.setTxtNokigen(result.get納期限().toDateString());
                dataSource普通.add(row);
                調定額合計_普通徴収 = 調定額合計_普通徴収.add(result.get調定額());
//                収入額合計_普通徴収.add(result.get収入額());
            }
            div.getShunoJohoFucho().getDgFucho().setDataSource(dataSource普通);
            div.getShunoJohoFucho().getTxtFuChoteiGokei().setValue(調定額合計_普通徴収);
            div.getShunoJohoFucho().getTxtFuShunyuGokei().setValue(収入額合計_普通徴収);
        } else {
            div.getShunoJohoFucho().getDgFucho().init();
        }
        if (div.getDdlChoteiNendo().getDataSource().isEmpty()) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (int index = 調定年度.getYearValue(); 平成12年.getYearValue() <= index; index--) {
                FlexibleYear 可能年度 = new FlexibleYear(new RString(index));
                dataSource.add(new KeyValueDataSource(可能年度.seireki().toDateString(), 可能年度.wareki().toDateString()));
            }
            div.getDdlChoteiNendo().setDataSource(dataSource);
            div.getDdlChoteiNendo().setSelectedKey(調定年度.seireki().toDateString());
        }
        if (div.getDdlFukaNendo().getDataSource().isEmpty()) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (int index = 賦課年度.getYearValue(); 平成12年.getYearValue() <= index; index--) {
                FlexibleYear 可能年度 = new FlexibleYear(new RString(index));
                dataSource.add(new KeyValueDataSource(可能年度.seireki().toDateString(), 可能年度.wareki().toDateString()));
            }
            div.getDdlFukaNendo().setDataSource(dataSource);
            div.getDdlFukaNendo().setSelectedKey(賦課年度.seireki().toDateString());
        }
        div.getBtnNendoChange().setDisabled(false);
    }

}
