/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100011;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100011.HomKaigRiysFutgGengKettTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 訪問介護等利用者負担額減額決定通知書Builderクラスです。
 *
 * @reamsid_L DBD-3540-090 wangchao
 */
public class HomKaigRiysFutgGengKettTsuchishoBuilderImpl implements IHomKaigRiysFutgGengKettTsuchishoBuider {

    private final IHomKaigRiysFutgGengKettTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IHomKaigRiysFutgGengKettTsuchishoEditor}
     */
    HomKaigRiysFutgGengKettTsuchishoBuilderImpl(IHomKaigRiysFutgGengKettTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HomKaigRiysFutgGengKettTsuchishoReportSource}
     */
    @Override
    public HomKaigRiysFutgGengKettTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new HomKaigRiysFutgGengKettTsuchishoReportSource()).join(bodyEditor).buildSource();
    }
}
