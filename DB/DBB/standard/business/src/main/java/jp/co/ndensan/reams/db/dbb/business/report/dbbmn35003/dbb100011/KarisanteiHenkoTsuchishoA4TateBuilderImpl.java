/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 仮算定額変更【A4縦タイプ】Builderクラスです。
 */
class KarisanteiHenkoTsuchishoA4TateBuilderImpl implements IKarisanteiHenkoTsuchishoA4TateBuilder {

    private final IKarisanteiHenkoTsuchishoA4TateEditor headerEditor;
    private final IKarisanteiHenkoTsuchishoA4TateEditor hyojiBodyEditor;

    public KarisanteiHenkoTsuchishoA4TateBuilderImpl(IKarisanteiHenkoTsuchishoA4TateEditor headerEditor,
            IKarisanteiHenkoTsuchishoA4TateEditor hyojiBodyEditor) {
        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;

    }

    @Override
    public KarisanteiHenkoTsuchishoA4TateReportSource build() {
        return ReportEditorJoiner.from(new KarisanteiHenkoTsuchishoA4TateReportSource()).join(headerEditor).join(hyojiBodyEditor).buildSource();
    }

}
