/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakukaishujizenshinseishoninkekka.JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 住宅改修事前申請承認結果通知書Builderクラスです。
 */
class JutakukaishuJizenShinseiShoninKekkaTsuchishoBuilder implements IJutakukaishuJizenShinseiShoninKekkaTsuchishoBuilder {

    private final IJutakukaishuJizenShinseiShoninKekkaTsuchishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJutakukaishuJizenShinseiShoninKekkaTsuchishoEditor}
     */
    public JutakukaishuJizenShinseiShoninKekkaTsuchishoBuilder(IJutakukaishuJizenShinseiShoninKekkaTsuchishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource}
     */
    @Override
    public JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource()).join(editor).buildSource();
    }
}
