/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200017;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200017.JigyoshoMukeShakaiFukushiHojinKeigenReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業所向け社会福祉法人軽減対象者一覧表Builderクラスです。
 *
 * @reamsid_L DBD-3810-040 donghj
 */
public class JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranBuilder implements
        IJigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranBuilder {

    private final IJigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranEditor}
     */
    JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranBuilder(
            IJigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public JigyoshoMukeShakaiFukushiHojinKeigenReportSource build() {
        return ReportEditorJoiner.from(new JigyoshoMukeShakaiFukushiHojinKeigenReportSource()).join(editor).buildSource();
    }

}
