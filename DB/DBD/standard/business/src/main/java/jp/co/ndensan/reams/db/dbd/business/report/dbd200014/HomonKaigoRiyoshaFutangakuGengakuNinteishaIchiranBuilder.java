/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200014;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200014.HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 訪問介護利用者負担額減額認定者リストBuilderクラスです。
 *
 * @reamsid_L DBD-3970-060 b_liuyang2
 */
public class HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranBuilder implements
        IHomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranBuilder {

    private final IHomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IHomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor}
     */
    HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranBuilder(IHomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource}
     */
    @Override
    public HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource build() {
        return ReportEditorJoiner.from(new HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource()).join(bodyEditor).buildSource();
    }
}
