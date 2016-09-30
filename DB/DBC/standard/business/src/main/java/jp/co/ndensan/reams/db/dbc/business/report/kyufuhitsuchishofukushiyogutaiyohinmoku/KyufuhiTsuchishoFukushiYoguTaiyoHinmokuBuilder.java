/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishofukushiyogutaiyohinmoku;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）Builderクラスです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 *
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuBuilder implements IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuBuilder {

    private final IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor}
     */
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuBuilder(IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource}
     */
    @Override
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource build() {
        return ReportEditorJoiner.from(new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource()).join(editor).buildSource();
    }
}
