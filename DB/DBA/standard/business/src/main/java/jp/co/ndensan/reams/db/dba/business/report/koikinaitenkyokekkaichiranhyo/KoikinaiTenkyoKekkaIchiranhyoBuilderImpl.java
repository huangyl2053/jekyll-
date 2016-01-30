/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 広域内転居結果一覧表Builderクラスです。
 */
class KoikinaiTenkyoKekkaIchiranhyoBuilderImpl implements IKoikinaiTenkyoKekkaIchiranhyoBuilder {

    private final IKoikinaiTenkyoKekkaIchiranhyoEditor headerEditor;
    private final IKoikinaiTenkyoKekkaIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKoikinaiTenkyoKekkaIchiranhyoEditor}
     * @param bodyEditor {@link IKoikinaiTenkyoKekkaIchiranhyoEditor}
     */
    public KoikinaiTenkyoKekkaIchiranhyoBuilderImpl(
            IKoikinaiTenkyoKekkaIchiranhyoEditor headerEditor,
            IKoikinaiTenkyoKekkaIchiranhyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KoikinaiTenkyoKekkaIchiranhyoReportSource}
     */
    @Override
    public KoikinaiTenkyoKekkaIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new KoikinaiTenkyoKekkaIchiranhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
