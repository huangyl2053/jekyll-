/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashokoufushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashokoufushinseisho.HihokenshashokoufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険被保険者証交付申請書（第2号被保険者）Builderクラスです。
 */
public class HihokenshashokoufuShinseishoBuilder implements IHihokenshashokoufuShinseishoBuilder {

    private final IHihokenshashokoufuShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHihokenshashokoufuShinseishoEditor}
     */
    public HihokenshashokoufuShinseishoBuilder(IHihokenshashokoufuShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KensayoNozeiShomeiShinsei}
     */
    @Override
    public HihokenshashokoufuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new HihokenshashokoufuShinseishoReportSource()).join(editor).buildSource();
    }
}
