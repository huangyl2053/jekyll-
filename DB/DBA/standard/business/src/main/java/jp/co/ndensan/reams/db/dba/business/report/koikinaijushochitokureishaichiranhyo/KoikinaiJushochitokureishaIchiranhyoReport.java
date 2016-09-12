/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 広域内住所地特例者一覧表のReportです。
 *
 * @reamsid_L DBU-1140-060 linghuhang
 */
public class KoikinaiJushochitokureishaIchiranhyoReport extends Report<KoikinaiJushochitokureishaIchiranhyoReportSource> {

    private final List<KoikinaiJushochitokureishaIchiranhyoBody> bodyItemList;
    private final KoikinaiJushochitokureishaIchiranhyoHead headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 広域内住所地特例者一覧表ヘッダのITEM
     * @param itemList 広域内住所地特例者一覧表のITEMリスト
     */
    public KoikinaiJushochitokureishaIchiranhyoReport(
            KoikinaiJushochitokureishaIchiranhyoHead headItem,
            List<KoikinaiJushochitokureishaIchiranhyoBody> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KoikinaiJushochitokureishaIchiranhyoReportSource> reportSourceWriter) {
        for (KoikinaiJushochitokureishaIchiranhyoBody bodyItem : bodyItemList) {
            IKoikinaiJushochitokureishaIchiranhyoEditor headerEditor = new KoikinaiJushochitokureishaIchiranhyoHeaderEditor(headItem);
            IKoikinaiJushochitokureishaIchiranhyoEditor bodyEditor = new KoikinaiJushochitokureishaIchiranhyoBodyEditor(bodyItem);
            IKoikinaiJushochitokureishaIchiranhyoBuilder builder = new KoikinaiJushochitokureishaIchiranhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
