/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoKanriMasterListChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 境界層管理マスタリストのReportです。
 *
 * @reamsid_L DBU-1050-060 linghuhang
 */
public class KyokaisoKanriMasterListReport extends Report<KyokaisoKanriMasterListReportSource> {

    private final KyokaisoKanriMasterListChohyoDataSakuseiEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity KyokaisoKanriMasterListChohyoDataSakuseiEntity
     */
    public KyokaisoKanriMasterListReport(KyokaisoKanriMasterListChohyoDataSakuseiEntity entity) {
        this.entity = entity;

    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KyokaisoKanriMasterListReportSource> reportSourceWriter) {
        IKyokaisoKanriMasterListEditor headerEditor = new KyokaisoKanriMasterListHeaderEditor(entity);
        IKyokaisoKanriMasterListBuilder builder = new KyokaisoKanriMasterListBuilderImpl(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
