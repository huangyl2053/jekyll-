/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shikakushutokushafuseigoichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranhyoEntity;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 資格取得者不整合リストの帳票を作成します。
 *
 * @reamsid_L DBU-4020-040 lishengli
 */
public class ShikakushutokushaFuseigoIchiranhyoReport extends
        Report<ShikakushutokushaFuseigoIchiranhyoReportSource> {

    private final ShikakushutokushaFuseigoIchiranhyoEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item 資格取得者不整合リスト帳票用データEntity
     */
    public ShikakushutokushaFuseigoIchiranhyoReport(ShikakushutokushaFuseigoIchiranhyoEntity item) {
        this.item = item;
    }

    /**
     * 帳票を作成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShikakushutokushaFuseigoIchiranhyoReportSource> reportSourceWriter) {
        IShikakushutokushaFuseigoIchiranhyoEditor editor = new ShikakushutokushaFuseigoIchiranhyoEditorImpl(item);
        IShikakushutokushaFuseigoIchiranhyoBuilder builder = new ShikakushutokushaFuseigoIchiranhyoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
