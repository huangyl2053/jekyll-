/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 処理確認リストのBuilderクラスです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
class ShoriKekkaKakuninListBuilder implements IShoriKekkaKakuninListBuidler {

    private final IShoriKekkaKakuninListEditor headerEditor;
    private final IShoriKekkaKakuninListEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IShoriKekkaKakuninListEditor}
     * @param bodyEditor {@link IShoriKekkaKakuninListEditor}
     */
    public ShoriKekkaKakuninListBuilder(IShoriKekkaKakuninListEditor headerEditor, IShoriKekkaKakuninListEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShoriKekkaKakuninListReportSource}
     */
    @Override
    public ShoriKekkaKakuninListReportSource build() {
        return ReportEditorJoiner.from(new ShoriKekkaKakuninListReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
