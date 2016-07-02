/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）発行一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0710-050 yebangqiang
 */
class KariNonyuTsuchishoHakkoIchiranBuilder implements IKariNonyuTsuchishoHakkoIchiranBuilder {

    private final IKariNonyuTsuchishoHakkoIchiranEditor headerEditor;
    private final IKariNonyuTsuchishoHakkoIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor headerEditor
     * @param bodyEditor bodyEditor
     */
    public KariNonyuTsuchishoHakkoIchiranBuilder(IKariNonyuTsuchishoHakkoIchiranEditor headerEditor,
            IKariNonyuTsuchishoHakkoIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KariNonyuTsuchishoHakkoIchiranSource}
     */
    @Override
    public KariNonyuTsuchishoHakkoIchiranSource build() {
        return ReportEditorJoiner.from(new KariNonyuTsuchishoHakkoIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
