/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki202;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki202.JigyohokokuCompYoshiki202ReportSource;

/**
 * 介護事業状況報告年報（様式2-4）のEditorです。
 *
 * @reamsid_L DBU-5600-250 guoqilin
 */
public class JigyohokokuCompYoshiki202BodyEditor implements IJigyohokokuCompYoshiki202Editor {

    private final JigyohokokuCompYoshiki202BodyData item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuCompYoshiki202BodyData
     */
    protected JigyohokokuCompYoshiki202BodyEditor(JigyohokokuCompYoshiki202BodyData item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshiki202ReportSource edit(JigyohokokuCompYoshiki202ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki202ReportSource editSource(JigyohokokuCompYoshiki202ReportSource source) {
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
