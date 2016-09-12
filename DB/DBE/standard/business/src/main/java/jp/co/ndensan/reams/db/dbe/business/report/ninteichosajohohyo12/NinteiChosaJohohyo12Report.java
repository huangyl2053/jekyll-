/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo12;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo12ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査票情報のReportです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyo12Report extends Report<NinteiChosaJohohyo12ReportSource> {

    private final NinteiChosaJohohyoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 認定調査票情報のItem
     */
    public NinteiChosaJohohyo12Report(NinteiChosaJohohyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査票情報を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaJohohyo12ReportSource> reportSourceWriter) {
        int maxCount = entity.getサービス区分リスト().size();
        for (int i = 0; i < maxCount; i++) {
            INinteiChosaJohohyo12Editor editor = new NinteiChosaJohohyo12Editor(entity, i);
            INinteiChosaJohohyo12Builder builder = new NinteiChosaJohohyo12Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
