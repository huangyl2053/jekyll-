/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki251;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki251.JigyohokokuCompYoshiki251ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業報告複合様式_05のReportクラスです。
 *
 * @reamsid_L DBU-5560-060 wanghuafeng
 */
public class JigyohokokuCompYoshiki251Report extends Report<JigyohokokuCompYoshiki251ReportSource> {

    private static final RString 集計区分_加算 = new RString("1");
    private static final RString 集計区分_減算 = new RString("2");
    private static final RString 一行目 = new RString("01");
    private static final RString 二行目 = new RString("04");
    private static final RString 三行目 = new RString("05");
    private static final RString 四行目 = new RString("06");
    private static final RString 五行目 = new RString("16");
    private static final RString 六行目 = new RString("07");
    private static final RString 七行目 = new RString("08");
    private static final RString 八行目 = new RString("09");
    private static final RString 九行目 = new RString("02");
    private static final RString 十行目 = new RString("10");
    private static final RString 十一行目 = new RString("11");
    private static final RString 十二行目 = new RString("12");
    private static final RString 十三行目 = new RString("17");
    private static final RString 十四行目 = new RString("13");
    private static final RString 十五行目 = new RString("14");
    private static final RString 十六行目 = new RString("15");
    private static final RString 十七行目 = new RString("03");
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
    private final JigyohokokuCompYoshiki201Business business;
    private List<JigyohokokuCompResultEntity> list;
    private int 件数合計 = 0;
    private int 請求額合計 = 0;
    private int 加算件数合計 = 0;
    private int 減算件数合計 = 0;
    private int 加算請求額合計 = 0;
    private int 減算請求額合計 = 0;
    private RString new縦横番号;
    private RString old縦横番号;

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
        old縦横番号 = RString.EMPTY;

    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki251ReportSource> writer) {
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
            list = get縦番号(entity.get縦番号(), entity.get横番号(), entity.get集計区分(),
                    entity.get後_保険請求分請求額());
            集計番号 = entity.get集計番号();
            給付実績区分コード = entity.get給付実績区分コード();
        }
        for (JigyohokokuCompResultEntity entity : list) {
            IJigyohokokuCompYoshiki251Editor headEditor = new JigyohokokuCompYoshiki251HeadEditor(
                    集計番号, 給付実績区分コード, business);
            IJigyohokokuCompYoshiki251Editor bodyEditor = new JigyohokokuCompYoshiki251BodyEditor(entity);
            IJigyohokokuCompYoshiki251Builder builder = new JigyohokokuCompYoshiki251Builder(headEditor, bodyEditor);
            writer.writeLine(builder);
        }

    }

    private List<JigyohokokuCompResultEntity> get縦番号(RString 縦番号, RString 横番号, RString 集計区分, int 請求額) {
        if (一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_1, 集計区分, 請求額);
        } else if (二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_2, 集計区分, 請求額);
        } else if (三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_3, 集計区分, 請求額);
        } else if (四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_4, 集計区分, 請求額);
        } else if (五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_5, 集計区分, 請求額);
        } else if (六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_6, 集計区分, 請求額);
        } else if (七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_7, 集計区分, 請求額);
        } else if (八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_8, 集計区分, 請求額);
        } else if (九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_9, 集計区分, 請求額);
        } else if (十行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_10, 集計区分, 請求額);
        } else if (十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_11, 集計区分, 請求額);
        } else if (十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_12, 集計区分, 請求額);
        } else if (十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_13, 集計区分, 請求額);
        } else if (十四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_14, 集計区分, 請求額);
        } else if (十五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_15, 集計区分, 請求額);
        } else if (十六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_16, 集計区分, 請求額);
        } else if (十七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_17, 集計区分, 請求額);
        }
        return list;
    }

    private List<JigyohokokuCompResultEntity> get横番号(RString 横番号, int index, RString 集計区分, int 請求額) {
        JigyohokokuCompResultEntity entity = list.get(index);
        if (IchijiHanteiKekkaCode06.要支援1.getコード().equals(横番号)) {
            entity.set要支援１(get件数合計(集計区分));
            entity.set要支援１＿１(get請求額合計(集計区分, 請求額));
        } else if (IchijiHanteiKekkaCode06.要支援2.getコード().equals(横番号)) {
            entity.set要支援２(get件数合計(集計区分));
            entity.set要支援２＿１(get請求額合計(集計区分, 請求額));
        } else if (IchijiHanteiKekkaCode06.経過的要介護.getコード().equals(横番号)) {
            entity.set経過的要介護(get件数合計(集計区分));
            entity.set経過的要介護＿１(get請求額合計(集計区分, 請求額));
        } else if (IchijiHanteiKekkaCode06.要介護1.getコード().equals(横番号)) {
            entity.set要介護１(get件数合計(集計区分));
            entity.set要介護１＿１(get請求額合計(集計区分, 請求額));
        } else if (IchijiHanteiKekkaCode06.要介護2.getコード().equals(横番号)) {
            entity.set要介護２(get件数合計(集計区分));
            entity.set要介護２＿１(get請求額合計(集計区分, 請求額));
        } else if (IchijiHanteiKekkaCode06.要介護3.getコード().equals(横番号)) {
            entity.set要介護３(get件数合計(集計区分));
            entity.set要介護３＿１(get請求額合計(集計区分, 請求額));
        } else if (IchijiHanteiKekkaCode06.要介護4.getコード().equals(横番号)) {
            entity.set要介護４(get件数合計(集計区分));
            entity.set要介護４＿１(get請求額合計(集計区分, 請求額));
        } else if (IchijiHanteiKekkaCode06.要介護5.getコード().equals(横番号)) {
            entity.set要介護５(get件数合計(集計区分));
            entity.set要介護５＿１(get請求額合計(集計区分, 請求額));
        }
        entity.set計１(entity.get要支援１() + entity.get要支援２());
        entity.set計２(entity.get経過的要介護() + entity.get要介護１() + entity.get要介護２()
                + entity.get要介護３() + entity.get要介護４() + entity.get要介護５());
        entity.set合計(entity.get計１() + entity.get計２());
        entity.set計１＿１(entity.get要支援１＿１() + entity.get要支援２＿１());
        entity.set計２＿１(entity.get経過的要介護＿１() + entity.get要介護１＿１() + entity.get要介護２＿１()
                + entity.get要介護３＿１() + entity.get要介護４＿１() + entity.get要介護５＿１());
        entity.set合計＿１(entity.get計１＿１() + entity.get計２＿１());
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
        件数合計 = 0;
        請求額合計 = 0;
        加算件数合計 = 0;
        減算件数合計 = 0;
        加算請求額合計 = 0;
        減算請求額合計 = 0;
    }

    private int get件数合計(RString 集計区分) {
        if (集計区分_加算.equals(集計区分)) {
            加算件数合計 = 加算件数合計 + 1;
        } else if (集計区分_減算.equals(集計区分)) {
            減算件数合計 = 減算件数合計 + 1;
        }
        件数合計 = 加算件数合計 - 減算件数合計;
        return 件数合計;
    }

    private int get請求額合計(RString 集計区分, int 請求額) {
        if (集計区分_加算.equals(集計区分)) {
            加算請求額合計 = 加算請求額合計 + 請求額;
        } else if (集計区分_減算.equals(集計区分)) {
            減算請求額合計 = 減算請求額合計 + 請求額;
        }
        請求額合計 = 加算請求額合計 - 減算請求額合計;
        return 請求額合計;
    }

}
