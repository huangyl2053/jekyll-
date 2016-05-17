/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.a4tate;

import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険料額変更兼特別徴収中止通知書のA4縦タイプのBuilderです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
public class KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateBuilder implements IKaigoHokenryogakuHenkoKenChushiTsuchishoA4TateBuilder {

    private final KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateEditor yokoEditor;
    private final KibetsuEditor kibetsuEditor;
    private final CompSofubutsuAtesakiEditor atesakiEditor;
    private final CompNinshoshaEditor compNinshoshaEditor;
    private final CompKaigoToiawasesakiEditor toiawasesakiEditor;

    /**
     * インスタンスを生成します。
     *
     * @param yokoEditor {@link KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateEditor}
     * @param kibetsuEditor {@link KibetsuEditor}
     * @param atesakiEditor {@link CompSofubutsuAtesakiEditor}
     * @param compNinshoshaEditor {@link CompNinshoshaEditor}
     * @param toiawasesakiEditor {@link CompKaigoToiawasesakiEditor}
     */
    public KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateBuilder(
            KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateEditor yokoEditor,
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
    public KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource build() {
        return ReportEditorJoiner.from(new KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource())
                .join(yokoEditor).join(kibetsuEditor).join(atesakiEditor).join(compNinshoshaEditor)
                .join(toiawasesakiEditor)
                .buildSource();
    }
}
