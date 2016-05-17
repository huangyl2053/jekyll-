/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryo.SonoTashiryoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定情報提供その他資料情報Builderクラスです。
 *
 * @reamsid_L DBE-0230-050 zhangzhiming
 */
class SonoTashiryoBuilder implements ISonoTashiryoBuilder {

    private final ISonoTashiryoBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ISonoTashiryoBodyEditor}
     */
    public SonoTashiryoBuilder(ISonoTashiryoBodyEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link SonoTashiryoReportSource}
     */
    @Override
    public SonoTashiryoReportSource build() {
        return ReportEditorJoiner.from(new SonoTashiryoReportSource()).join(bodyEditor).buildSource();
    }
}
