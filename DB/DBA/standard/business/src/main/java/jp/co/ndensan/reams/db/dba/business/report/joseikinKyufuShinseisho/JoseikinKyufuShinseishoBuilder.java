/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.joseikinKyufuShinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.joseikinKyufuShinseisho.JoseikinKyufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険助成金給付申請書Builderクラスです。
 */
public class JoseikinKyufuShinseishoBuilder implements IJoseikinKyufuShinseishoBuilder {

    private final IJoseikinKyufuShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJoseikinKyufuShinseishoEditor}
     */
    public JoseikinKyufuShinseishoBuilder(IJoseikinKyufuShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KensayoNozeiShomeiShinsei}
     */
    @Override
    public JoseikinKyufuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new JoseikinKyufuShinseishoReportSource()).join(editor).buildSource();
    }
}
