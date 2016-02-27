/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100056;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100056.TsuchishoFuriKaeNashiReportSource;

/**
 * 口振依頼なし通知書ボディEditorです。
 */
class TsuchishoFuriKaeNashiBodyEditor implements ITsuchishoFuriKaeNashiEditor {

    private final TsuchishoFuriKaeNashiItem item;

    public TsuchishoFuriKaeNashiBodyEditor(TsuchishoFuriKaeNashiItem item) {
        this.item = item;
    }

    @Override
    public TsuchishoFuriKaeNashiReportSource edit(TsuchishoFuriKaeNashiReportSource source) {
        return editBody(source);
    }

    private TsuchishoFuriKaeNashiReportSource editBody(TsuchishoFuriKaeNashiReportSource source) {
        source.hakkoYMD1 = item.get発行日();
        return source;
    }

}
