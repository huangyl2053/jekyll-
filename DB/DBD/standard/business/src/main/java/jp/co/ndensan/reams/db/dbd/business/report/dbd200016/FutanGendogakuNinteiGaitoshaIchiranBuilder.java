/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200016;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200001.FutanGendogakuNinteiGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 負担限度額認定者リストBuilderクラスです。
 *
 * @reamsid_L DBD-3960-060 donghj
 */
public class FutanGendogakuNinteiGaitoshaIchiranBuilder implements IFutanGendogakuNinteiGaitoshaIchiranBuilder {

    private final IFutanGendogakuNinteiGaitoshaIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IFutanGendogakuNinteiGaitoshaIchiranEditor}
     */
    FutanGendogakuNinteiGaitoshaIchiranBuilder(
            IFutanGendogakuNinteiGaitoshaIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public FutanGendogakuNinteiGaitoshaIchiranReportSource build() {
        return ReportEditorJoiner.from(new FutanGendogakuNinteiGaitoshaIchiranReportSource()).join(editor).buildSource();
    }

}
