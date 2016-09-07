/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100006;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100006.SashitomeYokokuTsuchishoNigoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 差止予告通知書（２号被保険者用）Builderクラスです。
 *
 * @reamsid_L DBD-3640-070 b_liuyang2
 */
public class SashitomeYokokuTsuchishoNigoBuilder implements ISashitomeYokokuTsuchishoNigoBuilder {

    private final ISashitomeYokokuTsuchishoNigoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link ISashitomeYokokuTsuchishoNigoEditor}
     */
    SashitomeYokokuTsuchishoNigoBuilder(ISashitomeYokokuTsuchishoNigoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link SashitomeYokokuTsuchishoNigoReportSource}
     */
    @Override
    public SashitomeYokokuTsuchishoNigoReportSource build() {
        return ReportEditorJoiner.from(new SashitomeYokokuTsuchishoNigoReportSource()).join(bodyEditor).buildSource();
    }
}
