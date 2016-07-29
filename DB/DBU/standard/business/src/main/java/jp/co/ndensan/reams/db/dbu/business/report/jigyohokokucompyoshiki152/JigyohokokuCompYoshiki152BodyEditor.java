/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152Change;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152ReportSource;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）_新様式 のEditorです。
 *
 * @reamsid_L DBU-5540-050 dangjingjing
 */
public class JigyohokokuCompYoshiki152BodyEditor implements IJigyohokokuCompYoshiki152Editor {

    private final JigyohokokuCompYoshiki152Change change;

    /**
     * インスタンスを生成します。
     *
     * @param change JigyohokokuCompYoshiki152Change
     */
    public JigyohokokuCompYoshiki152BodyEditor(JigyohokokuCompYoshiki152Change change) {
        this.change = change;
    }

    @Override
    public JigyohokokuCompYoshiki152ReportSource edit(JigyohokokuCompYoshiki152ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki152ReportSource editSource(JigyohokokuCompYoshiki152ReportSource source) {
        source.list1_1 = change.getList1_1();
        source.list1_2 = change.getList1_2();
        source.list1_3 = change.getList1_3();
        source.list1_4 = change.getList1_4();
        source.list1_5 = change.getList1_5();
        source.list1_6 = change.getList1_6();
        source.list1_7 = change.getList1_7();
        source.list1_8 = change.getList1_8();
        source.list1_9 = change.getList1_9();
        source.list1_10 = change.getList1_10();
        source.list1_11 = change.getList1_11();
        source.list1_12 = change.getList1_12();
        source.list2_1 = change.getList2_1();
        source.list2_2 = change.getList2_2();
        source.list2_3 = change.getList2_3();
        source.list2_4 = change.getList2_4();
        source.list2_5 = change.getList2_5();
        source.list2_6 = change.getList2_6();
        source.list2_7 = change.getList2_7();
        source.list2_8 = change.getList2_8();
        source.list2_9 = change.getList2_9();
        source.list2_10 = change.getList2_10();
        source.list2_11 = change.getList2_11();
        source.list2_12 = change.getList2_12();
        return source;

    }
}
