/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.gassanketteitsuchisho.GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN63003_高額合算支給決定通知書（単）Builderクラスです。
 *
 * @reamsid_L DBC-2310-035 chenyadong
 */
public class GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder implements
        IGassanKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder {

    private final IGassanKetteiTsuchishoShiharaiYoteiBiYijiNashiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor editor
     */
    GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder(IGassanKetteiTsuchishoShiharaiYoteiBiYijiNashiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource}
     */
    @Override
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource build() {
        return ReportEditorJoiner.from(new GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource())
                .join(editor).buildSource();
    }

}
