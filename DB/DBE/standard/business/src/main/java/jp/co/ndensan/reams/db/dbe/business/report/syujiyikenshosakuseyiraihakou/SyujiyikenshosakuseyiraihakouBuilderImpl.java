/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou;

import jp.co.ndensan.reams.db.dbe.entity.report.source.syujiyikensho.IkenshoSakuseiIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書作成依頼発行一覧表Builderクラスです。
 */
class SyujiyikenshosakuseyiraihakouBuilderImpl implements SyujiyikenshosakuseyiraihakouBuilder {

    private final SyujiyikenshosakuseyiraihakouEditor headerEditor;
    private final SyujiyikenshosakuseyiraihakouEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link SyujiyikenshosakuseyiraihakouEditor}
     * @param hyojiIchiranEditor {@link SyujiyikenshosakuseyiraihakouEditor}
     */
    public SyujiyikenshosakuseyiraihakouBuilderImpl(SyujiyikenshosakuseyiraihakouEditor headerEditor, SyujiyikenshosakuseyiraihakouEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public IkenshoSakuseiIraiHakkoIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new IkenshoSakuseiIraiHakkoIchiranhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
