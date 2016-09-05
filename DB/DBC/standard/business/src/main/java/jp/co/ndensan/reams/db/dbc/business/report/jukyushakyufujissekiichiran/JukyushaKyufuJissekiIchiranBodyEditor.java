/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakyufujissekiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranChange;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 受給者給付実績一覧表 のEditorです。
 *
 * @reamsid_L DBC-3070-040 dangjingjing
 */
public class JukyushaKyufuJissekiIchiranBodyEditor implements IJukyushaKyufuJissekiIchiranEditor {

    private final JukyushaKyufuJissekiIchiranChange change;

    /**
     * インスタンスを生成します。
     *
     * @param change JukyushaKyufuJissekiIchiranChange
     */
    protected JukyushaKyufuJissekiIchiranBodyEditor(JukyushaKyufuJissekiIchiranChange change) {
        this.change = change;
    }

    @Override
    public JukyushaKyufuJissekiIchiranReportSource edit(JukyushaKyufuJissekiIchiranReportSource source) {
        return editSource(source);
    }

    private JukyushaKyufuJissekiIchiranReportSource editSource(JukyushaKyufuJissekiIchiranReportSource source) {
        source.listUpper_1 = change.getList1_1();
        source.listUpper_2 = change.getList1_2();
        source.listUpper_3 = change.getList1_3();
        source.listUpper_4 = set年月(change.getList1_4());
        source.listUpper_5 = change.getList1_5();
        source.listUpper_6 = change.getList1_6();
        source.listUpper_7 = change.getList1_7();
        source.listUpper_8 = change.getList1_8();
        source.listUpper_9 = change.getList1_9();
        source.listUpper_10 = change.getList1_10();
        source.listUpper_11 = change.getList1_11();
        source.listUpper_12 = change.getList1_12();
        source.listCenter_1 = change.getList2_1();
        source.listCenter_2 = change.getList2_2();
        source.listCenter_3 = change.getList2_3();
        source.listCenter_4 = change.getList2_4();
        source.listCenter_5 = change.getList2_5();
        source.listCenter_6 = change.getList2_6();
        source.listCenter_7 = change.getList2_7();
        source.listCenter_8 = change.getList2_8();
        source.listCenter_9 = change.getList2_9();
        source.listCenter_10 = change.getList2_10();
        source.listCenter_11 = change.getList2_11();
        source.listCenter_12 = set年月(change.getList2_12());
        source.listLower_1 = change.getList3_1();
        source.listLower_2 = change.getList3_2();
        source.listLower_3 = change.getList3_3();
        source.listLower_4 = change.getList3_4();
        source.listLower_5 = change.getList3_5();
        source.listLower_6 = change.getList3_6();
        source.listLower_7 = change.getList3_7();
        source.listLower_8 = change.getList3_8();
        source.listLower_9 = change.getList3_9();
        source.listLower_10 = change.getList3_10();
        source.listLower_11 = change.getList3_11();
        source.listLower_12 = change.getList3_12();
        return source;
    }

    private RString set年月(RDateTime dateTime) {
        dateTime = RDateTime.now();
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.getDate().wareki().firstYear(FirstYear.ICHI_NEN).getYearMonth());
        return hakkoYMD.toRString();
    }
}
