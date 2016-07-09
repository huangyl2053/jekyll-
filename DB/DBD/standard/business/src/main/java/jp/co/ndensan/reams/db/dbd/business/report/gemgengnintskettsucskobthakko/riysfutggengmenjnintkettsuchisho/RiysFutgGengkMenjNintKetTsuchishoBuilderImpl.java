/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.riysfutggengmenjnintkettsuchisho;

import jp.co.ndensan.reams.db.dbd.entity.report.riysfutggengmenjnintkettsuchisho.RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 利用者負担額減額･免除認定決定通知書Builderクラスです。
 *
 * @reamsid_L DBD-3540-070 wangchao
 */
public class RiysFutgGengkMenjNintKetTsuchishoBuilderImpl implements IRiysFutgGengkMenjNintKetTsuchishoBuider {

    private final IRiysFutgGengkMenjNintKetTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IRiysFutgGengkMenjNintKetTsuchishoEditor}
     */
    RiysFutgGengkMenjNintKetTsuchishoBuilderImpl(IRiysFutgGengkMenjNintKetTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource}
     */
    @Override
    public RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource())
                .join(bodyEditor).buildSource();
    }
}
