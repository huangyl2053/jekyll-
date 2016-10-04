/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosokatsuhyo;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyosokatsuhyo.KyufuKanrihyoSokatsuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 給付管理票総括票のクラスです。
 *
 * @reamsid_L DBC-2840-042 kanghongsong
 */
class KyufuKanrihyoSokatsuhyoBuilder implements IKyufuKanrihyoSokatsuhyoBuilder {

    private final IKyufuKanrihyoSokatsuhyoEditor headerEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKyufuKanrihyoSokatsuhyoEditor}
     */
    public KyufuKanrihyoSokatsuhyoBuilder(IKyufuKanrihyoSokatsuhyoEditor headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuKanrihyoSokatsuhyoReportSource}
     */
    @Override
    public KyufuKanrihyoSokatsuhyoReportSource build() {
        return ReportEditorJoiner.from(new KyufuKanrihyoSokatsuhyoReportSource()).join(headerEditor).buildSource();
    }

}
