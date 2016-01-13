/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist;

import jp.co.ndensan.reams.db.dba.entity.report.jukirendotorokulist.JukiRendoTorokuListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 住基連動登録リストBuilderクラスです
 */
class JuKiRendoTorokuListBuilderImpl implements IJuKiRendoTorokuListBuilder {

    private final IJukiRendoTorokuListEditor headerEditor;
    private final IJukiRendoTorokuListEditor hyojiBodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IJukiRendoTorokuListEditor}
     * @param hyojiBodyEditor {@link IJukiRendoTorokuListEditor}
     */
    public JuKiRendoTorokuListBuilderImpl(IJukiRendoTorokuListEditor headerEditor, IJukiRendoTorokuListEditor hyojiBodyEditor) {
        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */

    @Override
    public JukiRendoTorokuListReportSource build() {
        return ReportEditorJoiner.from(new JukiRendoTorokuListReportSource()).join(headerEditor).join(hyojiBodyEditor).buildSource();
    }

}
