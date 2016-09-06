/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishocover;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishocover.KyufuhiTsuchishoCoverReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100041_介護保険給付費通知書Builderクラスです。
 *
 * @reamsid_L DBC-2280-040 lizhuoxuan
 *
 */
public class KyufuhiTsuchishoCoverBuilder implements IKyufuhiTsuchishoCoverBuilder {

    private final IKyufuhiTsuchishoCoverEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyufuhiTsuchishoCoverEditor}
     */
    public KyufuhiTsuchishoCoverBuilder(IKyufuhiTsuchishoCoverEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuhiTsuchishoCoverReportSource}
     */
    @Override
    public KyufuhiTsuchishoCoverReportSource build() {
        return ReportEditorJoiner.from(new KyufuhiTsuchishoCoverReportSource()).join(editor).buildSource();
    }
}
