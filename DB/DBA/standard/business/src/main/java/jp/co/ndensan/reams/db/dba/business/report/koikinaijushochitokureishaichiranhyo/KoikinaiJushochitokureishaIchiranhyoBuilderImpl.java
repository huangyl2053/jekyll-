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
 *
 * @reamsid_L DBU-1140-060 linghuhang
 */
class KoikinaiJushochitokureishaIchiranhyoBuilderImpl implements IKoikinaiJushochitokureishaIchiranhyoBuilder {

    private final IKoikinaiJushochitokureishaIchiranhyoEditor headerEditor;
    private final IKoikinaiJushochitokureishaIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKoikinaiJushochitokureishaIchiranhyoEditor}
     * @param bodyEditor {@link IKoikinaiJushochitokureishaIchiranhyoEditor}
     */
    public KoikinaiJushochitokureishaIchiranhyoBuilderImpl(
            IKoikinaiJushochitokureishaIchiranhyoEditor headerEditor,
            IKoikinaiJushochitokureishaIchiranhyoEditor bodyEditor) {
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
