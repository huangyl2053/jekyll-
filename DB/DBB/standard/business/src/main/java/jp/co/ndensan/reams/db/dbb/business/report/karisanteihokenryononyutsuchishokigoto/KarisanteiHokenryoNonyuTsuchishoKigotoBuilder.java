/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（仮算定）【期毎タイプ】帳票 KarisanteiHokenryoNonyuTsuchishoKigotoBuilder
 */
public class KarisanteiHokenryoNonyuTsuchishoKigotoBuilder implements IKarisanteiHokenryoNonyuTsuchishoKigotoBuilder {

    private final IKarisanteiHokenryoNonyuTsuchishoKigotoEditor editor;
    private final IKarisanteiHokenryoNonyuTsuchishoKigotoEditor compRyoshushoEditor;
    private final IKarisanteiHokenryoNonyuTsuchishoKigotoEditor compNofushoEditor;
    private final IKarisanteiHokenryoNonyuTsuchishoKigotoEditor compNinshoshaEditor;
    //private final IKarisanteiHokenryoNonyuTsuchishoKigotoEditor compSofubutsuAtesakiEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiHokenryoNonyuTsuchishoKigotoEditor}
     * @param compRyoshushoEditor {@link IKarisanteiHokenryoNonyuTsuchishoKigotoEditor}
     * @param compNofushoEditor {@link IKarisanteiHokenryoNonyuTsuchishoKigotoEditor}
     * @param compNinshoshaEditor {@link IKarisanteiHokenryoNonyuTsuchishoKigotoEditor}
     */
    public KarisanteiHokenryoNonyuTsuchishoKigotoBuilder(
            IKarisanteiHokenryoNonyuTsuchishoKigotoEditor editor,
            IKarisanteiHokenryoNonyuTsuchishoKigotoEditor compRyoshushoEditor,
            IKarisanteiHokenryoNonyuTsuchishoKigotoEditor compNofushoEditor,
            IKarisanteiHokenryoNonyuTsuchishoKigotoEditor compNinshoshaEditor
    //IKarisanteiHokenryoNonyuTsuchishoKigotoEditor compSofubutsuAtesakiEditor
    ) {
        this.editor = editor;
        this.compRyoshushoEditor = compRyoshushoEditor;
        this.compNofushoEditor = compNofushoEditor;
        this.compNinshoshaEditor = compNinshoshaEditor;
        //this.compSofubutsuAtesakiEditor = compSofubutsuAtesakiEditor;
    }

    /**
     * 帳票ソースビルド
     *
     * @return {@link KarisanteiHokenryoNonyuTsuchishoKigotoSource}
     */
    @Override
    public KarisanteiHokenryoNonyuTsuchishoKigotoSource build() {
        return ReportEditorJoiner.from(new KarisanteiHokenryoNonyuTsuchishoKigotoSource())
                .join(editor).join(compRyoshushoEditor).join(compNofushoEditor).join(compNinshoshaEditor)
                //.join(compSofubutsuAtesakiEditor)
                .buildSource();
    }

}
