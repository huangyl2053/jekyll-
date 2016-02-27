/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shoukanbaraijuryoininbaraishinseishochohyo;

import jp.co.ndensan.reams.db.dba.entity.report.shoukanbaraijuryoininbaraishinseishochohyo.ShokanharaiJuryoIninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険償還払受領委任払申請書Builderクラスです。
 */
public class ShokanharaiJuryoIninShinseishoBuilderImpl implements IShokanharaiJuryoIninShinseishoBuilder {

    private final IShokanharaiJuryoIninShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShokanharaiJuryoIninShinseishoEditor}
     */
    public ShokanharaiJuryoIninShinseishoBuilderImpl(IShokanharaiJuryoIninShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanharaiJuryoIninShinseishoReportSource}
     */
    @Override
    public ShokanharaiJuryoIninShinseishoReportSource build() {
        return ReportEditorJoiner.from(new ShokanharaiJuryoIninShinseishoReportSource()).join(editor).buildSource();
    }

}
