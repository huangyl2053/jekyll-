/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki3003;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki3003.JigyohokokuCompYoshiki3003Change;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki3003.JigyohokokuCompYoshiki3003ReportSource;

/**
 * 介護事業状況報告月報・一般状況（様式1-3） のEditorです。
 *
 * @reamsid_L DBU-5530-060 dangjingjing
 */
public class JigyohokokuCompYoshiki3003BodyEditor implements IJigyohokokuCompYoshiki3003Editor {

    private final JigyohokokuCompYoshiki3003Change change;

    /**
     * インスタンスを生成します。
     *
     * @param change JigyohokokuCompYoshiki3003Change
     */
    protected JigyohokokuCompYoshiki3003BodyEditor(JigyohokokuCompYoshiki3003Change change) {
        this.change = change;
    }

    @Override
    public JigyohokokuCompYoshiki3003ReportSource edit(JigyohokokuCompYoshiki3003ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki3003ReportSource editSource(JigyohokokuCompYoshiki3003ReportSource source) {
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
        source.list3Left_1 = change.getList3Left_1();
        source.list3Left_2 = change.getList3Left_2();
        source.list3Right_1 = change.getList3Right_1();
        return source;
    }
}
