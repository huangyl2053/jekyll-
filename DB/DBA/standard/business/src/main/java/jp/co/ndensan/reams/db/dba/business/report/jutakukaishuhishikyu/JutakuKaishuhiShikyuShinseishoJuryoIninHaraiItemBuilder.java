/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jutakukaishuhishikyu;

import jp.co.ndensan.reams.db.dba.entity.report.jutakukaishuhishikyu.JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書のBuilderクラスです。
 */
public class JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItemBuilder
        implements IJutakuKaishuhiShikyuShinseishoJuryoIninHaraiBuilder {

    private final IJutakuKaishuhiShikyuShinseishoJuryoIninHaraiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJutakuKaishuhiShikyuShinseishoJuryoIninHaraiEditor}
     */
    public JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItemBuilder(IJutakuKaishuhiShikyuShinseishoJuryoIninHaraiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource}
     */
    @Override
    public JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource build() {
        return ReportEditorJoiner.from(new JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource()).join(editor).buildSource();
    }
}
