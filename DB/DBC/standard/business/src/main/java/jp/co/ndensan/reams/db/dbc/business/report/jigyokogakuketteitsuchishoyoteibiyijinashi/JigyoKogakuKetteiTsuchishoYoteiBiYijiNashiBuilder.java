/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyoteibiyijinashi;

import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyoteibiyijinashi.JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 新総合事業・事業高額決定通知書（単）帳票Builder
 *
 * @reamsid_L DBC-4760-030 yebangqiang
 */
public class JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiBuilder implements IJigyoKogakuKetteiTsuchishoYoteiBiYijiNashiBuilder {

    private final IJigyoKogakuKetteiTsuchishoYoteiBiYijiNashiEditor editor;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param editor {@link IJigyoKogakuKetteiTsuchishoYoteiBiYijiNashiEditor}
     */
    public JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiBuilder(IJigyoKogakuKetteiTsuchishoYoteiBiYijiNashiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドするメソッド。
     *
     * @return {@link JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource}
     */
    @Override
    public JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource build() {
        return ReportEditorJoiner.from(new JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource()).join(editor).buildSource();
    }
}
