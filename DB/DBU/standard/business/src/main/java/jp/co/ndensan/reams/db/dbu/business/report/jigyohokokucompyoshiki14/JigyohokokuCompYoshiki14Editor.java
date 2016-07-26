/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki14;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5530-070 dangjingjing
 */
public class JigyohokokuCompYoshiki14Editor implements IJigyohokokuCompYoshiki14Editor {

    private static final int 年度 = 4;
    private final JigyohokokuCompYoshiki14Data data;
    private final JigyohokokuCompYoshiki14Change change;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki14Data
     * @param change JigyohokokuCompYoshiki14Change
     */
    protected JigyohokokuCompYoshiki14Editor(JigyohokokuCompYoshiki14Data data, JigyohokokuCompYoshiki14Change change) {
        this.data = data;
        this.change = change;
    }

    @Override
    public JigyohokokuCompYoshiki14ReportSource edit(JigyohokokuCompYoshiki14ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki14ReportSource editSource(JigyohokokuCompYoshiki14ReportSource source) {
        source.printTimeStamp = data.get作成日時();
        source.shukeiKubun = data.get集計区分();
        source.shuukeiHani = set集計範囲(data.get集計範囲());
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.hyo1ShinseishaKensu1 = data.get介護老人福祉施設の申請件数();
        source.hyo1ShinseishaKensu2 = data.get介護老人保健施設の申請件数();
        source.hyo1ShinseishaKensu3 = data.get介護療養型医療施設の申請件数();
        source.hyo1ShinseishaKensu4 = data.get地域密着型介護老人福祉施設入居者生活介護の申請件数();
        source.hyo1ShinseishaKensu5 = data.getその他の申請件数();
        source.hyo1ShinseishaKensu6 = data.get合計の申請件数();
        source.list_1 = change.getList_1();
        source.list_2 = change.getList_2();
        source.list_3 = change.getList_3();
        source.list_4 = change.getList_4();
        source.list_5 = change.getList_5();
        source.list_6 = change.getList_6();
        source.list_7 = change.getList_7();
        source.list_8 = change.getList_8();
        source.list_9 = change.getList_9();
        source.list_10 = change.getList_10();
        source.list_11 = change.getList_11();
        source.list_12 = change.getList_12();
        return source;
    }

    private RString set集計範囲(RString 集計範囲) {
        if (RString.isNullOrEmpty(集計範囲)) {
            return RString.EMPTY;
        }
        RStringBuilder 集計範囲_SB = new RStringBuilder();
        集計範囲_SB.append(new RString("("));
        FlexibleYear 集計範囲_年度 = new FlexibleYear(集計範囲.substring(0, 年度));
        FlexibleYearMonth 集計範囲_Temp = new FlexibleYearMonth(集計範囲);
        集計範囲_SB.append(集計範囲_年度.wareki().eraType(EraType.KANJI).getYear());
        集計範囲_SB.append(new RString("年度"));
        集計範囲_SB.append(集計範囲_Temp.wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).getMonth());
        集計範囲_SB.append(new RString("分）"));
        return 集計範囲_SB.toRString();
    }

}
