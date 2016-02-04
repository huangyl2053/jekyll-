/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashosaikoufushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashosaikoufushinseisho.HihokenshashoSaikoufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険被保険者証等再交付申請書Builderクラスです。
 */
public class HihokenshashoSaikoufuShinseishoBuilderImpl implements IHihokenshashoSaikoufuShinseishoBuilder {

    private final IHihokenshashoSaikoufuShinseishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IHihokenshashoSaikoufuShinseishoEditor}
     */
    HihokenshashoSaikoufuShinseishoBuilderImpl(IHihokenshashoSaikoufuShinseishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HihokenshashoSaikoufuShinseishoReportSource}
     */
    @Override
    public HihokenshashoSaikoufuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new HihokenshashoSaikoufuShinseishoReportSource())
                .join(bodyEditor).buildSource();
    }

}
