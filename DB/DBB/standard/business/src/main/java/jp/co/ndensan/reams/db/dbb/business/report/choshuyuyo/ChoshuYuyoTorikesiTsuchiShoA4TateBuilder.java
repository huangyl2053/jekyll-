/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.entity.report.choshuyuyo.KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料徴収猶予取消通知書 A4縦タイプBuilderするクラスです。
 *
 * @reamsid_L DBB-0740-070 chenaoqi
 */
public class ChoshuYuyoTorikesiTsuchiShoA4TateBuilder implements IChoshuYuyoTorikesiTsuchiShoA4TateBuilder {

    private final IChoshuYuyoTorikesiTsuchiShoA4TateEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IChoshuYuyoTorikesiTsuchiShoA4TateEditor
     */
    public ChoshuYuyoTorikesiTsuchiShoA4TateBuilder(IChoshuYuyoTorikesiTsuchiShoA4TateEditor editor) {
        this.editor = editor;
    }

    @Override
    public KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource build() {
        return ReportEditorJoiner.from(new KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource()).join(editor).buildSource();
    }
}
