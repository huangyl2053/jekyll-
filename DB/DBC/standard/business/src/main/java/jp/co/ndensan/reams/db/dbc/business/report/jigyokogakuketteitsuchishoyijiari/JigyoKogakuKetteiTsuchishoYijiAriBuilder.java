/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyijiari;

import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyijiari.JigyoKogakuKetteiTsuchishoYijiAriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN43002_事業高額決定通知書(支払予定日あり） Builderするクラスです。
 *
 * @reamsid_L DBC-2000-090 lijian
 */
public class JigyoKogakuKetteiTsuchishoYijiAriBuilder implements IJigyoKogakuKetteiTsuchishoYijiAriBuilder {

    private final IJigyoKogakuKetteiTsuchishoYijiAriEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IJigyoKogakuKetteiTsuchishoYijiAriEditor
     */
    public JigyoKogakuKetteiTsuchishoYijiAriBuilder(IJigyoKogakuKetteiTsuchishoYijiAriEditor editor) {
        this.editor = editor;
    }

    @Override
    public JigyoKogakuKetteiTsuchishoYijiAriSource build() {
        return ReportEditorJoiner.from(new JigyoKogakuKetteiTsuchishoYijiAriSource()).join(editor).buildSource();
    }

}
