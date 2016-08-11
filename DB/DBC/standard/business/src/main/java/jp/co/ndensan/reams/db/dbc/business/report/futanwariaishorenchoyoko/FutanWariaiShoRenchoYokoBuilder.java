/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishorenchoyoko;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishorenchoyoko.FutanWariaiShoRenchoYokoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100067_負担割合証（連帳・横）のBuilderです。
 *
 * @reamsid_L DBC-4990-060 pengxingyi
 */
public class FutanWariaiShoRenchoYokoBuilder implements IFutanWariaiShoRenchoYokoBuilder {

    private final IFutanWariaiShoRenchoYokoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IFutanWariaiShoRenchoYokoditor}
     */
    FutanWariaiShoRenchoYokoBuilder(IFutanWariaiShoRenchoYokoEditor editor) {
        this.editor = editor;
    }

    @Override
    public FutanWariaiShoRenchoYokoSource build() {
        return ReportEditorJoiner.from(new FutanWariaiShoRenchoYokoSource()).join(editor).buildSource();
    }
}
