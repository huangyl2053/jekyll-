/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.KojinShinchokuJokyohyo.KojinShinchokuJokyohyoReportSource;

/**
 * 要介護認定個人進捗状況票Editorです。
 */
class shuiBodyEditor implements KojinShinchokuJokyohyoEditor {

    private final shuiBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link shuiBodyItem}
     */
    protected shuiBodyEditor(shuiBodyItem item) {
        this.item = item;
    }

    @Override
    public KojinShinchokuJokyohyoReportSource edit(KojinShinchokuJokyohyoReportSource source) {
        return editHeader(source);
    }

    private KojinShinchokuJokyohyoReportSource editHeader(KojinShinchokuJokyohyoReportSource source) {
        source.listShujii_1 = item.getListShujii_1();
        source.listShujii_2 = item.getListShujii_2();
        source.listShujii_3 = item.getListShujii_3();
        return source;
    }
}
