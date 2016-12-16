/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査督促状のReportです。
 *
 * @reamsid_L DBE-0030-030 xuyue
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoReport extends Report<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> {

    private final NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity target;
    private final RString 市町村コード;
    private final RString 市町村名称;

    /**
     * コンストラクタです。
     *
     * @param target 認定調査督促対象者一覧表データのEntity
     * @param 市町村コード 市町村コード(広域市町村コード)
     * @param 市町村名称 市町村名称(広域市町村名称)
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoReport(NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity target,
            RString 市町村コード, RString 市町村名称) {
        this.target = target;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter) {

        INinteiChosaTokusokuTaishoshaIchiranhyoEditor headerEditor = new NinteiChosaTokusokuTaishoshaIchiranhyoHeaderEditor(市町村コード, 市町村名称);
        INinteiChosaTokusokuTaishoshaIchiranhyoEditor bodyEditor = new NinteiChosaTokusokuTaishoshaIchiranhyoBodyEditor(target);
        INinteiChosaTokusokuTaishoshaIchiranhyoBuilder builder = new NinteiChosaTokusokuTaishoshaIchiranhyoBuilderImpl(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
