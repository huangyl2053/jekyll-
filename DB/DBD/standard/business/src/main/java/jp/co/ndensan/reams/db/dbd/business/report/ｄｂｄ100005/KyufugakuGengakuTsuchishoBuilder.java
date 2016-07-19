/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.ｄｂｄ100005;

import jp.co.ndensan.reams.db.dbd.entity.report.ｄｂｄ100005.KyufugakuGengakuTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 給付額減額通知書Builderクラスです。
 *
 * @reamsid_L DBD-3640-060 b_liuyang2
 */
public class KyufugakuGengakuTsuchishoBuilder implements IKyufugakuGengakuTsuchishoBuilder {

    private final IKyufugakuGengakuTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IKyufugakuGengakuTsuchishoEditor}
     */
    KyufugakuGengakuTsuchishoBuilder(IKyufugakuGengakuTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufugakuGengakuTsuchishoReportSource}
     */
    @Override
    public KyufugakuGengakuTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new KyufugakuGengakuTsuchishoReportSource())
                .join(bodyEditor).buildSource();
    }

}
