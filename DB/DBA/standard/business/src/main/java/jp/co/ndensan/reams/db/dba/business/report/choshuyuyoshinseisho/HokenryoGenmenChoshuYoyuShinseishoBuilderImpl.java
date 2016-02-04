/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.choshuyuyoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.choshuyuyoshinseisho.HokenryoGenmenChoshuYoyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料徴収猶予申請書Builderクラスです。
 */
public class HokenryoGenmenChoshuYoyuShinseishoBuilderImpl implements IHokenryoGenmenChoshuYoyuShinseishoBuilder {

    private final IHokenryoGenmenChoshuYoyuShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHokenryoGenmenChoshuYoyuShinseishoEditor}
     */
    public HokenryoGenmenChoshuYoyuShinseishoBuilderImpl(IHokenryoGenmenChoshuYoyuShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HokenryoGenmenChoshuYoyuShinseishoReportSource}
     */
    @Override
    public HokenryoGenmenChoshuYoyuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new HokenryoGenmenChoshuYoyuShinseishoReportSource()).join(editor).buildSource();
    }

}
