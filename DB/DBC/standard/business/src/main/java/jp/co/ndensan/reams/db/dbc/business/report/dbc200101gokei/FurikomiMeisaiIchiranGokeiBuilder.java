/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200101gokei;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101gokei.FurikomiMeisaiIchiranGokeiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 振込明細一覧表（合計）Builderクラスです。
 *
 * @reamsid_L DBC-2180-040 b_liuyang2
 */
public class FurikomiMeisaiIchiranGokeiBuilder implements IFurikomiMeisaiIchiranGokeiBuilder {

    private final IFurikomiMeisaiIchiranGokeiEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IFurikomiMeisaiIchiranGokeiEditor}
     */
    FurikomiMeisaiIchiranGokeiBuilder(IFurikomiMeisaiIchiranGokeiEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FurikomiMeisaiIchiranGokeiReportSource}
     */
    @Override
    public FurikomiMeisaiIchiranGokeiReportSource build() {
        return ReportEditorJoiner.from(new FurikomiMeisaiIchiranGokeiReportSource()).join(bodyEditor).buildSource();
    }
}
