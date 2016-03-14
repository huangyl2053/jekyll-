/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 主治医意見書作成依頼一覧表Builderクラスです。
 */
public class IkenshoSakuseiIraiBuilderItem implements IkenshoSakuseiIraiIchiranhyoBuilder {

    private final IkenshoSakuseiIraiIchiranhyoEditor headEditor;
    private final IkenshoSakuseiIraiIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link IkenshoSakuseiIraiIchiranhyoEditor}
     * @param bodyEditor {@link IkenshoSakuseiIraiIchiranhyoEditor}
     */
    public IkenshoSakuseiIraiBuilderItem(IkenshoSakuseiIraiIchiranhyoEditor headEditor,
            IkenshoSakuseiIraiIchiranhyoEditor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IkenshoSakuseiIraiIchiranhyoReportSource}
     */
    @Override
    public IkenshoSakuseiIraiIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new IkenshoSakuseiIraiIchiranhyoReportSource())
                .join(headEditor).join(bodyEditor).buildSource();
    }
}
