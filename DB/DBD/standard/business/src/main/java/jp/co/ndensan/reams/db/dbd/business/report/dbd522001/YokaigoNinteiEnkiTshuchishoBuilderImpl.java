/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd522001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd522001.YokaigoNinteiEnkiTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定延期通知書タイトルのBuilderクラスです。
 *
 * @reamsid_L DBD-1410-030 chenxin
 */
class YokaigoNinteiEnkiTshuchishoBuilderImpl implements IYokaigoNinteiEnkiTshuchishoBuilder {

    private IYokaigoNinteiEnkiTshuchishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor
     */
    public YokaigoNinteiEnkiTshuchishoBuilderImpl(IYokaigoNinteiEnkiTshuchishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link }　YokaigoNinteiEnkiTshuchishoReportSource
     */
    @Override
    public YokaigoNinteiEnkiTshuchishoReportSource build() {
        return ReportEditorJoiner.from(new YokaigoNinteiEnkiTshuchishoReportSource()).join(editor).buildSource();
    }
}
