/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表Builderクラスです。
 */
class TokuChoHeijunkaKariSanteigakuHakkoIchiranBuilderImpl implements ITokuChoHeijunkaKariSanteigakuHakkoIchiranBuilder {

    private final ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor headerEditor;
    private final ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor hyojiBodyEditor;

    public TokuChoHeijunkaKariSanteigakuHakkoIchiranBuilderImpl(ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor headerEditor,
            ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor hyojiBodyEditor) {
        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;
    }

    @Override
    public TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource build() {
        return ReportEditorJoiner.from(new TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource()).
                join(headerEditor).join(hyojiBodyEditor).buildSource();
    }

}
