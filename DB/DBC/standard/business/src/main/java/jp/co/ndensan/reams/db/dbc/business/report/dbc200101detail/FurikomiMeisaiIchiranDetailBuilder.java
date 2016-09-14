/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200101detail;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101detail.FurikomiMeisaiIchiranDetailReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 振込明細一覧表（明細）Builderのクラスです。
 *
 * @reamsid_L DBC-2180-050 b_liuyang2
 */
public class FurikomiMeisaiIchiranDetailBuilder implements IFurikomiMeisaiIchiranDetailBuilder {

    private final IFurikomiMeisaiIchiranDetailEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IFurikomiMeisaiIchiranDetailEditor}
     */
    FurikomiMeisaiIchiranDetailBuilder(IFurikomiMeisaiIchiranDetailEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FurikomiMeisaiIchiranDetailReportSource}
     */
    @Override
    public FurikomiMeisaiIchiranDetailReportSource build() {
        return ReportEditorJoiner.from(new FurikomiMeisaiIchiranDetailReportSource()).join(bodyEditor).buildSource();
    }
}
