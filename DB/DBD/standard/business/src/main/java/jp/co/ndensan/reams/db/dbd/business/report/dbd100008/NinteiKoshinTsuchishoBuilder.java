/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100008;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100008.NinteiKoshinTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 負担限度額認定更新のお知らせ通知書
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoBuilder implements INinteiKoshinTsuchishoBuilder {

    private final NinteiKoshinTsuchishoLayer1Editor layer1Editor;
    private final NinteiKoshinTsuchishoCompNinshoshaEditor compNinshoshaEditor;
    private final NinteiKoshinTsuchishoCompSofubutsuAtesakiEditor compSofubutsuAtesakiEditor;

    /**
     * インスタンスを生成します。
     *
     * @param layer1Editor NinteiKoshinTsuchishoReportSourceLayer1Editor
     * @param compNinshoshaEditor NinteiKoshinTsuchishoReportSourceCompNinshoshaEditor
     * @param compSofubutsuAtesakiEditor NinteiKoshinTsuchishoReportSourceCompSofubutsuAtesakiEditor
     */
    public NinteiKoshinTsuchishoBuilder(NinteiKoshinTsuchishoLayer1Editor layer1Editor,
            NinteiKoshinTsuchishoCompNinshoshaEditor compNinshoshaEditor,
            NinteiKoshinTsuchishoCompSofubutsuAtesakiEditor compSofubutsuAtesakiEditor) {
        this.layer1Editor = layer1Editor;
        this.compNinshoshaEditor = compNinshoshaEditor;
        this.compSofubutsuAtesakiEditor = compSofubutsuAtesakiEditor;
    }

    @Override
    public NinteiKoshinTsuchishoReportSource build() {
        return ReportEditorJoiner.from(
                new NinteiKoshinTsuchishoReportSource()).join(layer1Editor).join(compNinshoshaEditor).join(compSofubutsuAtesakiEditor).buildSource();
    }

}
