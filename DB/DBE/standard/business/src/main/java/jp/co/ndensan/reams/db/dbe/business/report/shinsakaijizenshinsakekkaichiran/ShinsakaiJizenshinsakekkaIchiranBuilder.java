/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事前審査結果一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1640-040 zhaoyao
 */
public class ShinsakaiJizenshinsakekkaIchiranBuilder implements IShinsakaiJizenshinsakekkaIchiranBuilder {

    private final IShinsakaiJizenshinsakekkaIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsakaiJizenshinsakekkaIchiranEditor}
     */
    public ShinsakaiJizenshinsakekkaIchiranBuilder(IShinsakaiJizenshinsakekkaIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsakaiJizenshinsakekkaIchiranReportSource}
     */
    @Override
    public ShinsakaiJizenshinsakekkaIchiranReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaiJizenshinsakekkaIchiranReportSource()).join(editor).join(editor).buildSource();
    }

}
