/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo;

import jp.co.ndensan.reams.db.dbe.entity.report.johoteikyoshiryo.JohoTeikyoShiryoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医医療機関・主治医一覧表Builderクラスです。
 */
class JohoTeikyoShiryoBuilder implements IJohoTeikyoShiryoBuilder {

    private final IJohoTeikyoShiryoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJohoTeikyoShiryoEditor}
     */
    public JohoTeikyoShiryoBuilder(IJohoTeikyoShiryoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JohoTeikyoShiryoReportSource}
     */
    @Override
    public JohoTeikyoShiryoReportSource build() {
        return ReportEditorJoiner.from(new JohoTeikyoShiryoReportSource()).join(editor).buildSource();
    }
}
