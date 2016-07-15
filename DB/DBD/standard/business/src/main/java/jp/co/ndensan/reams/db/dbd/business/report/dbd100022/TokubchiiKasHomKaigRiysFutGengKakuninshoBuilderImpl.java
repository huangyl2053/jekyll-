/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100022;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100022.TokubChiiKasRiysFutGengKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 利用者負担額減額・免除等認定証Builderクラスです。
 *
 * @reamsid_L DBD-3540-120 wangchao
 */
public class TokubchiiKasHomKaigRiysFutGengKakuninshoBuilderImpl implements ITokubchiiKasHomKaigRiysFutGengKakuninshoBuider {

    private final ITokubchiiKasHomKaigRiysFutGengKakuninshoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link ITokubchiiKasHomKaigRiysFutGengKakuninshoEditor}
     */
    TokubchiiKasHomKaigRiysFutGengKakuninshoBuilderImpl(ITokubchiiKasHomKaigRiysFutGengKakuninshoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokubChiiKasRiysFutGengKakuninshoReportSource}
     */
    @Override
    public TokubChiiKasRiysFutGengKakuninshoReportSource build() {
        return ReportEditorJoiner.from(new TokubChiiKasRiysFutGengKakuninshoReportSource()).join(bodyEditor).buildSource();
    }
}
