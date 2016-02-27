/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100057;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100057.TsuchishoFuriKaeAriRenchoReportSource;

/**
 * 口振依頼あり通知書_連帳ボディEditorです。
 */
class TsuchishoFuriKaeAriRenchoBodyEditor implements ITsuchishoFuriKaeAriRenchoEditor {

    private final TsuchishoFuriKaeAriRenchoItem item;

    public TsuchishoFuriKaeAriRenchoBodyEditor(TsuchishoFuriKaeAriRenchoItem item) {
        this.item = item;
    }

    @Override
    public TsuchishoFuriKaeAriRenchoReportSource edit(TsuchishoFuriKaeAriRenchoReportSource source) {
        return editBody(source);
    }

    private TsuchishoFuriKaeAriRenchoReportSource editBody(TsuchishoFuriKaeAriRenchoReportSource source) {
        source.hakkoYMD1 = item.get発行日();
        return source;
    }

}
