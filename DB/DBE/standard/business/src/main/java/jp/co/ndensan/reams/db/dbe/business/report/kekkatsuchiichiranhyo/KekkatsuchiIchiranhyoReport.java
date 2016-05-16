/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kekkatsuchiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.kekkatsuchiichiranhyo.KekkatsuchiIchiranhyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.kekkatsuchiichiranhyo.KekkatsuchiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定結果通知一覧表のReportです。
 *
 * @reamsid_L DBE-0180-020 xuyannan
 */
public class KekkatsuchiIchiranhyoReport extends Report<KekkatsuchiIchiranhyoReportSource> {

    private final KekkatsuchiIchiranhyoEntity entity;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定結果通知一覧表のentity
     * @param index 連番
     */
    public KekkatsuchiIchiranhyoReport(KekkatsuchiIchiranhyoEntity entity, int index) {
        this.entity = entity;
        this.index = index;
    }

    /**
     * 要介護認定結果通知一覧表を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KekkatsuchiIchiranhyoReportSource> reportSourceWriter) {
        IKekkatsuchiIchiranhyoEditor editor = new KekkatsuchiIchiranhyoEditorImpl(entity, index);
        IKekkatsuchiIchiranhyoBuilder builder = new KekkatsuchiIchiranhyoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
