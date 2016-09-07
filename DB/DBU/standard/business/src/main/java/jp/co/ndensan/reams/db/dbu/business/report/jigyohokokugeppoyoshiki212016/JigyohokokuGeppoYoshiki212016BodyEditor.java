/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki212016;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki212016.JigyohokokuGeppoYoshiki212016ReportSource;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2）のEditorです。
 *
 * @reamsid_L DBU-5600-100 lishengli
 */
public class JigyohokokuGeppoYoshiki212016BodyEditor implements IJigyohokokuGeppoYoshiki212016Editor {

    private final JigyohokokuGeppoYoshiki212016BodyData item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuGeppoYoshiki212016BodyData
     */
    protected JigyohokokuGeppoYoshiki212016BodyEditor(JigyohokokuGeppoYoshiki212016BodyData item) {
        this.item = item;
    }

    @Override
    public JigyohokokuGeppoYoshiki212016ReportSource edit(JigyohokokuGeppoYoshiki212016ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuGeppoYoshiki212016ReportSource editSource(JigyohokokuGeppoYoshiki212016ReportSource source) {
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
