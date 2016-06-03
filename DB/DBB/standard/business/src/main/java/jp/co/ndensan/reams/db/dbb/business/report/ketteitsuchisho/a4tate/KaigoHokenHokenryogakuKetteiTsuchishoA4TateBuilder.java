/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.a4tate;

import jp.co.ndensan.reams.db.dbb.entity.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険料額決定通知書のA4縦タイプのBuilderです。
 *
 * @reamsid_L DBB-9080-010 sunhaidi
 */
public class KaigoHokenHokenryogakuKetteiTsuchishoA4TateBuilder implements IKaigoHokenHokenryogakuKetteiTsuchishoA4TateBuilder {

    private final KaigoHokenHokenryogakuKetteiTsuchishoA4TateEditor yokoEditor;
    private final KibetsuEditor kibetsuEditor;
    private final CompSofubutsuAtesakiEditor atesakiEditor;
    private final CompNinshoshaEditor compNinshoshaEditor;
    private final CompKaigoToiawasesakiEditor toiawasesakiEditor;

    /**
     * インスタンスを生成します。
     *
     * @param yokoEditor {@link KaigoHokenHokenryogakuKetteiTsuchishoA4TateEditor}
     * @param kibetsuEditor {@link KibetsuEditor}
     * @param atesakiEditor {@link CompSofubutsuAtesakiEditor}
     * @param compNinshoshaEditor {@link CompNinshoshaEditor}
     * @param toiawasesakiEditor {@link CompKaigoToiawasesakiEditor}
     */
    public KaigoHokenHokenryogakuKetteiTsuchishoA4TateBuilder(
            KaigoHokenHokenryogakuKetteiTsuchishoA4TateEditor yokoEditor,
            KibetsuEditor kibetsuEditor,
            CompSofubutsuAtesakiEditor atesakiEditor,
            CompNinshoshaEditor compNinshoshaEditor,
            CompKaigoToiawasesakiEditor toiawasesakiEditor) {
        this.yokoEditor = yokoEditor;
        this.kibetsuEditor = kibetsuEditor;
        this.atesakiEditor = atesakiEditor;
        this.compNinshoshaEditor = compNinshoshaEditor;
        this.toiawasesakiEditor = toiawasesakiEditor;
    }

    @Override
    public KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource build() {
        return ReportEditorJoiner.from(new KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource())
                .join(yokoEditor).join(kibetsuEditor).join(atesakiEditor).join(compNinshoshaEditor)
                .join(toiawasesakiEditor)
                .buildSource();
    }
}
