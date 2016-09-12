/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100015;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100015.RiysFutgGengMenjNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 利用者負担額減額・免除等認定証Builderクラスです。
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public class RiysFutgGengMenjNinteishoBuilderImpl implements IRiysFutgGengMenjNinteishoBuider {

    private final IRiysFutgGengMenjNinteishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IRiysFutgGengMenjNinteishoEditor}
     */
    RiysFutgGengMenjNinteishoBuilderImpl(IRiysFutgGengMenjNinteishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link RiysFutgGengMenjNinteishoReportSource}
     */
    @Override
    public RiysFutgGengMenjNinteishoReportSource build() {
        return ReportEditorJoiner.from(new RiysFutgGengMenjNinteishoReportSource()).join(bodyEditor).buildSource();
    }
}
