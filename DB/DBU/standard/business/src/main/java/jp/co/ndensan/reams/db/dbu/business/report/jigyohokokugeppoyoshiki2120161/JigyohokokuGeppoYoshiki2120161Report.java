/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki2120161;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki2120161.JigyohokokuGeppoYoshiki2120161ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
    private static final RString 十七行目 = new RString("17");
    private static final RString 十八行目 = new RString("18");
    private static final RString 十九行目 = new RString("28");
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
    private static final RString 集計区分_加算 = new RString("1");
    private static final RString 集計区分_減算 = new RString("2");
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
    private List<JigyohokokuCompResultEntity> list;
    private int 合計 = 0;
    private int 加算件数合計 = 0;
    private int 減算件数合計 = 0;
    private int 加算請求額合計 = 0;
    private int 減算請求額合計 = 0;
    private int 加算集計支給金額合計 = 0;
    private int 減算集計支給金額合計 = 0;
    private RString new縦横番号;
    private RString old縦横番号;

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
        old縦横番号 = RString.EMPTY;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuGeppoYoshiki2120161ReportSource> reportSourceWriter) {
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
            list = get縦番号1(entity.get縦番号(), entity.get横番号(),
                    getTitleThree(entity.get集計番号()), entity.get集計区分(), entity.get請求額(), entity.get集計支給金額());
            集計番号 = entity.get集計番号();
            給付実績区分コード = entity.get給付実績区分コード();
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

    private int get合計(RString title3, RString 集計区分, int 請求額, int 集計支給金額) {
        if (ア内容.equals(title3)) {
            if (集計区分_加算.equals(集計区分)) {
                加算件数合計 = 加算件数合計 + 1;
            } else if (集計区分_減算.equals(集計区分)) {
                減算件数合計 = 減算件数合計 + 1;
            }
            合計 = 加算件数合計 - 減算件数合計;
        } else if (ウ内容.equals(title3)) {
            if (集計区分_加算.equals(集計区分)) {
                加算請求額合計 = 加算請求額合計 + 請求額;
            } else if (集計区分_減算.equals(集計区分)) {
                減算請求額合計 = 減算請求額合計 + 請求額;
            }
            合計 = 加算請求額合計 - 減算請求額合計;
        } else if (エ内容.equals(title3)) {
            if (集計区分_加算.equals(集計区分)) {
                加算集計支給金額合計 = 加算集計支給金額合計 + 集計支給金額;
            } else if (集計区分_減算.equals(集計区分)) {
                減算集計支給金額合計 = 減算集計支給金額合計 + 集計支給金額;
            }
            合計 = 加算集計支給金額合計 - 減算集計支給金額合計;
        }
        return 合計;
    }

    private List<JigyohokokuCompResultEntity> get横番号(RString 横番号, int index,
            RString title3, RString 集計区分, int 請求額, int 集計支給金額) {
        JigyohokokuCompResultEntity entity = list.get(index);
        if (IchijiHanteiKekkaCode06.要支援1.getコード().equals(横番号)) {
            entity.set要支援１(get合計(title3, 集計区分, 請求額, 集計支給金額));
        } else if (IchijiHanteiKekkaCode06.要支援2.getコード().equals(横番号)) {
            entity.set要支援２(get合計(title3, 集計区分, 請求額, 集計支給金額));
        } else if (IchijiHanteiKekkaCode06.非該当.getコード().equals(横番号)) {
            entity.set非該当(get合計(title3, 集計区分, 請求額, 集計支給金額));
        } else if (IchijiHanteiKekkaCode06.経過的要介護.getコード().equals(横番号)) {
            entity.set経過的要介護(get合計(title3, 集計区分, 請求額, 集計支給金額));
        } else if (IchijiHanteiKekkaCode06.要介護1.getコード().equals(横番号)) {
            entity.set要介護１(get合計(title3, 集計区分, 請求額, 集計支給金額));
        } else if (IchijiHanteiKekkaCode06.要介護2.getコード().equals(横番号)) {
            entity.set要介護２(get合計(title3, 集計区分, 請求額, 集計支給金額));
        } else if (IchijiHanteiKekkaCode06.要介護3.getコード().equals(横番号)) {
            entity.set要介護３(get合計(title3, 集計区分, 請求額, 集計支給金額));
        } else if (IchijiHanteiKekkaCode06.要介護4.getコード().equals(横番号)) {
            entity.set要介護４(get合計(title3, 集計区分, 請求額, 集計支給金額));
        } else if (IchijiHanteiKekkaCode06.要介護5.getコード().equals(横番号)) {
            entity.set要介護５(get合計(title3, 集計区分, 請求額, 集計支給金額));
        }
        entity.set計１(entity.get要支援１() + entity.get要支援２());
        entity.set計２(entity.get非該当() + entity.get経過的要介護() + entity.get要介護１() + entity.get要介護２()
                + entity.get要介護３() + entity.get要介護４() + entity.get要介護５());
        entity.set合計(entity.get計１() + entity.get計２());
        return list;
    }

    private List<JigyohokokuCompResultEntity> get縦番号1(RString 縦番号, RString 横番号,
            RString title3, RString 集計区分, int 請求額, int 集計支給金額) {
        if (一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_1, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_2, title3, 集計区分, 請求額, 集計支給金額);
        } else if (三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_3, title3, 集計区分, 請求額, 集計支給金額);
        } else if (四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_4, title3, 集計区分, 請求額, 集計支給金額);
        } else if (五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_5, title3, 集計区分, 請求額, 集計支給金額);
        } else if (六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_6, title3, 集計区分, 請求額, 集計支給金額);
        } else if (七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_7, title3, 集計区分, 請求額, 集計支給金額);
        } else if (八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_8, title3, 集計区分, 請求額, 集計支給金額);
        } else if (九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_9, title3, 集計区分, 請求額, 集計支給金額);
        } else if (十行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_10, title3, 集計区分, 請求額, 集計支給金額);
        } else if (十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_11, title3, 集計区分, 請求額, 集計支給金額);
        } else if (十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_12, title3, 集計区分, 請求額, 集計支給金額);
        } else if (十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_13, title3, 集計区分, 請求額, 集計支給金額);
        } else if (十四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_14, title3, 集計区分, 請求額, 集計支給金額);
        } else if (十五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_15, title3, 集計区分, 請求額, 集計支給金額);
        } else if (十六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_16, title3, 集計区分, 請求額, 集計支給金額);
        } else if (十七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_17, title3, 集計区分, 請求額, 集計支給金額);
        } else if (十八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_18, title3, 集計区分, 請求額, 集計支給金額);
        }
        list = get縦番号2(縦番号, 横番号, title3, 集計区分, 請求額, 集計支給金額);
        return list;
    }

    private List<JigyohokokuCompResultEntity> get縦番号2(RString 縦番号, RString 横番号,
            RString title3, RString 集計区分, int 請求額, int 集計支給金額) {
        if (十九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_19, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_21, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_22, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_23, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二十四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_24, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二十五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_25, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二十六行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_26, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二十七行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_27, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二十八行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_28, title3, 集計区分, 請求額, 集計支給金額);
        } else if (二十九行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_29, title3, 集計区分, 請求額, 集計支給金額);
        } else if (三十行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_30, title3, 集計区分, 請求額, 集計支給金額);
        } else if (三十一行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_31, title3, 集計区分, 請求額, 集計支給金額);
        } else if (三十二行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_32, title3, 集計区分, 請求額, 集計支給金額);
        } else if (三十三行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_33, title3, 集計区分, 請求額, 集計支給金額);
        } else if (三十四行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_34, title3, 集計区分, 請求額, 集計支給金額);
        } else if (三十五行目.equals(縦番号)) {
            list = get横番号(横番号, INDEX_35, title3, 集計区分, 請求額, 集計支給金額);
        }
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
        加算件数合計 = 0;
        減算件数合計 = 0;
        加算請求額合計 = 0;
        減算請求額合計 = 0;
        加算集計支給金額合計 = 0;
        減算集計支給金額合計 = 0;
    }

}
