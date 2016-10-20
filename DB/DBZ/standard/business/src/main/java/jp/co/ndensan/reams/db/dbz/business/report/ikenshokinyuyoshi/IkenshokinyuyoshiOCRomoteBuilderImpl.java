/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi;

import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定主治医意見書記入用紙OCRー表Builderのクラスです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiOCRomoteBuilderImpl implements IIkenshokinyuyoshiOCRBuilder {

    private final IIkenshokinyuyoshiOCREditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIkenshokinyuyoshiOCREditor}
     */
    public IkenshokinyuyoshiOCRomoteBuilderImpl(IIkenshokinyuyoshiOCREditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IkenshokinyuyoshiReportSource}
     */
    @Override
    public IkenshokinyuyoshiReportSource build() {
        return ReportEditorJoiner.from(new IkenshokinyuyoshiReportSource()).join(editor).buildSource();
    }

}
