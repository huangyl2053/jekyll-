/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranReportSource;

/**
 * 要介護認定・要支援認定等申請者一覧表Builderクラスです。
 */
public class YokaigoYoshienShinseiIchiranBuilderImpl implements IYokaigoYoshienShinseiIchiranBuilder {

    private final IYokaigoYoshienShinseiIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IYokaigoYoshienShinseiIchiranEditor}
     */
    protected YokaigoYoshienShinseiIchiranBuilderImpl(IYokaigoYoshienShinseiIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link YokaigoYoshienShinseiIchiranReportSource}
     */
    @Override
    public YokaigoYoshienShinseiIchiranReportSource build() {
        return editor.edit(new YokaigoYoshienShinseiIchiranReportSource());
    }
}
