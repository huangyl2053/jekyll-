/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2021.JigyohokokuCompYoshiki2021ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業報告月報様式_02のReportです。
 *
 * @reamsid_L DBU-5560-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki2021Report extends Report<JigyohokokuCompYoshiki2021ReportSource> {

    private static final RString 集計区分_加算 = new RString("1");
    private static final RString 集計区分_減算 = new RString("2");
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
    private static final RString 十七行目 = new RString("28");
    private static final RString 十八行目 = new RString("29");
    private static final RString 十九行目 = new RString("31");
    private static final RString 二十行目 = new RString("37");
    private static final RString 二十一行目 = new RString("32");
    private static final RString 二十二行目 = new RString("39");
    private static final RString 二十三行目 = new RString("33");
    private static final RString 二十四行目 = new RString("34");
    private static final RString 二十五行目 = new RString("27");
    private static final RString 二十六行目 = new RString("35");
    private static final RString 二十七行目 = new RString("36");
    private static final RString 二十八行目 = new RString("38");
    private static final RString 二十九行目 = new RString("06");
    private static final RString 三十行目 = new RString("07");
    private static final RString 三十一行目 = new RString("08");
    private static final RString 三十二行目 = new RString("09");
    private static final RString 三十三行目 = new RString("14");
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
    private final JigyohokokuCompYoshiki201Business business;
    private List<JigyohokokuCompResultEntity> list;
    private int 合計 = 0;
    private int 加算単位数合計 = 0;
    private int 減算単位数合計 = 0;
    private RString new縦横番号;
    private RString old縦横番号;

    /**
     * インスタンスを生成します。
     *
     * @param business JigyohokokuCompYoshiki201Business
     */
    public JigyohokokuCompYoshiki2021Report(JigyohokokuCompYoshiki201Business business) {
        this.business = business;
        list = new ArrayList<>();
        for (int i = 0; i <= INDEX_33; i++) {
            JigyohokokuCompResultEntity entity = new JigyohokokuCompResultEntity();
            list.add(entity);
        }
        old縦横番号 = RString.EMPTY;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki2021ReportSource> writer) {
        RString 集計番号 = RString.EMPTY;
        RString 給付実績区分コード = RString.EMPTY;
        Collections.sort(business.get事業報告資料(), new Comparator<JigyohokokuCompYoshiki201Entity>() {
            @Override
            public int compare(JigyohokokuCompYoshiki201Entity entity1, JigyohokokuCompYoshiki201Entity entity2) {
                int flag = entity1.get縦番号().compareTo(entity2.get縦番号());
                if (flag == 0) {
                    return entity1.get横番号().compareTo(entity2.get横番号());
                } else {
                    return flag;
                }
            }
        });
        for (JigyohokokuCompYoshiki201Entity entity : business.get事業報告資料()) {
            if (isValueChanged(entity.get縦番号(), entity.get横番号())) {
                cleanValue();
            }
            list = get縦番号1(entity.get縦番号(), entity.get横番号(), entity.get集計区分());
            集計番号 = entity.get集計番号();
            給付実績区分コード = entity.get給付実績区分コード();
        }
        for (JigyohokokuCompResultEntity entity : list) {
            IJigyohokokuCompYoshiki2021Editor headEditor = new JigyohokokuCompYoshiki2021HeadEditor(
                    business, 集計番号, 給付実績区分コード);
            IJigyohokokuCompYoshiki2021Editor bodyEditor = new JigyohokokuCompYoshiki2021BodyEditor(entity);
            IJigyohokokuCompYoshiki2021Builder builder = new JigyohokokuCompYoshiki2021Builder(headEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

    private List<JigyohokokuCompResultEntity> get縦番号1(RString 縦番号, RString 横番号, RString 集計区分) {
        if (一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_1, 集計区分);
        } else if (二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_2, 集計区分);
        } else if (三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_3, 集計区分);
        } else if (四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_4, 集計区分);
        } else if (五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_5, 集計区分);
        } else if (六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_6, 集計区分);
        } else if (七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_7, 集計区分);
        } else if (八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_8, 集計区分);
        } else if (九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_9, 集計区分);
        } else if (十行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_10, 集計区分);
        } else if (十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_11, 集計区分);
        } else if (十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_12, 集計区分);
        } else if (十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_13, 集計区分);
        } else if (十四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_14, 集計区分);
        } else if (十五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_15, 集計区分);
        } else if (十六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_16, 集計区分);
        } else if (十七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_17, 集計区分);
        } else if (十八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_18, 集計区分);
        }
        list = get縦番号2(縦番号, 横番号, 集計区分);
        return list;
    }

    private List<JigyohokokuCompResultEntity> get縦番号2(RString 縦番号, RString 横番号, RString 集計区分) {
        if (十九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_19, 集計区分);
        } else if (二十行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_20, 集計区分);
        } else if (二十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_21, 集計区分);
        } else if (二十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_22, 集計区分);
        } else if (二十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_23, 集計区分);
        } else if (二十四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_24, 集計区分);
        } else if (二十五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_25, 集計区分);
        } else if (二十六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_26, 集計区分);
        } else if (二十七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_27, 集計区分);
        } else if (二十八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_28, 集計区分);
        } else if (二十九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_29, 集計区分);
        } else if (三十行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_30, 集計区分);
        } else if (三十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_31, 集計区分);
        } else if (三十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_32, 集計区分);
        } else if (三十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_33, 集計区分);
        }
        return list;
    }

    private List<JigyohokokuCompResultEntity> get横番号(RString 横番号, int index, RString 集計区分) {
        JigyohokokuCompResultEntity entity = list.get(index);
        if (IchijiHanteiKekkaCode06.要支援1.getコード().equals(横番号)) {
            entity.set要支援１(get合計(集計区分));
        } else if (IchijiHanteiKekkaCode06.要支援2.getコード().equals(横番号)) {
            entity.set要支援２(get合計(集計区分));
        } else if (IchijiHanteiKekkaCode06.非該当.getコード().equals(横番号)) {
            entity.set非該当(get合計(集計区分));
        } else if (IchijiHanteiKekkaCode06.経過的要介護.getコード().equals(横番号)) {
            entity.set経過的要介護(get合計(集計区分));
        } else if (IchijiHanteiKekkaCode06.要介護1.getコード().equals(横番号)) {
            entity.set要介護１(get合計(集計区分));
        } else if (IchijiHanteiKekkaCode06.要介護2.getコード().equals(横番号)) {
            entity.set要介護２(get合計(集計区分));
        } else if (IchijiHanteiKekkaCode06.要介護3.getコード().equals(横番号)) {
            entity.set要介護３(get合計(集計区分));
        } else if (IchijiHanteiKekkaCode06.要介護4.getコード().equals(横番号)) {
            entity.set要介護４(get合計(集計区分));
        } else if (IchijiHanteiKekkaCode06.要介護5.getコード().equals(横番号)) {
            entity.set要介護５(get合計(集計区分));
        }
        entity.set計１(entity.get要支援１() + entity.get要支援２());
        entity.set計２(entity.get非該当() + entity.get経過的要介護() + entity.get要介護１() + entity.get要介護２()
                + entity.get要介護３() + entity.get要介護４() + entity.get要介護５());
        entity.set合計(entity.get計１() + entity.get計２());
        return list;
    }

    private boolean isValueChanged(RString 縦番号, RString 横番号) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(縦番号).append(RString.HALF_SPACE).append(横番号);
        new縦横番号 = builder.toRString();
        if (RString.isNullOrEmpty(old縦横番号) || old縦横番号.equals(new縦横番号)) {
            old縦横番号 = new縦横番号;
            return false;
        } else {
            old縦横番号 = new縦横番号;
            return true;
        }
    }

    private void cleanValue() {
        合計 = 0;
        加算単位数合計 = 0;
        減算単位数合計 = 0;
    }

    private int get合計(RString 集計区分) {
        if (集計区分_加算.equals(集計区分)) {
            加算単位数合計 = 加算単位数合計 + 1;
        } else if (集計区分_減算.equals(集計区分)) {
            減算単位数合計 = 減算単位数合計 + 1;
        }
        合計 = 加算単位数合計 - 減算単位数合計;
        return 合計;
    }
}
