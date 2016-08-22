/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200004;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200004.ShakaiFukushiHojinReportSourse;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 社会福祉法人軽減認定者リストBuilderクラスです。
 *
 * @reamsid_L DBD-3830-060 tianyh
 */
public class ShakaiFukushiHojinKeigenBuilder implements IShakaiFukushiHojinKeigenBuilder {

    private final IShakaiFukushiHojinKeigenEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShakaiFukushiHojinKeigenEditor}
     */
    ShakaiFukushiHojinKeigenBuilder(IShakaiFukushiHojinKeigenEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return ShakaiFukushiHojinReportSourse
     */
    @Override
    public ShakaiFukushiHojinReportSourse build() {
        return ReportEditorJoiner.from(new ShakaiFukushiHojinReportSourse()).join(bodyEditor).buildSource();
    }
}
