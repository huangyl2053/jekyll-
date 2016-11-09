/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki251;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.JigyoHokokuShiryouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki251.JigyohokokuCompYoshiki251ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業報告複合様式_05のReportクラスです。
 *
 * @reamsid_L DBU-5560-060 wanghuafeng
 */
public class JigyohokokuCompYoshiki251Report extends Report<JigyohokokuCompYoshiki251ReportSource> {

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
    private static final RString 横番号_1 = new RString("1");
    private static final RString 横番号_2 = new RString("2");
    private static final RString 横番号_4 = new RString("4");
    private static final RString 横番号_6 = new RString("6");
    private static final RString 横番号_7 = new RString("7");
    private static final RString 横番号_8 = new RString("8");
    private static final RString 横番号_9 = new RString("9");
    private static final RString 横番号_10 = new RString("10");
    private final JigyohokokuCompYoshiki201Business business;
    private List<JigyohokokuCompResultEntity> list;

    /**
     * 事業報告複合様式_05のReportです
     *
     * @param business JigyohokokuCompYoshiki201Business
     */
    public JigyohokokuCompYoshiki251Report(JigyohokokuCompYoshiki201Business business) {
        this.business = business;
        list = new ArrayList<>();
        for (int i = 0; i <= INDEX_17; i++) {
            JigyohokokuCompResultEntity entity = new JigyohokokuCompResultEntity();
            list.add(entity);
        }

    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki251ReportSource> writer) {
        RString 集計番号 = RString.EMPTY;
        RString 給付実績区分コード = RString.EMPTY;
        for (JigyoHokokuShiryouRelateEntity entity : business.get事業報告資料()) {
            list = get縦番号(entity.getTateNo(), entity.getYokoNo(), entity.getSyukeiKekkaAtai());
            集計番号 = entity.getSyukeiNo();
            給付実績区分コード = business.get給付実績区分コード();
        }
        for (JigyohokokuCompResultEntity entity : list) {
            IJigyohokokuCompYoshiki251Editor headEditor = new JigyohokokuCompYoshiki251HeadEditor(
                    集計番号, 給付実績区分コード, business);
            IJigyohokokuCompYoshiki251Editor bodyEditor = new JigyohokokuCompYoshiki251BodyEditor(entity);
            IJigyohokokuCompYoshiki251Builder builder = new JigyohokokuCompYoshiki251Builder(headEditor, bodyEditor);
            writer.writeLine(builder);
        }

    }

    private List<JigyohokokuCompResultEntity> get縦番号(RString 縦番号, RString 横番号, Decimal 集計結果) {
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
        }
        return list;
    }

    private List<JigyohokokuCompResultEntity> get横番号(RString 横番号, int index, Decimal 集計結果) {
        JigyohokokuCompResultEntity entity = list.get(index);
        if (横番号_1.equals(横番号)) {
            entity.set要支援１(集計結果);
            entity.set要支援１＿１(集計結果);
        } else if (横番号_2.equals(横番号)) {
            entity.set要支援２(集計結果);
            entity.set要支援２＿１(集計結果);
        } else if (横番号_4.equals(横番号)) {
            entity.set経過的要介護(集計結果);
            entity.set経過的要介護＿１(集計結果);
        } else if (横番号_6.equals(横番号)) {
            entity.set要介護１(集計結果);
            entity.set要介護１＿１(集計結果);
        } else if (横番号_7.equals(横番号)) {
            entity.set要介護２(集計結果);
            entity.set要介護２＿１(集計結果);
        } else if (横番号_8.equals(横番号)) {
            entity.set要介護３(集計結果);
            entity.set要介護３＿１(集計結果);
        } else if (横番号_9.equals(横番号)) {
            entity.set要介護４(集計結果);
            entity.set要介護４＿１(集計結果);
        } else if (横番号_10.equals(横番号)) {
            entity.set要介護５(集計結果);
            entity.set要介護５＿１(集計結果);
        }
        return list;
    }

}
