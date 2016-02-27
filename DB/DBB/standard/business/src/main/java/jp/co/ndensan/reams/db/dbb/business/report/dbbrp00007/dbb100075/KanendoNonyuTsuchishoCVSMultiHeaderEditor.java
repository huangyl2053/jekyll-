/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100075;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100075.KanendoNonyuTsuchishoCVSMultiReportSource;

/**
 * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ通知書】ヘッダEditorです。
 */
class KanendoNonyuTsuchishoCVSMultiHeaderEditor implements IKanendoNonyuTsuchishoCVSMultiEditor {

    private final KanendoNonyuTsuchishoCVSMultiItem item;

    public KanendoNonyuTsuchishoCVSMultiHeaderEditor(KanendoNonyuTsuchishoCVSMultiItem item) {
        this.item = item;
    }

    @Override
    public KanendoNonyuTsuchishoCVSMultiReportSource edit(KanendoNonyuTsuchishoCVSMultiReportSource source) {
        return editHeader(source);
    }

    private KanendoNonyuTsuchishoCVSMultiReportSource editHeader(KanendoNonyuTsuchishoCVSMultiReportSource source) {
        source.hakkoYMD1 = item.get発行日();
        return source;
    }

}
