/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 認定調査スケジュール表(調査員)Builderクラスです。
 */
class ChosaSchedulehyoTyousayinBuilderImpl implements IChosaSchedulehyoTyousayinBuilder {

    private final IChosaSchedulehyoTyousayinEditor headerEditor;
    private final IChosaSchedulehyoTyousayinEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IChosaSchedulehyoTyousayinEditor}
     * @param bodyEditor {@link IChosaSchedulehyoTyousayinEditor}
     */
    public ChosaSchedulehyoTyousayinBuilderImpl(IChosaSchedulehyoTyousayinEditor headerEditor, IChosaSchedulehyoTyousayinEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosaSchedulehyoTyousayinReportSource}
     */
    @Override
    public ChosaSchedulehyoTyousayinReportSource build() {
        return ReportEditorJoiner.from(new ChosaSchedulehyoTyousayinReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
