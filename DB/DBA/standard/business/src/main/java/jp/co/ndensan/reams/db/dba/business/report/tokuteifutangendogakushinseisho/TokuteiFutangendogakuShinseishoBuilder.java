/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.tokuteifutangendogakushinseisho.TokuteiFutangendogakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険特定負担限度額申請書Builderクラスです。
 */
public class TokuteiFutangendogakuShinseishoBuilder implements ITokuteiFutangendogakuShinseishoBuilder {

    private final ITokuteiFutangendogakuShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ITokuteiFutangendogakuShinseishoEditor}
     */
    public TokuteiFutangendogakuShinseishoBuilder(ITokuteiFutangendogakuShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KensayoNozeiShomeiShinsei}
     */
    @Override
    public TokuteiFutangendogakuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new TokuteiFutangendogakuShinseishoReportSource()).join(editor).buildSource();
    }
}
