/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100007;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100007.SashitomeShobunTsuchishoNigoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 差止処分通知書（２号被保険者用）Builderクラスです。
 *
 * @reamsid_L DBD-3640-080 b_liuyang2
 */
public class SashitomeShobunTsuchishoNigoBuilder implements ISashitomeShobunTsuchishoNigoBuilder {

    private final ISashitomeShobunTsuchishoNigoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link ISashitomeShobunTsuchishoNigoEditor}
     */
    SashitomeShobunTsuchishoNigoBuilder(ISashitomeShobunTsuchishoNigoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link SashitomeShobunTsuchishoNigoReportSource}
     */
    @Override
    public SashitomeShobunTsuchishoNigoReportSource build() {
        return ReportEditorJoiner.from(new SashitomeShobunTsuchishoNigoReportSource()).join(bodyEditor).buildSource();
    }
}
