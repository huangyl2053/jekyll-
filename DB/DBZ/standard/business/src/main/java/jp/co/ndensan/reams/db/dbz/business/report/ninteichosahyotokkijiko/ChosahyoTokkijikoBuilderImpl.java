/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定調査票（特記事項）Builderのクラスです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoBuilderImpl implements IChosahyoTokkijikoBuilder {

    private final IChosahyoTokkijikoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosahyoTokkijikoEditor}
     */
    public ChosahyoTokkijikoBuilderImpl(IChosahyoTokkijikoEditor editor) {
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
