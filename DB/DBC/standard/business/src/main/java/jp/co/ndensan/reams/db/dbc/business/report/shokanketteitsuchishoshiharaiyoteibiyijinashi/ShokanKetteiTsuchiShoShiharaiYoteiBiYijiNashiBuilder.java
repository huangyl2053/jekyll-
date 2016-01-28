/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijinashi;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 償還払い支給（不支給）決定通知書Builderクラスです。
 */
class ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder implements IShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder {

    private final IShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor}
     */
    public ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder(IShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource}
     */
    @Override
    public ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource build() {
        return ReportEditorJoiner.from(new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource()).join(editor).buildSource();
    }
}
