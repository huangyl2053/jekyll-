/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100065_負担割合証Builder
 *
 * @reamsid_L DBC-5010-030 surun
 */
public class FutanWariaiShoBuilder implements IFutanWariaiShoBuilder {

    private final IFutanWariaiShoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IFutanWariaiShoEditor
     */
    public FutanWariaiShoBuilder(IFutanWariaiShoEditor editor) {
        this.editor = editor;
    }

    @Override
    public FutanWariaiShoSource build() {
        return ReportEditorJoiner.from(new FutanWariaiShoSource())
                .join(editor).buildSource();
    }

}
