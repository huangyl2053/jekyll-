/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】連帳 IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder
 *
 * @reamsid_L DBB-9110-070 wangjie2
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder implements IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder {

    private final IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor}
     */
    public KarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder(IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor editor) {
        this.editor = editor;
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource()).join(editor).buildSource();
    }

}
