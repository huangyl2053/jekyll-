/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyokaisokanrimasterlist;

import jp.co.ndensan.reams.db.dba.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 境界層管理マスタリストBuilderクラスです。
 */
class KyokaisoKanriMasterListBuilderImpl implements KyokaisoKanriMasterListBuilder {

    private final KyokaisoKanriMasterListEditor headerEditor;
    private final KyokaisoKanriMasterListEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link KyokaisoKanriMasterListEditor}
     * @param bodyEditor {@link KyokaisoKanriMasterListEditor}
     */
    public KyokaisoKanriMasterListBuilderImpl(KyokaisoKanriMasterListEditor headerEditor, KyokaisoKanriMasterListEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyokaisoKanriMasterListReportSource}
     */
    @Override
    public KyokaisoKanriMasterListReportSource build() {
        return ReportEditorJoiner.from(new KyokaisoKanriMasterListReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
