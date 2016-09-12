/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100009;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100009.RiysFutgGengMenjKettTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 利用者負担額減額･免除認定決定通知書Builderクラスです。
 *
 * @reamsid_L DBD-3540-070 wangchao
 */
public class RiysFutgGengMenjKettTsuchishoBuilderImpl implements IRiysFutgGengMenjKettTsuchishoBuider {

    private final IRiysFutgGengMenjKettTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IRiysFutgGengMenjKettTsuchishoEditor}
     */
    RiysFutgGengMenjKettTsuchishoBuilderImpl(IRiysFutgGengMenjKettTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link RiysFutgGengMenjKettTsuchishoReportSource}
     */
    @Override
    public RiysFutgGengMenjKettTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new RiysFutgGengMenjKettTsuchishoReportSource()).join(bodyEditor).buildSource();
    }
}
