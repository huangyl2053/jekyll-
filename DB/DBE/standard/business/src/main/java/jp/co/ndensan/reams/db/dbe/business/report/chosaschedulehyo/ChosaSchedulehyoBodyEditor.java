/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import jp.co.ndensan.reams.db.dbe.entity.report.chosaschedulehyo.ChosaSchedulehyoReportSource;

/**
 * 認定調査スケジュール表(事務所)ボディEditorです。
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

    /**
     * 認定調査スケジュール表ボディEditorです。
     *
     * @param source 認定調査スケジュール表Source
     * @return 認定調査スケジュール表Source
     */
    @Override
    public ChosaSchedulehyoReportSource edit(ChosaSchedulehyoReportSource source) {
        return editBody(source);
    }

    private ChosaSchedulehyoReportSource editBody(ChosaSchedulehyoReportSource source) {
        source.List1_1 = item.get日付();
        source.List1_2 = item.get曜日();
        source.List1_3 = item.get空き_AM();
        source.List1_4 = item.get空き_件数1();
        source.List1_5 = item.get空き_PM();
        source.List1_6 = item.get空き_件数2();
        source.List1_7 = item.get仮予約_AM();
        source.List1_8 = item.get仮予約_件数1();
        source.List1_9 = item.get仮予約_PM();
        source.List1_10 = item.get仮予約_件数2();
        source.List1_11 = item.get確定_AM();
        source.List1_12 = item.get確定_件数1();
        source.List1_13 = item.get確定_PM();
        source.List1_14 = item.get確定_件数2();
        return source;
    }
}
