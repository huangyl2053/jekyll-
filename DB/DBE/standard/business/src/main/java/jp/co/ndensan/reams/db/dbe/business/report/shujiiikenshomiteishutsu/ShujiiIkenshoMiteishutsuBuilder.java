/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshomiteishutsu;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiteishutsu.ShujiiIkenshoMiteishutsuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書未提出者一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1390-150 suguangjun
 */
class ShujiiIkenshoMiteishutsuBuilder implements IShujiiIkenshoMiteishutsuBuilder {

    private final IShujiiIkenshoMiteishutsuEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiIkenshoMiteishutsuEditor}
     */
    public ShujiiIkenshoMiteishutsuBuilder(IShujiiIkenshoMiteishutsuEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiIkenshoMiteishutsuReportSource}
     */
    @Override
    public ShujiiIkenshoMiteishutsuReportSource build() {
        return ReportEditorJoiner.from(new ShujiiIkenshoMiteishutsuReportSource()).join(editor).buildSource();
    }
}
