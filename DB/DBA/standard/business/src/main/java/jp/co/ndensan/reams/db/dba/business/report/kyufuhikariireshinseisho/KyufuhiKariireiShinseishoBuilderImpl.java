/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikariireshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikariireshinseisho.KyufuhiKariireiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険給付費借入申請書のEditorです。
 */
public class KyufuhiKariireiShinseishoBuilderImpl implements IKyufuhiKariireiShinseishoBuilder {

    private final IKyufuhiKariireiShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyufuhiKariireiShinseishoEditor}
     */
    public KyufuhiKariireiShinseishoBuilderImpl(IKyufuhiKariireiShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuhiKariireiShinseishoReportSource}
     */
    @Override
    public KyufuhiKariireiShinseishoReportSource build() {
        return ReportEditorJoiner.from(new KyufuhiKariireiShinseishoReportSource()).join(editor).buildSource();
    }
}
