/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami;

import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;

/**
 * 介護認定審査判定結果（鑑）Builderクラスです。
 *
 * @reamsid_L DBE-0170-030 wangkun
 */
public class HanteikekkaKagamiBuilder implements IHanteikekkaKagamiBuilder {

    private final HanteikekkaKagamiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link HanteikekkaKagamiEditor}
     */
    protected HanteikekkaKagamiBuilder(HanteikekkaKagamiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HanteiKekkaIchiranReportSource}
     */
    @Override
    public HanteikekkaKagamiReportSource build() {
        return editor.edit(new HanteikekkaKagamiReportSource());
    }
}
