/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoYokoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料減免決定通知書 B5横タイプBuilder
 */
public class GenmenKetteiTsuchiShoYokoBuilder implements IGenmenKetteiTsuchiShoYokoBuilder {

    private final IGenmenKetteiTsuchiShoYokoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor GenmenKetteiTsuchiShoTateEditor
     */
    public GenmenKetteiTsuchiShoYokoBuilder(IGenmenKetteiTsuchiShoYokoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KaigoHokenryoGenmenKetteiTsuchishoYokoSource build() {
        return ReportEditorJoiner.from(new KaigoHokenryoGenmenKetteiTsuchishoYokoSource()).join(editor).buildSource();
    }

}
