/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishokattokami;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100065_負担割合証（カット紙）のBuilderです。
 *
 * @reamsid_L DBC-4990-040 pengxingyi
 */
public class FutanWariaiShoBuilder implements IFutanWariaiShoBuilder {

    private final IFutanWariaiShoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IFutanWariaiShoEditor}
     */
    FutanWariaiShoBuilder(IFutanWariaiShoEditor editor) {
        this.editor = editor;
    }

    @Override
    public FutanWariaiShoSource build() {
        return ReportEditorJoiner.from(new FutanWariaiShoSource()).join(editor).buildSource();
    }

}
