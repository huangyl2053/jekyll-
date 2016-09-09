/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutariyutesuseikenshinichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 Builderクラスです。
 *
 * @reamsid_L DBC-2860-050 dangjingjing
 */
public class JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranBuilder
        implements IJutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranBuilder {

    private final IJutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranEditor}
     */
    protected JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranBuilder(IJutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource}
     */
    @Override
    public JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource build() {
        return ReportEditorJoiner.from(new JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource()).join(editor).buildSource();
    }
}
