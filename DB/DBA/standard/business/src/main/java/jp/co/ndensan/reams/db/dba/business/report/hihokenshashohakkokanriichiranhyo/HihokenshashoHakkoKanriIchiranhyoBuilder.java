/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 被保険者証発行管理一覧表Builderクラスです。
 *
 * @reamsid_L DBA-0600-070 lishengli
 */
public class HihokenshashoHakkoKanriIchiranhyoBuilder implements IHihokenshashoHakkoKanriIchiranhyoBuilder {

    private final IHihokenshashoHakkoKanriIchiranhyoEditor headEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link IHihokenshashoHakkoKanriIchiranhyoEditor}
     */
    HihokenshashoHakkoKanriIchiranhyoBuilder(IHihokenshashoHakkoKanriIchiranhyoEditor headEditor) {
        this.headEditor = headEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HihokenshashoHakkoKanriIchiranhyoReportSource}
     */
    @Override
    public HihokenshashoHakkoKanriIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new HihokenshashoHakkoKanriIchiranhyoReportSource())
                .join(headEditor).buildSource();
    }
}
