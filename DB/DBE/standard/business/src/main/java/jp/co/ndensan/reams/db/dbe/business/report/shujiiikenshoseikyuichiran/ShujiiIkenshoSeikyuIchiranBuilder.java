/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoseikyuichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書作成料請求一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1390-180 suguangjun
 */
public class ShujiiIkenshoSeikyuIchiranBuilder implements IShujiiIkenshoSeikyuIchiranBuilder {

    private final IShujiiIkenshoSeikyuIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiIkenshoSeikyuIchiranEditor}
     */
    public ShujiiIkenshoSeikyuIchiranBuilder(IShujiiIkenshoSeikyuIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiIkenshoSeikyuIchiranReportSource}
     */
    @Override
    public ShujiiIkenshoSeikyuIchiranReportSource build() {
        return ReportEditorJoiner.from(new ShujiiIkenshoSeikyuIchiranReportSource()).join(editor).buildSource();
    }
}
