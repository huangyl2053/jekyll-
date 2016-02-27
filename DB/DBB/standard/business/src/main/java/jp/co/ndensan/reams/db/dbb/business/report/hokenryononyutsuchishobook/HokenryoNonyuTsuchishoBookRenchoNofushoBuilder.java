/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookRenchoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * @author wangjie2
 */
public class HokenryoNonyuTsuchishoBookRenchoNofushoBuilder implements IHokenryoNonyuTsuchishoBookRenchoNofushoBuilder {

    private final IHokenryoNonyuTsuchishoBookRenchoNofushoEditor editor;

    public HokenryoNonyuTsuchishoBookRenchoNofushoBuilder(IHokenryoNonyuTsuchishoBookRenchoNofushoEditor editor) {
        this.editor = editor;
    }

    @Override
    public HokenryoNonyuTsuchishoBookRenchoNofushoSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuTsuchishoBookRenchoNofushoSource()).join(editor).buildSource();
    }

}
