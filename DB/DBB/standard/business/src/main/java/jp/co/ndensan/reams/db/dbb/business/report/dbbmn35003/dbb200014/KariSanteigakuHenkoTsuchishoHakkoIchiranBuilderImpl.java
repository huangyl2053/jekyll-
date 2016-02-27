/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 仮算定額変更通知書発行一覧表Builderクラスです。
 */
class KariSanteigakuHenkoTsuchishoHakkoIchiranBuilderImpl implements IKariSanteigakuHenkoTsuchishoHakkoIchiranBuilder {

    private final IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor headerEditor;

    private final IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor hyojiBodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor}
     * @param hyojiBodyEditor {@link IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor}
     */
    public KariSanteigakuHenkoTsuchishoHakkoIchiranBuilderImpl(IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor headerEditor,
            IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor hyojiBodyEditor) {
        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;
    }

    @Override
    public KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource build() {
        return ReportEditorJoiner.from(new KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource()).
                join(headerEditor).join(hyojiBodyEditor).buildSource();
    }

}
