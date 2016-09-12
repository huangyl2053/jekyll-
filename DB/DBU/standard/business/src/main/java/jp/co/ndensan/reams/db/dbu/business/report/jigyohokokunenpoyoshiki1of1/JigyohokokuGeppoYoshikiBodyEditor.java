/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpoyoshiki1of1;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki1of1.JigyohokokuNenpoYoshiki1of1ReportSource;

/**
 * 事業状況報告年報（様式１・２　被保険者数）のBodyEditorです。
 *
 * @reamsid_L DBU-5610-040 sunhaidi
 */
public class JigyohokokuGeppoYoshikiBodyEditor implements IJigyohokokuGeppoYoshikiEditor {

    private final JigyohokokuGeppoYoshikiData item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuGeppoYoshikiData
     */
    protected JigyohokokuGeppoYoshikiBodyEditor(JigyohokokuGeppoYoshikiData item) {
        this.item = item;
    }

    @Override
    public JigyohokokuNenpoYoshiki1of1ReportSource edit(JigyohokokuNenpoYoshiki1of1ReportSource source) {

        source.list1_1 = item.getList1_1();
        source.list1_2 = item.getList1_2();
        source.list1_3 = item.getList1_3();
        source.list1_4 = item.getList1_4();
        source.list2_1 = item.getList2_1();
        source.list2_2 = item.getList2_2();
        source.list2_3 = item.getList2_3();
        source.list2_4 = item.getList2_4();
        source.list3Upper_1 = item.getList3Upper_1();
        source.list3Upper_2 = item.getList3Upper_2();
        source.list3Upper_3 = item.getList3Upper_3();
        source.list3Upper_4 = item.getList3Upper_4();
        source.list3Upper_5 = item.getList3Upper_5();
        source.list3Upper_6 = item.getList3Upper_6();
        source.list3Lower_1 = item.getList3Lower_1();
        source.list3Lower_2 = item.getList3Lower_2();
        source.list3Lower_3 = item.getList3Lower_3();
        source.list3Lower_4 = item.getList3Lower_4();
        source.list3Lower_5 = item.getList3Lower_5();
        source.list3Lower_6 = item.getList3Lower_6();
        return source;
    }
}
