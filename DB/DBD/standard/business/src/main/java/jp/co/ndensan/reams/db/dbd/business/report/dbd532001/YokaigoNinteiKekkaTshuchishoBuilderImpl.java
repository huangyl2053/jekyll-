/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd532001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd532001.YokaigoNinteiKekkaTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定結果通知書Builderクラスです。
 *
 * @reamsid_L DBD-1430-030 b_zhengs
 */
public class YokaigoNinteiKekkaTshuchishoBuilderImpl implements IYokaigoNinteiKekkaTshuchishoBuilder {

    private final IYokaigoNinteiKekkaTshuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IYokaigoNinteiKekkaTshuchishoEditor}
     */
    YokaigoNinteiKekkaTshuchishoBuilderImpl(IYokaigoNinteiKekkaTshuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigoNinteiKekkaTshuchishoReportSource}
     */
    @Override
    public YokaigoNinteiKekkaTshuchishoReportSource build() {
        return ReportEditorJoiner.from(new YokaigoNinteiKekkaTshuchishoReportSource()).join(bodyEditor).buildSource();
    }

}
