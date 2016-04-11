/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMitorokuIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 転入転出未登録一覧表Builderクラスです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
class TennyuTenshutsuMiTorokuIchiranhyoBuilderImpl implements ITennyuTenshutsuMiTorokuIchiranhyoBuilder {

    private final ITennyuTenshutsuMiTorokuIchiranhyoEditor headerEditor;
    private final ITennyuTenshutsuMiTorokuIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link ITennyuTenshutsuMiTorokuIchiranhyoEditor}
     * @param hyojiIchiranEditor {@link ITennyuTenshutsuMiTorokuIchiranhyoEditor}
     */
    public TennyuTenshutsuMiTorokuIchiranhyoBuilderImpl(ITennyuTenshutsuMiTorokuIchiranhyoEditor headerEditor,
            ITennyuTenshutsuMiTorokuIchiranhyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TennyuTenshutsuMitorokuIchiranhyoReportSource}
     */
    @Override
    public TennyuTenshutsuMitorokuIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new TennyuTenshutsuMitorokuIchiranhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
