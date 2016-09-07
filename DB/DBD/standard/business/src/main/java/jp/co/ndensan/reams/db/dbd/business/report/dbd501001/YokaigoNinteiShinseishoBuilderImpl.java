/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd501001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd501001.YokaigoNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定申請書Builderクラスです。
 *
 * @reamsid_L DBD-1400-020 b_zhengs
 */
public class YokaigoNinteiShinseishoBuilderImpl implements IYokaigoNinteiShinseishoBuilder {

    private final IYokaigoNinteiShinseishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IYokaigoNinteiShinseishoEditor}
     */
    YokaigoNinteiShinseishoBuilderImpl(IYokaigoNinteiShinseishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigoNinteiShinseishoReportSource}
     */
    @Override
    public YokaigoNinteiShinseishoReportSource build() {
        return ReportEditorJoiner.from(new YokaigoNinteiShinseishoReportSource()).join(bodyEditor).buildSource();
    }

}
