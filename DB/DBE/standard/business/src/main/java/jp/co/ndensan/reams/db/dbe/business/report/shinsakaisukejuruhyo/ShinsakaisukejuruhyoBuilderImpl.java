/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会スケジュール表Builderクラスです。
 */
class ShinsakaisukejuruhyoBuilderImpl implements IShinsakaisukejuruhyoBuilder {

    private final ShinsakaisukejuruhyoHeaderEditor headerEditor;
    private final ShinsakaisukejuruhyoBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link ShinsakaisukejuruhyoHeaderEditor}
     * @param hyojiIchiranEditor {@link ShinsakaisukejuruhyoBodyEditor}
     */
    public ShinsakaisukejuruhyoBuilderImpl(ShinsakaisukejuruhyoHeaderEditor headerEditor, ShinsakaisukejuruhyoBodyEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsakaisukejuruhyoReportSource}
     */
    @Override
    public ShinsakaisukejuruhyoReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaisukejuruhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
