/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyijinashi;

import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyijinashi.JigyoKogakuKetteiTsuchishoYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN43002_事業高額決定通知書 Builderするクラスです。
 *
 * @reamsid_L DBC-2000-100 lijian
 */
public class JigyoKogakuKetteiTsuchishoYijiNashiBuilder implements IJigyoKogakuKetteiTsuchishoYijiNashiBuilder {

    private final IJigyoKogakuKetteiTsuchishoYijiNashiEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IJigyoKogakuKetteiTsuchishoYijiNashiEditor
     */
    public JigyoKogakuKetteiTsuchishoYijiNashiBuilder(IJigyoKogakuKetteiTsuchishoYijiNashiEditor editor) {
        this.editor = editor;
    }

    @Override
    public JigyoKogakuKetteiTsuchishoYijiNashiSource build() {
        return ReportEditorJoiner.from(new JigyoKogakuKetteiTsuchishoYijiNashiSource()).join(editor).buildSource();
    }

}
