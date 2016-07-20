/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100004;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100004.TainoHokenryoKojoTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 滞納保険料控除通知書Builderクラスです。
 *
 * @reamsid_L DBD-3640-050 b_liuyang2
 */
public class TainoHokenryoKojoTsuchishoBuilder implements ITainoHokenryoKojoTsuchishoBuilder {

    private final ITainoHokenryoKojoTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link ITainoHokenryoKojoTsuchishoEditor}
     */
    TainoHokenryoKojoTsuchishoBuilder(ITainoHokenryoKojoTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TainoHokenryoKojoTsuchishoReportSource}
     */
    @Override
    public TainoHokenryoKojoTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new TainoHokenryoKojoTsuchishoReportSource()).join(bodyEditor).buildSource();
    }

}
