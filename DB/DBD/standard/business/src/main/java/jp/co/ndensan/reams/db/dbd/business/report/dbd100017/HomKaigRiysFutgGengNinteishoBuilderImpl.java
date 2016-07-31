/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100017;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100017.HomKaigRiysFutgGengNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 訪問介護等利用者負担額減額認定証Builderクラスです。
 *
 * @reamsid_L DBD-3540-080 wangchao
 */
public class HomKaigRiysFutgGengNinteishoBuilderImpl implements IHomKaigRiysFutgGengNinteishoBuider {

    private final IHomKaigRiysFutgGengNinteishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IHomKaigRiysFutgGengNinteishoEditor}
     */
    HomKaigRiysFutgGengNinteishoBuilderImpl(IHomKaigRiysFutgGengNinteishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FutanGendogakuKetteiTsuchishoReportSource}
     */
    @Override
    public HomKaigRiysFutgGengNinteishoReportSource build() {
        return ReportEditorJoiner.from(new HomKaigRiysFutgGengNinteishoReportSource()).join(bodyEditor).buildSource();
    }

}
