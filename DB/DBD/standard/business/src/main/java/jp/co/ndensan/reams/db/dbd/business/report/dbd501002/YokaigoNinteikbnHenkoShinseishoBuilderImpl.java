/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd501002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd501002.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定区分変更申請書Builderクラスです。
 *
 * @reamsid_L DBD-1400-030 b_zhengs
 */
public class YokaigoNinteikbnHenkoShinseishoBuilderImpl implements IYokaigoNinteikbnHenkoShinseishoBuilder {

    private final IYokaigoNinteikbnHenkoShinseishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IYokaigoNinteikbnHenkoShinseishoEditor}
     */
    YokaigoNinteikbnHenkoShinseishoBuilderImpl(IYokaigoNinteikbnHenkoShinseishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigoNinteikbnHenkoShinseishoReportSource}
     */
    @Override
    public YokaigoNinteikbnHenkoShinseishoReportSource build() {
        return ReportEditorJoiner.from(new YokaigoNinteikbnHenkoShinseishoReportSource()).join(bodyEditor).buildSource();
    }

}
