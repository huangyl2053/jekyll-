/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosayoteimitei;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosayoteimitei.NinteichosaYoteiMiteiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査予定未定者一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1390-110 dongyabin
 */
class NinteichosaYoteiMiteiBuilder implements INinteichosaYoteiMiteiBuilder {

    private final INinteichosaYoteiMiteiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INinteichosaYoteiMiteiEditor}
     */
    public NinteichosaYoteiMiteiBuilder(INinteichosaYoteiMiteiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NinteichosaYoteiMiteiReportSource}
     */
    @Override
    public NinteichosaYoteiMiteiReportSource build() {
        return ReportEditorJoiner.from(new NinteichosaYoteiMiteiReportSource()).join(editor).buildSource();
    }
}
