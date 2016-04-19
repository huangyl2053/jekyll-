/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoTateSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料減免決定通知書 A4縦タイプBuilderクラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
public class GenmenKetteiTsuchiShoTateBuilder implements IGenmenKetteiTsuchiShoTateBuilder {

    private final IGenmenKetteiTsuchiShoTateEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor GenmenKetteiTsuchiShoTateEditor
     */
    public GenmenKetteiTsuchiShoTateBuilder(IGenmenKetteiTsuchiShoTateEditor editor) {
        this.editor = editor;
    }

    @Override
    public KaigoHokenryoGenmenKetteiTsuchishoTateSource build() {
        return ReportEditorJoiner.from(new KaigoHokenryoGenmenKetteiTsuchishoTateSource()).join(editor).buildSource();
    }
}
