/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishokattokami;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100065_負担割合証（カット紙）のBuilderです。
 *
 * @reamsid_L DBC-4990-040 pengxingyi
 */
public class FutanWariaiShoKattokamiBuilder implements IFutanWariaiShoKattokamiBuilder {

    private final IFutanWariaiShoKattokamiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IFutanWariaiShoKattokamiEditor}
     */
    FutanWariaiShoKattokamiBuilder(IFutanWariaiShoKattokamiEditor editor) {
        this.editor = editor;
    }

    @Override
    public FutanWariaiShoKattokamiSource build() {
        return ReportEditorJoiner.from(new FutanWariaiShoKattokamiSource()).join(editor).buildSource();
    }

}
