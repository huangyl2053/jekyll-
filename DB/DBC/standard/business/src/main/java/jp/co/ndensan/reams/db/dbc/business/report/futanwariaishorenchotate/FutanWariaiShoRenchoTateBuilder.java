/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishorenchotate;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishorenchotate.FutanWariaiShoRenchoTateSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100065_負担割合証（カット紙）のBuilderです。
 *
 * @reamsid_L DBC-4990-040 pengxingyi
 */
public class FutanWariaiShoRenchoTateBuilder implements IFutanWariaiShoRenchoTateBuilder {

    private final IFutanWariaiShoRenchoTateEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IFutanWariaiShoRenchoTateditor}
     */
    FutanWariaiShoRenchoTateBuilder(IFutanWariaiShoRenchoTateEditor editor) {
        this.editor = editor;
    }

    @Override
    public FutanWariaiShoRenchoTateSource build() {
        return ReportEditorJoiner.from(new FutanWariaiShoRenchoTateSource()).join(editor).buildSource();
    }

}
