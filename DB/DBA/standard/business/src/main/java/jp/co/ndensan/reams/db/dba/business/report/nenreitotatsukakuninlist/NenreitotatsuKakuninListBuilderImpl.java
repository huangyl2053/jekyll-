/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist;

import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 年齢到達者登録リストBuilderクラスです
 */
class NenreitotatsuKakuninListBuilderImpl implements INenreitotatsuKakuninListBuilder {

    private final INenreitotatsuKakuninListEdiotr headerEditor;
    private final INenreitotatsuKakuninListEdiotr hyojiBodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link INenreitotatsuKakuninListEdiotr}
     * @param hyojiBodyEditor {@link INenreitotatsuKakuninListEdiotr}
     */
    public NenreitotatsuKakuninListBuilderImpl(INenreitotatsuKakuninListEdiotr headerEditor, INenreitotatsuKakuninListEdiotr hyojiBodyEditor) {
        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NenreitotatsuKakuninListReportSource}
     */

    @Override
    public NenreitotatsuKakuninListReportSource build() {
        return ReportEditorJoiner.from(new NenreitotatsuKakuninListReportSource()).join(headerEditor).join(hyojiBodyEditor).buildSource();
    }

}
