/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshikibesshi;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiChange;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiData;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護事業状況報告月報・一般状況（別紙） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5530-090 dangjingjing
 */
public class JigyohokokuGeppoYoshikiBesshiEditor implements IJigyohokokuGeppoYoshikiBesshiEditor {

    private static final int 年度 = 4;
    private final JigyohokokuGeppoYoshikiBesshiData data;
    private final JigyohokokuGeppoYoshikiBesshiChange change;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuGeppoYoshikiBesshiData
     * @param change JigyohokokuGeppoYoshikiBesshiChange
     */
    protected JigyohokokuGeppoYoshikiBesshiEditor(JigyohokokuGeppoYoshikiBesshiData data, JigyohokokuGeppoYoshikiBesshiChange change) {
        this.data = data;
        this.change = change;
    }

    @Override
    public JigyohokokuGeppoYoshikiBesshiReportSource edit(JigyohokokuGeppoYoshikiBesshiReportSource source) {
        return editSource(source);
    }

    private JigyohokokuGeppoYoshikiBesshiReportSource editSource(JigyohokokuGeppoYoshikiBesshiReportSource source) {
        source.printTimeStamp = data.get作成日時();
        source.shukeiKubun = data.get集計区分();
        source.shuukeiHani = set集計範囲(data.get集計範囲());
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.komokuHyodaiRetsu1 = data.get項目標題列1();
        source.komokuHyodaiRetsu2 = data.get項目標題列2();
        source.komokuHyodaiRetsu3 = data.get項目標題列3();
        source.komokuHyodaiRetsu4 = data.get項目標題列4();
        source.list_1 = change.getList_1();
        source.list_2 = change.getList_2();
        source.list_3 = change.getList_3();
        source.list_4 = change.getList_4();
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
