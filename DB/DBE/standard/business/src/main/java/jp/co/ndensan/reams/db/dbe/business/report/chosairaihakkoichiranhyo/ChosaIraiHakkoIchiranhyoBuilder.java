/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;

/**
 *
 * 認定調査依頼発行一覧表Builderクラスです。
 */
public class ChosaIraiHakkoIchiranhyoBuilder implements IChosaIraiHakkoIchiranhyoBuilder {

    private final IChosaIraiHakkoIchiranhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosaIraiHakkoIchiranhyoEditor}
     */
    protected ChosaIraiHakkoIchiranhyoBuilder(IChosaIraiHakkoIchiranhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosaIraiHakkoIchiranhyoItem}
     */
    @Override
    public ChosaIraiHakkoIchiranhyoReportSource build() {
        return editor.edit(new ChosaIraiHakkoIchiranhyoReportSource());
    }
}
