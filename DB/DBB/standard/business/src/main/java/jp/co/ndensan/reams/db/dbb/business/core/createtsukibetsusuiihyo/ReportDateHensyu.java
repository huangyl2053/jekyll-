/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.createtsukibetsusuiihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GemmenJyoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.KoumokuGoukey;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.ReportDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票用データEntity編集クラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class ReportDateHensyu {

    private static final Decimal ZERO = new Decimal(0);
    private static final int LENGTH_40 = 40;
    private static final int LENGTH_19 = 19;
    private static final RString 合計 = new RString("合計");
    private static final RString 不明 = new RString("不明");

    /**
     * コンストラクタ。
     */
    public ReportDateHensyu() {
    }

    /**
     *
     * @param list List<KoumokuGoukey>
     * @return List<ReportDate>
     */
    public List<ReportDate> getReportDateList(List<KoumokuGoukey> list) {
        List<ReportDate> reportDateList = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            return reportDateList;
        }
        for (KoumokuGoukey koumokuGoukey : list) {
            if (!合計.equals(koumokuGoukey.getHokenryoDankai()) && !不明.equals(koumokuGoukey.getHokenryoDankai())) {
                ReportDate reportDate = new ReportDate();
                reportDate.setListTitle_1(koumokuGoukey.getHokenryoDankai());
                reportDate.setList_1(getNinsuuOrKinkaku(koumokuGoukey.getYoGetuNinsuuGoukeyi()));
                reportDate.setList_2(getNinsuuOrKinkaku(koumokuGoukey.getGoGetuNinsuuGoukeyi()));
                reportDate.setList_3(getNinsuuOrKinkaku(koumokuGoukey.getRokuGetuNinsuuGoukeyi()));
                reportDate.setList_4(getNinsuuOrKinkaku(koumokuGoukey.getNanaGetuNinsuuGoukeyi()));
                reportDate.setList_5(getNinsuuOrKinkaku(koumokuGoukey.getHatiGetuNinsuuGoukeyi()));
                reportDate.setList_6(getNinsuuOrKinkaku(koumokuGoukey.getKyuGetuNinsuuGoukeyi()));
                reportDate.setList_7(getNinsuuOrKinkaku(koumokuGoukey.getJyuGetuNinsuuGoukeyi()));
                reportDate.setList_8(getNinsuuOrKinkaku(koumokuGoukey.getJyuitiGetuNinsuuGoukeyi()));
                reportDate.setList_9(getNinsuuOrKinkaku(koumokuGoukey.getJyuniGetuNinsuuGoukeyi()));
                reportDate.setList_10(getNinsuuOrKinkaku(koumokuGoukey.getItiGetuNinsuuGoukeyi()));
                reportDate.setList_11(getNinsuuOrKinkaku(koumokuGoukey.getNiGetuNinsuuGoukeyi()));
                reportDate.setList_12(getNinsuuOrKinkaku(koumokuGoukey.getSanGetuNinsuuGoukeyi()));
                reportDate.setList_13(getNinsuuOrKinkaku(koumokuGoukey.get現年随時の人数合計()));
                reportDate.setList_14(getNinsuuOrKinkaku(koumokuGoukey.get過年度の人数合計()));
                reportDate.setList_15(getNinsuuOrKinkaku(koumokuGoukey.get該当段階の人数合計()));
                reportDate.setList_16(getNinsuuOrKinkaku(koumokuGoukey.get歳出還付の人数合計()));
                reportDateList.add(reportDate);
            }
        }
        int length = reportDateList.size();
        for (int i = 0; i < LENGTH_19; i++) {
            if (i >= length) {
                reportDateList.add(getReportDate());
            }
        }
        ReportDate reportDate1 = getReportDate();
        for (int i = 0; i < list.size(); i++) {
            if (不明.equals(list.get(i).getHokenryoDankai())) {
                reportDate1.setListTitle_1(list.get(i).getHokenryoDankai());
                reportDate1.setList_1(getNinsuuOrKinkaku(list.get(i).getYoGetuNinsuuGoukeyi()));
                reportDate1.setList_2(getNinsuuOrKinkaku(list.get(i).getGoGetuNinsuuGoukeyi()));
                reportDate1.setList_3(getNinsuuOrKinkaku(list.get(i).getRokuGetuNinsuuGoukeyi()));
                reportDate1.setList_4(getNinsuuOrKinkaku(list.get(i).getNanaGetuNinsuuGoukeyi()));
                reportDate1.setList_5(getNinsuuOrKinkaku(list.get(i).getHatiGetuNinsuuGoukeyi()));
                reportDate1.setList_6(getNinsuuOrKinkaku(list.get(i).getKyuGetuNinsuuGoukeyi()));
                reportDate1.setList_7(getNinsuuOrKinkaku(list.get(i).getJyuGetuNinsuuGoukeyi()));
                reportDate1.setList_8(getNinsuuOrKinkaku(list.get(i).getJyuitiGetuNinsuuGoukeyi()));
                reportDate1.setList_9(getNinsuuOrKinkaku(list.get(i).getJyuniGetuNinsuuGoukeyi()));
                reportDate1.setList_10(getNinsuuOrKinkaku(list.get(i).getItiGetuNinsuuGoukeyi()));
                reportDate1.setList_11(getNinsuuOrKinkaku(list.get(i).getNiGetuNinsuuGoukeyi()));
                reportDate1.setList_12(getNinsuuOrKinkaku(list.get(i).getSanGetuNinsuuGoukeyi()));
                reportDate1.setList_13(getNinsuuOrKinkaku(list.get(i).get現年随時の人数合計()));
                reportDate1.setList_14(getNinsuuOrKinkaku(list.get(i).get過年度の人数合計()));
                reportDate1.setList_15(getNinsuuOrKinkaku(list.get(i).get該当段階の人数合計()));
                reportDate1.setList_16(getNinsuuOrKinkaku(list.get(i).get歳出還付の人数合計()));
                break;
            }
        }
        reportDateList.add(reportDate1);
        ReportDate reportDate2 = getReportDate();
        for (int i = 0; i < list.size(); i++) {
            if (合計.equals(list.get(i).getHokenryoDankai())) {
                reportDate2.setListTitle_1(list.get(i).getHokenryoDankai());
                reportDate2.setList_1(getNinsuuOrKinkaku(list.get(i).getYoGetuNinsuuGoukeyi()));
                reportDate2.setList_2(getNinsuuOrKinkaku(list.get(i).getGoGetuNinsuuGoukeyi()));
                reportDate2.setList_3(getNinsuuOrKinkaku(list.get(i).getRokuGetuNinsuuGoukeyi()));
                reportDate2.setList_4(getNinsuuOrKinkaku(list.get(i).getNanaGetuNinsuuGoukeyi()));
                reportDate2.setList_5(getNinsuuOrKinkaku(list.get(i).getHatiGetuNinsuuGoukeyi()));
                reportDate2.setList_6(getNinsuuOrKinkaku(list.get(i).getKyuGetuNinsuuGoukeyi()));
                reportDate2.setList_7(getNinsuuOrKinkaku(list.get(i).getJyuGetuNinsuuGoukeyi()));
                reportDate2.setList_8(getNinsuuOrKinkaku(list.get(i).getJyuitiGetuNinsuuGoukeyi()));
                reportDate2.setList_9(getNinsuuOrKinkaku(list.get(i).getJyuniGetuNinsuuGoukeyi()));
                reportDate2.setList_10(getNinsuuOrKinkaku(list.get(i).getItiGetuNinsuuGoukeyi()));
                reportDate2.setList_11(getNinsuuOrKinkaku(list.get(i).getNiGetuNinsuuGoukeyi()));
                reportDate2.setList_12(getNinsuuOrKinkaku(list.get(i).getSanGetuNinsuuGoukeyi()));
                reportDate2.setList_13(getNinsuuOrKinkaku(list.get(i).get現年随時の人数合計()));
                reportDate2.setList_14(getNinsuuOrKinkaku(list.get(i).get過年度の人数合計()));
                reportDate2.setList_15(getNinsuuOrKinkaku(list.get(i).get該当段階の人数合計()));
                reportDate2.setList_16(getNinsuuOrKinkaku(list.get(i).get歳出還付の人数合計()));
                break;
            }
        }
        reportDateList.add(reportDate2);
        return getReportDateKinkaku(reportDateList, list);
    }

    /**
     *
     * @param list List<GemmenJyoho>
     * @return List<ReportDate>
     */
    public List<ReportDate> getReportGemmenDateList(List<GemmenJyoho> list) {
        List<ReportDate> reportDateList = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            return reportDateList;
        }
        for (GemmenJyoho gemmenJyoho : list) {
            if (!合計.equals(gemmenJyoho.getHokenryoDankai()) && !不明.equals(gemmenJyoho.getHokenryoDankai())) {
                ReportDate reportDate = new ReportDate();
                reportDate.setListTitle_1(gemmenJyoho.getHokenryoDankai());
                reportDate.setList_1(RString.EMPTY);
                reportDate.setList_2(RString.EMPTY);
                reportDate.setList_3(RString.EMPTY);
                reportDate.setList_4(RString.EMPTY);
                reportDate.setList_5(RString.EMPTY);
                reportDate.setList_6(RString.EMPTY);
                reportDate.setList_7(RString.EMPTY);
                reportDate.setList_8(RString.EMPTY);
                reportDate.setList_9(RString.EMPTY);
                reportDate.setList_10(RString.EMPTY);
                reportDate.setList_11(RString.EMPTY);
                reportDate.setList_12(RString.EMPTY);
                reportDate.setList_13(RString.EMPTY);
                reportDate.setList_14(getNinsuuOrKinkaku(gemmenJyoho.getHokenryoDankaiKanendoNinsu()));
                reportDate.setList_15(getNinsuuOrKinkaku(gemmenJyoho.getHoDankaiKanendoNinsuGoukeyi()));
                reportDate.setList_16(RString.EMPTY);
                reportDateList.add(reportDate);
            }
        }
        int length = reportDateList.size();
        for (int i = 0; i < LENGTH_19; i++) {
            if (i >= length) {
                reportDateList.add(getReportDate());
            }
        }
        ReportDate reportDate1 = getReportDate();
        for (int i = 0; i < list.size(); i++) {
            if (不明.equals(list.get(i).getHokenryoDankai())) {
                reportDate1.setListTitle_1(list.get(i).getHokenryoDankai());
                reportDate1.setList_14(getNinsuuOrKinkaku(list.get(i).getHokenryoDankaiKanendoNinsu()));
                reportDate1.setList_15(getNinsuuOrKinkaku(list.get(i).getHoDankaiKanendoNinsuGoukeyi()));
                break;
            }
        }
        reportDateList.add(reportDate1);
        ReportDate reportDate2 = getReportDate();
        for (int i = 0; i < list.size(); i++) {
            if (合計.equals(list.get(i).getHokenryoDankai())) {
                reportDate2.setListTitle_1(list.get(i).getHokenryoDankai());
                reportDate2.setList_14(getNinsuuOrKinkaku(list.get(i).getHokenryoDankaiKanendoNinsu()));
                reportDate2.setList_15(getNinsuuOrKinkaku(list.get(i).getHoDankaiKanendoNinsuGoukeyi()));
                break;
            }
        }
        reportDateList.add(reportDate2);
        return getReportGemmenDateKinkaku(reportDateList, list);
    }

    private List<ReportDate> getReportGemmenDateKinkaku(List<ReportDate> reportDateList, List<GemmenJyoho> list) {
        for (GemmenJyoho gemmenJyoho : list) {
            if (!合計.equals(gemmenJyoho.getHokenryoDankai()) && !不明.equals(gemmenJyoho.getHokenryoDankai())) {
                ReportDate reportDate = new ReportDate();
                reportDate.setListTitle_1(gemmenJyoho.getHokenryoDankai());
                reportDate.setList_1(RString.EMPTY);
                reportDate.setList_2(RString.EMPTY);
                reportDate.setList_3(RString.EMPTY);
                reportDate.setList_4(RString.EMPTY);
                reportDate.setList_5(RString.EMPTY);
                reportDate.setList_6(RString.EMPTY);
                reportDate.setList_7(RString.EMPTY);
                reportDate.setList_8(RString.EMPTY);
                reportDate.setList_9(RString.EMPTY);
                reportDate.setList_10(RString.EMPTY);
                reportDate.setList_11(RString.EMPTY);
                reportDate.setList_12(RString.EMPTY);
                reportDate.setList_13(RString.EMPTY);
                reportDate.setList_14(getNinsuuOrKinkaku(gemmenJyoho.getHoDankaiKanendoGemmenGaku()));
                reportDate.setList_15(getNinsuuOrKinkaku(gemmenJyoho.getHoDankaiKanendoGemenGakuGoukei()));
                reportDate.setList_16(RString.EMPTY);
                reportDateList.add(reportDate);
            }
        }
        int length = reportDateList.size();
        for (int i = 0; i < LENGTH_40; i++) {
            if (i >= length) {
                reportDateList.add(getReportDate());
            }
        }
        ReportDate reportDate1 = getReportDate();
        for (int i = 0; i < list.size(); i++) {
            if (不明.equals(list.get(i).getHokenryoDankai())) {
                reportDate1.setListTitle_1(list.get(i).getHokenryoDankai());
                reportDate1.setList_14(getNinsuuOrKinkaku(list.get(i).getHoDankaiKanendoGemmenGaku()));
                reportDate1.setList_15(getNinsuuOrKinkaku(list.get(i).getHoDankaiKanendoGemenGakuGoukei()));
                reportDateList.add(reportDate1);
                break;
            }
        }
        reportDateList.add(reportDate1);
        ReportDate reportDate2 = getReportDate();
        for (int i = 0; i < list.size(); i++) {
            if (合計.equals(list.get(i).getHokenryoDankai())) {
                reportDate2.setListTitle_1(list.get(i).getHokenryoDankai());
                reportDate2.setList_14(getNinsuuOrKinkaku(list.get(i).getHoDankaiKanendoGemmenGaku()));
                reportDate2.setList_15(getNinsuuOrKinkaku(list.get(i).getHoDankaiKanendoGemenGakuGoukei()));
                break;
            }
        }
        reportDateList.add(reportDate2);
        return reportDateList;
    }

    private RString getNinsuuOrKinkaku(Decimal temp) {
        if (temp == null || temp.compareTo(ZERO) == 0) {
            return RString.EMPTY;
        }
        return new RString(temp.toString());
    }

    private ReportDate getReportDate() {
        ReportDate reportDate = new ReportDate();
        reportDate.setListTitle_1(RString.EMPTY);
        reportDate.setList_1(RString.EMPTY);
        reportDate.setList_2(RString.EMPTY);
        reportDate.setList_3(RString.EMPTY);
        reportDate.setList_4(RString.EMPTY);
        reportDate.setList_5(RString.EMPTY);
        reportDate.setList_6(RString.EMPTY);
        reportDate.setList_7(RString.EMPTY);
        reportDate.setList_8(RString.EMPTY);
        reportDate.setList_9(RString.EMPTY);
        reportDate.setList_10(RString.EMPTY);
        reportDate.setList_11(RString.EMPTY);
        reportDate.setList_12(RString.EMPTY);
        reportDate.setList_13(RString.EMPTY);
        reportDate.setList_14(RString.EMPTY);
        reportDate.setList_15(RString.EMPTY);
        reportDate.setList_16(RString.EMPTY);
        return reportDate;
    }

    private List<ReportDate> getReportDateKinkaku(List<ReportDate> reportDateList, List<KoumokuGoukey> list) {
        for (KoumokuGoukey koumokuGoukey : list) {
            if (!合計.equals(koumokuGoukey.getHokenryoDankai()) && !不明.equals(koumokuGoukey.getHokenryoDankai())) {
                ReportDate reportDate = new ReportDate();
                reportDate.setListTitle_1(koumokuGoukey.getHokenryoDankai());
                reportDate.setList_1(getNinsuuOrKinkaku(koumokuGoukey.getYoGetuKinkakuGoukeyi()));
                reportDate.setList_2(getNinsuuOrKinkaku(koumokuGoukey.getGoGetuKinkakuGoukeyi()));
                reportDate.setList_3(getNinsuuOrKinkaku(koumokuGoukey.getRokuGetuKinkakuGoukeyi()));
                reportDate.setList_4(getNinsuuOrKinkaku(koumokuGoukey.getNanaGetuKinkakuGoukeyi()));
                reportDate.setList_5(getNinsuuOrKinkaku(koumokuGoukey.getHatiGetuKinkakuGoukeyi()));
                reportDate.setList_6(getNinsuuOrKinkaku(koumokuGoukey.getKyuGetuKinkakuGoukeyi()));
                reportDate.setList_7(getNinsuuOrKinkaku(koumokuGoukey.getJyuGetuKinkakuGoukeyi()));
                reportDate.setList_8(getNinsuuOrKinkaku(koumokuGoukey.getJyuitiGetuKinkakuGoukeyi()));
                reportDate.setList_9(getNinsuuOrKinkaku(koumokuGoukey.getJyuniGetuKinkakuGoukeyi()));
                reportDate.setList_10(getNinsuuOrKinkaku(koumokuGoukey.getItiGetuKinkakuGoukeyi()));
                reportDate.setList_11(getNinsuuOrKinkaku(koumokuGoukey.getNiGetuKinkakuGoukeyi()));
                reportDate.setList_12(getNinsuuOrKinkaku(koumokuGoukey.getSanGetuKinkakuGoukeyi()));
                reportDate.setList_13(getNinsuuOrKinkaku(koumokuGoukey.get現年随時の金額合計()));
                reportDate.setList_14(getNinsuuOrKinkaku(koumokuGoukey.get過年度の金額合計()));
                reportDate.setList_15(getNinsuuOrKinkaku(koumokuGoukey.get該当段階の金額合計()));
                reportDate.setList_16(getNinsuuOrKinkaku(koumokuGoukey.get歳出還付の金額合計()));
                reportDateList.add(reportDate);
            }
        }
        int length = reportDateList.size();
        for (int i = 0; i < LENGTH_40; i++) {
            if (i >= length) {
                reportDateList.add(getReportDate());
            }
        }
        ReportDate reportDate1 = getReportDate();
        for (int i = 0; i < list.size(); i++) {
            if (不明.equals(list.get(i).getHokenryoDankai())) {
                reportDate1.setListTitle_1(list.get(i).getHokenryoDankai());
                reportDate1.setList_1(getNinsuuOrKinkaku(list.get(i).getYoGetuKinkakuGoukeyi()));
                reportDate1.setList_2(getNinsuuOrKinkaku(list.get(i).getGoGetuKinkakuGoukeyi()));
                reportDate1.setList_3(getNinsuuOrKinkaku(list.get(i).getRokuGetuKinkakuGoukeyi()));
                reportDate1.setList_4(getNinsuuOrKinkaku(list.get(i).getNanaGetuKinkakuGoukeyi()));
                reportDate1.setList_5(getNinsuuOrKinkaku(list.get(i).getHatiGetuKinkakuGoukeyi()));
                reportDate1.setList_6(getNinsuuOrKinkaku(list.get(i).getKyuGetuKinkakuGoukeyi()));
                reportDate1.setList_7(getNinsuuOrKinkaku(list.get(i).getJyuGetuKinkakuGoukeyi()));
                reportDate1.setList_8(getNinsuuOrKinkaku(list.get(i).getJyuitiGetuKinkakuGoukeyi()));
                reportDate1.setList_9(getNinsuuOrKinkaku(list.get(i).getJyuniGetuKinkakuGoukeyi()));
                reportDate1.setList_10(getNinsuuOrKinkaku(list.get(i).getItiGetuKinkakuGoukeyi()));
                reportDate1.setList_11(getNinsuuOrKinkaku(list.get(i).getNiGetuKinkakuGoukeyi()));
                reportDate1.setList_12(getNinsuuOrKinkaku(list.get(i).getSanGetuKinkakuGoukeyi()));
                reportDate1.setList_13(getNinsuuOrKinkaku(list.get(i).get現年随時の金額合計()));
                reportDate1.setList_14(getNinsuuOrKinkaku(list.get(i).get過年度の金額合計()));
                reportDate1.setList_15(getNinsuuOrKinkaku(list.get(i).get該当段階の金額合計()));
                reportDate1.setList_16(getNinsuuOrKinkaku(list.get(i).get歳出還付の金額合計()));
                break;
            }
        }
        reportDateList.add(reportDate1);
        ReportDate reportDate2 = getReportDate();
        for (int i = 0; i < list.size(); i++) {
            if (合計.equals(list.get(i).getHokenryoDankai())) {
                reportDate2.setListTitle_1(list.get(i).getHokenryoDankai());
                reportDate2.setList_1(getNinsuuOrKinkaku(list.get(i).getYoGetuKinkakuGoukeyi()));
                reportDate2.setList_2(getNinsuuOrKinkaku(list.get(i).getGoGetuKinkakuGoukeyi()));
                reportDate2.setList_3(getNinsuuOrKinkaku(list.get(i).getRokuGetuKinkakuGoukeyi()));
                reportDate2.setList_4(getNinsuuOrKinkaku(list.get(i).getNanaGetuKinkakuGoukeyi()));
                reportDate2.setList_5(getNinsuuOrKinkaku(list.get(i).getHatiGetuKinkakuGoukeyi()));
                reportDate2.setList_6(getNinsuuOrKinkaku(list.get(i).getKyuGetuKinkakuGoukeyi()));
                reportDate2.setList_7(getNinsuuOrKinkaku(list.get(i).getJyuGetuKinkakuGoukeyi()));
                reportDate2.setList_8(getNinsuuOrKinkaku(list.get(i).getJyuitiGetuKinkakuGoukeyi()));
                reportDate2.setList_9(getNinsuuOrKinkaku(list.get(i).getJyuniGetuKinkakuGoukeyi()));
                reportDate2.setList_10(getNinsuuOrKinkaku(list.get(i).getItiGetuKinkakuGoukeyi()));
                reportDate2.setList_11(getNinsuuOrKinkaku(list.get(i).getNiGetuKinkakuGoukeyi()));
                reportDate2.setList_12(getNinsuuOrKinkaku(list.get(i).getSanGetuKinkakuGoukeyi()));
                reportDate2.setList_13(getNinsuuOrKinkaku(list.get(i).get現年随時の金額合計()));
                reportDate2.setList_14(getNinsuuOrKinkaku(list.get(i).get過年度の金額合計()));
                reportDate2.setList_15(getNinsuuOrKinkaku(list.get(i).get該当段階の金額合計()));
                reportDate2.setList_16(getNinsuuOrKinkaku(list.get(i).get歳出還付の金額合計()));
                break;
            }
        }
        reportDateList.add(reportDate2);
        return reportDateList;
    }
}
