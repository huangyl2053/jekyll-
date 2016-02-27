/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100056;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100056.TsuchishoFuriKaeNashiReportSource;

/**
 * 口振依頼なし通知書ヘッダEditorです。
 */
class TsuchishoFuriKaeNashiHeaderEditor implements ITsuchishoFuriKaeNashiEditor {

    private final TsuchishoFuriKaeNashiItem item;

    public TsuchishoFuriKaeNashiHeaderEditor(TsuchishoFuriKaeNashiItem item) {
        this.item = item;
    }

    @Override
    public TsuchishoFuriKaeNashiReportSource edit(TsuchishoFuriKaeNashiReportSource source) {
        return editHeader(source);
    }

    private TsuchishoFuriKaeNashiReportSource editHeader(TsuchishoFuriKaeNashiReportSource source) {
        source.hakkoYMD1 = item.get発行日();
        return source;
    }

}
