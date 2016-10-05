/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosahyokihonchosakatamen;

import jp.co.ndensan.reams.db.dbz.entity.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定調査票（基本調査）のBuilderクラスです。
 *
 * @reamsid_L DBE-0080-020 zuotao
 */
public class ChosahyoKihonchosaKatamenBuilder implements IChosahyoKihonchosaKatamenBuilder {

    private final ChosahyoKihonchosaKatamenEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor}
     */
    public ChosahyoKihonchosaKatamenBuilder(ChosahyoKihonchosaKatamenEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosahyoKihonchosaKatamenReportSource}
     */
    @Override
    public ChosahyoKihonchosaKatamenReportSource build() {
        return ReportEditorJoiner.from(new ChosahyoKihonchosaKatamenReportSource()).join(editor).buildSource();
    }
}
