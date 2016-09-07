/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd550001.YokaigoNinteiKyakkaTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定却下通知書Builderクラスです。
 *
 * @reamsid_L DBD-1430-060 b_zhengs
 */
public class YokaigoNinteiKyakkaTshuchishoBuilderImpl implements IYokaigoNinteiKyakkaTshuchishoBuilder {

    private final IYokaigoNinteiKyakkaTshuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IYokaigoNinteiKyakkaTshuchishoEditor}
     */
    YokaigoNinteiKyakkaTshuchishoBuilderImpl(IYokaigoNinteiKyakkaTshuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigoNinteiKyakkaTshuchishoReportSource}
     */
    @Override
    public YokaigoNinteiKyakkaTshuchishoReportSource build() {
        return ReportEditorJoiner.from(new YokaigoNinteiKyakkaTshuchishoReportSource()).join(bodyEditor).buildSource();
    }

}
