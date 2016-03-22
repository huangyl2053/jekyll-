/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 年齢到達予定者一覧表Builderクラスです。
 */
class NenreitotatsuYoteishaIchiranhyoBuilderImpl implements INenreitotatsuYoteishaIchiranhyoBuilder {

    private final INenreitotatsuYoteishaIchiranhyoEditor headerEditor;
    private final INenreitotatsuYoteishaIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link INenreitotatsuYoteishaIchiranhyoEditor}
     * @param hyojiIchiranEditor {@link INenreitotatsuYoteishaIchiranhyoEditor}
     */
    public NenreitotatsuYoteishaIchiranhyoBuilderImpl(INenreitotatsuYoteishaIchiranhyoEditor headerEditor,
            INenreitotatsuYoteishaIchiranhyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NenreitotatsuYoteishaIchiranhyoReportSource}
     */
    @Override
    public NenreitotatsuYoteishaIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new NenreitotatsuYoteishaIchiranhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
