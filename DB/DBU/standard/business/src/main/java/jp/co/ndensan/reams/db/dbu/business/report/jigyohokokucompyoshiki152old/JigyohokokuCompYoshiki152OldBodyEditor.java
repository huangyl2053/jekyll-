/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152old;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldChange;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldReportSource;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5550-040 dangjingjing
 */
public class JigyohokokuCompYoshiki152OldBodyEditor implements IJigyohokokuCompYoshiki152OldEditor {

    private final JigyohokokuCompYoshiki152OldChange change;

    /**
     * インスタンスを生成します。
     *
     * @param change JigyohokokuCompYoshiki152OldChange
     */
    public JigyohokokuCompYoshiki152OldBodyEditor(JigyohokokuCompYoshiki152OldChange change) {
        this.change = change;
    }

    @Override
    public JigyohokokuCompYoshiki152OldReportSource edit(JigyohokokuCompYoshiki152OldReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki152OldReportSource editSource(JigyohokokuCompYoshiki152OldReportSource source) {
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
