/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 要介護認定区分変更申請書のBuilderクラスです。
 */
public class YokaigoNinteikbnHenkoShinseishoItemBuilder
        implements IYokaigoNinteikbnHenkoShinseishoBuilder {

    private final IYokaigoNinteikbnHenkoShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IYokaigoNinteikbnHenkoShinseishoEditor}
     */
    public YokaigoNinteikbnHenkoShinseishoItemBuilder(IYokaigoNinteikbnHenkoShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigoNinteikbnHenkoShinseishoReportSource}
     */
    @Override
    public YokaigoNinteikbnHenkoShinseishoReportSource build() {
        return ReportEditorJoiner.from(new YokaigoNinteikbnHenkoShinseishoReportSource()).join(editor).buildSource();
    }
}
