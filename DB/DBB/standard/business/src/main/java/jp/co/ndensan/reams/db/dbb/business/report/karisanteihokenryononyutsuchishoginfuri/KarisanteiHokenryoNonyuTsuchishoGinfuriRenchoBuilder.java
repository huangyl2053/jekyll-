/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】連帳 KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoBuilder
 *
 * @reamsid_L DBB-9110-030 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoBuilder implements IKarisanteiHokenryoNonyuTsuchishoGinfuriRenchoBuilder {

    private final IKarisanteiHokenryoNonyuTsuchishoGinfuriRenchoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiHokenryoNonyuTsuchishoGinfuriRenchoEditor}
     */
    public KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoBuilder(IKarisanteiHokenryoNonyuTsuchishoGinfuriRenchoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource build() {
        return ReportEditorJoiner.from(new KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource())
                .join(editor).buildSource();
    }

}
