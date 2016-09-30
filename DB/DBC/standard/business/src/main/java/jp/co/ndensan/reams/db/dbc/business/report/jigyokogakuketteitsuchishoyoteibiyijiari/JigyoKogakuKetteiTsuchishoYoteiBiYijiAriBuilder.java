/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyoteibiyijiari;

import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyoteibiyijiari.JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 新総合事業・事業高額決定通知書（単）(支払予定日あり)帳票Builder
 *
 * @reamsid_L DBC-4760-040 yebangqiang
 */
public class JigyoKogakuKetteiTsuchishoYoteiBiYijiAriBuilder implements IJigyoKogakuKetteiTsuchishoYoteiBiYijiAriBuilder {

    private final IJigyoKogakuKetteiTsuchishoYoteiBiYijiAriEditor editor;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param editor {@link IJigyoKogakuKetteiTsuchishoYoteiBiYijiAriEditor}
     */
    public JigyoKogakuKetteiTsuchishoYoteiBiYijiAriBuilder(IJigyoKogakuKetteiTsuchishoYoteiBiYijiAriEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドするメソッド。
     *
     * @return {@link JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource}
     */
    @Override
    public JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource build() {
        return ReportEditorJoiner.from(new JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource()).join(editor).buildSource();
    }
}
