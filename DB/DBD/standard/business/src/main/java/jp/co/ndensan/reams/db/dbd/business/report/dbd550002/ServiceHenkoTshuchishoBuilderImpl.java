/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd550002.ServiceHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * サービス変更通知書Builderクラスです。
 *
 * @reamsid_L DBD-1430-040 b_zhengs
 */
public class ServiceHenkoTshuchishoBuilderImpl implements IServiceHenkoTshuchishoBuilder {

    private final IServiceHenkoTshuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IServiceHenkoTshuchishoEditor}
     */
    ServiceHenkoTshuchishoBuilderImpl(IServiceHenkoTshuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ServiceHenkoTshuchishoReportSource}
     */
    @Override
    public ServiceHenkoTshuchishoReportSource build() {
        return ReportEditorJoiner.from(new ServiceHenkoTshuchishoReportSource()).join(bodyEditor).buildSource();
    }

}
