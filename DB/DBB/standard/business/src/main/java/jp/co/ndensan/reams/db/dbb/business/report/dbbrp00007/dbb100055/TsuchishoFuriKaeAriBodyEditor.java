/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100055;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100055.TsuchishoFuriKaeAriReportSource;

/**
 * 口振依頼あり通知書ボディEditorです。
 */
class TsuchishoFuriKaeAriBodyEditor implements ITsuchishoFuriKaeAriEditor {

    private final TsuchishoFuriKaeAriItem item;

    public TsuchishoFuriKaeAriBodyEditor(TsuchishoFuriKaeAriItem item) {
        this.item = item;
    }

    @Override
    public TsuchishoFuriKaeAriReportSource edit(TsuchishoFuriKaeAriReportSource source) {
        return editBody(source);
    }

    private TsuchishoFuriKaeAriReportSource editBody(TsuchishoFuriKaeAriReportSource source) {
        source.hakkoYMD1 = item.get発行日();
        return source;
    }

}
