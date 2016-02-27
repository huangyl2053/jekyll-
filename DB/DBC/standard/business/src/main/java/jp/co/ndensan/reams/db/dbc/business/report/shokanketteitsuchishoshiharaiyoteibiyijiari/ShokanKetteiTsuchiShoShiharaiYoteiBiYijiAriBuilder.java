/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 償還払い支給（不支給）決定通知書(支払予定日あり）Builderクラスです。
 */
public class ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder implements IShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder {

    private final IShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor}
     */
    public ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder(IShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource}
     */
    @Override
    public ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource build() {
        return ReportEditorJoiner.from(new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource()).join(editor).buildSource();
    }
}
