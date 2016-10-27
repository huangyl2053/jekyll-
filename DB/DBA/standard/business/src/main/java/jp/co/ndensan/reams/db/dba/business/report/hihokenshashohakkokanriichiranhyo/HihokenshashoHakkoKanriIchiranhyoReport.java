/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihokenshashoHakkoKanriIchiranhyoEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 被保険者証発行管理一覧表のReportです。
 *
 * @reamsid_L DBA-0600-070 lishengli
 */
public class HihokenshashoHakkoKanriIchiranhyoReport extends Report<HihokenshashoHakkoKanriIchiranhyoReportSource> {

    private final HihokenshashoHakkoKanriIchiranhyoEntity headEntity;

    /**
     * インスタンスを生成します。
     *
     * @param headEntity 被保険者証発行管理一覧表ヘッダのEntity
     */
    public HihokenshashoHakkoKanriIchiranhyoReport(
            HihokenshashoHakkoKanriIchiranhyoEntity headEntity) {
        this.headEntity = headEntity;
    }

    /**
     * 被保険者証発行管理一覧表writeBy。
     *
     * @param reportSourceWriter 被保険者証発行管理一覧表のReportSource
     */
    @Override
    public void writeBy(ReportSourceWriter<HihokenshashoHakkoKanriIchiranhyoReportSource> reportSourceWriter) {
        IHihokenshashoHakkoKanriIchiranhyoEditor headEditor = new HihokenshashoHakkoKanriIchiranhyoEditor(headEntity);
        IHihokenshashoHakkoKanriIchiranhyoBuilder builder = new HihokenshashoHakkoKanriIchiranhyoBuilder(headEditor);
        reportSourceWriter.writeLine(builder);
    }
}
