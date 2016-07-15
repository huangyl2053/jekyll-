/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100013;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100013.FutanGendogakuKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 負担限度額決定通知書Builderクラスです。
 *
 * @reamsid_L DBD-3540-050 wangchao
 */
public class FutanGendogakuKetteiTsuchishoBuilderImpl implements IFutanGendogakuKetteiTsuchishoBuider {

    private final IFutanGendogakuKetteiTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IFutanGendogakuKetteiTsuchishoEditor}
     */
    FutanGendogakuKetteiTsuchishoBuilderImpl(IFutanGendogakuKetteiTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FutanGendogakuKetteiTsuchishoReportSource}
     */
    @Override
    public FutanGendogakuKetteiTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new FutanGendogakuKetteiTsuchishoReportSource()).join(bodyEditor).buildSource();
    }

}
