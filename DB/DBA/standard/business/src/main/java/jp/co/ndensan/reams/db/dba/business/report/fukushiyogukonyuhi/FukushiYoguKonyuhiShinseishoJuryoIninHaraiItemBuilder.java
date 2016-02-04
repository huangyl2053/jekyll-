/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.fukushiyogukonyuhi;

import jp.co.ndensan.reams.db.dba.entity.report.fukushiyogukonyuhi.FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書のBuilderクラスです。
 */
public class FukushiYoguKonyuhiShinseishoJuryoIninHaraiItemBuilder
        implements IFukushiYoguKonyuhiShinseishoJuryoIninHaraiBuilder {

    private final IFukushiYoguKonyuhiShinseishoJuryoIninHaraiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IFukushiYoguKonyuhiShinseishoJuryoIninHaraiEditor}
     */
    public FukushiYoguKonyuhiShinseishoJuryoIninHaraiItemBuilder(IFukushiYoguKonyuhiShinseishoJuryoIninHaraiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource}
     */
    @Override
    public FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource build() {
        return ReportEditorJoiner.from(new FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource()).join(editor).buildSource();
    }
}
