/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinyobihanteikinyuhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.iinyobihanteikinyuhyo.IinYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 委員用予備判定記入表のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-150 wangrenze
 */
public class IinYobihanteiKinyuhyoBuilder implements IIinYobihanteiKinyuhyoBuilder {

    private final IinYobihanteiKinyuhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIinYobihanteiKinyuhyoBuilder}
     */
    public IinYobihanteiKinyuhyoBuilder(IinYobihanteiKinyuhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IinYobihanteiKinyuhyoReportSource}
     */
    @Override
    public IinYobihanteiKinyuhyoReportSource build() {
        return ReportEditorJoiner.from(new IinYobihanteiKinyuhyoReportSource()).join(editor).buildSource();
    }
}
