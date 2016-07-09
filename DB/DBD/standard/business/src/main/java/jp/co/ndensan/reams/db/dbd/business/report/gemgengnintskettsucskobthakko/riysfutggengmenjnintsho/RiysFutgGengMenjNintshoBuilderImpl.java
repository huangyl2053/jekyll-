/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.riysfutggengmenjnintsho;

import jp.co.ndensan.reams.db.dbd.entity.report.riysfutggengmenjnintsho.RiyoshaFutangakuGengakuMenjoNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 利用者負担額減額・免除等認定証Builderクラスです。
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public class RiysFutgGengMenjNintshoBuilderImpl implements IRiysFutgGengMenjNintshoBuider {

    private final IRiysFutgGengMenjNintshoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IRiysFutgGengMenjNintshoEditor}
     */
    RiysFutgGengMenjNintshoBuilderImpl(IRiysFutgGengMenjNintshoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link RiyoshaFutangakuGengakuMenjoNinteishoReportSource}
     */
    @Override
    public RiyoshaFutangakuGengakuMenjoNinteishoReportSource build() {
        return ReportEditorJoiner.from(new RiyoshaFutangakuGengakuMenjoNinteishoReportSource())
                .join(bodyEditor).buildSource();
    }
}
