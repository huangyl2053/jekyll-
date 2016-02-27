/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 広域内住所地特例者一覧表Builderクラスです。
 */
class KoikinaiJushochitokureishaIchiranhyoBuilderImpl implements KoikinaiJushochitokureishaIchiranhyoBuilder {

    private final KoikinaiJushochitokureishaIchiranhyoEditor headerEditor;
    private final KoikinaiJushochitokureishaIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link KoikinaiJushochitokureishaIchiranhyoEditor}
     * @param bodyEditor {@link KoikinaiJushochitokureishaIchiranhyoEditor}
     */
    public KoikinaiJushochitokureishaIchiranhyoBuilderImpl(KoikinaiJushochitokureishaIchiranhyoEditor headerEditor, KoikinaiJushochitokureishaIchiranhyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KoikinaiJushochitokureishaIchiranhyoReportSource}
     */
    @Override
    public KoikinaiJushochitokureishaIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new KoikinaiJushochitokureishaIchiranhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
