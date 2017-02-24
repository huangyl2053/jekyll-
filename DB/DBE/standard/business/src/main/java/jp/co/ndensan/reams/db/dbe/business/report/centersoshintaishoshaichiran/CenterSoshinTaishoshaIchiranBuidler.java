/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.centersoshintaishoshaichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.centersoshintaishoshaichiran.CenterSoshinTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 完了処理・センター送信のBuidlerです。
 *
 * @reamsid_L DBE_1520_DBEMN91010 n8466
 */
class CenterSoshinTaishoshaIchiranBuidler implements ICenterSoshinTaishoshaIchiranBuidler {

    private final ICenterSoshinTaishoshaIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ICenterSoshinTaishoshaIchiranEditor}
     */
    public CenterSoshinTaishoshaIchiranBuidler(ICenterSoshinTaishoshaIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link CenterSoshinTaishoshaIchiranReportSource}
     */
    @Override
    public CenterSoshinTaishoshaIchiranReportSource build() {
        return ReportEditorJoiner.from(new CenterSoshinTaishoshaIchiranReportSource()).join(editor).buildSource();
    }
}
