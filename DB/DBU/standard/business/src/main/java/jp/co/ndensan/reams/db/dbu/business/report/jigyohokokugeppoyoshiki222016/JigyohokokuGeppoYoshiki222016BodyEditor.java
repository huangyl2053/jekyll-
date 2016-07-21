/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki222016;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki222016.JigyohokokuGeppoYoshiki222016ReportSource;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2）のEditorです。
 *
 * @reamsid_L DBU-5600-110 lishengli
 */
public class JigyohokokuGeppoYoshiki222016BodyEditor implements IJigyohokokuGeppoYoshiki222016Editor {

    private final JigyohokokuGeppoYoshiki222016BodyData item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuGeppoYoshiki222016BodyData
     */
    protected JigyohokokuGeppoYoshiki222016BodyEditor(JigyohokokuGeppoYoshiki222016BodyData item) {
        this.item = item;
    }

    @Override
    public JigyohokokuGeppoYoshiki222016ReportSource edit(JigyohokokuGeppoYoshiki222016ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuGeppoYoshiki222016ReportSource editSource(JigyohokokuGeppoYoshiki222016ReportSource source) {
        source.listList1_1 = item.getListList1_1();
        source.listList1_2 = item.getListList1_2();
        source.listList1_3 = item.getListList1_3();
        source.listList1_4 = item.getListList1_4();
        source.listList1_5 = item.getListList1_5();
        source.listList1_6 = item.getListList1_6();
        source.listList1_7 = item.getListList1_7();
        source.listList1_8 = item.getListList1_8();
        source.listList1_9 = item.getListList1_9();
        source.listList1_10 = item.getListList1_10();
        source.listList1_11 = item.getListList1_11();
        source.listList1_12 = item.getListList1_12();
        return source;
    }
}
