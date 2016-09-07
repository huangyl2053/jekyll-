/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550003;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd550003.YokaigodoHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護度変更通知書Builderクラスです。
 *
 * @reamsid_L DBD-1430-050 b_zhengs
 */
public class YokaigodoHenkoTshuchishoBuilderImpl implements IYokaigodoHenkoTshuchishoBuilder {

    private final IYokaigodoHenkoTshuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IYokaigodoHenkoTshuchishoEditor}
     */
    YokaigodoHenkoTshuchishoBuilderImpl(IYokaigodoHenkoTshuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigodoHenkoTshuchishoReportSource}
     */
    @Override
    public YokaigodoHenkoTshuchishoReportSource build() {
        return ReportEditorJoiner.from(new YokaigodoHenkoTshuchishoReportSource()).join(bodyEditor).buildSource();
    }

}
