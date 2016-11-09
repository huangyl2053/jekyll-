/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki201;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.JigyoHokokuShiryouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業報告月報様式_01のReportクラスです。
 *
 * @reamsid_L DBU-5560-040 xuyannan
 */
public class JigyohokokuCompYoshiki201Report extends Report<JigyohokokuCompYoshiki201ReportSource> {

    private static final RString 一行目 = new RString("15");
    private static final RString 二行目 = new RString("01");
    private static final RString 三行目 = new RString("16");
    private static final RString 四行目 = new RString("17");
    private static final RString 五行目 = new RString("18");
    private static final RString 六行目 = new RString("19");
    private static final RString 七行目 = new RString("26");
    private static final RString 八行目 = new RString("30");
    private static final RString 九行目 = new RString("20");
    private static final RString 十行目 = new RString("21");
    private static final RString 十一行目 = new RString("02");
    private static final RString 十二行目 = new RString("23");
    private static final RString 十三行目 = new RString("24");
    private static final RString 十四行目 = new RString("25");
    private static final RString 十五行目 = new RString("03");
    private static final RString 十六行目 = new RString("22");
    private static final RString 十七行目 = new RString("04");
    private static final RString 十八行目 = new RString("05");
    private static final RString 十九行目 = new RString("28");
    private static final RString 二十行目 = new RString("29");
    private static final RString 二十一行目 = new RString("31");
    private static final RString 二十二行目 = new RString("37");
    private static final RString 二十三行目 = new RString("32");
    private static final RString 二十四行目 = new RString("39");
    private static final RString 二十五行目 = new RString("33");
    private static final RString 二十六行目 = new RString("34");
    private static final RString 二十七行目 = new RString("27");
    private static final RString 二十八行目 = new RString("35");
    private static final RString 二十九行目 = new RString("36");
    private static final RString 三十行目 = new RString("38");
    private static final RString 三十一行目 = new RString("06");
    private static final RString 三十二行目 = new RString("07");
    private static final RString 三十三行目 = new RString("08");
    private static final RString 三十四行目 = new RString("09");
    private static final RString 三十五行目 = new RString("14");
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
    private final JigyohokokuCompYoshiki201Business business;
    private final List<JigyohokokuCompResultEntity> list;

    /**
     * インスタンスを生成します。
     *
     * @param business JigyohokokuCompYoshiki201Business
     */
    public JigyohokokuCompYoshiki201Report(JigyohokokuCompYoshiki201Business business) {
        this.business = business;
        list = new ArrayList<>();
        for (int i = 0; i <= INDEX_35; i++) {
            list.add(new JigyohokokuCompResultEntity());
        }
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki201ReportSource> reportSourceWriter) {
        for (JigyoHokokuShiryouRelateEntity entity : business.get事業報告資料()) {
            get縦番号1(entity.getTateNo(), entity);
        }
        IJigyohokokuCompYoshiki201Editor headEditor = new JigyohokokuCompYoshiki201HeadEditor(business);
        for (JigyohokokuCompResultEntity entity : list) {
            IJigyohokokuCompYoshiki201Editor bodyEditor = new JigyohokokuCompYoshiki201BodyEditor(entity);
            IJigyohokokuCompYoshiki201Builder builder = new JigyohokokuCompYoshiki201Builder(headEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }

    }

    private void get横番号(RString 横番号, JigyohokokuCompResultEntity resultEntity, JigyoHokokuShiryouRelateEntity entity) {
        resultEntity.set集計番号(entity.getSyukeiNo());
        if (IchijiHanteiKekkaCode06.要支援1.getコード().equals(横番号)) {
            resultEntity.set要支援１(entity.getSyukeiKekkaAtai());
        } else if (IchijiHanteiKekkaCode06.要支援2.getコード().equals(横番号)) {
            resultEntity.set要支援２(entity.getSyukeiKekkaAtai());
        } else if (IchijiHanteiKekkaCode06.非該当.getコード().equals(横番号)) {
            resultEntity.set非該当(entity.getSyukeiKekkaAtai());
        } else if (IchijiHanteiKekkaCode06.経過的要介護.getコード().equals(横番号)) {
            resultEntity.set経過的要介護(entity.getSyukeiKekkaAtai());
        } else if (IchijiHanteiKekkaCode06.要介護1.getコード().equals(横番号)) {
            resultEntity.set要介護１(entity.getSyukeiKekkaAtai());
        } else if (IchijiHanteiKekkaCode06.要介護2.getコード().equals(横番号)) {
            resultEntity.set要介護２(entity.getSyukeiKekkaAtai());
        } else if (IchijiHanteiKekkaCode06.要介護3.getコード().equals(横番号)) {
            resultEntity.set要介護３(entity.getSyukeiKekkaAtai());
        } else if (IchijiHanteiKekkaCode06.要介護4.getコード().equals(横番号)) {
            resultEntity.set要介護４(entity.getSyukeiKekkaAtai());
        } else if (IchijiHanteiKekkaCode06.要介護5.getコード().equals(横番号)) {
            resultEntity.set要介護５(entity.getSyukeiKekkaAtai());
        }
    }

    private void get縦番号1(RString 縦番号, JigyoHokokuShiryouRelateEntity entity) {
        if (一行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_1), entity);
        } else if (二行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_2), entity);
        } else if (三行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_3), entity);
        } else if (四行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_4), entity);
        } else if (五行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_5), entity);
        } else if (六行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_6), entity);
        } else if (七行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_7), entity);
        } else if (八行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_8), entity);
        } else if (九行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_9), entity);
        } else if (十行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_10), entity);
        } else if (十一行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_11), entity);
        } else if (十二行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_12), entity);
        } else if (十三行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_13), entity);
        } else if (十四行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_14), entity);
        } else if (十五行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_15), entity);
        } else if (十六行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_16), entity);
        } else if (十七行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_17), entity);
        } else if (十八行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_18), entity);
        }
        get縦番号2(縦番号, entity);
    }

    private void get縦番号2(RString 縦番号, JigyoHokokuShiryouRelateEntity entity) {
        if (十九行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_19), entity);
        } else if (二十行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_20), entity);
        } else if (二十一行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_21), entity);
        } else if (二十二行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_22), entity);
        } else if (二十三行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_23), entity);
        } else if (二十四行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_24), entity);
        } else if (二十五行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_25), entity);
        } else if (二十六行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_26), entity);
        } else if (二十七行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_27), entity);
        } else if (二十八行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_28), entity);
        } else if (二十九行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_29), entity);
        } else if (三十行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_30), entity);
        } else if (三十一行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_31), entity);
        } else if (三十二行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_32), entity);
        } else if (三十三行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_33), entity);
        } else if (三十四行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_34), entity);
        } else if (三十五行目.equals(縦番号)) {
            get横番号(entity.getYokoNo(), list.get(INDEX_35), entity);
        }
    }
}
