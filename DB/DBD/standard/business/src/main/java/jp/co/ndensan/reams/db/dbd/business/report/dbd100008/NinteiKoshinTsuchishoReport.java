/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100008;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100008.NinteiKoshinTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 負担限度額認定更新のお知らせ通知書
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoReport extends Report<NinteiKoshinTsuchishoReportSource> {

    private final NinteiKoshinTsuchishoItem target;

    /**
     * インスタンスを生成します。
     *
     * @param target パラメータ
     */
    public NinteiKoshinTsuchishoReport(NinteiKoshinTsuchishoItem target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteiKoshinTsuchishoReportSource> reportSourceWriter) {
        target.setイメージファイルパス(reportSourceWriter.getImageFolderPath());
        NinteiKoshinTsuchishoLayer1Editor layer1Editor = new NinteiKoshinTsuchishoLayer1Editor(target);
        NinteiKoshinTsuchishoCompNinshoshaEditor compNinshoshaEditor = new NinteiKoshinTsuchishoCompNinshoshaEditor(target);
        NinteiKoshinTsuchishoCompSofubutsuAtesakiEditor compSofubutsuAtesakiEditor = new NinteiKoshinTsuchishoCompSofubutsuAtesakiEditor(target);
        INinteiKoshinTsuchishoBuilder builder = new NinteiKoshinTsuchishoBuilder(layer1Editor, compNinshoshaEditor, compSofubutsuAtesakiEditor);
        reportSourceWriter.writeLine(builder);
    }
}
