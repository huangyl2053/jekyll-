/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkiichiran.GaikyoTokkiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkiichiran.GaikyoTokkiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用概況特記一覧表のReportです。
 *
 * @reamsid_L DBE-0150-030 lishengli
 */
public class GaikyoTokkiIchiranReport extends Report<GaikyoTokkiIchiranReportSource> {

    private final GaikyoTokkiIchiranEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 事務局用概況特記一覧表のEntity
     */
    public GaikyoTokkiIchiranReport(GaikyoTokkiIchiranEntity entity) {

        this.entity = entity;
    }

    /**
     *
     * @param reportSourceWriter 要介護認定調査依頼書Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<GaikyoTokkiIchiranReportSource> reportSourceWriter) {
        IGaikyoTokkiIchiranEditor editor = new GaikyoTokkiIchiranEditor(entity);
        IGaikyoTokkiIchiranBuilder builder = new GaikyoTokkiIchiranBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
