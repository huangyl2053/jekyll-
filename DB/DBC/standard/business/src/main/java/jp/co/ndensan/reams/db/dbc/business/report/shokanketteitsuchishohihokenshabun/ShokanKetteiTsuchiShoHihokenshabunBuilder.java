/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoHihokenshabunReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）Builderクラスです。
 */
public class ShokanKetteiTsuchiShoHihokenshabunBuilder implements IShokanKetteiTsuchiShoHihokenshabunBuilder {

    private final IShokanKetteiTsuchiShoHihokenshabunEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShokanKetteiTsuchiShoHihokenshabunEditor}
     */
    public ShokanKetteiTsuchiShoHihokenshabunBuilder(IShokanKetteiTsuchiShoHihokenshabunEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanKetteiTsuchiShoHihokenshabunReportSource}
     */
    @Override
    public ShokanKetteiTsuchiShoHihokenshabunReportSource build() {
        return ReportEditorJoiner.from(new ShokanKetteiTsuchiShoHihokenshabunReportSource()).join(editor).buildSource();
    }
}
