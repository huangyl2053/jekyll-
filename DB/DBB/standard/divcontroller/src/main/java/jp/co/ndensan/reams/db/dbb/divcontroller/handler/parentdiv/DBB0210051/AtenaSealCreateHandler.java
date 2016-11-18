/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210051;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021051.DBB021051_AtenaSealSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210051.AtenaSealCreateDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.YmdKubun;

/**
 * 画面設計_DBB0210051_宛名シール作成（介護賦課）のハンドラクラスです。
 *
 * reamsid_L DBB-5660-010 wangxingpeng
 */
public class AtenaSealCreateHandler {

    private final AtenaSealCreateDiv div;
    private Code 導入形態コード;
    private KoseiShichosonJoho 市町村情報;
    private static final RString 定数_000000 = new RString("000000");
    private static final RString 定数_000001 = new RString("000001");
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString 定数_111 = new RString("111");
    private static final RString 定数_112 = new RString("112");
    private static final RString 定数_120 = new RString("120");
    private static final RString 定数_00 = new RString("00");
    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_4 = new RString("4");
    private static final RString 定数_5 = new RString("5");
    private static final RString 定数_6 = new RString("6");
    private static final RString 定数_7 = new RString("7");
    private static final RString 定数_12 = new RString("12");
    private static final int NUM_0 = 0;
    private static final int NUM_6 = 6;
    private static final RString ALL = new RString("all");
    private static final RString 普通徴収 = new RString("普通徴収");
    private static final RString 特別徴収 = new RString("特別徴収");
    private static final RString 現住所 = new RString("現住所");
    private static final RString 送付先又は代納人 = new RString("送付先又は代納人");
    private static final RString 表示する = new RString("表示する");
    private static final RString 表示しない = new RString("表示しない");
    private static final RString 市町村 = new RString(" 市町村 ");
    private static final RString 郡 = new RString(" 郡 ");
    private static final RString 都道府県 = new RString(" 都道府県 ");
    private static final RString 方書 = new RString(" 方書 ");
    private static final ReportId 帳票ID = ReportIdDBZ.DBZ100001.getReportId();

    /**
     * コンストラクタです。
     *
     * @param div AtenaSealCreateDiv
     */
    public AtenaSealCreateHandler(AtenaSealCreateDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div AtenaSealCreateDiv
     * @return ハンドラ
     */
    public static AtenaSealCreateHandler of(AtenaSealCreateDiv div) {
        return new AtenaSealCreateHandler(div);
    }

    /**
     * onloadのメソッドます。
     *
     */
    public void onload() {
        ShichosonSecurityJoho 市町村情報セキュリティ = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        導入形態コード = 市町村情報セキュリティ.get導入形態コード();
        市町村情報 = 市町村情報セキュリティ.get市町村情報();
        if (導入形態コード.getColumnValue().equals(定数_111) || 導入形態コード.getColumnValue().equals(定数_112)) {
            List<KoseiShichoson> 構成市町村リスト = KoikiShichosonJohoFinder.createInstance().getKoseiShichosonList().records();
            if (市町村情報.get市町村識別ID().equals(定数_00)) {
                List<KeyValueDataSource> dataSourceList = new ArrayList<>();
                KeyValueDataSource dataSourceone = new KeyValueDataSource(定数_000000, 全市町村);
                dataSourceList.add(dataSourceone);
                KeyValueDataSource dataSourcetwo = new KeyValueDataSource(定数_000001, 市町村情報.get市町村名称());
                dataSourceList.add(dataSourcetwo);
                div.getDdlShicyouson().setDataSource(dataSourceList);
                div.getDdlShicyouson().setSelectedKey(定数_000000);
            }
            if (!(市町村情報.get市町村識別ID().equals(定数_00)) && (構成市町村リスト != null)) {
                getdataSource(構成市町村リスト);
            }
        }
        if (導入形態コード.getColumnValue().equals(定数_120)) {
            div.getDdlShicyouson().setDisplayNone(true);
        }
        div.getTxtKijyunnengatu().setYmdKubunEnum(YmdKubun.年月);
        div.getCcdJushoSettei().initialize(SubGyomuCode.DBZ介護共通.getColumnValue(), 帳票ID.getColumnValue());
        div.getCcdAtenaSealPosition().load(定数_12);
        div.getCcdShutsuryokuJun().load(SubGyomuCode.DBZ介護共通, 帳票ID);
    }

    /**
     * setバッチパラメータのメソッドます。
     *
     * @return DBB021051_AtenaSealSakuseiParameter
     */
    public DBB021051_AtenaSealSakuseiParameter setバッチパラメータ() {
        DBB021051_AtenaSealSakuseiParameter parameter = new DBB021051_AtenaSealSakuseiParameter();
        List<RString> list = div.getChkTaishosha().getSelectedValues();
        int j = 0;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(普通徴収)) {
                    j = j + 1;
                }
                if (list.get(i).equals(特別徴収)) {
                    j = j + 2;
                }
            }
        }
        RString 抽出対象者 = new RString(j);
        RString 画面の基準年月 = new RString(div.getTxtKijyunnengatu().getValue().toString());
        FlexibleYearMonth 基準年月 = new FlexibleYearMonth(画面の基準年月.substring(NUM_0, NUM_6));
        RString 資格区分 = get資格区分(div.getDdlShikakuKubun().getSelectedKey());
        RString 市町村指定のkey = div.getDdlShicyouson().getSelectedKey();
        RString 市町村指定のvalue = div.getDdlShicyouson().getSelectedValue();
        RString 市町村指定 = null;
        if (市町村指定のkey != null && !市町村指定のkey.isEmpty()) {
            市町村指定 = 市町村指定のkey.concat(RString.HALF_SPACE).concat(市町村指定のvalue);
        }
        RString 最優先住所 = div.getDdlSaiyusenJusho().getSelectedValue();
        RString 敬称 = div.getDdlKeisho().getSelectedValue();
        RString 被保番号表示 = div.getRadIsPrintHihokenshaNo().getSelectedValue();
        RStringBuilder 宛先住所設定 = new RStringBuilder();
        if (div.getCcdJushoSettei().is市町村名表示()) {
            宛先住所設定 = 宛先住所設定.append(市町村);
        }
        if (div.getCcdJushoSettei().is郡名表示()) {
            宛先住所設定 = 宛先住所設定.append(郡);
        }
        if (div.getCcdJushoSettei().is都道府県名表示()) {
            宛先住所設定 = 宛先住所設定.append(都道府県);
        }
        if (div.getCcdJushoSettei().is方書表示()) {
            宛先住所設定 = 宛先住所設定.append(方書);
        }
        Long 出力順ID = div.getCcdShutsuryokuJun().get出力順ID();
        parameter.set抽出対象者(抽出対象者);
        parameter.set基準年月(new RYearMonth(基準年月.toDateString()));
        parameter.set資格区分(資格区分);
        parameter.set市町村指定(市町村指定);
        if (最優先住所.equals(現住所)) {
            parameter.set最優先住所(定数_1);
        }
        if (最優先住所.equals(送付先又は代納人)) {
            parameter.set最優先住所(定数_2);
        }
        parameter.set敬称(敬称);
        if (被保番号表示.equals(表示する)) {
            parameter.set被保番号表示(定数_1);
        }
        if (被保番号表示.equals(表示しない)) {
            parameter.set被保番号表示(定数_0);
        }
        if (出力順ID != null) {
            parameter.set出力順ID(Long.parseLong(出力順ID.toString()));
        }
        if (宛先住所設定 != null) {
            parameter.set宛先住所設定(宛先住所設定.toRString());
        }
        parameter.set業務コード(SubGyomuCode.DBB介護賦課);
        return parameter;
    }

    /**
     * onChangeのメソッドます。
     *
     */
    public void onChange() {
        List<RString> 抽出対象list = div.getChkTaishosha().getSelectedValues();
        if (抽出対象list != null) {
            if (抽出対象list.size() == 2) {
                div.getDdlShikakuKubun().setSelectedKey(ALL);
                div.getDdlShikakuKubun().setDisabled(true);
            } else {
                div.getDdlShikakuKubun().setDisabled(false);
            }
        }
    }

    private void getdataSource(List<KoseiShichoson> 構成市町村リスト) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (int i = 0; i < 構成市町村リスト.size(); i++) {
            RString key = null;
            if (構成市町村リスト.get(i).get市町村コード() != null) {
                key = 構成市町村リスト.get(i).get市町村コード().getColumnValue();
            }
            RString value = 構成市町村リスト.get(i).get市町村名称();
            KeyValueDataSource dataSource = new KeyValueDataSource(key, value);
            dataSourceList.add(dataSource);
        }
        div.getDdlShicyouson().setDataSource(dataSourceList);
        div.getDdlShicyouson().setSelectedKey(dataSourceList.get(NUM_0).getKey());
        div.getDdlShicyouson().setDisabled(true);
    }

    private RString get資格区分(RString 資格区分のkey) {
        switch (資格区分のkey.toString()) {
            case "nihonjin1go":
                return 定数_1;
            case "nihonjin2go":
                return 定数_2;
            case "gaikokujin1go":
                return 定数_3;
            case "gaikokujin2go":
                return 定数_4;
            case "all1go":
                return 定数_5;
            case "all2go":
                return 定数_6;
            case "all":
                return 定数_7;
            default:
                return RString.EMPTY;
        }
    }
}
