/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書督促対象者一覧表Builderのインターフェースクラスです。
 *
 */
class NinteiChosaTokusokuTaishoshaIchiranhyoBulider implements INinteiChosaTokusokuTaishoshaIchiranhyoBuilder {

    INinteiChosaTokusokuTaishoshaIchiranhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INinteiChosaTokusokuTaishoshaIchiranhyoEditor}
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoBulider(INinteiChosaTokusokuTaishoshaIchiranhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NinteiChosaTokusokuTaishoshaIchiranhyoReportSource}
     */
    @Override
    public NinteiChosaTokusokuTaishoshaIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new NinteiChosaTokusokuTaishoshaIchiranhyoReportSource()).join(editor).buildSource();
    }

}
