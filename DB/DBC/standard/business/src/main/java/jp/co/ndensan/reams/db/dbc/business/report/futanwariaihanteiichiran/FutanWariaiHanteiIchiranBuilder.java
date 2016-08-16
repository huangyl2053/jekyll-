/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaihanteiichiran.FutanWariaiHanteiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 負担割合判定一覧表のBodyBuilderクラスです。
 *
 * @reamsid_L DBC-4980-040 yuanzhenxia
 */
public class FutanWariaiHanteiIchiranBuilder implements IFutanWariaiHanteiIchiranBuilder {

    private final IFutanWariaiHanteiIchiranEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IFutanWariaiHanteiIchiranEditor
     */
    public FutanWariaiHanteiIchiranBuilder(IFutanWariaiHanteiIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public FutanWariaiHanteiIchiranSource build() {
        return ReportEditorJoiner.from(new FutanWariaiHanteiIchiranSource())
                .join(editor).buildSource();
    }

}
