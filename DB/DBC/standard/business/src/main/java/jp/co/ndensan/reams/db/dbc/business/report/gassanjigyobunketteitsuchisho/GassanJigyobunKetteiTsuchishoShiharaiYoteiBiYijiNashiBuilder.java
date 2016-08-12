/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMNN2003_事業分高額合算支給決定通知書（単）Builderクラスです。
 *
 * （高額合算支給（不支給）決定通知書）支払予定日なし
 *
 * @reamsid_L DBC-4850-030 dongqianjing
 */
public class GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder implements
        IGassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder {

    private final IGassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor editor
     */
    GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder(IGassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiSource}
     */
    @Override
    public GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiSource build() {
        return ReportEditorJoiner.from(new GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiSource())
                .join(editor).buildSource();
    }

}
