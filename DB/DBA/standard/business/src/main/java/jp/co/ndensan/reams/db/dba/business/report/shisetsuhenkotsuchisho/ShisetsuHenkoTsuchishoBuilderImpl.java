/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険住所地特例施設変更通知書Builderクラスです。
 */
class ShisetsuHenkoTsuchishoBuilderImpl implements IShisetsuHenkoTsuchishoBuilder {

    private final IShisetsuHenkoTsuchishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param Editor {@link ShisetsuHenkoTsuchishoEditor}
     */
    public ShisetsuHenkoTsuchishoBuilderImpl(IShisetsuHenkoTsuchishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShisetsuHenkoTsuchishoReportSource}
     */
    @Override
    public ShisetsuHenkoTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new ShisetsuHenkoTsuchishoReportSource()).join(editor).buildSource();
    }
}
