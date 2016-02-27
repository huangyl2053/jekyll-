/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist;

import jp.co.ndensan.reams.db.dbu.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 境界層管理マスタリストBuilderクラスです。
 */
class KyokaisoKanriMasterListBuilderImpl implements IKyokaisoKanriMasterListBuilder {

    private final IKyokaisoKanriMasterListEditor headerEditor;
    private final IKyokaisoKanriMasterListEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKyokaisoKanriMasterListEditor}
     * @param bodyEditor {@link IKyokaisoKanriMasterListEditor}
     */
    public KyokaisoKanriMasterListBuilderImpl(IKyokaisoKanriMasterListEditor headerEditor, IKyokaisoKanriMasterListEditor bodyEditor) {
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
