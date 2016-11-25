/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB5140001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB514001.DBB514001_NofugakuDataSakuseiTandokuShichosonParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB514001.NofugakuDataTsushutsuJoken;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001.NoufuGakuDataSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001.dgKoikiShoriTaishoSelect_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001.dgTanitsuShoriJoken_Row;
import jp.co.ndensan.reams.db.dbb.service.core.noufuhitaidatasakusei.NoufuhitaiDataSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 画面設計_DBBGM91003_納付額データ作成のクラスです。
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public class NoufuGakuDataSakuseiHandler {

    private final NoufuGakuDataSakuseiDiv div;
    private static final RString STR_00 = new RString("00");
    private static final RString STR_0 = new RString("0");
    private static final RString STR_2 = new RString("2");
    private static final RString STR_3 = new RString("3");
    private static final RString 単一 = new RString("単一");
    private static final RString 広域 = new RString("広域");
    private static final RString 領収日 = new RString("領収日");
    private static final RString 収入日 = new RString("収入日");
    private static final RString SPACE = new RString(" ");
    private static final RString 変更理由 = new RString("納付額データ作成実行時に設定");
    private static final ReportId 定値_帳票ID = new ReportId("DBB300005_NofugakuIchiranDaihyo");
    private static final int INT_1 = 1;
    private static final int SUBCONTRACT_1 = -1;
    private static final int INT_12 = 12;
    private static final int INT_31 = 31;

    /**
     * コンストラクタです。
     *
     * @param div NoufuGakuDataSakuseiDiv
     */
    public NoufuGakuDataSakuseiHandler(NoufuGakuDataSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @return RString
     */
    public RString initialize() {
        RString 画面の状態 = null;
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null) {
            RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().getKey();
            if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード)
                    || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード)) {
                set抽出条件(市町村セキュリティ情報);
                画面の状態 = 単一;
            } else if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
                set処理対象();
                画面の状態 = 広域;
            }
        }
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        div.getShoriNaiyo().getTxtTaishoNendo().setValue(new RDate(調定年度.toString()));
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBB介護賦課, 定値_帳票ID);
        return 画面の状態;
    }

    private void set抽出条件(ShichosonSecurityJoho 市町村セキュリティ情報) {
        int year = Integer.valueOf(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        int month = RDate.getNowDate().getMonthValue();
        int day = RDate.getNowDate().getDayValue();
        RDate 適用基準日 = new RDate(year, month, day);
        RString 集計日区分 = DbBusinessConfig.get(ConfigNameDBB.納付額データ_集計日区分,
                適用基準日, SubGyomuCode.DBB介護賦課);
        List<dgTanitsuShoriJoken_Row> 抽出条件List = new ArrayList<>();
        dgTanitsuShoriJoken_Row 抽出条件Row = new dgTanitsuShoriJoken_Row();
        抽出条件Row.setTxtShukeibiKbnData(集計日区分);
        if (STR_2.equals(集計日区分)) {
            抽出条件Row.getTxtShukeibiKbn().setValue(領収日);
        } else if (STR_3.equals(集計日区分)) {
            抽出条件Row.getTxtShukeibiKbn().setValue(収入日);
        }
        RString 市町村識別ID = 市町村セキュリティ情報.get市町村情報().get市町村識別ID();
        RString 抽出期間終了補正 = DbBusinessConfig.get(ConfigNameDBB.納付額データ_抽出期間補正,
                適用基準日, SubGyomuCode.DBB介護賦課, 市町村識別ID);
        RString 抽出期間開始補正 = DbBusinessConfig.get(ConfigNameDBB.納付額データ_抽出期間補正,
                適用基準日.plusYear(SUBCONTRACT_1), SubGyomuCode.DBB介護賦課, 市町村識別ID);
        抽出条件Row.setTxtCityCode(市町村セキュリティ情報.get市町村情報().get市町村コード().getColumnValue());
        抽出条件Row.setTxtCityName(市町村セキュリティ情報.get市町村情報().get市町村名称());
        抽出条件Row.setTxtCityShikibetsuId(市町村セキュリティ情報.get市町村情報().get市町村識別ID());
        抽出条件Row.getTxtKikanStHosei().setValue(抽出期間開始補正);
        抽出条件Row.getTxtKikanEdHosei().setValue(抽出期間終了補正);
        RString 処理枝番 = new RString(STR_00.toString() + 市町村セキュリティ情報.get市町村情報().get市町村識別ID().toString());
        ShoriDateKanri 処理日付 = NoufuhitaiDataSakusei.createInstance().
                get抽出条件前回処理日付(市町村セキュリティ情報.get市町村情報().get市町村コード(), 処理枝番);
        if (処理日付 != null && 処理日付.get基準日時() != null) {
            YMDHMS 基準日時 = 処理日付.get基準日時();
            RDate 年月日 = 基準日時.getDate();
            RTime 時刻 = 基準日時.getRDateTime().getTime();
            RString 前回処理日時 = new RString(年月日.wareki().toDateString().toString() + SPACE
                    + 時刻.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
            抽出条件Row.getTxtZenShoriNichiji().setValue(前回処理日時);
            抽出条件Row.getTxtZenShoriYMD().setValue(年月日);
            抽出条件Row.getTxtZenShoriTime().setValue(時刻);
        }
        抽出条件List.add(抽出条件Row);
        div.getDgTanitsuShoriJoken().setDataSource(抽出条件List);
    }

    private void set処理対象() {
        List<KoikiZenShichosonJoho> 構成市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
        int year = Integer.valueOf(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        int month = RDate.getNowDate().getMonthValue();
        int day = RDate.getNowDate().getDayValue();
        RDate 適用基準日 = new RDate(year, month, day);
        List<LasdecCode> 市町村コードList = new ArrayList<>();
        List<RString> 処理枝番List = new ArrayList<>();
        for (KoikiZenShichosonJoho 構成市町村 : 構成市町村List) {
            市町村コードList.add(構成市町村.get市町村コード());
            処理枝番List.add(new RString(STR_00 + 構成市町村.get市町村識別ID().toString()));
        }
        List<ShoriDateKanri> 処理日付List = NoufuhitaiDataSakusei.createInstance().
                get処理対象前回処理日付(市町村コードList, 処理枝番List);
        Map<RString, ShoriDateKanri> 処理日付Map = new HashMap<>();
        for (ShoriDateKanri 処理日付 : 処理日付List) {
            RString key = new RString(処理日付.get市町村コード().getColumnValue().toString()
                    + 処理日付.get処理枝番().toString());
            処理日付Map.put(key, 処理日付);
        }
        List<dgKoikiShoriTaishoSelect_Row> 処理対象List = new ArrayList<>();
        for (KoikiZenShichosonJoho 構成市町村 : 構成市町村List) {
            dgKoikiShoriTaishoSelect_Row 処理対象 = new dgKoikiShoriTaishoSelect_Row();
            処理対象.getTxtCityCode().setValue(構成市町村.get市町村コード().getColumnValue());
            処理対象.getTxtCityName().setValue(構成市町村.get市町村名称());
            処理対象.setTxtCityShikibetsuId(構成市町村.get市町村識別ID());
            RString 集計日区分 = DbBusinessConfig.get(ConfigNameDBB.納付額データ_集計日区分,
                    適用基準日, SubGyomuCode.DBB介護賦課, 構成市町村.get市町村識別ID());
            if (STR_2.equals(集計日区分)) {
                処理対象.getTxtShukeibiKbn().setValue(領収日);
            } else if (STR_3.equals(集計日区分)) {
                処理対象.getTxtShukeibiKbn().setValue(収入日);
            }
            RString 抽出期間終了補正 = DbBusinessConfig.get(ConfigNameDBB.納付額データ_抽出期間補正,
                    適用基準日, SubGyomuCode.DBB介護賦課, 構成市町村.get市町村識別ID());
            RString 抽出期間開始補正 = DbBusinessConfig.get(ConfigNameDBB.納付額データ_抽出期間補正,
                    適用基準日.plusYear(SUBCONTRACT_1), SubGyomuCode.DBB介護賦課,
                    構成市町村.get市町村識別ID());
            処理対象.getTxtKikanStHosei().setValue(抽出期間開始補正);
            処理対象.getTxtKikanEdHosei().setValue(抽出期間終了補正);
            RString key = new RString(構成市町村.get市町村コード().getColumnValue().toString()
                    + STR_00 + 構成市町村.get市町村識別ID().toString());
            ShoriDateKanri 処理日付 = 処理日付Map.get(key);
            if (処理日付 != null && 処理日付.get基準日時() != null) {
                YMDHMS 基準日時 = 処理日付.get基準日時();
                RDate 年月日 = 基準日時.getDate();
                RTime 時刻 = 基準日時.getRDateTime().getTime();
                RString 前回処理日時 = new RString(年月日.wareki().toDateString().toString() + SPACE
                        + 時刻.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
                処理対象.getTxtZenShoriNichiji().setValue(前回処理日時);
                処理対象.getTxtZenShoriYMD().setValue(new RDate(年月日.toDateString().toString()));
                処理対象.getTxtZenShoriTime().setValue(時刻);
            }
            処理対象List.add(処理対象);
        }
        div.getDgKoikiShoriTaishoSelect().setDataSource(処理対象List);
    }

    /**
     * 単一用バッチパラメータの作成のメソッドです。
     *
     * @return DBB514001_NofugakuDataSakuseiTandokuShichosonParameter
     */
    public DBB514001_NofugakuDataSakuseiTandokuShichosonParameter get単一用バッチパラメータ() {
        DBB514001_NofugakuDataSakuseiTandokuShichosonParameter parameter = new DBB514001_NofugakuDataSakuseiTandokuShichosonParameter();
        RDate 調定年度 = div.getShoriNaiyo().getTxtTaishoNendo().getValue();
        if (調定年度 != null) {
            parameter.set対象年(調定年度.getYear());
        }
        if (div.getShoriSelect().getChkHikazeiNomiSakusei().getSelectedKeys().contains(STR_0)) {
            parameter.set非課税年金のみ作成フラグ(true);
        } else {
            parameter.set非課税年金のみ作成フラグ(false);
        }
        parameter.set出力順ID(div.getShoriSelect().getCcdChohyoShutsuryokujun().get出力順ID());
        List<NofugakuDataTsushutsuJoken> 抽出条件List = new ArrayList<>();
        List<dgTanitsuShoriJoken_Row> 抽出条件Rows = div.getChushutsuKikan().getDgTanitsuShoriJoken().getDataSource();
        if (抽出条件Rows == null || 抽出条件Rows.isEmpty()) {
            return parameter;
        }
        NofugakuDataTsushutsuJoken 抽出条件 = new NofugakuDataTsushutsuJoken();
        抽出条件.set市町村コード(new LasdecCode(抽出条件Rows.get(0).getTxtCityCode()));
        抽出条件.set市町村名称(抽出条件Rows.get(0).getTxtCityName());
        抽出条件.set集計日区分(抽出条件Rows.get(0).getTxtShukeibiKbnData());
        RString 抽出開始補正 = 抽出条件Rows.get(0).getTxtKikanStHosei().getValue();
        RString 抽出終了補正 = 抽出条件Rows.get(0).getTxtKikanEdHosei().getValue();
        if (調定年度 != null) {
            RDate 開始日 = new RDate(調定年度.getYearValue(), INT_1, INT_1);
            抽出条件.set抽出開始日(開始日.plusDay(Integer.valueOf(抽出開始補正.toString())));
            RDate 終了日 = new RDate(調定年度.getYearValue(), INT_12, INT_31);
            抽出条件.set抽出終了日(終了日.plusDay(Integer.valueOf(抽出終了補正.toString())));
        }
        抽出条件List.add(抽出条件);
        parameter.set抽出条件List(抽出条件List);
        return parameter;
    }

    /**
     * 広域用バッチパラメータの作成のメソッドです。
     *
     * @return DBB514001_NofugakuDataSakuseiTandokuShichosonParameter
     */
    public DBB514001_NofugakuDataSakuseiTandokuShichosonParameter get広域用バッチパラメータ() {
        DBB514001_NofugakuDataSakuseiTandokuShichosonParameter parameter = new DBB514001_NofugakuDataSakuseiTandokuShichosonParameter();
        RDate 調定年度 = div.getShoriNaiyo().getTxtTaishoNendo().getValue();
        if (調定年度 != null) {
            parameter.set対象年(調定年度.getYear());
        }
        if (div.getShoriSelect().getChkHikazeiNomiSakusei().getSelectedKeys().contains(STR_0)) {
            parameter.set非課税年金のみ作成フラグ(true);
        } else {
            parameter.set非課税年金のみ作成フラグ(false);
        }
        parameter.set出力順ID(div.getShoriSelect().getCcdChohyoShutsuryokujun().get出力順ID());
        List<dgKoikiShoriTaishoSelect_Row> 処理対象Rows = div.getKoikiShori().getDgKoikiShoriTaishoSelect().getSelectedItems();
        if (処理対象Rows == null || 処理対象Rows.isEmpty()) {
            return parameter;
        }
        RDate 開始日 = null;
        RDate 終了日 = null;
        if (調定年度 != null) {
            開始日 = new RDate(調定年度.getYearValue(), INT_1, INT_1);
            終了日 = new RDate(調定年度.getYearValue(), INT_12, INT_31);
        }
        List<NofugakuDataTsushutsuJoken> 抽出条件List = new ArrayList<>();
        for (dgKoikiShoriTaishoSelect_Row 処理対象 : 処理対象Rows) {
            NofugakuDataTsushutsuJoken 抽出条件 = new NofugakuDataTsushutsuJoken();
            抽出条件.set市町村コード(new LasdecCode(処理対象.getTxtCityCode().getValue()));
            抽出条件.set市町村名称(処理対象.getTxtCityName().getValue());
            抽出条件.set集計日区分(処理対象.getTxtShukeibiKbnData());
            RString 抽出開始補正 = 処理対象.getTxtKikanStHosei().getValue();
            RString 抽出終了補正 = 処理対象.getTxtKikanEdHosei().getValue();
            if (開始日 != null) {
                抽出条件.set抽出開始日(開始日.plusDay(Integer.valueOf(抽出開始補正.toString())));
            }
            if (終了日 != null) {
                抽出条件.set抽出終了日(終了日.plusDay(Integer.valueOf(抽出終了補正.toString())));
            }
            抽出条件List.add(抽出条件);
        }
        parameter.set抽出条件List(抽出条件List);
        return parameter;
    }

    /**
     * 単一コンフィグ保存のメソッドです。
     *
     */
    public void 単一コンフィグ保存() {
        List<dgTanitsuShoriJoken_Row> 抽出条件Rows = div.getChushutsuKikan().getDgTanitsuShoriJoken().getDataSource();
        RString 抽出終了補正 = 抽出条件Rows.get(0).getTxtKikanEdHosei().getValue();
        RString 市町村コード = new RString(STR_00 + 抽出条件Rows.get(0).getTxtCityShikibetsuId().toString());
        BusinessConfig.update(ConfigNameDBB.納付額データ_抽出期間補正, 抽出終了補正,
                変更理由, 市町村コード, RDate.getNowDate());
    }

    /**
     * 広域コンフィグ保存のメソッドです。
     *
     */
    public void 広域コンフィグ保存() {
        List<dgKoikiShoriTaishoSelect_Row> 処理対象Rows = div.getKoikiShori().getDgKoikiShoriTaishoSelect().getSelectedItems();
        for (dgKoikiShoriTaishoSelect_Row row : 処理対象Rows) {
            if (row.getTxtKikanEdHosei().getValue() == null) {
                continue;
            }
            RString 抽出終了補正 = row.getTxtKikanEdHosei().getValue();
            RString 市町村コード = new RString(STR_00 + row.getTxtCityShikibetsuId().toString());
            BusinessConfig.update(ConfigNameDBB.納付額データ_抽出期間補正, 抽出終了補正,
                    変更理由, 市町村コード, RDate.getNowDate());
        }
    }
}
