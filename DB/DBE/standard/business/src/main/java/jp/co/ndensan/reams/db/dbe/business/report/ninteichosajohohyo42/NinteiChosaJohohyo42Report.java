/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo42;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo42ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査票情報のReportです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyo42Report extends Report<NinteiChosaJohohyo42ReportSource> {

    private final NinteiChosaJohohyoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 認定調査票情報のItem
     */
    public NinteiChosaJohohyo42Report(NinteiChosaJohohyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査票情報を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaJohohyo42ReportSource> reportSourceWriter) {
        int maxCount = entity.get問題行動リスト_42().size();
        for (int i = 0; i < maxCount; i++) {
            INinteiChosaJohohyo42Editor editor = new NinteiChosaJohohyo42Editor(entity, i);
            INinteiChosaJohohyo42Builder builder = new NinteiChosaJohohyo42Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
