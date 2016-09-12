/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.gemmentorikesitsuchisho.KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料減免取消通知書 B5横タイプBuilderするクラスです。
 *
 * @reamsid_L DBB-0740-060 chenaoqi
 */
public class GemmenTorikesiTsuchiShoB5YokoBuilder implements IGemmenTorikesiTsuchiShoB5YokoBuilder {

    private final IGemmenTorikesiTsuchiShoB5YokoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IGemmenTorikesiTsuchiShoA4TateEditor
     */
    public GemmenTorikesiTsuchiShoB5YokoBuilder(IGemmenTorikesiTsuchiShoB5YokoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource build() {
        return ReportEditorJoiner.from(new KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource()).join(editor).buildSource();
    }
}
