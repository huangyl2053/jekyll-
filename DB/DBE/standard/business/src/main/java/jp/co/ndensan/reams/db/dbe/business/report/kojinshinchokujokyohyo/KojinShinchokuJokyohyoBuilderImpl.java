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
class KojinShinchokuJokyohyoBuilderImpl implements IKojinShinchokuJokyohyoBuilder {

    private final IKojinShinchokuJokyohyoEditor headerEditor;
    private final IKojinShinchokuJokyohyoEditor chousaEditor;
    private final IKojinShinchokuJokyohyoEditor shujiEditor;
    private final IKojinShinchokuJokyohyoEditor kojinshinEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKojinShinchokuJokyohyoEditor}
     * @param chousaEditor {@link IKojinShinchokuJokyohyoEditor}
     * @param shujiEditor {@link IKojinShinchokuJokyohyoEditor}
     * @param kojinshinEditor {@link IKojinShinchokuJokyohyoEditor}
     */
    public KojinShinchokuJokyohyoBuilderImpl(IKojinShinchokuJokyohyoEditor headerEditor, IKojinShinchokuJokyohyoEditor chousaEditor,
            IKojinShinchokuJokyohyoEditor shujiEditor, IKojinShinchokuJokyohyoEditor kojinshinEditor) {
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
