/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;

/**
 * 事務局用介護認定審査対象者一覧表のEditorクラスです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
public class ShinsakaishiryoA4Editor implements IShinsakaishiryoA4Editor {

    private final ShinsakaishiryoA4Item item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsakaishiryoA4Item}
     */
    protected ShinsakaishiryoA4Editor(ShinsakaishiryoA4Item item) {
        this.item = item;
    }

    /**
     *
     * @param source 事務局用介護認定審査対象者一覧表のReportSourceクラス
     * @return ShinsakaishiryoA4ReportSource 事務局用介護認定審査対象者一覧表のReportSourceクラス
     */
    @Override
    public ShinsakaishiryoA4ReportSource edit(ShinsakaishiryoA4ReportSource source) {
        return editItem(source);
    }

    private ShinsakaishiryoA4ReportSource editItem(ShinsakaishiryoA4ReportSource source) {
        source.shinsakaiNo = item.getShinsakaiNo();
        source.year = item.getYear();
        source.listshinsainName_1 = item.getListshinsainName_1();
        source.gogitaiNo = item.getGogitaiNo();
        source.shinsaTaishoshaCount = item.getShinsaTaishoshaCount();
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
        source.list1_13 = item.getList1_13();
        return source;
    }

}
