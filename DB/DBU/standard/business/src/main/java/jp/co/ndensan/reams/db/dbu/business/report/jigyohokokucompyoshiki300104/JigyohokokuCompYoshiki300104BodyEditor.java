/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki300104;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12Change;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki300103.JigyohokokuCompYoshiki300103ReportSource;

/**
 * 介護事業状況報告年報（様式1-3）のEditorです。
 *
 * @reamsid_L DBU-5600-130 lishengli
 */
public class JigyohokokuCompYoshiki300104BodyEditor implements IJigyohokokuCompYoshiki300104Editor {

    private final JigyohokokuCompYoshiki12Change item;

    /**
     * インスタンスを生成します。
     *
     * @param item NinteichosaIraiHenkoData
     */
    protected JigyohokokuCompYoshiki300104BodyEditor(JigyohokokuCompYoshiki12Change item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshiki300103ReportSource edit(JigyohokokuCompYoshiki300103ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki300103ReportSource editSource(JigyohokokuCompYoshiki300103ReportSource source) {
        source.list1_1 = item.getList1_1();
        source.list1_2 = item.getList1_2();
        source.list1_3 = item.getList1_3();
        source.list1_4 = item.getList1_4();
        source.list1_5 = item.getList1_5();
        source.list1_6 = item.getList1_6();
        source.list1_7 = item.getList1_7();
        source.list1_8 = item.getList1_8();
        source.list1_9 = item.getList1_9();
        source.list1_10 = item.getList1_10();
        source.list1_11 = item.getList1_11();
        source.list1_12 = item.getList1_12();
        source.list2_1 = item.getList2_1();
        source.list3Left_1 = item.getList3Left_1();
        source.list3Left_2 = item.getList3Left_2();
        source.list3Right_1 = item.getList3Right_1();
        return source;
    }

}
