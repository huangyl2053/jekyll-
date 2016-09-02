/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishodetail;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険給付費通知書(２ページ目以降)Builderクラスです。
 *
 * @reamsid_L DBC-2280-050 lizhuoxuan
 *
 */
public class KyufuhiTsuchishoDetailBuilder implements IKyufuhiTsuchishoDetailBuilder {

    private final IKyufuhiTsuchishoDetailEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyufuhiTsuchishoDetailEditor}
     */
    public KyufuhiTsuchishoDetailBuilder(IKyufuhiTsuchishoDetailEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuhiTsuchishoDetailReportSource}
     */
    @Override
    public KyufuhiTsuchishoDetailReportSource build() {
        return ReportEditorJoiner.from(new KyufuhiTsuchishoDetailReportSource()).join(editor).buildSource();
    }
}
