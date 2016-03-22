/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険住所地特例施設退所通知書Builderクラスです。
 */
class ShisetsuTaishoTsuchishoBuilderImpl implements IShisetsuTaishoTsuchishoBuilder {

    private final IShisetsuTaishoTsuchishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param Editor {@link IShisetsuTaishoTsuchishoEditor}
     */
    public ShisetsuTaishoTsuchishoBuilderImpl(IShisetsuTaishoTsuchishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShisetsuTaishoTsuchishoReportSource}
     */
    @Override
    public ShisetsuTaishoTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new ShisetsuTaishoTsuchishoReportSource()).join(editor).buildSource();
    }
}
