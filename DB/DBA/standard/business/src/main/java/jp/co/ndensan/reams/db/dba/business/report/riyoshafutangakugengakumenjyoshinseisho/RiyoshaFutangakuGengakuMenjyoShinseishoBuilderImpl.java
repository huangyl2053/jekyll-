/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.riyoshafutangakugengakumenjyoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.riyoshafutangakugengakumenjyoshinseisho.RiyoshaFutangakuGengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険利用者負担額減額・免除申請書Builderクラスです。
 */
public class RiyoshaFutangakuGengakuMenjyoShinseishoBuilderImpl implements IRiyoshaFutangakuGengakuMenjyoShinseishoBuilder {

    private final IRiyoshaFutangakuGengakuMenjyoShinseishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IRiyoshaFutangakuGengakuMenjyoShinseishoEditor}
     */
    RiyoshaFutangakuGengakuMenjyoShinseishoBuilderImpl(IRiyoshaFutangakuGengakuMenjyoShinseishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link RiyoshaFutangakuGengakuMenjyoShinseishoReportSource}
     */
    @Override
    public RiyoshaFutangakuGengakuMenjyoShinseishoReportSource build() {
        return ReportEditorJoiner.from(new RiyoshaFutangakuGengakuMenjyoShinseishoReportSource())
                .join(bodyEditor).buildSource();
    }

}
