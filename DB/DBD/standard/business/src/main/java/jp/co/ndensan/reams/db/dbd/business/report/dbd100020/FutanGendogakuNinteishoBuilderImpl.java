/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100020;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100020.FutanGendogakuNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 負担限度額認定証Builderクラスです。
 *
 * @reamsid_L DBD-3540-040 wangchao
 */
public class FutanGendogakuNinteishoBuilderImpl implements IFutanGendogakuNinteishoBuider {

    private final IFutanGendogakuNinteishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IFutanGendogakuNinteishoEditor}
     */
    FutanGendogakuNinteishoBuilderImpl(IFutanGendogakuNinteishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FutanGendogakuNinteishoReportSource}
     */
    @Override
    public FutanGendogakuNinteishoReportSource build() {
        return ReportEditorJoiner.from(new FutanGendogakuNinteishoReportSource()).join(bodyEditor).buildSource();
    }
}
