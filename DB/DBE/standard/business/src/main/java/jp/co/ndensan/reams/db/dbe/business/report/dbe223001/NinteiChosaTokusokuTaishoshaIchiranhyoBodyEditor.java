/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;

/**
 * 認定調査督促対象者一覧表ボディEditorです。
 */
class NinteiChosaTokusokuTaishoshaIchiranhyoBodyEditor implements INinteiChosaTokusokuTaishoshaIchiranhyoEditor {

    private final NinteiChosaTokusokuTaishoshaIchiranhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IkenshoShujiiIchiranItem}
     */
    protected NinteiChosaTokusokuTaishoshaIchiranhyoBodyEditor(NinteiChosaTokusokuTaishoshaIchiranhyoItem item) {
        this.item = item;
    }

    @Override
    public NinteiChosaTokusokuTaishoshaIchiranhyoReportSource edit(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        return editBody(source);
    }

    private NinteiChosaTokusokuTaishoshaIchiranhyoReportSource editBody(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listNo_1 = item.getListNo_1();
        source.listUpper1_1 = item.getListUpper1_1();
        source.listUpper1_2 = item.getListUpper1_2();
        source.listShinseiYMD_1 = item.getListShinseiYMD_1();
        source.listTokusokujoHakkoYMD_1 = item.getListTokusokujoHakkoYMD_1();
        source.listUpper2_1 = item.getListUpper2_1();
        source.listUpper2_2 = item.getListUpper2_2();
        source.listLower1_1 = item.getListLower1_1();
        source.listLower1_2 = item.getListLower1_2();
        source.listLower2_1 = item.getListLower2_1();
        source.listLower2_2 = item.getListLower2_2();
        return source;
    }
}
