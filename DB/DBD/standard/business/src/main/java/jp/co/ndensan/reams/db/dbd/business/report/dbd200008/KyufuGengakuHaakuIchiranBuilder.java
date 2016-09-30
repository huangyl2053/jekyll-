/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200008;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 給付額減額把握リストBuilderクラスです。
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
public class KyufuGengakuHaakuIchiranBuilder implements IKyufuGengakuHaakuIchiranBuilder {

    private final IKyufuGengakuHaakuIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IKyufuGengakuHaakuIchiranEditor}
     */
    KyufuGengakuHaakuIchiranBuilder(IKyufuGengakuHaakuIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuGengakuHaakuIchiranReportSource}
     */
    @Override
    public KyufuGengakuHaakuIchiranReportSource build() {
        return ReportEditorJoiner.from(new KyufuGengakuHaakuIchiranReportSource()).join(bodyEditor).buildSource();
    }
}
