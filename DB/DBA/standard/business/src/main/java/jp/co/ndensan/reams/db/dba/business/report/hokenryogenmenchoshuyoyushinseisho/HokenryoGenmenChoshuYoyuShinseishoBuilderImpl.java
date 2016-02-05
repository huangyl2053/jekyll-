/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hokenryogenmenchoshuyoyushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.hokenryogenmenchoshuyoyushinseisho.HokenryoGenmenChoshuYoyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険料減免申請書Builderクラスです。
 */
public class HokenryoGenmenChoshuYoyuShinseishoBuilderImpl implements IHokenryoGenmenChoshuYoyuShinseishoBuilder {

    private final IHokenryoGenmenChoshuYoyuShinseishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IHokenryoGenmenChoshuYoyuShinseishoEditor}
     */
    HokenryoGenmenChoshuYoyuShinseishoBuilderImpl(IHokenryoGenmenChoshuYoyuShinseishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HokenryoGenmenChoshuYoyuShinseishoReportSource}
     */
    @Override
    public HokenryoGenmenChoshuYoyuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new HokenryoGenmenChoshuYoyuShinseishoReportSource())
                .join(bodyEditor).buildSource();
    }
}
