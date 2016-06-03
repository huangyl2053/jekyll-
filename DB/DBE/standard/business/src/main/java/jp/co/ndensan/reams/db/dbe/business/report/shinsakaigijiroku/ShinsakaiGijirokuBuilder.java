/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaigijiroku.ShinsakaiGijirokuReportSource;

/**
 * 介護認定審査会議事録Builderクラスです。
 *
 * @reamsid_L DBE-0170-040 wangkun
 */
public class ShinsakaiGijirokuBuilder implements IShinsakaiGijirokuBuilder {

    private final ShinsakaiGijirokuEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link HanteikekkaKagamiEditor}
     */
    protected ShinsakaiGijirokuBuilder(ShinsakaiGijirokuEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HanteiKekkaIchiranReportSource}
     */
    @Override
    public ShinsakaiGijirokuReportSource build() {
        return editor.edit(new ShinsakaiGijirokuReportSource());
    }
}
