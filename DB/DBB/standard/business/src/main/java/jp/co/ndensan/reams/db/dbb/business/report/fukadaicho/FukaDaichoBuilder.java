/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import jp.co.ndensan.reams.db.dbb.entity.report.fukadaicho.FukaDaichoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 */
class FukaDaichoBuilder implements IFukaDaichoBuilder{
    
    private final IFukaDaichoEditor headerEditor;
    private final IFukaDaichoEditor bodyEditor;

    public FukaDaichoBuilder(IFukaDaichoEditor headerEditor, IFukaDaichoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public FukaDaichoSource build() {
       return ReportEditorJoiner.from(new FukaDaichoSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
    
}
