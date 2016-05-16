/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】KarisanteiNonyuTsuchishoCVSKigotoBuilder
 *
 * @reamsid_L DBB-9110-070 wangjie2
 */
public class KarisanteiNonyuTsuchishoCVSKigotoBuilder implements IKarisanteiNonyuTsuchishoCVSKigotoBuilder {

    private final IKarisanteiNonyuTsuchishoCVSKigotoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiNonyuTsuchishoCVSKigotoEditor}
     */
    public KarisanteiNonyuTsuchishoCVSKigotoBuilder(IKarisanteiNonyuTsuchishoCVSKigotoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSKigotoSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSKigotoSource()).join(editor).buildSource();
    }

}
