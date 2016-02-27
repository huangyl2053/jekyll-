/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoSealerReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）Builderクラスです。
 */
public class ShokanKetteiTsuchiShoSealerBuilder implements IShokanKetteiTsuchiShoSealerBuilder {

    private final IShokanKetteiTsuchiShoSealerEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor}
     */
    public ShokanKetteiTsuchiShoSealerBuilder(IShokanKetteiTsuchiShoSealerEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanKetteiTsuchiShoSealerReportSource}
     */
    @Override
    public ShokanKetteiTsuchiShoSealerReportSource build() {
        return ReportEditorJoiner.from(new ShokanKetteiTsuchiShoSealerReportSource()).join(editor).buildSource();
    }
}
