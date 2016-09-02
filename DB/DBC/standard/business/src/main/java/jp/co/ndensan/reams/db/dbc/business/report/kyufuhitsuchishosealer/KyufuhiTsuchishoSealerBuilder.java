/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishosealer;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100042_介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)Builderクラスです。
 *
 * @reamsid_L DBC-2280-070 lizhuoxuan
 *
 */
public class KyufuhiTsuchishoSealerBuilder implements IKyufuhiTsuchishoSealerBuilder {

    private final IKyufuhiTsuchishoSealerEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyufuhiTsuchishoSealerEditor}
     */
    public KyufuhiTsuchishoSealerBuilder(IKyufuhiTsuchishoSealerEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuhiTsuchishoSealerReportSource}
     */
    @Override
    public KyufuhiTsuchishoSealerReportSource build() {
        return ReportEditorJoiner.from(new KyufuhiTsuchishoSealerReportSource()).join(editor).buildSource();
    }
}
