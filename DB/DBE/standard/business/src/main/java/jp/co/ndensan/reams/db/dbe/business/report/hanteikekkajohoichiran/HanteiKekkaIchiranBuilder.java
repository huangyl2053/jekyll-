/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkajohoichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkajohoichiran.HanteiKekkaIchiranA4ReportSource;

/**
 * 要介護認定判定結果一覧Builderクラスです。
 *
 * @reamsid_L DBE-0170-020 wangkun
 */
public class HanteiKekkaIchiranBuilder implements IHanteiKekkaIchiranBuilder {

    private final HanteiKekkaIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link HanteiKekkaIchiranEditor}
     */
    protected HanteiKekkaIchiranBuilder(HanteiKekkaIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HanteiKekkaIchiranReportSource}
     */
    @Override
    public HanteiKekkaIchiranA4ReportSource build() {
        return editor.edit(new HanteiKekkaIchiranA4ReportSource());
    }
}
