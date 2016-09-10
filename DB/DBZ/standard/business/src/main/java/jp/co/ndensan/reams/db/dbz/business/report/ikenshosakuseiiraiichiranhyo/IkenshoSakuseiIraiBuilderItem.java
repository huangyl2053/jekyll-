/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.db.dbz.entity.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書作成依頼一覧表Builderクラスです。
 *
 * @reamsid_L DBE-0080-090 zhangzhiming
 */
public class IkenshoSakuseiIraiBuilderItem implements IkenshoSakuseiIraiIchiranhyoBuilder {

    private final IkenshoSakuseiIraiIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IkenshoSakuseiIraiIchiranhyoEditor}
     */
    public IkenshoSakuseiIraiBuilderItem(IkenshoSakuseiIraiIchiranhyoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IkenshoSakuseiIraiIchiranhyoReportSource}
     */
    @Override
    public IkenshoSakuseiIraiIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new IkenshoSakuseiIraiIchiranhyoReportSource()).join(bodyEditor).buildSource();
    }
}
