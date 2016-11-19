/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.riyojokyotokeihyo;

import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_EditPattern;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.TokeiServiceShurui;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo.RiyoJokyoTokeihyoShukeiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.riyojokyotokeihyo.RiyoJokyoTokeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 利用状況統計表のEditorです。
 *
 * @reamsid_L DBC-3500-050 jinjue
 */
public class RiyoJokyoTokeihyoEditor implements IRiyoJokyoTokeihyoEditor {

    private final RiyoJokyoTokeihyoShukeiKekkaEntity item;
    private static final RString 作成 = new RString("作成");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString コロン = new RString("：");
    private static final RString 旧市町村コードフラグ = new RString("000000");
    private static final int サイズ_3 = 3;
    private static final int サイズ_4 = 4;
    private static final int サイズ_5 = 5;
    private static final int サイズ_6 = 6;

    /**
     * RiyoJokyoTokeihyoShukeiKekkaEntityインスタンスを生成します。
     *
     * @param item RiyoJokyoTokeihyoShukeiKekkaEntity
     */
    protected RiyoJokyoTokeihyoEditor(RiyoJokyoTokeihyoShukeiKekkaEntity item) {
        this.item = item;
    }

    @Override
    public RiyoJokyoTokeihyoReportSource edit(RiyoJokyoTokeihyoReportSource source) {
        return editSource(source);
    }

    private RiyoJokyoTokeihyoReportSource editSource(RiyoJokyoTokeihyoReportSource source) {
        if (item == null) {
            return source;
        }
        RString サービス種類コード = item.getリスト_サービス種類集計().get(0).getサービス種類コード();
        RiyojokyoTokeihyo_EditPattern 利用状況統計表_編集仕様 = RiyojokyoTokeihyo_EditPattern.toValue(サービス種類コード);
        int 集計項目せーズ = item.getリスト_サービス種類集計().size();
        if (item.get処理市町村コード() != null && !RString.EMPTY.equals(item.get処理市町村コード().getColumnValue())) {
            source.kyuShichoson = item.get処理市町村コード().getColumnValue().concat(コロン).concat(item.get処理市町村名());
        } else if (RString.isNullOrEmpty(item.get旧市町村コード()) || 旧市町村コードフラグ.equals(item.get旧市町村コード())) {
            source.kyuShichoson = RString.EMPTY;
        } else {
            source.kyuShichoson = item.get旧市町村コード().concat(コロン).concat(item.get旧市町村名());
        }
        source.printTimeStamp = this.get作成年月日時(item.get作成日時()).concat(RString.HALF_SPACE).concat(作成);
        source.hokenshaName = item.get保険者名();
        source.hokenshaNo = item.get保険者番号();
        source.list1_1 = 利用状況統計表_編集仕様.get集計項目名1();
        source.list1_2 = 金額(item.getリスト_サービス種類集計().get(0).get集計項目1_1());
        source.list1_3 = format金額(item.getリスト_サービス種類集計().get(0).get集計項目1_2());
        source.list1_4 = format金額(item.getリスト_サービス種類集計().get(0).get集計項目1_3());
        source.list1_5 = format金額(item.getリスト_サービス種類集計().get(0).get集計項目1_4());
        source.list1_6 = format金額(item.getリスト_サービス種類集計().get(0).get集計項目1_5());
        source.list1_7 = format金額(item.getリスト_サービス種類集計().get(0).get集計項目1_6());
        source.list1_8 = format金額(item.getリスト_サービス種類集計().get(0).get集計項目1_7());
        source.list1_9 = format金額(item.getリスト_サービス種類集計().get(0).get集計項目1_8());
        source.list1_10 = format金額(item.getリスト_サービス種類集計().get(0).get集計項目1_9());
        source.list1_11 = format金額(item.getリスト_サービス種類集計().get(0).get集計項目1_10());
        if (1 < 集計項目せーズ && item.getリスト_サービス種類集計().get(1) != null) {
            RString サービス種類 = 利用状況統計表_編集仕様.get名称();
            if (RString.EMPTY.equals(サービス種類)) {
                source.list2_1 = RString.EMPTY;
                source.list2_2 = RString.EMPTY;
                source.list2_10 = RString.EMPTY;
                source.list2_11 = RString.EMPTY;
                source.list2_3 = RString.EMPTY;
                source.list2_4 = RString.EMPTY;
                source.list2_5 = RString.EMPTY;
                source.list2_6 = RString.EMPTY;
                source.list2_7 = RString.EMPTY;
                source.list2_8 = RString.EMPTY;
                source.list2_9 = RString.EMPTY;
                source.list2_11 = RString.EMPTY;
            } else {
                source.list2_1 = 利用状況統計表_編集仕様.get集計項目名2();
                source.list2_2 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_1(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_1());
                source.list2_10 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_9(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_9());
                source.list2_3 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_2(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_2());
                source.list2_4 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_3(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_3());
                source.list2_5 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_4(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_4());
                source.list2_6 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_5(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_5());
                source.list2_7 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_6(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_6());
                source.list2_8 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_7(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_7());
                source.list2_9 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_8(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_8());
                source.list2_11 = this.内訳有無(item.getリスト_サービス種類集計().get(1).get集計項目2_10(),
                        item.getリスト_サービス種類集計().get(1).get集計項目2内訳_10());
            }
        }
        if (2 < 集計項目せーズ && item.getリスト_サービス種類集計().get(2) != null) {
            source.list3_1 = new RString(new Decimal(item.getリスト_サービス種類集計().get(2).getサービス種類コード().toString()).toString()).concat("．");
            source.list3_10 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_7());
            source.list3_11 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_8());
            source.list3_12 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_9());
            source.list3_13 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_10());
            source.list3_2 = TokeiServiceShurui.toValue(item.getリスト_サービス種類集計().get(2).getサービス種類コード()).get統計表印字名称1();
            source.list3_3 = 利用状況統計表_編集仕様.get集計項目名3();
            source.list3_4 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_1());
            source.list3_5 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_2());
            source.list3_6 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_3());
            source.list3_7 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_4());
            source.list3_8 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_5());
            source.list3_9 = this.集計項目(item.getリスト_サービス種類集計().get(2).get集計項目3_6());
        }
        if (サイズ_3 < 集計項目せーズ && item.getリスト_サービス種類集計().get(サイズ_3) != null) {
            source.list4_1 = TokeiServiceShurui.toValue(item.getリスト_サービス種類集計().get(サイズ_3).getサービス種類コード()).get統計表印字名称2();
            source.list4_2 = RiyojokyoTokeihyo_EditPattern.toValue(item.getリスト_サービス種類集計().get(サイズ_3).
                    getサービス種類コード()).get集計項目名4();
            source.list4_3 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_1());
            source.list4_4 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_2());
            source.list4_5 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_3());
            source.list4_6 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_4());
            source.list4_7 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_5());
            source.list4_8 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_6());
            source.list4_9 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_7());
            source.list4_10 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_8());
            source.list4_11 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_9());
            source.list4_12 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_3).get集計項目4_10());
        }
        if (サイズ_4 < 集計項目せーズ && item.getリスト_サービス種類集計().get(サイズ_4) != null) {
            source.list5_1 = TokeiServiceShurui.toValue(item.getリスト_サービス種類集計().get(サイズ_4).getサービス種類コード()).get統計表印字名称3();
            source.list5_2 = RiyojokyoTokeihyo_EditPattern.toValue(item.getリスト_サービス種類集計().get(サイズ_4).
                    getサービス種類コード()).get集計項目名5();
            source.list5_3 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_1());
            source.list5_5 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_2());
            source.list5_5 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_3());
            source.list5_6 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_4());
            source.list5_7 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_5());
            source.list5_8 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_6());
            source.list5_9 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_7());
            source.list5_10 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_8());
            source.list5_11 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_9());
            source.list5_12 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_4).get集計項目5_10());
        }
        if (サイズ_5 < 集計項目せーズ && item.getリスト_サービス種類集計().get(サイズ_5) != null) {
            source.list6_1 = RiyojokyoTokeihyo_EditPattern.toValue(item.getリスト_サービス種類集計().get(サイズ_5).
                    getサービス種類コード()).get集計項目名6();
            source.list6_2 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_1());
            source.list6_3 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_2());
            source.list6_6 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_3());
            source.list6_5 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_4());
            source.list6_6 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_5());
            source.list6_7 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_6());
            source.list6_8 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_7());
            source.list6_9 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_8());
            source.list6_10 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_9());
            source.list6_11 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_5).get集計項目6_10());
        }
        if (サイズ_6 < 集計項目せーズ && item.getリスト_サービス種類集計().get(サイズ_6) != null) {
            source.list7_1 = RiyojokyoTokeihyo_EditPattern.toValue(item.getリスト_サービス種類集計().
                    get(サイズ_6).getサービス種類コード()).get集計項目名7();
            source.list7_2 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_1());
            source.list7_3 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_2());
            source.list7_7 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_3());
            source.list7_5 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_4());
            source.list7_6 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_5());
            source.list7_7 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_6());
            source.list7_8 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_7());
            source.list7_9 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_8());
            source.list7_10 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_9());
            source.list7_11 = this.集計項目(item.getリスト_サービス種類集計().get(サイズ_6).get集計項目7_10());
        }
        return source;
    }

    private RString get作成年月日時(RDateTime 年月日時) {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(年月日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", 年月日時.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", 年月日時.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", 年月日時.getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }

    private RString 内訳有無(Decimal 集計項目2, Decimal 集計項目2_2) {
        RiyojokyoTokeihyo_EditPattern 編集仕様 = RiyojokyoTokeihyo_EditPattern.toValue(item.getリスト_サービス種類集計().get(0).getサービス種類コード());
        if (RString.isNullOrEmpty(編集仕様.get集計項目名2())) {
            return RString.EMPTY;
        } else {
            boolean is内訳有無 = 編集仕様.get回数集計パターン().is内訳有無();
            if (is内訳有無) {
                return format金額(集計項目2).concat("(")
                        .concat(format金額(集計項目2_2)).concat(")");
            } else {
                return format金額(集計項目2);

            }
        }
    }

    private RString 集計項目(Decimal 金額) {
        RString 表示名称 = TokeiServiceShurui.施設サービス計_15_17の合計.get名称();
        if (RString.EMPTY.equals(表示名称)) {
            return new RString(Decimal.ZERO.intValue());
        } else {
            return format金額(金額);
        }
    }

    private RString 金額(Decimal 金額) {
        if (金額 != null || Decimal.ZERO.equals(金額)) {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        } else {
            return RString.HALF_SPACE;
        }
    }

    private RString format金額(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        } else {
            return RString.HALF_SPACE;
        }
    }
}
