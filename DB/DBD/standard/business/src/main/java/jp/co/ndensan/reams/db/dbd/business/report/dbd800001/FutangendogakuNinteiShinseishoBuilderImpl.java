/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800001.FutangendogakuNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険負担限度額認定申請書Builderクラスです。
 *
 * @reamsid_L DBA-0540-690 suguangjun
 */
public class FutangendogakuNinteiShinseishoBuilderImpl implements IFutangendogakuNinteiShinseishoBuilder {

    private final IFutangendogakuNinteiShinseishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IFutangendogakuNinteiShinseishoEditor}
     */
    FutangendogakuNinteiShinseishoBuilderImpl(IFutangendogakuNinteiShinseishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FutangendogakuNinteiShinseishoReportSource}
     */
    @Override
    public FutangendogakuNinteiShinseishoReportSource build() {
        return ReportEditorJoiner.from(new FutangendogakuNinteiShinseishoReportSource())
                .join(bodyEditor).buildSource();
    }

}
