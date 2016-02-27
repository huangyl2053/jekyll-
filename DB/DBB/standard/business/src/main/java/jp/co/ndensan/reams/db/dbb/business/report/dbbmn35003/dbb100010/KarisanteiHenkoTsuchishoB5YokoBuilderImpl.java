/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 仮算定額変更【B5横タイプ】Builderクラスです。
 */
class KarisanteiHenkoTsuchishoB5YokoBuilderImpl implements IKarisanteiHenkoTsuchishoB5YokoBuilder {

    private final IKarisanteiHenkoTsuchishoB5YokoEditor headerEditor;
    private final IKarisanteiHenkoTsuchishoB5YokoEditor hyojiBodyEditor;

    public KarisanteiHenkoTsuchishoB5YokoBuilderImpl(IKarisanteiHenkoTsuchishoB5YokoEditor headerEditor,
            IKarisanteiHenkoTsuchishoB5YokoEditor hyojiBodyEditor) {
        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link     public KarisanteiHenkoTsuchishoB5YokoReportSource build() {
     * }
     */
    @Override
    public KarisanteiHenkoTsuchishoB5YokoReportSource build() {
        return ReportEditorJoiner.from(new KarisanteiHenkoTsuchishoB5YokoReportSource()).join(headerEditor).join(hyojiBodyEditor).buildSource();
    }

}
