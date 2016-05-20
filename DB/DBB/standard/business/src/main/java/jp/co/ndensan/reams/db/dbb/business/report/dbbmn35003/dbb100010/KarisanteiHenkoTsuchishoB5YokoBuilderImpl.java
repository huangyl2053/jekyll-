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
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
class KarisanteiHenkoTsuchishoB5YokoBuilderImpl implements IKarisanteiHenkoTsuchishoB5YokoBuilder {

    private final IKarisanteiHenkoTsuchishoB5YokoEditor editor;

    public KarisanteiHenkoTsuchishoB5YokoBuilderImpl(IKarisanteiHenkoTsuchishoB5YokoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KarisanteiHenkoTsuchishoB5YokoReportSource build() {
        return ReportEditorJoiner.from(new KarisanteiHenkoTsuchishoB5YokoReportSource())
                .join(editor).buildSource();
    }

}
