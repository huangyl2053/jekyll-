/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.nenreikeikyubetsuriyojyokyo;

import jp.co.ndensan.reams.db.dbc.entity.report.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 年齢階級別利用状況作成 Builderクラスです。
 *
 * @reamsid_L DBE-3470-040 dongyabin
 */
public class NenreiKeikyuBetsuRiyoJyokyoBuilder implements INenreiKeikyuBetsuRiyoJyokyoBuilder {

    private final INenreiKeikyuBetsuRiyoJyokyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INenreiKeikyuBetsuRiyoJyokyoEditor}
     */
    NenreiKeikyuBetsuRiyoJyokyoBuilder(INenreiKeikyuBetsuRiyoJyokyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NenreiKeikyuBetsuRiyoJyokyoSource}
     */
    @Override
    public NenreiKeikyuBetsuRiyoJyokyoReportSource build() {
        return ReportEditorJoiner.from(new NenreiKeikyuBetsuRiyoJyokyoReportSource()).join(editor).buildSource();
    }
}
