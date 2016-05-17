/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.b5yoko;

import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険料額変更兼特別徴収中止通知書のB5横タイプのBuilderです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
public class KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoBuilder implements IKaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoBuilder {

    private final KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoEditor yokoEditor;
    private final KibetsuEditor kibetsuEditor;
    private final CompSofubutsuAtesakiEditor atesakiEditor;
    private final CompNinshoshaEditor compNinshoshaEditor;
    private final CompKaigoToiawasesakiEditor toiawasesakiEditor;
    private final ShotokuDankaiEditor shotokuDankaiEditor;

    /**
     * インスタンスを生成します。
     *
     * @param yokoEditor {@link KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoEditor}
     * @param kibetsuEditor {@link KibetsuEditor}
     * @param atesakiEditor {@link CompSofubutsuAtesakiEditor}
     * @param compNinshoshaEditor {@link CompNinshoshaEditor}
     * @param toiawasesakiEditor {@link CompKaigoToiawasesakiEditor}
     * @param shotokuDankaiEditor {@link ShotokuDankaiEditor}
     */
    public KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoBuilder(
            KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoEditor yokoEditor,
            KibetsuEditor kibetsuEditor,
            CompSofubutsuAtesakiEditor atesakiEditor,
            CompNinshoshaEditor compNinshoshaEditor,
            CompKaigoToiawasesakiEditor toiawasesakiEditor,
            ShotokuDankaiEditor shotokuDankaiEditor) {
        this.yokoEditor = yokoEditor;
        this.kibetsuEditor = kibetsuEditor;
        this.atesakiEditor = atesakiEditor;
        this.compNinshoshaEditor = compNinshoshaEditor;
        this.toiawasesakiEditor = toiawasesakiEditor;
        this.shotokuDankaiEditor = shotokuDankaiEditor;
    }

    @Override
    public KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource build() {
        return ReportEditorJoiner.from(new KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource())
                .join(yokoEditor).join(kibetsuEditor).join(atesakiEditor).join(compNinshoshaEditor)
                .join(toiawasesakiEditor).join(shotokuDankaiEditor)
                .buildSource();
    }
}
