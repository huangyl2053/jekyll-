/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki201300009;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki201300009.JigyohokokuCompYoshiki20109ReportSource;

/**
 * 介護事業状況報告年報（様式2-3）のBodyEditorです。
 *
 * @reamsid_L DBU-5600-220 wangrenze
 */
public class JigyohokokuCompYoshiki20109BodyEditor implements IJigyohokokuCompYoshiki20109Editor {

    private final JigyohokokuCompYoshiki20109BodyData item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuCompYoshiki20109BodyData
     */
    protected JigyohokokuCompYoshiki20109BodyEditor(JigyohokokuCompYoshiki20109BodyData item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshiki20109ReportSource edit(JigyohokokuCompYoshiki20109ReportSource source) {
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
