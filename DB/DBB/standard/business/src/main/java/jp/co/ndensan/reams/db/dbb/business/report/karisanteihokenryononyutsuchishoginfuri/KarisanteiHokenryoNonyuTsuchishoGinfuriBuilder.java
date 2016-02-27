/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】KarisanteiHokenryoNonyuTsuchishoGinfuriBuilder
 */
public class KarisanteiHokenryoNonyuTsuchishoGinfuriBuilder implements IKarisanteiHokenryoNonyuTsuchishoGinfuriBuilder {

    private final IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor editor;
    //private final IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compNinshoshaEditor;
    private final IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compSofubutsuAtesakiEditor;
    private final IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compSofubutsuAtesaki2Editor;
    private final IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compNofushoItemEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor}
     * @param compSofubutsuAtesakiEditor {@link IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor}
     * @param compSofubutsuAtesaki2Editor {@link IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor}
     * @param compNofushoItemEditor {@link IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor}
     */
    public KarisanteiHokenryoNonyuTsuchishoGinfuriBuilder(
            IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor editor,
            //IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compNinshoshaEditor,
            IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compSofubutsuAtesakiEditor,
            IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compSofubutsuAtesaki2Editor,
            IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compNofushoItemEditor) {
        this.editor = editor;
        //this.compNinshoshaEditor = compNinshoshaEditor;
        this.compNofushoItemEditor = compNofushoItemEditor;
        this.compSofubutsuAtesakiEditor = compSofubutsuAtesakiEditor;
        this.compSofubutsuAtesaki2Editor = compSofubutsuAtesaki2Editor;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoGinfuriSource build() {
        return ReportEditorJoiner.from(new KarisanteiHokenryoNonyuTsuchishoGinfuriSource())
                .join(editor)
                //.join(compNinshoshaEditor)
                .join(compNofushoItemEditor)
                .join(compSofubutsuAtesakiEditor).join(compSofubutsuAtesaki2Editor).buildSource();
    }

}
