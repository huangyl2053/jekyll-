/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.b5yoko;

import jp.co.ndensan.reams.db.dbb.entity.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険料額決定通知書のB5横タイプのBuilderです。
 *
 * @reamsid_L DBB-9080-010 sunhaidi
 */
public class KaigoHokenHokenryogakuKetteiTsuchishoB5YokoBuilder implements IKaigoHokenHokenryogakuKetteiTsuchishoB5YokoBuilder {

    private final KaigoHokenHokenryogakuKetteiTsuchishoB5YokoEditor yokoEditor;
    private final KibetsuEditor kibetsuEditor;
    private final CompSofubutsuAtesakiEditor atesakiEditor;
    private final CompNinshoshaEditor compNinshoshaEditor;
    private final CompKaigoToiawasesakiEditor toiawasesakiEditor;

    /**
     * インスタンスを生成します。
     *
     * @param yokoEditor {@link KaigoHokenHokenryogakuKetteiTsuchishoB5YokoEditor}
     * @param kibetsuEditor {@link KibetsuEditor}
     * @param atesakiEditor {@link CompSofubutsuAtesakiEditor}
     * @param compNinshoshaEditor {@link CompNinshoshaEditor}
     * @param toiawasesakiEditor {@link CompKaigoToiawasesakiEditor}
     */
    public KaigoHokenHokenryogakuKetteiTsuchishoB5YokoBuilder(
            KaigoHokenHokenryogakuKetteiTsuchishoB5YokoEditor yokoEditor,
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
    public KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource build() {
        return ReportEditorJoiner.from(new KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource())
                .join(yokoEditor).join(kibetsuEditor).join(atesakiEditor).join(compNinshoshaEditor)
                .join(toiawasesakiEditor)
                .buildSource();
    }
}
