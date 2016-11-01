/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakairiyusakuteseikenshin;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakairiyusakuteseikenshin.JutakuKaishuRSTSKSReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 Builderクラスです。
 *
 * @reamsid_L DBC-2860-040 dangjingjing
 */
public class JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoBuilder implements IJutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoBuilder {

    private final IJutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoEditor}
     */
    protected JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoBuilder(IJutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JutakuKaishuRSTSKSReportSource}
     */
    @Override
    public JutakuKaishuRSTSKSReportSource build() {
        return ReportEditorJoiner.from(new JutakuKaishuRSTSKSReportSource()).join(editor).buildSource();
    }

}
