/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.business.report.dbd200002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd00002.RiyoshaFutangakuGemmenGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 利用負担額減額免除認定証Builderのクラスです。
 *
 * @reamsid_L DBD-3980-050 x_youyj
 */
public class RiyoshaFutangakuGemmenGaitoshaIchiranBuilderImpl implements IRiyoshaFutangakuGemmenGaitoshaIchiranBuilder {
    

    private final IRiyoshaFutangakuGemmenGaitoshaIchiranEditor editor;

    RiyoshaFutangakuGemmenGaitoshaIchiranBuilderImpl(IRiyoshaFutangakuGemmenGaitoshaIchiranEditor editor) {
        this.editor = editor;
    }
    @Override
    public RiyoshaFutangakuGemmenGaitoshaIchiranReportSource build() {
        return ReportEditorJoiner.from(new RiyoshaFutangakuGemmenGaitoshaIchiranReportSource())
                .join(editor).buildSource();
    }
}
