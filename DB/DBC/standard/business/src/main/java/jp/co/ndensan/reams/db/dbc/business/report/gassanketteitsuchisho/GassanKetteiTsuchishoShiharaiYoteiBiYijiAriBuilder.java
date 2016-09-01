/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.gassanketteitsuchisho.GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN63003_高額合算支給決定通知書（単）Builderクラスです。
 *
 * （高額合算支給（不支給）決定通知書）支払予定日あり
 *
 * @reamsid_L DBC-2310-035 chenyadong
 */
public class GassanKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder implements
        IGassanKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder {

    private final IGassanKetteiTsuchishoShiharaiYoteiBiYijiAriEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor editor
     */
    GassanKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder(IGassanKetteiTsuchishoShiharaiYoteiBiYijiAriEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource}
     */
    @Override
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource build() {
        return ReportEditorJoiner.from(new GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource())
                .join(editor).buildSource();
    }

}
