/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki2120161;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.JigyoHokokuShiryouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki2120161.JigyohokokuGeppoYoshiki2120161ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業報告月報様式_03のReportのクラスです。
 *
 * @reamsid_L DBU-5560-070 wanghuafeng
 */
public class JigyohokokuGeppoYoshiki2120161Report extends Report<JigyohokokuGeppoYoshiki2120161ReportSource> {

    private static final RString 集計番号_0107 = new RString("0107");
    private static final RString 集計番号_0109 = new RString("0109");
    private static final RString 集計番号_0110 = new RString("0110");
    private static final RString ア内容 = new RString("ア．件数");
    private static final RString ウ内容 = new RString("ウ．費用額");
    private static final RString エ内容 = new RString("エ．給付額");
    private static final RString 一行目 = new RString("01");
    private static final RString 二行目 = new RString("02");
    private static final RString 三行目 = new RString("03");
    private static final RString 四行目 = new RString("04");
    private static final RString 五行目 = new RString("05");
    private static final RString 六行目 = new RString("06");
    private static final RString 七行目 = new RString("07");
    private static final RString 八行目 = new RString("08");
    private static final RString 九行目 = new RString("09");
    private static final RString 十行目 = new RString("10");
    private static final RString 十一行目 = new RString("11");
    private static final RString 十二行目 = new RString("12");
    private static final RString 十三行目 = new RString("13");
    private static final RString 十四行目 = new RString("14");
    private static final RString 十五行目 = new RString("15");
    private static final RString 十六行目 = new RString("16");
    private static final RString 十七行目 = new RString("17");
    private static final RString 十八行目 = new RString("18");
    private static final RString 十九行目 = new RString("19");
    private static final RString 二十行目 = new RString("20");
    private static final RString 二十一行目 = new RString("21");
    private static final RString 二十二行目 = new RString("22");
    private static final RString 二十三行目 = new RString("23");
    private static final RString 二十四行目 = new RString("24");
    private static final RString 二十五行目 = new RString("25");
    private static final RString 二十六行目 = new RString("26");
    private static final RString 二十七行目 = new RString("27");
    private static final RString 二十八行目 = new RString("28");
    private static final RString 二十九行目 = new RString("29");
    private static final RString 三十行目 = new RString("30");
    private static final RString 三十一行目 = new RString("31");
    private static final RString 三十二行目 = new RString("32");
    private static final RString 三十三行目 = new RString("33");
    private static final RString 三十四行目 = new RString("34");
    private static final RString 三十五行目 = new RString("35");
    private static final int INDEX_1 = 0;
    private static final int INDEX_2 = 1;
    private static final int INDEX_3 = 2;
    private static final int INDEX_4 = 3;
    private static final int INDEX_5 = 4;
    private static final int INDEX_6 = 5;
    private static final int INDEX_7 = 6;
    private static final int INDEX_8 = 7;
    private static final int INDEX_9 = 8;
    private static final int INDEX_10 = 9;
    private static final int INDEX_11 = 10;
    private static final int INDEX_12 = 11;
    private static final int INDEX_13 = 12;
    private static final int INDEX_14 = 13;
    private static final int INDEX_15 = 14;
    private static final int INDEX_16 = 15;
    private static final int INDEX_17 = 16;
    private static final int INDEX_18 = 17;
    private static final int INDEX_19 = 18;
    private static final int INDEX_20 = 19;
    private static final int INDEX_21 = 20;
    private static final int INDEX_22 = 21;
    private static final int INDEX_23 = 22;
    private static final int INDEX_24 = 23;
    private static final int INDEX_25 = 24;
    private static final int INDEX_26 = 25;
    private static final int INDEX_27 = 26;
    private static final int INDEX_28 = 27;
    private static final int INDEX_29 = 28;
    private static final int INDEX_30 = 29;
    private static final int INDEX_31 = 30;
    private static final int INDEX_32 = 31;
    private static final int INDEX_33 = 32;
    private static final int INDEX_34 = 33;
    private static final int INDEX_35 = 34;
    private static final RString 横番号_1 = new RString("1");
    private static final RString 横番号_2 = new RString("2");
    private static final RString 横番号_4 = new RString("4");
    private static final RString 横番号_5 = new RString("5");
    private static final RString 横番号_6 = new RString("6");
    private static final RString 横番号_7 = new RString("7");
    private static final RString 横番号_8 = new RString("8");
    private static final RString 横番号_9 = new RString("9");
    private static final RString 横番号_10 = new RString("10");
    private final JigyohokokuCompYoshiki201Business business;
    private List<JigyohokokuCompResultEntity> list;

    /**
     * インスタンスを生成します。
     *
     * @param business JigyohokokuCompYoshiki201Business
     */
    public JigyohokokuGeppoYoshiki2120161Report(JigyohokokuCompYoshiki201Business business) {
        this.business = business;
        list = new ArrayList<>();
        for (int i = 0; i <= INDEX_35; i++) {
            JigyohokokuCompResultEntity entity = new JigyohokokuCompResultEntity();
            list.add(entity);
        }
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuGeppoYoshiki2120161ReportSource> reportSourceWriter) {
        RString 集計番号 = RString.EMPTY;
        RString 給付実績区分コード = RString.EMPTY;
        for (JigyoHokokuShiryouRelateEntity entity : business.get事業報告資料()) {
            list = get縦番号1(entity.getTateNo(), entity.getYokoNo(), entity.getSyukeiKekkaAtai());
            集計番号 = entity.getSyukeiNo();
            給付実績区分コード = business.get給付実績区分コード();
        }
        for (int i = 0; i < list.size(); i++) {
            IJigyohokokuGeppoYoshiki2120161Editor headEditor = new JigyohokokuGeppoYoshiki2120161HeadEditor(
                    business, getTitleThree(集計番号), 集計番号, 給付実績区分コード);
            IJigyohokokuGeppoYoshiki2120161Editor bodyEditor = new JigyohokokuGeppoYoshiki2120161BodyEditor(list.get(i), i);
            IJigyohokokuGeppoYoshiki2120161Builder builder = new JigyohokokuGeppoYoshiki2120161Builder(headEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private RString getTitleThree(RString 集計番号) {
        RString title;
        if (集計番号_0107.equals(集計番号)) {
            title = ア内容;
        } else if (集計番号_0109.equals(集計番号)) {
            title = ウ内容;
        } else if (集計番号_0110.equals(集計番号)) {
            title = エ内容;
        } else {
            title = RString.EMPTY;
        }
        return title;
    }

    private List<JigyohokokuCompResultEntity> get横番号(RString 横番号, int index, Decimal 集計結果) {
        JigyohokokuCompResultEntity entity = list.get(index);
        if (横番号_1.equals(横番号)) {
            entity.set要支援１(集計結果);
        } else if (横番号_2.equals(横番号)) {
            entity.set要支援２(集計結果);
        } else if (横番号_4.equals(横番号)) {
            entity.set非該当(集計結果);
        } else if (横番号_5.equals(横番号)) {
            entity.set経過的要介護(集計結果);
        } else if (横番号_6.equals(横番号)) {
            entity.set要介護１(集計結果);
        } else if (横番号_7.equals(横番号)) {
            entity.set要介護２(集計結果);
        } else if (横番号_8.equals(横番号)) {
            entity.set要介護３(集計結果);
        } else if (横番号_9.equals(横番号)) {
            entity.set要介護４(集計結果);
        } else if (横番号_10.equals(横番号)) {
            entity.set要介護５(集計結果);
        }
        return list;
    }

    private List<JigyohokokuCompResultEntity> get縦番号1(RString 縦番号, RString 横番号, Decimal 集計結果) {
        if (一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_1, 集計結果);
        } else if (二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_2, 集計結果);
        } else if (三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_3, 集計結果);
        } else if (四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_4, 集計結果);
        } else if (五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_5, 集計結果);
        } else if (六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_6, 集計結果);
        } else if (七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_7, 集計結果);
        } else if (八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_8, 集計結果);
        } else if (九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_9, 集計結果);
        } else if (十行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_10, 集計結果);
        } else if (十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_11, 集計結果);
        } else if (十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_12, 集計結果);
        } else if (十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_13, 集計結果);
        } else if (十四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_14, 集計結果);
        } else if (十五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_15, 集計結果);
        } else if (十六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_16, 集計結果);
        } else if (十七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_17, 集計結果);
        } else if (十八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_18, 集計結果);
        }
        list = get縦番号2(縦番号, 横番号, 集計結果);
        return list;
    }

    private List<JigyohokokuCompResultEntity> get縦番号2(RString 縦番号, RString 横番号, Decimal 集計結果) {
        if (十九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_19, 集計結果);
        } else if (二十行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_20, Decimal.ZERO);
        } else if (二十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_21, 集計結果);
        } else if (二十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_22, 集計結果);
        } else if (二十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_23, 集計結果);
        } else if (二十四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_24, 集計結果);
        } else if (二十五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_25, 集計結果);
        } else if (二十六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_26, 集計結果);
        } else if (二十七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_27, 集計結果);
        } else if (二十八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_28, 集計結果);
        } else if (二十九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_29, 集計結果);
        } else if (三十行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_30, 集計結果);
        } else if (三十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_31, 集計結果);
        } else if (三十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_32, 集計結果);
        } else if (三十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_33, 集計結果);
        } else if (三十四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_34, 集計結果);
        } else if (三十五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_35, 集計結果);
        }
        return list;
    }

}
