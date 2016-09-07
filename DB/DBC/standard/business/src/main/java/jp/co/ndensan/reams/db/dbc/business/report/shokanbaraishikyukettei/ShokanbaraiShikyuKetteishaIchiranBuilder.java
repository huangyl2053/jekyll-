/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyukettei;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyuketteishaichiran.ShokanbaraiShikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 償還払支給決定者一覧表Builderクラスです。
 *
 * @reamsid_L DBC-0980-480 sunhui
 */
public class ShokanbaraiShikyuKetteishaIchiranBuilder implements IShokanbaraiShikyuKetteishaIchiranBuilder {

    private final IShokanbaraiShikyuKetteishaIchiranEditor headerEditor;
    private final IShokanbaraiShikyuKetteishaIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor IShokanbaraiShikyuKetteishaIchiranEditor
     * @param bodyEditor IShokanbaraiShikyuKetteishaIchiranEditor
     */
    public ShokanbaraiShikyuKetteishaIchiranBuilder(
            IShokanbaraiShikyuKetteishaIchiranEditor headerEditor,
            IShokanbaraiShikyuKetteishaIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanbaraiShikyuKetteishaIchiranSource}
     */
    @Override
    public ShokanbaraiShikyuKetteishaIchiranSource build() {
        return ReportEditorJoiner.from(new ShokanbaraiShikyuKetteishaIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
