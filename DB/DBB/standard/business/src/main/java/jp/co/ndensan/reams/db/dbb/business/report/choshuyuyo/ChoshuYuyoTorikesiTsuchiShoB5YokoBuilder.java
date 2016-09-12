/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.entity.report.choshuyuyo.KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料徴収猶予取消通知書 B5横タイプBuilderするクラスです。
 *
 * @reamsid_L DBB-0740-070 chenaoqi
 */
public class ChoshuYuyoTorikesiTsuchiShoB5YokoBuilder implements IChoshuYuyoTorikesiTsuchiShoB5YokoBuilder {

    private final IChoshuYuyoTorikesiTsuchiShoB5YokoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IChoshuYuyoTorikesiTsuchiShoB5YokoEditor
     */
    public ChoshuYuyoTorikesiTsuchiShoB5YokoBuilder(IChoshuYuyoTorikesiTsuchiShoB5YokoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource build() {
        return ReportEditorJoiner.from(new KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource()).join(editor).buildSource();
    }
}
