/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki1;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護事業状況報告月報・一般状況（様式1） のEditorです。
 *
 * @reamsid_L DBU-5530-040 dangjingjing
 */
public class JigyohokokuGeppoYoshiki1Editor implements IJigyohokokuGeppoYoshiki1Editor {

    private static final int 年度 = 4;

    private final JigyohokokuGeppoYoshiki1Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuGeppoYoshiki1Data
     */
    protected JigyohokokuGeppoYoshiki1Editor(JigyohokokuGeppoYoshiki1Data data) {
        this.data = data;
    }

    @Override
    public JigyohokokuGeppoYoshiki1ReportSource edit(JigyohokokuGeppoYoshiki1ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuGeppoYoshiki1ReportSource editSource(JigyohokokuGeppoYoshiki1ReportSource source) {
        source.shukeiKubun = data.get集計区分();
        source.printTimeStamp = data.get作成日時();
        source.shuukeiHani = set集計範囲(data.get集計範囲());
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.komokuHyodaiRetsu1 = data.get第1号被保険者数_項目標題列1();
        source.komokuHyodaiRetsu2 = data.get第1号被保険者数_項目標題列2();
        source.komokuHyodaiRetsu3 = data.get第1号被保険者数_項目標題列3();
        source.komokuHyodaiRetsu4 = data.get第1号被保険者数_項目標題列4();
        source.komokuHyodaiGyo1 = data.get第1号被保険者増減内訳_項目標題行1();
        source.komokuHyodaiGyo2 = data.get第1号被保険者増減内訳_項目標題行2();
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
        集計範囲_SB.append(new RString("分)"));
        return 集計範囲_SB.toRString();
    }
}
