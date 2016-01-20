/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定個人進捗状況票Builderクラスです。
 */
class KojinShinchokuJokyohyoBuilderImpl implements KojinShinchokuJokyohyoBuilder {

    private final KojinShinchokuJokyohyoEditor headerEditor;
    private final KojinShinchokuJokyohyoEditor chousaEditor;
    private final KojinShinchokuJokyohyoEditor shujiEditor;
    private final KojinShinchokuJokyohyoEditor kojinshinEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link KojinShinchokuJokyohyoEditor}
     * @param chousaEditor {@link KojinShinchokuJokyohyoEditor}
     * @param shujiEditor {@link KojinShinchokuJokyohyoEditor}
     * @param kojinshinEditor {@link KojinShinchokuJokyohyoEditor}
     */
    public KojinShinchokuJokyohyoBuilderImpl(KojinShinchokuJokyohyoEditor headerEditor, KojinShinchokuJokyohyoEditor chousaEditor,
            KojinShinchokuJokyohyoEditor shujiEditor, KojinShinchokuJokyohyoEditor kojinshinEditor) {
        this.headerEditor = headerEditor;
        this.chousaEditor = chousaEditor;
        this.shujiEditor = shujiEditor;
        this.kojinshinEditor = kojinshinEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KojinShinchokuJokyohyoReportSource}
     */
    @Override
    public KojinShinchokuJokyohyoReportSource build() {
        return ReportEditorJoiner.from(new KojinShinchokuJokyohyoReportSource()).join(headerEditor).join(chousaEditor).
                join(shujiEditor).join(kojinshinEditor).buildSource();
    }
}
