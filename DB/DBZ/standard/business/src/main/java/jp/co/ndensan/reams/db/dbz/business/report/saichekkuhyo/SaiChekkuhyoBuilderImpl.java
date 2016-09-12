/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo;

import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定調査票差異チェック票Builderのクラスです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoBuilderImpl implements ISaiChekkuhyoBuilder {

    private final ISaiChekkuhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ISaiChekkuhyoEditor}
     */
    public SaiChekkuhyoBuilderImpl(ISaiChekkuhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link SaiChekkuhyoReportSource}
     */
    @Override
    public SaiChekkuhyoReportSource build() {
        return ReportEditorJoiner.from(new SaiChekkuhyoReportSource()).join(editor).buildSource();
    }
}
