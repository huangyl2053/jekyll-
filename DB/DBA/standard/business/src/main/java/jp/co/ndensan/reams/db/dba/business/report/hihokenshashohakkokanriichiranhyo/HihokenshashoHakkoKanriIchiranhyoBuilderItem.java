/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 被保険者証発行管理一覧表Builderクラスです。
 */
public class HihokenshashoHakkoKanriIchiranhyoBuilderItem implements IHihokenshashoHakkoKanriIchiranhyoBuilder {

    private final IHihokenshashoHakkoKanriIchiranhyoEditor headEditor;
    private final IHihokenshashoHakkoKanriIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link IHihokenshashoHakkoKanriIchiranhyoEditor}
     * @param bodyEditor {@link IHihokenshashoHakkoKanriIchiranhyoEditor}
     */
    HihokenshashoHakkoKanriIchiranhyoBuilderItem(IHihokenshashoHakkoKanriIchiranhyoEditor headEditor,
            IHihokenshashoHakkoKanriIchiranhyoEditor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HihokenshashoHakkoKanriIchiranhyoReportSource}
     */
    @Override
    public HihokenshashoHakkoKanriIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new HihokenshashoHakkoKanriIchiranhyoReportSource())
                .join(headEditor).join(bodyEditor).buildSource();
    }
}
