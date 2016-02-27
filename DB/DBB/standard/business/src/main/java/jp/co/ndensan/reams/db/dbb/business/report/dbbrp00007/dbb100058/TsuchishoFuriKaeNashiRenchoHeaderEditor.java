/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100058;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100058.TsuchishoFuriKaeNashiRenchoReportSource;

/**
 * 口振依頼なし通知書_連帳ヘッダEditorです。
 */
class TsuchishoFuriKaeNashiRenchoHeaderEditor implements ITsuchishoFuriKaeNashiRenchoEditor {

    private final TsuchishoFuriKaeNashiRenchoItem item;

    public TsuchishoFuriKaeNashiRenchoHeaderEditor(TsuchishoFuriKaeNashiRenchoItem item) {
        this.item = item;
    }

    @Override
    public TsuchishoFuriKaeNashiRenchoReportSource edit(TsuchishoFuriKaeNashiRenchoReportSource source) {
        return editHeader(source);
    }

    private TsuchishoFuriKaeNashiRenchoReportSource editHeader(TsuchishoFuriKaeNashiRenchoReportSource source) {
        source.hakkoYMD1 = item.get発行日();
        return source;
    }

}
