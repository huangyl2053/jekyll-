/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100029;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100029.OmutsuShoumeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * おむつ使用証明書Builderクラスです。
 *
 * @reamsid_L DBD-5780-030 donghj
 */
public class OmutsuShoumeishoBuilder implements IOmutsuShoumeishoBuilder {

    private final IOmutsuShoumeishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IOmutsuShoumeishoEditor}
     */
    OmutsuShoumeishoBuilder(IOmutsuShoumeishoEditor editor) {
        this.editor = editor;
    }

    @Override
    public OmutsuShoumeishoReportSource build() {
        return ReportEditorJoiner.from(new OmutsuShoumeishoReportSource()).join(editor).buildSource();
    }

}
