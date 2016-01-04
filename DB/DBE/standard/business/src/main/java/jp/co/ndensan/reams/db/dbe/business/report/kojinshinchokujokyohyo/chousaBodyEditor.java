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
class chousaBodyEditor implements KojinShinchokuJokyohyoEditor {

    private final chousaBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link chousaBodyItem1}
     */
    protected chousaBodyEditor(chousaBodyItem item) {
        this.item = item;
    }

    @Override
    public KojinShinchokuJokyohyoReportSource edit(KojinShinchokuJokyohyoReportSource source) {
        return editHeader(source);
    }

    private KojinShinchokuJokyohyoReportSource editHeader(KojinShinchokuJokyohyoReportSource source) {
        source.listChosain_1 = item.getChosain_1();
        source.listChosain_2 = item.getChosain_2();
        source.listChosain_3 = item.getChosain_3();
        return source;
    }
}
