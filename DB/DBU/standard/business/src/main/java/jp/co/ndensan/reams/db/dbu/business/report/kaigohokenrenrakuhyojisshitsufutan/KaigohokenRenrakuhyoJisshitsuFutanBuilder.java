/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyojisshitsufutan;

import jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyojisshitsufutan.KaigohokenRenrakuhyoJisshitsuFutanReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険連絡票_実質負担軽減者用Builderクラスです。
 *
 * @reamsid_L DBA-1290-060 wangrenze
 */
public class KaigohokenRenrakuhyoJisshitsuFutanBuilder implements IKaigohokenRenrakuhyoJisshitsuFutanBuilder {

    private final IKaigohokenRenrakuhyoJisshitsuFutanEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKaigohokenRenrakuhyoJisshitsuFutanEditor}
     */
    public KaigohokenRenrakuhyoJisshitsuFutanBuilder(IKaigohokenRenrakuhyoJisshitsuFutanEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KaigohokenRenrakuhyoJisshitsuFutanReportSource}
     */
    @Override
    public KaigohokenRenrakuhyoJisshitsuFutanReportSource build() {
        return ReportEditorJoiner.from(new jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyojisshitsufutan.KaigohokenRenrakuhyoJisshitsuFutanReportSource()).join(editor).buildSource();
    }
}
