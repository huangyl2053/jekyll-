/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.gemmentorikesitsuchisho.KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料減免取消通知書 A4縦タイプBuilderするクラスです。
 *
 * @reamsid_L DBB-0740-060 chenaoqi
 */
public class GemmenTorikesiTsuchiShoA4TateBuilder implements IGemmenTorikesiTsuchiShoA4TateBuilder {

    private final IGemmenTorikesiTsuchiShoA4TateEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IGemmenTorikesiTsuchiShoA4TateEditor
     */
    public GemmenTorikesiTsuchiShoA4TateBuilder(IGemmenTorikesiTsuchiShoA4TateEditor editor) {
        this.editor = editor;
    }

    @Override
    public KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource build() {
        return ReportEditorJoiner.from(new KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource()).join(editor).buildSource();
    }
}
