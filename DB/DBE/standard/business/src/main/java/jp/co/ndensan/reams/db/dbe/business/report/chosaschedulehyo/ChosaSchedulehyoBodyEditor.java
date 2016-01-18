/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import jp.co.ndensan.reams.db.dbe.entity.report.chosaschedulehyo.ChosaSchedulehyoReportSource;

/**
 * 認定調査スケジュール登録・認定調査スケジュール表(調査員)Editorです。
 */
class ChosaSchedulehyoBodyEditor implements ChosaSchedulehyoEditor {

    private final ChosaSchedulehyoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaSchedulehyoItem}
     */
    protected ChosaSchedulehyoBodyEditor(ChosaSchedulehyoBodyItem item) {
        this.item = item;
    }

    @Override
    public ChosaSchedulehyoReportSource edit(ChosaSchedulehyoReportSource source) {
        return editBody(source);
    }

    private ChosaSchedulehyoReportSource editBody(ChosaSchedulehyoReportSource source) {
        source.List1_1 = item.getList1_1();
        source.List1_2 = item.getList1_2();
        source.List1_3 = item.getList1_3();
        source.List1_4 = item.getList1_4();
        source.List1_5 = item.getList1_5();
        source.List1_6 = item.getList1_6();
        source.List1_7 = item.getList1_7();
        source.List1_8 = item.getList1_8();
        source.List1_9 = item.getList1_9();
        source.List1_10 = item.getList1_10();
        source.List1_11 = item.getList1_11();
        source.List1_12 = item.getList1_12();
        source.List1_13 = item.getList1_13();
        source.List1_14 = item.getList1_14();
        return source;
    }
}
