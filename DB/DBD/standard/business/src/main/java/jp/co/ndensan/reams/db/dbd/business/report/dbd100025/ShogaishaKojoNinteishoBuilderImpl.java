/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100025;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 障がい者控除対象者認定証のBuilderです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class ShogaishaKojoNinteishoBuilderImpl implements IShogaishaKojoNinteishoBuilder {

    private final IShogaishaKojoNinteishoEditor shogaishaKojoNinteishoEditorImpl;

    public ShogaishaKojoNinteishoBuilderImpl(IShogaishaKojoNinteishoEditor shogaishaKojoNinteishoEditorImpl) {
        this.shogaishaKojoNinteishoEditorImpl = shogaishaKojoNinteishoEditorImpl;
    }

    @Override
    public NinteishoJohoReportSource build() {
        return ReportEditorJoiner.from(new NinteishoJohoReportSource())
                .join(shogaishaKojoNinteishoEditorImpl).buildSource();
    }

}
