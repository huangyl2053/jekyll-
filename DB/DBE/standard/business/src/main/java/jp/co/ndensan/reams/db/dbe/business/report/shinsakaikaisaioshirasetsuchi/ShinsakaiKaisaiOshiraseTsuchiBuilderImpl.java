/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaikaisaioshirasetsuchi;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会開催のお知らせBuilderクラスです。
 *
 * @reamsid_L DBE-0150-110 lishengli
 */
class ShinsakaiKaisaiOshiraseTsuchiBuilderImpl implements IShinsakaiKaisaiOshiraseTsuchiBuilder {

    private final IShinsakaiKaisaiOshiraseTsuchiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsakaiKaisaiOshiraseTsuchiEditor}
     */
    public ShinsakaiKaisaiOshiraseTsuchiBuilderImpl(IShinsakaiKaisaiOshiraseTsuchiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsakaiKaisaiOshiraseTsuchiReportSource}
     */
    @Override
    public ShinsakaiKaisaiOshiraseTsuchiReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaiKaisaiOshiraseTsuchiReportSource()).join(editor).buildSource();
    }
}
