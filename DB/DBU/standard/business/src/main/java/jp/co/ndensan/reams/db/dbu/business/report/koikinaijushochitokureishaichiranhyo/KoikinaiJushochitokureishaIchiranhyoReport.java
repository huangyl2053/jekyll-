/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.koikinaijushochitokureishaichiranhyo;

import jp.co.ndensan.reams.db.dbu.entity.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 広域内住所地特例者一覧表のReportです。
 *
 * @reamsid_L DBU-1140-060 linghuhang
 */
public class KoikinaiJushochitokureishaIchiranhyoReport extends Report<KoikinaiJushochitokureishaIchiranhyoReportSource> {

    private final KoikinaiJushochitokureishaIchiranhyoBody bodyItem;
    private final KoikinaiJushochitokureishaIchiranhyoHead headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 広域内住所地特例者一覧表ヘッダのITEM
     * @param bodyItem 広域内住所地特例者一覧表のITEMリスト
     */
    public KoikinaiJushochitokureishaIchiranhyoReport(
            KoikinaiJushochitokureishaIchiranhyoHead headItem,
            KoikinaiJushochitokureishaIchiranhyoBody bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KoikinaiJushochitokureishaIchiranhyoReportSource> reportSourceWriter) {
        IKoikinaiJushochitokureishaIchiranhyoEditor headerEditor = new KoikinaiJushochitokureishaIchiranhyoHeaderEditor(headItem);
        IKoikinaiJushochitokureishaIchiranhyoEditor bodyEditor = new KoikinaiJushochitokureishaIchiranhyoBodyEditor(bodyItem);
        IKoikinaiJushochitokureishaIchiranhyoBuilder builder = new KoikinaiJushochitokureishaIchiranhyoBuilderImpl(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
