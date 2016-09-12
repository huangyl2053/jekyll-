/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijikofree;

import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定調査票（特記事項）フリー様式Builderのクラスです。
 *
 * @reamsid_L DBE-0080-050 xuyannan
 */
public class ChosahyoTokkijikoFreeBuilderImpl implements IChosahyoTokkijikoFreeBuilder {

    private final IChosahyoTokkijikoFreeEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosahyoTokkijikoFreeEditor}
     */
    public ChosahyoTokkijikoFreeBuilderImpl(IChosahyoTokkijikoFreeEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosahyoTokkijikoReportSource}
     */
    @Override
    public ChosahyoTokkijikoReportSource build() {
        return ReportEditorJoiner.from(new ChosahyoTokkijikoReportSource()).join(editor).buildSource();
    }
}
